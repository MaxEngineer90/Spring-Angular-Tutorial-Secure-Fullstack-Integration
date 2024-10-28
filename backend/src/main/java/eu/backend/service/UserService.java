package eu.backend.service;


import eu.backend.dto.AddressDTO;
import eu.backend.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserService {

    private static final String[] STREETS = {
            "Hauptstraße", "Bahnhofstraße", "Schulstraße", "Feldstraße", "Parkstraße"
    };

    private static final String[] CITIES = {
            "Berlin", "München", "Hamburg", "Köln", "Frankfurt"
    };

    private static final String[] COUNTRIES = {
            "Deutschland", "Österreich", "Schweiz"
    };

    private static final Random RANDOM = new Random();


    public UserDTO getUserWithAddress(UserDTO userDTO) {
        userDTO.setAddressDTO(generateRandomAddress());
        return userDTO;
    }


    private AddressDTO generateRandomAddress() {
        String street = STREETS[RANDOM.nextInt(STREETS.length)];
        String houseNumber = String.valueOf(RANDOM.nextInt(100) + 1);
        String postalCode = String.format("%05d", RANDOM.nextInt(100000));
        String city = CITIES[RANDOM.nextInt(CITIES.length)];
        String country = COUNTRIES[RANDOM.nextInt(COUNTRIES.length)];

        return new AddressDTO(street, houseNumber, postalCode, city, country);
    }
}
