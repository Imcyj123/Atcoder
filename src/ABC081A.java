import java.io.BufferedReader;
import java.io.InputStreamReader;
public class ABC081A {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        char[] input = in.readLine().toCharArray();
        int cnt = 0;
        for (char c : input) {
            if (c == '1') cnt++;
        }
        System.out.println(cnt);
    }
}