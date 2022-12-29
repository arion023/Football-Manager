/* ORDER OF LOADING */
-- COUNTRY
-- LEAGUE
-- STADIUM
-- CLUB
-- COACH
-- POSITION     (not yet)//z palca
-- PLAYER_STATS (not yet)//depend from position
-- PLAYER
-- PLAYER_CLUB_HISTORY (not yet) join
-- COACH_CLUB_HISTORY (not yet) join
-- TROPHY       (not yet)//dynamic
-- REFEREE      wywalic
-- MATCH        (not yet)//dynamic
-- cards (EVENTS)         (not yet)//dynamic
-- TYPE_EVENTS ?



/* DATES IN THIS FORMAT */

ALTER SESSION SET nls_date_format='yyyy-mm-dd';


/*  COUNTRY */

INSERT INTO country VALUES ( 'AL', 'Albania' );
INSERT INTO country VALUES ( 'DZ', 'Algeria' );
INSERT INTO country VALUES ( 'AD', 'Andorra' );
INSERT INTO country VALUES ( 'AO', 'Angola' );
INSERT INTO country VALUES ( 'AR', 'Argentina' );
INSERT INTO country VALUES ( 'AM', 'Armenia' );
INSERT INTO country VALUES ( 'AW', 'Aruba' );
INSERT INTO country VALUES ( 'AU', 'Australia' );
INSERT INTO country VALUES ( 'AT', 'Austria' );
INSERT INTO country VALUES ( 'AZ', 'Azerbaidjan' );
INSERT INTO country VALUES ( 'BH', 'Bahrain' );
INSERT INTO country VALUES ( 'BD', 'Bangladesh' );
INSERT INTO country VALUES ( 'BB', 'Barbados' );
INSERT INTO country VALUES ( 'BY', 'Belarus' );
INSERT INTO country VALUES ( 'BE', 'Belgium' );
INSERT INTO country VALUES ( 'BZ', 'Belize' );
INSERT INTO country VALUES ( 'BJ', 'Benin' );
INSERT INTO country VALUES ( 'BM', 'Bermuda' );
INSERT INTO country VALUES ( 'BT', 'Bhutan' );
INSERT INTO country VALUES ( 'BO', 'Bolivia' );
INSERT INTO country VALUES ( 'BA', 'Bosnia' );
INSERT INTO country VALUES ( 'BW', 'Botswana' );
INSERT INTO country VALUES ( 'BR', 'Brazil' );
INSERT INTO country VALUES ( 'BG', 'Bulgaria' );
INSERT INTO country VALUES ( 'BF', 'Burkina-Faso' );
INSERT INTO country VALUES ( 'BI', 'Burundi' );
INSERT INTO country VALUES ( 'KH', 'Cambodia' );
INSERT INTO country VALUES ( 'CM', 'Cameroon' );
INSERT INTO country VALUES ( 'CA', 'Canada' );
INSERT INTO country VALUES ( 'CL', 'Chile' );
INSERT INTO country VALUES ( 'CN', 'China' );
INSERT INTO country VALUES ( 'TW', 'Chinese-Taipei' );
INSERT INTO country VALUES ( 'CO', 'Colombia' );
INSERT INTO country VALUES ( 'CD', 'Congo' );
INSERT INTO country VALUES ( 'CG', 'Congo-DR' );
INSERT INTO country VALUES ( 'CR', 'Costa-Rica' );
INSERT INTO country VALUES ( 'HR', 'Croatia' );
INSERT INTO country VALUES ( 'CU', 'Cuba' );
INSERT INTO country VALUES ( 'CW', 'Curacao' );
INSERT INTO country VALUES ( 'CY', 'Cyprus' );
INSERT INTO country VALUES ( 'CZ', 'Czech-Republic' );
INSERT INTO country VALUES ( 'DK', 'Denmark' );
INSERT INTO country VALUES ( 'DO', 'Dominican-Republic' );
INSERT INTO country VALUES ( 'EC', 'Ecuador' );
INSERT INTO country VALUES ( 'EG', 'Egypt' );
INSERT INTO country VALUES ( 'SV', 'El-Salvador' );
INSERT INTO country VALUES ( 'GB', 'England' );
INSERT INTO country VALUES ( 'EE', 'Estonia' );
INSERT INTO country VALUES ( 'SZ', 'Eswatini' );
INSERT INTO country VALUES ( 'ET', 'Ethiopia' );
INSERT INTO country VALUES ( 'FO', 'Faroe-Islands' );
INSERT INTO country VALUES ( 'FJ', 'Fiji' );
INSERT INTO country VALUES ( 'FI', 'Finland' );
INSERT INTO country VALUES ( 'FR', 'France' );
INSERT INTO country VALUES ( 'GM', 'Gambia' );
INSERT INTO country VALUES ( 'GE', 'Georgia' );
INSERT INTO country VALUES ( 'DE', 'Germany' );
INSERT INTO country VALUES ( 'GH', 'Ghana' );
INSERT INTO country VALUES ( 'GI', 'Gibraltar' );
INSERT INTO country VALUES ( 'GR', 'Greece' );
INSERT INTO country VALUES ( 'GP', 'Guadeloupe' );
INSERT INTO country VALUES ( 'GT', 'Guatemala' );
INSERT INTO country VALUES ( 'GN', 'Guinea' );
INSERT INTO country VALUES ( 'HT', 'Haiti' );
INSERT INTO country VALUES ( 'HN', 'Honduras' );
INSERT INTO country VALUES ( 'HK', 'Hong-Kong' );
INSERT INTO country VALUES ( 'HU', 'Hungary' );
INSERT INTO country VALUES ( 'IS', 'Iceland' );
INSERT INTO country VALUES ( 'IN', 'India' );
INSERT INTO country VALUES ( 'ID', 'Indonesia' );
INSERT INTO country VALUES ( 'IR', 'Iran' );
INSERT INTO country VALUES ( 'IQ', 'Iraq' );
INSERT INTO country VALUES ( 'IE', 'Ireland' );
INSERT INTO country VALUES ( 'IL', 'Israel' );
INSERT INTO country VALUES ( 'IT', 'Italy' );
INSERT INTO country VALUES ( 'CI', 'Ivory-Coast' );
INSERT INTO country VALUES ( 'JM', 'Jamaica' );
INSERT INTO country VALUES ( 'JP', 'Japan' );
INSERT INTO country VALUES ( 'JO', 'Jordan' );
INSERT INTO country VALUES ( 'KZ', 'Kazakhstan' );
INSERT INTO country VALUES ( 'KE', 'Kenya' );
INSERT INTO country VALUES ( 'XK', 'Kosovo' );
INSERT INTO country VALUES ( 'KW', 'Kuwait' );
INSERT INTO country VALUES ( 'KG', 'Kyrgyzstan' );
INSERT INTO country VALUES ( 'LA', 'Laos' );
INSERT INTO country VALUES ( 'LV', 'Latvia' );
INSERT INTO country VALUES ( 'LB', 'Lebanon' );
INSERT INTO country VALUES ( 'LR', 'Liberia' );
INSERT INTO country VALUES ( 'LY', 'Libya' );
INSERT INTO country VALUES ( 'LI', 'Liechtenstein' );
INSERT INTO country VALUES ( 'LT', 'Lithuania' );
INSERT INTO country VALUES ( 'LU', 'Luxembourg' );
INSERT INTO country VALUES ( 'MK', 'Macedonia' );
INSERT INTO country VALUES ( 'MW', 'Malawi' );
INSERT INTO country VALUES ( 'MY', 'Malaysia' );
INSERT INTO country VALUES ( 'MV', 'Maldives' );
INSERT INTO country VALUES ( 'ML', 'Mali' );
INSERT INTO country VALUES ( 'MT', 'Malta' );
INSERT INTO country VALUES ( 'MR', 'Mauritania' );
INSERT INTO country VALUES ( 'MU', 'Mauritius' );
INSERT INTO country VALUES ( 'MX', 'Mexico' );
INSERT INTO country VALUES ( 'MD', 'Moldova' );
INSERT INTO country VALUES ( 'MN', 'Mongolia' );
INSERT INTO country VALUES ( 'ME', 'Montenegro' );
INSERT INTO country VALUES ( 'MA', 'Morocco' );
INSERT INTO country VALUES ( 'MM', 'Myanmar' );
INSERT INTO country VALUES ( 'NA', 'Namibia' );
INSERT INTO country VALUES ( 'NP', 'Nepal' );
INSERT INTO country VALUES ( 'NL', 'Netherlands' );
INSERT INTO country VALUES ( 'NZ', 'New-Zealand' );
INSERT INTO country VALUES ( 'NI', 'Nicaragua' );
INSERT INTO country VALUES ( 'NG', 'Nigeria' );
INSERT INTO country VALUES ( 'NO', 'Norway' );
INSERT INTO country VALUES ( 'OM', 'Oman' );
INSERT INTO country VALUES ( 'PK', 'Pakistan' );
INSERT INTO country VALUES ( 'PS', 'Palestine' );
INSERT INTO country VALUES ( 'PA', 'Panama' );
INSERT INTO country VALUES ( 'PY', 'Paraguay' );
INSERT INTO country VALUES ( 'PE', 'Peru' );
INSERT INTO country VALUES ( 'PH', 'Philippines' );
INSERT INTO country VALUES ( 'PL', 'Poland' );
INSERT INTO country VALUES ( 'PT', 'Portugal' );
INSERT INTO country VALUES ( 'QA', 'Qatar' );
INSERT INTO country VALUES ( 'RO', 'Romania' );
INSERT INTO country VALUES ( 'RU', 'Russia' );
INSERT INTO country VALUES ( 'RW', 'Rwanda' );
INSERT INTO country VALUES ( 'SM', 'San-Marino' );
INSERT INTO country VALUES ( 'SA', 'Saudi-Arabia' );
INSERT INTO country VALUES ( 'SN', 'Senegal' );
INSERT INTO country VALUES ( 'RS', 'Serbia' );
INSERT INTO country VALUES ( 'SG', 'Singapore' );
INSERT INTO country VALUES ( 'SK', 'Slovakia' );
INSERT INTO country VALUES ( 'SI', 'Slovenia' );
INSERT INTO country VALUES ( 'SO', 'Somalia' );
INSERT INTO country VALUES ( 'ZA', 'South-Africa' );
INSERT INTO country VALUES ( 'KR', 'South-Korea' );
INSERT INTO country VALUES ( 'ES', 'Spain' );
INSERT INTO country VALUES ( 'SD', 'Sudan' );
INSERT INTO country VALUES ( 'SR', 'Surinam' );
INSERT INTO country VALUES ( 'SE', 'Sweden' );
INSERT INTO country VALUES ( 'CH', 'Switzerland' );
INSERT INTO country VALUES ( 'SY', 'Syria' );
INSERT INTO country VALUES ( 'TJ', 'Tajikistan' );
INSERT INTO country VALUES ( 'TZ', 'Tanzania' );
INSERT INTO country VALUES ( 'TH', 'Thailand' );
INSERT INTO country VALUES ( 'TT', 'Trinidad-And-Tobago' );
INSERT INTO country VALUES ( 'TN', 'Tunisia' );
INSERT INTO country VALUES ( 'TR', 'Turkey' );
INSERT INTO country VALUES ( 'TM', 'Turkmenistan' );
INSERT INTO country VALUES ( 'UG', 'Uganda' );
INSERT INTO country VALUES ( 'UA', 'Ukraine' );
INSERT INTO country VALUES ( 'AE', 'United-Arab-Emirates' );
INSERT INTO country VALUES ( 'UY', 'Uruguay' );
INSERT INTO country VALUES ( 'US', 'USA' );
INSERT INTO country VALUES ( 'UZ', 'Uzbekistan' );
INSERT INTO country VALUES ( 'VE', 'Venezuela' );
INSERT INTO country VALUES ( 'VN', 'Vietnam' );
INSERT INTO country VALUES ( 'ZM', 'Zambia' );
INSERT INTO country VALUES ( 'ZW', 'Zimbabwe' );

commit;

/* LEAGUE */

INSERT INTO league VALUES ( 106, 'Ekstraklasa', 'PL' );

commit;

/* STADIUM */

INSERT INTO stadium VALUES ( 1245, 'Stadion Narodowy', 'Aleja Ksiecia J. Poniatowskiego 1', 'PL', 58145, NULL );
INSERT INTO stadium VALUES ( 1254, 'Stadion im. Orla Bialego', 'Aleja Orla Bialego 1', 'PL', 6244, NULL );
INSERT INTO stadium VALUES ( 1249, 'Stadion Miejski', 'ul. Sloneczna 1', 'PL', 22372, NULL );
INSERT INTO stadium VALUES ( 18628, 'Tarczynski Arena', 'al. Slaska 1', 'PL', 42771, NULL );
INSERT INTO stadium VALUES ( 1258, 'Stadion Miejski im. Henryka Reymana', 'ul. Reymonta 22', 'PL', 33268, NULL );
INSERT INTO stadium VALUES ( 1253, 'Stadion Miejski Legii Warszawa', 'ul. Lazienkowska 3', 'PL', 31103, NULL );
INSERT INTO stadium VALUES ( 18625, 'Stadion im. Ernesta Pohla', 'ul. Roosevelta 81', 'PL', 31871, NULL );
INSERT INTO stadium VALUES ( 1259, 'Stadion im. Kazimierza Gorskiego', 'ul. Lukasiewicza 34', 'PL', 12798, NULL );
INSERT INTO stadium VALUES ( 1261, 'Stadion Ludowy', 'ul. Kresowa 1', 'PL', 7500, NULL );
INSERT INTO stadium VALUES ( 18627, 'Polsat Plus Arena Gdansk', 'Pokolen Lechii Gdansk 1', 'PL', 43615, NULL );
INSERT INTO stadium VALUES ( 1246, 'Stadion Miejski', 'ul. Olimpijska 5/9, Redlowo', 'PL', 15139, NULL );
INSERT INTO stadium VALUES ( 1260, 'Stadion Zaglebia Lubin', 'ul. Marii Sklodowskiej Curie 98', 'PL', 16068, NULL );
INSERT INTO stadium VALUES ( 1250, 'Suzuki Arena', 'ul. Sciegiennego 8', 'PL', 15550, NULL );
INSERT INTO stadium VALUES ( 18626, 'Stadion Poznan', 'ul. Bulgarska 17', 'PL', 43269, NULL );
INSERT INTO stadium VALUES ( 1256, 'Stadion Miejski im. Floriana Krygiera', 'ul. Karlowicza 28', 'PL', 18027, NULL );
INSERT INTO stadium VALUES ( 1255, 'Stadion Miejski', 'ul. Stefana Okrzei 20', 'PL', 9913, NULL );
INSERT INTO stadium VALUES ( 1247, 'Stadion Cracovii im. Jozefa Pilsudskiego', 'ul. Jozefa Kaluzy 1', 'PL', 15016, NULL );
INSERT INTO stadium VALUES ( 2282, 'Stadion MOSiR', 'ul. Mickiewicza 13', 'PL', 5000, NULL );
INSERT INTO stadium VALUES ( 2283, 'Stadion Miejski Chojnice', 'ul. Mickiewicza 12', 'PL', 4500, NULL );
INSERT INTO stadium VALUES ( 2284, 'Stadion GOS', 'ul. Wita Stwosza 3', 'PL', 2895, NULL );
INSERT INTO stadium VALUES ( 2285, 'Stadion ul. Bukowa', 'ul. Bukowa 1', 'PL', 10052, NULL );
INSERT INTO stadium VALUES ( 2286, 'Stadion Garbarni przy ul. Barskiej', 'ul. Rydlowka 23', 'PL', 4000, NULL );
INSERT INTO stadium VALUES ( 2287, 'Stadion Miejski', 'ul. Harcerska 14b', 'PL', 20000, NULL );
INSERT INTO stadium VALUES ( 18632, 'Stadion Sportowy Bruk-Bet Termalica', 'ul. Nieciecza 150', 'PL', 4666, NULL );
INSERT INTO stadium VALUES ( 2289, 'Stadion Miejski', 'ul. Oleska 51', 'PL', 5500, NULL );
INSERT INTO stadium VALUES ( 2290, 'Stadion Miejski', 'ul. Rychlinskiego 19', 'PL', 15292, NULL );
INSERT INTO stadium VALUES ( 2291, 'Stadion ul. Kusocinskiego', 'ul. Janusza Kusocinskiego 2', 'PL', 2118, NULL );
INSERT INTO stadium VALUES ( 18633, 'Miejski Stadion Pilkarski Rakow', 'ul. Limanowskiego 83', 'PL', 5500, NULL );
INSERT INTO stadium VALUES ( 2293, 'Stadion im. Ojca Wladyslawa Augustynka', 'ul. Kilinskiego 47', 'PL', 7000, NULL );
INSERT INTO stadium VALUES ( 18634, 'Stadion Miejski w Mielcu', 'ul. Solskiego 1', 'PL', 6864, NULL );
INSERT INTO stadium VALUES ( 2295, 'Stadion OSiR', 'ul. Marszalka Jozefa Pilsudskiego 69A', 'PL', 16800, NULL );
INSERT INTO stadium VALUES ( 2296, 'Stadion Miejski', 'ul. Edukacji 7', 'PL', 15300, NULL );
INSERT INTO stadium VALUES ( 10506, 'Stadion Groclinu Dyskobolii', 'ul. Powstancow Chocieszynskich 52', 'PL', 5383, NULL );
INSERT INTO stadium VALUES ( 2298, 'Stadion Miejski', 'ul. Zarzecze 26', 'PL', 4800, NULL );
INSERT INTO stadium VALUES ( 12602, 'Stadion Miejski LKS Lodz', 'Al. Unii Lubelskiej 2', 'PL', 18033, NULL );
INSERT INTO stadium VALUES ( 3241, 'Stadion GKS-u', 'ul. Sportowa 3', 'PL', 5238, NULL );
INSERT INTO stadium VALUES ( 3242, 'Stadion Miejski im. Bronislawa Malinowskiego', 'ul. marsz. Jozefa Pilsudskiego 14', 'PL', 5323, NULL );
INSERT INTO stadium VALUES ( 18635, 'Stadion Lekkoatletyczno-Pilkarski', 'ul. Narutowicza 9', 'PL', 5000, NULL );
INSERT INTO stadium VALUES ( 5053, 'Stadion im. Czeslawa Kobusa', 'ul. Glinki 79', 'PL', 15000, NULL );
INSERT INTO stadium VALUES ( 5054, 'Stadion OSiR', 'Siedlecka 1', 'PL', 2795, NULL );
INSERT INTO stadium VALUES ( 5055, 'Stadion Miejski', 'I Pulku Szwolezerow 15a', 'PL', 6000, NULL );
INSERT INTO stadium VALUES ( 5056, 'Stadion MOSiR ul. Krakusa', 'ul. Krakusa 25', 'PL', 900, NULL );
INSERT INTO stadium VALUES ( 5057, 'Stadion Miejski im. Grzegorza Duneckiego', 'ul. Gen. J. Bema 23/29', 'PL', 6000, NULL );
INSERT INTO stadium VALUES ( 12608, 'Stadion ul. Zielona', 'Zielona 9', 'PL', 1500, NULL );
INSERT INTO stadium VALUES ( 5058, 'Stadion WKS Gryf Wejherowo', 'ul. Sportowa', 'PL', 2500, NULL );
INSERT INTO stadium VALUES ( 5059, 'Stadion Gornik', 'Aleja Jana Pawla II 13', 'PL', 7437, NULL );
INSERT INTO stadium VALUES ( 5061, 'Miejski Stadion Sportowy', 'ul. Swietokrzyska 11', 'PL', 7430, NULL );
INSERT INTO stadium VALUES ( 11952, 'Legia Training Center', 'ul. Legionistow 3', 'PL', 1000, NULL );
INSERT INTO stadium VALUES ( 5063, 'Stadion Miejski', 'ul. Agrykola 8', 'PL', 7000, NULL );
INSERT INTO stadium VALUES ( 5064, 'Stadion Miejski', 'ul. Kardynala Stefana Wyszynskiego 8', 'PL', 4000, NULL );
INSERT INTO stadium VALUES ( 5065, 'Stadion ROSRRiT', 'ul. Jana Pawla II 2a (ul. Polnocna 2a)', 'PL', 8000, NULL );
INSERT INTO stadium VALUES ( 5066, 'Stadion 700-lecia Srody Wielkopolskiej', 'Sportowa 12', 'PL', 3115, NULL );
INSERT INTO stadium VALUES ( 5067, 'Stadion MOSiR', 'ul. Gliwicka 72', 'PL', 10304, NULL );
INSERT INTO stadium VALUES ( 5068, 'Stadion BTS Rekord', 'ul. Startowa 13', 'PL', 2000, NULL );
INSERT INTO stadium VALUES ( 5075, 'Stadion Stal', 'ul. Hetmanska 69', 'PL', 12700, NULL );
INSERT INTO stadium VALUES ( 19234, 'Osrodek Sportowy Kolejarz', 'ul. Alfreda 1', 'PL', 1500, NULL );
INSERT INTO stadium VALUES ( 5071, 'Stadion Miejski', 'ul. Cicha 6', 'PL', 9500, NULL );
INSERT INTO stadium VALUES ( 5073, 'Stadion OSiR Wisla', 'al. Niepodleglosci 2', 'PL', 3676, NULL );
INSERT INTO stadium VALUES ( 5074, 'Stadion MOSiR', 'ul. Sportowa 1', 'PL', 2100, NULL );
INSERT INTO stadium VALUES ( 11362, 'Podkarpackie Centrum Pilki Noznej', 'ul. Hutnicza 15', 'PL', 3764, NULL );
INSERT INTO stadium VALUES ( 5077, 'Stadion Miejski', 'ul. Ceglana 1', 'PL', 6000, NULL );
INSERT INTO stadium VALUES ( 5078, 'Stadion OSiR ul. Olimpijska', 'ul. Olimpijska 1 / ul. Mysliborska 1', 'PL', 8000, NULL );
INSERT INTO stadium VALUES ( 5079, 'Stadion Miejski w Skierniewicach', 'Pomologiczna 10', 'PL', 6000, NULL );
INSERT INTO stadium VALUES ( 5080, 'Stadion Miejski Widzewa Lodz', 'al. Pilsudskiego 138', 'PL', 18018, NULL );
INSERT INTO stadium VALUES ( 5082, 'Stadion Znicza (MZOS)', 'ul. Bohaterow Warszawy 4', 'PL', 2000, NULL );
INSERT INTO stadium VALUES ( 6319, 'Stadion Gornik', 'ul. Kopalniana 4', 'PL', 4635, NULL );
INSERT INTO stadium VALUES ( 6320, 'Stadion Amiki Wronki', 'ul. Lesna 15a', 'PL', 5296, NULL );
INSERT INTO stadium VALUES ( 6321, 'Stadion Miejski w Legionowie im. ks. plk. Jana Mrugacza', 'ul. Parkowa 27a', 'PL', 1730, NULL );
INSERT INTO stadium VALUES ( 7194, 'Stadion Wierzbica', NULL, 'PL', 1400, NULL );
INSERT INTO stadium VALUES ( 7195, 'Stadion MKS-u Korsze', 'ul. Wojska Polskiego 39', 'PL', 372, NULL );
INSERT INTO stadium VALUES ( 11337, 'Stadion Miejski im. Zlotej Jedenastki Kazimierza Gorskiego', 'ul. Podwale 1', 'PL', 15000, NULL );
INSERT INTO stadium VALUES ( 11350, 'Stadion MOSiR', 'Mickiewicza 66a, Mikulczyce', 'PL', 13000, NULL );
INSERT INTO stadium VALUES ( 8145, 'Stadion OSiR w Zamosciu', 'ul. Krolowej Jadwigi 8', 'PL', 12000, NULL );
INSERT INTO stadium VALUES ( 8157, 'Stadion OSRiR', 'ul. Lodzka 19-29', 'PL', 6232, NULL );
INSERT INTO stadium VALUES ( 8161, 'Stadion Miejski', 'ul. Sportowa 7', 'PL', 3306, NULL );
INSERT INTO stadium VALUES ( 11351, 'Akademii Pilkarskiej Miedzi', 'ul. Swierkowej', 'PL', 1000, NULL );
INSERT INTO stadium VALUES ( 8179, 'Stadion Pelikan', 'ul. Starzynskiego 6/8', 'PL', 4000, NULL );
INSERT INTO stadium VALUES ( 8183, 'Stadion Miejski im. Jozefa Pilsudskiego', 'Tysiaclecia 74', 'PL', 700, NULL );
INSERT INTO stadium VALUES ( 11352, 'Stadion Szombierek Bytom', 'ul. Andrzeja Frycza Modrzewskiego 3', 'PL', 20000, NULL );
INSERT INTO stadium VALUES ( 8186, 'Gminny Stadion Sportowy', 'Abrahama 11', 'PL', 2000, NULL );
INSERT INTO stadium VALUES ( 8189, 'Stadion 1 Maja', 'ul. 1 Maja 14', 'PL', 958, NULL );
INSERT INTO stadium VALUES ( 8190, 'Stadion Miejski', 'ul. Rozwadzka', 'PL', 3500, NULL );
INSERT INTO stadium VALUES ( 8202, 'Stadion im. Wlodzimierza Smolarka', 'ul. 11-go Listopada 98', 'PL', 2086, NULL );
INSERT INTO stadium VALUES ( 8203, 'Stadion Sokola Ostroda', '3 Maja 19', 'PL', 4998, NULL );
INSERT INTO stadium VALUES ( 5062, 'Stadion Miejski', 'ul. Sportowa 66', 'PL', 3400, NULL );
INSERT INTO stadium VALUES ( 8225, 'Stadion Miejski', 'ul. Glowna 40', 'PL', 3828, NULL );
INSERT INTO stadium VALUES ( 8239, 'Stadion Miejski przy Zespole Szkol nr 1', 'ul. Sportowa 1', 'PL', 500, NULL );
INSERT INTO stadium VALUES ( 8240, 'Stadion Oporowska', 'ul. Oporowska 62', 'PL', 8346, NULL );
INSERT INTO stadium VALUES ( 11353, 'Kompleks Pilkarski 1KS Sleza Wroclaw', 'Klokoczycka 5', 'PL', 1000, NULL );
INSERT INTO stadium VALUES ( 8242, 'Stadion Miejski Skolwin', 'Stolczynska 100', 'PL', 2000, NULL );
INSERT INTO stadium VALUES ( 8563, 'Stadion im. Zdzislawa Krzyszkowiaka', 'ul. Gdanska 163', 'PL', 20247, NULL );
INSERT INTO stadium VALUES ( 12727, 'Stadion Jaguar Kokoszki', 'Budowlanych 49/5', 'PL', 1000, NULL );
INSERT INTO stadium VALUES ( 11354, 'Stadion MOSiR', 'ul. Urszuli 3a', 'PL', 11000, NULL );
INSERT INTO stadium VALUES ( 11363, 'Stadion Miejski', 'ul. Warszawska 77', 'PL', 2000, NULL );
INSERT INTO stadium VALUES ( 11355, 'Stadion KS Polonia Nysa', 'Sudecka 23', 'PL', 1500, NULL );
INSERT INTO stadium VALUES ( 9336, 'Stadion MOSiR', 'ul. Legionow 6', 'PL', 2240, NULL );
INSERT INTO stadium VALUES ( 11356, 'Stadion Pniowek', 'Swierczewskiego 16a', 'PL', 1000, NULL );
INSERT INTO stadium VALUES ( 11992, 'Arena Lublin', 'ul. Krochmalna', 'PL', 15500, NULL );
INSERT INTO stadium VALUES ( 11326, 'Stadion Miejski', 'Aleja Mokronoskich 4', 'PL', 1514, NULL );
INSERT INTO stadium VALUES ( 11327, 'Stadion Blonianka', 'Legionow 3', 'PL', 2500, NULL );
INSERT INTO stadium VALUES ( 11328, 'Stadion Huragan', 'Zeromskiego 36', 'PL', 2000, NULL );
INSERT INTO stadium VALUES ( 12153, 'Osrodek Szkoleniowy Jagiellonii Bialystok', 'Elewatorska 4', 'PL', 1000, NULL );
INSERT INTO stadium VALUES ( 11330, 'Stadion Miejski im. Henryka Reymana', 'ul. Kosciuszki 26', 'PL', 3500, NULL );
INSERT INTO stadium VALUES ( 11331, 'Stadion im. Braci Gadajow', 'Nowowiejska 9/27', 'PL', 8000, NULL );
INSERT INTO stadium VALUES ( 11332, 'Stadion Polonii im. generala Kazimierza Sosnkowskiego', 'ul. Konwiktorska 6', 'PL', 7150, NULL );
INSERT INTO stadium VALUES ( 11333, 'Stadion RKS', 'ul. Brzeznicka 23', 'PL', 8000, NULL );
INSERT INTO stadium VALUES ( 11334, 'Stadion Gminny', 'ul. Sosnkowskiego 3', 'PL', 1500, NULL );
INSERT INTO stadium VALUES ( 11335, 'Stadion Miejski w Wasilkowie', 'Supraslska 21', 'PL', 1000, NULL );
INSERT INTO stadium VALUES ( 11336, 'Stadion Wikielec', NULL, 'PL', 1000, NULL );
INSERT INTO stadium VALUES ( 11338, 'Narodowy Stadion Rugby', 'ul. Sportowa 5/9', 'PL', 3425, NULL );
INSERT INTO stadium VALUES ( 11339, 'Stadion ZOS Baltyk Koszalin', 'ul. Andersa 16', 'PL', 4000, NULL );
INSERT INTO stadium VALUES ( 11340, 'Stadion Miejski', 'ul. Matejki 22', 'PL', 3070, NULL );
INSERT INTO stadium VALUES ( 11341, 'Stadion im. Stanislawa Figasa', 'ul. Falata 34', 'PL', 25000, NULL );
INSERT INTO stadium VALUES ( 11342, 'Stadion Miejski', 'ul. Sportowa 6', 'PL', 1984, NULL );
INSERT INTO stadium VALUES ( 11343, 'Stadion Miejski im. Sebastiana Karpiniuka', 'Sliwinskiego 10', 'PL', 3014, NULL );
INSERT INTO stadium VALUES ( 11344, 'Stadion MKS Mieszko Gniezno', 'Strumykowa 8', 'PL', 5000, NULL );
INSERT INTO stadium VALUES ( 11345, 'Stadion OSiR im. Stanislawa Baka', 'ul. Kosciuszki 59', 'PL', 4460, NULL );
INSERT INTO stadium VALUES ( 11346, 'Stadion Miejski', 'Sportowa 1', 'PL', 1000, NULL );
INSERT INTO stadium VALUES ( 11347, 'Stadion Miejski', 'Aleja 600-lecia 21', 'PL', 2000, NULL );
INSERT INTO stadium VALUES ( 11348, 'Stadion Miejski im. Kazimierza Deyny', 'Olimpijczykow Starogardzkich 1', 'PL', 5000, NULL );
INSERT INTO stadium VALUES ( 11349, 'Stadion Miejski', 'ul. Swietego Marcina 1', 'PL', 1500, NULL );
INSERT INTO stadium VALUES ( 11357, 'Stadion w Gaciu', 'Gac 10', 'PL', 600, NULL );
INSERT INTO stadium VALUES ( 12619, 'Panatoni Arena', 'ul. Uzdrowiskowa 41', 'PL', 1500, NULL );
INSERT INTO stadium VALUES ( 11359, 'Stadion Towarzystwa Sportowego Gwarek', 'ul. Wojska Polskiego 2', 'PL', 999, NULL );
INSERT INTO stadium VALUES ( 11360, 'Stadion OSiR', 'ul. Sportowa', 'PL', 900, NULL );
INSERT INTO stadium VALUES ( 11361, 'Stadion OSiR w Swidnicy', 'Slaska 35', 'PL', 4000, NULL );
INSERT INTO stadium VALUES ( 11364, 'Stadion Swidnik', 'Sportowa 2', 'PL', 3000, NULL );
INSERT INTO stadium VALUES ( 11365, 'Boisko przy ul. Wielickiej', 'Wielicka 101', 'PL', 3000, NULL );
INSERT INTO stadium VALUES ( 11366, 'Stadion Jutrzenka Giebultow', 'Sportowa 3', 'PL', 1000, NULL );
INSERT INTO stadium VALUES ( 11367, 'Stadion Korona', 'ul. Szczepaniaka 29', 'PL', 6000, NULL );
INSERT INTO stadium VALUES ( 12620, 'Stadion Miejski w Sokolowie Podlaskim', 'Lipowa 50', 'PL', 1000, NULL );
INSERT INTO stadium VALUES ( 11369, 'Stadion Miejski', 'ul. Sportowa 1', 'PL', 1000, NULL );
INSERT INTO stadium VALUES ( 11370, 'Stadion MOSiR', 'Aleja Niepodleglosci 44', 'PL', 2000, NULL );
INSERT INTO stadium VALUES ( 11371, 'Stadion MOSiR', 'ul. gen. Jozefa Hauke-Bosaka 1', 'PL', 4418, NULL );
INSERT INTO stadium VALUES ( 11372, 'Miejski Stadion Sportowy Sandomierz', 'ul. Kosely 3a', 'PL', 2500, NULL );
INSERT INTO stadium VALUES ( 11373, 'Stadion Miejski', 'Parkowa 1', 'PL', 3000, NULL );
INSERT INTO stadium VALUES ( 18851, 'Stadion Gminny Wiazownica', 'ul. Sportowa', 'PL', 1500, NULL );
INSERT INTO stadium VALUES ( 11374, 'Stadion Miejski w Wolce Pelkinskiej', NULL, 'PL', 800, NULL );
INSERT INTO stadium VALUES ( 12142, 'Stadion w Lagowie', 'ul. Zaplotnia 1', 'PL', 1000, NULL );
INSERT INTO stadium VALUES ( 12019, 'Stadion Miejski', 'ul. Sienkiewicza 1', 'PL', 5000, NULL );
INSERT INTO stadium VALUES ( 7922, 'Stadion Miejski', 'ul. Pulaskiego 5', 'PL', 2460, NULL );
INSERT INTO stadium VALUES ( 12293, 'Stadion Miejski', 'ul. Boguminska 8', 'PL', 6620, NULL );
INSERT INTO stadium VALUES ( 12624, 'Stadion KS Wieczysta', 'Kazimierza Chalupnika 16', 'PL', 1000, NULL );
INSERT INTO stadium VALUES ( 12626, 'Boisko MKS Slask Swietochlowice', 'Lagiewnicka 80', 'PL', 1000, NULL );
INSERT INTO stadium VALUES ( 12155, 'Stadion Miejski', 'Zbylitowska 3', 'PL', 15000, NULL );
INSERT INTO stadium VALUES ( 12704, 'Stadion Miejski MOSIR Gizycko', 'Stanislawa Moniuszki 5', 'PL', 1000, NULL );
INSERT INTO stadium VALUES ( 18845, 'Stadion Miejski', 'ul. 11 Listopada 57', 'PL', 5000, NULL );
INSERT INTO stadium VALUES ( 12154, 'Stadion Miejski', 'ul. Sportowa 4', 'PL', 1000, NULL );
INSERT INTO stadium VALUES ( 18846, 'Akademia LKS Lodz', 'Krancowa 19', 'PL', 1000, NULL );
INSERT INTO stadium VALUES ( 12731, 'Stadion Miejsko-Gminny w Nowych Skalmierzycach', 'Mostowa 1a', 'PL', 1000, NULL );
INSERT INTO stadium VALUES ( 18706, 'Stadion GOTiS', 'ul. Sportowa 1', 'PL', 1010, NULL );
INSERT INTO stadium VALUES ( 18849, 'Stadion Miejski Gubin', 'Generala Sikorskiego 89', 'PL', 3000, NULL );
INSERT INTO stadium VALUES ( 19259, 'Stadion Miejski', 'Zlotnicza 12', 'PL', 1558, NULL );
INSERT INTO stadium VALUES ( 12156, 'Stadion MKS Czarni Polaniec', 'Sportowa 1', 'PL', 900, NULL );
INSERT INTO stadium VALUES ( 12157, 'Stadion Miejski', 'Aleja Sportowa 8', 'PL', 3000, NULL );
INSERT INTO stadium VALUES ( 12392, 'Stadion Kujawiaka Wloclawek', 'ul. Lesna 53A', 'PL', 4840, NULL );
INSERT INTO stadium VALUES ( 12633, 'Stadion GKS Glinik w Gorlicach', 'Henryka Sienkiewicza 15', 'PL', 2000, NULL );
INSERT INTO stadium VALUES ( 12732, 'Stadion Miejski', 'ul. Jozefa Pilsudskiego', 'PL', 12000, NULL );
INSERT INTO stadium VALUES ( 12733, 'Boisko Gedania 1922 Gdansk', 'gen. Jozefa Hallera 201', 'PL', 1000, NULL );
INSERT INTO stadium VALUES ( 19263, 'Stadion Ruch Radzionkow', 'Knosaly 113', 'PL', 1000, NULL );
INSERT INTO stadium VALUES ( 18707, 'Stadion OSiR', 'ul Sportowa 1', 'PL', 2000, NULL );
INSERT INTO stadium VALUES ( 18719, 'Stadion Miejski', 'Klodnicka 58', 'PL', 3000, NULL );
INSERT INTO stadium VALUES ( 18726, 'Stadion Kuzni Ustron', 'Sportowa 3', 'PL', 680, NULL );
INSERT INTO stadium VALUES ( 18847, 'Stadion MOSiR', 'Sportowa 1', 'PL', 2000, NULL );
INSERT INTO stadium VALUES ( 18848, 'Stadion Miejski', 'Swierczewskiego 3', 'PL', 1000, NULL );
INSERT INTO stadium VALUES ( 18850, 'MZKS Glogow Boisko pilkarskie', 'ul. Wita Stwosza 3', 'PL', 2000, NULL );
INSERT INTO stadium VALUES ( 18902, 'Stadion im. Jerzego Michalowicza', 'Wroclawska 47', 'PL', 4500, NULL );

commit;

/* CLUB */

-- LEAGUE: 106 EKSTRAKLASA

INSERT INTO club VALUES ( 336, 'Jagiellonia', 'PL', 464000, 106, 1249 );
INSERT INTO club VALUES ( 337, 'Slask Wroclaw', 'PL', 198000, 106, 18628 );
INSERT INTO club VALUES ( 338, 'Wisla Krakow', 'PL', 747000, 106, 1258 );
INSERT INTO club VALUES ( 339, 'Legia Warszawa', 'PL', 387000, 106, 1253 );
INSERT INTO club VALUES ( 340, 'Gornik Zabrze', 'PL', 928000, 106, 18625 );
INSERT INTO club VALUES ( 341, 'Wisla Plock', 'PL', 863000, 106, 1259 );
INSERT INTO club VALUES ( 343, 'Lechia Gdansk', 'PL', 826000, 106, 18627 );
INSERT INTO club VALUES ( 345, 'Zaglebie Lubin', 'PL', 651000, 106, 1260 );
INSERT INTO club VALUES ( 347, 'Lech Poznan', 'PL', 411000, 106, 18626 );
INSERT INTO club VALUES ( 348, 'Pogon Szczecin', 'PL', 739000, 106, 1256 );
INSERT INTO club VALUES ( 349, 'Piast Gliwice', 'PL', 976000, 106, 1255 );
INSERT INTO club VALUES ( 350, 'Cracovia Krakow', 'PL', 681000, 106, 1247 );
INSERT INTO club VALUES ( 3487, 'Nieciecza', 'PL', 91000, 106, 18632 );
INSERT INTO club VALUES ( 3491, 'Rakow Czestochowa', 'PL', 589000, 106, 18633 );
INSERT INTO club VALUES ( 3493, 'Stal Mielec', 'PL', 936000, 106, 18634 );
INSERT INTO club VALUES ( 3496, 'Warta Poznan', 'PL', 674000, 106, 10506 );
INSERT INTO club VALUES ( 4248, 'Radomiak Radom', 'PL', 519000, 106, 18635 );
INSERT INTO club VALUES ( 6941, 'Gornik Leczna', 'PL', 669000, 106, 5059 );

--NO ERRORS

commit;

/* COACH */

ALTER SESSION SET nls_date_format='yyyy-mm-dd';

-- EKSTRAKLASA

-- TEAM: 336

INSERT INTO coach VALUES ( 1215, 'Ireneusz', 'Mamrot', '1970-12-13', 'PL', 336 );
INSERT INTO coach VALUES ( 5711, 'Piotr', 'Nowak', '1964-07-05', 'PL', 336 );
INSERT INTO coach VALUES ( 7621, 'Rafal', 'Grzyb', '1983-01-16', 'PL', 336 );

--NO ERRORS

-- TEAM: 337

INSERT INTO coach VALUES ( 1242, 'Piotr', 'Tworek', '1975-03-10', 'PL', 337 );
INSERT INTO coach VALUES ( 2862, 'Tadeusz', 'Pawlowski', '1953-10-14', 'PL', 337 );
INSERT INTO coach VALUES ( 8187, 'Jacek', 'Magiera', '1977-01-01', 'PL', 337 );

--NO ERRORS

-- TEAM: 338

INSERT INTO coach VALUES ( 118, 'Jerzy Jozef', 'Brzeczek', '1971-03-18', 'PL', 338 );
INSERT INTO coach VALUES ( 14999, 'Kazimierz', 'Kmiecik', '1951-09-19', 'PL', 338 );

--NO ERRORS

-- TEAM: 339


--ERRORS
INSERT INTO coach VALUES ( 1216, 'Aleksandar', 'Vukovic', '1979-08-25', 'BA', 339 );


-- TEAM: 340

INSERT INTO coach VALUES ( 1227, 'Marcin', 'Brosz', '1973-04-11', 'PL', 340 );
INSERT INTO coach VALUES ( 15260, 'Jan', 'Urban', '1962-05-14', 'PL', 340 );

--NO ERRORS

-- TEAM: 341

INSERT INTO coach VALUES ( 1230, 'Radoslaw', 'Sobolewski', '1976-12-13', 'PL', 341 );
INSERT INTO coach VALUES ( 3148, 'Dariusz', 'Dzwigala', '1969-03-22', 'PL', 341 );
INSERT INTO coach VALUES ( 4457, 'Maciej', 'Bartoszek', '1977-04-12', 'PL', 341 );
INSERT INTO coach VALUES ( 7751, 'Pavol', 'Stano', '1977-09-29', 'SK', 341 );
INSERT INTO coach VALUES ( 16814, 'Lukasz', 'Nadolski', '1987-09-03', 'PL', 341 );

--NO ERRORS

-- TEAM: 343

INSERT INTO coach VALUES ( 2959, 'Tomasz', 'Kaczmarek', '1984-09-20', 'PL', 343 );

--NO ERRORS

-- TEAM: 345

INSERT INTO coach VALUES ( 1219, 'Piotr', 'Stokowiec', '1972-05-25', 'PL', 345 );
INSERT INTO coach VALUES ( 1221, 'Dariusz', 'Zuraw', '1972-11-14', 'PL', 345 );
INSERT INTO coach VALUES ( 1228, 'Ben', 'van Dael', '1965-03-03', 'NL', 345 );
INSERT INTO coach VALUES ( 16414, 'Pawel', 'Karmelita', '1977-08-28', 'PL', 345 );
INSERT INTO coach VALUES ( 17625, 'Orest', 'Lenczyk', '1942-12-28', 'PL', 345 );

--NO ERRORS

-- TEAM: 347

INSERT INTO coach VALUES ( 2864, 'Adam', 'Nawalka', '1957-10-23', 'PL', 347 );
INSERT INTO coach VALUES ( 8956, 'Maciej', 'Skorza', '1972-01-10', 'PL', 347 );
INSERT INTO coach VALUES ( 14420, 'Janusz', 'Gora', '1963-07-08', 'PL', 347 );

--NO ERRORS

-- TEAM: 348

INSERT INTO coach VALUES ( 1217, 'Kosta', 'Runjaic', '1971-06-04', 'DE', 348 );

--NO ERRORS

-- TEAM: 349

INSERT INTO coach VALUES ( 1220, 'Waldemar', 'Fornalik', '1963-04-11', 'PL', 349 );

--NO ERRORS

-- TEAM: 350


--NO ERRORS

-- TEAM: 3487


--ERRORS
INSERT INTO coach VALUES ( 1805, 'Radoslav', 'Latal', '1970-01-06', 'CZ', 3487 );


-- TEAM: 3491

INSERT INTO coach VALUES ( 1222, 'Marek', 'Papszun', '1974-08-08', 'PL', 3491 );

--NO ERRORS

-- TEAM: 3493

INSERT INTO coach VALUES ( 11951, 'Adam', 'Majewski', '1973-12-24', 'PL', 3493 );
INSERT INTO coach VALUES ( 12249, 'Dariusz', 'Skrzypczak', '1967-11-13', 'PL', 3493 );

--NO ERRORS

-- TEAM: 3496

INSERT INTO coach VALUES ( 12298, 'Dawid', 'Szulczek', '1990-01-26', 'PL', 3496 );

--ERRORS
INSERT INTO coach VALUES ( 4453, 'Petr', 'Nemec', '1957-06-07', 'CZ', 3496 );


-- TEAM: 4248

INSERT INTO coach VALUES ( 1251, 'Dariusz', 'Banasik', '1973-07-16', 'PL', 4248 );
INSERT INTO coach VALUES ( 3147, 'Mariusz', 'Lewandowski', '1979-05-18', 'PL', 4248 );

--NO ERRORS

-- TEAM: 6941

INSERT INTO coach VALUES ( 4454, 'Kamil', 'Kieres', '1974-07-16', 'PL', 6941 );
INSERT INTO coach VALUES ( 8949, 'Piotr', 'Mazurkiewicz', '1984-03-16', 'PL', 6941 );
INSERT INTO coach VALUES ( 17106, 'Marcin', 'Prasol', '1980-10-12', 'PL', 6941 );

--NO ERRORS
commit;

/* POSITION */

INSERT INTO position VALUES ( 1, 'Bramkarz' );
INSERT INTO position VALUES ( 2, 'Obronca' );
INSERT INTO position VALUES ( 3, 'Pomocnik' );
INSERT INTO position VALUES ( 4, 'Napastnik' );


/* PLAYER_STATS */


/* PLAYER */
ALTER SESSION SET nls_date_format='yyyy-mm-dd';
-- LEAGUE: 106 EKSTRAKLASA

INSERT INTO player_stats VALUES (  40277, 54, 56, 27, 73, 48, 80, 45 );
INSERT INTO player VALUES ( 40277, 'Bartlomiej', 'Sielewski', '1984-08-09', 341, 2, 'PL' );
INSERT INTO player_stats VALUES (  40432, 68, 90, 75, 59, 81, 27, 76 );
INSERT INTO player VALUES ( 40432, 'Karol', 'Stanek', '1999-10-03', 349, 4, 'PL' );
INSERT INTO player_stats VALUES (  40740, 73, 85.0, 67.0, 81.0, 77.0, 58.0, 71.0 );
INSERT INTO player VALUES ( 40740, 'Hubert', 'Gostomski', '1998-02-25', 336, 1, 'PL' );
INSERT INTO player_stats VALUES (  40762, 67, 86, 87, 62, 83, 15, 74 );
INSERT INTO player VALUES ( 40762, 'Lukasz', 'Krakowczyk', '1998-02-21', 349, 4, 'PL' );
INSERT INTO player_stats VALUES (  40855, 63, 58, 64, 69, 60, 51, 78 );
INSERT INTO player VALUES ( 40855, 'Bartosz', 'Kalupa', '1998-06-16', 3496, 3, 'PL' );
INSERT INTO player_stats VALUES (  48075, 61, 81, 70, 51, 73, 35, 60 );
INSERT INTO player VALUES ( 48075, 'Pawel', 'Cibicki', '1994-01-09', 348, 4, 'SE' );
INSERT INTO player_stats VALUES (  53524, 57, 50, 22, 68, 47, 83, 76 );
INSERT INTO player VALUES ( 53524, 'Maciej', 'Wilusz', '1988-09-25', 3491, 2, 'PL' );
INSERT INTO player_stats VALUES (  148639, 70, 71.0, 72.0, 71.0, 76.0, 56.0, 79.0 );
INSERT INTO player VALUES ( 148639, 'Patryk', 'Rojek', '1999-04-18', 6941, 1, 'PL' );
INSERT INTO player_stats VALUES (  148640, 68, 61, 33, 77, 55, 100, 84 );
INSERT INTO player VALUES ( 148640, 'Jakub', 'Jaroszynski', '2000-01-22', 6941, 2, 'PL' );
INSERT INTO player_stats VALUES (  148653, 60, 68, 90, 66, 49, 33, 59 );
INSERT INTO player VALUES ( 148653, 'Jakub', 'Cielebak', '2002-10-01', 6941, 4, 'PL' );
INSERT INTO player_stats VALUES (  159130, 63, 58.0, 66.0, 72.0, 65.0, 58.0, 62.0 );
INSERT INTO player VALUES ( 159130, 'Damian', 'Pawelski', '1999-04-15', 3487, 1, 'PL' );
INSERT INTO player_stats VALUES (  261674, 66, 84, 49, 75, 62, 68, 59 );
INSERT INTO player VALUES ( 261674, 'Athanasios Augustus', 'Scheidt', '1998-03-24', 4248, 3, 'US' );
INSERT INTO player_stats VALUES (  270840, 74, 79, 51, 74, 91, 65, 88 );
INSERT INTO player VALUES ( 270840, 'Jakub', 'Gut', '2003-05-13', 350, 3, 'PL' );
INSERT INTO player_stats VALUES (  275657, 65, 74, 76, 57, 89, 24, 73 );
INSERT INTO player VALUES ( 275657, 'Morimakan', 'Diane', '1999-02-25', 4248, 4, 'FR' );
INSERT INTO player_stats VALUES (  281962, 67, 67.0, 82.0, 67.0, 62.0, 64.0, 64.0 );
INSERT INTO player VALUES ( 281962, 'Marcel', 'Mendes-Dudzinski', '2005-05-14', 348, 1, 'PL' );
INSERT INTO player_stats VALUES (  290644, 60, 60, 48, 59, 44, 76, 76 );
INSERT INTO player VALUES ( 290644, 'Szymon', 'Pankiewicz', '2001-02-09', 336, 2, 'PL' );
INSERT INTO player_stats VALUES (  296034, 66, 67, 62, 71, 64, 85, 47 );
INSERT INTO player VALUES ( 296034, 'Jan', 'Ziewiec', '2004-05-13', 350, 3, 'PL' );
INSERT INTO player_stats VALUES (  301777, 68, 66.0, 67.0, 74.0, 52.0, 69.0, 82.0 );
INSERT INTO player VALUES ( 301777, 'Norbert', 'Luczak', '2003-08-11', 350, 1, 'PL' );
INSERT INTO player_stats VALUES (  302920, 75, 88, 68, 67, 73, 66, 93 );
INSERT INTO player VALUES ( 302920, 'Maciej', 'Mrozik', '2005-05-05', 350, 3, 'PL' );
INSERT INTO player_stats VALUES (  321636, 66, 61.0, 72.0, 60.0, 51.0, 82.0, 74.0 );
INSERT INTO player VALUES ( 321636, 'Michal', 'Bodys', '1999-03-21', 349, 1, 'PL' );
INSERT INTO player_stats VALUES (  18859, 69, 70.0, 70.0, 63.0, 67.0, 66.0, 81.0 );
INSERT INTO player VALUES ( 18859, 'Artur', 'Boruc', '1980-02-20', 339, 1, 'PL' );
INSERT INTO player_stats VALUES (  24943, 67, 76, 85, 64, 73, 36, 73 );
INSERT INTO player VALUES ( 24943, 'Waldemar', 'Sobota', '1987-05-19', 337, 4, 'PL' );
INSERT INTO player_stats VALUES (  26338, 68, 68, 84, 60, 66, 71, 62 );
INSERT INTO player VALUES ( 26338, 'Marcos', 'Alvarez', '1991-09-30', 350, 3, 'DE' );
INSERT INTO player_stats VALUES (  40424, 70, 73, 60, 71, 68, 80, 69 );
INSERT INTO player VALUES ( 40424, 'Aleksander', 'Jagiello', '1995-02-02', 6941, 3, 'PL' );
INSERT INTO player_stats VALUES (  40656, 70, 76.0, 80.0, 62.0, 64.0, 72.0, 69.0 );
INSERT INTO player VALUES ( 40656, 'Damian', 'Primel', '1992-04-16', 3493, 1, 'PL' );
INSERT INTO player_stats VALUES (  40783, 74, 85, 79, 69, 80, 69, 63 );
INSERT INTO player VALUES ( 40783, 'Przemyslaw', 'Mystkowski', '1998-04-25', 336, 3, 'PL' );
INSERT INTO player_stats VALUES (  53603, 66, 53, 61, 63, 78, 78, 67 );
INSERT INTO player VALUES ( 53603, 'Jewgienij', 'Baszkirow', '1991-07-06', 345, 3, 'RU' );
INSERT INTO player_stats VALUES (  63608, 69, 71, 55, 70, 65, 67, 89 );
INSERT INTO player VALUES ( 63608, 'Mykola', 'Musolitin', '1999-01-21', 343, 3, 'UA' );
INSERT INTO player_stats VALUES (  125325, 60, 68, 73, 64, 79, 14, 67 );
INSERT INTO player VALUES ( 125325, 'Przemyslaw', 'Zdybowicz', '2000-01-10', 338, 4, 'PL' );
INSERT INTO player_stats VALUES (  125326, 61, 34, 43, 66, 60, 86, 77 );
INSERT INTO player VALUES ( 125326, 'Meik Adalbert', 'Karwot', '1993-02-27', 4248, 2, 'DE' );
INSERT INTO player_stats VALUES (  129112, 65, 83, 71, 71, 49, 72, 49 );
INSERT INTO player VALUES ( 129112, 'Michal', 'Rakowiecki', '2001-02-18', 349, 3, 'PL' );
INSERT INTO player_stats VALUES (  129540, 59, 75, 64, 46, 77, 15, 79 );
INSERT INTO player VALUES ( 129540, 'Krzysztof', 'Kiklaisz', '1998-04-13', 340, 4, 'PL' );
INSERT INTO player_stats VALUES (  153376, 56, 46, 30, 76, 45, 69, 71 );
INSERT INTO player VALUES ( 153376, 'Mateusz', 'Supryn', '1999-04-04', 350, 2, 'PL' );
INSERT INTO player_stats VALUES (  262633, 75, 100, 90, 74, 100, 25, 65 );
INSERT INTO player VALUES ( 262633, 'Przemyslaw', 'Oziebala', '1986-08-24', 3491, 4, 'PL' );
INSERT INTO player_stats VALUES (  268680, 71, 100, 73, 71, 83, 22, 78 );
INSERT INTO player VALUES ( 268680, 'Michal', 'Litwa', '2004-04-19', 3491, 4, 'PL' );
INSERT INTO player_stats VALUES (  301774, 63, 50, 37, 69, 62, 97, 67 );
INSERT INTO player VALUES ( 301774, 'Maksym', 'Gendera', '2000-02-10', 349, 2, 'PL' );
INSERT INTO player_stats VALUES (  301775, 75, 65, 76, 82, 71, 80, 77 );
INSERT INTO player VALUES ( 301775, 'Michal', 'Zachcial', '1999-08-25', 349, 3, 'PL' );
INSERT INTO player_stats VALUES (  309443, 66, 64, 58, 73, 75, 68, 63 );
INSERT INTO player VALUES ( 309443, 'Eryk', 'Galara', '2000-12-23', 3493, 3, 'PL' );
INSERT INTO player_stats VALUES (  323618, 62, 64, 20, 72, 59, 90, 70 );
INSERT INTO player VALUES ( 323618, 'Gabor', 'Zukowski', '2002-03-12', 336, 2, 'PL' );
INSERT INTO player_stats VALUES (  353732, 71, 100, 88, 66, 67, 26, 81 );
INSERT INTO player VALUES ( 353732, 'Jan', 'Faberski', '2006-04-22', 336, 4, 'PL' );
INSERT INTO player_stats VALUES (  25096, 66, 66, 63, 60, 75, 65, 71 );
INSERT INTO player VALUES ( 25096, 'Dominik', 'Wydra', '1994-03-21', 3491, 3, 'AT' );
INSERT INTO player_stats VALUES (  40454, 66, 79, 49, 65, 57, 80, 69 );
INSERT INTO player VALUES ( 40454, 'Mateusz', 'Sopocko', '1999-06-26', 3496, 3, 'PL' );
INSERT INTO player_stats VALUES (  40566, 63, 67, 57, 63, 61, 62, 73 );
INSERT INTO player VALUES ( 40566, 'Lukasz', 'Tralka', '1984-05-11', 3496, 3, 'PL' );
INSERT INTO player_stats VALUES (  40696, 70, 63, 73, 82, 71, 58, 75 );
INSERT INTO player VALUES ( 40696, 'Radoslaw', 'Kanach', '1999-04-03', 350, 3, 'PL' );
INSERT INTO player_stats VALUES (  128646, 74, 68, 88, 75, 83, 70, 63 );
INSERT INTO player VALUES ( 128646, 'Maciej', 'Swidzikowski', '1989-09-09', 4248, 3, 'PL' );
INSERT INTO player_stats VALUES (  161831, 69, 70, 56, 80, 55, 85, 71 );
INSERT INTO player VALUES ( 161831, 'Iwo', 'Kaczmarski', '2004-04-16', 3491, 3, 'PL' );
INSERT INTO player_stats VALUES (  216598, 63, 60, 40, 63, 45, 98, 73 );
INSERT INTO player VALUES ( 216598, 'Mateusz', 'Pienczak', '2003-01-09', 350, 2, 'PL' );
INSERT INTO player_stats VALUES (  269859, 69, 68.0, 70.0, 76.0, 74.0, 66.0, 65.0 );
INSERT INTO player VALUES ( 269859, 'Dariusz', 'Krzysztofek', '2000-04-09', 348, 1, 'PL' );
INSERT INTO player_stats VALUES (  269879, 60, 51.0, 46.0, 62.0, 59.0, 66.0, 81.0 );
INSERT INTO player VALUES ( 269879, 'Wiktor', 'Koptas', '2004-10-20', 4248, 1, 'PL' );
INSERT INTO player_stats VALUES (  286469, 61, 68, 39, 80, 50, 58, 74 );
INSERT INTO player VALUES ( 286469, 'Jakub', 'Goralczyk', '2002-09-14', 350, 2, 'PL' );
INSERT INTO player_stats VALUES (  290643, 66, 68.0, 65.0, 52.0, 68.0, 68.0, 76.0 );
INSERT INTO player VALUES ( 290643, 'Jakub', 'Jasionek', '2004-07-02', 336, 1, 'PL' );
INSERT INTO player_stats VALUES (  300955, 61, 59, 44, 73, 41, 74, 79 );
INSERT INTO player VALUES ( 300955, 'Michal', 'Wisniewski', '1999-05-02', 350, 2, 'PL' );

INSERT INTO player VALUES ( 304052, 'Jakub', 'Orpik', '2003-10-26', 336, NULL, 'PL' );
INSERT INTO player VALUES ( 323505, 'Oliwier', 'Hyla', '2004-08-24', 350, NULL, 'PL' );
INSERT INTO player VALUES ( 323511, 'Michal', 'Samborski', '2004-01-20', 336, NULL, 'PL' );
INSERT INTO player VALUES ( 323620, 'Bartosz', 'Bayer', '2001-07-31', 336, NULL, 'PL' );
INSERT INTO player VALUES ( 323621, 'Kamil', 'Duszkiewicz', '2002-03-05', 3493, NULL, 'PL' );
INSERT INTO player VALUES ( 337514, 'Konrad', 'Guca', '2003-08-18', 3493, NULL, 'PL' );
INSERT INTO player VALUES ( 353731, 'Milosz', 'Skowronek', '2005-03-20', 336, NULL, 'PL' );
INSERT INTO player VALUES ( 359404, 'Radoslaw', 'Zysk', '2003-07-16', 336, NULL, 'PL' );
INSERT INTO player VALUES ( 40441, 'Filip', 'Dymerski', '2002-04-05', 343, NULL, 'PL' );
INSERT INTO player VALUES ( 41031, 'Dominik', 'Kakolewski', '1996-06-04', 3487, NULL, 'PL' );
INSERT INTO player VALUES ( 46811, 'Pawel', 'Kieszek', '1984-04-16', 338, NULL, 'PL' );
INSERT INTO player VALUES ( 96256, 'Adam', 'Banasiak', '1989-12-07', 4248, NULL, 'PL' );
INSERT INTO player VALUES ( 122262, 'Kacper', 'Rosa', '1994-08-13', 338, NULL, 'PL' );
INSERT INTO player VALUES ( 128590, 'Jakub', 'Janczy', '2002-03-07', 3487, NULL, 'PL' );
INSERT INTO player VALUES ( 129101, 'Hubert', 'Turski', '2003-01-31', 348, NULL, 'PL' );
INSERT INTO player VALUES ( 264685, 'Dominik', 'Smykowski', '2001-06-14', 3496, NULL, 'PL' );
INSERT INTO player VALUES ( 266533, 'Filip', 'Malek', '2002-01-03', 3496, NULL, 'PL' );
INSERT INTO player VALUES ( 269870, 'Eryk', 'Mirus', '2003-09-19', 343, NULL, 'PL' );
INSERT INTO player VALUES ( 269904, 'Bartosz', 'Snopczynski', '2001-06-01', 3487, NULL, 'PL' );
INSERT INTO player VALUES ( 271863, 'Leo', 'Przybylak', '2004-05-28', 3496, NULL, 'PL' );
INSERT INTO player VALUES ( 296087, 'Piotr', 'Owczarek', '2002-10-01', 3491, NULL, 'PL' );
INSERT INTO player VALUES ( 323508, 'Bartlomiej', 'Korbecki', '2002-02-23', 340, NULL, 'PL' );
INSERT INTO player VALUES ( 323515, 'Patryk', 'Prange', '2002-07-05', 3496, NULL, 'PL' );
INSERT INTO player VALUES ( 323622, 'Szymon', 'Soinski', '2003-05-08', 3496, NULL, 'PL' );
INSERT INTO player VALUES ( 346812, 'Mikolaj', 'Stangel', '2004-08-29', 3496, NULL, 'PL' );
INSERT INTO player VALUES ( 346894, 'Alexander', 'Steffen', '2004-04-06', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 353730, 'Nikodem', 'Zielonka', '2004-08-17', 340, NULL, 'PL' );
INSERT INTO player VALUES ( 357136, 'Kacper', 'Pankowski', '2003-11-10', 4248, NULL, 'PL' );
INSERT INTO player VALUES ( 1712, 'Richard', 'Strebinger', '1993-02-14', 339, NULL, 'AT' );
INSERT INTO player VALUES ( 40247, 'Jan', 'Szpaderski', '1998-08-31', 4248, NULL, 'PL' );
INSERT INTO player VALUES ( 40332, 'Piotr Oliver', 'Celeban', '1985-06-25', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 40526, 'Damian', 'Oko', '1997-01-22', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 40626, 'Franciszek', 'Wroblewski', '2000-10-10', 4248, NULL, 'PL' );
INSERT INTO player VALUES ( 41505, 'Fabio Miguel', 'dos Santos Sturgeon', '1994-02-04', 3491, NULL, 'PT' );
INSERT INTO player VALUES ( 46752, 'Nikola', 'Stojiljkovic', '1992-08-17', 349, NULL, 'RS' );
INSERT INTO player VALUES ( 46765, 'Aleksandar', 'Pantic', '1992-04-11', 345, NULL, 'RS' );
INSERT INTO player VALUES ( 96250, 'Konrad', 'Wrzesinski', '1993-09-10', 3493, NULL, 'PL' );
INSERT INTO player VALUES ( 96297, 'Tomasz', 'Midzierski', '1985-06-05', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 122258, 'Michal', 'Orzechowski', '2001-05-22', 3487, NULL, 'PL' );
INSERT INTO player VALUES ( 148647, 'Michal', 'Golinski', '2000-03-05', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 148651, 'Tomasz', 'Tymosiak', '1993-03-19', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 216610, 'Marcin', 'Szeibe', '2000-07-08', 3496, NULL, 'PL' );
INSERT INTO player VALUES ( 281298, 'Jakub', 'Nowaczek', '2002-03-30', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 298140, 'Maksymilian Pawel', 'Boruc', '2002-11-15', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 323506, 'Arsen', 'Hrosu', '2001-04-13', 340, NULL, 'UA' );
INSERT INTO player VALUES ( 323507, 'Dariusz', 'Stalmach', '2005-12-08', 340, NULL, 'PL' );
INSERT INTO player VALUES ( 323512, 'Ehor', 'Matsenko', '2002-01-23', 339, NULL, 'UA' );
INSERT INTO player VALUES ( 368135, 'Marcel', 'Obroslak', '2003-02-25', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 40325, 'Aleksandar', 'Lyubomirov Kolev', '1992-12-08', 3493, NULL, 'BG' );
INSERT INTO player VALUES ( 40493, 'Oleksii', 'Dytyatyev', '1988-11-07', 350, NULL, 'UA' );
INSERT INTO player VALUES ( 40514, 'Filip', 'Piszczek', '1995-05-26', 336, NULL, 'PL' );
INSERT INTO player VALUES ( 40608, 'Daniel', 'Bartl', '1989-07-05', 3491, NULL, NULL );
INSERT INTO player VALUES ( 40618, 'Igor', 'Sapala', '1995-10-11', 3491, NULL, 'PL' );
INSERT INTO player VALUES ( 40781, 'Milosz', 'Kozak', '1997-05-23', 4248, NULL, 'PL' );
INSERT INTO player VALUES ( 40941, 'Maciej', 'Palaszewski', '1998-04-07', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 47014, 'Tomas', 'Pekhart', '1989-05-26', 339, NULL, NULL );
INSERT INTO player VALUES ( 61363, 'Frank Andersson', 'Castaneda Velez', '1994-07-17', 3496, NULL, 'CO' );
INSERT INTO player VALUES ( 66213, 'Michal', 'Bezpalec', '1996-08-19', 3487, NULL, NULL );
INSERT INTO player VALUES ( 72463, 'Amancio Jose', 'Pinto Fortes', '1990-04-18', 4248, NULL, 'PT' );
INSERT INTO player VALUES ( 72472, 'Joalisson', 'Santos Oliveira', '1991-03-31', 4248, NULL, 'BR' );
INSERT INTO player VALUES ( 73403, 'Jasurbek', 'Jumaboy o`g`li Yaxshiboyev', '1997-06-24', 339, NULL, 'UZ' );
INSERT INTO player VALUES ( 80415, 'Martin', 'Zeman', '1989-03-28', 3487, NULL, NULL );
INSERT INTO player VALUES ( 104824, 'Ian', 'Pino Soler', '1996-01-23', 345, NULL, 'ES' );
INSERT INTO player VALUES ( 119200, 'Michal', 'Rostkowski', '2000-08-10', 340, NULL, 'PL' );
INSERT INTO player VALUES ( 125644, 'Daniel Marek', 'Scislak', '2000-03-13', 340, NULL, 'PL' );
INSERT INTO player VALUES ( 127659, 'Alejandro', 'Serrano Garcia', '1995-02-06', 6941, NULL, 'ES' );
INSERT INTO player VALUES ( 137073, 'David', 'Tosevski', '2001-07-16', 340, NULL, NULL );
INSERT INTO player VALUES ( 181852, 'Mario', 'Rodriguez Ruiz', '1997-03-03', 3496, NULL, 'ES' );
INSERT INTO player VALUES ( 1549, 'Daniel', 'Quintana Sosa', '1987-03-08', 336, NULL, 'ES' );
INSERT INTO player VALUES ( 8067, 'Ilya', 'Shkurin', '1999-08-17', 3491, NULL, 'BY' );
INSERT INTO player VALUES ( 10452, 'Gerson', 'Guimaraes Ferreira Junior', '1992-01-07', 6941, NULL, 'BR' );
INSERT INTO player VALUES ( 10995, 'Bozidar', 'Brankov Czorbadzijski', '1995-08-08', 3493, NULL, 'BG' );
INSERT INTO player VALUES ( 11137, 'Alasana', 'Manneh', '1998-04-08', 340, NULL, 'GM' );
INSERT INTO player VALUES ( 25328, 'Aron', 'Johannsson', '1990-11-10', 347, NULL, 'US' );
INSERT INTO player VALUES ( 40256, 'Mateusz', 'Zyro', '1998-10-28', 3493, NULL, 'PL' );
INSERT INTO player VALUES ( 40319, 'Michal Jan', 'Nalepa', '1995-03-24', 336, NULL, 'PL' );
INSERT INTO player VALUES ( 40345, 'Lubambo', 'Musonda', '1995-03-01', 337, NULL, 'ZM' );
INSERT INTO player VALUES ( 40382, 'Vamara', 'Sanogo', '1995-04-22', 340, NULL, 'FR' );
INSERT INTO player VALUES ( 40396, 'Luis Augusto', 'Martins Rocha', '1993-06-27', 350, NULL, 'PT' );
INSERT INTO player VALUES ( 40899, 'Pawel', 'Baranowski', '1990-10-11', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 40901, 'Serafin Jan', 'Szota', '1999-03-04', 338, NULL, 'PL' );
INSERT INTO player VALUES ( 45836, 'Aleksandar', 'Scekic', '1991-12-12', 345, NULL, 'ME' );
INSERT INTO player VALUES ( 48296, 'Eddie Albin Alexander', 'Granlund', '1989-09-01', 3493, NULL, 'FI' );
INSERT INTO player VALUES ( 61408, 'Aschraf', 'El Mahdioui', '1996-05-24', 338, NULL, 'NL' );
INSERT INTO player VALUES ( 96646, 'Tiago Alexandre', 'Mendes Alves', '1996-06-19', 349, NULL, 'PT' );
INSERT INTO player VALUES ( 104478, 'Gabriel Eugen', 'Matei', '1990-02-26', 6941, NULL, 'RO' );
INSERT INTO player VALUES ( 107020, 'Ruben', 'Lopez Huesca', '1995-06-24', 350, NULL, 'ES' );
INSERT INTO player VALUES ( 139896, 'Przemyslaw', 'Banaszak', '1997-05-10', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 3004, 'Michal', 'Pazdan', '1987-09-21', 336, NULL, 'PL' );
INSERT INTO player VALUES ( 8697, 'Bojan', 'Nastic', '1994-07-06', 336, NULL, NULL );
INSERT INTO player VALUES ( 40435, 'Zlatan', 'Alomerovic', '1991-06-15', 336, NULL, 'RS' );
INSERT INTO player VALUES ( 40448, 'Patryk', 'Lipski', '1994-06-12', 349, NULL, 'PL' );
INSERT INTO player VALUES ( 40471, 'Ivan', 'Runje', '1990-10-09', 336, NULL, 'HR' );
INSERT INTO player VALUES ( 40532, 'Bartlomiej Radoslaw', 'Pawlowski', '1992-11-13', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 40565, 'Mateusz', 'Skrzypczak', '2000-08-22', 347, NULL, 'PL' );
INSERT INTO player VALUES ( 40579, 'Hubert', 'Matynia', '1995-11-04', 348, NULL, 'PL' );
INSERT INTO player VALUES ( 40995, 'Kacper', 'Tabis', '2000-01-31', 336, NULL, 'PL' );
INSERT INTO player VALUES ( 41043, 'Pawel', 'Olszewski', '1999-06-07', 336, NULL, 'PL' );
INSERT INTO player VALUES ( 43090, 'Bogdan Ionut', 'Tiru', '1994-03-15', 336, NULL, 'RO' );
INSERT INTO player VALUES ( 104826, 'Victor', 'Moya Martinez', '1997-06-10', 338, NULL, 'ES' );
INSERT INTO player VALUES ( 108491, 'Israel', 'Puerto Pineda', '1993-06-15', 336, NULL, 'ES' );
INSERT INTO player VALUES ( 122257, 'Ernest', 'Terpilowski', '2001-09-14', 3487, NULL, 'PL' );
INSERT INTO player VALUES ( 122259, 'Bartlomiej', 'Wdowik', '2000-09-25', 336, NULL, 'PL' );
INSERT INTO player VALUES ( 148282, 'Jakub', 'Sypek', '2001-04-07', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 148551, 'Lukasz', 'Zjawinski', '2001-07-11', 343, NULL, 'PL' );
INSERT INTO player VALUES ( 296088, 'Milosz', 'Matysik', '2004-04-26', 336, NULL, 'PL' );
INSERT INTO player VALUES ( 341375, 'Slawomir', 'Abramowicz', '2004-06-09', 336, NULL, 'PL' );
INSERT INTO player VALUES ( 364125, 'Patryk', 'Czerech', '2001-04-06', 336, NULL, 'PL' );
INSERT INTO player VALUES ( 40237, 'Mateusz', 'Matras', '1991-01-23', 3493, NULL, 'PL' );
INSERT INTO player VALUES ( 40481, 'Martin', 'Pospisil', '1991-06-26', 336, NULL, NULL );
INSERT INTO player VALUES ( 40482, 'Taras Wiktorowycz', 'Romanczuk', '1991-11-14', 336, NULL, 'PL' );
INSERT INTO player VALUES ( 40485, 'Jesus', 'Imaz Balleste', '1990-09-26', 336, NULL, 'ES' );
INSERT INTO player VALUES ( 40488, 'Maciej', 'Twarowski', '2001-03-13', 336, NULL, 'PL' );
INSERT INTO player VALUES ( 40602, 'Arkadiusz', 'Kasperkiewicz', '1994-09-29', 3493, NULL, 'PL' );
INSERT INTO player VALUES ( 40661, 'Leandro', 'Messias dos Santos', '1983-12-29', 6941, NULL, 'BR' );
INSERT INTO player VALUES ( 40662, 'Krystian', 'Getinger', '1988-08-29', 3493, NULL, 'PL' );
INSERT INTO player VALUES ( 40685, 'Marcin', 'Flis', '1994-02-10', 3493, NULL, 'PL' );
INSERT INTO player VALUES ( 41058, 'Bartosz', 'Bida', '2001-02-21', 336, NULL, 'PL' );
INSERT INTO player VALUES ( 47067, 'Marc', 'Gual Huguet', '1996-03-13', 336, NULL, 'ES' );
INSERT INTO player VALUES ( 53655, 'Fedor', 'Cernych', '1991-05-21', 336, NULL, 'LT' );
INSERT INTO player VALUES ( 66259, 'Tomas', 'Prikryl', '1992-07-04', 336, NULL, NULL );
INSERT INTO player VALUES ( 126896, 'Bartosz', 'Mrozek', '2000-02-23', 3493, NULL, 'PL' );
INSERT INTO player VALUES ( 128601, 'Mateusz', 'Dudek', '2002-12-14', 3493, NULL, 'PL' );
INSERT INTO player VALUES ( 128640, 'Mateusz', 'Kochalski', '2000-07-25', 4248, NULL, 'PL' );
INSERT INTO player VALUES ( 158160, 'Kamil', 'Kruk', '2000-03-13', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 204329, 'Andrzej', 'Trubeha', '1997-11-22', 336, NULL, 'PL' );
INSERT INTO player VALUES ( 290805, 'Oliwier', 'Wojciechowski', '2005-04-05', 336, NULL, 'PL' );
INSERT INTO player VALUES ( 368138, 'Mateusz', 'Kowalski', '2005-07-21', 336, NULL, 'PL' );
INSERT INTO player VALUES ( 7066, 'Constantin', 'Reiner', '1997-07-11', 349, NULL, 'AT' );
INSERT INTO player VALUES ( 40411, 'Frantisek', 'Plach', '1992-03-08', 349, NULL, 'SK' );
INSERT INTO player VALUES ( 40412, 'Jakub', 'Szmatula', '1981-03-22', 349, NULL, 'PL' );
INSERT INTO player VALUES ( 40414, 'Jakub', 'Czerwinski', '1991-08-06', 349, NULL, 'PL' );
INSERT INTO player VALUES ( 40418, 'Tomasz', 'Mokwa', '1993-02-10', 349, NULL, 'PL' );
INSERT INTO player VALUES ( 40426, 'Mateusz', 'Mak', '1991-11-14', 3493, NULL, 'PL' );
INSERT INTO player VALUES ( 40545, 'Karol', 'Szymanski', '1993-06-25', 349, NULL, 'PL' );
INSERT INTO player VALUES ( 40609, 'Maciej', 'Domanski', '1990-09-05', 3493, NULL, 'PL' );
INSERT INTO player VALUES ( 40646, 'Adam', 'Ratajczyk', '2002-06-12', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 40812, 'Piotr', 'Wlazlo', '1989-06-03', 3487, NULL, 'PL' );
INSERT INTO player VALUES ( 40888, 'Pawel', 'Zyra', '1998-04-07', 3487, NULL, 'PL' );
INSERT INTO player VALUES ( 61167, 'Tomas', 'Huk', '1994-12-22', 349, NULL, 'SK' );
INSERT INTO player VALUES ( 61237, 'Jakub', 'Holubek', '1991-01-12', 349, NULL, 'SK' );
INSERT INTO player VALUES ( 148345, 'Ariel Pawel', 'Mosor', '2003-02-19', 349, NULL, 'PL' );
INSERT INTO player VALUES ( 148541, 'Bartlomiej', 'Ciepiela', '2001-05-24', 339, NULL, 'PL' );
INSERT INTO player VALUES ( 189968, 'Miguel', 'Munoz Fernandez', '1996-11-22', 349, NULL, 'ES' );
INSERT INTO player VALUES ( 268702, 'Fryderyk', 'Gerbowski', '2003-01-17', 341, NULL, 'PL' );
INSERT INTO player VALUES ( 295348, 'Przemyslaw', 'Maj', '2003-04-06', 3493, NULL, 'PL' );
INSERT INTO player VALUES ( 300956, 'Michael', 'Wyparlo', '2003-09-25', 3493, NULL, 'PL' );
INSERT INTO player VALUES ( 345106, 'David', 'Poreba', '2002-12-01', 3493, NULL, 'US' );
INSERT INTO player VALUES ( 1328, 'Damian', 'Kadzior', '1992-06-16', 349, NULL, 'PL' );
INSERT INTO player VALUES ( 15895, 'Kamil Antoni', 'Wilczek', '1988-01-14', 349, NULL, 'PL' );
INSERT INTO player VALUES ( 26649, 'Alexandros', 'Katranis', '1998-05-04', 349, NULL, 'GR' );
INSERT INTO player VALUES ( 33259, 'Krzysztof', 'Kaminski', '1990-11-26', 341, NULL, 'PL' );
INSERT INTO player VALUES ( 37470, 'Rauno', 'Sappinen', '1996-01-23', 349, NULL, 'EE' );
INSERT INTO player VALUES ( 40343, 'Michal Lukasz', 'Chrapek', '1992-04-03', 349, NULL, 'PL' );
INSERT INTO player VALUES ( 40423, 'Thomas Nathan', 'Hateley', '1989-09-12', 349, NULL, 'GB' );
INSERT INTO player VALUES ( 40520, 'Sasa', 'Balic', '1990-01-29', 345, NULL, 'ME' );
INSERT INTO player VALUES ( 40675, 'Grzegorz', 'Tomasiewicz', '1996-05-05', 3493, NULL, 'PL' );
INSERT INTO player VALUES ( 40999, 'Bartosz', 'Spiaczka', '1991-08-19', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 41036, 'Adam Jan', 'Chrzanowski', '1999-03-31', 341, NULL, 'PL' );
INSERT INTO player VALUES ( 55958, 'Anton', 'Krivotsyuk', '1998-08-20', 341, NULL, NULL );
INSERT INTO player VALUES ( 61204, 'Tihomir', 'Kostadinov', '1996-03-04', 349, NULL, NULL );
INSERT INTO player VALUES ( 107033, 'Bartlomiej', 'Gradecki', '1999-12-26', 341, NULL, 'PL' );
INSERT INTO player VALUES ( 126797, 'Michal', 'Kaput', '1998-02-18', 349, NULL, 'PL' );
INSERT INTO player VALUES ( 135874, 'Alberto', 'Toril Domingo', '1997-06-01', 349, NULL, 'ES' );
INSERT INTO player VALUES ( 148379, 'Michael', 'Ameyaw', '2000-09-16', 349, NULL, 'PL' );
INSERT INTO player VALUES ( 148448, 'Arkadiusz', 'Pyrka', '2002-09-20', 349, NULL, 'PL' );
INSERT INTO player VALUES ( 323624, 'Oskar', 'Lodzinski', '2004-07-20', 341, NULL, 'PL' );
INSERT INTO player VALUES ( 364327, 'Bartosz', 'Luczak', '2003-03-19', 349, NULL, 'PL' );
INSERT INTO player VALUES ( 1538, 'Jakub', 'Rzezniczak', '1986-10-26', 341, NULL, 'PL' );
INSERT INTO player VALUES ( 15726, 'Filip', 'Lesniak', '1996-05-14', 341, NULL, 'SK' );
INSERT INTO player VALUES ( 26026, 'Mateusz Stefan', 'Lewandowski', '1999-03-04', 341, NULL, 'PL' );
INSERT INTO player VALUES ( 40191, 'Marko', 'Kolar', '1995-05-31', 341, NULL, 'HR' );
INSERT INTO player VALUES ( 40285, 'Dominik Grzegorz', 'Furman', '1992-07-06', 341, NULL, 'PL' );
INSERT INTO player VALUES ( 40290, 'Damian', 'Rasak', '1996-02-08', 341, NULL, 'PL' );
INSERT INTO player VALUES ( 40293, 'Mateusz', 'Szwoch', '1993-03-19', 341, NULL, 'PL' );
INSERT INTO player VALUES ( 40456, 'Rafal', 'Wolski', '1992-11-10', 341, NULL, 'PL' );
INSERT INTO player VALUES ( 40552, 'Piotr', 'Tomasik', '1987-10-31', 341, NULL, 'PL' );
INSERT INTO player VALUES ( 40653, 'Lukasz', 'Sekulski', '1990-11-03', 341, NULL, 'PL' );
INSERT INTO player VALUES ( 61230, 'Kristian', 'Vallo', '1998-06-02', 341, NULL, 'SK' );
INSERT INTO player VALUES ( 128622, 'Dawid', 'Kocyla', '2002-07-23', 3487, NULL, 'PL' );
INSERT INTO player VALUES ( 148348, 'Radoslaw', 'Cielemecki', '2003-02-19', 341, NULL, 'PL' );
INSERT INTO player VALUES ( 178863, 'Aleksander', 'Pawlak', '2001-11-14', 341, NULL, 'PL' );
INSERT INTO player VALUES ( 207820, 'Adrian', 'Szczutowski', '2000-09-12', 3493, NULL, 'PL' );
INSERT INTO player VALUES ( 265823, 'Damian', 'Warchol', '1995-07-19', 341, NULL, 'PL' );
INSERT INTO player VALUES ( 286551, 'Kacper', 'Tobiasz', '2002-11-04', 339, NULL, 'PL' );
INSERT INTO player VALUES ( 323518, 'Dawid', 'Krzyzanski', '2001-11-08', 341, NULL, 'PL' );
INSERT INTO player VALUES ( 333517, 'Tomasz', 'Walczak', '2005-08-17', 341, NULL, 'PL' );
INSERT INTO player VALUES ( 346522, 'Igor', 'Drapinski', '2004-05-31', 341, NULL, 'PL' );
INSERT INTO player VALUES ( 565, 'Yuri', 'Oliveira Ribeiro', '1997-01-24', 339, NULL, 'PT' );
INSERT INTO player VALUES ( 2150, 'Josue Filipe', 'Soares Pesqueira', '1990-09-17', 339, NULL, 'PT' );
INSERT INTO player VALUES ( 2820, 'Filip', 'Mladenovic', '1995-08-15', 339, NULL, 'RS' );
INSERT INTO player VALUES ( 3002, 'Artur Marcin', 'Jedrzejczyk', '1987-11-04', 339, NULL, 'PL' );
INSERT INTO player VALUES ( 3638, 'Ernest', 'Muci', '2001-03-19', 339, NULL, 'AL' );
INSERT INTO player VALUES ( 8782, 'Bartosz', 'Kapustka', '1996-12-23', 339, NULL, 'PL' );
INSERT INTO player VALUES ( 19591, 'Pawel Marek', 'Wszolek', '1992-04-30', 339, NULL, 'PL' );
INSERT INTO player VALUES ( 26736, 'Mattias Erik', 'Johansson', '1992-02-16', 339, NULL, 'SE' );
INSERT INTO player VALUES ( 28338, 'Ihor', 'Kharatin', '1995-02-02', 339, NULL, 'UA' );
INSERT INTO player VALUES ( 38683, 'Karol Stanislaw', 'Niemczycki', '1999-07-05', 350, NULL, 'PL' );
INSERT INTO player VALUES ( 40346, 'Robert', 'Pich', '1988-11-12', 337, NULL, 'SK' );
INSERT INTO player VALUES ( 40386, 'Cezary', 'Miszta', '2001-10-30', 339, NULL, 'PL' );
INSERT INTO player VALUES ( 40428, 'Patryk', 'Sokolowski', '1994-09-25', 339, NULL, 'PL' );
INSERT INTO player VALUES ( 40517, 'Dominik', 'Hladun', '1995-09-17', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 40534, 'Bartosz Piotr', 'Slisz', '1999-03-29', 339, NULL, 'PL' );
INSERT INTO player VALUES ( 40551, 'Thomas', 'Pauck Rogne', '1990-06-29', 347, NULL, 'NO' );
INSERT INTO player VALUES ( 68187, 'Lindsay Marc', 'Rose', '1992-02-08', 339, NULL, 'MU' );
INSERT INTO player VALUES ( 129113, 'Maciej', 'Rosolek', '2001-09-02', 339, NULL, 'PL' );
INSERT INTO player VALUES ( 178708, 'Maik', 'Nawrocki', '2001-02-07', 339, NULL, 'PL' );
INSERT INTO player VALUES ( 301274, 'Jakub', 'Kisiel', '2003-02-05', 339, NULL, 'PL' );
INSERT INTO player VALUES ( 11020, 'David', 'Jablonsky', '1991-10-08', 350, NULL, NULL );
INSERT INTO player VALUES ( 15667, 'Mathias', 'Hebo Rasmussen', '1995-08-02', 350, NULL, 'DK' );
INSERT INTO player VALUES ( 37073, 'Florian', 'Loshaj', '1996-08-13', 350, NULL, 'XK' );
INSERT INTO player VALUES ( 40356, 'Lukas', 'Hrosso', '1987-04-19', 350, NULL, 'SK' );
INSERT INTO player VALUES ( 40497, 'Cornel Emilian', 'Rapa', '1990-01-16', 350, NULL, 'RO' );
INSERT INTO player VALUES ( 40498, 'Michal', 'Siplak', '1996-02-02', 350, NULL, 'SK' );
INSERT INTO player VALUES ( 40499, 'Marcin', 'Budzinski', '1990-07-06', 3493, NULL, 'PL' );
INSERT INTO player VALUES ( 40507, 'Michal', 'Rakoczy', '2002-03-05', 350, NULL, 'PL' );
INSERT INTO player VALUES ( 40702, 'Kamil', 'Ogorzaly', '2000-09-05', 350, NULL, 'PL' );
INSERT INTO player VALUES ( 40952, 'Kamil', 'Pestka', '1998-08-22', 350, NULL, 'PL' );
INSERT INTO player VALUES ( 43074, 'Virgil Eugen', 'Ghita', '1998-06-04', 350, NULL, 'RO' );
INSERT INTO player VALUES ( 48451, 'Otar', 'Kakabadze', '1995-06-27', 350, NULL, 'GE' );
INSERT INTO player VALUES ( 63926, 'Adam', 'Wilk', '1997-11-21', 350, NULL, 'PL' );
INSERT INTO player VALUES ( 64100, 'Thiago', 'Rodrigues de Souza', '1997-03-18', 350, NULL, 'BR' );
INSERT INTO player VALUES ( 66242, 'Jakub', 'Jugas', '1992-05-05', 350, NULL, NULL );
INSERT INTO player VALUES ( 77055, 'Matej', 'Rodin', '1996-02-13', 350, NULL, 'HR' );
INSERT INTO player VALUES ( 153377, 'Patryk', 'Zaucha', '2000-04-19', 350, NULL, 'PL' );
INSERT INTO player VALUES ( 270545, 'Karol', 'Knap', '2001-09-12', 350, NULL, 'PL' );
INSERT INTO player VALUES ( 314269, 'Krystian', 'Bracik', '2001-03-18', 350, NULL, 'PL' );
INSERT INTO player VALUES ( 323504, 'Filip', 'Kramarz', '2004-06-22', 350, NULL, 'PL' );
INSERT INTO player VALUES ( 413, 'Yevhen', 'Konoplyanka', '1989-09-29', 350, NULL, 'UA' );
INSERT INTO player VALUES ( 6933, 'Michal', 'Kopczynski', '1992-06-15', 3496, NULL, 'PL' );
INSERT INTO player VALUES ( 40550, 'Wiktor Marek', 'Plesnierowicz', '2001-03-29', 3496, NULL, 'PL' );
INSERT INTO player VALUES ( 40598, 'Maciej', 'Zurawski', '2000-12-22', 348, NULL, 'PL' );
INSERT INTO player VALUES ( 40603, 'Kamil', 'Koscielny', '1991-08-04', 3493, NULL, 'PL' );
INSERT INTO player VALUES ( 40634, 'Jan', 'Grzesik', '1994-10-21', 3496, NULL, 'PL' );
INSERT INTO player VALUES ( 40811, 'Dawid', 'Szymonowicz', '1995-07-07', 3496, NULL, 'PL' );
INSERT INTO player VALUES ( 40840, 'Adrian', 'Lis', '1992-05-28', 3496, NULL, 'PL' );
INSERT INTO player VALUES ( 40845, 'Bartosz', 'Kieliba', '1990-08-01', 3496, NULL, 'PL' );
INSERT INTO player VALUES ( 40846, 'Jakub', 'Kielb', '1993-07-15', 3496, NULL, 'PL' );
INSERT INTO player VALUES ( 40853, 'Michal', 'Jakobowski', '1992-09-08', 3496, NULL, 'PL' );
INSERT INTO player VALUES ( 55450, 'Niilo', 'Maenpaa', '1998-01-14', 3496, NULL, 'FI' );
INSERT INTO player VALUES ( 55467, 'Robert', 'Ivanov', '1994-09-19', 3496, NULL, 'FI' );
INSERT INTO player VALUES ( 61244, 'Filip', 'Balaj', '1997-08-02', 350, NULL, 'SK' );
INSERT INTO player VALUES ( 61407, 'Milan', 'Corryn', '1999-04-04', 3496, NULL, 'BE' );
INSERT INTO player VALUES ( 128658, 'Konrad', 'Matuszewski', '2001-10-04', 3496, NULL, 'PL' );
INSERT INTO player VALUES ( 129098, 'Jedrzej', 'Grobelny', '2001-06-28', 3496, NULL, 'PL' );
INSERT INTO player VALUES ( 270837, 'Robert', 'Ozog', '2000-01-08', 350, NULL, 'PL' );
INSERT INTO player VALUES ( 270839, 'Przemyslaw', 'Kapek', '2003-05-07', 350, NULL, 'PL' );
INSERT INTO player VALUES ( 272922, 'Jakub', 'Myszor', '2002-06-07', 350, NULL, 'PL' );
INSERT INTO player VALUES ( 1490, 'Miguel', 'Mariz Luis', '1999-02-27', 3496, NULL, 'PT' );
INSERT INTO player VALUES ( 1556, 'Mahir', 'Emreli', '1997-07-01', 339, NULL, NULL );
INSERT INTO player VALUES ( 2271, 'Martin', 'Dolezal', '1990-05-03', 345, NULL, NULL );
INSERT INTO player VALUES ( 25625, 'Adam', 'Zrelak', '1994-05-05', 3496, NULL, 'SK' );
INSERT INTO player VALUES ( 40216, 'Jakub', 'Zubrowski', '1992-03-21', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 40416, 'Martin', 'Konczkowski', '1993-09-14', 349, NULL, 'PL' );
INSERT INTO player VALUES ( 40525, 'Bartosz', 'Kopacz', '1992-05-21', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 40535, 'Filip', 'Starzynski', '1991-05-27', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 40620, 'Milosz', 'Szczepanski', '1998-03-22', 3496, NULL, 'PL' );
INSERT INTO player VALUES ( 40805, 'Mateusz', 'Kupczak', '1992-02-20', 3496, NULL, 'PL' );
INSERT INTO player VALUES ( 40858, 'Kajetan', 'Szmyt', '2002-05-29', 3496, NULL, 'PL' );
INSERT INTO player VALUES ( 40897, 'Michal', 'Szromnik', '1993-03-04', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 40908, 'Patryk', 'Janasik', '1997-08-25', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 41017, 'Kacper', 'Chodyna', '1999-05-24', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 47054, 'Diogo', 'Sousa Verdasca', '1996-10-26', 337, NULL, 'PT' );
INSERT INTO player VALUES ( 57141, 'Daniel Leo', 'Gretarsson Schmidt', '1995-10-02', 337, NULL, 'IS' );
INSERT INTO player VALUES ( 122574, 'Victor', 'Garcia Marin', '1994-05-31', 337, NULL, 'ES' );
INSERT INTO player VALUES ( 128637, 'Aleks', 'Lawniczak', '1999-05-05', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 148351, 'Lukasz', 'Lakomy', '2001-01-18', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 323516, 'Mikolaj', 'Rakowski', '2002-03-16', 3496, NULL, 'PL' );
INSERT INTO player VALUES ( 16196, 'Patrick Haakon', 'Olsen', '1994-04-23', 337, NULL, 'DK' );
INSERT INTO player VALUES ( 25360, 'Dennis', 'Jastrzembski', '2000-02-20', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 40359, 'Mateusz', 'Cichocki', '1992-01-31', 4248, NULL, 'PL' );
INSERT INTO player VALUES ( 40449, 'Daniel', 'Lukasik', '1991-04-28', 4248, NULL, 'PL' );
INSERT INTO player VALUES ( 40513, 'Daniel', 'Pik', '2000-07-20', 350, NULL, 'PL' );
INSERT INTO player VALUES ( 40619, 'Petr', 'Schwarz', '1991-11-12', 337, NULL, NULL );
INSERT INTO player VALUES ( 40714, 'Dawid', 'Abramowicz', '1991-05-16', 4248, NULL, 'PL' );
INSERT INTO player VALUES ( 40725, 'Mateusz', 'Grzybek', '1996-03-30', 3487, NULL, 'PL' );
INSERT INTO player VALUES ( 40814, 'Dariusz', 'Pawlowski', '1999-02-25', 340, NULL, 'PL' );
INSERT INTO player VALUES ( 41504, 'Luis Miguel', 'Vieira Babo Machado', '1992-11-04', 4248, NULL, 'PT' );
INSERT INTO player VALUES ( 41722, 'Tiago Manuel', 'Maio Matos', '2001-01-22', 4248, NULL, 'PT' );
INSERT INTO player VALUES ( 41729, 'Luiz Gustavo', 'Novaes Palhares', '1998-02-20', 4248, NULL, 'BR' );
INSERT INTO player VALUES ( 41772, 'Thabo', 'Cele', '1997-01-15', 4248, NULL, NULL );
INSERT INTO player VALUES ( 48508, 'Raphael', 'Rossi Branco', '1990-07-25', 4248, NULL, 'BR' );
INSERT INTO player VALUES ( 80772, 'Filipe Guterres', 'Nascimento', '1995-01-07', 4248, NULL, 'PT' );
INSERT INTO player VALUES ( 104797, 'Erik Alexander', 'Exposito Hernandez', '1996-06-23', 337, NULL, 'ES' );
INSERT INTO player VALUES ( 108560, 'Cayetano', 'Quintana Hernandez', '1993-12-20', 337, NULL, 'ES' );
INSERT INTO player VALUES ( 126802, 'Damian', 'Jakubik', '1990-03-25', 4248, NULL, 'PL' );
INSERT INTO player VALUES ( 157915, 'Konrad', 'Poprawa', '1998-06-04', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 347677, 'Jakub', 'Snopczynski', '2005-07-05', 4248, NULL, 'PL' );
INSERT INTO player VALUES ( 12550, 'Maurides', 'Roque Junior', '1994-03-10', 4248, NULL, 'BR' );
INSERT INTO player VALUES ( 14299, 'Erik', 'Janza', '1993-06-21', 340, NULL, 'SI' );
INSERT INTO player VALUES ( 33255, 'Lukasz Jozef', 'Podolski', '1985-06-04', 340, NULL, 'DE' );
INSERT INTO player VALUES ( 40195, 'Pawel', 'Sokol', '2000-03-02', 340, NULL, 'PL' );
INSERT INTO player VALUES ( 40220, 'Daniel', 'Bielica', '1999-04-30', 340, NULL, 'PL' );
INSERT INTO player VALUES ( 40342, 'Mateusz', 'Cholewiak', '1990-02-05', 340, NULL, 'PL' );
INSERT INTO player VALUES ( 40548, 'Rafal', 'Janicki', '1992-07-05', 340, NULL, 'PL' );
INSERT INTO player VALUES ( 46837, 'Daniel', 'Pacheco Lobato', '1991-01-05', 340, NULL, 'ES' );
INSERT INTO player VALUES ( 107131, 'Jean Jules', 'Sepp Mvondo', '1998-04-23', 340, NULL, 'CM' );
INSERT INTO player VALUES ( 119201, 'Piotr', 'Krawczyk', '1994-12-29', 340, NULL, 'PL' );
INSERT INTO player VALUES ( 125323, 'Leandro', 'Rossi Pereira', '1988-11-26', 4248, NULL, 'BR' );
INSERT INTO player VALUES ( 127632, 'Dominik', 'Sokol', '1999-05-16', 4248, NULL, 'PL' );
INSERT INTO player VALUES ( 129107, 'Aleksander', 'Paluszek', '2001-04-09', 340, NULL, 'PL' );
INSERT INTO player VALUES ( 148542, 'Robert', 'Dadok', '1996-12-24', 340, NULL, 'PL' );
INSERT INTO player VALUES ( 148676, 'Norbert', 'Wojtuszek', '2001-10-05', 340, NULL, 'PL' );
INSERT INTO player VALUES ( 152386, 'Jakub', 'Nowakowski', '2001-10-11', 4248, NULL, 'PL' );
INSERT INTO player VALUES ( 158614, 'Szymon', 'Wlodarczyk', '2003-01-05', 339, NULL, 'PL' );
INSERT INTO player VALUES ( 207212, 'Kryspin', 'Szczesniak', '2001-01-08', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 323510, 'Jakub', 'Szymanski', '2002-07-05', 340, NULL, 'PL' );
INSERT INTO player VALUES ( 368134, 'Milosz', 'Zurawski', '2006-04-17', 4248, NULL, 'PL' );
INSERT INTO player VALUES ( 7797, 'Pavel', 'Pavlyuchenko', '1998-01-01', 3487, NULL, 'BY' );
INSERT INTO player VALUES ( 26657, 'Dawid', 'Kort', '1995-04-29', 3493, NULL, 'PL' );
INSERT INTO player VALUES ( 40169, 'Marcin', 'Grabowski', '2000-05-21', 3487, NULL, 'PL' );
INSERT INTO player VALUES ( 40173, 'Maciej', 'Sadlok', '1989-06-29', 338, NULL, 'PL' );
INSERT INTO player VALUES ( 40222, 'Tomasz', 'Loska', '1996-01-26', 3487, NULL, 'PL' );
INSERT INTO player VALUES ( 40228, 'Kacper', 'Michalski', '2000-01-03', 340, NULL, 'PL' );
INSERT INTO player VALUES ( 40633, 'Artur', 'Bogusz', '1993-04-18', 4248, NULL, 'PL' );
INSERT INTO player VALUES ( 40792, 'Krystian', 'Bartoszek', '2002-05-28', 3487, NULL, 'PL' );
INSERT INTO player VALUES ( 40797, 'Artem', 'Putivtsev', '1988-08-29', 3487, NULL, 'UA' );
INSERT INTO player VALUES ( 41033, 'Damian', 'Weglarz', '1996-03-21', 341, NULL, 'PL' );
INSERT INTO player VALUES ( 41035, 'Wiktor', 'Biedrzycki', '1997-07-31', 3487, NULL, 'PL' );
INSERT INTO player VALUES ( 80214, 'Dino', 'Stiglec', '1990-10-03', 337, NULL, 'HR' );
INSERT INTO player VALUES ( 126801, 'Wojciech', 'Hajda', '2000-05-23', 340, NULL, 'PL' );
INSERT INTO player VALUES ( 148286, 'Patryk', 'Kusztal', '2003-03-28', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 148338, 'Mateusz', 'Winciersz', '2000-10-05', 349, NULL, 'PL' );
INSERT INTO player VALUES ( 148641, 'Bartlomiej', 'Kukulowicz', '2000-10-11', 3487, NULL, 'PL' );
INSERT INTO player VALUES ( 265639, 'Jakub', 'Witek', '2002-12-04', 341, NULL, 'PL' );
INSERT INTO player VALUES ( 270832, 'Wiktor', 'Preuss', '2001-11-04', 349, NULL, 'PL' );
INSERT INTO player VALUES ( 323619, 'Eryk', 'Matus', '2001-04-13', 336, NULL, 'PL' );
INSERT INTO player VALUES ( 325027, 'Marcel', 'Blachewicz', '2003-05-06', 341, NULL, 'PL' );
INSERT INTO player VALUES ( 37719, 'Omran', 'Haydary', '1998-01-13', 343, NULL, NULL );
INSERT INTO player VALUES ( 40203, 'Bartosz', 'Rymaniak', '1989-11-13', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 40232, 'Maciej', 'Ambrosiewicz', '1998-05-24', 3487, NULL, 'PL' );
INSERT INTO player VALUES ( 40425, 'Tomasz', 'Jodlowiec', '1985-09-08', 349, NULL, 'PL' );
INSERT INTO player VALUES ( 40503, 'Janusz Krzysztof', 'Gol', '1985-11-11', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 40801, 'Roman', 'Gergel', '1988-02-22', 3487, NULL, 'SK' );
INSERT INTO player VALUES ( 40802, 'Vlastimir', 'Jovanovic', '1985-04-03', 3487, NULL, NULL );
INSERT INTO player VALUES ( 41030, 'Mateusz', 'Kuzimski', '1991-06-26', 3496, NULL, 'PL' );
INSERT INTO player VALUES ( 46022, 'Nemanja', 'Tekijaski', '1997-03-02', 3487, NULL, 'RS' );
INSERT INTO player VALUES ( 63393, 'Artem', 'Polyarus', '1992-07-05', 3487, NULL, 'UA' );
INSERT INTO player VALUES ( 63572, 'Andrii', 'Dombrovskyi', '1995-08-12', 3487, NULL, 'UA' );
INSERT INTO player VALUES ( 66252, 'Michal', 'Hubinek', '1994-11-10', 3487, NULL, NULL );
INSERT INTO player VALUES ( 66262, 'Muris', 'Mesanovic', '1990-07-06', 3487, NULL, NULL );
INSERT INTO player VALUES ( 66313, 'Tomas', 'Poznar', '1988-09-27', 3487, NULL, NULL );
INSERT INTO player VALUES ( 96272, 'Adam', 'Radwanski', '1998-04-10', 3487, NULL, 'PL' );
INSERT INTO player VALUES ( 128589, 'Tomasz', 'Matuszewski', '2001-11-26', 3487, NULL, 'PL' );
INSERT INTO player VALUES ( 148212, 'Jakub', 'Pek', '2000-10-31', 3487, NULL, 'PL' );
INSERT INTO player VALUES ( 148539, 'Kacper', 'Spiewak', '2000-05-30', 3487, NULL, 'PL' );
INSERT INTO player VALUES ( 176187, 'Daniel', 'Pietraszkiewicz', '2001-09-12', 3487, NULL, 'PL' );
INSERT INTO player VALUES ( 262787, 'Marcel', 'Szymanski', '2005-02-23', 4248, NULL, 'PL' );
INSERT INTO player VALUES ( 3006, 'Jakub', 'Blaszczykowski', '1985-12-14', 338, NULL, 'PL' );
INSERT INTO player VALUES ( 40163, 'Kamil', 'Broda', '2001-07-19', 338, NULL, 'PL' );
INSERT INTO player VALUES ( 40174, 'Dawid', 'Szot', '2001-04-29', 338, NULL, 'PL' );
INSERT INTO player VALUES ( 40280, 'Alan', 'Uryga', '1994-02-19', 338, NULL, 'PL' );
INSERT INTO player VALUES ( 40282, 'Igor Michal', 'Lasicki', '1995-06-26', 348, NULL, 'PL' );
INSERT INTO player VALUES ( 40457, 'Jakub', 'Arak', '1995-04-02', 3491, NULL, 'PL' );
INSERT INTO player VALUES ( 40537, 'Daniel', 'Dudzinski', '2002-03-07', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 40554, 'Marcin', 'Wasielewski', '1994-08-23', 3487, NULL, 'PL' );
INSERT INTO player VALUES ( 40885, 'Krystian', 'Wachowiak', '2001-10-19', 338, NULL, 'PL' );
INSERT INTO player VALUES ( 96288, 'Kacper', 'Sadlocha', '2002-12-01', 3493, NULL, 'PL' );
INSERT INTO player VALUES ( 127389, 'Maksymilian', 'Sitek', '2000-12-04', 3493, NULL, 'PL' );
INSERT INTO player VALUES ( 147782, 'Joseph', 'Colley', '1999-04-13', 338, NULL, 'SE' );
INSERT INTO player VALUES ( 148642, 'Kamil', 'Pajnowski', '1998-01-28', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 148710, 'Mikolaj', 'Bieganski', '2002-04-05', 338, NULL, 'PL' );
INSERT INTO player VALUES ( 174933, 'Alkhaly Momo', 'Cisse', '2002-10-17', 338, NULL, 'GN' );
INSERT INTO player VALUES ( 207819, 'Wiktor', 'Klos', '2000-01-21', 3493, NULL, 'PL' );
INSERT INTO player VALUES ( 263180, 'Kacper', 'Duda', '2004-01-01', 338, NULL, 'PL' );
INSERT INTO player VALUES ( 270521, 'Dawid', 'Olejarka', '2001-12-27', 4248, NULL, 'PL' );
INSERT INTO player VALUES ( 281306, 'Konrad', 'Gruszkowski', '2001-01-27', 338, NULL, 'PL' );
INSERT INTO player VALUES ( 285060, 'Ramil', 'Mustafaev', '2003-12-20', 339, NULL, 'RU' );
INSERT INTO player VALUES ( 39226, 'Maciej', 'Gostomski', '1988-09-27', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 40182, 'Patryk', 'Plewka', '2000-01-02', 338, NULL, 'PL' );
INSERT INTO player VALUES ( 40318, 'Mateusz', 'Mlynski', '2001-01-02', 338, NULL, 'PL' );
INSERT INTO player VALUES ( 40347, 'Mateusz', 'Radecki', '1993-04-02', 4248, NULL, 'PL' );
INSERT INTO player VALUES ( 40567, 'Tymoteusz', 'Klups', '2000-02-26', 347, NULL, 'PL' );
INSERT INTO player VALUES ( 40591, 'Michal', 'Zyro', '1992-09-20', 336, NULL, 'PL' );
INSERT INTO player VALUES ( 40599, 'Michal', 'Gliwa', '1988-04-08', 3493, NULL, 'PL' );
INSERT INTO player VALUES ( 40722, 'Jan', 'Bieganski', '2002-12-04', 343, NULL, 'PL' );
INSERT INTO player VALUES ( 40842, 'Mateusz', 'Bodzioch', '1990-06-04', 4248, NULL, 'PL' );
INSERT INTO player VALUES ( 40904, 'Sebastian', 'Bonecki', '1995-02-13', 3487, NULL, 'PL' );
INSERT INTO player VALUES ( 40907, 'Mateusz', 'Czyzycki', '1998-02-08', 3496, NULL, 'PL' );
INSERT INTO player VALUES ( 41029, 'Gracjan', 'Jaroch', '1998-04-15', 3496, NULL, 'PL' );
INSERT INTO player VALUES ( 51143, 'Zdenek', 'Ondrasek', '1988-12-22', 338, NULL, NULL );
INSERT INTO player VALUES ( 105087, 'Luis', 'Fernandez Teijeiro', '1993-09-23', 338, NULL, 'ES' );
INSERT INTO player VALUES ( 110538, 'Dor', 'Hugi', '1995-07-10', 338, NULL, 'IL' );
INSERT INTO player VALUES ( 125327, 'Patryk', 'Mikita', '1993-12-28', 4248, NULL, 'PL' );
INSERT INTO player VALUES ( 148637, 'Adrian', 'Kostrzewski', '1998-08-27', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 269889, 'Filip', 'Borowski', '2003-10-06', 347, NULL, 'PL' );
INSERT INTO player VALUES ( 301269, 'Piotr', 'Starzynski', '2004-01-22', 338, NULL, 'PL' );
INSERT INTO player VALUES ( 363558, 'Mateusz', 'Ziolkowski', '2003-08-29', 340, NULL, 'PL' );
INSERT INTO player VALUES ( 40312, 'Damian', 'Zbozien', '1989-04-25', 341, NULL, 'PL' );
INSERT INTO player VALUES ( 40350, 'Damian', 'Gaska', '1996-11-24', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 40476, 'Bartosz', 'Kwiecien', '1994-05-07', 336, NULL, 'PL' );
INSERT INTO player VALUES ( 40523, 'Daniel', 'Dziwniel', '1992-08-19', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 40659, 'Jonathan', 'de Amo Perez', '1990-01-13', 6941, NULL, 'ES' );
INSERT INTO player VALUES ( 40863, 'Hubert', 'Sobol', '2000-06-25', 338, NULL, 'PL' );
INSERT INTO player VALUES ( 41073, 'Serhii', 'Krykun', '1996-09-22', 6941, NULL, 'UA' );
INSERT INTO player VALUES ( 109703, 'Egzon', 'Kryeziu', '2000-04-25', 343, NULL, 'SI' );
INSERT INTO player VALUES ( 128580, 'Ruben', 'Lobato Cabal', '1994-03-09', 6941, NULL, 'ES' );
INSERT INTO player VALUES ( 139925, 'Karol', 'Podlinski', '1997-11-06', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 148645, 'Karol', 'Turek', '2000-06-23', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 157789, 'Bartlomiej', 'Eizenchart', '2001-08-23', 340, NULL, 'PL' );
INSERT INTO player VALUES ( 176163, 'Lukasz', 'Szramowski', '2002-04-01', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 273430, 'Szymon', 'Lewkot', '1999-02-18', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 306553, 'Tomasz Dominik', 'Wozniak', '2002-01-07', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 307253, 'Kamil', 'Duda', '2004-04-29', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 307254, 'Dawid', 'Tkacz', '2005-01-25', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 354200, 'Patryk', 'Pierzak', '2003-01-16', 339, NULL, 'PL' );
INSERT INTO player VALUES ( 368136, 'Michal', 'Szalachowski', '2004-07-23', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 368137, 'Mateusz', 'Golba', '2003-03-29', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 40302, 'Pavels', 'Steinbors', '1985-09-21', 336, NULL, 'LV' );
INSERT INTO player VALUES ( 40372, 'Tomasz', 'Nawotka', '1997-02-14', 339, NULL, 'PL' );
INSERT INTO player VALUES ( 40506, 'Sylwester', 'Lusiusz', '1999-09-18', 350, NULL, 'PL' );
INSERT INTO player VALUES ( 40541, 'Patryk', 'Tuszynski', '1989-12-13', 341, NULL, 'PL' );
INSERT INTO player VALUES ( 40544, 'Matus', 'Putnocky', '1984-11-01', 337, NULL, 'SK' );
INSERT INTO player VALUES ( 40571, 'Jakub', 'Bursztyn', '1998-03-25', 348, NULL, 'PL' );
INSERT INTO player VALUES ( 40604, 'Oskar', 'Krzyzak', '2002-01-24', 3491, NULL, 'PL' );
INSERT INTO player VALUES ( 40641, 'Bartlomiej', 'Kalinkowski', '1994-07-11', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 40644, 'Piotr', 'Pyrdol', '1999-04-27', 341, NULL, 'PL' );
INSERT INTO player VALUES ( 40676, 'Maciej', 'Urbanczyk', '1995-04-02', 3493, NULL, 'PL' );
INSERT INTO player VALUES ( 40961, 'Szymon', 'Drewniak', '1993-07-11', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 148654, 'Pawel', 'Wojciechowski', '1990-04-24', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 162878, 'Bartlomiej', 'Burman', '2001-05-01', 3496, NULL, 'PL' );
INSERT INTO player VALUES ( 180742, 'Bartosz', 'Neugebauer', '2002-02-18', 340, NULL, 'PL' );
INSERT INTO player VALUES ( 264487, 'Jakub Cezary', 'Iskra', '2002-08-13', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 271982, 'Michal', 'Surzyn', '2003-11-03', 336, NULL, 'PL' );
INSERT INTO player VALUES ( 273447, 'Jakub', 'Sangowski', '2002-03-11', 3496, NULL, 'PL' );
INSERT INTO player VALUES ( 322936, 'Pedro Miguel', 'Carmo Vieira', '2002-05-03', 3491, NULL, 'PT' );
INSERT INTO player VALUES ( 324070, 'Szymon', 'Michalski', '2004-03-08', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 340634, 'Kacper', 'Lukasiak', '2003-09-24', 348, NULL, 'PL' );
INSERT INTO player VALUES ( 1414, 'Antonio', 'Milic', '1994-03-10', 347, NULL, 'HR' );
INSERT INTO player VALUES ( 14330, 'Josip', 'Juranovic', '1995-08-16', 339, NULL, 'HR' );
INSERT INTO player VALUES ( 15491, 'Joel', 'Vieira Pereira', '1996-09-28', 347, NULL, 'PT' );
INSERT INTO player VALUES ( 19121, 'Barry James', 'Douglas', '1989-09-04', 347, NULL, 'GB' );
INSERT INTO player VALUES ( 21486, 'Pedro Miguel', 'Braga Rebocho', '1995-01-23', 347, NULL, 'PT' );
INSERT INTO player VALUES ( 25619, 'Mikael', 'Ishak', '1993-03-31', 347, NULL, 'SE' );
INSERT INTO player VALUES ( 31076, 'Bartosz', 'Salamon', '1991-05-01', 347, NULL, 'PL' );
INSERT INTO player VALUES ( 31556, 'Radoslaw Pawel', 'Murawski', '1994-04-22', 347, NULL, 'PL' );
INSERT INTO player VALUES ( 36964, 'Filip', 'Bednarek', '1992-09-26', 347, NULL, 'PL' );
INSERT INTO player VALUES ( 39244, 'Kristoffer', 'Velde', '1999-09-09', 347, NULL, 'NO' );
INSERT INTO player VALUES ( 40402, 'Andre Renato', 'Soares Martins', '1990-01-21', 339, NULL, 'PT' );
INSERT INTO player VALUES ( 40521, 'Alan', 'Czerwinski', '1993-02-02', 347, NULL, 'PL' );
INSERT INTO player VALUES ( 40569, 'Joao Pedro', 'Reis Amaral', '1991-09-07', 347, NULL, 'PT' );
INSERT INTO player VALUES ( 40809, 'Michal Krzysztof', 'Skoras', '2000-02-15', 347, NULL, 'PL' );
INSERT INTO player VALUES ( 48047, 'Jesper Kewe', 'Karlstrom', '1995-06-21', 347, NULL, 'SE' );
INSERT INTO player VALUES ( 55946, 'Nikoloz', 'Kvekveskiri', '1992-05-29', 347, NULL, 'GE' );
INSERT INTO player VALUES ( 55949, 'Lubomir', 'Satka', '1995-12-02', 347, NULL, 'SK' );
INSERT INTO player VALUES ( 70336, 'Vladan', 'Kovacevic', '1998-04-11', 3491, NULL, NULL );
INSERT INTO player VALUES ( 180229, 'Krzysztof', 'Toporkiewicz', '2002-04-21', 336, NULL, 'PL' );
INSERT INTO player VALUES ( 215855, 'Veton', 'Tusha', '2002-12-29', 3487, NULL, 'XK' );
INSERT INTO player VALUES ( 14347, 'Fran', 'Tudor', '1995-09-27', 3491, NULL, 'HR' );
INSERT INTO player VALUES ( 27039, 'Giannis', 'Papanikolaou', '1998-11-18', 3491, NULL, 'GR' );
INSERT INTO player VALUES ( 40207, 'Marcin', 'Cebula', '1995-12-06', 3491, NULL, 'PL' );
INSERT INTO player VALUES ( 40208, 'Wiktor', 'Dlugosz', '2000-07-01', 3491, NULL, 'PL' );
INSERT INTO player VALUES ( 40466, 'Zoran', 'Arsenic', '1994-06-02', 3491, NULL, 'HR' );
INSERT INTO player VALUES ( 40509, 'Mateusz', 'Wdowiak', '1996-08-28', 3491, NULL, 'PL' );
INSERT INTO player VALUES ( 40605, 'Andrzej', 'Niewulis', '1989-04-21', 3491, NULL, 'PL' );
INSERT INTO player VALUES ( 40606, 'Tomas', 'Petrasek', '1992-03-02', 3491, NULL, NULL );
INSERT INTO player VALUES ( 40612, 'Patryk', 'Kun', '1995-04-20', 3491, NULL, 'PL' );
INSERT INTO player VALUES ( 40672, 'Bartosz', 'Nowak', '1993-08-25', 340, NULL, 'PL' );
INSERT INTO player VALUES ( 43194, 'Deian Cristian', 'Sorescu', '1997-08-29', 3491, NULL, 'RO' );
INSERT INTO player VALUES ( 46892, 'Ivan', 'Lopez Alvarez', '1994-06-29', 3491, NULL, 'ES' );
INSERT INTO player VALUES ( 63443, 'Vladyslav', 'Kochergin', '1996-04-30', 3491, NULL, 'UA' );
INSERT INTO player VALUES ( 64004, 'Daniel', 'Szelagowski', '2002-09-02', 3496, NULL, 'PL' );
INSERT INTO player VALUES ( 66191, 'Milan', 'Rundic', '1992-03-29', 3491, NULL, 'RS' );
INSERT INTO player VALUES ( 191110, 'Bogdan', 'Racovitan', '2000-06-06', 3491, NULL, 'RO' );
INSERT INTO player VALUES ( 215851, 'Szymon', 'Czyz', '2001-07-08', 3491, NULL, 'PL' );
INSERT INTO player VALUES ( 262634, 'Benjamin', 'Lederman', '2000-05-08', 3491, NULL, 'PL' );
INSERT INTO player VALUES ( 264404, 'Xavier', 'Dziekonski', '2003-10-06', 336, NULL, 'PL' );
INSERT INTO player VALUES ( 265761, 'Kacper', 'Trelowski', '2003-08-19', 3491, NULL, 'PL' );
INSERT INTO player VALUES ( 2155, 'Elvis', 'Manu', '1993-08-13', 338, NULL, 'NL' );
INSERT INTO player VALUES ( 3012, 'Kamil Pawel', 'Grosicki', '1988-06-08', 348, NULL, 'PL' );
INSERT INTO player VALUES ( 3013, 'Dawid Igor', 'Kownacki', '1997-03-14', 347, NULL, 'PL' );
INSERT INTO player VALUES ( 7677, 'Benedikt', 'Zech', '1990-11-03', 348, NULL, 'AT' );
INSERT INTO player VALUES ( 10990, 'Dante', 'Stipica', '1991-05-30', 348, NULL, 'HR' );
INSERT INTO player VALUES ( 15804, 'Rafal Maciej', 'Kurzawa', '1993-01-29', 348, NULL, 'PL' );
INSERT INTO player VALUES ( 26833, 'Konstantinos', 'Triantafyllopoulos', '1993-04-03', 348, NULL, 'GR' );
INSERT INTO player VALUES ( 40225, 'Adrian', 'Gryszkiewicz', '1999-12-13', 340, NULL, 'PL' );
INSERT INTO player VALUES ( 40235, 'Valerian', 'Gvilia', '1994-05-24', 3491, NULL, 'GE' );
INSERT INTO player VALUES ( 40269, 'Fabian', 'Piasecki', '1995-05-04', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 40395, 'Michal', 'Kucharczyk', '1991-03-20', 348, NULL, 'PL' );
INSERT INTO player VALUES ( 40501, 'Damian', 'Dabrowski', '1992-08-27', 348, NULL, 'PL' );
INSERT INTO player VALUES ( 40560, 'Jakub', 'Kaminski', '2002-06-05', 347, NULL, 'PL' );
INSERT INTO player VALUES ( 40574, 'Jakub', 'Bartkowski', '1991-11-07', 348, NULL, 'PL' );
INSERT INTO player VALUES ( 40578, 'Mariusz', 'Malec', '1995-04-04', 348, NULL, 'PL' );
INSERT INTO player VALUES ( 40625, 'Sebastian Karol', 'Musiolik', '1996-05-19', 3491, NULL, 'PL' );
INSERT INTO player VALUES ( 40813, 'Vladislavs', 'Gutkovskis', '1995-04-02', 3491, NULL, 'LV' );
INSERT INTO player VALUES ( 64304, 'Kacper Szymon', 'Kozlowski', '2003-10-16', 348, NULL, 'PL' );
INSERT INTO player VALUES ( 96329, 'Luis Carlos', 'Machado Mata', '1997-07-06', 348, NULL, 'PT' );
INSERT INTO player VALUES ( 119204, 'Damian', 'Michalski', '1998-05-17', 341, NULL, 'PL' );
INSERT INTO player VALUES ( 9388, 'Conrado', 'Buchanelli Holz', '1997-04-03', 343, NULL, 'BR' );
INSERT INTO player VALUES ( 14294, 'Alexander', 'Gorgon', '1988-10-28', 348, NULL, 'AT' );
INSERT INTO player VALUES ( 24796, 'Christian', 'Clemens', '1991-08-04', 343, NULL, 'DE' );
INSERT INTO player VALUES ( 25149, 'Mario', 'Maloca', '1989-05-04', 343, NULL, 'HR' );
INSERT INTO player VALUES ( 26591, 'Joel', 'Abu Hanna', '1998-01-22', 339, NULL, 'IL' );
INSERT INTO player VALUES ( 40164, 'Michal', 'Buchalik', '1989-02-03', 343, NULL, 'PL' );
INSERT INTO player VALUES ( 40172, 'Rafal', 'Pietrzak', '1992-01-30', 343, NULL, 'PL' );
INSERT INTO player VALUES ( 40436, 'Dusan', 'Kuciak', '1985-05-21', 343, NULL, 'SK' );
INSERT INTO player VALUES ( 40443, 'Michal Jan', 'Nalepa', '1993-01-22', 343, NULL, 'PL' );
INSERT INTO player VALUES ( 40447, 'Jaroslaw', 'Kubicki', '1995-08-07', 343, NULL, 'PL' );
INSERT INTO player VALUES ( 40557, 'Maciej', 'Gajos', '1991-03-19', 343, NULL, 'PL' );
INSERT INTO player VALUES ( 40581, 'David', 'Stec', '1994-05-10', 343, NULL, 'AT' );
INSERT INTO player VALUES ( 40586, 'Sebastian', 'Kowalczyk', '1998-08-22', 348, NULL, 'PL' );
INSERT INTO player VALUES ( 48185, 'Sven Henrik Olof', 'Castegren', '1996-03-28', 343, NULL, 'SE' );
INSERT INTO player VALUES ( 56027, 'Luka', 'Zahovic', '1995-11-15', 348, NULL, 'SI' );
INSERT INTO player VALUES ( 61232, 'Vahan', 'Bichakhchyan', '1999-07-09', 348, NULL, 'AM' );
INSERT INTO player VALUES ( 68534, 'Kristers', 'Tobers', '2000-12-13', 343, NULL, 'LV' );
INSERT INTO player VALUES ( 104845, 'Jean Carlos', 'Silva Rocha', '1996-05-10', 348, NULL, 'BR' );
INSERT INTO player VALUES ( 301772, 'Mateusz', 'Legowski', '2003-01-29', 348, NULL, 'PL' );
INSERT INTO player VALUES ( 304062, 'Antoni', 'Mikulko', '2005-02-11', 343, NULL, 'PL' );
INSERT INTO player VALUES ( 7735, 'Ilkay', 'Durmus', '1994-05-01', 343, NULL, 'TR' );
INSERT INTO player VALUES ( 7835, 'Godfrey Bitok', 'Stephen', '2000-08-22', 336, NULL, 'NG' );
INSERT INTO player VALUES ( 9088, 'Damir', 'Sadikovic', '1995-04-07', 350, NULL, NULL );
INSERT INTO player VALUES ( 14381, 'Lukasz', 'Zwolinski', '1993-02-24', 343, NULL, 'PL' );
INSERT INTO player VALUES ( 26259, 'Marco', 'Terrazzino', '1991-04-15', 343, NULL, 'DE' );
INSERT INTO player VALUES ( 40366, 'Zarko', 'Udovicic', '1987-08-31', 3491, NULL, 'RS' );
INSERT INTO player VALUES ( 40431, 'Piotr', 'Parzyszek', '1993-09-08', 348, NULL, 'PL' );
INSERT INTO player VALUES ( 40458, 'Flavio Emanuel', 'Lopes Paixao', '1984-09-19', 343, NULL, 'PT' );
INSERT INTO player VALUES ( 40475, 'Martin', 'Kostal', '1996-02-23', 336, NULL, 'SK' );
INSERT INTO player VALUES ( 45377, 'Nikola', 'Kuveljic', '1997-04-06', 338, NULL, 'RS' );
INSERT INTO player VALUES ( 45880, 'Milan', 'Obradovic', '1999-12-27', 341, NULL, 'RS' );
INSERT INTO player VALUES ( 55874, 'Fatos', 'Beciraj', '1988-05-05', 338, NULL, 'ME' );
INSERT INTO player VALUES ( 66053, 'Jan', 'Sykora', '1993-12-29', 347, NULL, NULL );
INSERT INTO player VALUES ( 90746, 'Jan', 'Kliment', '1993-09-01', 338, NULL, NULL );
INSERT INTO player VALUES ( 119203, 'Dominik', 'Steczyk', '1999-05-04', 3493, NULL, 'PL' );
INSERT INTO player VALUES ( 197784, 'Jakub', 'Kaluzinski', '2002-10-31', 343, NULL, 'PL' );
INSERT INTO player VALUES ( 266178, 'Kacper', 'Sezonienko', '2003-03-23', 343, NULL, 'PL' );
INSERT INTO player VALUES ( 293353, 'Bassekou', 'Diabate', '2000-04-15', 343, NULL, 'ML' );
INSERT INTO player VALUES ( 301776, 'Filip', 'Koperski', '2004-02-24', 343, NULL, 'PL' );
INSERT INTO player VALUES ( 324545, 'Tomasz', 'Neugebauer', '2003-05-08', 343, NULL, 'PL' );
INSERT INTO player VALUES ( 1233, 'Michal', 'Frydrych', '1990-02-27', 338, NULL, NULL );
INSERT INTO player VALUES ( 14455, 'Karlo', 'Muhar', '1996-01-17', 347, NULL, 'HR' );
INSERT INTO player VALUES ( 23535, 'Jayson', 'Papeau', '1996-06-30', 3496, NULL, 'FR' );
INSERT INTO player VALUES ( 28350, 'Roland', 'Varga', '1990-01-23', 3487, NULL, 'HU' );
INSERT INTO player VALUES ( 28586, 'Mark', 'Tamas', '1993-10-28', 337, NULL, 'HU' );
INSERT INTO player VALUES ( 40388, 'Adam', 'Hlousek', '1988-12-20', 3487, NULL, NULL );
INSERT INTO player VALUES ( 40504, 'Sergiu Catalin', 'Hanca', '1992-04-04', 350, NULL, 'RO' );
INSERT INTO player VALUES ( 40772, 'Filip', 'Modelski', '1992-09-28', 3487, NULL, 'PL' );
INSERT INTO player VALUES ( 43093, 'Rivaldo Vitor', 'Borba Ferreira Junior', '1995-04-29', 350, NULL, 'BR' );
INSERT INTO player VALUES ( 43174, 'Mario Junior', 'Rondon Fernandez', '1986-03-26', 4248, NULL, 'VE' );
INSERT INTO player VALUES ( 66035, 'Matej', 'Hybs', '1993-01-03', 3487, NULL, NULL );
INSERT INTO player VALUES ( 66107, 'Tomas', 'Zajic', '1996-08-12', 345, NULL, NULL );
INSERT INTO player VALUES ( 96273, 'Aron', 'Stasiak', '1999-02-19', 348, NULL, 'PL' );
INSERT INTO player VALUES ( 119198, 'Jakub', 'Wawszczyk', '1998-01-11', 3493, NULL, 'PL' );
INSERT INTO player VALUES ( 148343, 'Mateusz', 'Grudzinski', '2000-06-20', 339, NULL, 'PL' );
INSERT INTO player VALUES ( 281305, 'Jan', 'Majsterek', '2000-06-09', 336, NULL, 'PL' );
INSERT INTO player VALUES ( 302127, 'Dominik', 'Banach', '2002-11-16', 4248, NULL, 'PL' );
INSERT INTO player VALUES ( 304063, 'Jakub', 'Grzesiak', '2003-02-22', 340, NULL, 'PL' );
INSERT INTO player VALUES ( 323367, 'Jakub', 'Madrzyk', '2003-12-04', 3491, NULL, 'PL' );
INSERT INTO player VALUES ( 355464, 'Piotr', 'Zielinski', '1999-01-08', 341, NULL, 'PL' );
INSERT INTO player VALUES ( 2181, 'Giorgi', 'Tsitaishvili', '2000-11-18', 338, NULL, 'GE' );
INSERT INTO player VALUES ( 40459, 'Artur Adam', 'Sobiech', '1990-06-12', 347, NULL, 'PL' );
INSERT INTO player VALUES ( 40460, 'Mateusz', 'Zukowski', '2001-11-23', 343, NULL, 'PL' );
INSERT INTO player VALUES ( 40464, 'Blazej', 'Niezgoda', '2000-01-23', 336, NULL, 'PL' );
INSERT INTO player VALUES ( 40473, 'Jakub', 'Wojcicki', '1988-07-09', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 40563, 'Filip', 'Marchwinski', '2002-01-10', 347, NULL, 'PL' );
INSERT INTO player VALUES ( 40815, 'Milosz Stefan', 'Mleczko', '1999-03-01', 347, NULL, 'PL' );
INSERT INTO player VALUES ( 40824, 'Jakub', 'Zagorski', '1997-01-04', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 64303, 'Bartosz', 'Borun', '2000-05-17', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 66205, 'Adriel D Avila', 'Ba Loua', '1996-07-25', 347, NULL, NULL );
INSERT INTO player VALUES ( 148452, 'Patryk', 'Czarnowski', '1998-05-19', 3487, NULL, 'PL' );
INSERT INTO player VALUES ( 266050, 'Filip', 'Wilak', '2003-08-06', 347, NULL, 'PL' );
INSERT INTO player VALUES ( 269882, 'Krystian', 'Palacz', '2003-07-19', 347, NULL, 'PL' );
INSERT INTO player VALUES ( 269892, 'Antoni', 'Kozubal', '2004-08-18', 347, NULL, 'PL' );
INSERT INTO player VALUES ( 269897, 'Norbert', 'Paclawski', '2004-02-19', 347, NULL, 'PL' );
INSERT INTO player VALUES ( 310611, 'Maksymilian', 'Pingot', '2003-04-01', 347, NULL, 'PL' );
INSERT INTO player VALUES ( 325184, 'Jakub', 'Antczak', '2004-04-29', 347, NULL, 'PL' );
INSERT INTO player VALUES ( 325185, 'Maksym', 'Czekala', '2004-03-05', 347, NULL, 'PL' );
INSERT INTO player VALUES ( 338047, 'Maciej', 'Kikolski', '2004-02-23', 339, NULL, 'PL' );
INSERT INTO player VALUES ( 349605, 'Krzysztof', 'Wingralek', '2002-09-29', 340, NULL, 'PL' );
INSERT INTO player VALUES ( 7734, 'Cheikhou', 'Dieng', '1993-11-23', 345, NULL, 'SN' );
INSERT INTO player VALUES ( 15389, 'Sasa Aleksander', 'Zivec', '1991-04-02', 345, NULL, 'SI' );
INSERT INTO player VALUES ( 40451, 'Tomasz', 'Makowski', '1999-07-19', 343, NULL, 'PL' );
INSERT INTO player VALUES ( 40480, 'Marko', 'Poletanovic', '1993-07-20', 338, NULL, 'RS' );
INSERT INTO player VALUES ( 40531, 'Dawid', 'Pakulski', '1998-07-23', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 40543, 'Jasmin', 'Buric', '1987-02-18', 345, NULL, NULL );
INSERT INTO player VALUES ( 68436, 'Kacper', 'Bieszczad', '2002-09-11', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 96287, 'Nikodem', 'Fiedosewicz', '1998-05-30', 3496, NULL, 'PL' );
INSERT INTO player VALUES ( 128597, 'Rafal', 'Adamski', '2001-11-21', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 135493, 'Koki', 'Hinokio', '2001-02-26', 345, NULL, 'JP' );
INSERT INTO player VALUES ( 148092, 'Mateusz', 'Bartolewski', '1998-01-12', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 148276, 'Kacper', 'Lepczynski', '2001-07-18', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 148280, 'Mateusz', 'Kizyma', '2002-07-08', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 314268, 'Milan', 'Posmyk', '2002-02-02', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 322937, 'Tomasz', 'Pienko', '2004-01-05', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 322938, 'Bartlomiej', 'Kludka', '2002-05-14', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 323623, 'Szymon', 'Weirauch', '2004-03-05', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 340114, 'Kacper', 'Masiak', '2005-01-11', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 354198, 'Kamil', 'Sobczak', '2003-01-01', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 354199, 'Filip', 'Kocaba', '2004-11-13', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 40338, 'Mariusz', 'Pawelec', '1986-04-14', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 40377, 'Kacper', 'Radkowski', '2001-03-27', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 40793, 'Lukasz', 'Budzilek', '1991-03-19', 3487, NULL, 'PL' );
INSERT INTO player VALUES ( 96260, 'Maciej', 'Orlowski', '1994-01-07', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 119202, 'Wojciech', 'Muzyk', '1998-11-07', 339, NULL, 'PL' );
INSERT INTO player VALUES ( 122270, 'Michal', 'Krol', '2000-03-14', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 129111, 'Patryk', 'Krolczyk', '1994-05-10', 349, NULL, 'PL' );
INSERT INTO player VALUES ( 148283, 'Bartosz', 'Zynek', '2002-03-14', 341, NULL, 'PL' );
INSERT INTO player VALUES ( 148407, 'Mateusz', 'Wyjadlowski', '2000-01-04', 3493, NULL, 'PL' );
INSERT INTO player VALUES ( 148655, 'Jozef', 'Burta', '1999-09-20', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 162870, 'Jakub', 'Karbownik', '2001-03-15', 347, NULL, 'PL' );
INSERT INTO player VALUES ( 163053, 'Lukasz', 'Bejger', '2002-01-11', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 216600, 'Kais', 'Al-Ani', '1997-03-29', 3493, NULL, 'IQ' );
INSERT INTO player VALUES ( 273429, 'Olivier', 'Wypart', '2001-01-16', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 301186, 'Jakub', 'Lutostanski', '2004-09-17', 336, NULL, 'PL' );
INSERT INTO player VALUES ( 301773, 'Oliwier', 'Slawinski', '2005-04-15', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 304339, 'Kamil', 'Glogowski', '2004-07-22', 338, NULL, 'PL' );
INSERT INTO player VALUES ( 319489, 'Ehor', 'Matsenko', '2002-01-23', 339, NULL, 'UA' );
INSERT INTO player VALUES ( 323509, 'Adrian', 'Dziedzic', '2003-03-22', 340, NULL, 'PL' );
INSERT INTO player VALUES ( 344249, 'Dorian', 'Gadek', '2004-01-02', 338, NULL, 'PL' );
INSERT INTO player VALUES ( 7367, 'Alex', 'Sobczyk', '1997-05-20', 340, NULL, 'AT' );
INSERT INTO player VALUES ( 40344, 'Krzysztof', 'Maczynski', '1987-05-23', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 40353, 'Piotr', 'Samiec-Talar', '2001-11-02', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 40399, 'Mateusz', 'Praszelik', '2000-09-26', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 40996, 'Adrian', 'Lyszczarz', '1999-08-22', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 41057, 'Sebastian', 'Bergier', '1999-12-20', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 46085, 'Filip', 'Bainovic', '1996-06-23', 340, NULL, 'RS' );
INSERT INTO player VALUES ( 61199, 'Erik', 'Daniel', '1992-02-04', 345, NULL, NULL );
INSERT INTO player VALUES ( 61235, 'Enis', 'Fazlagikj', '2000-03-27', 338, NULL, NULL );
INSERT INTO player VALUES ( 61450, 'Samuel', 'Stefanik', '1991-11-16', 3487, NULL, 'SK' );
INSERT INTO player VALUES ( 96415, 'Rui Pedro', 'Ribeiro Fernandes Duarte Gomes', '1997-09-04', 339, NULL, 'PT' );
INSERT INTO player VALUES ( 125338, 'Filip', 'Majchrowicz', '2000-02-09', 4248, NULL, 'PL' );
INSERT INTO player VALUES ( 125646, 'Karol', 'Struski', '2001-01-18', 336, NULL, 'PL' );
INSERT INTO player VALUES ( 125711, 'Marcel Noah', 'Zylla', '2000-01-14', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 158051, 'Przemyslaw Gabriel', 'Bargiel', '2000-03-26', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 161967, 'Javier', 'Ajenjo Hyjek', '2001-01-12', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 273435, 'Szymon', 'Krocz', '2000-03-16', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 305075, 'Adrian', 'Bukowski', '2003-03-18', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 324072, 'Filip', 'Gryglak', '2004-09-02', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 359697, 'Karol', 'Borys', '2006-09-28', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 3629, 'Jurgen', 'Celhaka', '2000-12-06', 339, NULL, 'AL' );
INSERT INTO player VALUES ( 30862, 'Lorenco', 'Simic', '1996-07-15', 345, NULL, 'HR' );
INSERT INTO player VALUES ( 40170, 'Daniel', 'Hoyo-Kowalski', '2003-07-12', 338, NULL, 'PL' );
INSERT INTO player VALUES ( 40231, 'Przemyslaw', 'Wisniewski', '1998-07-27', 340, NULL, 'PL' );
INSERT INTO player VALUES ( 40236, 'Krzysztof', 'Kubica', '2000-05-25', 340, NULL, 'PL' );
INSERT INTO player VALUES ( 40439, 'Blazej Szczepan', 'Augustyn', '1988-01-26', 336, NULL, 'PL' );
INSERT INTO player VALUES ( 40502, 'Milan', 'Dimun', '1996-09-19', 350, NULL, 'SK' );
INSERT INTO player VALUES ( 40616, 'Karol', 'Nojszewski', '1999-11-13', 339, NULL, 'PL' );
INSERT INTO player VALUES ( 40666, 'Lukasz', 'Seweryn', '2002-03-29', 3493, NULL, 'PL' );
INSERT INTO player VALUES ( 40851, 'Adrian', 'Cierpka', '1995-01-06', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 65393, 'Narek', 'Grigoryan', '2001-06-17', 336, NULL, 'AM' );
INSERT INTO player VALUES ( 148674, 'Kacper', 'Skibicki', '2001-10-11', 339, NULL, 'PL' );
INSERT INTO player VALUES ( 161835, 'Kacper', 'Rogozinski', '2001-04-20', 341, NULL, 'PL' );
INSERT INTO player VALUES ( 215916, 'Marcel', 'Vasil', '2001-02-09', 3487, NULL, 'SK' );
INSERT INTO player VALUES ( 270838, 'Bartlomiej', 'Kafel', '2003-10-03', 350, NULL, 'PL' );
INSERT INTO player VALUES ( 301778, 'Lukasz', 'Ziemnik', '2002-04-16', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 322501, 'Kacper', 'Skwierczynski', '2003-01-11', 339, NULL, 'PL' );
INSERT INTO player VALUES ( 323513, 'Wiktor', 'Kaminski', '2004-02-23', 339, NULL, 'PL' );
INSERT INTO player VALUES ( 324815, 'Pawel', 'Koncewicz-Zylka', '2003-10-29', 338, NULL, 'PL' );
INSERT INTO player VALUES ( 354201, 'Igor', 'Strzalek', '2004-01-19', 339, NULL, 'PL' );
INSERT INTO player VALUES ( 3447, 'Jorge Fernando', 'Barbosa Intima', '1995-09-21', 341, NULL, NULL );
INSERT INTO player VALUES ( 20637, 'Jason', 'Eyenga Lokilo', '1998-09-17', 6941, NULL, NULL );
INSERT INTO player VALUES ( 40324, 'Maciej', 'Jankowski', '1990-01-04', 3493, NULL, 'PL' );
INSERT INTO player VALUES ( 40391, 'Pawel', 'Stolarski', '1996-01-28', 348, NULL, 'PL' );
INSERT INTO player VALUES ( 40450, 'Michal', 'Mak', '1991-11-14', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 40577, 'Santeri', 'Hostikka', '1997-09-30', 348, NULL, 'FI' );
INSERT INTO player VALUES ( 40583, 'Kamil', 'Drygas', '1991-09-07', 348, NULL, 'PL' );
INSERT INTO player VALUES ( 40780, 'Kacper', 'Kostorz', '1999-08-21', 348, NULL, 'PL' );
INSERT INTO player VALUES ( 41066, 'Bartlomiej', 'Mruk', '2001-08-21', 348, NULL, 'PL' );
INSERT INTO player VALUES ( 41316, 'Rafael', 'Guimaraes Lopes', '1991-07-28', 339, NULL, 'PT' );
INSERT INTO player VALUES ( 47841, 'Lars Joseph', 'Ceesay', '1998-06-03', 343, NULL, 'SE' );
INSERT INTO player VALUES ( 129100, 'Kacper', 'Smolinski', '2001-02-07', 348, NULL, 'PL' );
INSERT INTO player VALUES ( 129102, 'Marcel', 'Wedrychowski', '2002-01-13', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 144030, 'Jan', 'Klimek', '2000-10-22', 3487, NULL, 'PL' );
INSERT INTO player VALUES ( 264761, 'Blazej', 'Starzycki', '2000-06-27', 348, NULL, 'PL' );
INSERT INTO player VALUES ( 268705, 'Mariusz', 'Fornalczyk', '2003-01-15', 348, NULL, 'PL' );
INSERT INTO player VALUES ( 269824, 'Bartosz', 'Klebaniuk', '2002-04-03', 348, NULL, 'PL' );
INSERT INTO player VALUES ( 302129, 'Pawel', 'Perdun', '2004-01-08', 6941, NULL, 'PL' );
INSERT INTO player VALUES ( 323517, 'Michal', 'Oczkowski', '2001-05-08', 341, NULL, 'PL' );
INSERT INTO player VALUES ( 337202, 'Dawid', 'Rezaeian', '2002-06-26', 348, NULL, 'PL' );
INSERT INTO player VALUES ( 2164, 'Tomasz Karol', 'Kedziora', '1994-06-11', 347, NULL, 'PL' );
INSERT INTO player VALUES ( 2183, 'Benjamin', 'Verbic', '1993-11-27', 339, NULL, 'SI' );
INSERT INTO player VALUES ( 7800, 'Aleksandr', 'Pavlovets', '1996-08-13', 3496, NULL, 'BY' );
INSERT INTO player VALUES ( 14401, 'Lirim', 'Kastrati', '1999-01-16', 339, NULL, 'XK' );
INSERT INTO player VALUES ( 26915, 'Stefanos', 'Evangelou', '1998-05-12', 340, NULL, 'GR' );
INSERT INTO player VALUES ( 36914, 'Mickey', 'van der Hart', '1994-06-13', 347, NULL, 'NL' );
INSERT INTO player VALUES ( 36981, 'Pelle', 'van Amersfoort', '1996-04-01', 350, NULL, 'NL' );
INSERT INTO player VALUES ( 40201, 'Ivan', 'Marquez Alvarez', '1994-06-09', 350, NULL, 'ES' );
INSERT INTO player VALUES ( 40209, 'Michal', 'Gardawski', '1990-09-25', 350, NULL, 'DE' );
INSERT INTO player VALUES ( 40335, 'Wojciech', 'Golla', '1992-01-12', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 40465, 'Grzegorz', 'Sandomierski', '1989-09-05', 340, NULL, 'PL' );
INSERT INTO player VALUES ( 40555, 'Pedro Miguel', 'Amorim Pereira Silva', '1988-08-31', 347, NULL, 'PT' );
INSERT INTO player VALUES ( 43357, 'Dusan', 'Lagator', '1994-03-29', 341, NULL, 'ME' );
INSERT INTO player VALUES ( 53642, 'Ilya', 'Zhigulev', '1996-02-01', 345, NULL, 'RU' );
INSERT INTO player VALUES ( 61179, 'Krisztofer Andras', 'Vida', '1995-06-23', 349, NULL, 'HU' );
INSERT INTO player VALUES ( 61242, 'Michal', 'Skvarka', '1992-08-19', 338, NULL, 'SK' );
INSERT INTO player VALUES ( 105636, 'Rafal', 'Makowski', '1996-08-05', 337, NULL, 'PL' );
INSERT INTO player VALUES ( 119836, 'Diego', 'Silva Nascimento Santos', '1998-02-06', 336, NULL, 'BR' );
INSERT INTO player VALUES ( 278941, 'Abraham Ayomide', 'Marcus', '2000-01-02', 4248, NULL, 'NG' );
INSERT INTO player VALUES ( 290118, 'Luka', 'Gagnidze', '2003-02-28', 3491, NULL, 'GE' );
INSERT INTO player VALUES ( 2439, 'Jhon Carlos', 'Chancellor Cedeno', '1992-01-02', 345, NULL, 'VE' );
INSERT INTO player VALUES ( 3565, 'David Nue', 'Domgjoni', '1997-05-21', 3487, NULL, 'XK' );
INSERT INTO player VALUES ( 10064, 'Rhuan', 'da Silveira Castro', '2000-01-25', 4248, NULL, 'BR' );
INSERT INTO player VALUES ( 14720, 'Roko', 'Baturina', '2000-06-20', 347, NULL, 'HR' );
INSERT INTO player VALUES ( 17843, 'Karl Sebastian', 'Ring', '1995-04-18', 338, NULL, 'SE' );
INSERT INTO player VALUES ( 40165, 'Mateusz', 'Lis', '1997-02-27', 338, NULL, 'PL' );
INSERT INTO player VALUES ( 40234, 'Ishmael', 'Baidoo', '1998-12-01', 340, NULL, 'GH' );
INSERT INTO player VALUES ( 40336, 'Mateusz', 'Holownia', '1998-05-06', 339, NULL, 'PL' );
INSERT INTO player VALUES ( 40392, 'Mateusz', 'Wieteska', '1997-02-11', 339, NULL, 'PL' );
INSERT INTO player VALUES ( 40533, 'Lukasz', 'Poreba', '2000-03-13', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 40657, 'Rafal', 'Straczek', '1999-02-12', 3493, NULL, 'PL' );
INSERT INTO player VALUES ( 41165, 'Alexandre Xavier', 'Pereira Guedes', '1994-02-11', 3491, NULL, 'PT' );
INSERT INTO player VALUES ( 41236, 'Goncalo Filipe', 'Oliveira Silva', '1991-06-04', 4248, NULL, 'PT' );
INSERT INTO player VALUES ( 41344, 'Lucas', 'Lima Linhares', '1996-09-28', 339, NULL, 'BR' );
INSERT INTO player VALUES ( 45771, 'Dorde', 'Crnomarkovic', '1993-09-10', 347, NULL, 'RS' );
INSERT INTO player VALUES ( 47145, 'Higinio', 'Marin Escavy', '1993-10-19', 340, NULL, 'ES' );
INSERT INTO player VALUES ( 47151, 'Yaw', 'Yeboah', '1997-03-28', 338, NULL, 'GH' );
INSERT INTO player VALUES ( 80207, 'Stefan', 'Savic', '1994-01-09', 338, NULL, 'AT' );
INSERT INTO player VALUES ( 109691, 'David', 'Tijanic', '1997-07-16', 3491, NULL, 'SI' );
INSERT INTO player VALUES ( 109710, 'Luka', 'Susnjara', '1997-04-04', 341, NULL, 'SI' );
INSERT INTO player VALUES ( 1078, 'Jakub', 'Swierczok', '1992-12-28', 349, NULL, 'PL' );
INSERT INTO player VALUES ( 40206, 'Felicio Anando', 'Brown Forbes', '1991-08-28', 338, NULL, NULL );
INSERT INTO player VALUES ( 40241, 'Jesus', 'Jimenez Nunez', '1993-11-05', 340, NULL, 'ES' );
INSERT INTO player VALUES ( 40296, 'Karol Jerzy', 'Angielski', '1996-03-20', 4248, NULL, 'PL' );
INSERT INTO player VALUES ( 40298, 'Oskar', 'Zawada', '1996-02-01', 3493, NULL, 'PL' );
INSERT INTO player VALUES ( 40540, 'Patryk', 'Szysz', '1998-04-01', 345, NULL, 'PL' );
INSERT INTO player VALUES ( 40645, 'Daniel', 'Ramirez Fernandez', '1992-06-18', 347, NULL, 'ES' );
INSERT INTO player VALUES ( 56085, 'Georgy', 'Zhukov', '1994-11-19', 338, NULL, 'KZ' );
INSERT INTO player VALUES ( 63536, 'Adi', 'Mehremic', '1992-04-26', 338, NULL, NULL );
INSERT INTO player VALUES ( 66011, 'Matej', 'Hanousek', '1993-06-02', 338, NULL, NULL );
INSERT INTO player VALUES ( 153623, 'Jordan Alan', 'Courtney-Perkins', '2002-11-06', 3496, NULL, 'AU' );
INSERT INTO player VALUES ( 199185, 'Witan', 'Sulaeman', '2001-10-08', 343, NULL, 'ID' );

commit;
