package tests;

import annotations.CalculatorServiceInjector;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.example.CalculatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@Story("Sum tests")
@ExtendWith(CalculatorServiceInjector.class)
public class SumTests {

    @Inject
    CalculatorService calculatorService;

    @Test
    void simpleSumTest() {
        log.info("Test 'simpleSumTest' started");
        assertThat(calculatorService.sum(2, 2)).isEqualTo(4);
    }

    @ParameterizedTest(name = " Test {index}: verify that {0} + {1} == {2}")
    @CsvSource(delimiter = ' ', value = {
            "1 1 2",
            "5 7 12",
            "50 50 100",
            "-50 50 0",
            "2 1998 2000",
            "7 7 14"})
    void verifySumMethodWithSeveralCsvRows(int x, int y, int result) {
        log.info("Test 'verifySumMethodWithSeveralCsvRows' started with value: '{}', '{}', '{}'", x, y, result);
        assertThat(calculatorService.sum(x, y)).isEqualTo(result);
    }

    @ParameterizedTest(name = " Test {index}: verify that {0} + {1} == {2}")
    @CsvFileSource(resources = "/testdata/sum.csv", delimiter = ' ')
    void verifySumMethodWithDataFromCsvFile(int x, int y, int result) {
        log.info("Test 'verifySumMethodWithDataFromCsvFile' started with value: '{}', '{}', '{}'", x, y, result);
        assertThat(calculatorService.sum(x, y)).isEqualTo(result);
    }

}
