package org.example;

import org.example.entity.Doctor;
import org.example.entity.MedicalTests;
import org.example.entity.Patient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class Main {

    public static void main(String[] args) {
       var driver=new DriverManagerDataSource("jdbc:postgresql://localhost:5432/medicalcentre","elenaz","26272");
       driver.setDriverClassName("org.postgresql.Driver");
       JdbcTemplate jdbcTemplate=new JdbcTemplate(driver);

       var doctor= jdbcTemplate.queryForList("SELECT *FROM doctor");
       var patients=jdbcTemplate.queryForList("select *from patient");
       var test=jdbcTemplate.queryForList("select *from medicalTests where id=4");
        System.out.println(doctor);
        System.out.println(patients);
        System.out.println(test);
    }


    private static final RowMapper<Doctor>doctorRowMapper= ((rs, rowNum) -> {
        Long id= rs.getLong("id");
        String name= rs.getNString("name");
        String specialization=rs.getString("specialization");
        return new Doctor();
    });

    private static final RowMapper<Patient>patientRowMapper= ((rs, rowNum) -> {
        Long id= rs.getLong("id");
        String name= rs.getNString("name");
        Integer age=rs.getInt("age");
        return new Patient();
    });

    private static final RowMapper<MedicalTests>medicalTestsRowMapper= ((rs, rowNum) -> {
        Long id= rs.getLong("id");
        String test= rs.getNString("test");
        return new MedicalTests();
    });
}