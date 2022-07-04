DROP DATABASE IF EXISTS GuesstheNumberRESTService;
CREATE DATABASE GuesstheNumberRESTService;

USE GuesstheNumberRESTService;

DROP TABLE IF EXISTS Game;

CREATE TABLE Game(
    id INT PRIMARY KEY AUTO_INCREMENT,
    answer varchar(4)
);

DROP TABLE IF EXISTS Guess;

Create TABLE Guess(
    id INT NOT NULL,
    result VARCHAR(6),
    FOREIGN KEY (id) REFERENCES Game(id)
);

SELECT *
FROM Game;

SELECT *
FROM Guess;