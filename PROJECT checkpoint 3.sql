--
-- File generated with SQLiteStudio v3.4.4 on Mon Jun 24 19:07:05 2024
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: COACH
CREATE TABLE IF NOT EXISTS COACH (
ID varchar (3) not null,
Name varchar (20),
Primary Key (ID)
);

-- Table: COACH_SEASON_STAT
CREATE TABLE IF NOT EXISTS COACH_SEASON_STAT(
Coach_ID varchar (3) not null,
Year Year(4),
Wins varchar (2),
Losses varchar (2),
Num_Passes varchar (2),
Num_Runs varchar (2),
Primary key (Coach_ID)
);

-- Table: GAME
CREATE TABLE IF NOT EXISTS GAME (ID varchar (3) NOT NULL, Year year (4) NOT NULL, Week varchar (3) NOT NULL, Season_Type varchar (12), Home_Team_ID varchar (3) NOT NULL, Away_Team_ID varchar (3) NOT NULL, Home_Points varchar (3), Away_Points varchar (3), PRIMARY KEY (ID), FOREIGN KEY (Home_Team_ID) REFERENCES TEAM (ID), FOREIGN KEY (Away_Team_ID) REFERENCES TEAM (ID));

-- Table: PLAYER
CREATE TABLE IF NOT EXISTS PLAYER (
ID varchar (5) not null,
Name varchar (30),
Primary key (ID)
);

-- Table: PLAYER_GAME_STATS
CREATE TABLE IF NOT EXISTS PLAYER_GAME_STATS (
Player_ID varchar (5) not null,
Year year(4) not null,
Week varchar (3) not null,
C_ATT varchar (3),
Yards varchar (3),
Average varchar float (3,2),
Touchdown varchar (2),
Interceptions varchar (2),
Quarterback_Rating Float (3,2),
Carries varchar (4),
Long varchar (4),
Receptions varchar (4),
/* NO varchar (5),*/
Field_Goals varchar (4),
Percent float (3,2),
XP varchar (4),
Points varchar (3),
Touchback varchar (2),
In_20 varchar (2),
Fumbles varchar (2),
Lost varchar (2),
TOT varchar (2),
Solo varchar (2),
Sacks varchar (2),
TFL varchar (2),
Passes_Defended varchar (2),
Quarterback_Hurries varchar (2),
Primary key (Player_ID)
);

-- Table: PLAYER_SEASON_STATS
CREATE TABLE IF NOT EXISTS PLAYER_SEASON_STATS(
Player_ID varchar(5) NOT NULL,
Year YEAR NOT NULL,
Touchdowns varchar(3),
Long varchar(3),
Receptions varchar(3),
/* NO varchar(3) */
Yards_Per_Carry varchar(3),
Carries varchar(3),
Interceptions varchar(3),
Yards_Per_Reception varchar(3),
Average varchar(3),
Attempts varchar(3),
Percent FLOAT (2,2),
Yards_Per_Pass varchar(3),
Completions varchar(3),
Touchback varchar(3),
XPM varchar(3),
In_20 varchar(3),
Field_Goal_Attempts varchar(3),
Points varchar(3),
XPA varchar(3),
Field_Goal_Made varchar(3),
PD varchar(3),
QB_Hurries varchar(3),
TFL varchar(3),
TOT varchar(3),
Solo varchar(3),
Sack varchar(3),
Fumble varchar(3),
Lost varchar(3),
PRIMARY KEY(Player_ID)
);

-- Table: PLAYER_YEAR
CREATE TABLE IF NOT EXISTS PLAYER_YEAR(
Player_ID varchar (5) not null,
Year year(4),
Age varchar (3),
Height varchar (4),
Weight varchar (3),
Team_ID varchar (3) not null,
Primary key (Player_ID),
Foreign key (Team_ID) references Team(ID)
);

-- Table: TEAM
CREATE TABLE IF NOT EXISTS TEAM (
    ID   varchar (3)     NOT NULL,
    Name VARCHAR (30),
    PRIMARY KEY (
        ID
    )
);

-- Table: TEAM_GAME_STATS
CREATE TABLE IF NOT EXISTS TEAM_GAME_STATS(
Team_ID varchar(3) NOT NULL,
Year YEAR NOT NULL,
Week varchar(2),
Points INTEGER,
Home_Away char(4),
Fumbles_Recovered INTEGER,
Rushing_Touchdowns INTEGER,
Passing_Touchdowns INTEGER,
Kick_Return_Yards INTEGER,
Kick_Return_Touchdowns INTEGER,
Kick_Returns INTEGER,
Kicking_Points INTEGER,
First_Downs INTEGER,
Third_Down_Efficiency REAL,
Fourth_Down_Efficiency REAL,
Total_Yards INTEGER,
Net_Passing_Yards INTEGER,
Completion_Attempts INTEGER,
Yards_Per_Pass REAL,
Rushing_Attempts INTEGER,
Rushing_Yards INTEGER,
Yards_Per_Rush_Attempt REAL,
Total_Penalty_Yards REAL,
Turnovers INTEGER,
Fumbles_Lost INTEGER,
Interceptions INTEGER,
Possession_Time TIME,
Punt_Return_Yards INTEGER,
Punt_Return_Touchdowns INTEGER,
Punt_Returns INTEGER,
Interception_Yards INTEGER,
Interception_Touchdowns INTEGER,
Passes_Intercepted INTEGER,
Total_Fumbles INTEGER,
Tackles_For_Loss INTEGER,
Defensive_Touchdowns INTEGER,
Tackles INTEGER,
Sacks INTEGER,
QB_Hurries INTEGER,
Passes_Deflected INTEGER,
PRIMARY KEY(Team_ID)
);

-- Table: TEAM_SEASON_STATS
CREATE TABLE IF NOT EXISTS TEAM_SEASON_STATS (
Team_ID varchar (3) not null,
Year year (4) not null,
TouchDowns varchar (3),
Long varchar (3),
Receptions varchar (3),
/* no varchar (3), */
Yards_Per_Reception varchar (3),
Average varchar (3),
Attempts varchar(3),
Percent Float (2,2),
Yards_Per_Pass varchar (3),
Completions varchar (3),
Touchback varchar (3),
XPM varchar (3),
Inside_20 varchar (3),
Field_Goal_Attempts varchar (3),
Passes_Defended varchar (3),
QB_Hurries varchar (3),
TFL varchar (3),
TOT varchar (3),
Solo varchar (3),
Sack varchar (3),
Fumble varchar (3),
Lost varchar (3),
Primary key (Team_ID)
);

-- Table: TEAM_YEAR
CREATE TABLE IF NOT EXISTS TEAM_YEAR (
Team_ID varchar(3) not null,
Year Year(4),
Coach_ID varchar(3) not null,
Conference varchar(9),
Primary key (Team_ID),
Foreign key (Coach_ID) references COACH(ID)
);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
