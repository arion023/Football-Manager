/* DROPPING TABLES */
DROP TABLE users;
DROP TABLE offer;
DROP TABLE event;
DROP TABLE event_type;
DROP TABLE trophy;
DROP TABLE match;
DROP TABLE referee;
DROP TABLE player_history;
DROP TABLE coach_history;
DROP TABLE coach;
DROP TABLE player;
DROP TABLE player_stats;
DROP TABLE position;
DROP TABLE club;
DROP TABLE user_club;
DROP TABLE stadium;
DROP TABLE league;
DROP TABLE country;


/* DATES IN THIS FORMAT */

ALTER SESSION SET nls_date_format='yyyy-mm-dd';
INSERT INTO users VALUES ( 101, 'mail', 'nickname', NULL, 349, DEFAULT );

/* CREATING TABLES */
--TODO ADD TO PLAYER IF HE IS IN FIRST SQUAD ?

CREATE TABLE users
(
    user_id     NUMBER NOT NULL CONSTRAINT user_pk PRIMARY KEY,  --TODO TRIGGER ADDING AUTOMATIC ID
    mail        VARCHAR2(30) NOT NULL,
    nickname    VARCHAR2(20),
    budget      NUMBER DEFAULT 1000000,
    club_id     NUMBER NOT NULL, --TODO TRIGGER FOR AUTOMATIC CLUB ID
    formation_id NUMBER --TODO MAYBE GET ONLY NUMBER AND SET BY ENUM?
);

CREATE TABLE offer
(
    offer_id    NUMBER NOT NULL CONSTRAINT offer_pk PRIMARY KEY,
    user_id     NUMBER NOT NULL,
    player_id   NUMBER NOT NULL,
    price       NUMBER DEFAULT 0
);

CREATE TABLE user_club
(
    --TODO ON NEW INSERT DEFAULT ADDING SOME DEFAULT PLAYERS TO THIS CLUB;
    club_id         NUMBER NOT NULL CONSTRAINT user_club_pk PRIMARY KEY, --TODO TRIGGER FOR AUTOMATIC CLUB ID
    name            VARCHAR2(30) NOT NULL,
    country_id      CHAR(2) DEFAULT 'PL',    --TODO TRIGGER -> SAME COUNTRY AS LEAGUE
    league_id       NUMBER DEFAULT '106',
    stadium_id      NUMBER DEFAULT NULL
);


CREATE TABLE country
(
    country_id      CHAR(2) NOT NULL CONSTRAINT country_pk PRIMARY KEY,
    name            VARCHAR2(30) NOT NULL
);


CREATE TABLE league
(
    league_id       NUMBER NOT NULL CONSTRAINT League_pk PRIMARY KEY,
    name            VARCHAR2(20) NOT NULL,
    country_id      CHAR(2) NOT NULL
);


CREATE TABLE stadium
(
    stadium_id      NUMBER NOT NULL CONSTRAINT stadium_pk PRIMARY KEY,
    name            VARCHAR2(60) NOT NULL,
    address         VARCHAR2(60),
    country_id      CHAR(2),
    capacity        NUMBER
);


CREATE TABLE club
(
    club_id         NUMBER NOT NULL CONSTRAINT club_pk PRIMARY KEY,
    name            VARCHAR2(30) NOT NULL,
    country_id      CHAR(2) NOT NULL,
    budget          NUMBER,
    league_id       NUMBER NOT NULL,
    stadium_id      NUMBER
);


CREATE TABLE coach
(
    coach_id        NUMBER NOT NULL CONSTRAINT coach_pk PRIMARY KEY,
    name            VARCHAR2(20) NOT NULL,
    surname         VARCHAR2(20) NOT NULL,
    birth_date      DATE,
    country_id      CHAR(2),
    club_id         NUMBER NOT NULL
);


CREATE TABLE position
(
    position_id     NUMBER NOT NULL CONSTRAINT position_pk PRIMARY KEY,
    name            VARCHAR2(20) NOT NULL
);


CREATE TABLE player_stats
(
    player_id       NUMBER NOT NULL CONSTRAINT player_stats_pk PRIMARY KEY,
    overall         NUMBER NOT NULL,
    pace            NUMBER NOT NULL,
    shooting        NUMBER NOT NULL,
    passing         NUMBER NOT NULL,
    dribbling       NUMBER NOT NULL,
    defence         NUMBER NOT NULL,
    physical        NUMBER NOT NULL
);


CREATE TABLE player
(
    player_id       NUMBER NOT NULL CONSTRAINT player_pk PRIMARY KEY,
    name            VARCHAR2(20) NOT NULL,
    surname         VARCHAR2(40) NOT NULL,
    birth_date      DATE,
    club_id         NUMBER,
    position_id     NUMBER,
    country_id      CHAR(2)
);

-- join to one club history?
CREATE TABLE player_history
(
    club_history_id NUMBER NOT NULL CONSTRAINT player_history_pk PRIMARY KEY,
    player_id       NUMBER NOT NULL,
    club_id         NUMBER NOT NULL,
    start_date      DATE NOT NULL,
    end_date        DATE
);

CREATE TABLE coach_history
(
    coach_history_id NUMBER NOT NULL CONSTRAINT coach_history_pk PRIMARY KEY,
    coach_id        NUMBER NOT NULL,
    club_id         NUMBER NOT NULL,
    start_date      DATE NOT NULL,
    end_date        DATE
);


CREATE TABLE trophy
(
    name            VARCHAR2(30),
    league_id       NUMBER NOT NULL,
    season          DATE NOT NULL,
    club_id         NUMBER NOT NULL,
    CONSTRAINT trophy_pk PRIMARY KEY (League_ID, Season)
    -- Primary key from 2 values?
);


CREATE TABLE referee
(
    referee_id      NUMBER NOT NULL CONSTRAINT referee_pk PRIMARY KEY,
    name            VARCHAR2(20) NOT NULL,
    surname         VARCHAR2(20) NOT NULL,
    country_id      CHAR(2) NOT NULL
);


CREATE TABLE match
(
match_id            NUMBER NOT NULL CONSTRAINT match_pk PRIMARY KEY,
home_club           NUMBER NOT NULL,
away_club           NUMBER NOT NULL,
match_date          DATE NOT NULL,
result              CHAR(3) NOT NULL,
stadium_id          NUMBER NOT NULL,
referee_id          NUMBER NOT NULL
);

CREATE TABLE event
(
    event_id        NUMBER NOT NULL CONSTRAINT event_pk PRIMARY KEY,
    match_id        NUMBER,
    player_id       NUMBER,
    event_type_id   NUMBER
);

CREATE TABLE event_type
(
  event_type_id     NUMBER NOT NULL CONSTRAINT event_type_id PRIMARY KEY,
  name              VARCHAR(20)
);





/* CONSTRAINTS (FOREIGN KEY - REFERENCES) */

--USER
ALTER TABLE users ADD CONSTRAINT user_club_fk FOREIGN KEY(club_id)
    REFERENCES club (club_id);

--OFFER
ALTER TABLE offer ADD CONSTRAINT offer_user_fk FOREIGN KEY(user_id)
    REFERENCES users (user_id);

ALTER TABLE offer ADD CONSTRAINT offer_player_fk FOREIGN KEY(player_id)
    REFERENCES player (player_id);


--USER_CLUB
ALTER TABLE user_club ADD CONSTRAINT user_club_country_fk FOREIGN KEY(country_id)
    REFERENCES country (country_id);

ALTER TABLE user_club ADD CONSTRAINT user_club_league_fk FOREIGN KEY(league_id)
    REFERENCES league (league_id);

ALTER TABLE user_club ADD CONSTRAINT user_club_stadium_fk FOREIGN KEY(stadium_id)
    REFERENCES stadium (stadium_id);


--LEAGUE

ALTER TABLE league ADD CONSTRAINT league_country_fk FOREIGN KEY(country_id)
    REFERENCES country (country_id);


-- STADIUM

ALTER TABLE stadium ADD CONSTRAINT stadium_country_fk FOREIGN KEY(country_id)
    REFERENCES country (country_id);


--CLUB

ALTER TABLE club ADD CONSTRAINT club_country_fk FOREIGN KEY(country_id)
    REFERENCES country (country_id);

ALTER TABLE club ADD CONSTRAINT club_league_fk FOREIGN KEY(league_id)
    REFERENCES league (league_id);

ALTER TABLE club ADD CONSTRAINT club_stadium_fk FOREIGN KEY(stadium_id)
    REFERENCES stadium (stadium_id);

-- USER CLUB

ALTER TABLE user_club ADD CONSTRAINT user_club_country_fk FOREIGN KEY(country_id)
    REFERENCES country (country_id);

ALTER TABLE user_club ADD CONSTRAINT user_club_league_fk FOREIGN KEY(league_id)
    REFERENCES league (league_id);

ALTER TABLE user_club ADD CONSTRAINT user_club_stadium_fk FOREIGN KEY(stadium_id)
    REFERENCES stadium (stadium_id);



--COACH

ALTER TABLE coach ADD CONSTRAINT coach_country_fk FOREIGN KEY(country_id)
    REFERENCES country (country_id);

ALTER TABLE coach ADD CONSTRAINT coach_club_fk FOREIGN KEY(club_id)
    REFERENCES club (club_id);


-- PLAYER

ALTER TABLE player ADD CONSTRAINT player_stats_fk FOREIGN KEY(player_id)
REFERENCES player_stats(player_id);

ALTER TABLE player ADD CONSTRAINT player_position_fk FOREIGN KEY(position_id)
REFERENCES position (position_id);

ALTER TABLE player ADD CONSTRAINT player_club_fk FOREIGN KEY(club_id)
REFERENCES club (club_id);

ALTER TABLE player ADD CONSTRAINT player_country_fk FOREIGN KEY(country_id)
REFERENCES country (country_id);


--PLAYER CLUB HISTORY

ALTER TABLE player_history ADD CONSTRAINT player_history_club_fk FOREIGN KEY(club_id)
REFERENCES club (club_id);

ALTER TABLE player_history ADD CONSTRAINT player_history_player_fk FOREIGN KEY(player_id)
    REFERENCES player (player_id);

--COACH CLUB HISTORY

ALTER TABLE coach_history ADD CONSTRAINT coach_history_club_fk FOREIGN KEY(club_id)
    REFERENCES club (club_id);

ALTER TABLE coach_history ADD CONSTRAINT coach_history_player_fk FOREIGN KEY(coach_id)
    REFERENCES coach (coach_id);


--Trophy

ALTER TABLE trophy ADD CONSTRAINT trophy_league_fk FOREIGN KEY(league_id)
    REFERENCES match (match_id);

ALTER TABLE trophy ADD CONSTRAINT cards_club_fk FOREIGN KEY(club_id)
    REFERENCES club (club_id);


--REFEREE

ALTER TABLE referee ADD CONSTRAINT referee_country_fk FOREIGN KEY(country_id)
REFERENCES country (country_id);


--MATCH

ALTER TABLE match ADD CONSTRAINT match_stadium_fk FOREIGN KEY(stadium_id)
REFERENCES stadium (stadium_id);

ALTER TABLE match ADD CONSTRAINT match_referee FOREIGN KEY(referee_id)
REFERENCES referee (referee_id);


--EVENT

ALTER TABLE event ADD CONSTRAINT event_match_fk FOREIGN KEY(match_id)
REFERENCES match (match_id);

ALTER TABLE event ADD CONSTRAINT event_player_fk FOREIGN KEY(player_id)
REFERENCES player (player_id);

ALTER TABLE event ADD CONSTRAINT event_event_type_fk FOREIGN KEY(event_type_id)
REFERENCES event_type (event_type_id);



