package com.docker.app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "subjects")
public class Subjects {

    @Id
    @Column(name = "subject_Id")
    @GeneratedValue
    int subject_Id;

    @Column(name = "subject_Name")
    String subject_Name;

    @OneToOne(cascade = CascadeType.ALL)
    private Lecturer lecturer;

    @ManyToOne(cascade = CascadeType.ALL)
    private StudentCourse studentCourse;
}
