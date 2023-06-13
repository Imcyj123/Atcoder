package abc295;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        in.readLine();
        String[] split = in.readLine().split(" ");
        boolean yes = false;
        for (String s : split) {
            if (s.equals("and") || s.equals("not") || s.equals("that") || s.equals("the") || s.equals("you")) {
                yes = true;
                break;
            }
        }
        System.out.println(yes ? "Yes" : "No");
    }
}