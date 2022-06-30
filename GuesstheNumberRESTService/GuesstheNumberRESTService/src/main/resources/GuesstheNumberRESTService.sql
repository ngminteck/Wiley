DROP DATABASE IF EXISTS GuesstheNumberRESTService;
CREATE DATABASE GuesstheNumberRESTService;

USE GuesstheNumberRESTService;

CREATE TABLE Round(
    id INT PRIMARY KEY AUTO_INCREMENT,
    Answer INT,
    Guess INT,
    TimeGuess TIMESTAMP,
    Result VARCHAR(10)
);