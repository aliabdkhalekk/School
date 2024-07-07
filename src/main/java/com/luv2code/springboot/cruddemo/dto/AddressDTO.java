package com.luv2code.springboot.cruddemo.dto;

public record AddressDTO(
        int id,
        String streetName,
        String country,
        String government
) {}