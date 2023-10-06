import javax.lang.model.element.NestingKind;
import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Executable;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.*;
import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) {

//        FileManager fm = new FileManager();
//        StringBuilder filetext = fm.read("test1.txt");
//        System.out.println(filetext);
//        TestGui test = new TestGui(400, 400);

        Map<String, String[]> dict = new HashMap<>();

        dict.put("a2", new String[]{"a2", "b2"});
        dict.put("a1", new String[]{"a1", "b1"});
        dict.put("a4", new String[]{"a4", "b4"});
        dict.put("A4", new String[]{"A4", "B4"});
        dict.put("c3", new String[]{"c3", "b3"});
        dict.put("d3", new String[]{"d3", "b3"});
        List<String> alist = new ArrayList<>(dict.keySet());
        Collections.sort(alist);;
        for(String each: alist){
            System.out.println(Arrays.toString(dict.get(each)));
        }
        System.out.println(alist);

    }
}