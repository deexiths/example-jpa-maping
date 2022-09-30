package com.docker.app.entity;


import com.docker.app.entity.StudentCourse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "lecture")
public class Lecturer {
    @Id
    @Column(name = "lecturer_id")
    @GeneratedValue
    int lecturer_id;

    @Column(name = "lecturer_Name")
    String lecturer_Name;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<StudentCourse> studentCourse;



    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;


}
