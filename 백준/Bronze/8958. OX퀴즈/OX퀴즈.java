import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int i=0;i<N;i++) {
			String text = br.readLine();
			int sum =0;
			int mark=0;
			for(int j=0;j<text.length();j++) {
				if(text.charAt(j)=='O') {
					sum+= ++mark;
				}
				else {
					mark=0;
				}
			}
			System.out.println(sum);
		}

	}

}
