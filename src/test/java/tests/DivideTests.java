package tests;

import argumentproviders.ArgumentsProviderForDivideMethod;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import tests.steps.CalculatorSteps;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@Story("Divide tests")
public class DivideTests {

    @ParameterizedTest(name = " Test {index}: verify that {0} / {1} == {2}")
    @ArgumentsSource(ArgumentsProviderForDivideMethod.class)
    void verifyDivideWithFloorMethodWithDataFromArgumentProvider(int x, int y, double result) {
        log.info("Test 'verifyDivideWithFloorMethodWithDataFromArgumentProvider' started with value: '{}', '{}', '{}'", x, y, result);
        assertThat(new CalculatorSteps().divideWithFloor(x, y)).isEqualTo(result);
    }

    @ParameterizedTest(name = " Test {index}: verify that {0} / {1} == {2}")
    @MethodSource("dataForDivideMethodSuccessfulTest")
    void verifyDivideWithFloorMethodWithDataFromMethod(int x, int y, double result) {
        log.info("Test 'verifyDivideWithFloorMethodWithDataFromMethod' started with value: '{}', '{}', '{}'", x, y, result);
        assertThat(new CalculatorSteps().divideWithFloor(x, y)).isEqualTo(result);
    }

    @ParameterizedTest(name = " Test {index}: verify that {0} / {1} == {2}")
    @CsvFileSource(resources = "/testdata/divide.csv", delimiter = ' ')
    void verifyDivideWithFloorMethodWithDataFromCsvFile(int x, int y, double result) {
        log.info("Test 'verifyDivideWithFloorMethodWithDataFromCsvFile' started with value: '{}', '{}', '{}'", x, y, result);
        assertThat(new CalculatorSteps().divideWithFloor(x, y)).isEqualTo(result);
    }

    private static Stream<Arguments> dataForDivideMethodSuccessfulTest() {
        return Stream.of(
                Arguments.of(6, 3, 2.0),
                Arguments.of(10, 5, 2.0),
                Arguments.of(330, 10, 33.0),
                Arguments.of(9, 2, 4.0),
                Arguments.of(800, 20, 40.0),
                Arguments.of(21, 7, 3.0)
        );
    }

}
