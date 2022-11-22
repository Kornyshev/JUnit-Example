package annotations;

import org.example.Calculator;
import org.example.CalculatorService;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

import javax.inject.Inject;
import java.lang.reflect.Field;

public class CalculatorServiceInjector implements TestInstancePostProcessor {

    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
        final Field[] declaredFields = testInstance.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Inject.class)
                    && field.getType().isAssignableFrom(CalculatorService.class)) {
                field.setAccessible(true);
                field.set(testInstance, new Calculator());
            }
        }
    }

}
