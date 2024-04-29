DROP TABLE City;
DROP TABLE County;
DROP TABLE Major;

CREATE TABLE County
(
    County_ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT
    ,Name VARCHAR(100) NOT NULL
);

CREATE TABLE City
(
    City_ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT
    ,Name VARCHAR(100) NOT NULL
    ,post_code INT NOT NULL
    ,Major_ID INT NOT NULL
    ,NO_OF_CITIZENS INT NOT NULL
    ,County_ID INT NOT NULL
);

CREATE TABLE Major
(
    Major_ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT
    ,Name VARCHAR(50) NOT NULL
    ,Surname VARCHAR(50) NOT NULL
);