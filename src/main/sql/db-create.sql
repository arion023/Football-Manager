/* DROPPING TABLES */
DROP TABLE card;
DROP TABLE player;
DROP TABLE player_stats;
DROP TABLE position;
DROP TABLE coach;
DROP TABLE club_history;
DROP TABLE trophy;
DROP TABLE club;
DROP TABLE league;
DROP TABLE match;
DROP TABLE referee;
DROP TABLE stadium;
DROP TABLE country;

/* DATES IN THIS FORMAT */

ALTER SESSION SET nls_date_format='yyyy-mm-dd';

/* CREATING TABLES */

CREATE TABLE player
(
    player_id       NUMBER NOT NULL CONSTRAINT player_pk PRIMARY KEY,
    name            VARCHAR2(20) NOT NULL,
    surname         VARCHAR2(20) NOT NULL,
    player_stats_id NUMBER NOT NULL,
    birth_date      DATE,
    club_id         NUMBER,
    position_id     NUMBER,
    country_id      CHAR(2) NOT NULL,
    club_history_id NUMBER
);

CREATE TABLE position
(
    position_id     NUMBER NOT NULL CONSTRAINT position_pk PRIMARY KEY,
    name            VARCHAR2(20) NOT NULL
);


CREATE TABLE player_stats
(
    player_stats_id NUMBER NOT NULL CONSTRAINT player_stats_pk PRIMARY KEY,
    overall         NUMBER NOT NULL,
    pace            NUMBER NOT NULL,
    shooting        NUMBER NOT NULL,
    passing         NUMBER NOT NULL,
    dribbling       NUMBER NOT NULL,
    defense         NUMBER NOT NULL,
    physical        NUMBER NOT NULL
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

CREATE TABLE club_history
(
    club_history_id NUMBER NOT NULL CONSTRAINT club_history_pk PRIMARY KEY,
    club_id         NUMBER NOT NULL,
    start_date      DATE NOT NULL,
    end_date        DATE

);

CREATE TABLE coach
(
    coach_id        NUMBER NOT NULL CONSTRAINT coach_pk PRIMARY KEY,
    name            VARCHAR2(20) NOT NULL,
    surname         VARCHAR2(20) NOT NULL,
    birth_date      DATE,
    country_id      CHAR(2) NOT NULL,
    club_id         NUMBER NOT NULL,
    club_history_id NUMBER
);

CREATE TABLE referee
(
    referee_id      NUMBER NOT NULL CONSTRAINT referee_pk PRIMARY KEY,
    name            VARCHAR2(20) NOT NULL,
    surname         VARCHAR2(20) NOT NULL,
    country_id      CHAR(2) NOT NULL
);

CREATE TABLE league
(
    league_id       NUMBER NOT NULL CONSTRAINT League_pk PRIMARY KEY,
    name            VARCHAR2(20) NOT NULL,
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

CREATE TABLE card
(
    card_id         NUMBER NOT NULL CONSTRAINT card_pk PRIMARY KEY,
    match_id        NUMBER NOT NULL,
    player_id       NUMBER NOT NULL
);

CREATE TABLE stadium
(
    stadium_id      NUMBER NOT NULL CONSTRAINT stadium_pk PRIMARY KEY,
    name            VARCHAR2(60) NOT NULL,
    address         VARCHAR2(60),
    country_id      CHAR(2),
    capacity        NUMBER,
    build_date      DATE
);

CREATE TABLE country
(
    country_id      CHAR(2) NOT NULL CONSTRAINT country_pk PRIMARY KEY,
    name            VARCHAR2(30) NOT NULL
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


/* CONSTRAINTS (FOREIGN KEY - REFERENCES) */

-- PLAYER

ALTER TABLE player ADD CONSTRAINT player_player_stats_fk FOREIGN KEY(player_stats_id)
REFERENCES player_stats (player_stats_id);

ALTER TABLE player ADD CONSTRAINT player_position_fk FOREIGN KEY(position_id)
REFERENCES position (position_id);

ALTER TABLE player ADD CONSTRAINT player_club_fk FOREIGN KEY(club_id)
REFERENCES club (club_id);

ALTER TABLE player ADD CONSTRAINT player_country_fk FOREIGN KEY(country_id)
REFERENCES country (country_id);

ALTER TABLE player ADD CONSTRAINT player_club_history_fk FOREIGN KEY(club_history_id)
REFERENCES club_history (club_history_id);

--CLUB

ALTER TABLE club ADD CONSTRAINT club_country_fk FOREIGN KEY(country_id)
REFERENCES country (country_id);

ALTER TABLE club ADD CONSTRAINT club_league_fk FOREIGN KEY(league_id)
REFERENCES league (league_id);

ALTER TABLE club ADD CONSTRAINT club_stadium_fk FOREIGN KEY(stadium_id)
REFERENCES stadium (stadium_id);

--CLUB HISTORY

ALTER TABLE club_history ADD CONSTRAINT club_history_club_fk FOREIGN KEY(club_id)
REFERENCES club (club_id);

--COACH

ALTER TABLE coach ADD CONSTRAINT coach_country_fk FOREIGN KEY(country_id)
REFERENCES country (country_id);

ALTER TABLE coach ADD CONSTRAINT coach_club_fk FOREIGN KEY(club_id)
REFERENCES club (club_id);

ALTER TABLE coach ADD CONSTRAINT coach_club_history_fk FOREIGN KEY(club_history_id)
REFERENCES club_history (club_history_id);

--REFEREE

ALTER TABLE referee ADD CONSTRAINT referee_country_fk FOREIGN KEY(country_id)
REFERENCES country (country_id);

--LEAGUE

ALTER TABLE league ADD CONSTRAINT league_country_fk FOREIGN KEY(country_id)
REFERENCES country (country_id);

--MATCH

ALTER TABLE match ADD CONSTRAINT match_stadium_fk FOREIGN KEY(stadium_id)
REFERENCES stadium (stadium_id);

ALTER TABLE match ADD CONSTRAINT match_referee FOREIGN KEY(referee_id)
REFERENCES referee (referee_id);

--CARDS

ALTER TABLE card ADD CONSTRAINT cards_match_fk FOREIGN KEY(match_id)
REFERENCES match (match_id);

ALTER TABLE card ADD CONSTRAINT cards_player_fk FOREIGN KEY(player_id)
REFERENCES player (player_id);

-- STADIUM

ALTER TABLE stadium ADD CONSTRAINT stadium_country_fk FOREIGN KEY(country_id)
REFERENCES country (country_id);

--Trophy

ALTER TABLE trophy ADD CONSTRAINT trophy_league_fk FOREIGN KEY(league_id)
REFERENCES match (match_id);

ALTER TABLE trophy ADD CONSTRAINT cards_club_fk FOREIGN KEY(club_id)
REFERENCES club (club_id);


