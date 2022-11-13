package tests;

import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import tests.steps.CalculatorSteps;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@Story("Multiple tests")
public class MultipleTests {

    @ParameterizedTest(name = " Test {index}: verify that {0} * {1} == {2}")
    @CsvFileSource(resources = "/testdata/multiplication.csv", delimiter = ' ')
    void verifyMultipleMethodWithDataFromCsvFile(int x, int y, int result) {
        log.info("Test 'verifyMultipleMethodWithDataFromCsvFile' started with value: '{}', '{}', '{}'", x, y, result);
        assertThat(new CalculatorSteps().multiple(x, y)).isEqualTo(result);
    }

}
