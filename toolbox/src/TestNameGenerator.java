import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestNameGenerator {
    public static List<String> MethodNames(Class<?> cls, boolean getAllMethods) {
        List<String> testMethodNames = new ArrayList<>();
        Method[] methods;
        // If you want all methods (including private and protected), use cls.getDeclaredMethods()
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

            if(parameters.length > 1) {
                for (Parameter parameter : parameters) {
                    testmethodName.append(parameter.getType().getSimpleName());
                    testmethodName.append("_");
                }
            }

            testmethodName.append("expected_output");
            testMethodNames.add(testmethodName.toString());
        }

        Print.print(testMethodNames);
        return testMethodNames;
    }


    public static List<String> MethodNames(Class<?> cls, String addNote, boolean getAllMethods) {
        List<String> testMethodNames = new ArrayList<>();
        Method[] methods;
        // If you want all methods (including private and protected), use cls.getDeclaredMethods()
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
                testmethodName.append(parameter.getType().getSimpleName());
                testmethodName.append("_");
            }

            testmethodName.append("expected_");
            testmethodName.append(addNote.isEmpty()? " ":addNote.replace(" ", "_"));
            testMethodNames.add(testmethodName.toString());
        }
        Print.print(testMethodNames);
        return testMethodNames;
    }
}
