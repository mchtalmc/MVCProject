package com.tpe.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "t_student")
public class Student {
    //Wrapper class kullanma sebebim default deger almasini istemiyorum.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Integer grade;
    private LocalDateTime createDate= LocalDateTime.now();
}
