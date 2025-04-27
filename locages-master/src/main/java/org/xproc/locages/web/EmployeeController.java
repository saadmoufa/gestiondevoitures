package org.xproc.locages.web;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.xproc.locages.dao.entities.Employee;
import org.xproc.locages.dao.entities.Client;
import org.xproc.locages.metier.EmployeeManagerMetier;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller

public class EmployeeController {

    @Autowired
    private  EmployeeManagerMetier employeeManager;




    @GetMapping("indexEmployee")
    public String start(Model model) {
        List<Employee> employees = employeeManager.getAllEmployeesNoPage();
        model.addAttribute("Employees", employees);
        return "indexEmployee";
    }

    @GetMapping("/ajouterEmployee")
    public String ajouterEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "ajouterEmployee";
    }

    @PostMapping("/ajouterOnceE")
    public String ajouterEmployee(Model model,
                             @Valid Employee employee,
                             BindingResult bindingResult) {
        employeeManager.addEmployee(employee);
        return "redirect:indexEmployee";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(Model model, @RequestParam(name = "id") Integer id) {
        if (employeeManager.deleteEmployee(id)) {
            return "redirect:/indexEmployee";

        } else {
            return "error";
        }
    }

    @GetMapping("/editEmployee")
    public String editEmployee(Model model, @RequestParam(name = "id") Integer id) {
        Employee employee = employeeManager.getEmployeeById(id);
        if (employee != null) {
            model.addAttribute("employeeTobeUpdated", employee);
            return "updateEmployee";
        } else {
            return "error";
        }
    }
    @PostMapping("/updateEmployee")
    public String updateClient(@ModelAttribute("clientTobeUpdated") Employee employee) {
        employeeManager.updateEmployee(employee);
        return "redirect:indexEmployee";
    }
    @PostMapping("/ajouterE")
    public String ajouterEmployeeAction(Model model,
                                   @Valid Employee employee,
                                   BindingResult bindingResult) {
        employeeManager.addEmployee(employee);
        return "redirect:indexEmployee";
    }
}


