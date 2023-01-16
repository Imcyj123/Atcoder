package arc153;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A {
        final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        public static void main(String[] args) throws Exception {
                int n = Integer.parseInt(in.readLine());
                n -= 1;
                int[] c = {1,1,0,0,0,0,0,0,0};
                c[7] += (n % 10) ;
                n /= 10;
                c[6] += n % 10 ;
                c[8] += n % 10 ;
                n /= 10;
                c[4] += n % 10 ;
                c[5] += n % 10 ;
                n /= 10;
                c[3] += n % 10 ;
                n /= 10;
                c[2] += n % 10 ;
                n /= 10;
                c[1] += n % 10 ;
                c[0] += n % 10 ;
                for(int e : c) out.write(e+"");
                out.flush();
        }
}