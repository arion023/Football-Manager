drop view user_players;
drop view default_clubs;
drop view user_clubs;

CREATE OR REPLACE VIEW user_players
AS
SELECT *
FROM player WHERE player.club_id IN (SELECT club_id FROM users);

CREATE MATERIALIZED VIEW default_players
AS
SELECT *
FROM player WHERE player.club_id NOT IN (SELECT club_id FROM users);


CREATE OR REPLACE VIEW user_clubs
AS
SELECT *
FROM club WHERE club_id IN (SELECT club_id FROM users);


CREATE OR REPLACE VIEW default_clubs
AS
SELECT *
FROM club WHERE club_id NOT IN (SELECT club_id FROM users);


--TODO make copy of players
CREATE OR REPLACE TRIGGER generate_user
AFTER INSERT ON users
FOR EACH ROW
DECLARE
    players_counter NUMBER;
BEGIN
    -- 2 5 5 3
    --GK
    SELECT count(player_id) INTO players_counter FROM player WHERE club_id = :new.club_id;
    IF players_counter < 11 THEN

    FOR rand_player IN (SELECT * FROM default_players WHERE POSITION_ID = 1 ORDER BY DBMS_RANDOM.value FETCH NEXT 2 ROWS ONLY)
    LOOP
        UPDATE player SET club_id = :new.club_id WHERE player_id = rand_player.PLAYER_ID;
    END LOOP;

    --DEFENCE
    FOR rand_player IN (SELECT * FROM default_players WHERE POSITION_ID = 2 ORDER BY DBMS_RANDOM.value FETCH NEXT 5 ROWS ONLY)
        LOOP
            UPDATE player SET club_id = :new.club_id WHERE player_id = rand_player.PLAYER_ID;
        END LOOP;

    --MIDFIELDERS
    FOR rand_player IN (SELECT * FROM default_players WHERE POSITION_ID = 3 ORDER BY DBMS_RANDOM.value FETCH NEXT 5 ROWS ONLY)
        LOOP
            UPDATE player SET club_id = :new.club_id WHERE player_id = rand_player.PLAYER_ID;
        END LOOP;

    --FORWARDS
    FOR  rand_player IN (SELECT * FROM default_players WHERE POSITION_ID = 4 ORDER BY DBMS_RANDOM.value FETCH NEXT 3 ROWS ONLY)
        LOOP
            UPDATE player SET club_id = :new.club_id WHERE player_id = rand_player.PLAYER_ID;
        END LOOP;

    END IF;

    --OFFER
    FOR rand_player IN (SELECT * FROM default_players ORDER BY DBMS_RANDOM.value FETCH NEXT 30 ROWS ONLY)
        LOOP
            INSERT INTO offer VALUES(DEFAULT, :new.USER_ID, rand_player.PLAYER_ID, (SELECT TRUNC ((DBMS_RANDOM.NORMAL * 10000) + 50000) to_int FROM DUAL));
        END LOOP;

END;
/


DROP TRIGGER generate_user;

INSERT INTO club VALUES (4000, 'Legia Warszawa', 'PL', 106, NULL);

DELETE FROM club WHERE club_id = 4000;

DELETE FROM users WHERE user_id = 100;

INSERT INTO users VALUES (100, 'mail@gmail.com', 'essa', 1000000, 4000, NULL);
--
--SELECT * FROM player WHERE CLUB_ID = 4000;
--SELECT * FROM offer WHERE user_id = 100;
--
--ALTER TRIGGER generate_user disable;
--ALTER TRIGGER generate_user enable;
--
--SELECT player_id FROM player WHERE POSITION_ID = 1 ORDER BY DBMS_RANDOM.value FETCH NEXT 2 ROWS ONLY;
--
--SELECT player_id FROM player WHERE POSITION_ID = 1 ORDER BY DBMS_RANDOM.value FETCH NEXT 2 ROWS ONLY;
--
--SELECT (DBMS_RANDOM.NORMAL * 10000) + 50000 FROM DUAL;
--SELECT DBMS_RANDOM.VALUE FROM DUAL;
--
--select * from user_errors where type = 'TRIGGER' and name = 'NEWALERT';
