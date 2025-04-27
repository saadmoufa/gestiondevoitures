package org.xproc.locages.metier;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.xproc.locages.dao.entities.Employee;

import java.util.List;

@Transactional
public interface EmployeeManager {
    Employee addEmployee(Employee employee);
    Page<Employee> getAllEmployees(int page, int size);
    Page<Employee> searchEmployees(String keyword, int page, int size);
    Employee getEmployeeById(Integer id);
    Employee updateEmployee(Employee employee);
    boolean deleteEmployee(Integer id);
    Page<Employee> findByNbrCin(String keyword, Pageable pageable);
    void saveEmployee(Employee existingEmployee);

    List<Employee> getAllEmployeesNoPage();
}
