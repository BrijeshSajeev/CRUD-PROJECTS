package com.example.springboot.doctorCrud.service;

import com.example.springboot.doctorCrud.dao.DoctorResposritoryDao;
import com.example.springboot.doctorCrud.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService{

    private DoctorResposritoryDao doctorResposritoryDao;

    @Autowired
    public DoctorServiceImpl(DoctorResposritoryDao doctorResposritoryDao) {
        this.doctorResposritoryDao = doctorResposritoryDao;
    }

    @Override
    public List<Doctor> findAll() {
        return doctorResposritoryDao.findAll();
    }

    @Override
    public Doctor findById(int theId) {
        Optional<Doctor> result= doctorResposritoryDao.findById(theId);
        Doctor theDoc=null;
        if (result.isPresent()){
            theDoc=result.get();
        }
        else {
            throw new RuntimeException("No Employee Id Found");
        }

        return theDoc;




    }

    @Override
    public Doctor save(Doctor theDoc) {
         doctorResposritoryDao.save(theDoc);
        return theDoc;
    }

    @Override
    public void deleteById(int theId) {
        doctorResposritoryDao.deleteById(theId);
    }
}
