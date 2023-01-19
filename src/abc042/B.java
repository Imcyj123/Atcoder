package abc042;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class B {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    final static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        String[] nl = in.readLine().split(" ");
        int n = Integer.parseInt(nl[0]);
        int l = Integer.parseInt(nl[1]);
        PriorityQueue<String> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(in.readLine());
        }
        while (!pq.isEmpty()) {
            out.write(pq.poll());
        }
        out.write("\n");
        out.flush();
    }
}