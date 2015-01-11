--
-- ER/Studio 8.0 SQL Code Generation
-- Company :      τττ
-- Project :      Model1.DM1
-- Author :       CrazyBobik@hotmail.com
--
-- Date Created : Saturday, January 03, 2015 17:27:45
-- Target DBMS : MySQL 5.x
--

--
-- DELETE DATABASE
--

DROP DATABASE IF EXISTS db_hospital;
 
CREATE DATABASE db_hospital
            DEFAULT CHARACTER SET 'utf8';
 
USE db_hospital;

-- 
-- TABLE: DIAGNOSIS 
--

CREATE TABLE DIAGNOSIS(
    DIAGNOSIS_ID    INT             NOT NULL AUTO_INCREMENT,
    PATIENT_ID      INT             NOT NULL,
    DOCTOR_ID       INT,
    NAME            VARCHAR(50)     NOT NULL,
    TEXT            VARCHAR(255)    NOT NULL,
    PRIMARY KEY (DIAGNOSIS_ID)
)ENGINE=INNODB
;



-- 
-- TABLE: DOCTOR 
--

CREATE TABLE DOCTOR(
    DOCTOR_ID    INT            NOT NULL AUTO_INCREMENT,
    FIO          VARCHAR(70)    NOT NULL,
    POST         VARCHAR(25)    NOT NULL,
    PRIMARY KEY (DOCTOR_ID)
)ENGINE=INNODB
;



-- 
-- TABLE: GRAPHIK 
--

CREATE TABLE GRAPHIK(
    GRAPHIK_ID    INT     NOT NULL AUTO_INCREMENT,
    A_TIME        DATE    NOT NULL,
    PATIENT_ID    INT     NOT NULL,
    DOCTOR_ID     INT     NOT NULL,
    PRIMARY KEY (GRAPHIK_ID)
)ENGINE=INNODB
;



-- 
-- TABLE: INSURER 
--

CREATE TABLE INSURER(
    INSURER_ID    INT             NOT NULL AUTO_INCREMENT,
    NAME          VARCHAR(60)     NOT NULL,
    CONTACTS      VARCHAR(255),
    PRIMARY KEY (INSURER_ID)
)ENGINE=INNODB
;



-- 
-- TABLE: PATIENT 
--

CREATE TABLE PATIENT(
    PATIENT_ID    INT             AUTO_INCREMENT,
    FIO           VARCHAR(70)     NOT NULL,
    ADDRESS       VARCHAR(100),
    CONTACTS      VARCHAR(255),
    INSURER_ID    INT,
    PRIMARY KEY (PATIENT_ID)
)ENGINE=INNODB
;



-- 
-- INDEX: Ref58 
--

CREATE INDEX Ref58 ON DIAGNOSIS(DOCTOR_ID)
;
-- 
-- INDEX: Ref112 
--

CREATE INDEX Ref112 ON DIAGNOSIS(PATIENT_ID)
;
-- 
-- INDEX: Ref113 
--

CREATE INDEX Ref113 ON GRAPHIK(PATIENT_ID)
;
-- 
-- INDEX: Ref514 
--

CREATE INDEX Ref514 ON GRAPHIK(DOCTOR_ID)
;
-- 
-- INDEX: Ref44 
--

CREATE INDEX Ref44 ON PATIENT(INSURER_ID)
;
-- 
-- TABLE: DIAGNOSIS 
--

ALTER TABLE DIAGNOSIS ADD CONSTRAINT RefDOCTOR8 
    FOREIGN KEY (DOCTOR_ID)
    REFERENCES DOCTOR(DOCTOR_ID)
;

ALTER TABLE DIAGNOSIS ADD CONSTRAINT RefPATIENT12 
    FOREIGN KEY (PATIENT_ID)
    REFERENCES PATIENT(PATIENT_ID)
;


-- 
-- TABLE: GRAPHIK 
--

ALTER TABLE GRAPHIK ADD CONSTRAINT RefPATIENT13 
    FOREIGN KEY (PATIENT_ID)
    REFERENCES PATIENT(PATIENT_ID)
;

ALTER TABLE GRAPHIK ADD CONSTRAINT RefDOCTOR14 
    FOREIGN KEY (DOCTOR_ID)
    REFERENCES DOCTOR(DOCTOR_ID)
;


-- 
-- TABLE: PATIENT 
--

ALTER TABLE PATIENT ADD CONSTRAINT RefINSURER4 
    FOREIGN KEY (INSURER_ID)
    REFERENCES INSURER(INSURER_ID)
;


set names 'utf8';

insert into insurer (name, contacts)
values ('Оранта', '937-99-92');

insert into patient (fio, insurer_id)
values ('Краснянчин А. В.', 1);
insert into patient (fio)
values ('Дымов И. С.');

insert into doctor (fio, post) 
values ('Хаус', 'Хирург');

insert into diagnosis (patient_id, doctor_id, name, text)
values (1, 1, 'Грип', 'Здоров');
insert into diagnosis (patient_id, name, text)
values (1, 'Ангина', 'Здоров, здоров');
insert into diagnosis (patient_id, doctor_id, name, text)
values (2, 1, 'Простуда', 'Здоров, здоров, здоров');


