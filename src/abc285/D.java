package abc285;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class D {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    final static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(in.readLine());
        String[] before = new String[N];
        String[] after = new String[N];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] names = in.readLine().split(" ");
            before[i] = names[0];
            after[i] = names[1];
            map.put(before[i], i);
        }
        in.close();
        int[] nx = new int[N];
        int[] iri = new int[N + 1];
        for (int i = 0; i < N; i++) {
            nx[i] = map.getOrDefault(after[i], N);
            iri[nx[i]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (iri[i] == 0) {
                queue.add(i);
            }
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            cnt++;
            int i = queue.poll();
            if (nx[i] != N) {
                iri[nx[i]]--;
                if (iri[nx[i]] == 0) {
                    queue.add(nx[i]);
                }
            }
        }
        if (cnt == N) System.out.println("Yes");
        else System.out.println("No");
    }
}