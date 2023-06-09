package com.example.controller.database;

public class DatabaseConfig {



    private DatabaseConfig() {
        throw new IllegalStateException("Utility class");
    }

    public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    public static final String USER = "system";
    public static final String PASSWORD = "toor";

    public static final String SELECT = "SELECT";
    public static final String FROM = "FROM";
    public static final String WHERE = "WHERE";

    public static final String PLAYERS_TABLE_NAME = "player";
    public static final String STATISTICS_TABLE_NAME = "player_stats";
    public static final String COACHES_TABLE_NAME = "coach";
    public static final String REFEREES_TABLE_NAME = "referee";
    public static final String OFFER_TABLE_NAME = "offer";
    public static final String CLUBS_TABLE_NAME = "club";
    public static final String CLUB_HISTORY_TABLE_NAME = "club_history";
    public static final String STADIUM_TABLE_NAME = "stadium";
    public static final String LEAGUES_TABLE_NAME = "league";
    public static final String MATCHES_TABLE_NAME = "match";
    public static final String EVENTS_TABLE_NAME = "event";
    public static final String USERS_TABLE_NAME = "users";
    public static final String OFFERS_ALL_INFO_VIEW = "offers_all_info";
    public static final String CLUB_POINTS_QUERY = "SELECT GET_POINTS(%d) FROM DUAL";
    public static final String CLUB_GOALS_SCORED_QUERY = "SELECT GET_SCORED_GOALS(%d) FROM DUAL";
    public static final String CLUB_GOALS_CONCEDED_QUERY = "SELECT GET_CONCEDED_GOALS(%d) FROM DUAL";
}
