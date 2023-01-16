package abc284;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class C {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    final static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static int r, ret;
    static int[] friend;

    public static void main(String[] args) throws Exception {
        int n = readInt();
        int m = readInt();
        friend = new int[n + 1];
        for (int i = 1; i <= n; i++) friend[i] = i;
        while (m-- > 0) {
            int a = readInt();
            int b = readInt();
            join(a, b);
        }
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (friend[i] == i) {
                cnt++;
            }
        }
        out.write(cnt + "\n");
        out.flush();
    }

    static int find(int x) {
        if (friend[x] == x) return x;
        return friend[x] = find(friend[x]);
    }

    static void join(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx != fy) friend[fx] = fy;
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