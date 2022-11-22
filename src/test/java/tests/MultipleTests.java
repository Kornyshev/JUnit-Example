package tests;

import annotations.CalculatorServiceInjector;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.example.CalculatorService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@Story("Multiple tests")
@ExtendWith(CalculatorServiceInjector.class)
public class MultipleTests {

    @Inject
    CalculatorService calculatorService;

    @ParameterizedTest(name = " Test {index}: verify that {0} * {1} == {2}")
    @CsvFileSource(resources = "/testdata/multiplication.csv", delimiter = ' ')
    void verifyMultipleMethodWithDataFromCsvFile(int x, int y, int result) {
        log.info("Test 'verifyMultipleMethodWithDataFromCsvFile' started with value: '{}', '{}', '{}'", x, y, result);
        assertThat(calculatorService.multiple(x, y)).isEqualTo(result);
    }

}
