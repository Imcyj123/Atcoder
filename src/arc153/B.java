package arc153;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    final static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static int r, ret;

    public static void main(String[] args) throws Exception {
        int h = readInt();
        int w = readInt();
        char[][] s = new char[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                s[i][j] = (char) in.read();
            }
            in.read();
        }
        int q = Integer.parseInt(in.readLine());
        int x1 = 1, y1 = 1;
        int x2 = 0, y2 = 0;
        while (q-- > 0) {
            int a = readInt() - 1;
            int b = readInt() - 1;
            x1 *= -1;
            y1 *= -1;
            x2 = (h + a - x2) % h;
            y2 = (w + b - y2) % w;
            if (x2 < 0) x2 += h;
            if (y2 < 0) y2 += w;
        }

        char[][] t = new char[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int x = (i * x1 + x2 + h) % h;
                int y = (j * y1 + y2 + w) % w;
                t[x][y] = s[i][j];
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                out.write(t[i][j] + "");
            }
            out.write("\n");
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