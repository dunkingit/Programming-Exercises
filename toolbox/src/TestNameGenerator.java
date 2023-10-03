import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

public class TestNameGenerator {

    public static List<String> generateTestMethodNames(Class<?> cls, String aString, boolean getAllMethods) {
        List<String> testMethodNames = new ArrayList<>();
        Method[] methods;
        // If you want all methods
        // (including private and protected),
        // use cls.getDeclaredMethods()
        methods = getAllMethods? cls.getDeclaredMethods():cls.getMethods();

        for (Method method : methods) {
            StringBuilder testmethodName = new StringBuilder();
            String methodName = method.getName();
            String returnType = method.getReturnType().getSimpleName();
            Parameter[] parameters = method.getParameters();

            testmethodName.append(cls.getSimpleName());
            testmethodName.append("_");
            testmethodName.append(methodName);
            testmethodName.append("_return_");
            testmethodName.append(returnType);
            testmethodName.append("_parameters_");

            for (Parameter parameter : parameters) {
                testmethodName.append("_");
                testmethodName.append(parameter.getType().getSimpleName());
            }

            testmethodName.append("_expected_");
            testmethodName.append(aString.isEmpty()? "none_expected":aString.replace(" ", "_"));
            testMethodNames.add(testmethodName.toString());
        }

        return testMethodNames;
    }
}
