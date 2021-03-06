CREATE TABLE CONTACTLIST (
	IDCONTACT INTEGER NOT NULL PRIMARY KEY, 
	EMAILOWNER VARCHAR(30) NOT NULL, 
	NAME VARCHAR(20) NOT NULL, 
	LASTNAME VARCHAR(20) NOT NULL, 
	EMAIL VARCHAR(30) NOT NULL, 
	CATEGORY VARCHAR(20) NOT NULL, 
	SUBCATEGORY VARCHAR(20), 
	PHONENUMBER VARCHAR(15) NOT NULL, 
	BIRTHDATE DATE NOT NULL, 
);

CREATE TABLE USERS (
	EMAIL VARCHAR(30) NOT NULL PRIMARY KEY, 
	NAME VARCHAR(20), 
	LASTNAME VARCHAR(20), 
	PASSWORD VARCHAR(20)
);