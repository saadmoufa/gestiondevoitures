package org.xproc.locages.web;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.xproc.locages.dao.entities.Car;
import org.xproc.locages.metier.CarManagerMetier;
import org.xproc.locages.metier.MaintenanceManagerMetier;

import java.util.List;

@Controller

public class CarController {

    @Autowired
    private  CarManagerMetier carManager;


    @GetMapping("index")
    public String start(Model model) {
        List<Car> cars = carManager.getAllCarsNoPage();
        model.addAttribute("cars", cars);
        return "index";
    }

    @GetMapping("/ajouterCar")
    public String ajouterCar(Model model) {
        model.addAttribute("car", new Car());
        return "ajouterCar";
    }

    @PostMapping("/ajouterOnce")
    public String ajouterCar(Model model,
                             @Valid Car car,
                             BindingResult bindingResult) {
        double carGains =  car.getCarPrice()*(-1) ;
        car.setCarGains(carGains);
        carManager.addCar(car);
        return "redirect:index";
    }

    @GetMapping("/availableCars")
    public String showCarList(Model model) {
        List<Car> cars = carManager.getCarsByAvailability(true);
        model.addAttribute("cars", cars);

        return "availableCars";
    }
    @GetMapping("/notavailableCars")
    public String showCarListn(Model model) {
        List<Car> cars = carManager.getCarsByAvailability(false);
        model.addAttribute("cars", cars);

        return "notavailableCars";
    }


    @GetMapping("/deleteCar")
    public String deleteCar(Model model, @RequestParam(name = "id") Integer id) {
        if (carManager.deleteCar(id)) {
            return "redirect:/index";

        } else {
            return "error";
        }
    }

    @GetMapping("/editCar")
    public String editCar(Model model, @RequestParam(name = "id") Integer id) {
        Car car = carManager.getCarById(id);
        if (car != null) {
            model.addAttribute("carTobeUpdated", car);
            return "updateCar";
        } else {
            return "error";
        }
    }

    @PostMapping("/updateCar")
    public String updateClient(@ModelAttribute("clientTobeUpdated") Car car) {
        carManager.updateCar(car);
        return "redirect:index";
    }
    @PostMapping("/ajouter")
    public String ajouterCarAction(Model model,
                             @Valid Car car,
                             BindingResult bindingResult) {
        carManager.addCar(car);
        return "redirect:index";
    }
}


