package step11;

import java.io.*;
import java.util.*;

//���� 2798 ����, m�� ���� �����鼭 m�� ����� ī�� �� ���� ��
//https://velog.io/@im_lily/%EB%B0%B1%EC%A4%80-2798-%EB%B8%94%EB%9E%99%EC%9E%AD �ڵ� ����
public class blackJack {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // ī���� ����
		int m = Integer.parseInt(st.nextToken()); // ������ ����

		int[] arr = new int[n];
		int max = 0; //������ ���� ���� ����� ��
		
		st = new StringTokenizer(br.readLine()); // �ʱ�ȭ �������
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < arr.length - 2; i++) {
			for (int j = i+1; j < arr.length - 1; j++) {
				for (int k = j+1; k < arr.length; k++) {
					int sum = 0; // �� ���� ī�带 ���� ��
					sum += arr[i] + arr[j] + arr[k];
					
					if(sum<=m) {
						max = Math.max(max, sum); // �ִ� ���Ͽ� ����
					}
				}
			}
		}
		System.out.println(max);
	}

}
