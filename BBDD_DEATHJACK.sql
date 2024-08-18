DROP DATABASE IF EXISTS DEATHJACK;
CREATE DATABASE DEATHJACK;
USE DEATHJACK;

CREATE TABLE PLAYER (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	id_score INT,
	NAME VARCHAR(100),
	PASSWORD VARCHAR(100),
	bot BOOLEAN
);
	
CREATE TABLE object (
	id INT PRIMARY KEY NOT NULL,
	NAME VARCHAR(100),
	DESCRIPTION VARCHAR(100)
);

CREATE TABLE CARDS (
	id INT PRIMARY KEY NOT NULL,
	card VARCHAR(50)
);

CREATE TABLE SCORE (
	id_player INT PRIMARY KEY NOT NULL,
	name_player VARCHAR(100),
	rounds INT,
	FOREIGN KEY (id_player) REFERENCES player (id)
);

CREATE TABLE INVENTORY (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	id_player INT,
	id_object INT,
	FOREIGN KEY (id_player) REFERENCES player (id),
	FOREIGN KEY (id_object) REFERENCES object (id)
);