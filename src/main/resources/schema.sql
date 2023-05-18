-- Удаление таблиц, если они существуют
drop table if exists Peers cascade;
drop table if exists Tasks cascade;
drop type if exists check_state cascade;
drop table if exists Checks cascade;
drop table if exists P2P cascade;
drop table if exists Verter cascade;
drop table if exists TransferredPoints cascade;
drop table if exists Friends cascade;
drop table if exists Recommendations cascade;
drop table if exists XP cascade;
drop table if exists TimeTracking cascade;

-- Создание всех заданных таблиц
create table Peers (
                       Nickname    varchar not null primary key,
                       Birthday    date not null
);

create table Tasks (
                       Title       varchar not null primary key,
                       ParentTask   varchar,
                       MaxXP       integer not null,
                       foreign key ( ParentTask ) references Tasks ( Title )
);

create table Checks (
                        ID      integer primary key not null,
                        Peer    varchar not null,
                        Task    varchar not null,
                        Date    date not null,
                        foreign key ( Peer ) references Peers ( Nickname ),
                        foreign key ( Task ) references Tasks ( Title )
);

create type check_state as enum ( 'Start', 'Success', 'Failure' );

create  table P2P (
                      ID              integer primary key not null,
                      "Check"         integer not null,
                      CheckingPeer    varchar not null,
                      State           check_state not null,
                      Time            time not null,
                      foreign key ( "Check" ) references Checks ( ID ),
                      foreign key ( CheckingPeer ) references Peers ( Nickname )
);

create table Verter (
                        ID      integer primary key not null,
                        "Check" integer not null,
                        State   check_state not null,
                        Time    time not null,
                        foreign key ( "Check" ) references Checks ( ID )
);

create table TransferredPoints (
                                   ID              integer primary key not null,
                                   CheckingPeer    varchar not null,
                                   CheckedPeer     varchar not null,
                                   PointsAmount    bigint not null,
                                   foreign key ( CheckingPeer ) references Peers ( Nickname ),
                                   foreign key ( CheckedPeer ) references Peers ( Nickname )
);

create table Friends (
                         ID      integer primary key not null,
                         Peer1   varchar not null,
                         Peer2   varchar not null,
                         foreign key ( Peer1 ) references Peers ( Nickname ),
                         foreign key ( Peer2 ) references Peers ( Nickname )
);

create table Recommendations (
                                 ID              integer primary key not null,
                                 Peer            varchar not null,
                                 RecommendedPeer varchar not null,
                                 foreign key ( Peer ) references Peers ( Nickname ),
                                 foreign key ( RecommendedPeer ) references Peers ( Nickname )
);

create table XP (
                    ID          integer primary key not null,
                    "Check"     integer not null,
                    XPAmount    integer not null,
                    foreign key ( "Check" ) references Checks ( ID )
);

create table TimeTracking (
                              ID  integer primary key not null,
                              Peer    varchar not null,
                              "Date"  date not null,
                              "Time"  time not null,
                              State   int2 not null check ( State in ( 1, 2 ) ),
                              foreign key ( Peer ) references Peers ( Nickname )
);

-- Процедуры экспорта и импорта их .csv файла
-- drop procedure if exists export() cascade;
--
-- create or replace procedure export(IN tablename varchar, IN path text, IN separator char) as $$
--     begin
--             execute format('copy %s to ''%s'' delimiter ''%s'' csv header;',
--                            tablename, path, separator);
--     end;
-- $$ language plpgsql;
--
-- drop procedure if exists import() cascade;
--
-- create or replace procedure import(IN tablename varchar, IN path text, IN separator char) as $$
-- begin
--     execute format('copy %s from ''%s'' delimiter ''%s'' csv header;',
--                    tablename, path, separator);
-- end;
-- $$ language plpgsql;

-- -- Тестирование работы процедур
-- -- Запись таблиц в файлы
-- CALL export('Peers', '/tmp/peers.csv', ',');
-- CALL export('Tasks', '/tmp/tasks.csv', ',');
-- CALL export('Checks', '/tmp/checks.csv', ',');
-- CALL export('P2P', '/tmp/p2p.csv', ',');
-- CALL export('verter', '/tmp/verter.csv', ',');
-- CALL export('transferredpoints', '/tmp/transferredpoints.csv', ',');
-- CALL export('friends', '/tmp/friends.csv', ',');
-- CALL export('recommendations', '/tmp/recommendations.csv', ',');
-- CALL export('xp', '/tmp/xp.csv', ',');
-- CALL export('timetracking', '/tmp/timetracking.csv', ',');
--
-- -- Удвление запись из таблиц
-- TRUNCATE TABLE Peers CASCADE;
-- TRUNCATE TABLE Tasks CASCADE;
-- TRUNCATE TABLE Checks CASCADE;
-- TRUNCATE TABLE P2P CASCADE;
-- TRUNCATE TABLE Verter CASCADE;
-- TRUNCATE TABLE Transferredpoints CASCADE;
-- TRUNCATE TABLE Friends CASCADE;
-- TRUNCATE TABLE Recommendations CASCADE;
-- TRUNCATE TABLE XP CASCADE;
-- TRUNCATE TABLE TimeTracking CASCADE;
--
-- -- Заполнение таблиц данными из файлов
-- CALL import('Peers', '/tmp/peers.csv', ',');
-- CALL import('Tasks', '/tmp/tasks.csv', ',');
-- CALL import('Checks', '/tmp/checks.csv', ',');
-- CALL import('P2P', '/tmp/p2p.csv', ',');
-- CALL import('verter', '/tmp/verter.csv', ',');
-- CALL import('transferredpoints', '/tmp/transferredpoints.csv', ',');
-- CALL import('friends', '/tmp/friends.csv', ',');
-- CALL import('recommendations', '/tmp/recommendations.csv', ',');
-- CALL import('xp', '/tmp/xp.csv', ',');
-- CALL import('timetracking', '/tmp/timetracking.csv', ',');
