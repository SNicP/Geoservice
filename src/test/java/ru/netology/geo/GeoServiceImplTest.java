package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import java.util.Optional;

class GeoServiceImplTest {
    GeoServiceImpl geoService;

    @BeforeEach
    public void beforeEach() {
        geoService = new GeoServiceImpl();
    }

    @ParameterizedTest
    @CsvSource({
            "127.0.0.1,",
            "172.0.32.11, RUSSIA",
            "96.44.183.149, USA",
            "172.198.0.1, RUSSIA",
            "96.55.55.96, USA"})
    void get_location_by_IP(String ip, String expectedCountry) {
        //Given

        //When
        Optional<Location> location = Optional.ofNullable(geoService.byIp(ip));
        Optional<Country> country = Optional.ofNullable(location.get().getCountry());
        String actualCountry = country.isPresent() ? country.get().toString() : null;

        //Then
        Assertions.assertEquals(expectedCountry, actualCountry);
    }

    @Test
    void get_location_by_coordinates() {
        //Given
        double latitude = 23.732208;
        double longitude = 52.093663;

        //Then
        Assertions.assertThrows(RuntimeException.class,
                () -> geoService.byCoordinates(latitude, longitude));
    }
}