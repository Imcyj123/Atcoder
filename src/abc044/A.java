package abc044;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(in.readLine());
        int K = Integer.parseInt(in.readLine());
        int X = Integer.parseInt(in.readLine());
        int Y = Integer.parseInt(in.readLine());
        if (N > K) {
            System.out.println((N - K) * Y + K * X);
        } else {
            System.out.println(N * X);
        }
        System.out.close();
    }
}
