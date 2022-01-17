package step11;

import java.io.*;
import java.util.*;

//���� 2231�� ������
//n = m + 100�� �ڸ� + 10�� �ڸ� + 1�� �ڸ�
//���Ʈ ����: ���� ������ ��� ���ڿ��� �ϳ��� ������ ���� ������� ������ �ص��ϴ� ���
public class baekjoon_2231 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // �ڿ��� n �Է� ����

		int result = 0;

		for (int i = 0; i < n; i++) {
			int m = i;
			int sum = 0; // �� �ڸ��� ��

			while (m>0) { // m�� ���� 0�� �ƴ� ��
				sum += m % 10;   // �� �ڸ����� ����
				m /= 10;
			}

			if ((sum +i) == n) { // ������ �϶�
				result = i;
				break;
			}

		}
		System.out.println(result);
	}
}
