import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ABC086A {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String[] ab = in.readLine().split(" ");
        int a = Integer.parseInt(ab[0]);
        int b = Integer.parseInt(ab[1]);
        System.out.println(((a & 1) == 0) || ((b & 1) == 0) ? "Even" : "Odd");
    }
}