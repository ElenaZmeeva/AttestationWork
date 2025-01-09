--liquibase formatted sql

SELECT *FROM doctor;
SELECT *FROM patient ORDER BY age;
SELECT *FROM medicaltests WHERE test='МРТ';
UPDATE doctor SET name='Соловьев Р.В' WHERE id=5;
UPDATE medicaltests SET patient_id=1 WHERE id=6;
DELETE FROM patient WHERE id=10;
SELECT patient.name, patient.age FROM patient
INNER JOIN doctor d on d.id = patient.doctor_id;
SELECT doctor.name, doctor.specialization FROM doctor
LEFT JOIN patient p on doctor.id = p.doctor_id;




