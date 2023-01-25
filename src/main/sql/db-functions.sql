CREATE or REPLACE FUNCTION get_points(club_id IN INTEGER)
    RETURN INTEGER
AS
    points integer := 0;
BEGIN
    for i in (select home_club, away_club, home_goals, away_goals from match)
        loop
            IF i.away_club = club_id THEN
                IF i.away_goals > i.home_goals THEN
                    points := points + 3;
                ELSIF i.away_goals = i.home_goals THEN
                    points := points + 1;
                END IF;
            ELSIF i.home_club = club_id THEN
                IF i.home_goals > i.away_goals THEN
                    points := points + 3;
                ELSIF i.home_goals = i.away_goals THEN
                    points := points + 1;
                END IF;
            END IF;
        end loop;
    RETURN points;
END;
/


CREATE or REPLACE FUNCTION get_scored_goals(club_id IN INTEGER)
    RETURN INTEGER
AS
    goals integer := 0;
BEGIN
    for i in (select home_club, away_club, home_goals, away_goals from match)
        loop
            IF i.away_club = club_id THEN
                goals := goals + i.away_goals;
            ELSIF i.home_club = club_id THEN
                goals := goals + i.home_goals;
            END IF;
        end loop;
    RETURN goals;
END;
/


CREATE or REPLACE FUNCTION get_conceded_goals(club_id IN INTEGER)
    RETURN INTEGER
AS
    goals integer := 0;
BEGIN
    for i in (select home_club, away_club, home_goals, away_goals from match)
        loop
            IF i.away_club = club_id THEN
                goals := goals + i.home_goals;
            ELSIF i.home_club = club_id THEN
                goals := goals + i.away_goals;
            END IF;
        end loop;
    RETURN goals;
END;
/


select unique get_points(340)
from dual;

select unique get_scored_goals(340)
from dual;

select unique get_conceded_goals(340)
from dual;


create or replace PROCEDURE update_club_countries
AS
league_country CHAR(2);
BEGIN
FOR club_rec IN (SELECT club_id, league_id FROM CLUB WHERE country_id is Null)
    LOOP
        EXIT WHEN club_rec.league_id is null;
SELECT lg.country_id INTO league_country FROM
    CLUB c join LEAGUE lg on c.league_id = lg.league_id where c.club_id = club_rec.club_id;
UPDATE CLUB SET country_id = league_country WHERE club_id = club_rec.club_id;
END LOOP;
END;
/