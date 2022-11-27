package com.example.controller.database;

public class DatabaseConfig {
    public static final String URL = "jdbc:oracle:thin:@//ora4.ii.pw.edu.pl:1521/pdb1.ii.pw.edu.pl";
    public static final String USER = "z07";
    public static final String PASSWORD = "kiycvj";

    public static final String SELECT = "SELECT";
    public static final String FROM = "FROM";
    public static final String WHERE = "WHERE";

    public static final String PLAYERS_TABLE_NAME = "players";
    public static final String STATISTICS_TABLE_NAME = "player_stats";
    public static final String COACHES_TABLE_NAME = "coaches";
    public static final String REFEREES_TABLE_NAME = "referees";
    public static final String CLUBS_TABLE_NAME = "clubs";
    public static final String CLUB_HISTORY_TABLE_NAME = "club_history";
    public static final String STADIUM_TABLE_NAME = "stadiums";
    public static final String LEAGUES_TABLE_NAME = "leagues";
    public static final String MATCHES_TABLE_NAME = "matches";
    public static final String MATCH_EVENTS_TABLE_NAME = "match_events";
}
