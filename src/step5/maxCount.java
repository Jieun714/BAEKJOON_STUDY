package step5;

import java.io.*;
import java.util.*;

//���� 2562�� �ִ񰪰� �ִ� �ڸ��� ���ϱ�
public class maxCount {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[9]; // 9���� �ڿ���
		
		int max = 0; // �ִ밪
		int count = 0; 
		int index = 0; //�ڸ���

		for (int i = 0; i < arr.length; i++) { // �迭�� ���̸�ŭ �Է��ϵ���
			arr[i] = Integer.parseInt(br.readLine());  
		}

		for (int i = 0; i < arr.length; i++) { // N�� �ݺ�
			count++;  //ī��Ʈ
			if (max < arr[i]) { // max ���ϱ�
				max = arr[i];
				index = count; //index�� count ����. �ڸ���
			}
		}
		System.out.println(max);
		System.out.println(index);
	}
}