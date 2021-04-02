package com.tourism.tourism.models;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Tourist extends Person {
    
    @Getter
	@Setter
    private String viajem;

    public Tourist() {
        
    }
}
