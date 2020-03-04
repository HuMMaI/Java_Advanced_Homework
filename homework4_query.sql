DROP DATABASE IF EXISTS user_db;
CREATE DATABASE user_db;

USE user_db;

CREATE TABLE countries(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE users(
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    age INT NOT NULL,
    country_id INT NOT NULL,
    CONSTRAINT users_country_FK FOREIGN KEY (country_id) REFERENCES countries(id) 
);

INSERT INTO countries(name) VALUES
	('Ukraine'), ('Poland'), ('USA'), ('French'), ('Germany');
    
INSERT INTO users(first_name, last_name, age, country_id) VALUES
	('FirstName1', 'LastName1', 19, 1),
    ('FirstName2', 'LastName2', 25, 5),
    ('FirstName3', 'LastName3', 22, 3);