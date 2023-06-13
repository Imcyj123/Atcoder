package arc058;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class D {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    final static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static int r, ret, mod = (int) 1e9 + 7;
    static long[] fac = new long[200000], inv = new long[200000];

    public static void main(String[] args) throws Exception {
        int h = readInt();
        int w = readInt();
        int a = readInt();
        int b = readInt();

    }

    static long mod(long n){
        if(n>=mod) n%=mod;
        return n;
    }

    static int readInt() throws Exception {
        ret = 0;
        r = in.read();
        while (r > 47 && r < 58) {
            ret *= 10;
            ret += (r & 15);
            r = in.read();
        }
        return ret;
    }
}