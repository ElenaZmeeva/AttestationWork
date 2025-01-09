--liquibase formatted sql

CREATE TABLE IF NOT EXISTS doctor(
    id serial primary key,
    name text,
    specialization text
);

CREATE TABLE IF NOT EXISTS patient(
    id serial primary key,
    name text,
    age serial,
    doctor_id serial references doctor(id)
);
 CREATE TABLE IF NOT EXISTS medicalTests(
     id serial primary key,
     test text,
     patient_id serial references patient(id)
 );