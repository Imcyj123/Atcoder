package arc058;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class C {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    final static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static int r, ret;

    public static void main(String[] args) throws Exception {
        int n = readInt();
        int k = readInt();
        boolean[] bool = new boolean[10];
        for (int i = 0; i < k; i++) {
            bool[readInt()] = true;
        }
        int res = n;
        while (true) {
            int t = res;
            boolean yes = true;
            while (t > 0) {
                if (bool[(t % 10)]) {
                    yes = false;
                    break;
                }
                t /= 10;
            }
            if (yes) {
                out.write(res + "\n");
                out.flush();
                return;
            }
            res++;
        }
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