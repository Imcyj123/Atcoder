package abc284;

import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class F {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    final static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static int r,ret;
    public static void main(String[] args) throws Exception {
        int n = readInt();
        String line = in.readLine();
        char[] charr = line.toCharArray();
        int[] letter = new int[26];
        for (char c : charr) {
            letter[c-'a']++;
        }
        if(!check(charr)){
            System.out.println("-1");
        }else{
            System.out.println(line.substring(0,n/2));
            System.out.println();
        }
    }

    static boolean check(char[] charr){
        for(int i=0;i<26;i++){
            if((charr[i]&1)==0) return false;
        }
        return true;
    }

    static int readInt() throws Exception {
        ret = 0;
        r = in.read();
        while (r > 47 && r < 58) {
            ret *= 10;
            ret += (r & 15);
            r = in.read();
        }
        return ret;
    }
}
