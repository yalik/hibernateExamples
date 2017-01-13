package com.epam.hibernate.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Konstantin_Yalovik on 1/5/2017.
 */
@Entity
@Table(name = "employee")
public class Employee1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String role;

    @Column(name = "insert_time")
    private Date insertTime;

    private int salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
}
