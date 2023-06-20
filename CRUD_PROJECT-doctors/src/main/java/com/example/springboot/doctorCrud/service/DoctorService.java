package com.example.springboot.doctorCrud.service;

import com.example.springboot.doctorCrud.entity.Doctor;

import java.util.List;

public interface DoctorService {

    public List<Doctor> findAll();
    public Doctor findById(int theId);

    public Doctor save(Doctor theDoc);

    public void deleteById(int theId);

}
