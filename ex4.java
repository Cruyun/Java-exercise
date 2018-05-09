import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String []args) throws Exception {
        String s;
        Scanner scanner = new Scanner(System.in);
        s = scanner.next();
        scanner.close();

        int b1 = s.indexOf("b");
        int o = s.indexOf("o");
        int m = s.indexOf("m");
        int b2 = s.indexOf("b", b1 + 1);

        if (b1 != -1 && b2 != -1 && o != -1 && m != -1 && (b1 < o) && (o < m) && (m < b2)) {
            System.out.println("bomb");
            throw new Exception("bomb");
        } else {
            filter(s);
        }

    }
    private static void filter(String str) {
        Pattern pat = Pattern.compile("([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])");
        Matcher alphas = pat.matcher(str);
        while(alphas.find()) {
            System.out.println(alphas.group());
        }
    }
}

