import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ABC081B {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static int r, ret;

    public static void main(String[] args) throws Exception {
        int n = readInt();
        int[] arr = new int[n];
        int cnt = -1;
        for (int i = 0; i < n; i++) arr[i] = readInt();
        boolean bool = true;
        while (bool) {
            for (int i = 0; i < n; i++) {
                if ((arr[i] & 1) != 0) {
                    bool = false;
                    break;
                } else {
                    arr[i] /= 2;
                }
            }
            cnt++;
        }
        System.out.println(cnt);
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