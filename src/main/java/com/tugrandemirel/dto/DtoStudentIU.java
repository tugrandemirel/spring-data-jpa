package com.tugrandemirel.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @NotEmpty(message = "First name cannot be empty")
    @NotNull(message = "First name cannot be null")
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty")
    private String lastName;

    private Date birthOfDate;
}
