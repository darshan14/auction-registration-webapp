INSERT INTO ctcountry (cd_country, dc_country) VALUES
('AFG', 'Afghanistan'),
('AUS', 'Australia'),
('BAN', 'Bangladesh'),
('CAN', 'Canada'),
('ENG', 'England'),         -- England does not have an ISO-3166 code, keeping 'ENG'
('GER', 'Germany'),
('FRA', 'France'),
('IND', 'India'),
('IRL', 'Ireland'),
('PAK', 'Pakistan'),
('NPL', 'Nepal'),
('NLD', 'Netherlands'),
('NZ', 'New Zealand'),
('SCO', 'Scotland'),        -- Scotland does not have an ISO-3166 code, keeping 'SCO'
('SA', 'South Africa'),
('SL', 'Sri Lanka'),
('WI', 'West Indies'),     -- West Indies is a cricket team region, not a country
('USA', 'United States'),
('ZIM', 'Zimbabwe');

INSERT INTO ctplayerrole (cd_player_role, dc_player_role) VALUES
('BAT', 'Batter'),
('BWL', 'Bowler'),
('ALL', 'All Rounder'),
('WK',  'Wicket Keeper');

INSERT INTO ctplayercategory VALUES (1, 'BAT', 1, 0, 20000000, 'Capped Indian Batter - Diamond');

INSERT INTO ctplayercategory VALUES (2, 'BAT', 1, 1, 20000000, 'Capped Overseas Batter - Diamond');

INSERT INTO ctplayercategory VALUES (3, 'BAT', 0, 1, 20000000, 'Uncapped Overseas Batter - Diamond');

INSERT INTO ctplayercategory VALUES (4, 'BAT', 0, 0, 20000000, 'Uncapped India Batter - Diamond');

INSERT INTO ctplayercategory VALUES (5, 'BWL', 1, 0, 20000000, 'Capped Indian Bowler - Diamond');

INSERT INTO ctplayercategory VALUES (6, 'BWL', 1, 1, 20000000, 'Capped Overseas Bowler - Diamond');

INSERT INTO ctplayercategory VALUES (7, 'BWL', 0, 1, 20000000, 'Uncapped Overseas Bowler - Diamond');

INSERT INTO ctplayercategory VALUES (8, 'BWL', 0, 0, 20000000, 'Uncapped India Bowler - Diamond');

INSERT INTO ctplayercategory VALUES (9, 'ALL', 1, 0, 20000000, 'Capped Indian All Rounder - Diamond');

INSERT INTO ctplayercategory VALUES (10, 'ALL', 1, 1, 20000000, 'Capped Overseas All Rounder - Diamond');

INSERT INTO ctplayercategory VALUES (11, 'ALL', 0, 1, 20000000, 'Uncapped Overseas All Rounder - Diamond');

INSERT INTO ctplayercategory VALUES (12, 'ALL', 0, 0, 20000000, 'Uncapped India All Rounder - Diamond');

INSERT INTO ctplayercategory VALUES (13, 'WK', 1, 0, 20000000, 'Capped Indian Wicket Keeper - Diamond');

INSERT INTO ctplayercategory VALUES (14, 'WK', 1, 1, 20000000, 'Capped Overseas Wicket Keeper - Diamond');

INSERT INTO ctplayercategory VALUES (15, 'WK', 0, 1, 20000000, 'Uncapped Overseas Wicket Keeper - Diamond');

INSERT INTO ctplayercategory VALUES (16, 'WK', 0, 0, 20000000, 'Uncapped India Wicket Keeper - Diamond');

INSERT INTO ctplayercategory VALUES (17, 'BAT', 1, 0, 10000000, 'Capped Indian Batter - Gold');

INSERT INTO ctplayercategory VALUES (18, 'BAT', 1, 1, 10000000, 'Capped Overseas Batter - Gold');

INSERT INTO ctplayercategory VALUES (19, 'BAT', 0, 1, 10000000, 'Uncapped Overseas Batter - Gold');

INSERT INTO ctplayercategory VALUES (20, 'BAT', 0, 0, 10000000, 'Uncapped India Batter - Gold');

INSERT INTO ctplayercategory VALUES (21, 'BWL', 1, 0, 10000000, 'Capped Indian Bowler - Gold');

INSERT INTO ctplayercategory VALUES (22, 'BWL', 1, 1, 10000000, 'Capped Overseas Bowler - Gold');

INSERT INTO ctplayercategory VALUES (23, 'BWL', 0, 1, 10000000, 'Uncapped Overseas Bowler - Gold');

INSERT INTO ctplayercategory VALUES (24, 'BWL', 0, 0, 10000000, 'Uncapped India Bowler - Gold');

INSERT INTO ctplayercategory VALUES (25, 'ALL', 1, 0, 10000000, 'Capped Indian All Rounder - Gold');

INSERT INTO ctplayercategory VALUES (26, 'ALL', 1, 1, 10000000, 'Capped Overseas All Rounder - Gold');

INSERT INTO ctplayercategory VALUES (27, 'ALL', 0, 1, 10000000, 'Uncapped Overseas All Rounder - Gold');

INSERT INTO ctplayercategory VALUES (28, 'ALL', 0, 0, 10000000, 'Uncapped India All Rounder - Gold');

INSERT INTO ctplayercategory VALUES (29, 'WK', 1, 0, 10000000, 'Capped Indian Wicket Keeper - Gold');

INSERT INTO ctplayercategory VALUES (30, 'WK', 1, 1, 10000000, 'Capped Overseas Wicket Keeper - Gold');

INSERT INTO ctplayercategory VALUES (31, 'WK', 0, 1, 10000000, 'Uncapped Overseas Wicket Keeper - Gold');

INSERT INTO ctplayercategory VALUES (32, 'WK', 0, 0, 10000000, 'Uncapped India Wicket Keeper - Gold');

INSERT INTO ctplayercategory VALUES (33, 'BAT', 1, 0, 8000000, 'Capped Indian Batter - Silver');

INSERT INTO ctplayercategory VALUES (34, 'BAT', 1, 1, 8000000, 'Capped Overseas Batter - Silver');

INSERT INTO ctplayercategory VALUES (35, 'BAT', 0, 1, 8000000, 'Uncapped Overseas Batter - Silver');

INSERT INTO ctplayercategory VALUES (36, 'BAT', 0, 0, 8000000, 'Uncapped India Batter - Silver');

INSERT INTO ctplayercategory VALUES (37, 'BWL', 1, 0, 8000000, 'Capped Indian Bowler - Silver');

INSERT INTO ctplayercategory VALUES (38, 'BWL', 1, 1, 8000000, 'Capped Overseas Bowler - Silver');

INSERT INTO ctplayercategory VALUES (39, 'BWL', 0, 1, 8000000, 'Uncapped Overseas Bowler - Silver');

INSERT INTO ctplayercategory VALUES (40, 'BWL', 0, 0, 8000000, 'Uncapped India Bowler - Silver');

INSERT INTO ctplayercategory VALUES (41, 'ALL', 1, 0, 8000000, 'Capped Indian All Rounder - Silver');

INSERT INTO ctplayercategory VALUES (42, 'ALL', 1, 1, 8000000, 'Capped Overseas All Rounder - Silver');

INSERT INTO ctplayercategory VALUES (43, 'ALL', 0, 1, 8000000, 'Uncapped Overseas All Rounder - Silver');

INSERT INTO ctplayercategory VALUES (44, 'ALL', 0, 0, 8000000, 'Uncapped India All Rounder - Silver');

INSERT INTO ctplayercategory VALUES (45, 'WK', 1, 0, 8000000, 'Capped Indian Wicket Keeper - Silver');

INSERT INTO ctplayercategory VALUES (46, 'WK', 1, 1, 8000000, 'Capped Overseas Wicket Keeper - Silver');

INSERT INTO ctplayercategory VALUES (47, 'WK', 0, 1, 8000000, 'Uncapped Overseas Wicket Keeper - Silver');

INSERT INTO ctplayercategory VALUES (48, 'WK', 0, 0, 8000000, 'Uncapped India Wicket Keeper - Silver');

INSERT INTO ctplayercategory VALUES (49, 'BAT', 1, 0, 5000000, 'Capped Indian Batter - Platinum');

INSERT INTO ctplayercategory VALUES (50, 'BAT', 1, 1, 5000000, 'Capped Overseas Batter - Platinum');

INSERT INTO ctplayercategory VALUES (51, 'BAT', 0, 1, 5000000, 'Uncapped Overseas Batter - Platinum');

INSERT INTO ctplayercategory VALUES (52, 'BAT', 0, 0, 5000000, 'Uncapped India Batter - Platinum');

INSERT INTO ctplayercategory VALUES (53, 'BWL', 1, 0, 5000000, 'Capped Indian Bowler - Platinum');

INSERT INTO ctplayercategory VALUES (54, 'BWL', 1, 1, 5000000, 'Capped Overseas Bowler - Platinum');

INSERT INTO ctplayercategory VALUES (55, 'BWL', 0, 1, 5000000, 'Uncapped Overseas Bowler - Platinum');

INSERT INTO ctplayercategory VALUES (56, 'BWL', 0, 0, 5000000, 'Uncapped India Bowler - Platinum');

INSERT INTO ctplayercategory VALUES (57, 'ALL', 1, 0, 5000000, 'Capped Indian All Rounder - Platinum');

INSERT INTO ctplayercategory VALUES (58, 'ALL', 1, 1, 5000000, 'Capped Overseas All Rounder - Platinum');

INSERT INTO ctplayercategory VALUES (59, 'ALL', 0, 1, 5000000, 'Uncapped Overseas All Rounder - Platinum');

INSERT INTO ctplayercategory VALUES (60, 'ALL', 0, 0, 5000000, 'Uncapped India All Rounder - Platinum');

INSERT INTO ctplayercategory VALUES (61, 'WK', 1, 0, 5000000, 'Capped Indian Wicket Keeper - Platinum');

INSERT INTO ctplayercategory VALUES (62, 'WK', 1, 1, 5000000, 'Capped Overseas Wicket Keeper - Platinum');

INSERT INTO ctplayercategory VALUES (63, 'WK', 0, 1, 5000000, 'Uncapped Overseas Wicket Keeper - Platinum');

INSERT INTO ctplayercategory VALUES (64, 'WK', 0, 0, 5000000, 'Uncapped India Wicket Keeper - Platinum');

INSERT INTO ctplayercategory VALUES (65, 'BAT', 1, 0, 3000000, 'Capped Indian Batter - Platinum');

INSERT INTO ctplayercategory VALUES (66, 'BAT', 1, 1, 3000000, 'Capped Overseas Batter - Platinum');

INSERT INTO ctplayercategory VALUES (67, 'BAT', 0, 1, 3000000, 'Uncapped Overseas Batter - Platinum');

INSERT INTO ctplayercategory VALUES (68, 'BAT', 0, 0, 3000000, 'Uncapped India Batter - Platinum');

INSERT INTO ctplayercategory VALUES (69, 'BWL', 1, 0, 3000000, 'Capped Indian Bowler - Platinum');

INSERT INTO ctplayercategory VALUES (70, 'BWL', 1, 1, 3000000, 'Capped Overseas Bowler - Platinum');

INSERT INTO ctplayercategory VALUES (71, 'BWL', 0, 1, 3000000, 'Uncapped Overseas Bowler - Platinum');

INSERT INTO ctplayercategory VALUES (72, 'BWL', 0, 0, 3000000, 'Uncapped India Bowler - Platinum');

INSERT INTO ctplayercategory VALUES (73, 'ALL', 1, 0, 3000000, 'Capped Indian All Rounder - Platinum');

INSERT INTO ctplayercategory VALUES (74, 'ALL', 1, 1, 3000000, 'Capped Overseas All Rounder - Platinum');

INSERT INTO ctplayercategory VALUES (75, 'ALL', 0, 1, 3000000, 'Uncapped Overseas All Rounder - Platinum');

INSERT INTO ctplayercategory VALUES (76, 'ALL', 0, 0, 3000000, 'Uncapped India All Rounder - Platinum');

INSERT INTO ctplayercategory VALUES (77, 'WK', 1, 0, 3000000, 'Capped Indian Wicket Keeper - Platinum');

INSERT INTO ctplayercategory VALUES (78, 'WK', 1, 1, 3000000, 'Capped Overseas Wicket Keeper - Platinum');

INSERT INTO ctplayercategory VALUES (79, 'WK', 0, 1, 3000000, 'Uncapped Overseas Wicket Keeper - Platinum');

INSERT INTO ctplayercategory VALUES (80, 'WK', 0, 0, 3000000, 'Uncapped India Wicket Keeper - Platinum');
