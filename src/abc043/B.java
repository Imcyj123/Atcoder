package abc043;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class B {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringBuilder res = new StringBuilder();
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
            res.append(c);
        }
        System.out.println(res);
        System.out.flush();
    }
}