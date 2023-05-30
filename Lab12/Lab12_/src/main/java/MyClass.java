import org.junit.Test;

public class MyClass {
    @Test
    public static void test() {
    }
    public void testMethod1() {
        System.out.println("Test Method 1 - This should be run");
    }

    public void testMethod2() {
        System.out.println("Test Method 2 - This should NOT be run");
    }

    public void nonTestMethod() {
        System.out.println("Non-Test Method");
    }
}
