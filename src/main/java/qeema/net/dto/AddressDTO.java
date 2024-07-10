package qeema.net.dto;

public record AddressDTO(
        int id,
        String streetName,
        String country,
        String government
) {}