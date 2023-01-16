package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class B {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    final static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        String[] ab = in.readLine().split(" ");
        int N = Integer.parseInt(ab[0]);
        int Q = Integer.parseInt(ab[1]);
        String s = "";
        for(int i=0;i<N;i++) s += (char)('A'+i);
        char[] c = s.toCharArray();
        for(int i=0;i<N;i++)
            for(int j=0;j<N-1;j++){
                out.write("? "+c[j]+" "+c[j+1]);
                char res = (char) in.read();
                if(res == '>') {
                    char tmp = c[j];
                    c[j] = c[j+1];
                    c[j+1] = tmp;
                }
            }
        out.write("! "+c.toString()+"\n");
        out.flush();
    }
}
