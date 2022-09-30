package com.docker.app.entity;

import com.docker.app.entity.StudentCourse;
import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue
    String student_Id;

    @NotNull
    @Column(name = "student_Name")
    String student_Name;

    @NotNull
    @Column(name = "age")
    int age;

   @Column(name = "DOB")
    Date dob;

   @Column(name = "address", columnDefinition = "json")
   @JsonRawValue
   String address;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<StudentCourse> studentCourse;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "student")
    private List<Lecturer> lecturers;


}
