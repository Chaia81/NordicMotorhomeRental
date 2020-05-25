package com.example.demo.controllers;

import com.example.demo.models.CustomerDTO;
import com.example.demo.models.MotorhomeDTO;
import com.example.demo.repositories.IMotorhomeRepository;
import com.example.demo.repositories.MotorhomeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MotorhomeController {

    private IMotorhomeRepository motorhomeRepository;

    @Autowired
    public MotorhomeController(){
        motorhomeRepository = new MotorhomeRepositoryImpl();
    }

    /*
    +----------------------------------+
    |          Administration          |
    +----------------------------------+
    */

    // ---------- DO NOT TOUCH!! ----------

    @GetMapping("/motorhomeAdministration")
    public String administrateMotorhome(Model model){
        return "motorhome/motorhomeAdministration";
    }

    /*
    +----------------------------------+
    |         Create motorhome         |
    +----------------------------------+
    */

    // ---------- DO NOT TOUCH!! ----------

    @GetMapping("/createMotorhome")
    public String createMotorhome(Model model){
        model.addAttribute("motorhome", new MotorhomeDTO());
        return "motorhome/createMotorhome";
    }

    @PostMapping("/createMotorhome")
    public String saveMotorhome(@ModelAttribute MotorhomeDTO motorhomeDTO){
        motorhomeRepository.create(motorhomeDTO);
        return "redirect:/motorhomeAdministration";
    }


        /*
    +---------------------------------+
    |          Find motorhome         |
    +---------------------------------+
    */

    // ---------- DO NOT TOUCH!! ----------

    @GetMapping("/findMotorhome")
    public String findMotorhome(Model model){
        // if(model.getAttribute("customer") == null) {
        model.addAttribute("motorhome", new MotorhomeDTO()); // laver et tomt customer object, det der står i form {customer}
        //  }
        return "motorhome/findMotorhome";
    }

    @PostMapping("/getMotorhomeById")
    public String getMotorhomeById(@ModelAttribute MotorhomeDTO motorhome,Model model) {
        MotorhomeDTO motor = motorhomeRepository.read(motorhome.getMotorhomeId());
        model.addAttribute("motorhome", motor);
        return "motorhome/findMotorhome";
    }

    /*
    +----------------------------------+
    |         See all motorhomes       |
    +----------------------------------+
    */

    // ---------- DO NOT TOUCH!! ----------

    @GetMapping("/allMotorhomes")
    public String allMotorhomes(Model model){
        model.addAttribute("motorhomes", motorhomeRepository.readAll());
        return "motorhome/allMotorhomes";
    }

    /*
    +----------------------------------+
    |          Edit motorhome          |
    +----------------------------------+
    */

    // ---------- DO NOT TOUCH!! ----------

    @GetMapping("/editMotorhome")
    public String editMotorhome(Model model, @RequestParam int motorhomeId){
        MotorhomeDTO motorhome = motorhomeRepository.read(motorhomeId);
        model.addAttribute("motorhome", motorhome);
        return "motorhome/editMotorhome";
    }

    @PostMapping("/editMotorhome")
    public String updateMotorhome(@ModelAttribute MotorhomeDTO motorhome){
        motorhomeRepository.edit(motorhome);
        return "redirect:/motorhomeAdministration";
    }

        /*
    +----------------------------------+
    |         Delete motorhome          |
    +----------------------------------+
    */

    // ---------- DO NOT TOUCH!! ----------

    @GetMapping("/deleteMotorhome")
    public String details(Model model, @RequestParam int motorhomeId){
        MotorhomeDTO motor = motorhomeRepository.read(motorhomeId);
        model.addAttribute("motorhome", motor);
        return "motorhome/deleteMotorhome";
    }

    @PostMapping ("/deleteMotorhome")
    public String deleteForGood(@RequestParam int motorhomeId) {
        motorhomeRepository.delete(motorhomeId);
        return "redirect:/motorhomeAdministration";
    }




}
