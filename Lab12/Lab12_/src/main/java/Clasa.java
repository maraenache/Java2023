import org.junit.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
//PS C:/Users\Mara\Desktop\Lab12_\src\main\java\org\example> javac -cp "C:/Users/Mara/.m2/repository/junit/junit/4.13.2/junit-4.13.2.jar;" Clasa.java
//javac -cp "C:/Users/Mara/.m2/repository/junit/junit/4.13.2/junit-4.13.2.jar;" MyClass.java //
// java -cp "C:\Users\Mara\.m2\repository\junit\junit\4.13.2\junit-4.13.2.jar;." Clasa MyClass.class
public class Clasa {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: java ClassAnalyzer <class-file>");
            System.exit(1);
        }

        String classFileName = args[0];
        String filePath = new File(classFileName).toURI().toURL().toString();
        URLClassLoader classLoader = new URLClassLoader(new URL[]{new URL(filePath)});
        Class<?> loadedClass = classLoader.loadClass(getClassName(classFileName));


        System.out.println("Class: " + loadedClass.getName());
        System.out.println("Package: " + loadedClass.getPackageName());

        for (Method method : loadedClass.getDeclaredMethods()) {
            System.out.println("Method: " + method.getName());
        }

        for (Method method : loadedClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class) && method.getReturnType() == void.class) {
                System.out.println("Running test: " + method.getName());
                method.setAccessible(true);
                method.invoke(null);
            }
        }
    }

    private static String getClassName(String classFileName) {
        String[] parts = classFileName.split("/");
        String fileName = parts[parts.length - 1];
        return fileName.substring(0, fileName.lastIndexOf("."));
    }
}
