package com.example.practicaltest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
public class AccountCreateRequestDto {

    @NotEmpty
    private String name;

    @Size(min = 4, max = 4)
    private String pinCode;

}
