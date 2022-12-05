/* ORDER OF LOADING */
-- COUNTRY
-- LEAGUE
-- STADIUM
-- CLUB
-- COACH
-- POSITION
-- PLAYER_STATS
-- PLAYER

/* NOT INCLUDED:
   1. match //dynamic
   2. card //dynamic
   3. referee //not in api
   4. club_history // dynamic
   5. trophy // dynamic
   6. Standings ?
 */

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

INSERT INTO league VALUES ( 107, 'I Liga', 'PL' );
INSERT INTO league VALUES ( 106, 'Ekstraklasa', 'PL' );
INSERT INTO league VALUES ( 108, 'Cup', 'PL' );
INSERT INTO league VALUES ( 109, 'II Liga - East', 'PL' );
INSERT INTO league VALUES ( 676, 'Central Youth League', 'PL' );
INSERT INTO league VALUES ( 783, 'III Liga - Group 4', 'PL' );
INSERT INTO league VALUES ( 782, 'III Liga - Group 3', 'PL' );
INSERT INTO league VALUES ( 781, 'III Liga - Group 2', 'PL' );
INSERT INTO league VALUES ( 780, 'III Liga - Group 1', 'PL' );
INSERT INTO league VALUES ( 727, 'Super Cup', 'PL' );

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

-- LEAGUE: 107

INSERT INTO club VALUES ( 335, 'Miedz Legnica', 'PL', 583000, 107, 1254 );
INSERT INTO club VALUES ( 342, 'Zaglebie Sosnowiec', 'PL', 804000, 107, 1261 );
INSERT INTO club VALUES ( 344, 'Arka Gdynia', 'PL', 459000, 107, 1246 );
INSERT INTO club VALUES ( 346, 'Korona Kielce', 'PL', 116000, 107, 1250 );
INSERT INTO club VALUES ( 3483, 'Chrobry Glogow', 'PL', 396000, 107, 2284 );
INSERT INTO club VALUES ( 3484, 'GKS Katowice', 'PL', 405000, 107, 2285 );
INSERT INTO club VALUES ( 3486, 'Jastrzebie', 'PL', 166000, 107, 2287 );
INSERT INTO club VALUES ( 3488, 'Odra Opole', 'PL', 116000, 107, 2289 );
INSERT INTO club VALUES ( 3489, 'Podbeskidzie', 'PL', 966000, 107, 2290 );
INSERT INTO club VALUES ( 3490, 'Puszcza Niepolomice', 'PL', 400000, 107, 2291 );
INSERT INTO club VALUES ( 3492, 'Sandecja Nowy Sacz', 'PL', 571000, 107, 2293 );
INSERT INTO club VALUES ( 3494, 'Stomil Olsztyn', 'PL', 787000, 107, 2295 );
INSERT INTO club VALUES ( 3495, 'Tychy 71', 'PL', 548000, 107, 2296 );
INSERT INTO club VALUES ( 3498, 'LKS Lodz', 'PL', 615000, 107, 12602 );
INSERT INTO club VALUES ( 6951, 'Resovia Rzeszow', 'PL', 522000, 107, 5075 );
INSERT INTO club VALUES ( 6954, 'SKRA Czestochowa', 'PL', 513000, 107, 3241 );
INSERT INTO club VALUES ( 6962, 'Widzew Lodz', 'PL', 76000, 107, 5080 );
INSERT INTO club VALUES ( 9132, 'Gornik Polkowice', 'PL', 205000, 107, 6319 );

--NO ERRORS

-- LEAGUE: 106

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


-- LEAGUE: 109

INSERT INTO club VALUES ( 3482, 'Chojniczanka Chojnice', 'PL', 92000, 109, 2283 );
INSERT INTO club VALUES ( 3485, 'Garbarnia Krakow', 'PL', 835000, 109, 2286 );
INSERT INTO club VALUES ( 3497, 'Wigry Suwalki', 'PL', 545000, 109, 2298 );
INSERT INTO club VALUES ( 4246, 'Belchatow', 'PL', 363000, 109, 3241 );
INSERT INTO club VALUES ( 6942, 'Hutnik Krakow', 'PL', 297000, 109, 2286 );
INSERT INTO club VALUES ( 6945, 'Olimpia Elblag', 'PL', 36000, 109, 5063 );
INSERT INTO club VALUES ( 6947, 'Pogon Siedlce', 'PL', 163000, 109, 5065 );
INSERT INTO club VALUES ( 6953, 'Ruch Chorzow', 'PL', 615000, 109, 5071 );
INSERT INTO club VALUES ( 6957, 'Stal Rzeszow', 'PL', 152000, 109, 5075 );
INSERT INTO club VALUES ( 6964, 'Znicz Pruszkow', 'PL', 346000, 109, 5082 );
INSERT INTO club VALUES ( 9133, 'Lech Poznan II', 'PL', 638000, 109, 6320 );
INSERT INTO club VALUES ( 12801, 'Kalisz', 'PL', 885000, 109, 8157 );
INSERT INTO club VALUES ( 12837, 'Radunia Stezyca', 'PL', 594000, 109, 8186 );
INSERT INTO club VALUES ( 12857, 'Sokol Ostroda', 'PL', 216000, 109, 8203 );
INSERT INTO club VALUES ( 12900, 'Slask Wroclaw II', 'PL', 977000, 109, 8240 );
INSERT INTO club VALUES ( 14562, 'Motor Lublin', 'PL', 990000, 109, 11992 );
INSERT INTO club VALUES ( 14750, 'Pogon Grod. Mazowiecki', 'PL', 982000, 109, 11326 );
INSERT INTO club VALUES ( 16272, 'Wisla Pulawy', 'PL', 59000, 109, 11371 );

--NO ERRORS


-- LEAGUE: 783

INSERT INTO club VALUES ( 6936, 'Chelmianka Chelm', 'PL', 510000, 783, 5055 );
INSERT INTO club VALUES ( 6943, 'KSZO 1929', 'PL', 229000, 783, 5061 );
INSERT INTO club VALUES ( 6955, 'Siarka Tarnobrzeg', 'PL', 427000, 783, 5073 );
INSERT INTO club VALUES ( 6958, 'Stal Stalowa Wola', 'PL', 254000, 783, 11362 );
INSERT INTO club VALUES ( 12834, 'Podhale Nowy Targ', 'PL', 972000, 783, 8183 );
INSERT INTO club VALUES ( 14144, 'Orleta Radzyn Podlaski', 'PL', 625000, 783, 11363 );
INSERT INTO club VALUES ( 16264, 'Avia Swidnik', 'PL', 423000, 783, 11364 );
INSERT INTO club VALUES ( 16265, 'Cracovia Krakow II', 'PL', 867000, 783, 11365 );
INSERT INTO club VALUES ( 16269, 'Podlasie Biala Podlaska', 'PL', 739000, 783, 12620 );
INSERT INTO club VALUES ( 16270, 'Sokol Sieniawa', 'PL', 978000, 783, 11369 );
INSERT INTO club VALUES ( 16273, 'Wisla Sandomierz', 'PL', 450000, 783, 11372 );
INSERT INTO club VALUES ( 16274, 'Wisloka Debica', 'PL', 612000, 783, 11373 );
INSERT INTO club VALUES ( 16276, 'Wolczanka W. Pelkinska', 'PL', 354000, 783, 11374 );
INSERT INTO club VALUES ( 16277, 'Lagow', 'PL', 855000, 783, 12142 );
INSERT INTO club VALUES ( 17322, 'Unia Tarnow', 'PL', 500000, 783, 12155 );
INSERT INTO club VALUES ( 17403, 'Czarni Polaniec', 'PL', 506000, 783, 12156 );
INSERT INTO club VALUES ( 17405, 'Tomasovia Tomaszow', 'PL', 456000, 783, 12157 );

--ERRORS
INSERT INTO club VALUES ( 17404, 'Korona Rzeszow', 'PL', 743000, 783, NULL );


-- LEAGUE: 782

INSERT INTO club VALUES ( 6950, 'Rekord Bielsko-Biala', 'PL', 210000, 782, 5068 );
INSERT INTO club VALUES ( 6956, 'Stal Brzeg', 'PL', 31000, 782, 5074 );
INSERT INTO club VALUES ( 6963, 'Zaglebie Lubin II', 'PL', 439000, 782, 1260 );
INSERT INTO club VALUES ( 12776, 'Gornik Zabrze II', 'PL', 543000, 782, 11350 );
INSERT INTO club VALUES ( 12806, 'Kluczbork', 'PL', 160000, 782, 8161 );
INSERT INTO club VALUES ( 12815, 'Miedz Legnica II', 'PL', 426000, 782, 11351 );
INSERT INTO club VALUES ( 12835, 'Polonia Bytom', 'PL', 55000, 782, 11352 );
INSERT INTO club VALUES ( 12901, 'Sleza Wroclaw', 'PL', 973000, 782, 11353 );
INSERT INTO club VALUES ( 14143, 'Lechia Zielona Gora', 'PL', 752000, 782, 11354 );
INSERT INTO club VALUES ( 14267, 'Pawlowice Slaskie', 'PL', 376000, 782, 11356 );
INSERT INTO club VALUES ( 16258, 'Gac Olawa', 'PL', 524000, 782, 11357 );
INSERT INTO club VALUES ( 16259, 'Goczalkowice Zdroj', 'PL', 900000, 782, 12619 );
INSERT INTO club VALUES ( 16260, 'Gwarek Tarnowskie Gory', 'PL', 58000, 782, 11359 );
INSERT INTO club VALUES ( 16261, 'Piast Zmigrod', 'PL', 41000, 782, 11360 );
INSERT INTO club VALUES ( 16263, 'Warta Gorzow', 'PL', 403000, 782, 5078 );
INSERT INTO club VALUES ( 17075, 'Odra Wodzislaw', 'PL', 535000, 782, 12293 );
INSERT INTO club VALUES ( 17401, 'Carina Gubin', 'PL', 777000, 782, 18849 );
INSERT INTO club VALUES ( 17402, 'Karkonosze Jelenia Gora', 'PL', 89000, 782, 19259 );

--NO ERRORS

-- LEAGUE: 781

INSERT INTO club VALUES ( 4247, 'Olimpia Grudziadz', 'PL', 122000, 781, 3242 );
INSERT INTO club VALUES ( 6938, 'Elana Torun', 'PL', 486000, 781, 5057 );
INSERT INTO club VALUES ( 6948, 'Polonia Sroda', 'PL', 588000, 781, 5066 );
INSERT INTO club VALUES ( 6959, 'Stargard Szczecinski', 'PL', 483000, 781, 5077 );
INSERT INTO club VALUES ( 12884, 'Unia Janikowo', 'PL', 477000, 781, 8225 );
INSERT INTO club VALUES ( 12902, 'Swit Skolwin', 'PL', 724000, 781, 8242 );
INSERT INTO club VALUES ( 13843, 'Zawisza Bydgoszcz', 'PL', 716000, 781, 8563 );
INSERT INTO club VALUES ( 16244, 'Baltyk Gdynia', 'PL', 528000, 781, 11338 );
INSERT INTO club VALUES ( 16245, 'Baltyk Koszalin', 'PL', 724000, 781, 11339 );
INSERT INTO club VALUES ( 16248, 'Jarota Jarocin', 'PL', 539000, 781, 11342 );
INSERT INTO club VALUES ( 16249, 'Kotwica Kolobrzeg', 'PL', 934000, 781, 11343 );
INSERT INTO club VALUES ( 16252, 'Pogon Szczecin II', 'PL', 801000, 781, 1256 );
INSERT INTO club VALUES ( 16254, 'Przodkowo', 'PL', 464000, 781, 11346 );
INSERT INTO club VALUES ( 16255, 'Sokol Kleczew', 'PL', 947000, 781, 11347 );
INSERT INTO club VALUES ( 16256, 'Starogard Gdanski', 'PL', 822000, 781, 11348 );
INSERT INTO club VALUES ( 17399, 'Pogon Nowe Skalmierzyce', 'PL', 109000, 781, 12731 );
INSERT INTO club VALUES ( 17400, 'Stolem Gniewino', 'PL', 227000, 781, 18706 );

--ERRORS
INSERT INTO club VALUES ( 17398, 'Kluczevia Stargard', 'PL', 812000, 781, NULL );


-- LEAGUE: 780

INSERT INTO club VALUES ( 6944, 'Legia Warszawa II', 'PL', 604000, 780, 11952 );
INSERT INTO club VALUES ( 6961, 'Unia Skierniewice', 'PL', 147000, 780, 5079 );
INSERT INTO club VALUES ( 9134, 'Legionovia Legionowo', 'PL', 205000, 780, 6321 );
INSERT INTO club VALUES ( 12829, 'Pelikan Lowicz', 'PL', 983000, 780, 8179 );
INSERT INTO club VALUES ( 12856, 'Sokol Aleksandrow', 'PL', 428000, 780, 8202 );
INSERT INTO club VALUES ( 12869, 'Swit', 'PL', 171000, 780, 5062 );
INSERT INTO club VALUES ( 12899, 'Znicz Biala Piska', 'PL', 396000, 780, 8239 );
INSERT INTO club VALUES ( 16233, 'Bron Radom', 'PL', 197000, 780, 18635 );
INSERT INTO club VALUES ( 16234, 'Blonianka Blonie', 'PL', 935000, 780, 11327 );
INSERT INTO club VALUES ( 16236, 'Jagiellonia II', 'PL', 552000, 780, 12153 );
INSERT INTO club VALUES ( 16237, 'Kutno', 'PL', 717000, 780, 11330 );
INSERT INTO club VALUES ( 16238, 'Lechia T. Mazowiecki', 'PL', 48000, 780, 11331 );
INSERT INTO club VALUES ( 16239, 'Polonia Warszawa', 'PL', 208000, 780, 11332 );
INSERT INTO club VALUES ( 16241, 'Ursus Warszawa', 'PL', 183000, 780, 11334 );
INSERT INTO club VALUES ( 16243, 'Wikielec', 'PL', 958000, 780, 11336 );
INSERT INTO club VALUES ( 17394, 'Mamry Gizycko', 'PL', 758000, 780, 12704 );
INSERT INTO club VALUES ( 17395, 'Pilica Bialobrzegi', 'PL', 227000, 780, 18845 );
INSERT INTO club VALUES ( 17396, 'Wissa Szczuczyn', 'PL', 520000, 780, 12154 );
INSERT INTO club VALUES ( 17397, 'LKS Lodz II', 'PL', 717000, 780, 18846 );

--NO ERRORS

commit;

/* COACH */
-- TEAM: 335


--ERRORS
INSERT INTO coach VALUES ( 11988, 'I. Koscielniak', 'Koscielniak', '1974-01-16', 'PL', 335, NULL );
INSERT INTO coach VALUES ( 15064, 'W. Lobodzinski', 'Lobodzinski', '1982-10-20', 'PL', 335, NULL );


-- TEAM: 342


--ERRORS
INSERT INTO coach VALUES ( 1218, 'K. Moskal', 'Moskal', '1967-01-09', 'PL', 342, NULL );
INSERT INTO coach VALUES ( 1240, 'A. Skowronek', 'Skowronek', '1982-05-22', 'PL', 342, NULL );
INSERT INTO coach VALUES ( 11935, 'K. Debek', 'Debek', '1978-09-18', 'PL', 342, NULL );


-- TEAM: 344


--ERRORS
INSERT INTO coach VALUES ( 1245, 'R. Tarasiewicz', 'Tarasiewicz', '1962-04-27', 'PL', 344, NULL );
INSERT INTO coach VALUES ( 2618, 'D. Marzec', 'Marzec', '1969-09-14', 'PL', 344, NULL );


-- TEAM: 346


--ERRORS
INSERT INTO coach VALUES ( 1226, 'L. Ojrzynski', 'Ojrzynski', '1972-05-31', 'PL', 346, NULL );
INSERT INTO coach VALUES ( 1237, 'D. Nowak', 'Nowak', '1972-02-07', 'PL', 346, NULL );


-- TEAM: 3483


--ERRORS
INSERT INTO coach VALUES ( 1238, 'I. Djurdjevic', 'Durdevic', '1977-02-05', 'RS', 3483, NULL );
INSERT INTO coach VALUES ( 4448, 'G. Nicinski', 'Nicinski', '1973-05-16', 'PL', 3483, NULL );
INSERT INTO coach VALUES ( 14033, 'M. Golebiewski', 'Golebiewski', '1980-05-18', 'PL', 3483, NULL );


-- TEAM: 3484


--ERRORS
INSERT INTO coach VALUES ( 5049, 'R. Gorak', 'Gorak', '1973-03-30', 'PL', 3484, NULL );


-- TEAM: 3486


--ERRORS
INSERT INTO coach VALUES ( 5659, 'J. Trzeciak', 'Trzeciak', '1971-12-26', 'PL', 3486, NULL );
INSERT INTO coach VALUES ( 6463, 'P. Sciebura', 'Sciebura', '1985-05-11', 'PL', 3486, NULL );
INSERT INTO coach VALUES ( 14372, 'L. Wlodarek', 'Wlodarek', '1987-09-21', 'PL', 3486, NULL );
INSERT INTO coach VALUES ( 16212, 'M. Galikowski', 'Galikowski', NULL, 'PL', 3486, NULL );
INSERT INTO coach VALUES ( 16356, 'G. Kurdziel', 'Kurdziel', '1976-08-07', 'PL', 3486, NULL );


-- TEAM: 3488


--ERRORS
INSERT INTO coach VALUES ( 1253, 'P. Plewnia', 'Plewnia', '1977-05-29', 'PL', 3488, NULL );
INSERT INTO coach VALUES ( 8069, 'D. Brehmer', 'Brehmer', '1974-12-27', 'PL', 3488, NULL );


-- TEAM: 3489


--ERRORS
INSERT INTO coach VALUES ( 1233, 'M. Smyla', 'Smyla', '1969-07-25', 'PL', 3489, NULL );
INSERT INTO coach VALUES ( 1243, 'K. Brede', 'Brede', '1981-02-08', 'PL', 3489, NULL );
INSERT INTO coach VALUES ( 12390, 'P. Jawny', 'Jawny', '1971-10-18', 'PL', 3489, NULL );
INSERT INTO coach VALUES ( 13825, 'H. Kosciukiewicz', 'Kosciukiewicz', '1978-10-24', 'PL', 3489, NULL );
INSERT INTO coach VALUES ( 13912, 'R. Kasperczyk', 'Kasperczyk', '1967-01-22', 'PL', 3489, NULL );


-- TEAM: 3490


--ERRORS
INSERT INTO coach VALUES ( 1235, 'T. Tulacz', 'Tulacz', '1969-12-29', 'PL', 3490, NULL );


-- TEAM: 3492

commit;

/* POSITION */

/* PLAYER_STATS */
/* PLAYER */
