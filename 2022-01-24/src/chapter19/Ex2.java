package chapter19;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		byte[] outSrc = null;
		byte[] basket = new byte[10];
		
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		// �迭�� �������¹�(Ex1 4byte�� 10��� �����͸� �о�ü�����)
		// ���� ���� ���ڴٰ� �ƴ� ������� ����
		
		// �迭�� ���ڷ� �ؼ� ��Ƽ� read, write�ϸ� 
		try {
			input.read(basket);	
			output.write(basket);
			
			// output�� ����� ������ byteArrayȭ��Ŵ
			outSrc = output.toByteArray();
			
			System.out.println("Input Source : " + Arrays.toString(inSrc));
			System.out.println("Output Source : " + Arrays.toString(outSrc));
		}catch(IOException e) {
			System.out.println("read ���� ���ܰ� �߻��߽��ϴ�.");
		}
		
		
		//가나다라
		가나다라
		
	}

}
