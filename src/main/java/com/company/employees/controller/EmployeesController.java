package com.company.employees.controller;

import com.company.employees.model.Employee;
import com.company.employees.service.interfaces.EmployeeService;
import com.company.employees.service.interfaces.GenderService;
import com.company.employees.service.interfaces.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * контроллер для сотрудников
 */
@Controller
@SessionAttributes({"listPosition", "listGender", "listEmployees", "employee", "listYears"})
public class EmployeesController {
    @Autowired
    private EmployeeService employeeServiceImpl;

    @Autowired
    private GenderService genderServiceImpl;

    @Autowired
    private PositionService positionServiceImpl;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "/index";
    }

    /**
     * получить "listPosition", "listGender"
     */
    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String startPage(Model model) {
        model.addAttribute("listPosition", positionServiceImpl.getAll());
        model.addAttribute("listGender", genderServiceImpl.getAll());

        return "redirect:/updateData";
    }

    /**
     * обновить данные
     */
    @RequestMapping(value = "/updateData", method = RequestMethod.GET)
    public String updateData(Model model) {
        model.addAttribute("listEmployees", employeeServiceImpl.getAll());
        model.addAttribute("employee", new Employee());

        return "/employees";
    }

    /**
     * получить сотрудника по id
     */
    @RequestMapping(value = "/getEmployeesById/{id}", method = RequestMethod.GET)
    public String getEmployeesById(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", employeeServiceImpl.getById(id));

        return "/employees";
    }

    /**
     * добавить нового сотрудника или редактировать старого
     */
    @RequestMapping(value = "/addOrUpdateEmployee", method = RequestMethod.POST)
    public String addOrUpdateEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        if(employee.getId() == 0) {
            employeeServiceImpl.add(employee);
        } else {
            employeeServiceImpl.update(employee);
        }

        return "redirect:/updateData";
    }

    /**
     * удалить сотрудника по id
     */
    @RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeServiceImpl.delete(id);

        return "redirect:/updateData";
    }
}
