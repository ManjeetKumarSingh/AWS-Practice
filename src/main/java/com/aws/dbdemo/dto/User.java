package com.aws.dbdemo.dto;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "user")
@Data
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private  String userName;
    private  String userEmail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_userdetails_id")
    private UserDetails userDetails;


}
