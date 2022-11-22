package tests;

import annotations.CalculatorServiceInjector;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.example.CalculatorService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@Story("IsOdd tests")
@ExtendWith(CalculatorServiceInjector.class)
public class IsOddTests {

    @Inject
    CalculatorService calculatorService;

    @ParameterizedTest(name = " Test {index}: verify that {0} % 2 != 0")
    @ValueSource(ints = {1, 3, 5})
    void parameterizedOddTest(int number) {
        log.info("Test 'parameterizedOddTest' started with value: '{}'", number);
        assertThat(calculatorService.isOdd(number)).isTrue();
    }

}
