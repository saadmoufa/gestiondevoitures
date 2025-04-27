package org.xproc.locages.metier;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.xproc.locages.dao.entities.Reservation;
import org.xproc.locages.dao.repositories.ReservationRepository;

import java.util.List;

@Service
public class ReservationManagerMetier implements ReservationManager {
    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Page<Reservation> getAllReservations(int page, int size) {
        return reservationRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Reservation getReservationById(Integer id) {
        return reservationRepository.findById(id).orElse(null);
    }




    @Override
    public Page<Reservation> searchReservations(String keyword, int page, int size) {
            return reservationRepository.findByDescription(keyword, PageRequest.of(page, size));
    }



    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public boolean deleteReservation(Integer id) {
        try {
            reservationRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public Page<Reservation> findByDescription(String keyword, Pageable pageable) {
        return reservationRepository.findByDescription(keyword, pageable);
    }

    @Override
    public void saveReservation(Reservation existingReservation) {
        // Implementation can be added if needed
    }
    @Override
    public List<Reservation> getAllReservationsNoPage() {
        return reservationRepository.findAll();
    }
}
