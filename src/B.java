import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    final static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static int r, ret;

    public static void main(String[] args) throws Exception {
        int n = readInt();
        int q = readInt();
        boolean[] player = new boolean[n + 1];
        int[] cnt = new int[n + 1];
        while (q-- > 0) {
            int a = readInt();
            int b = readInt();
            if (a == 3) out.write(player[b] || cnt[b] >= 2 ? "Yes\n" : "No\n");
            else if (a == 2) player[b] = true;
            else cnt[b]++;
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