

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

        FileManager fm = new FileManager();
        StringBuilder filetext = fm.read("test1.txt");
        System.out.println(filetext);

    }
}