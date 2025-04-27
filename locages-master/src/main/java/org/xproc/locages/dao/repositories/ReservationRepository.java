package org.xproc.locages.dao.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.xproc.locages.dao.entities.Employee;
import org.xproc.locages.dao.entities.Maintenance;
import org.xproc.locages.dao.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {

    Page<Reservation> findByDescription(String keyword, Pageable pageable);
}
