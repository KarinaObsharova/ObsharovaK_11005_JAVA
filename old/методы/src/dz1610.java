import java.util.Scanner;

public class dz1610 {
    public static void main(String args[]) {
        Scanner a = new Scanner(System.in);

        int n = a.nextInt();
        int m = a.nextInt();
        int[][] matrix = new int[n][m];
        int[][] matrix2 = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = a.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix2[i][j] = a.nextInt();
            }
        }

        // Задача 1
        int c = rang(a.nextInt());
        System.out.println(c);

        // Задание 2
        revers("Hello, world!");

        // Задача 3
         int[] array1 = new int[a.nextInt()];
          for (int i = 0; i < array1.length; i++) {
            array1[i] = a.nextInt();
          }

        int max = arrayMax(array1);
        System.out.println(max);

        // Задача 4
        int[] array2 = new int[a.nextInt()];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = a.nextInt();
        }

        int[] array3 = new int[a.nextInt()];
        for (int i = 0; i < array3.length; i++) {
            array3[i] = a.nextInt();
        }

        twoArray(array2,array3);

        // Задача 5
        transMarix(matrix);
        int [][] transMatrix = transMarix(matrix);
        for (int i = 0; i < transMatrix.length ; i++) {
            for (int j = 0; j < transMatrix[0].length; j++){
                System.out.print(transMatrix[i][j] + " ");
            }
            System.out.println();
        }

        // Задача 6
        sumMatrix(matrix, matrix2);
        int[][] sum = sumMatrix(matrix, matrix2);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void revers(String str) {
        char[] result = str.toCharArray();
        char temp;
        int i, j;
        for (i = 0, j = result.length - 1; i < j; i++, j--) {
            temp = result[i];
            result[i] = result[j];
            result[j] = temp;
        }
        System.out.println(result);
    }
    public static int rang(int x) {
        int c = 0;
        while (x > 0) {
            x = x / 10;
            c++;
        }
        return c;
    }
    public static int arrayMax(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        return max;
    }
    public static void twoArray(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        for (int i = 0; i < c.length; i++) {
            if (i < a.length)
                c[i] = a[i];
            else
                c[i] = b[i - a.length];
        }
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
        }
    }
    public static int[][] transMarix (int[][] matrix){
        int[][] transMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++){
                transMatrix[j][i] = matrix[i][j];
            }
        }
        return transMatrix;
    }
    public static int[][] sumMatrix(int[][] matrix, int[][] matrix2) {
        int[][] sum = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sum[i][j] = matrix[i][j] + matrix2[i][j];
            }
        }
        return sum;


    }
}
