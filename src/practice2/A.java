//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//
//public class A {
//    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//    final static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
//    static int r, ret, n, q;
//    static int[] pre, size;
//
//    public static void main(String[] args) throws Exception {
//        n = readInt();
//        q = readInt();
//        pre = new int[n];
//        size = new int[n];
//        for (int i = 0; i < n; i++) {
//            pre[i] = i;
//            size[i] = 1;
//        }
//        while (q-- > 0) {
//            int t = readInt();
//            int a = readInt();
//            int b = readInt();
//            int fa = find(a);
//            int fb = find(b);
//            if (t == 1) {
//                out.write(((fa == fb) ? 1 : 0) + "\n");
//                continue;
//            }
//            if (fa == fb) continue;
//            if (size[fa] < size[fb]) {
//                pre[fa] = pre[fb];
//                size[fb] += size[fa];
//            } else {
//                pre[fb] = pre[fa];
//                size[fa] += size[fb];
//            }
//        }
//        out.close();
//    }
//
//    static int find(int x) {
//        if (pre[x] == x) return x;
//        return pre[x] = find(pre[x]);
//    }
//
//    static int readInt() throws Exception {
//        ret = 0;
//        r = in.read();
//        while (r > 47 && r < 58) {
//            ret *= 10;
//            ret += (r & 15);
//            r = in.read();
//        }
//        return ret;
//    }
//}