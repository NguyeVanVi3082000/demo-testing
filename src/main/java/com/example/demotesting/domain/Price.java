package com.example.demotesting.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "PRICE")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRICE_ID")
    private Long id;

    @Column(name = "PRICE_NAME")
    private String name;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "PRICE_DESCRIPTION")
    private String description;

}
