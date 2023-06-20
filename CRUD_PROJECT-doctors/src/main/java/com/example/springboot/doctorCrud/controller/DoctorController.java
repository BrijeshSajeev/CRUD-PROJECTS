package com.example.springboot.doctorCrud.controller;

import com.example.springboot.doctorCrud.entity.Doctor;
import com.example.springboot.doctorCrud.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DoctorController {

    private DoctorService doctorService;

    public DoctorController() {
    }

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctors")
    public List<Doctor> findAll(){
        return doctorService.findAll();
    }

    @GetMapping("/doctors/{docId}")
    public Doctor findById(@PathVariable int docId){
        return doctorService.findById(docId);
    }

    @PostMapping("/doctors")
    public Doctor save(@RequestBody Doctor theDoc){
        theDoc.setId(0);

        Doctor doc = doctorService.save(theDoc);
        return doc;
    }

    @PutMapping("/doctors")
    public Doctor updateDoc(@RequestBody Doctor theDoc) {
        Doctor doc = doctorService.save(theDoc);
        return doc;
    }

    @DeleteMapping("/doctors/{docId}")
    public int deleteDoc(@PathVariable int theId){
        doctorService.deleteById(theId);
        return theId;

    }




}
