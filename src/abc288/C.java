package abc288;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class C {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    final static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static int r, ret;
    static int[] fa;

    public static void main(String[] args) throws Exception {
        int n = readInt();
        int m = readInt();
        fa = new int[n + 1];
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            fa[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int a = readInt(), b = readInt();
            int x = find(a), y = find(b);
            if (x == y) cnt++;
            else fa[y] = x;
        }
        System.out.println(cnt);
        System.out.flush();
    }

    static int find(int x) {
        if (x != fa[x]) fa[x] = find(fa[x]);
        return fa[x];
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