package org.xproc.locages.metier;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.xproc.locages.dao.entities.Employee;
import org.xproc.locages.dao.repositories.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeManagerMetier implements EmployeeManager {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Page<Employee> getAllEmployees(int page, int size) {
        return employeeRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }




    @Override
    public Page<Employee> searchEmployees(String keyword, int page, int size) {
        return employeeRepository.findByEmpCin(keyword, PageRequest.of(page, size));
    }



    @Override
    public Employee updateEmployee(Employee Employee) {
        return employeeRepository.save(Employee);
    }

    @Override
    public boolean deleteEmployee(Integer id) {
        try {
                employeeRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public Page<Employee> findByNbrCin(String keyword, Pageable pageable) {
        return employeeRepository.findByEmpCin(keyword, pageable);
    }

    @Override
    public void saveEmployee(Employee existingEmployee) {
        // Implementation can be added if needed
    }

    @Override
    public List<Employee> getAllEmployeesNoPage() {
        return employeeRepository.findAll();
    }

}
