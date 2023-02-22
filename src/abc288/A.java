package abc288;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    final static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static long r, ret;
    static boolean negative = false;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            long a = readInt();
            long b = readInt();
            out.write((a + b) + "\n");
        }
        out.flush();
    }

    static long readInt() throws Exception {
        ret = 0;
        r = in.read();
        if (r == '-') {
            negative = true;
            r = in.read();
        }
        while (r > 47 && r < 58) {
            ret *= 10;
            ret += (r & 15);
            r = in.read();
        }
        if (negative) {
            ret *= -1;
            negative = false;
        }
        return ret;
    }
}