package com.company.employees.model;

import com.company.employees.model.abstracts.Model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * класс - пол сотрудника
 */
@Entity
@Table(name = "gender")
public class Gender extends Model {
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "gender", fetch = FetchType.LAZY)
    private Set<Employee> employeeSet = new HashSet<>();

    public Gender() {
        super();
    }

    public Gender(int id, String name, Set<Employee> employeeSet) {
        super(id);
        this.name = name;
        this.employeeSet = employeeSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }
}
