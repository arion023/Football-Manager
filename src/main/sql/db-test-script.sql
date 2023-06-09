
/*============================================================================/
/                      GENERATE_USER TRIGGER                                  /
/============================================================================*/

-- Creating user with id = 101, club_id = 1010
INSERT INTO club VALUES (1010, 'user club', Null, 106, Null);
-- User club is initially empty:
select name, surname, club_id from player where club_id = 1010;

INSERT INTO users VALUES (101, 'test@gmail.com', 'test user', 2000, 1010, 0);
-- The trigger is activated, the club should receive players from default_players pool:
select name, surname, club_id from player where club_id = 1010;
-- The user club also receives auto-generated offers on the transfer market:
select * from offer where user_id = 101;

commit;

-- Creating two clubs
INSERT INTO club VALUES (1111, 'test club 1', Null, 106, Null);
INSERT INTO club VALUES (2222, 'test club 2', Null, 106, Null);


-- Creating a player assigned to the first club
INSERT INTO player_stats VALUES (1111111, 57, 53, 39, 70, 36, 91, 57 );
INSERT INTO player VALUES ( 1111111, 'Test', 'Player', NULL, 1111, 2, 'PL' );

/*============================================================================/
/                      PLAYER_HISTORY_UPDATE TRIGGER                          /
/============================================================================*/

select * from player_history where player_id = 1111111;
-- We see that the information about the player joining the first club is saved

-- Now we update test player's club to test club 2
UPDATE player set club_id = 2222 where player_id = 1111111;

select * from player_history where player_id = 1111111;
-- Now we see that the date of leaving the club 1 is updated in the first entry
-- A new row represents the new stage of the players career in the second club


/*============================================================================/
/      GET_CONECEDED_GOALS, GET_SCORED_GOALS and GET_POINTS FUNCTIONS         /
/============================================================================*/

INSERT INTO match VALUES (11111, 1111, 2222, 3, 1, 1);
INSERT INTO match VALUES (11112, 1111, 2222, 2, 2, 1);
INSERT INTO match VALUES (11113, 1111, 2222, 1, 0, 1);
-- There are 3 matches.
-- 2 wins for team 1 and 1 draw
-- Team 1 should have 7 points, 6 goals scored, 3 conceded
-- Team 2 should have 1 point, 3 goals scored, 6 conceded

SELECT  club_id, name,
        (select get_points(club_id) from dual) as points,
        (select get_scored_goals(club_id) from dual) as scored,
        (select get_conceded_goals(club_id) from dual) as conceded
from club where club_id = 1111 or club_id = 2222;


-- UPDATE_CLUB_COUNTRIES PROCEDURE

select * from club where country_id is null;
-- As we can see club 1 and 2 don't have countries assigned

-- country_id will be updated according to league_id (league of ID 106 is polish)
begin
update_club_countries();
end;
select * from club where club_id = 1111 or club_id = 2222;


-- CLEANING UP THE TEST DATA

delete from player_history where club_id = 1010 or club_id = 1111 or club_id = 2222;
update player set club_id = null where club_id = 1010 or club_id = 1111 or club_id = 2222;
delete from match where away_club = 1111 or home_club = 1111;
delete from offer where user_id = 101;
delete from users where user_id = 101;
delete from club  where club_id = 1010 or club_id = 1111 or club_id = 2222;
delete from player where player_id = 1111111;
delete from player_stats where player_id = 1111111;
commit;
