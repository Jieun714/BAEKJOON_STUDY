package step5;

import java.io.*;
import java.util.*;

//���� 10818�� �ִ�, �ּ� ���ϱ�  //�迭���
public class minMax {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] arr = new int[N]; // N��ŭ �迭 ����

		for (int i = 0; i < N; i++) { // �迭�� ������ ����
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// �迭�� �����Ͱ� ���Ե� �� min�� max ����
		int min = arr[0]; // �ּ�
		int max = arr[0]; // �ִ�

		for (int i = 1; i < N; i++) { // N�� �ݺ�
			if (min > arr[i]) { // min ���ϱ�
				min = arr[i];
			}
			if (max < arr[i]) { // max ���ϱ�
				max = arr[i];
			}
		}
		System.out.println(min + " " + max);
	}
}
