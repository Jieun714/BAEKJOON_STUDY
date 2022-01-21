package step16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//���� 11399�� ATM
//�׸��� �˰���. �ð��� ���� �ּڰ� ���ϱ�
public class baekjoon_11399 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());  //����� ��
		int[] pArr = new int[N]; //�ð� �迭. �迭�� ���̴� ��� ����ŭ
		int minTime = 0;  //�ּҽð�
		int sum = 0;  //������
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			pArr[i] = Integer.parseInt(st.nextToken());  //�ð��迭�� �� ���
		}
		
		Arrays.sort(pArr);  //�ð� �迭 ����
		for(int j=0; j<N; j++) { 
			minTime += pArr[j];  //�ּҽð��� �迭�� ���� ����
			sum += minTime;  //������
		}
		
		System.out.print(sum);
	}
}
