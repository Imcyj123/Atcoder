package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class A {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int a = Integer.parseInt(in.readLine());
        String[] bc = in.readLine().split(" ");
        int b = Integer.parseInt(bc[0]);
        int c = Integer.parseInt(bc[1]);
        String s = in.readLine();
        System.out.println((a + b + c) + " " + s);
    }
}