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
    career VARCHAR(255) NOT NULL,
    semester INT(1) NOT NULL,
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

CREATE TABLE Admin (
	adminId INT(8) NOT NULL,
	password VARCHAR(255) NOT NULL,
    firstName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    phoneNumber VARCHAR(20) NOT NULL,
	PRIMARY KEY (adminId)
);

-- Inserción de datos en la tabla Teacher
INSERT INTO Teacher (teacherId, password, firstName, lastName, email, phoneNumber, curp, birthDate, gender, career)
VALUES
(10000001, 'bd9509aba7d1e5ab68bc526195d369f2418f26f044f5bc2c9af3871a486a6bd3', 'Ana', 'Lopez', 'ana.lopez@example.com', '555-1234', 'LOPA000101HDFRNN01', '1980-01-01', 'F', 'Mathematics'),
(10000002, 'bd9509aba7d1e5ab68bc526195d369f2418f26f044f5bc2c9af3871a486a6bd3', 'Carlos', 'Martinez', 'carlos.martinez@example.com', '555-1235', 'MARC800101HDFRNN02', '1982-02-02', 'M', 'Physics'),
(10000003, 'bd9509aba7d1e5ab68bc526195d369f2418f26f044f5bc2c9af3871a486a6bd3', 'Laura', 'Garcia', 'laura.garcia@example.com', '555-1236', 'GALA800101HDFRNN03', '1984-03-03', 'F', 'Chemistry'),
(10000004, 'bd9509aba7d1e5ab68bc526195d369f2418f26f044f5bc2c9af3871a486a6bd3', 'Miguel', 'Hernandez', 'miguel.hernandez@example.com', '555-1237', 'HERM800101HDFRNN04', '1986-04-04', 'M', 'Biology'),
(10000005, 'bd9509aba7d1e5ab68bc526195d369f2418f26f044f5bc2c9af3871a486a6bd3', 'Sofia', 'Perez', 'sofia.perez@example.com', '555-1238', 'PESF800101HDFRNN05', '1988-05-05', 'F', 'History'),
(10000006, 'bd9509aba7d1e5ab68bc526195d369f2418f26f044f5bc2c9af3871a486a6bd3', 'Juan', 'Gonzalez', 'juan.gonzalez@example.com', '555-1239', 'GOJU800101HDFRNN06', '1990-06-06', 'M', 'Geography'),
(10000007, 'bd9509aba7d1e5ab68bc526195d369f2418f26f044f5bc2c9af3871a486a6bd3', 'Marta', 'Sanchez', 'marta.sanchez@example.com', '555-1240', 'SAMA800101HDFRNN07', '1992-07-07', 'F', 'Philosophy'),
(10000008, 'bd9509aba7d1e5ab68bc526195d369f2418f26f044f5bc2c9af3871a486a6bd3', 'Pablo', 'Torres', 'pablo.torres@example.com', '555-1241', 'TOPA800101HDFRNN08', '1994-08-08', 'M', 'Literature'),
(10000009, 'bd9509aba7d1e5ab68bc526195d369f2418f26f044f5bc2c9af3871a486a6bd3', 'Elena', 'Ramirez', 'elena.ramirez@example.com', '555-1242', 'RAEL800101HDFRNN09', '1996-09-09', 'F', 'Arts'),
(10000010, 'bd9509aba7d1e5ab68bc526195d369f2418f26f044f5bc2c9af3871a486a6bd3', 'Luis', 'Fernandez', 'luis.fernandez@example.com', '555-1243', 'FELU800101HDFRNN10', '1998-10-10', 'M', 'Music');

-- Inserción de datos en la tabla Coordinator
INSERT INTO Coordinator (coordinatorId, password, firstName, lastName, email, phoneNumber, curp, birthDate, gender, area)
VALUES
(20000001, 'bd9509aba7d1e5ab68bc526195d369f2418f26f044f5bc2c9af3871a486a6bd3', 'Fernando', 'Castro', 'fernando.castro@example.com', '555-2244', 'CAFE800101HDFRNN11', '1980-11-11', 'M', 'Science'),
(20000002, 'bd9509aba7d1e5ab68bc526195d369f2418f26f044f5bc2c9af3871a486a6bd3', 'Lucia', 'Mendez', 'lucia.mendez@example.com', '555-2245', 'MELU800101HDFRNN12', '1982-12-12', 'F', 'Engineering'),
(20000003, 'bd9509aba7d1e5ab68bc526195d369f2418f26f044f5bc2c9af3871a486a6bd3', 'Alberto', 'Ruiz', 'alberto.ruiz@example.com', '555-2246', 'RUAL800101HDFRNN13', '1984-01-13', 'M', 'Humanities'),
(20000004, 'bd9509aba7d1e5ab68bc526195d369f2418f26f044f5bc2c9af3871a486a6bd3', 'Patricia', 'Ortiz', 'patricia.ortiz@example.com', '555-2247', 'ORPA800101HDFRNN14', '1986-02-14', 'F', 'Social Sciences'),
(20000005, 'bd9509aba7d1e5ab68bc526195d369f2418f26f044f5bc2c9af3871a486a6bd3', 'Roberto', 'Ramos', 'roberto.ramos@example.com', '555-2248', 'RARO800101HDFRNN15', '1988-03-15', 'M', 'Arts'),
(20000006, 'bd9509aba7d1e5ab68bc526195d369f2418f26f044f5bc2c9af3871a486a6bd3', 'Angela', 'Reyes', 'angela.reyes@example.com', '555-2249', 'REAN800101HDFRNN16', '1990-04-16', 'F', 'Business'),
(20000007, 'bd9509aba7d1e5ab68bc526195d369f2418f26f044f5bc2c9af3871a486a6bd3', 'Diego', 'Fuentes', 'diego.fuentes@example.com', '555-2250', 'FUDE800101HDFRNN17', '1992-05-17', 'M', 'Law'),
(20000008, 'bd9509aba7d1e5ab68bc526195d369f2418f26f044f5bc2c9af3871a486a6bd3', 'Natalia', 'Gomez', 'natalia.gomez@example.com', '555-2251', 'GONA800101HDFRNN18', '1994-06-18', 'F', 'Medicine'),
(20000009, 'bd9509aba7d1e5ab68bc526195d369f2418f26f044f5bc2c9af3871a486a6bd3', 'Ricardo', 'Vega', 'ricardo.vega@example.com', '555-2252', 'VERI800101HDFRNN19', '1996-07-19', 'M', 'Technology'),
(20000010, 'bd9509aba7d1e5ab68bc526195d369f2418f26f044f5bc2c9af3871a486a6bd3', 'Adriana', 'Morales', 'adriana.morales@example.com', '555-2253', 'MOAD800101HDFRNN20', '1998-08-20', 'F', 'Education');

-- Inserción de datos en la tabla Student
INSERT INTO Student (studentId, password, firstName, lastName, email, phoneNumber, curp, birthDate, gender, career, semester)
VALUES
(30000001, 'bd9509aba7d1e5ab68bc526195d369f2418f26f044f5bc2c9af3871a486a6bd3', 'Jose', 'Navarro', 'jose.navarro@example.com', '555-3344', 'NAJO800101HDFRNN21', '2000-09-21', 'M', 'Engineering', 1),
(30000002, 'bd9509aba7d1e5ab68bc526195d369f2418f26f044f5bc2c9af3871a486a6bd3', 'Marina', 'Silva', 'marina.silva@example.com', '555-3345', 'SIMA800101HDFRNN22', '2001-10-22', 'F', 'Medicine', 2),
(30000003, 'bd9509aba7d1e5ab68bc526195d369f2418f26f044f5bc2c9af3871a486a6bd3', 'Fernando', 'Gonzalez', 'fernando.gonzalez@example.com', '555-3346', 'GOFE800101HDFRNN23', '2002-11-23', 'M', 'Law', 3),
(30000004, 'bd9509aba7d1e5ab68bc526195d369f2418f26f044f5bc2c9af3871a486a6bd3', 'Lucia', 'Reyes', 'lucia.reyes@example.com', '555-3347', 'RELU800101HDFRNN24', '2003-12-24', 'F', 'Business', 4),
(30000005, 'bd9509aba7d1e5ab68bc526195d369f2418f26f044f5bc2c9af3871a486a6bd3', 'Pedro', 'Ramirez', 'pedro.ramirez@example.com', '555-3348', 'RAPE800101HDFRNN25', '2004-01-25', 'M', 'Arts', 5),
(30000006, 'bd9509aba7d1e5ab68bc526195d369f2418f26f044f5bc2c9af3871a486a6bd3', 'Ana', 'Cruz', 'ana.cruz@example.com', '555-3349', 'CRAN800101HDFRNN26', '2005-02-26', 'F', 'Education', 6),
(30000007, 'bd9509aba7d1e5ab68bc526195d369f2418f26f044f5bc2c9af3871a486a6bd3', 'Miguel', 'Torres', 'miguel.torres@example.com', '555-3350', 'TOMI800101HDFRNN27', '2006-03-27', 'M', 'Technology', 7),
(30000008, 'bd9509aba7d1e5ab68bc526195d369f2418f26f044f5bc2c9af3871a486a6bd3', 'Sofia', 'Gomez', 'sofia.gomez@example.com', '555-3351', 'GOSO800101HDFRNN28', '2007-04-28', 'F', 'Science', 8),
(30000009, 'bd9509aba7d1e5ab68bc526195d369f2418f26f044f5bc2c9af3871a486a6bd3', 'Juan', 'Martinez', 'juan.martinez@example.com', '555-3352', 'MAJU800101HDFRNN29', '2008-05-29', 'M', 'Humanities', 9),
(30000010, 'bd9509aba7d1e5ab68bc526195d369f2418f26f044f5bc2c9af3871a486a6bd3', 'Marta', 'Lopez', 'marta.lopez@example.com', '555-3353', 'LOMA800101HDFRNN30', '2009-06-30', 'F', 'Philosophy', 10);

-- Inserción de datos en la tabla Subject
INSERT INTO Subject (subjectId, name)
VALUES
(1, 'Mathematics'),
(2, 'Physics'),
(3, 'Chemistry'),
(4, 'Biology'),
(5, 'History'),
(6, 'Geography'),
(7, 'Philosophy'),
(8, 'Literature'),
(9, 'Arts'),
(10, 'Music');

-- Inserción de datos en la tabla Group
INSERT INTO `Group` (groupId)
VALUES
('4SA'),
('4SB'),
('4SC'),
('2SA'),
('2SB'),
('2SC'),
('3SA'),
('3SB'),
('3SC'),
('2CA');

-- Inserción de datos en la tabla Group_Subject
INSERT INTO Group_Subject (groupId, subjectId, startTime, endTime, teacherId, studentId)
VALUES
('4SA', 1, '08:00:00', '09:00:00', 10000001, 30000001),
('4SB', 2, '09:00:00', '10:00:00', 10000002, 30000002),
('4SC', 3, '10:00:00', '11:00:00', 10000003, 30000003),
('2SA', 4, '11:00:00', '12:00:00', 10000004, 30000004),
('2SB', 5, '12:00:00', '13:00:00', 10000005, 30000005),
('2SC', 6, '13:00:00', '14:00:00', 10000006, 30000006),
('3SA', 7, '14:00:00', '15:00:00', 10000007, 30000007),
('3SB', 8, '15:00:00', '16:00:00', 10000008, 30000008),
('3SC', 9, '16:00:00', '17:00:00', 10000009, 30000009),
('2CA', 10, '17:00:00', '18:00:00', 10000010, 30000010);
