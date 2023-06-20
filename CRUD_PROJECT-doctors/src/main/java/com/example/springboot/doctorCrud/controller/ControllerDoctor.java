package com.example.springboot.doctorCrud.controller;

import com.example.springboot.doctorCrud.entity.Doctor;
import com.example.springboot.doctorCrud.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/doctors")
public class ControllerDoctor {

    private DoctorService doctorService;

    @Autowired
    public ControllerDoctor(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/list")
    public String listAll(Model theModel){
        List<Doctor> docList=doctorService.findAll();
        theModel.addAttribute("doctors",docList);
        return "/doctor/doctor-list";
    }

    @GetMapping("/showFormToAdd")
    public String addDoctor(Model theModel){
        Doctor theDoc=new Doctor();
        theModel.addAttribute("doctor",theDoc);
        return "doctor/save-doctor";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Doctor theDoc){
        doctorService.save(theDoc);
        return "redirect:/doctors/list";

    }

    @GetMapping("/showFormToUpdate")
    public String updateForm(@RequestParam("doctorId") int id,Model theModel){
        Doctor theDoc=doctorService.findById(id);
        theModel.addAttribute("doctor",theDoc);
        return "doctor/save-doctor";
    }

    @GetMapping("/delete")
    public String deleteDoc(@RequestParam("doctorId") int id){
        doctorService.deleteById(id);
        return "redirect:/doctors/list";
    }


}
