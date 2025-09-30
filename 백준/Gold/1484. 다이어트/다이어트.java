import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long G = Long.parseLong(br.readLine().trim());

        StringBuilder sb = new StringBuilder();
        int l = 1;
        int r = 2;
        boolean found = false;

  
        while (r <= 100000) {
            long diff = (long) r * r - (long) l * l;

            if (diff == G) {
                sb.append(r).append('\n');
                found = true;
                l++;
            } else if (diff > G) {
                l++;   
            } else {
                r++;      
            }

            if (l == r) r++;  
        }

        if (!found) System.out.println(-1);
        else System.out.print(sb.toString());
    }
}
