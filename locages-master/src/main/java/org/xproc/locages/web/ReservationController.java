package org.xproc.locages.web;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.xproc.locages.dao.entities.Car;
import org.xproc.locages.dao.entities.Client;
import org.xproc.locages.dao.entities.Maintenance;
import org.xproc.locages.dao.entities.Reservation;
import org.xproc.locages.metier.CarManager;
import org.xproc.locages.metier.ClientManager;
import org.xproc.locages.metier.ReservationManagerMetier;


import java.time.temporal.ChronoUnit;
import java.util.List;

@Controller

public class ReservationController {

    @Autowired
    private  ReservationManagerMetier reservationManager;
    @Autowired
    private CarManager carManager;
    @Autowired
    private ClientManager clientManager;

    @GetMapping("indexReservation")
    public String start(Model model) {
        List<Reservation> reservations = reservationManager.getAllReservationsNoPage();
        model.addAttribute("reservations", reservations);
        return "indexReservation";
    }

    @GetMapping("/ajouterReservation")
    public String ajouterReservation(Model model) {
        model.addAttribute("clients", clientManager.getAllClientsNoPage());
        model.addAttribute("cars", carManager.getAllCarsNoPage());
        model.addAttribute("reservation", new Reservation());
        return "ajouterReservation";
    }

    @PostMapping("/ajouterOnceR")
    public String ajouterReservation(Model model,
                                     @Valid Reservation reservation,
                                     BindingResult bindingResult ,@RequestParam Integer carId,@RequestParam Integer clientId) {
        Car car = carManager.getCarById(carId);
        Client client = clientManager.getClientById(clientId);
        reservation.setCar(car);
        reservation.setClient(client);
        // Calculate the number of days between DateDebut and DateEnd
        long numberOfDays = ChronoUnit.DAYS.between(reservation.getDateDebut(), reservation.getDateEnd());

        // Calculate carGains based on rentPrice and numberOfDays
        double carGains =  (car.getRentPrice() * numberOfDays)+car.getCarGains() ;
        car.setCarGains(carGains);
        reservationManager.addReservation(reservation);
        return "redirect:indexReservation";
    }

    @GetMapping("/deleteReservation")
    public String deleteReservation(Model model, @RequestParam(name = "id") Integer id) {
        if (reservationManager.deleteReservation(id)) {
            return "redirect:/indexReservation";

        } else {
            return "error";
        }
    }

    @GetMapping("/editReservation")
    public String editReservation(Model model, @RequestParam(name = "id") Integer id) {
        Reservation reservation =   reservationManager.getReservationById(id);
        if (reservation != null) {
            model.addAttribute("ReservationTobeUpdated", reservation);
            return "updateReservation";
        } else {
            return "error";
        }
    }
    @PostMapping("/updateReservation")
    public String updateReservation(@ModelAttribute("ReservationTobeUpdated") Reservation reservation) {
        reservationManager.updateReservation(reservation);
        return "redirect:indexReservation";
    }


    @PostMapping("/ajouterR")
    public String ajouterReservationAction(Model model,
                                      @Valid Reservation reservation,
                                      BindingResult bindingResult) {
        reservationManager.addReservation(reservation);
        return "redirect:indexReservation";
    }
}


