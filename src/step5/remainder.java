package step5;

import java.io.*;
import java.util.*;

//���� 3052�� ������ ���ϱ�
//10���� �Էµ� ���� �������� ���� ���ϱ�
public class remainder {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[10]; // 10���� �Է� ����

		int num = 0;
		int count = 0; // �ڸ���

		for (int i = 0; i < arr.length; i++) { // �迭�� ���̸�ŭ �Է��ϵ���
			arr[i] = Integer.parseInt(br.readLine())%42; //�迭���� �������� ����
		}

		//�迭 ���� ���� ���ؾ��ϱ� ������ ���� for�� ���
		for (int i = 0; i < arr.length; i++) {
			num = 0;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) { //�������� �����ϸ�
					num++; //
				}	
			}
			if (num == 0) { //num�� 0�̸� ���� �ٸ� ����
				count++; // ���� �ø�
			}
		}
		System.out.println(count); // ����� ���
	}
}
