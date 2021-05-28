package com.tourism.tourism.person.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonChangePhotoDTO {
    private Long personId;
    private String base64;
}
