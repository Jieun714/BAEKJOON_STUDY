package step5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//���� 1546�� ���
public class avgGrade {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // ����ȯ
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] arr = new int[N]; // N��ŭ �迭 ����

		for (int i = 0; i < N; i++) { // �迭�� ������ ����
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = arr[0]; //�ְ�����
		double sum = 0; //��
		double avg = 0; //���
		double result = 0; //���ο� ���
		
		for (int value : arr) { //�ִ밪 ���ϱ�
			if (value > max) { 
				max = value;
			}
		}
		
		for(int value : arr) {
			avg = (double) value/max*100; //������ ������ ���� ���
			sum += avg; //avg ���� ����
		}
		
		result = (double)sum/N; //���ο� ���

		System.out.println(result); //��� ���
	}
}
