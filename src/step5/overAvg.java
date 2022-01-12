package step5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//���� 4344�� ��� ���ϱ�
//��� ���� �̻��� �л����� ���� ���ϱ�
public class overAvg {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());  //��ū ���
		
		int C = Integer.parseInt(st.nextToken()); // �׽�Ʈ ���̽� ����
		
		for (int i = 0; i < C; i++) { // �׽�Ʈ ���̽� �� ��ŭ �ݺ�
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //�л� �� 
			int[] arr = new int[N]; //�л� ����ŭ �迭
			
			int count = 0;  //��� �Ѵ� �л� ī��Ʈ  //for�� �ۿ� ����� %�� ������
			double avg = 0; //��� ����
			double overAvg = 0; //����� �Ѵ� �л� ����
			
			for (int j = 0; j < N; j++) { //�л� �� ��ŭ �ݓ�
				int score = Integer.parseInt(st.nextToken()); //���� �Է� ����
				arr[j] = score;
				avg += score;
			}
			avg = (avg/N);  //��� ���ϱ�
			 
			for (int k = 0; k < arr.length; k++) { //�迭 �ȿ� �ִ� ��
				if(arr[k] > avg) {  //��� ���� ���ؼ� ��� �Ѵ� �л� �� ����
					count++;
				}
			}
			
			overAvg = (double) count/N*100; //(double) �����ϸ� ����� ����� �ȵ�! �ʼ�
			System.out.printf("%.3f",overAvg);  //�л� �� ��� ��� (�Ҽ� ��°�ڸ�)
			System.out.println("%"); //��� �������� %���� ���
		}
	}
}
