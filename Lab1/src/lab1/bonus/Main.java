package lab1.bonus;
/**
 * @author Mara
 */
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Ex1> Type the number of verticies for Cn:");
        int n = scan.nextInt();
        if (n < 3) {
            System.out.println("A cycle contains at least 3 vertecies => there is no adjency matrix of C" + n);
            return;
        }

        int[][] matrixOfCn = new int[n][n];
        matrixOfCn = adjencyMatrixOfCn(n);

        System.out.println("The adjacency matrix A of a cycle graph C" + n + " is:");
        printMatrix(matrixOfCn);

        nPowersOfMatrix(matrixOfCn, n);

        System.out.println("\n\nEx2> Type the number of verticies and the degree value for the regular graph:");
        int numberOfVerticies = scan.nextInt();
        int degree = scan.nextInt();
        if (degree > numberOfVerticies - 1) {
            System.out.println("Invalid input: Maximum degree of a vertex is n-1");
            return;
        } else if (numberOfVerticies * degree % 2 == 1)//suma gradelor trb sa fie nr par
        {
            System.out.println("Invalid input: There is no regular graph with " + n + " vertecies where the degree of each vertex is " + degree);
            return;
        }

        int[][] matrixOfRegular = new int[numberOfVerticies][numberOfVerticies];
        matrixOfRegular = adjencyMatrixOfRegular(numberOfVerticies, degree);


        System.out.println("The adjacency matrix of a regular graph with " + n + " vertecies and the degree: "+degree);
        printMatrix(matrixOfRegular);
    }

    /**
     * afiseaza elementele unei matrice
     * @param matrix
     */
    public static void printMatrix(int[][] matrix) {
        int n = matrix[1].length;
        for (int linie = 0; linie < n; linie++) {
            for (int coloana = 0; coloana < n; coloana++)
                System.out.print(matrix[linie][coloana] + " ");
            System.out.println();
        }
    }

    /**
     * in matricea de adiacenta a unui ciclu muchiile sunt de forma [nod,nod+1];
     * de ex pt C5 [1,2],[2,3],[3,4],[4,5]
     * si in plus mai este muchia de la primul nod la ultimul [1,5], care de fapt este
     * tot [nod, nod+1] dar nod+1 este modulo numarului total de vf
     * astfel am adaugat 1 in matricea de adiacenta unde este muchie
     * fiind simetrica am completat atat pentru matrice[i][j] cat si pt matrice[j][i]
     * @param n -numarul de noduri
     * @return -matricea de adiacenta a lui Cn
     */
    public static int[][] adjencyMatrixOfCn(int n) {
        int[][] matrix = new int[n][n];
        for (int index = 0; index < n; index++) {
            matrix[index][(index + 1) % n] = 1;
            matrix[(index + 1) % n][index] = 1;
        }
        return matrix;
    }

    /**
     * prima putere A^2 se obtine inmultind
     * matricea primita ca parametru, de ex A cu ea insasi,
     * pentru urmatoarele puteri, matricea Ai+1 se obtine inmultiind matricea
     * Ai cu A
     * @param matrix-matricea careia vrem sa ii afisam puterile
     * @param n -numarul de puteri afisate (sau aflat cu length)
     */
    public static void nPowersOfMatrix(int matrix[][], int n) {
        int[][] result = matrix;
        for (int power = 2; power <= n; power++) {
            System.out.println("\nA^ power" + power);
            result = multiplyMatrix(result, matrix, n);
            printMatrix(result);
        }
    }

    /**
     * inmulteste matricea matrix1 cu matricea matrix2
     * pentru a afla elementul de pe pozitia i, j in matricea produs
     * se face suma produselor dintre matrice1[i][1] si matrice2[1][j]
     * cu matrice[i][2]*matrice[2][j]...
     * @param matrix1
     * @param matrix2
     * @param n-dimensiunea matricelor patratice
     * @return- matricea obtinuta ca rezultat
     */
    public static int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2, int n) {
        int result[][] = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                result[i][j] = 0;
                for (int k = 0; k < 3; k++)
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
            }
        return result;
    }

    /**
     * un graf regulat are toate nodurile de acelasi grad (al 2 lea parametru)
     * am creat o lista ce contine secventa gradelor tuturor varfurilor, care initial are
     * pe toate pozitiile 0, parcurg matricea deasupra diagonalei principale,
     * si verific daca pot avea muchia i j, astfel:
     * daca in matrice am pe pozitia i j 0, verific daca gradele ambelor varfuri sunt
     * mai mici decat numarul de grade la care trebuie sa ajung, daca da, nu este suficient
     * intrucat pentru exemplul 4 2, daca as verifica doar aceste conditii, nodul 4 va ramane fara
     * nicio muchie.
     * Verific in plus ca muchia are ca si capat un varf de grad minim, pentru a acoperi cu siguranta
     * toate varfurile
     * Daca se respecta regulile, pot trasa o muchie si atribui 1 pe pozitia i j in matricea de adiacenta
     * @param n-numarul de varfuri
     * @param d-gradul fiecarui nod
     * @return
     */
    public static int[][] adjencyMatrixOfRegular(int n, int d) {
        int[][] matrixOfRegular = new int[n][n];
        int[] vertexDegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (matrixOfRegular[i][j] == 0 && vertexDegree[i] < d && vertexDegree[j] < d && vertexDegree[j] == mindegree(vertexDegree)) {
                    matrixOfRegular[i][j] = 1;
                    matrixOfRegular[j][i] = 1;
                    vertexDegree[i]++;
                    vertexDegree[j]++;
                }
            }
        }
        return matrixOfRegular;
    }

    /**
     * @param array-secventa de grade
     * @return elementul minim al unui vector
     */
    public static int mindegree(int[] array) {
        int min = array[0];
        for (int index = 1; index < array.length; index++)
            min = array[index];
        return min;
    }
}