ALTER SESSION SET nls_date_format='yyyy-mm-dd';
alter trigger PLAYER_HISTORY_UPDATE enable;
truncate table PLAYER_HISTORY;
delete player where player_id = 1001;
delete player_stats where player_id = 1001;

SELECT * from player WHERE PLAYER_ID = 40277;
SELECT * from player WHERE PLAYER_ID = 1001;

SELECT * FROM player_history;


UPDATE player SET club_id = 11 WHERE player_id = 40277;
UPDATE player SET club_id = 111 WHERE player_id = 40277;

INSERT INTO player_stats VALUES ( 1001, 71, 62, 72, 57, 70, 84, 83 );
INSERT INTO player VALUES ( 1001, 'Witan', 'Sulaeman', '2001-10-08', 11, 3, 'ID');

SELECT * FROM player_history;
