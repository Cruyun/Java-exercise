import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入矩阵1的行、列和矩阵2的列：");
        int m, n, p;
        m = scanner.nextInt();
        n = scanner.nextInt();
        p = scanner.nextInt();

        int a[][] = new int[m][n];
        int b[][] = new int[n][p];

        System.out.println("请按行输入矩阵1的值：");

        int i, j, k;
        for (i = 0; i < a.length; i++) {
            for (j = 0; j < a[0].length; j++) {
                a[i][j] = scanner.nextInt();
            }
        }

        System.out.println("请按行输入矩阵2的值：");
        for (i = 0; i < n; i++) {
            for (j = 0; j < p; j++) {
                b[i][j] = scanner.nextInt();
            }
        }

        int c[][] = new int[m][p];
        for (i = 0; i < a.length; i++) {
            for (j = 0; j < b[0].length; j++) {
                int temp = 0;
                for (k = 0; k < b.length; k++) {
                    temp += a[i][k] * b[k][j];
                }
                c[i][j] = temp;
            }
        }

        for (int d[] : c) {
            for (int e: d) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
