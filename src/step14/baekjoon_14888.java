package step14;

import java.io.*;
import java.util.*;

//���� 14888�� ������ �����ֱ�
public class jaekjoon_14888 {

	//��ͺκп��� �ִ񰪰� �ּڰ��� ���Ž�Ű�� ������, MAX�� ���� MIN_VALUE�� ����
	public static int MAX = Integer.MIN_VALUE;  //�ִ�
	public static int MIN = Integer.MAX_VALUE;  //�ּڰ�
	public static int[] operator = new int[4];	//������ ����  // + - * %
	public static int[] arr; //���� �迭
	public static int n; //������ ����
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine()); //���� ����
		arr = new int[n]; //����ŭ �迭 ����
		
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());  //�ش��ϴ� �迭�� ���̸�ŭ ���� ����
		}
		
		// + - * %
		st = new StringTokenizer(br.readLine());  //for�� �ۿ� �����ؾߵ�. 
		for(int j=0; j<4; j++) { //�ش��ϴ� �������� ������ ����. �ּҴ� 0����
			operator[j] = Integer.parseInt(st.nextToken());   //�ش��ϴ� �迭�� ���̸�ŭ ���� ����
		}
		
		dfs(arr[0], 1);
		 
		System.out.println(MAX); //�ִ� ����
		System.out.println(MIN); //�ּڰ� 
	}
	
	public static void dfs(int num, int idx) {
		if(idx == n) { //�ε��� ���� n(���� ��)�� ������ ��
			MAX = Math.max(MAX, num);
			MIN = Math.min(MIN, num);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(operator[i] > 0) {  //�������� ������ 1�̻��� ���
				operator[i]--; //�ش� �����ڸ� 1���ҽ�Ų��
				
//				if�� ����ϰų� switch�� ��� ����.
//				if(i == 0) dfs(num + arr[idx], idx+1); 
//				else if(i == 1) dfs(num - arr[idx], idx+1);
//				else if(i == 2) dfs(num * arr[idx], idx+1);
//				else if(i == 3) dfs(num / arr[idx], idx+1);
//				
				switch(i) {
				case 0: dfs(num + arr[idx], idx+1); break; 
				case 1: dfs(num - arr[idx], idx+1); break;
				case 2: dfs(num * arr[idx], idx+1); break;
				case 3: dfs(num / arr[idx], idx+1); break;
				}	
				operator[i]++;  //���ȣ���� ����Ǹ� �ٽ� �ش� ������ ������ ������
			}
		}
	}
}
