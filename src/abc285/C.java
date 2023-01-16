package abc285;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class C {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    final static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        char[] charr = in.readLine().toCharArray();
        long res = 0;
        for (char c : charr) {
            res *= 26;
            res += c - '@';
        }
        System.out.println(res);
    }
}