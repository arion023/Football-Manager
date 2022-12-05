from configFun import *

URL = "https://v3.football.api-sports.io/"

SEASON = "2021"

payload={}
headers = {
  'x-rapidapi-key': '5a67a589962bae936da655b663052fec', #<- Juan(xariigamesx)
  'x-rapidapi-host': 'v3.football.api-sports.io'
}

INSERT = 'INSERT '
INTO = 'INTO '
VALUES = 'VALUES '

COUNTRIES = []

table_country = 'country '
table_league = 'league '
table_team = 'club '
table_venue = 'stadium '
table_coach = 'coach '
table_player = 'player '

countries_dict = get_countries_dict()

leagues_ids = get_leagues_id_from_json()
teams_ids = get_teams_id_from_json()

league_params = {"code" : "PL" }
team_params = {"season" : SEASON}
venue_params = {"country" : "Poland"}
coach_params = {}
player_params = {"season" : SEASON}





