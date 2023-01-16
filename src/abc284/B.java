package abc284;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    final static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static int r, ret;

    public static void main(String[] args) throws Exception {
        int T = readInt();
        while (T-- > 0) {
            int cnt = 0;
            int n = readInt();
            while (n-- > 0) {
                int val = readInt();
                cnt += (val & 1) != 0 ? 1 : 0;
            }
            out.write(cnt + "\n");

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