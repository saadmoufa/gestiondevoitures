package org.xproc.locages.dao.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.xproc.locages.dao.entities.Car;
import org.xproc.locages.dao.entities.Client;

public interface ClientRepository extends JpaRepository<Client,Integer> {
    Page<Client> findByNbrCin(String keyword, Pageable pageable);






}
