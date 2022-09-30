package com.docker.app.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "course")
@Data
public class StudentCourse {
    @Id
    @Column(name = "course_Id")
    @GeneratedValue
    int course_Id;

    @Column(name = "course_Name")
    String course_Name;

    @Column(name = "price")
    double price;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "studentCourse")
    private List<Subjects> subjects;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "studentCourse")
    private List<Student> students;

}
