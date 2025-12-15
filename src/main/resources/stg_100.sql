DROP TABLE IF EXISTS tbcsk;

CREATE TABLE tbcsk AS
SELECT
a.id,
a.first_name,
a.last_name,
a.cd_country,
a.age,
case when c.cd_player_role_id in (1,3) then 1 else 0 end as in_bat,
case when c.cd_player_role_id in (2,3) then 1 else 0 end as in_bowl,
case when c.cd_player_role_id in (4) then 1 else 0 end as in_wk,
a.cd_player_role,
a.cd_batting_style,
a.in_cap,
a.in_overseas,
a.am_base_rupees,
a.am_base_dollar,
a.dc_category,
a.dc_status
FROM tbplayerstats a
LEFT JOIN ctplayerrole c ON a.cd_player_role = c.cd_player_role
WHERE cd_team = 'CSK';

DROP TABLE IF EXISTS tbdc;

CREATE TABLE tbdc AS
SELECT
a.id,
a.first_name,
a.last_name,
a.cd_country,
a.age,
case when c.cd_player_role_id in (1,3) then 1 else 0 end as in_bat,
case when c.cd_player_role_id in (2,3) then 1 else 0 end as in_bowl,
case when c.cd_player_role_id in (4) then 1 else 0 end as in_wk,
a.cd_player_role,
a.cd_batting_style,
a.in_cap,
a.in_overseas,
a.am_base_rupees,
a.am_base_dollar,
a.dc_category,
a.dc_status
FROM tbplayerstats a
LEFT JOIN ctplayerrole c ON a.cd_player_role = c.cd_player_role
WHERE cd_team = 'DC';


DROP TABLE IF EXISTS tbgt;

CREATE TABLE tbgt AS
SELECT
a.id,
a.first_name,
a.last_name,
a.cd_country,
a.age,
case when c.cd_player_role_id in (1,3) then 1 else 0 end as in_bat,
case when c.cd_player_role_id in (2,3) then 1 else 0 end as in_bowl,
case when c.cd_player_role_id in (4) then 1 else 0 end as in_wk,
a.cd_player_role,
a.cd_batting_style,
a.in_cap,
a.in_overseas,
a.am_base_rupees,
a.am_base_dollar,
a.dc_category,
a.dc_status
FROM tbplayerstats a
LEFT JOIN ctplayerrole c ON a.cd_player_role = c.cd_player_role
WHERE cd_team = 'GT';


DROP TABLE IF EXISTS tbkkr;

CREATE TABLE tbkkr AS
SELECT
a.id,
a.first_name,
a.last_name,
a.cd_country,
a.age,
case when c.cd_player_role_id in (1,3) then 1 else 0 end as in_bat,
case when c.cd_player_role_id in (2,3) then 1 else 0 end as in_bowl,
case when c.cd_player_role_id in (4) then 1 else 0 end as in_wk,
a.cd_player_role,
a.cd_batting_style,
a.in_cap,
a.in_overseas,
a.am_base_rupees,
a.am_base_dollar,
a.dc_category,
a.dc_status
FROM tbplayerstats a
LEFT JOIN ctplayerrole c ON a.cd_player_role = c.cd_player_role
WHERE cd_team = 'KKR';


DROP TABLE IF EXISTS tblsg;

CREATE TABLE tblsg AS
SELECT
a.id,
a.first_name,
a.last_name,
a.cd_country,
a.age,
case when c.cd_player_role_id in (1,3) then 1 else 0 end as in_bat,
case when c.cd_player_role_id in (2,3) then 1 else 0 end as in_bowl,
case when c.cd_player_role_id in (4) then 1 else 0 end as in_wk,
a.cd_player_role,
a.cd_batting_style,
a.in_cap,
a.in_overseas,
a.am_base_rupees,
a.am_base_dollar,
a.dc_category,
a.dc_status
FROM tbplayerstats a
LEFT JOIN ctplayerrole c ON a.cd_player_role = c.cd_player_role
WHERE cd_team = 'LSG';


DROP TABLE IF EXISTS tbmi;

CREATE TABLE tbmi AS
SELECT
a.id,
a.first_name,
a.last_name,
a.cd_country,
a.age,
case when c.cd_player_role_id in (1,3) then 1 else 0 end as in_bat,
case when c.cd_player_role_id in (2,3) then 1 else 0 end as in_bowl,
case when c.cd_player_role_id in (4) then 1 else 0 end as in_wk,
a.cd_player_role,
a.cd_batting_style,
a.in_cap,
a.in_overseas,
a.am_base_rupees,
a.am_base_dollar,
a.dc_category,
a.dc_status
FROM tbplayerstats a
LEFT JOIN ctplayerrole c ON a.cd_player_role = c.cd_player_role
WHERE cd_team = 'MI';


DROP TABLE IF EXISTS tbpbks;

CREATE TABLE tbpbks AS
SELECT
a.id,
a.first_name,
a.last_name,
a.cd_country,
a.age,
case when c.cd_player_role_id in (1,3) then 1 else 0 end as in_bat,
case when c.cd_player_role_id in (2,3) then 1 else 0 end as in_bowl,
case when c.cd_player_role_id in (4) then 1 else 0 end as in_wk,
a.cd_player_role,
a.cd_batting_style,
a.in_cap,
a.in_overseas,
a.am_base_rupees,
a.am_base_dollar,
a.dc_category,
a.dc_status
FROM tbplayerstats a
LEFT JOIN ctplayerrole c ON a.cd_player_role = c.cd_player_role
WHERE cd_team = 'PBKS';


DROP TABLE IF EXISTS tbrr;

CREATE TABLE tbrr AS
SELECT
a.id,
a.first_name,
a.last_name,
a.cd_country,
a.age,
case when c.cd_player_role_id in (1,3) then 1 else 0 end as in_bat,
case when c.cd_player_role_id in (2,3) then 1 else 0 end as in_bowl,
case when c.cd_player_role_id in (4) then 1 else 0 end as in_wk,
a.cd_player_role,
a.cd_batting_style,
a.in_cap,
a.in_overseas,
a.am_base_rupees,
a.am_base_dollar,
a.dc_category,
a.dc_status
FROM tbplayerstats a
LEFT JOIN ctplayerrole c ON a.cd_player_role = c.cd_player_role
WHERE cd_team = 'RR';


DROP TABLE IF EXISTS tbrcb;

CREATE TABLE tbrcb AS
SELECT
a.id,
a.first_name,
a.last_name,
a.cd_country,
a.age,
case when c.cd_player_role_id in (1,3) then 1 else 0 end as in_bat,
case when c.cd_player_role_id in (2,3) then 1 else 0 end as in_bowl,
case when c.cd_player_role_id in (4) then 1 else 0 end as in_wk,
a.cd_player_role,
a.cd_batting_style,
a.in_cap,
a.in_overseas,
a.am_base_rupees,
a.am_base_dollar,
a.dc_category,
a.dc_status
FROM tbplayerstats a
LEFT JOIN ctplayerrole c ON a.cd_player_role = c.cd_player_role
WHERE cd_team = 'RCB';


DROP TABLE IF EXISTS tbsrh;

CREATE TABLE tbsrh AS
SELECT
a.id,
a.first_name,
a.last_name,
a.cd_country,
a.age,
case when c.cd_player_role_id in (1,3) then 1 else 0 end as in_bat,
case when c.cd_player_role_id in (2,3) then 1 else 0 end as in_bowl,
case when c.cd_player_role_id in (4) then 1 else 0 end as in_wk,
a.cd_player_role,
a.cd_batting_style,
a.in_cap,
a.in_overseas,
a.am_base_rupees,
a.am_base_dollar,
a.dc_category,
a.dc_status
FROM tbplayerstats a
LEFT JOIN ctplayerrole c ON a.cd_player_role = c.cd_player_role
WHERE cd_team = 'SRH';

----------- xxx ------------
DROP TABLE IF EXISTS stg_tbauctionplayer_100;

CREATE TABLE stg_tbauctionplayer_100 AS
SELECT
a.id,
a.set_no,
g.cd_set_id,
a.first_name,
a.last_name,
b.cd_country_id,
a.cd_state_assoc,
a.age,
a.cd_player_role,
c.cd_player_role_id,
case when c.cd_player_role_id in (1,3) then 1 else 0 end as in_bat,
case when c.cd_player_role_id in (2,3) then 1 else 0 end as in_bowl,
case when c.cd_player_role_id in (4) then 1 else 0 end as in_wk,
case when a.cd_batting_style = 'LHB' then 1 else 0 end as in_bat_style,
a.in_cap,
a.in_overseas,
f.cd_team_id,
a.cnt_test_caps,
a.cnt_odi_caps,
a.cnt_t20i_caps,
a.cnt_ipl_caps,
a.cnt_match_last_season,
a.am_base_rupees,
a.am_base_dollar,
d.cd_cetegory_id,
e.cd_status_id
FROM tbplayerstats a
LEFT JOIN ctcountry b ON a.cd_country = b.cd_country
LEFT JOIN ctplayerrole c ON a.cd_player_role = c.cd_player_role
LEFT JOIN ctplayercategory d ON a.cd_player_role = d.cd_player_role and a.in_cap = d.in_cap and a.in_overseas = d.in_overseas and a.am_base_rupees = d.am_base_rupees
LEFT JOIN ctplayerstatus e ON a.dc_status = e.dc_status
LEFT JOIN ctteam f ON a.cd_team = f.cd_team
LEFT JOIN ctsetid g ON a.id_set = g.id_set;


DROP TABLE IF EXISTS stg_tbauctionplayer_200;

CREATE TABLE stg_tbauctionplayer_200 AS
SELECT
a.id,
a.cd_set_id,
a.cd_state_assoc,
10 * (80 - a.cd_set_id) as pt_auction_set,
case when a.cd_set_id = 0 then 25000 else 0 end as pt_retain,
case when a.cd_country_id = 8 then 50 else 0 end as pt_country,
b.pt_age,
a.cd_player_role,
a.cd_player_role_id,
50 * a.in_bat as pt_bat,
50 * a.in_bowl as pt_bwl,
50 * a.in_wk as pt_wk,
20 * a.in_bat_style as pt_bat_style,
50 * a.in_cap as pt_cap,
a.in_overseas,
case when a.in_overseas <> 1 then 10 else 0 end as pt_indian,
case when a.cnt_test_caps > 0 then 500 else 0 end as pt_test_cap,
a.cnt_test_caps,
case when a.cnt_odi_caps > 0 then 200 else 0 end as pt_odi_cap,
a.cnt_odi_caps,
case when a.cnt_t20i_caps > 0 then 100 else 0 end as pt_t20i_cap,
a.cnt_t20i_caps,
a.cnt_ipl_caps,
case when a.cnt_match_last_season > 0 then 50 else 0 end as pt_last_season,
a.am_base_rupees,
a.am_base_dollar,
5 * (80 - a.cd_cetegory_id) as pt_category,
a.cd_status_id,
FLOOR(-10 + (RAND() * 51)) AS pt_luck
FROM stg_tbauctionplayer_100 a
LEFT JOIN ctage b ON a.age = b.age;


DROP TABLE IF EXISTS stg_tbauctionplayer_300;

CREATE TABLE stg_tbauctionplayer_300 AS
SELECT
a.id,
a.cd_set_id,
a.cd_state_assoc,
a.pt_auction_set,
a.pt_retain,
a.pt_country,
a.pt_age,
a.cd_player_role,
a.cd_player_role_id,
a.pt_bat,
a.pt_bwl,
a.pt_wk,
a.pt_bat_style,
a.pt_cap,
a.in_overseas,
a.pt_indian,
a.pt_test_cap,
a.cnt_test_caps,
a.pt_odi_cap,
a.cnt_odi_caps,
a.pt_t20i_cap,
a.cnt_t20i_caps,
a.cnt_ipl_caps,
a.pt_last_season,
a.am_base_rupees,
a.am_base_dollar,
a.pt_category,
a.cd_status_id,
(a.pt_auction_set + a.pt_retain + a.pt_country + a.pt_age + a.pt_bat + a.pt_bwl + a.pt_wk + a.pt_bat_style + a.pt_cap + a.pt_indian + a.pt_test_cap + a.cnt_test_caps + a.pt_odi_cap + a.cnt_odi_caps + a.pt_t20i_cap + a.cnt_t20i_caps + a.cnt_ipl_caps + a.pt_last_season + a.pt_luck) as total_points
FROM stg_tbauctionplayer_200 a;


DROP TABLE IF EXISTS tbauctionplayer;

CREATE TABLE tbauctionplayer AS
SELECT
a.id,
a.cd_set_id,
a.cd_state_assoc,
a.pt_auction_set,
a.pt_retain,
a.pt_country,
a.pt_age,
a.cd_player_role,
a.cd_player_role_id,
a.pt_bat,
a.pt_bwl,
a.pt_wk,
a.pt_bat_style,
a.pt_cap,
a.in_overseas,
a.pt_indian,
a.pt_test_cap,
a.cnt_test_caps,
a.pt_odi_cap,
a.cnt_odi_caps,
a.pt_t20i_cap,
a.cnt_t20i_caps,
a.cnt_ipl_caps,
a.pt_last_season,
a.am_base_rupees,
a.am_base_dollar,
a.pt_category,
a.cd_status_id,
a.total_points,
a.total_points / (a.am_base_rupees / 100000) as rating
FROM stg_tbauctionplayer_300 a;

