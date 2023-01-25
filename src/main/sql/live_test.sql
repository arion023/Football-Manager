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


-- PROCEDURE RESET_USER_OFFERS

alter trigger GENERATE_USER enable;

delete club where CLUB_ID = 1013;
delete users where NICKNAME = 'resetOffers';

INSERT INTO club VALUES (1013, 'test113', 'PL', 106, NULL);
INSERT INTO USERS VALUES ( default, 'addoffers@', 'resetOffers', 1000000, 1013, NULL );

SELECT user_id from users where NICKNAME = 'resetOffers';
select * from OFFER where USER_ID = 11; --wstawic user id z zapytania powyzej

declare
    u_id NUMBER;
begin
    SELECT user_id into u_id from users where NICKNAME = 'resetOffers';
    RESET_USER_OFFERS(u_id);
end;

select * from OFFER where USER_ID = 11; --wstawic user id z zapytania powyzej



