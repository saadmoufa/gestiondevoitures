package org.xproc.locages.dao.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.xproc.locages.dao.entities.Employee;
import org.xproc.locages.dao.entities.Maintenance;

public interface MaintenanceRepository extends JpaRepository<Maintenance,Integer> {
    Page<Maintenance> findByDescription(String keyword, Pageable pageable);
}
