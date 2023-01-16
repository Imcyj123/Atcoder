package practice2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    final static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static int r, ret, m, n;
    static int[] pre = new int[2000001];

    public static void main(String[] args) throws Exception {
        for (int i = 0; i <= 2000000; i++) pre[i] = i;
        m = readInt();
        n = readInt();
        for (int i = 0; i < n; i++) {
            int t = readInt();
            int u = readInt();
            int v = readInt();
            if (t == 1) {
                out.write(judge(u, v) + "\n");
            } else {
                join(u, v);
            }
        }
        out.flush();
    }

    static int find(int x) {
        if (pre[x] == x) return x;
        return pre[x] = find(pre[x]);
    }

    static int judge(int x, int y) {
        return find(x) == find(y) ? 1 : 0;
    }

    static void join(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx != fy) {
            pre[fx] = fy;
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