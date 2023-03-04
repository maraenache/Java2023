package lab1.homework;

import java.util.Scanner;

/**
 * @author Mara
 */
public class Main {
    public static void main(String[] args) {
        long t0 = System.currentTimeMillis();//System.nanoTime();
        //MODIFICAT
         if(args.length<1)
        {
            System.out.println("Invalid number of arguments");
            System.exit(-1);
        }
        int n=Integer.parseInt(args[0]);

        /*varianta anterioara, fara argumente de la linia de comanda
        Scanner scan = new Scanner(System.in);
        System.out.println("Ex1:\nType an integer number n:");
        while (!scan.hasNextInt()) {
            System.out.println("That s not an integer, try again: ");
            scan.next();
        }
        int n = scan.nextInt();
        System.out.println("Valid number! :)\n");

        */

        int[][] matrix = new int[n][n];
        matrix = latinSquareMatrix(n);
        System.out.println("Ex2:\nThe latin square matrix of size " + n);
        printMatrix(matrix);
        System.out.println();


        System.out.println("Ex3:");
        printConcatStringBuilder(n, matrix);
        //printConcatString(n, matrix);


        System.out.println("Ex4: click dreapta pe Main -> Modify Run Configurations -> am adaugat la modify options -Xms4G -Xmx4G");
        long t1 = System.currentTimeMillis();//sau in nanosecunde cu System.nanoTime();
        if (n >= 30000)
            System.out.println("running time of application" + (t1 - t0));

        System.out.println("Ex5: Am deschis terminalul si am mers in folderul care contine proiectul cu cd /path \n\t*am compilat cu javac Main.java\n\t*am rulat cu java Main");
    }

    public static void printMatrix(int[][] matrix) {
        int n = matrix[1].length;
        for (int linie = 0; linie < n; linie++) {
            for (int coloana = 0; coloana < n; coloana++)
                System.out.print(matrix[linie][coloana] + " ");
            System.out.println();
        }
    }

    /**
     * o matrice Latin Square contine pe fiecare linie toate numerele de la 1 la n fara ca acestea sa se repete
     * in forma standard normalizata(reduced form), randul i+1 este o shiftare la stanga a randului i
     * astfel am pus pe prima linie toate numerele in oridine crescatoare
     * iar incepand cu a 2 a linie, am luat elemetul aflat cu o pozitie mai sus si am adunat 1, pt cazul in
     * care se depasea n am facut %n
     * @param n-dimensiunea matricei patratice
     * @return o matrice Latin Square
     */
    public static int[][] latinSquareMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int index = 0; index < n; index++)
            matrix[0][index] = index + 1;
        for (int linie = 1; linie < n; linie++) {
            for (int coloana = 0; coloana < n; coloana++)
                matrix[linie][coloana] = (matrix[linie - 1][coloana]) % n + 1;
        }
        return matrix;
    }

    /**
     * in prima varianta am concatenat toate simbolurile de pe fiecare linie
     * folosind stringbuilder, pt a nu crea de fiecare data un string nou,ci doar
     * il reactualizam cu append, sau il resetam cu setLength(0)
     * @param n-dimensiunea matricei
     * @param matrix-matricea careia ii concatenez liniile si coloanele
     */
    public static void printConcatStringBuilder(int n, int[][] matrix) {
        StringBuilder string = new StringBuilder();
        for (int line = 0; line < n; line++) {
            string.setLength(0);
            for (int column = 0; column < n; column++) {
                string.append(matrix[line][column]);
                string.append(" ");
            }
            if (n < 30000)
                System.out.println("line " + line + ": " + string);
        }
        for (int column = 0; column < n; column++) {
            string.setLength(0);
            for (int linie = 0; linie < n; linie++) {
                string.append(matrix[linie][column]);
                string.append(" ");
            }
            if (n < 30000)
                System.out.println("column " + column + ": " + string);
        }
    }

    /**
     * am concatenat simbolurile cu +, dar astfel se creeaza mai multe stringuri in memorie
     * de aceea am comentat varianta asta
     * @param n-dimensiunea matricei
     * @param matrix-matricea careia ii concatenez liniile si coloanele
     */
    public static void printConcatString(int n, int[][] matrix) {
        String string = new String();
        for (int line = 0; line < n; line++) {
            string = "";
            for (int coloana = 0; coloana < n; coloana++) {
                string += matrix[line][coloana];
                string += " ";
            }
            System.out.println("line " + line + ": " + string);
        }
        for (int column = 0; column < n; column++) {
            string = "";
            for (int linie = 0; linie < n; linie++) {
                string += matrix[linie][column];
                string += " ";
            }
            System.out.println("column " + column + ": " + string);
        }
    }
}
