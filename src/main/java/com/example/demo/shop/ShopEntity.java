package com.example.demo.shop;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "shops")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "location",nullable = false)
    private String location;

    @Column(name = "phoneNumber",nullable = false)
    private String phoneNumber;

    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private LocalDateTime deleteAt;



}
