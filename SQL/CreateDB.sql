DROP DATABASE IF EXISTS Control_escolar;
CREATE DATABASE Control_escolar;
USE Control_escolar;

CREATE TABLE Teacher (
    teacherId INT NOT NULL AUTO_INCREMENT,
    password VARCHAR(255) NOT NULL,
    firstName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    phoneNumber VARCHAR(20) NOT NULL,
    curp VARCHAR(18) NOT NULL,
    birthDate DATE NOT NULL,
    gender CHAR(1) NOT NULL,
    career VARCHAR(255) NOT NULL,
    imagePath VARCHAR(255) NOT NULL DEFAULT '/EduManager/Images_profile/profile.png',
    PRIMARY KEY (teacherId)
);

CREATE TABLE Coordinator (
    coordinatorId INT NOT NULL AUTO_INCREMENT,
    password VARCHAR(255) NOT NULL,
    firstName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    phoneNumber VARCHAR(20) NOT NULL,
    curp VARCHAR(18) NOT NULL,
    birthDate DATE NOT NULL,
    gender CHAR(1) NOT NULL,
    area VARCHAR(255) NOT NULL,
    imagePath VARCHAR(255) NOT NULL DEFAULT '/EduManager/Images_profile/profile.png',
    PRIMARY KEY (coordinatorId)
);

CREATE TABLE Student (
    studentId INT NOT NULL AUTO_INCREMENT,
    password VARCHAR(255) NOT NULL,
    firstName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    phoneNumber VARCHAR(20) NOT NULL,
    curp VARCHAR(18) NOT NULL,
    birthDate DATE NOT NULL,
    gender CHAR(1) NOT NULL,
    career VARCHAR(255) NOT NULL,
    semester TINYINT NOT NULL,
    imagePath VARCHAR(255) NOT NULL DEFAULT '/EduManager/Images_profile/profile.png',
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

CREATE TABLE GroupSubject (
    groupSubjectId INT NOT NULL AUTO_INCREMENT,
    groupId VARCHAR(3) NOT NULL,
    subjectId INT NOT NULL,
    startTime TIME NOT NULL,
    endTime TIME NOT NULL,
    teacherId INT NOT NULL,
    daysOfWeek VARCHAR(7) NOT NULL,
    capacity INT NOT NULL,
    vacancies INT NOT NULL,
    PRIMARY KEY (groupSubjectId),
    FOREIGN KEY (groupId) REFERENCES `Group`(groupId),
    FOREIGN KEY (subjectId) REFERENCES Subject(subjectId),
    FOREIGN KEY (teacherId) REFERENCES Teacher(teacherId)
);

CREATE TABLE Admin (
    adminId INT NOT NULL AUTO_INCREMENT,
    password VARCHAR(255) NOT NULL,
    firstName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    phoneNumber VARCHAR(20) NOT NULL,
    imagePath VARCHAR(255) NOT NULL DEFAULT '/EduManager/Images_profile/profile.png',
    PRIMARY KEY (adminId)
);

CREATE TABLE Enrollment (
    enrollmentId INT NOT NULL AUTO_INCREMENT,
    studentId INT NOT NULL,
    groupSubjectId INT NOT NULL,
    PRIMARY KEY (enrollmentId),
    FOREIGN KEY (studentId) REFERENCES Student(studentId),
    FOREIGN KEY (groupSubjectId) REFERENCES GroupSubject(groupSubjectId),
    UNIQUE (studentId, groupSubjectId)
);
