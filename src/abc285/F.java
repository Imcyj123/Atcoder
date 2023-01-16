package abc285;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class F {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    final static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[] sp, rs, split;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(in.readLine());
        String s = in.readLine();
        rs = s.split("");
        sp = s.split("");
        int q = Integer.parseInt(in.readLine());
        List<String> list = Arrays.asList(sp);
        Collections.sort(list);
        while (q-- > 0) {
            split = in.readLine().split(" ");
            if (split[0].equals("1")) {
                int idx = Integer.parseInt(split[1]) - 1;
                rs[idx] = split[2];
                sp = rs;
                list = Arrays.asList(sp);
                Collections.sort(list);
            } else {
                out.write(check(list) ? "Yes\n" : "No\n");
            }
        }
        out.flush();
    }

    static boolean check(List<String> list) {
        int start = Integer.parseInt(split[1]) - 1;
        int end = Integer.parseInt(split[2]);
        List<String> checklist = Arrays.asList(rs);
        return checklist.subList(start, end).equals(list.subList(start, end));
    }
}