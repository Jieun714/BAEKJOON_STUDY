package step8;

import java.io.*;
import java.util.StringTokenizer;

//백준 1712번 손익분기점
public class bep {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());  //고정비용
		int b = Integer.parseInt(st.nextToken());  //가변비용
		int c = Integer.parseInt(st.nextToken());  //판매비용
		
		if(b>=c) {
			System.out.println("-1");
		}else {
			System.out.println(a/(c-b)+1);
		}
	}
}
