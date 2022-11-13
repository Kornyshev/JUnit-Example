package tests;

import argumentconverters.SlashyDateConverter;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@Story("Some different tests")
public class DifferentTests {

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    void isBlankShouldReturnTrueForAllTypesOfBlankStrings(String input) {
        log.info("Test 'isBlankShouldReturnTrueForAllTypesOfBlankStrings' started with value: '{}'", input);
        assertThat(input.isBlank()).isTrue();
    }

    @ParameterizedTest
    @NullSource
    void verifyNullAnnotationForStrings(String input) {
        log.info("Test 'verifyNullAnnotationForStrings' started with value: '{}'", input);
        assertThat(Objects.isNull(input)).isTrue();
    }

    @ParameterizedTest
    @EnumSource(Month.class)
    void verifyMonthGetValueNumber(Month month) {
        log.info("Test 'verifyMonthGetValueNumber' started with value: '{}'", month);
        assertThat(month.getValue() >= 1 && month.getValue() <= 12).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"2018/12/25,2018", "2019/02/11,2019"})
    void getYearShouldWorkAsExpected(@ConvertWith(SlashyDateConverter.class) LocalDate date, int expected) {
        log.info("Test 'getYearShouldWorkAsExpected' started with value: '{}', '{}'", date, expected);
        assertThat(date.getYear()).isEqualTo(expected);
    }

}
