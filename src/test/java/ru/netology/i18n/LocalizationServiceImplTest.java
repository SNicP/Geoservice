package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import ru.netology.entity.Country;

class LocalizationServiceImplTest {
    LocalizationService localizationService;

    @BeforeEach
    public void beforeEach() {
        localizationService = new LocalizationServiceImpl();
    }

    @ParameterizedTest
    @CsvSource({
            "RUSSIA, Добро пожаловать",
            "GERMANY, Welcome",
            "USA, Welcome",
            "BRAZIL, Welcome"})
    void locale(Country country, String messageExpected) {
        //When
        String messageActual = localizationService.locale(country);

        //Then
        Assertions.assertEquals(messageExpected, messageActual);
    }
}