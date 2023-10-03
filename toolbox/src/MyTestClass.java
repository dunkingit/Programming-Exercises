import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class MyTestClass {

//    public StringBuilder startTest(int num, String aString){
//        StringBuilder testmethodName = new StringBuilder();
//        Class<?> cls = this.getClass();
//
//        for (Method method : cls.getDeclaredMethods()) {
//            String methodName = method.getName();
//            String returnType = method.getReturnType().getSimpleName();
//            Parameter[] parameters = method.getParameters();

//            testmethodName.append(cls.getSimpleName());
//            testmethodName.append("_");
//            testmethodName.append(methodName);
//            testmethodName.append("_return_");
//            testmethodName.append(returnType);
//
//            for (Parameter parameter : parameters) {
//                testmethodName.append("_");
//                testmethodName.append(parameter.getType().getSimpleName());
//            }
//
//            testmethodName.append("_expected_");
//
//            if(aString.isEmpty() && num == 0){
//                testmethodName.append("none_expected.");
//            }else {
//                if(num > 0){
//                    testmethodName.append(num);
//                }
//
//                if(!aString.isEmpty()){
//                    testmethodName.append(aString);
//                }
//
//            }
//
//            System.out.println(testmethodName.toString());
//            testmethodName.append("\n");
//        }
//        return testmethodName;
//    };
//
//    public StringBuilder startTest(int num){
//        return this.startTest(num, "");
//    };
//
//    public StringBuilder startTest(String aString){
//        return this.startTest(0, aString);
//    };
//
//    public StringBuilder startTest(){
//        return this.startTest(0, "");
//    };

    public void newMethod(){
        System.out.println("Checking this method");
    };
}
