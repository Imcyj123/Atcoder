package arc059;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class C {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    final static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static int r, ret;
    static boolean negative = false;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = readInt();
        }
        in.close();
        int res = Integer.MAX_VALUE;
        for (int i = -100; i <= 100; i++) {
            int min = 0;
            for (int j = 0; j < n; j++) {
                int val = arr[j] - i;
                min += val * val;
            }
            res = Math.min(res, min);
        }
        out.write(res + "");
        out.flush();
        out.close();
    }

    static int readInt() throws Exception {
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
            negative = false;
            ret *= -1;
        }
        return ret;
    }
}