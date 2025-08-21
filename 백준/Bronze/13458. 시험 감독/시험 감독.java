import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	A[i] =  Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        long cnt=0;
        for (int i=0;i<N;i++) {
        	
        	A[i]-= B;
        	cnt++;
            if (A[i]<0) continue;
        	if(A[i]%C>0){
                cnt+= A[i]/C +1;
            } else {
                cnt += A[i]/C;
            }
        	
        }
        
        System.out.println(cnt);
    }
}
