import java.io.*;
import java.util.*;

public class Main {
    static PriorityQueue<Integer> plus  = new PriorityQueue<>(Comparator.reverseOrder()); 
    static PriorityQueue<Integer> minus = new PriorityQueue<>();  

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine().trim());
            if (x <= 0) minus.offer(x);
            else plus.offer(x);
        }

        int answer = 0;

        while (!minus.isEmpty()) {
            int a = minus.poll();
            if (minus.isEmpty()) {        
                answer += a;
            } else {
                int b = minus.poll();    
                answer += a * b;
            }
        }

        while (!plus.isEmpty()) {
            int a = plus.poll();
            if (plus.isEmpty()) {         
                answer += a;
            } else {
                int b = plus.peek();       
                if (a == 1 || b == 1) {    
                    answer += a;
                } else {                 
                    plus.poll();           
                    answer += a * b;
                }
            }
        }

        System.out.println(answer);
    }
}
