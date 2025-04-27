package org.xproc.locages.dao.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.xproc.locages.dao.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Page<Employee> findByEmpCin(String keyword, Pageable pageable);
    Page<Employee> findEmployeeByLogin(String keyword, Pageable pageable);
}
