import org.junit.Test;

public class MyClass {
    @Test
    public void test() {
        //System.out.println("Running test...");
        // Assertions or other test logic goes here
    }
    public void testMethod1() {
        System.out.println("Test Method 1 - This should be run");
    }

    public void testMethod2() {
        System.out.println("Test Method 2 - This should NOT be run");
    }

    public int nonTestMethod() {
        System.out.println("Non-Test Method");
        return 42;
    }
}
