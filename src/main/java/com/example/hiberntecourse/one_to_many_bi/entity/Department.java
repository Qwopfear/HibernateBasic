package com.example.hiberntecourse.one_to_many_bi.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String dName;
    @Column(name = "min_salary")
    private int minSalary;
    @Column(name = "max_salary")
    private int maxSalary;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department",fetch = FetchType.LAZY)  // mappedBy - говорит в каком поле искать связь
    List<Employee> emps;

    public Department() {
    }

    public Department(String dName, int minSalary, int maxSalary) {
        this.dName = dName;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    public void addEmployeeToDepartment(Employee employee){
        if (emps == null)
            emps = new ArrayList<>();
        emps.add(employee);
        employee.setDepartment(this);

    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", dName='" + dName + '\'' +
                ", minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                '}';
    }
}
