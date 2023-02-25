package lab1.compulsory;

class Main {
    public static void main(String[] args) {
        //1
        System.out.println("Hello World");
        //2
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        for (String language : languages) {
            System.out.print(language + " ");
        }
        //3
        int n = (int) (Math.random() * 1_000_000);
        System.out.println("\nRandom number generated: " + n);
        //4
        int oldResult, result;
        //multiply n by 3
        result = n * 3;
        System.out.println(n + " * 3 = " + result);

        //add the binary number 10101 to the result
        oldResult = result;
        result = oldResult + 0b10101;
        System.out.println(oldResult + " + 0b10101 = " + result);//+21

        //add the hexadecimal number FF to the result
        oldResult = result;
        result = oldResult + 0xFF;
        System.out.println(oldResult + " + 0xFF = " + result);//+255

        oldResult = result;
        result = oldResult * 6;
        System.out.println(oldResult + " * 6 = " + result);
        n = result;
        /*  varianta 2
            n*=3;
            n+=0b10101;
            n+=0xFF;
            n*=6;
        */
        //5
        int sum = 0;
        while (n > 9) {
            sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            n = sum;
        }
        result = sum;
        /* varianta2
           result=n%9;
           if (result==0)
               result = 9;
         */
        System.out.println("The one digit sum is " + result);
        //6
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }
}
