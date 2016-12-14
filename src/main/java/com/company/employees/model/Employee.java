package com.company.employees.model;

import com.company.employees.model.abstracts.Model;

import javax.persistence.*;

/**
 * класс - сотрудник
 */
@Entity
@Table(name = "employees")
public class Employee extends Model {
    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genderId")
    private Gender gender;

    @Column(name = "yearOfBirth")
    private int yearOfBirth;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "positionId")
    private Position position;

    @Column(name = "comments")
    private String comments;

    public Employee() {
        super();
    }

    public Employee(int id, String firstName, String lastName,
                    Gender gender, int yearOfBirth,
                    Position position, String comments) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
        this.position = position;
        this.comments = comments;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (yearOfBirth != employee.yearOfBirth) return false;
        if (!firstName.equals(employee.firstName)) return false;
        if (!lastName.equals(employee.lastName)) return false;
        if (!gender.equals(employee.gender)) return false;
        return position.equals(employee.position);

    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + yearOfBirth;
        result = 31 * result + position.hashCode();
        return result;
    }
}
