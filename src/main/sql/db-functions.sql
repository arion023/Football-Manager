CREATE TABLE match
(
    match_id            NUMBER NOT NULL CONSTRAINT match_pk PRIMARY KEY,
    home_club           NUMBER NOT NULL,
    away_club           NUMBER NOT NULL,
    home_goals          NUMBER NOT NULL,
    away_goals          NUMBER NOT NULL,
    match_week          NUMBER NOT NULL
);

INSERT INTO match VALUES ( 1, 340, 350, 1, 3, 1 );
INSERT INTO match VALUES ( 2, 340, 350, 2, 2, 2 );
INSERT INTO match VALUES ( 3, 350, 340, 0, 0, 3 );
INSERT INTO match VALUES ( 4, 350, 340, 1, 2, 4 );
INSERT INTO match VALUES ( 5, 340, 350, 1, 0, 5 );
INSERT INTO match VALUES ( 6, 339, 338, 1, 2, 6 );



CREATE or REPLACE PROCEDURE get_points (club_id IN INTEGER, output_points OUT INTEGER)
AS
points integer := 0;
BEGIN
for i in (select home_club, away_club, home_goals, away_goals from match) loop
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
    output_points := points;
END;
/


CREATE or REPLACE FUNCTION total_points (club_id INTEGER)
RETURN INTEGER
AS
total_points INTEGER;
BEGIN
    get_points(club_id, total_points);
RETURN total_points;
END;
/



CREATE or REPLACE PROCEDURE get_scored_goals (club_id IN INTEGER, output_goals OUT INTEGER)
AS
goals integer := 0;
BEGIN
for i in (select home_club, away_club, home_goals, away_goals from match) loop
    IF i.away_club = club_id THEN
        goals := goals + i.away_goals;
    ELSIF i.home_club = club_id THEN
        goals := goals + i.home_goals;
END IF;
end loop;
    output_goals := goals;
END;
/

CREATE or REPLACE FUNCTION total_goals_scored (club_id INTEGER)
RETURN INTEGER
AS
total_goals INTEGER;
BEGIN
    get_scored_goals(club_id, total_goals);
RETURN total_goals;
END;
/



CREATE or REPLACE PROCEDURE get_conceded_goals (club_id IN INTEGER, output_goals OUT INTEGER)
AS
goals integer := 0;
BEGIN
for i in (select home_club, away_club, home_goals, away_goals from match) loop
    IF i.away_club = club_id THEN
        goals := goals + i.home_goals;
    ELSIF i.home_club = club_id THEN
        goals := goals + i.away_goals;
END IF;
end loop;
    output_goals := goals;
END;
/

CREATE or REPLACE FUNCTION total_goals_conceded (club_id INTEGER)
RETURN INTEGER
AS
total_goals INTEGER;
BEGIN
    get_conceded_goals(club_id, total_goals);
RETURN total_goals;
END;
/



select unique total_points(340) from match;

select unique total_goals_scored(340) from match;

select unique total_goals_conceded(340) from match;