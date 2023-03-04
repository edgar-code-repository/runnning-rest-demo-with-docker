package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_country")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Country {

    @Id
    private int countryId;
    private String name;
    private String officialName;
    private String capital;

}
