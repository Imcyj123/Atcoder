package practice2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class B {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    final static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static int r, ret;

    static class BIT {
        int N;
        long[] bit;

        BIT(int n) {
            bit = new long[n];
            N = 1;
            while ((N << 1) < n) N <<= 1;
        }

        void upd(int x, int val) { //update
            while (x < bit.length) {
                bit[x] += val;
                x += x & -x;
            }
        }

        long query(int x) {
            long sum = 0;
            while (x > 0) {
                sum += bit[x];
                x -= x & -x;
            }
            return sum;
        }

        long query(int x, int y) {
            return query(y) - query(x - 1);
        }
    }

    public static void main(String[] args) throws Exception {
        int N = readInt();
        BIT bit = new BIT(N + 1);
        int Q = readInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = readInt();
            bit.upd(i + 1, arr[i]);
        }
        while (Q-- > 0) {
            int first = readInt();
            if (first == 0) {
                bit.upd(readInt() + 1, readInt());
            } else {
                out.write(bit.query(readInt() + 1, readInt()) + "\n");
            }
        }
        out.flush();
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