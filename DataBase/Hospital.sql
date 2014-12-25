--
-- ER/Studio 8.0 SQL Code Generation
-- Company :      τττ
-- Project :      Model1.DM1
-- Author :       CrazyBobik@hotmail.com
--
-- Date Created : Tuesday, December 09, 2014 14:03:22
-- Target DBMS : MySQL 5.x
--


--
-- DELETE DATABASE
--

DROP DATABASE IF EXISTS db_hospital;

CREATE DATABASE db_hospital
            DEFAULT CHARACTER SET 'utf8'
            DEFAULT COLLATE 'utf8_unicode_ci';

USE db_hospital;

--
-- TABLE: DIAGNOSIS
--

CREATE TABLE DIAGNOSIS(
    DIAGNOSIS_ID    INT             NOT NULL AUTO_INCREMENT,
    PATIENT_ID      INT             NOT NULL,
    DOCTOR_ID       INT,
	NAME			VARCHAR(50)		NOT NULL,
    TEXT            VARCHAR(255)    NOT NULL,
    PRIMARY KEY (DIAGNOSIS_ID)
)ENGINE=INNODB
;



--
-- TABLE: DOCTOR
--

CREATE TABLE DOCTOR(
    DOCTOR_ID    INT             NOT NULL AUTO_INCREMENT,
    FIO          VARCHAR(70)     NOT NULL,
    POST         VARCHAR(25)     NOT NULL,
    PRIMARY KEY (DOCTOR_ID)
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
    PATIENT_ID    INT             NOT NULL AUTO_INCREMENT,
    FIO           VARCHAR(70)     NOT NULL,
    ADDRESS       VARCHAR(100),
    CONTACTS      VARCHAR(255),
    INSURER_ID    INT,
    PRIMARY KEY (PATIENT_ID)
)ENGINE=INNODB
;

--
-- TABLE: DIAGNOSIS
--

ALTER TABLE DIAGNOSIS ADD CONSTRAINT RefPATIENT7
    FOREIGN KEY (PATIENT_ID)
    REFERENCES PATIENT(PATIENT_ID)
;

ALTER TABLE DIAGNOSIS ADD CONSTRAINT RefDOCTOR8
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
insert into diagnosis (patient_id, doctor_id, name, text)
values (1, 1, 'Ангина', 'Здоров, здоров');
insert into diagnosis (patient_id, doctor_id, name, text)
values (2, 1, 'Простуда', 'Здоров, здоров, здоров');
