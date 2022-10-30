import lombok.extern.slf4j.Slf4j;
import org.example.Calculator;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class SumTest {

    @Test
    void simpleSumTest() {
        log.info("Test started.");
        assertThat(new Calculator().sum(2, 2)).isEqualTo(4);
    }

}
