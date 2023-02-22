package abc290;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    final static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        String[] line = in.readLine().split(" ");
        String input = in.readLine();
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);
        int cnt = 0;
        for (char c : input.toCharArray()) {
            if (cnt == K) out.write("x");
            else {
                if (c == 'o') cnt++;
                out.write(c + "");
            }
        }
        out.flush();
    }
}