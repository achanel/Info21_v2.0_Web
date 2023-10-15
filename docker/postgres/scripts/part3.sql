-- ++1) Написать функцию, возвращающую таблицу TransferredPoints в более человекочитаемом виде

drop function if exists fnc_transferred_points();
create or replace function fnc_transferred_points()
    returns table
            (
                peer1        varchar,
                peer2        varchar,
                pointsamount bigint
            )
as
$$
begin
    return query
        select tp1.checkedpeer                                  as peer1,
               tp1.checkingpeer                                 as peer2,
               tp1.pointsamount - coalesce(tp2.pointsamount, 0) as pointsamount
        from transferredpoints tp1
                 left join
             transferredpoints tp2
             on
                         tp1.checkedpeer = tp2.checkingpeer
                     and tp1.checkingpeer = tp2.checkedpeer;
end;
$$
    language plpgsql;

-- select *
-- from fnc_transferred_points();

-- ++2) Написать функцию, которая возвращает таблицу вида: ник пользователя, название проверенного задания, кол-во полученного XP

drop function if exists fnc_successful_checks();
create or replace function fnc_successful_checks()
    returns table
            (
                Peer varchar,
                Task varchar,
                XP   integer
            )
as
$$
begin
    return query (select c.peer, c.task, x.xpamount
                  from checks c
                           inner join xp x on c.id = x."check"
                           inner join p2p p on c.id = p."check"
                  where p.state = 'Success');
end;
$$ language plpgsql;

-- select *
-- from fnc_successful_checks();

-- ++3) Написать функцию, определяющую пиров, которые не выходили из кампуса в течение всего дня

drop function if exists fnc_all_day_in_campus();
create or replace function fnc_all_day_in_campus(in day date)
    returns setof varchar as
$$
begin
    return query ((select peer
                   from timetracking
                   where state = 1
                     and "date" = day)
                  except
                  (select peer
                   from timetracking
                   where state = 2
                     and "date" = day));
end;
$$ language plpgsql;

-- select *
-- from fnc_all_day_in_campus('2020-01-02');

-- ++4) Найти процент успешных и неуспешных проверок за всё время
create or replace function fnc_checks_percent()
    returns table
            (
                successfulchecks   real,
                unsuccessfulchecks real
            )
as
$$
begin
    return query (with tmp as (select p2p.state as p2p, verter.state as verter
                               from p2p
                                        join checks on p2p."check" = checks.id
                                        left join verter on verter."check" = checks.id
                               where p2p.state in ('Success', 'Failure')
                                 and (verter.state in ('Success', 'Failure') or verter.state is null)),
                       success as (select round(((select count(*)
                                                  from tmp
                                                  where p2p = 'Success'
                                                    and (verter = 'Success' or verter is null))::real * 100) /
                                                (select count(*) from tmp))::real as a),
                       fail as (select round(((select count(*)
                                               from tmp
                                               where p2p = 'Failure'
                                                  or verter = 'Failure')::real * 100) /
                                             (select count(*) from tmp))::real as b)
                  select a, b
                  from success
                           cross join fail);
end;
$$ language plpgsql;

-- select *
-- from fnc_checks_percent();

-- ++5) Посчитать изменение в количестве пир поинтов каждого пира по таблице TransferredPoints
drop function if exists fnc_peer_points_changes cascade;
create function fnc_peer_points_changes()
    returns table
            (
                peer         character varying,
                pointschange numeric
            )
as
$$
begin
    return query (select checkingpeer      as peer,
                         sum(pointsamount) as points
                  from (select checkingpeer, sum(pointsamount) as pointsamount
                        from transferredpoints
                        group by checkingpeer
                        union all
                        select checkedpeer, sum(-pointsamount) as pointsamount
                        from transferredpoints
                        group by checkedpeer) as change
                  group by checkingpeer
                  order by points desc);
end ;
$$
    language plpgsql;

-- select *
-- from fnc_peer_points_changes();

-- ++6) Посчитать изменение в количестве пир поинтов каждого пира по таблице, возвращаемой первой функцией из Part 3
drop function if exists fnc_peer_points_changes_2 cascade;
create or replace function fnc_peer_points_changes_2()
    returns table
            (
                peer         varchar,
                pointsChange numeric
            )
as
$$
begin
    return query (
        select "peer1"           as Peer,
               sum(pointsamount) as pointsChange
        from (select "peer1",
                     sum("pointsamount") as pointsamount
              from fnc_transferred_points()
              group by "peer1"
              union all
              select "peer2",
                     sum(-"pointsamount") as pointsamount
              from fnc_transferred_points()
              group by "peer2") as pointsChange
        group by peer
        order by pointsChange desc);
end;
$$
    language plpgsql;

select *
from fnc_peer_points_changes_2();

-- ++7) Определить самое часто проверяемое задание за каждый день
drop function if exists fnc_most_reviewed_task cascade;
create or replace function fnc_most_reviewed_task()
    returns table
            (
                CDate date,
                Task  varchar
            )
as
$$
begin
    return query (with t1 as (select checks.task, checks.date, COUNT(*) as counts
                              from checks
                              group by checks.task, date),
                       t2 as (select t1.task, t1.date, rank() over (partition by t1.date order by t1.counts) as rank
                              from t1)
                  select t2.date, t2.task
                  from t2
                  where rank = 1);
end ;
$$ language plpgsql;

-- select *
-- from fnc_most_reviewed_task();

-- ++8) Определить длительность последней P2P проверки
drop function if exists fnc_last_check_duration cascade;
create or replace function fnc_last_check_duration()
    returns table
            (
                Times time
            )
as
$$
begin
    return query (with last_check as (select "check" as check_id
                                      from p2p
                                      where id = (select max(id)
                                                  from p2p
                                                  where state = 'Start'))
                  select (max(time) - min(time))::time as times
                  from last_check lc
                           inner join p2p on lc.check_id = p2p."check");
end;
$$ language plpgsql;

-- select *
-- from fnc_last_check_duration();

-- ++9) Найти всех пиров, выполнивших весь заданный блок задач и дату завершения последнего задания
drop function if exists fnc_task_block cascade;
create or replace function fnc_task_block(in block varchar)
    returns table
            (
                Peer  varchar,
                CDate date
            )
as
$$
begin
    return query (with tasks_block as (select *
                                       from tasks
                                       where title similar to concat(block, '[0-9]%')),
                       last_task as (select max(title) as title from tasks_block),
                       date_of_successful_check as (select checks.peer, checks.task, checks.date
                                                    from checks
                                                             join p2p on checks.id = p2p."check"
                                                    where p2p.state = 'Success'
                                                    group by checks.id)
                  select date_of_successful_check.peer as Peer, date_of_successful_check.date
                  from date_of_successful_check
                           join last_task on date_of_successful_check.task = last_task.title);
end;
$$ language plpgsql;

-- select *
-- from fnc_task_block('C');

-- ++10) Определить, к какому пиру стоит идти на проверку каждому обучающемуся
drop function if exists fnc_recommended_peer cascade;
create or replace function fnc_recommended_peer()
    returns table
            (
                Peer             varchar,
                Recommended_peer varchar
            )
as
$$
begin
    return query (with list_of_recommendation as (select peer1, recommendedpeer, count(r.peer) as count
                                                  from friends f
                                                           inner join recommendations r on f.peer2 = r.peer
                                                  where peer1 <> r.recommendedpeer
                                                  group by peer1, recommendedpeer
                                                  order by 1, count desc, 2),
                       table_of_max_count_recommendation as (select peer1, max(count) as max_count
                                                             from list_of_recommendation
                                                             group by peer1)

                  select mcr.peer1 as Peer, recommendedpeer as RecommendedPeer
                  from table_of_max_count_recommendation mcr
                           inner join list_of_recommendation lor on lor.count = mcr.max_count and
                                                                    lor.peer1 = mcr.peer1
                  order by Peer);
end;
$$ language plpgsql;

-- select *
-- from fnc_recommended_peer();

-- ++11) Определить процент пиров, которые:
-- - Приступили только к блоку 1
-- - Приступили только к блоку 2
-- - Приступили к обоим
-- - Не приступили ни к одному
drop function if exists fnc_blocks_comparing cascade;
create or replace function fnc_blocks_comparing(block_name_1 varchar, block_name_2 varchar)
    returns table
            (
                first_block  bigint,
                second_block bigint,
                both_blocks  bigint,
                didnt_start  bigint
            )
as
$$
begin
    return query (with first_block as (select distinct peer
                                       from checks
                                       where task like block_name_1),
                       second_block as (select distinct peer
                                        from checks
                                        where task like block_name_2),
                       both_blocks as (select distinct peer
                                       from first_block
                                       intersect
                                       select distinct peer
                                       from second_block),
                       didnt_start as (select nickname as peer
                                       from peers
                                       except
                                       (select distinct peer
                                        from first_block
                                        union
                                        select distinct peer
                                        from second_block))
                  select (select count(peer) from first_block) * 100 / count(nickname)  as StartedBlock1,
                         (select count(peer) from second_block) * 100 / count(nickname) as StartedBlock2,
                         (select count(peer) from both_blocks) * 100 / count(nickname)  as StartedBothBlocks,
                         (select count(peer) from didnt_start) * 100 / count(nickname)  as DidntStartAnyBlock
                  from peers);
end;
$$ language plpgsql;

-- select *
-- from fnc_blocks_comparing('C', 'C');

-- ++12) Определить N пиров с наибольшим числом друзей
drop function if exists fnc_max_friends_peer cascade;
create or replace function fnc_max_friends_peer(in limits int)
    returns table
            (
                Nick_name    varchar,
                FriendsCount bigint
            )
as
$$
begin
    return query (with find_friends as (select peers.nickname,
                                               (case when peers.nickname = f.peer1 then peer2 else peer1 end) as friends
                                        from peers
                                                 join friends f on peers.nickname = f.peer1 or peers.nickname = f.peer2)
                  select nickname, count(friends) as FriendsCount
                  from find_friends
                  group by nickname
                  order by FriendsCount desc
                  limit limits);

end;
$$ language plpgsql;

-- select *
-- from fnc_max_friends_peer(2);

-- ++13) Определить процент пиров, которые когда-либо успешно проходили проверку в свой день рождения
drop function if exists fnc_birthday_check cascade;
create or replace function fnc_birthday_check()
    returns table
            (
                SuccessfulChecks   double precision,
                UnsuccessfulChecks double precision
            )
as
$$
begin
    return query (with succ_and_fail_stat as (select count(peer)
                                                     filter (where p2p.state = 'Success' and v.state <> 'Failure') as success,
                                                     count(peer) filter (where
                                                             (p2p.state = 'Success' and v.state = 'Failure') or
                                                             (p2p.state = 'Failure'))                              as fail
                                              from checks c
                                                       inner join verter v on c.id = v."check"
                                                       inner join p2p on c.id = p2p."check"
                                                       inner join peers p on p.nickname = c.peer
                                              where extract(month from c.date) = extract(month from p.birthday)
                                                and extract(day from c.date) = extract(day from p.birthday))
                  select round(100 * success / (success + fail)) as SuccessfulChecks,
                         round(100 * fail / (success + fail))    as UnsuccessfulChecks
                  from succ_and_fail_stat);
end;
$$ language plpgsql;

-- select *
-- from fnc_birthday_check();

-- ++14) Определить кол-во XP, полученное в сумме каждым пиром
drop function if exists fnc_total_xp cascade;
create or replace function fnc_total_xp()
    returns table
            (
                Peer varchar,
                Xp   bigint
            )
as
$$
begin
    return query (with max_xp as (select c.peer, max(x.xpamount) as max_xp
                                  from checks c
                                           join xp x on c.id = x."check"
                                  group by c.peer, task)
                  select m.peer as Peer, sum(max_xp) as xp
                  from max_xp m
                  group by m.peer
                  order by xp desc);
end;
$$ language plpgsql;

-- select *
-- from fnc_total_xp();

-- ++15) Определить всех пиров, которые сдали заданные задания 1 и 2, но не сдали задание 3
drop function if exists fnc_completed_task cascade;
create or replace function fnc_completed_task(in first_task text, in second_task text,
                                              in third_task text)
    returns table
            (
                CheckedPeer varchar
            )
as
$$
begin
    return query (with success as (select "check", Peer as CheckedPeer, Task
                                   from p2p
                                            inner join checks c on c.id = p2p."check"
                                   where state = 'Success'
                                   except all
                                   (select "check", Peer as CheckedPeer, Task
                                    from verter
                                             inner join checks c on c.id = verter."check"
                                    where state = 'Failure'
                                    union all
                                    select "check", Peer as CheckedPeer, Task
                                    from p2p
                                             inner join checks c on c.id = p2p."check"
                                    where state = 'Failure'))
                  select distinct s1.CheckedPeer
                  from success s1
                           full join success s2 on s2.CheckedPeer = s1.CheckedPeer
                           full join success s3 on s3.CheckedPeer = s1.CheckedPeer
                  where s1.task = first_task
                    and s2.task = second_task
                    and s3.task <> third_task);
end;
$$ language plpgsql;

-- select *
-- from fnc_completed_task('SQL1_Bootcamp', 'SQL2_Info21 v1.0', 'SQL3_RetailAnalitycs v1.0');

-- ++16) Используя рекурсивное обобщенное табличное выражение, для каждой задачи вывести кол-во предшествующих ей задач
create or replace function fnc_count(in pre_tasks text) returns integer as
$$
with recursive count_tasks as (select title, parenttask, 0 as count
                               from tasks
                               where title = pre_tasks
                               union
                               select tasks.title, tasks.parenttask, count_tasks.count + 1
                               from tasks
                                        join count_tasks on tasks.title = count_tasks.parenttask)

select max(count)
from count_tasks
$$ language sql;
drop function if exists fnc_pre_task cascade;
create or replace function fnc_pre_task()
    returns table
            (
                Task      varchar,
                PrevCount integer
            )
as
$$
begin
    return query (select tasks.title as task, fnc_count(tasks.title) as PrevCount
                  from tasks
                  order by PrevCount);
end;
$$ language plpgsql;

-- select *
-- from fnc_pre_task();

-- ++17) Найти "удачные" для проверок дни. День считается "удачным", если в нем есть хотя бы N идущих подряд успешных проверки
drop function if exists fnc_lucky_day cascade;
create or replace function fnc_lucky_day(in n int)
    returns table
            (
                CDate date
            )
as
$$
begin
    return query (with t as (select *
                             from checks
                                      join p2p p on checks.id = p."check"
                                      left join verter v on checks.id = v."check"
                                      join tasks t2 on checks.task = t2.title
                                      join xp x on checks.id = x."check"
                             where p.state = 'Success'
                               and v.state = 'Success')
                  select date
                  from t
                  where t.xpamount >= t.maxxp * 0.8
                  group by date
                  having count(date) >= n);
end;
$$ language plpgsql;

-- select *
-- from fnc_lucky_day(1);

-- ++18) Определить пира с наибольшим числом выполненных заданий
drop function if exists fnc_max_tasks cascade;
create or replace function fnc_max_tasks()
    returns table
            (
                Peer      varchar,
                Completed bigint
            )
as
$$
begin
    return query (select checks.peer, count(checks.task) as completed
                  from checks
                  group by checks.peer
                  order by 2 desc
                  limit 1);
end;
$$ language plpgsql;

-- select *
-- from fnc_max_tasks();

-- ++19) Определить пира с наибольшим количеством XP
drop function if exists fnc_top_peer cascade;
create or replace function fnc_top_peer()
    returns table
            (
                Peer varchar,
                Xp   bigint
            )
as
$$
begin
    return query (select c.peer, sum(xpamount) as xp
                  from xp
                           join checks c on c.id = xp."check"
                  group by c.peer
                  order by xp desc
                  limit 1);
end;
$$ language plpgsql;

-- select *
-- from fnc_top_peer();

-- ++20) Определить пира, который провел сегодня в кампусе больше всего времени
drop function if exists fnc_max_time_in_campus cascade;
create or replace function fnc_max_time_in_campus()
    returns table
            (
                Peers varchar
            )
as
$$
begin
    return query (with t1 as (select id, peer, "time"
                              from timetracking
                              where state = 1
                                and "date" = now()::date),
                       t2 as (select id, peer, "time"
                              from timetracking
                              where state = 2
                                and "date" = now()::date),
                       t12 as (select distinct on (t1.id) t1.id     as id_1,
                                                          t1.peer   as peer_1,
                                                          t1."time" as time_1,
                                                          t2.id     as id_2,
                                                          t2.peer   as peer_2,
                                                          t2."time" as time_2
                               from t1
                                        inner join t2 on t1.peer = t2.peer and t1."time" < t2."time")

                  select peer_1 as peer
                  from t12
                  group by 1
                  having (sum(time_2 - time_1)::time) = (select (sum(time_2 - time_1)::time) as t3
                                                         from t12
                                                         group by peer_1
                                                         order by 1 desc
                                                         limit 1));
end;
$$ language plpgsql;

-- select *
-- from fnc_max_time_in_campus();

-- ++21) Определить пиров, приходивших раньше заданного времени не менее N раз за всё время
drop function if exists fnc_coming_early cascade;
create or replace function fnc_coming_early(in "check_time" time, in n int)
    returns table
            (
                Peer varchar
            )
as
$$
begin
    return query (select t.early_peer
                  from (select timetracking.peer as early_peer, min("time") as min_time
                        from timetracking
                        where state = 1
                        group by "date", early_peer) as t
                  where min_time < "check_time"
                  group by t.early_peer
                  having count(t.early_peer) >= n);
end;
$$ language plpgsql;

-- select *
-- from fnc_coming_early('23:00:00', 1);

-- ++22) Определить пиров, выходивших за последние N дней из кампуса больше M раз
drop function if exists fnc_out_of_campus cascade;
create or replace function fnc_out_of_campus(in n int, in m int)
    returns table
            (
                Peer varchar
            )
as
$$
begin

    return query (select t.peer
                  from (select timetracking.peer, timetracking."date", (count(*) - 1) as counts
                        from timetracking
                        where state = 2
                          and "date" > (current_date - n)
                        group by timetracking.peer, "date") as t
                  group by t.peer
                  having sum(counts) > m);
end;
$$ language plpgsql;

-- select *
-- from fnc_out_of_campus(0, 0);

-- ++23) Определить пира, который пришел сегодня последним
drop function if exists fnc_last_peer cascade;
create or replace function fnc_last_peer()
    returns table
            (
                Peers varchar
            )
as
$$
begin
    return query (select peer
                  from timetracking
                  where state = 1
                    and "date" = current_date
                  order by "time" desc
                  limit 1);
end;
$$ language plpgsql;

-- select *
-- from fnc_last_peer();

-- ++24) Определить пиров, которые выходили вчера из кампуса больше чем на N минут
drop function if exists fnc_time_out_of_campus cascade;
create or replace function fnc_time_out_of_campus(in N int)
    returns table
            (
                Peers varchar
            )
as
$$
begin
    return query (with find_first_input as (select timetracking.peer, "date", min("time") as min_t
                                            from timetracking
                                            where state = 1
                                              and "date" = (current_date - 1)
                                            group by peer, "date"),
                       last as (select timetracking.peer, "date", MAX("time") as max_t
                                from timetracking
                                where state = 2
                                  and "date" = (current_date - 1)
                                group by peer, "date"),
                       ins as (select t.peer as peer, t."time" as time
                               from timetracking as t
                                        join find_first_input as ff on t.peer = ff.peer
                                   and t."time" != ff.min_t and t.state = 1
                               where t."date" = (current_date - 1)),
                       outs as (select t.peer as peer, t."time" as time
                                from timetracking as t
                                         join last as fl on t.peer = fl.peer
                                    and t."time" != fl.max_t and t.state = 2
                                where t."date" = (current_date - 1))
                  select ins.peer as peer
                  from ins
                           join outs ON ins.peer = outs.peer
                  where (outs.time + (select make_interval(mins => N))) > ins.time);
end;
$$ language plpgsql;

-- select *
-- from fnc_time_out_of_campus('90');

-- ++25) Определить для каждого месяца процент ранних входов
drop function if exists fnc_count_of_visits cascade;
create or replace function fnc_count_of_visits(in ppeer text, in ttime time) returns integer as
$$
select count(*)
from (select peer
      from timetracking
      where peer = ppeer
        and timetracking."time" < ttime
        and state = '1') jojo
$$
    language sql;

drop function if exists fnc_early_coming cascade;
create or replace function fnc_early_coming()
    returns table
            (
                "Month"      text,
                EarlyEntries bigint
            )
as
$$
begin
    return query (with months as (select months::date
                                  from generate_series('2022-01-01', '2022-12-01', interval '1 month') as months),
                       visits as (select to_char(months::date, 'Month')                         as month,
                                         sum(fnc_count_of_visits(p.nickname::text, '24:00:00')) as visits,
                                         sum(fnc_count_of_visits(p.nickname::text, '12:00:00')) as early_visits
                                  from months
                                           full join peers p
                                                     on extract(month from months) = extract(month from p.birthday::date)
                                  group by 1)
                  select month, case when visits = 0 then 0 else early_visits * 100 / visits end as EarlyEntries
                  from visits);
end;
$$ language plpgsql;

-- select *
-- from fnc_early_coming();