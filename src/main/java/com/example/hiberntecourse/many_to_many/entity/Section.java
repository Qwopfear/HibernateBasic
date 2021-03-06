package com.example.hiberntecourse.many_to_many.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "section")
public class Section {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

    public Section() {
    }

    public Section(String name) {
        this.name = name;
    }
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "child_section",
            joinColumns = @JoinColumn(name = "section_id"),
            inverseJoinColumns = @JoinColumn(name = "child_id"))
    private List<Child> children;

    public void addChildrenToSection(Child child){
        if (children == null)
            children = new ArrayList<>();
        children.add(child);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
