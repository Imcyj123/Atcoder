package abc043;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B {
    static BufferedReader in;
    static BufferedWriter out;

    public static void main(String[] args) throws Exception {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] input = in.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : input) {
            if (c == 'B') {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(c);
            }
        }
        for (char c : stack) {
            out.write(c + "");
        }
        out.flush();
    }
}