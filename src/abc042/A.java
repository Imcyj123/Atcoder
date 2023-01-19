package abc042;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String str = in.readLine();
        System.out.println(str.equals("5 5 7") || str.equals("5 7 5") || str.equals("7 5 5") ? "YES" : "NO");
    }
}