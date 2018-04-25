import java.text.DecimalFormat;
import java.util.*;

interface Calculate {
    double calcGrade(double grade[]);
}

class calcMethod1 implements Calculate {
    public double calcGrade(double grade[]) {
        double sum = 0.0;
        for (double x : grade) {
            sum += x;
        }
        double average = sum / grade.length;
        return average;
    }
}

class calcMethod2 implements Calculate {
    public double calcGrade(double grade[]) {
        double max = grade[0];
        double min = grade[0];
        double sum = 0.0;
        for (double x : grade) {
            sum += x;
            if (max < x) max = x;
            if (min > x) min = x;
        }
        sum = sum - max - min;
        double average = sum / (grade.length - 2);
        return average;
    }
}

public class Main {
    public static void main(String []args) {
        double grade[] = new double[7];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            grade[i] = scanner.nextDouble();
        }
        scanner.close();

        DecimalFormat df = new DecimalFormat("0.00");

        Calculate calculate1;
        calculate1 = new calcMethod1();
        System.out.println("calculate method1: " + df.format(calculate1.calcGrade(grade)));

        Calculate calculate2;
        calculate2 = new calcMethod2();
        System.out.println("calculate method2: " + df.format(calculate2.calcGrade(grade)));
    }
}