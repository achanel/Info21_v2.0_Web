-- Заполнение таблиц данными
insert into Peers ( Nickname, Birthday )
values ( 'achanel', '1992-02-02' ),
       ( 'mmonarch', '1991-10-20' ),
       ( 'rhoke', '1993-01-13' ),
       ( 'fbeatris', '1994-09-28' ),
       ( 'ikathrin', '1997-03-14' ),
       ( 'ikael', '1998-01-07' ),
       ( 'wsei', '1997-08-23' ),
       ( 'bgenia', '1996-06-09' );

insert into Tasks ( Title, ParentTask, MaxXP )
values ( 'C2_SimpleBashUtils', NULL, 250 ),
       ( 'C3_s21_string+', 'C2_SimpleBashUtils', 500 ),
       ( 'C4_s21_math', 'C2_SimpleBashUtils', 300 ),
       ( 'C5_s21_decimal', 'C4_s21_math', 350 ),
       ( 'C6_s21_matrix', 'C5_s21_decimal', 200 ),
       ( 'C7_SmartCalc_v1.0', 'C6_s21_matrix', 500 ),
       ( 'C8_3DViewer_v1.0', 'C7_SmartCalc_v1.0', 750 ),
       ( 'DO1_Linux', 'C3_s21_string+', 300 ),
       ( 'DO2_Linux Network', 'DO1_Linux', 250 ),
       ( 'DO3_LinuxMonitoring v1.0', 'DO2_Linux Network', 350 ),
       ( 'DO4_LinuxMonitoring v2.0', 'DO3_LinuxMonitoring v1.0', 350 ),
       ( 'DO5_SimpleDocker', 'DO3_LinuxMonitoring v1.0', 300 ),
       ( 'DO6_CICD', 'DO5_SimpleDocker', 300 ),
       ( 'CPP1_s21_matrix+', 'C8_3DViewer_v1.0', 300 ),
       ( 'CPP2_s21_containers', 'CPP1_s21_matrix+', 350 ),
       ( 'CPP3_SmartCalc_v2.0', 'CPP2_s21_containers', 600 ),
       ( 'CPP4_3DViewer_v2.0', 'CPP3_SmartCalc_v2.0', 750 ),
       ( 'CPP5_3DViewer_v2.1', 'CPP4_3DViewer_v2.0', 600 ),
       ( 'CPP6_3DViewer_v2.2', 'CPP4_3DViewer_v2.0', 800 ),
       ( 'CPP7_MLP', 'CPP4_3DViewer_v2.0', 700 ),
       ( 'CPP8_PhotoLab_v1.0', 'CPP4_3DViewer_v2.0', 450 ),
       ( 'CPP9_MonitoringSystem', 'CPP4_3DViewer_v2.0', 1000 ),
       ( 'A1_Maze', 'CPP4_3DViewer_v2.0', 300 ),
       ( 'A2_SimpleNavigator v1.0', 'A1_Maze', 400 ),
       ( 'A3_Parallels', 'A2_SimpleNavigator v1.0', 300 ),
       ( 'A4_Crypto', 'A2_SimpleNavigator v1.0', 350 ),
       ( 'A5_s21_memory', 'A2_SimpleNavigator v1.0', 400 ),
       ( 'A6_Transactions', 'A2_SimpleNavigator v1.0', 700 ),
       ( 'A7_DNA Analyzer', 'A2_SimpleNavigator v1.0', 800 ),
       ( 'A8_Algorithmic trading', 'A2_SimpleNavigator v1.0', 800 ),
       ( 'SQL1_Bootcamp', 'C8_3DViewer_v1.0', 1500 ),
       ( 'SQL2_Info21 v1.0', 'SQL1_Bootcamp', 500 ),
       ( 'SQL3_RetailAnalitycs v1.0', 'SQL2_Info21 v1.0', 600 );

insert into Checks ( ID, Peer, Task, Date )
values ( 1, 'bgenia', 'SQL1_Bootcamp', '2023-06-09' ),
       ( 2, 'rhoke', 'A6_Transactions', '2022-12-14' ),
       ( 3, 'wsei', 'A3_Parallels', '2023-01-06' ),
       ( 4, 'fbeatris', 'CPP9_MonitoringSystem', '2023-02-26' ),
       ( 5, 'ikathrin', 'CPP6_3DViewer_v2.2', '2023-01-20' ),
       ( 6, 'mmonarch', 'CPP2_s21_containers', '2022-06-30' ),
       ( 7, 'achanel', 'DO1_Linux', '2022-05-09' ),
       ( 8, 'rhoke', 'A7_DNA Analyzer', '2022-11-09' ),
       ( 9, 'achanel', 'DO2_Linux Network', '2022-11-30' );

insert into P2P ( ID, "check", checking_peer, State, Time )
values ( 1, 1, 'achanel', 0, '18:30:21' ),
       ( 2, 1, 'achanel', 1, '19:01:12' ),

       ( 3, 2, 'mmonarch', 0, '13:02:01' ),
       ( 4, 2, 'mmonarch', 1, '13:10:01' ),

       ( 5, 3, 'ikathrin', 0, '09:11:45' ),
       ( 6, 3, 'ikathrin', 2, '11:06:23' ),

       ( 7, 4, 'rhoke', 0, '19:10:45' ),
       ( 8, 4, 'rhoke', 1, '20:06:23' ),

       ( 9, 5, 'ikael', 0, '20:11:45' ),
       ( 10, 5, 'ikael', 1, '20:15:23' ),

       ( 11, 6, 'wsei', 0, '00:00:00' ),

       ( 12, 7, 'bgenia', 0, '11:11:45' ),
       ( 13, 7, 'bgenia', 1, '11:15:23' ),

       ( 14, 8, 'achanel', 0, '10:51:45' ),
       ( 15, 8, 'achanel', 1, '11:15:13' );

insert into Verter ( ID, "check", State, Time )
values ( 1, 1, 0, '19:21:12' ),
       ( 2, 1, 1, '19:51:12' ),

       ( 3, 2, 0, '13:30:01' ),
       ( 4, 2, 1, '14:00:01' ),

       ( 5, 4, 0, '20:26:23' ),
       ( 6, 4, 1, '20:56:23' ),

       ( 7, 5, 0, '19:21:12' ),
       ( 8, 5, 1, '19:51:12' ),

       ( 9, 7, 0, '11:35:23' ),
       ( 10, 7, 2, '12:05:23' ),

       ( 11, 8, 0, '11:35:13' ),
       ( 12, 8, 1, '12:05:13' );

insert into transferred_points ( ID, checking_peer, checked_peer, points_amount )
values ( 1, 'achanel', 'bgenia', 1),
       ( 2, 'mmonarch', 'rhoke', 1),
       ( 3, 'ikathrin', 'wsei', 1),
       ( 4, 'rhoke', 'fbeatris', 1),
       ( 5, 'ikael', 'ikathrin', 1),
       ( 6, 'bgenia', 'achanel', 1),
       ( 7, 'achanel', 'rhoke', 1);

insert into Friends ( ID, Peer1, Peer2 )
values ( 1, 'achanel', 'mmonarch' ),
       ( 2, 'achanel', 'ikathrin' ),
       ( 3, 'ikael', 'wsei' ),
       ( 4, 'ikathrin', 'mmonarch' ),
       ( 5, 'mmonarch', 'rhoke' ),
       ( 6, 'fbeatris', 'wsei' ),
       ( 7, 'wsei', 'achanel' ),
       ( 8, 'bgenia', 'rhoke' );

insert into Recommendations ( ID, Peer, Recommended_Peer )
values ( 1, 'achanel', 'mmonarch'),
       ( 2, 'achanel', 'rhoke'),
       ( 3, 'rhoke', 'wsei'),
       ( 4, 'ikael', 'fbeatris'),
       ( 5, 'mmonarch', 'bgenia'),
       ( 6, 'bgenia', 'ikathrin'),
       ( 7, 'ikael', 'achanel'),
       ( 8, 'mmonarch', 'achanel');

insert into XP ( ID, "check", XP_Amount )
values ( 1, 1, 1500),
       ( 2, 2, 700),
       ( 3, 4, 1000),
       ( 4, 5, 800),
       ( 5, 8, 800);

insert into time_tracking ( ID, peer, "date", "time", State )
values ( 1, 'mmonarch', '2023-01-30', '11:05:16', 1 ),
       ( 2, 'mmonarch', '2023-01-30', '20:15:22', 2 ),
       ( 3, 'achanel', '2023-02-01', '17:13:01', 1 ),
       ( 4, 'achanel', '2023-02-01', '03:10:12', 2 ),
       ( 5, 'rhoke', '2022-09-03', '12:45:38', 1 ),
       ( 6, 'rhoke', '2022-09-03', '22:43:56', 2 ),
       ( 7, 'ikathrin', '2022-12-23', '08:00:00', 1 ),
       ( 8, 'ikathrin', '2023-12-23', '21:00:00', 2 ),
       ( 9, 'wsei', '2020-01-02', '00:00:00', 1 );