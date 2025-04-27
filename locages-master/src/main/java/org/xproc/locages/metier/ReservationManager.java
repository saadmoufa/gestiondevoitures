package org.xproc.locages.metier;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.xproc.locages.dao.entities.Reservation
        ;

import java.util.List;

@Transactional
public interface ReservationManager {
    Reservation addReservation(Reservation reservation);
    Page<Reservation> getAllReservations(int page, int size);
    Page<Reservation> searchReservations(String keyword, int page, int size);
    Reservation getReservationById(Integer id);
    Reservation updateReservation(Reservation reservation);
    boolean deleteReservation(Integer id);
    Page<Reservation> findByDescription(String keyword, Pageable pageable);
    void saveReservation(Reservation existingReservation);

    List<Reservation> getAllReservationsNoPage();
}
