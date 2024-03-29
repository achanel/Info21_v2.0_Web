-- +1) Написать процедуру добавления P2P проверки

drop procedure if exists add_p2p_review cascade;

create or replace procedure add_p2p_review(in checked_peer varchar,
                                           in checking_peer varchar,
                                           in task_title varchar,
                                           in checkstate check_state,
                                           in check_time time) as
$$
begin
    if checkstate = 'Start' then
        insert into checks
        values ((select max(id) + 1 from checks), checked_peer, task_title,
                now());
        insert into p2p
        values ((select max(id) + 1 from p2p),
                (select max(id) from checks),
                checking_peer,
                checkstate, check_time);
    else
        insert into p2p
        values ((select max(id) + 1 from p2p),
                (select "check"
                 from p2p
                 where checkingpeer = add_p2p_review.checking_peer
                   and state = 'Start'
                 order by time desc
                 limit 1),
                checking_peer,
                checkstate, check_time);
    end if;
end;
$$ language plpgsql;


-- call add_p2p_review('mmonarch', 'wsei', 'CPP2_s21_containers', 'Start'::check_state, '11:12:13');
-- ERROR: UNFINISHED CHECK
-- call add_p2p_review('mmonarch', 'rhoke', 'DO2_Linux Network', 'Start'::check_state, '11:12:13');
-- call add_p2p_review('mmonarch', 'rhoke', 'DO2_Linux Network', 'Success'::check_state, '11:22:13');
-- call add_p2p_review('wsei', 'ikathrin', 'A1_Maze', 'Start'::check_state, '12:12:13');
-- call add_p2p_review('wsei', 'ikathrin', 'A1_Maze', 'Failure'::check_state, '12:22:13');
-- delete from p2p where id = 19;
-- delete from p2p where id = 18;
-- delete from p2p where id = 17;
-- delete from p2p where id = 16;

-- +2) Написать процедуру добавления проверки Verter'ом

drop procedure if exists add_verter_review cascade;

create or replace procedure add_verter_review(in checkedPeer varchar, in task_name text,
                                              in verter_status check_state, IN check_time time)
as
$$
begin
    if (verter_status = 'Start') then
        if ((select max(p2p.time)
             from p2p
                      join checks c on p2p."check" = c.id
             where c.peer = checkedPeer
               and c.task = task_name
               and p2p.state = 'Success') is not null) then
            insert into verter
            values ((select max(id) from verter) + 1,
                    (select distinct c2.id
                     from p2p
                              join checks c2 on p2p."check" = c2.id
                     where c2.peer = checkedPeer
                       and c2.task = task_name
                       and p2p.state = 'Success'),
                    verter_status,
                    check_time);
        else
            raise exception 'P2P STATE MUST BE SUCCESS';
        end if;
    else
        insert into verter
        values ((select max(id) from verter) + 1,
                (select "check"
                 from verter
                 group by "check"
                 having count(*) % 2 = 1),
                verter_status,
                check_time);
    end if;
end;
$$ language plpgsql;

-- call add_verter_review('fbeatris', 'CPP9_MonitoringSystem', 'Start', '12:00:00');
-- call add_verter_review('mmonarch', 'CPP2_s21_containers', 'Start', '12:00:00');
-- -- ERROR: P2P STATE MUST BE SUCCESS
-- call add_verter_review('fbeatris', 'CPP9_MonitoringSystem', 'Start', '12:00:00');
-- call add_verter_review('fbeatris', 'CPP9_MonitoringSystem', 'Failure', '12:00:00');
-- delete from verter where id = 13;
-- delete from verter where id = 14;

-- 3) Написать триггер: после добавления записи со статутом "начало" в таблицу P2P, изменить соответствующую запись в таблице TransferredPoints

drop function if exists fnc_trg_update_transferredpoints() cascade;

create or replace function fnc_trg_update_transferredpoints()
    returns trigger as
$$
declare
    checked_peer text;
begin
    checked_peer := (select peer from checks where id = new."check");
    if (TG_OP = 'INSERT') then
        if exists(select *
                  from transferredpoints
                  where checkingpeer = new.checkingpeer
                    and checkedpeer = checked_peer) then
            update transferredpoints
            set pointsamount = pointsamount + 1
            where checkingpeer = NEW.checkingpeer
              and checked_peer = (select peer
                                  from p2p
                                           inner join checks c on c.id = p2p."check"
                                      and "check" = NEW."check"
                                      and state = 'Start'
                                  group by peer);
        else
            insert into transferredpoints
            values ((select max(id) + 1 from transferredpoints),
                    new.checkingpeer,
                    checked_peer, 1);
        end if;
        return NEW;
    end if;
end;
$$ language plpgsql;

create or replace trigger trg_transferredPoints
    after insert
    on p2p
    for each row
execute procedure fnc_trg_update_transferredpoints();

-- insert into p2p
-- values (16, 9, 'bgenia', 'Start', '14:00:00');
-- call add_p2p_review('bgenia', 'mmonarch', 'C6_s21_matrix', 'Start', '14:00:00');
-- delete from p2p where id = 16;
-- delete from p2p where id = 17;

-- 4) Написать триггер: перед добавлением записи в таблицу XP, проверить корректность добавляемой записи

drop function if exists fnc_trg_XP() cascade;

create or replace function fnc_trg_XP() returns trigger as
$$
begin
    if new.xpamount <= (select maxxp
                        from xp
                                 inner join checks c on c.id = xp."check"
                                 inner join tasks t on t.title = c.task
                        group by maxxp)
        and new."check" in (select "check"
                            from verter
                            where state = 'Success') then
        return new;
    end if;
    return null;
end;
$$ language plpgsql;

create or replace trigger trg_XP
    before insert
    on xp
    for each row
execute procedure fnc_trg_XP();

-- insert into xp
-- values (6, 6, 1000);