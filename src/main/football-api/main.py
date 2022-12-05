import unicodedata
import unidecode

from queries import countries, leagues, teams, venues, players, coachs


if __name__ == "__main__":
    sql_queries = coachs()
    for i in range(len(sql_queries)):
        # swap polish letters to ASCII
        sql_queries[i] = unidecode.unidecode(sql_queries[i])

    with open('sql/coachs.sql', 'w', encoding='utf-8') as fp:
        fp.writelines(sql_queries)
