package step5;

import java.io.*;
import java.util.*;

//���� 2577�� ������ ���� ���ϱ�
//�� ���� ���� �޾Ƽ� ���� ���� ���� ������ ������ ����
//��α� https://st-lab.tistory.com/45 �Ϻ� �����ؼ� �ۼ�
public class numCount {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[3]; // 3���� �ڿ���
		int[] num = new int[10];  //0���� 9���� ������ �迭

		int count = 0;
		int index = 0; // �ڸ���

		for (int i = 0; i < arr.length; i++) { // �迭�� ���̸�ŭ �Է��ϵ���
			arr[i] = Integer.parseInt(br.readLine());
		}

		int a = arr[0]; 
		int b = arr[1];
		int c = arr[2];

		String sum = String.valueOf(a * b * c); //���� ���� String �������� ��ȯ

		for (int i = 0; i < sum.length(); i++) {
			num[(sum.charAt(i) - 48)]++; //0~9�� �ش��ϴ� ������ ������ ī����
		}

		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i]); //����� ���
		}
	}
}