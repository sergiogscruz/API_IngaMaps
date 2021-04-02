package com.tourism.tourism.models;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Employee extends Person {
    
    @Getter
	@Setter
    private String funcionar;

    public Employee() {

    }
    
}
