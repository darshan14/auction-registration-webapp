DROP TABLE IF EXISTS tbplayers;

DROP TABLE IF EXISTS tbplayerdisplay;

DROP TABLE IF EXISTS ctplayerrole;

CREATE TABLE ctplayerrole (
    cd_player_role_id INTEGER,
    cd_player_role VARCHAR(10),
    dc_player_role VARCHAR(100)
);

DROP TABLE IF EXISTS ctcountry;

CREATE TABLE ctcountry (
    cd_country_id INTEGER,
    cd_country VARCHAR(10),
    dc_country VARCHAR(100)
);


DROP TABLE IF EXISTS ctplayercategory;

CREATE TABLE ctplayercategory (
    cd_cetegory_id INTEGER,
    cd_player_role VARCHAR(10),
    in_cap TINYINT,
    in_overseas TINYINT,
    am_base_rupees BIGINT,
    dc_category VARCHAR(100)
);
