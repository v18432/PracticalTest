package com.example.practicaltest.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AccountCreateRequestDto {

    @NotEmpty
    private String name;

    @Size(min = 4, max = 4)
    private String pinCode;

    public AccountCreateRequestDto(String name,String pinCode) {
        this.name = name;
        this.pinCode = pinCode;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}
