DROP TABLE IF EXISTS stat_line;
DROP TABLE IF EXISTS game;
DROP TABLE IF EXISTS player;
DROP TABLE IF EXISTS team;

CREATE TABLE team (
    id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE player (
    id INT AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    jersey_number INT NOT NULL,
    team_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (team_id) REFERENCES team(id)
);

CREATE TABLE game (
    id INT AUTO_INCREMENT NOT NULL,
    team_id INT NOT NULL,
    opponent VARCHAR(255) NOT NULL,
    date DATE NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (team_id) REFERENCES team(id)
);

CREATE TABLE stat_line (
    id INT AUTO_INCREMENT NOT NULL,
    player_id INT NOT NULL,
    game_id INT NOT NULL,
    field_goal_attempts int NOT NULL DEFAULT 0,
    field_goals_made int NOT NULL DEFAULT 0,
    three_point_attempts int NOT NULL DEFAULT 0,
    three_point_made int NOT NULL DEFAULT 0,
    free_throw_attempts int NOT NULL DEFAULT 0,
    free_throws_made int NOT NULL DEFAULT 0,
    defensive_rebounds int NOT NULL DEFAULT 0,
    offensive_rebounds int NOT NULL DEFAULT 0,
    steals int NOT NULL DEFAULT 0,
    blocks int NOT NULL DEFAULT 0,
    turnovers int NOT NULL DEFAULT 0,
    fouls int NOT NULL DEFAULT 0,
    PRIMARY KEY (id),
    FOREIGN KEY (player_id) REFERENCES player(id),
    FOREIGN KEY (game_id) REFERENCES game(id)
);