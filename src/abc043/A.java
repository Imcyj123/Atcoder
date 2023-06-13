package abc043;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {
    static BufferedReader in;

    public static void main(String[] args) throws Exception {
        in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += i;
        }
        System.out.println(sum);
        System.out.flush();
    }
}