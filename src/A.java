import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    final static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        for (char c : in.readLine().toCharArray()) {
            if (c >= 'a' && c <= 'z') out.write(c - 32);
            else out.write(c);
        }
        out.flush();
    }
}
