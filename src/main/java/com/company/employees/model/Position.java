package com.company.employees.model;

import com.company.employees.model.abstracts.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * класс - должность сотрудника
 */
@Entity
@Table(name = "position")
public class Position extends Model {
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "position", fetch = FetchType.LAZY)
    private Set<Employee> employeeSet = new HashSet<>();

    public Position() {
        super();
    }

    public Position(int id, String name, Set<Employee> employeeSet) {
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
