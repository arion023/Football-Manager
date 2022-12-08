import json
import requests
import random
from time import sleep

from config import *



def countries():
    queries = []
    errors = []
    endpoint = "countries"

    response = requests.request("GET", URL + endpoint, headers=headers, data=payload)

    with open(f"json/{endpoint}.json", 'w') as fp:
        json.dump(response.json(), fp, indent=4)

    if response.status_code == 200:
        countries = response.json()['response'] #list

        for country in countries:
            query = INSERT + INTO + table_country + VALUES
            correct = True

            if (type(country['code']) != str):
                country['code'] = 'NULL'
                correct = False
            if (type(country['name']) != str):
                country['name'] = 'NULL'
                correct = False

            query += '( \'' + country['code'] + '\', \'' + country['name'] + '\' );\n'
            if correct:
                queries.append(query)
            else:
                errors.append(query)

        if (len(errors) > 0):
            queries.append("\n--ERRORS\n")
            queries.extend(errors)
        else:
            queries.append("\n--NO ERRORS")
        return queries

    else:
        return f"Error {response.code}"



def leagues():
    queries = []
    errors = []

    endpoint = "leagues"

    response = requests.request("GET", URL + endpoint, headers=headers, data=payload, params=league_params)

    with open(f"json/{endpoint}.json", 'w') as fp:
        json.dump(response.json(), fp, indent=4)

    if response.status_code == 200:

        response = response.json()['response'] #list

        for element in response:
            query = INSERT + INTO + table_league + VALUES
            correct = True

            league_id = element['league']['id']
            league_name = element['league']['name']
            country_id = element['country']['code']

            if (type(league_id) != int):
                league['id'] = 'NULL'
                correct = False

            if (type(league_name) != str):
                league['name'] = 'NULL'
                correct = False

            if (type(country_id) != str):
                country_id = 'NULL'
                correct = False

            values = [league_id, league_name, country_id]


            query += '( ' + str(league_id) + ', \'' + league_name + '\', \'' + country_id + '\' );\n'

            if correct:
                queries.append(query)
            else:
                errors.append(query)

        if (len(errors) > 0):
            queries.append("\n--ERRORS\n")
            queries.extend(errors)
        else:
            queries.append("\n--NO ERRORS")
        return queries

    else:
        return f"Error {response.code}"



def teams():
    queries = []

    endpoint = "teams"

    with open(f"json/{endpoint}.json", 'w') as fp:
        fp.write("[\n")


    for id in leagues_ids:
        errors = []
        queries.append(f"\n\n-- LEAGUE: {id} \n\n")
        team_params["league"] = id
        response = requests.request("GET", URL + endpoint, headers=headers, data=payload, params=team_params)

        with open(f"json/{endpoint}.json", 'a') as fp:
            json.dump(response.json(), fp, indent=4)
            if id in leagues_ids[:-1]:
                fp.write(", \n")

        if response.status_code == 200:

            response = response.json()['response'] #list


            for element in response:
                query = INSERT + INTO + table_team + VALUES
                correct = True

                country = str(element['team']['country'])

                team_id = element['team']['id']
                name = element['team']['name']
                country_id = countries_dict[country]
                budget = random.randrange(2000, 1000000, 1000)
                league_id = id
                stadium_id = element['venue']['id']

                values = [team_id, name, country_id, budget, league_id, stadium_id]

                query += '( '
                for value in values[:-1]:
                    if type(value) == str:
                        query += "\'"+value + "\', "
                    elif type(value) == int:
                        query += str(value) + ", "
                    else:
                        query += "NULL" + ", "
                        correct = False

                if type(values[-1]) == str:
                    query += "\'"+ values[-1] + "\'"
                elif type(values[-1]) == int:
                    query += str(values[-1])
                else:
                    query += "NULL"
                    correct = False
                query += ' );\n'

                if correct:
                    queries.append(query)
                else:
                    errors.append(query)

            if (len(errors) > 0):
                queries.append("\n--ERRORS\n")
                queries.extend(errors)
            else:
                queries.append("\n--NO ERRORS")
        else:
            return [f"\nError {response.code}\n"]

    with open(f"json/{endpoint}.json", 'a') as fp:
        fp.write("\n]\n")

    return queries



def venues():
    queries = []
    errors = []

    endpoint = "venues"

    response = requests.request("GET", URL + endpoint, headers=headers, data=payload, params=venue_params)

    with open(f"json/{endpoint}.json", 'w') as fp:
        json.dump(response.json(), fp, indent=4)

    if response.status_code == 200:

        response = response.json()['response'] #list

        for data in response:
            query = INSERT + INTO + table_venue + VALUES
            correct = True

            venue_id = data['id']
            venue_name = data['name']
            address = data['address']
            country_id = countries_dict[data['country']]
            capacity = data['capacity']
            build_date = None

            values = [venue_id, venue_name, address, country_id, capacity, build_date]

            query += '( '
            for value in values[:-1]:
                if type(value) == str:
                    query += "\'"+value + "\', "
                elif type(value) == int:
                    query += str(value) + ", "
                else:
                    query += "NULL" + ", "
                    correct = False

            if type(values[-1]) == str:
                query += "\'"+ values[-1] + "\'"
            elif type(values[-1]) == int:
                query += str(values[-1])
            else:
                query += "NULL"
                correct = False

            query += ' );\n'

            if correct:
                queries.append(query)
            else:
                errors.append(query)

        if (len(errors) > 0):
            queries.append("\n--ERRORS\n")
            queries.extend(errors)
        else:
            queries.append("\n--NO ERRORS")
        return queries

    else:
        return f"Error {response.code}"


def coachs():
    queries = []
    errors = []

    endpoint = "coachs"
    teams_ids = get_teams_id_from_json()

    with open(f"json/{endpoint}.json", 'w') as fp:
        fp.write("[\n")

    i = 1
    for id in teams_ids:
        if i % 10 == 0:  #limit 10 requestes in 60s period
            sleep(70)

        i+= 1

        errors = []
        queries.append(f"\n\n-- TEAM: {id} \n\n")
        coach_params["team"] = id
        response = requests.request("GET", URL + endpoint, headers=headers, data=payload, params=coach_params)

        with open(f"json/{endpoint}.json", 'a') as fp:
            json.dump(response.json(), fp, indent=4)
            if id in teams_ids[:-1]:
                fp.write(", \n")

        if response.status_code == 200:

            response = response.json()['response'] #list


            for element in response:
                query = INSERT + INTO + table_coach + VALUES
                correct = True


                id = element['id']
                name = element['firstname']
                surname = element["lastname"]
                b_date = element["birth"]["date"]

                nationality = element['nationality']

                if nationality in countries_dict.keys():
                    country_id = countries_dict[nationality]
                else:
                    country_id = None
                    correct = False

                club_id = element['team']['id']
                club_history = None

                values = [id, name, surname, b_date, country_id, club_id]

                query += '( '
                for value in values[:-1]:
                    if type(value) == str:
                        query += "\'"+value + "\', "
                    elif type(value) == int:
                        query += str(value) + ", "
                    else:
                        query += "NULL" + ", "
                        correct = False


                if type(values[-1]) == str:
                    query += "\'"+ values[-1] + "\'"
                elif type(values[-1]) == int:
                    query += str(values[-1])
                else:
                    query += "NULL"
                    correct = False
                query += ' );\n'

                if correct:
                    queries.append(query)
                else:
                    errors.append(query)

            if (len(errors) > 0):
                queries.append("\n--ERRORS\n")
                queries.extend(errors)
            else:
                queries.append("\n--NO ERRORS")
        else:
            return [f"\nError {response.code}\n"]

    with open(f"json/{endpoint}.json", 'a') as fp:
        fp.write("\n]\n")

    return queries


def players():
    queries = []

    endpoint = "players"

    with open(f"json/{endpoint}.json", 'w') as fp:
        fp.write("[\n")


    for id in leagues_ids:
        errors = []
        queries.append(f"\n\n-- LEAGUE: {id} \n\n")
        player_params["league"] = id

        next_page = True
        page = 0

        while(next_page == True):
            page += 1

            if page%10 == 0: # check if correct!!
                sleep(70)

            player_params["page"] = page
            response = requests.request("GET", URL + endpoint, headers=headers, data=payload, params=player_params)

            response_json = response.json()

            last_page = response_json["paging"]["total"]

            if page == last_page:
                next_page = False

            with open(f"json/{endpoint}.json", 'a') as fp:
                json.dump(response_json, fp, indent=4)
                if (id in leagues_ids[:-1] or page < last_page):
                    fp.write(", \n")

            if response.status_code == 200:

                response = response_json['response'] #list


                for element in response:
                    query = INSERT + INTO + table_player + VALUES
                    correct = True

                    statistics = element["statistics"][0]
                    nationality = element["player"]["nationality"]

                    p_id = element["player"]["id"]
                    name = element["player"]["firstname"]
                    surname = element["player"]["lastname"]
                    p_stats_id = None
                    b_date = element["player"]["birth"]["date"]
                    club_id = statistics["team"]["id"]
                    position_id = None

                    if nationality in countries_dict.keys():
                        country_id = countries_dict[nationality]
                    else:
                        country_id = None
                        correct = False

                    club_history = None


                    values = [p_id, name, surname, p_stats_id, b_date, club_id, position_id, country_id]

                    query += '( '
                    for value in values[:-1]:
                        if type(value) == str:
                            query += "\'"+value + "\', "
                        elif type(value) == int:
                            query += str(value) + ", "
                        else:
                            query += "NULL" + ", "
                            correct = False


                    if type(values[-1]) == str:
                        query += "\'"+ values[-1] + "\'"
                    elif type(values[-1]) == int:
                        query += str(values[-1])
                    else:
                        query += "NULL"
                        correct = False
                    query += ' );\n'

                    if correct:
                        queries.append(query)
                    else:
                        errors.append(query)
            else:
                return [f"\nError {response.code}\n"]

        if (len(errors) > 0):
            queries.append("\n--ERRORS\n")
            queries.extend(errors)
        else:
            queries.append("\n--NO ERRORS")

    with open(f"json/{endpoint}.json", 'a') as fp:
        fp.write("\n]\n")

    return queries

