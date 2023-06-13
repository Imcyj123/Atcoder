import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(in.readLine());
        long res = 0;
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j * i <= N; j++) {
                arr[i * j]++;
            }
        }
        for (int i = 1; i <= N; i++) {
            res += (long) arr[i] * arr[N - i];
        }
        System.out.println(res);
    }
}