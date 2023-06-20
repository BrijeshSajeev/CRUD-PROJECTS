package com.example.springboot.doctorCrud.dao;

import com.example.springboot.doctorCrud.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorResposritoryDao extends JpaRepository<Doctor,Integer> {
}
