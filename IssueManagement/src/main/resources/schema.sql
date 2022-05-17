CREATE TABLE issues (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
summary VARCHAR(200) NOT NULL,
description VARCHAR(200) NOT NULL,
username VARCHAR(50) NOT NULL,
priorityId INT NOT NULL
);

CREATE TABLE priority (
id INT NOT NULL PRIMARY KEY,
priority VARCHAR(10) NOT NULL
);

CREATE TABLE users (
username VARCHAR(50) NOT NULL PRIMARY KEY,
password VARCHAR(500) NOT NULL,
authority ENUM('ADMIN', 'USER') NOT NULL
);