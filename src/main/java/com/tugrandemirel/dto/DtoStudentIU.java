package com.tugrandemirel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

// IU dediğim Insert Update. Insert ve update dönüşlerinde kullanılacak olan DTO
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU {
    private String firstName;
    private String lastName;
    private Date birthOfDate;
}
