package org.xproc.locages.web;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.xproc.locages.dao.entities.Car;
import org.xproc.locages.dao.entities.Maintenance;
import org.xproc.locages.metier.CarManager;
import org.xproc.locages.metier.CarManagerMetier;
import org.xproc.locages.metier.MaintenanceManagerMetier;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller

public class MaintenanceController {

    @Autowired
    private  MaintenanceManagerMetier maintenanceManager;
    @Autowired
    private CarManager carManager;

    @GetMapping("indexMaintenance")
    public String start(Model model) {
        List<Maintenance> maintenances = maintenanceManager.getAllMaintenancesNoPage();
        model.addAttribute("Maintenances", maintenances);
        return "indexMaintenance";
    }


    @GetMapping("/ajouterMaintenance")
    public String ajouterMaintenance(Model model) {

        model.addAttribute("cars", carManager.getAllCarsNoPage());
        model.addAttribute("maintenance", new Maintenance());
        return "ajouterMaintenance";
    }


    @PostMapping("/ajouterOnceM")
    public String ajouterMaintenance(Model model,
                                @Valid Maintenance maintenance,
                                BindingResult bindingResult ,@RequestParam Integer carId) {

        Car car = carManager.getCarById(carId);
        double carGains =  car.getCarGains() - maintenance.getMaintenancePrice() ;
        car.setCarGains(carGains);
        maintenance.setCar(car);
        maintenanceManager.addMaintenance(maintenance);
        return "redirect:indexMaintenance";
    }


    @GetMapping("/deleteMaintenance")
    public String deleteMaintenance(Model model, @RequestParam(name = "id") Integer id) {
        if (maintenanceManager.deleteMaintenance(id)) {
            return "redirect:/indexMaintenance";

        } else {
            return "error";
        }
    }

    @GetMapping("/editMaintenance")
    public String editMaintenance(Model model, @RequestParam(name = "id") Integer id) {
        Maintenance maintenance =   maintenanceManager.getMaintenanceById(id);
        if (maintenance != null) {
            model.addAttribute("MaintenanceTobeUpdated", maintenance);
            model.addAttribute("cars", carManager.getAllCarsNoPage());
            return "updateMaintenance";
        } else {
            return "error";
        }
    }

    @PostMapping("/updateMaintenance")
    public String updateMaintenance(@ModelAttribute("MaintenanceTobeUpdated") Maintenance maintenance,@RequestParam Integer carId) {
        Car car = carManager.getCarById(carId);
        maintenance.setCar(car);
        maintenanceManager.updateMaintenance(maintenance);
        return "redirect:indexMaintenance";
    }


}


