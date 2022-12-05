
import json

def get_leagues_id_from_json():
    leagues_id = []
    with open(f"json/leagues.json", 'r') as fp:
        data = json.load(fp)['response']
    for element in data:
        leagues_id.append(element['league']['id'])
    return leagues_id

def get_teams_id_from_json():
    teams_id = []
    with open(f"json/teams.json", 'r') as fp:
        leagues = json.load(fp)
    for league in leagues:
        league = league["response"]
        for team in league:
            teams_id.append(team['team']['id'])
    return teams_id


def get_countries_dict():
    countries = {}
    with open(f"json/countries.json", 'r') as fp:
        data = json.load(fp)['response']
    for element in data:
        countries[element['name']] = element['code']
    return countries