package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// StringBuilder�δ� �� �߸��� ���� ��µǴ� �� �𸣰���
//���� 4375�� 1
//2�� 5�� ������ �������� �ʴ� ����
public class baekjoon_4375 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();

		while (true) {
			String s = br.readLine();
			if (s == null) {
				break; // null�̸� ���ߵ���
			}
			int n = Integer.parseInt(s);
			int result = 0;

			for (int i = 1; i <= n; i++) {
				result = result * 10 + 1; // �ڸ����� ��
				result %= n;  
				if (result == 0) { // �������� 0�� ��
//					sb.append(i).append('\n'); 
					System.out.println(i);
					break;
				}	
			}
//			System.out.print(sb);
		}
	}
}
