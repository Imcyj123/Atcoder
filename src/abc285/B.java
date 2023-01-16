package abc285;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    final static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(in.readLine());
        char[] arr = in.readLine().toCharArray();
        for (int i = 1; i < n; i++) {
            int cnt = 0;
            for (int idx = 0; idx < arr.length - i; idx++) {
                if (arr[idx] != arr[idx + i]) cnt++;
                else break;
            }
            out.write(cnt + "\n");
        }
        out.flush();
    }
}