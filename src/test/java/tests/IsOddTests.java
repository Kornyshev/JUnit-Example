package tests;

import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import tests.steps.CalculatorSteps;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@Story("IsOdd tests")
public class IsOddTests {

    @ParameterizedTest(name = " Test {index}: verify that {0} % 2 != 0")
    @ValueSource(ints = {1, 3, 5})
    void parameterizedOddTest(int number) {
        log.info("Test 'parameterizedOddTest' started with value: '{}'", number);
        assertThat(new CalculatorSteps().isOdd(number)).isTrue();
    }

}
