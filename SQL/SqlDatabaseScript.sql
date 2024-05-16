DROP DATABASE IF EXISTS Control_escolar;
CREATE DATABASE Control_escolar;
USE Control_escolar;
CREATE TABLE Teacher (
    teacherId INT(8) NOT NULL,
    password VARCHAR(255) NOT NULL,
    firstName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    phoneNumber VARCHAR(20) NOT NULL,
    curp VARCHAR(18) NOT NULL,
    birthDate DATE NOT NULL,
    gender CHAR(1) NOT NULL,
    career VARCHAR(255) NOT NULL,
    PRIMARY KEY (teacherId)
);

CREATE TABLE Coordinator(
	coordinatorId INT(8) NOT NULL,
    password VARCHAR(255) NOT NULL,
    firstName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    phoneNumber VARCHAR(20) NOT NULL,
    curp VARCHAR(18) NOT NULL,
    birthDate DATE NOT NULL,
    gender CHAR(1) NOT NULL,
    area VARCHAR(255) NOT NULL,
    PRIMARY KEY (coordinatorId)
);

CREATE TABLE Student (
    studentId INT(8) NOT NULL,
    password VARCHAR(255) NOT NULL,
    firstName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    phoneNumber VARCHAR(20) NOT NULL,
    curp VARCHAR(18) NOT NULL,
    birthDate DATE NOT NULL,
    gender CHAR(1) NOT NULL,
    area VARCHAR(255) NOT NULL,
    PRIMARY KEY (studentId)
);

CREATE TABLE Subject (
    subjectId INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (subjectId)
);

CREATE TABLE `Group` (
    groupId VARCHAR(3) NOT NULL,
    PRIMARY KEY (groupId)
);

CREATE TABLE Group_Subject (
    groupId VARCHAR(3) NOT NULL,
    subjectId INT NOT NULL,
    startTime TIME NOT NULL,
    endTime TIME NOT NULL,
    teacherId INT NOT NULL,
    studentId INT NOT NULL,
    FOREIGN KEY (groupId) REFERENCES `Group`(groupId),
    FOREIGN KEY (subjectId) REFERENCES Subject(subjectId),
    FOREIGN KEY (teacherId) REFERENCES Teacher(teacherId),
    FOREIGN KEY (studentId) REFERENCES Student(studentId)
);
