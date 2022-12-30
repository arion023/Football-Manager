import re
import numpy as np
from enum import Enum

from urllib.parse import urlparse
from urllib.request import Request
from urllib.request import urlopen
from urllib.request import urlretrieve

from bs4 import BeautifulSoup as bs

URL = "https://www.google.com/search?q="

class Position(Enum):
    GOALKEEPER = 1
    DEFENDER = 2
    MIDFIELDER = 3
    FORWARD = 4

def get_SQL_content(path):
    with open(path, 'r') as fp:
        lines = fp.readlines()
    return lines

def get_SQL_values(line):
    values = []
    line = line.split(' ')
    flag_values = False
    for word in line:
        if flag_values:
            if ");" in word:
                flag_values = False
            else:
                values.append(word[:-1])
        if word == '(':
            flag_values = True
    return values


def generateURL(name, surname):
    new_url = URL + name + '+' + surname
    return new_url


def searchPosition(name, surname):
    url = generateURL(name, surname)
    htmlPage = downloadPage(url).decode('utf-8').lower()
    occur = []
    goalkeeper_idx = [m.start() for m in re.finditer('bramkarz', htmlPage)]
    occur.append(len(goalkeeper_idx))
    defender_idx = [m.start() for m in re.finditer('obrońca', htmlPage)]
    occur.append(len(defender_idx))
    midfielder_idx = [m.start() for m in re.finditer('pomocnik', htmlPage)]
    occur.append(len(midfielder_idx))
    forward_idx = [m.start() for m in re.finditer('napastnik', htmlPage)]
    occur.append(len(forward_idx))
    if max(occur) != 0:
        idx = occur.index(max(occur))
        return Position(idx + 1)
    else:
        return -1


def downloadPage(url):
    req = Request(url, headers={
        'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_5) AppleWebKit/537.36 (KHTML, like Gecko) Cafari/537.36'
        })
    sauce = urlopen(req).read()
    soup = bs(sauce, 'html5lib')
    return soup

def generate_SQL_player_positions(path):
    lines = get_SQL_content(path)

    with open('new_' + path, 'w') as fp:
        for line in lines:
            attrs_idx = [m.start() for m in re.finditer(',', line)]
            if line.find(' player ') != -1 and len(attrs_idx) == 6:
                values = get_SQL_values(line)
                if values[-2] == "NULL":
                    position = searchPosition(values[1], values[2])
                    if position != -1:
                        line = line[:attrs_idx[-1] - 4] + str(position.value) + line[attrs_idx[-1]:]

            fp.write(line)



#poss_idx 1 = bramkarz, 2 = obronca, 3 = pomocnik, 4 = napastnik
def generate_SQL_players_stats(path):
    lines = get_SQL_content(path)

    with open(path, 'w') as fp:
        error_lines = []
        for line in lines:
            attrs_idx = [m.start() for m in re.finditer(',', line)]
            if line.find(' player ') != -1 and len(attrs_idx) == 6:
                stats = []
                if line[attrs_idx[5] - 1].isdigit():
                    stat_sql = 'INSERT INTO player_stats VALUES ('
                    poss_idx = int(line[attrs_idx[5] - 1])
                    poss = Position(poss_idx)
                    player_id = get_SQL_values(line)[0]

                    if poss == Position.GOALKEEPER:
                        stats = np.random.normal(70, 10, 6)

                    elif poss == Position.DEFENDER:
                        pace = np.random.normal(50, 10)
                        shooting = np.random.normal(40, 10)
                        passing = np.random.normal(70, 10)
                        dribbling = np.random.normal(50, 10)
                        defense = np.random.normal(80, 10)
                        physical = np.random.normal(70, 10)
                        stats = [pace, shooting, passing, dribbling, defense, physical]

                    elif poss == Position.MIDFIELDER:
                        pace = np.random.normal(70, 10)
                        shooting = np.random.normal(70, 10)
                        passing = np.random.normal(70, 10)
                        dribbling = np.random.normal(70, 10)
                        defense = np.random.normal(70, 10)
                        physical = np.random.normal(70, 10)
                        stats = [pace, shooting, passing, dribbling, defense, physical]

                    elif poss == Position.FORWARD:
                        pace = np.random.normal(80, 10)
                        shooting = np.random.normal(80, 10)
                        passing = np.random.normal(70, 10)
                        dribbling = np.random.normal(80, 10)
                        defense = np.random.normal(30, 10)
                        physical = np.random.normal(70, 10)
                        stats = [pace, shooting, passing, dribbling, defense, physical]

                    else:
                        raise Exception(ValueError(f'Error vlaues is: {poss_idx}'))

                    for i in range(len(stats)):
                        stats[i] = round(stats[i])
                        if stats[i] > 100:
                            stats[i] = 100

                    stat_sql += player_id + ', '
                    stat_sql += str(int(sum(stats)/len(stats))) + ', '

                    for s in stats[:-1]:
                        stat_sql += str(s) + ', '
                    stat_sql += str(stats[-1]) + ' );\n'

                    fp.write(stat_sql)

                    if line.find(' player_stats ') == -1:
                        fp.write(line)

                elif line[attrs_idx[5] - 4 : attrs_idx[5]] == 'NULL':
                    error_lines.append(line)
            else:
                if line.find(' player_stats ') == -1:
                    fp.write(line)

        fp.write('\n--ERRORS\n\n')
        for line in error_lines:
            fp.write(line)

def main():
    path = 'sql/workspace/players.sql'
    #generate_SQL_player_positions('sql/players.sql')
    generate_SQL_players_stats(path)

if __name__ == "__main__":
    main()