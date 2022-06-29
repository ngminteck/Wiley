DROP DATABASE IF EXISTS StudentGradeLab;

CREATE DATABASE StudentGradeLab;

USE StudentGradeLab;

Create table Student (
 StudentID CHAR(50) PRIMARY KEY,
`Name` VARCHAR(100) NOT NULL
);

create table Grade(
StudentID CHAR(50) PRIMARY KEY,
Subject1_Name VARCHAR(100),
Subject1_Score int not null default 0,
Subject2_Name VARCHAR(100),
Subject2_Score int not null default 0,
Subject3_Name VARCHAR(100),
Subject3_Score int not null default 0,
Subject4_Name VARCHAR(100),
Subject4_Score int not null default 0
);

SHOW DATABASES;

Show tables;

INSERT INTO Student VALUES ('1', 'Clarence Ng');
INSERT INTO Student VALUES ('2', 'Ng Min Teck');
INSERT INTO Student VALUES ('3', 'Huang Ming De');
INSERT INTO Student VALUES ('4', 'Hwang Min Taeg');

INSERT INTO Grade VALUES ('1', 'English', 100, 'Chinese', 100, 'Math', 100, 'Science', 100 );
INSERT INTO Grade VALUES ('2', 'English', 75, 'Chinese', 75, 'Math', 75, 'Science', 75 );
INSERT INTO Grade VALUES ('3', 'English', 0 , 'Chinese', 0, 'Math', 0, 'Science', 0 );
INSERT INTO Grade VALUES ('4', 'English', 50, null , 0, 'Math', 80, 'Science', 70 );

INSERT INTO Student VALUES ('5', 'Clarence');
INSERT INTO Grade VALUES ('5', 'English', 100, 'Chinese', 100, 'Math', 100, 'Science', 100 );
INSERT INTO Student VALUES ('6', 'a');
INSERT INTO Grade VALUES ('6', 'English', 100, 'Chinese', 100, 'Math', 100, 'Science', 100 );
INSERT INTO Student VALUES ('7', 'b');
INSERT INTO Grade VALUES ('7', 'English', 70, 'Chinese', 70, 'Math', 70, 'Science', 70 );
INSERT INTO Student VALUES ('8', 'c');
INSERT INTO Grade VALUES ('8', 'English', 55, 'Chinese', 55, 'Math', 55, 'Science', 55 );

select *
from grade;

