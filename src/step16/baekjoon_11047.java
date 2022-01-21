package step16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ���� 11047�� ����
// �׸��� �˰���: ���ÿ��� ���� ���� ������ ã��
public class baekjoon_11047 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // ������ ����
		int K = Integer.parseInt(st.nextToken()); // ��ġ�� ��
		int[] arr = new int[N]; // ��ġ�� ���������� ���� �迭
		int count = 0; // ���� ����

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine()); // ��ġ ����
		}

		for (int i = N - 1; i >= 0; i--) {
			if (arr[i] <= K) { // �迭�� ���� K���� �۰ų� ���ٸ�
				count += (K / arr[i]); // ��
				K = K % arr[i]; // ������. if���� K�� �������� �Ǵ� ����
			}
		}
		System.out.print(count);
	}
}
