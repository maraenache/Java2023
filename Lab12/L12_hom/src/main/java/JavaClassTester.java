import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
//javac -cp "C:/Users/Mara/.m2/repository/junit/junit/4.13.2/junit-4.13.2.jar;" MyClass.java //

//java -cp "C:\Users\Mara\.m2\repository\junit\junit\4.13.2\junit-4.13.2.jar;." JavaClassTester "C:\Users\Mara\Desktop\L12_hom\src\main\java"
public class JavaClassTester {

    private static int totalTests = 0;
    private static int passedTests = 0;

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Please provide a folder");
            return;
        }
        String path = args[0];
        File file = new File(path);
        List<Class<?>> classes = new ArrayList<>();
        if (file.exists() && file.isDirectory()) {
            classes = getClassesFromFolder(file, "");
            for (Class<?> clazz : classes) {
                System.out.println("Loaded class: " + clazz.getName());
            }

        } else {
            System.out.println("Invalid input. Please provide a folder");
            return;
        }
        for (Class<?> clazz : classes) {
            System.out.println("Class: " + clazz.getName());
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Test.class)) {
                    totalTests++;
                    System.out.println("  Method: " + method.getName());
                    try {
                        Object instance = clazz.newInstance();
                        Parameter[] parameters = method.getParameters();
                        Object[] arguments = new Object[parameters.length];
                        for (int i = 0; i < parameters.length; i++) {
                            arguments[i] = generateMockValue(parameters[i].getType());
                        }
                        method.invoke(instance, arguments);
                        passedTests++;
                        System.out.println("    Passed");
                    } catch (Exception e) {
                        System.out.println("    Failed: " + e.getMessage());
                    }
                }
            }
        }
        System.out.println("Total tests: " + totalTests);
        System.out.println("Passed tests: " + passedTests);
        System.out.println("Failed tests: " + (totalTests - passedTests));
    }

    private static List<Class<?>> getClassesFromFolder(File folder, String packageName) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                classes.addAll(getClassesFromFolder(file, ""));
            } else if (file.getName().endsWith(".class")) {
                Class<?> clazz = Class.forName(file.getName().substring(0, file.getName().length() - 6));
                classes.add(clazz);
            }
        }
        return classes;
    }


    private static Object generateMockValue(Class<?> type) {
        if (type == int.class) {
            return 0;
        } else if (type == String.class) {
            return "";
        } else {
            return null;
        }
    }

}
