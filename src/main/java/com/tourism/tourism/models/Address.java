package com.tourism.tourism.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Address {

    @Getter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

    @Getter
	@Setter
    private String country;

    @Getter
	@Setter
    private String state;

    @Getter
	@Setter
    private String city;

    public Address() {
        
    }
}
