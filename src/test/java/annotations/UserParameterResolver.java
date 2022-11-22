package annotations;

import models.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.extension.*;

import javax.inject.Inject;
import java.util.HashMap;

public class UserParameterResolver implements ParameterResolver {

    DataManager dataManager = new DataManager();

    @Override
    public boolean supportsParameter(ParameterContext parameterContext,
                                     ExtensionContext extensionContext) throws ParameterResolutionException {
        return extensionContext.getRequiredTestMethod().isAnnotationPresent(Inject.class)
                && parameterContext.getParameter().getType().isAssignableFrom(User.class);
    }

    @Override
    public User resolveParameter(ParameterContext parameterContext,
                                 ExtensionContext extensionContext) throws ParameterResolutionException {
        final TestCaseId testCaseId = extensionContext.getRequiredTestMethod().getAnnotation(TestCaseId.class);
        if (testCaseId == null) {
            throw new ParameterResolutionException("TestCaseId must be here");
        }
        return dataManager.getUserById(testCaseId.value());
    }

}

class DataManager {

    private HashMap<String, User> usersForTestCases;

    public DataManager() {
        this.usersForTestCases = new HashMap<>();
        this.usersForTestCases.put("60490", new User("login", "password", "something@email.com"));
    }

    public User getUserById(String id) {
        return usersForTestCases.entrySet()
                .stream()
                .filter(entry -> entry.getKey().equals(id))
                .findFirst().orElseThrow()
                .getValue();
    }

}
