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
		
		// 배열로 가져오는법(Ex1 4byte의 10배로 데이터를 읽어올수있음)
		// 누가 좋다 나쁘다가 아니 장단점이 있음
		
		// 배열을 인자로 해서 담아서 read, write하면 
		try {
			input.read(basket);	
			output.write(basket);
			
			// output과 연결된 공간을 byteArray화시킴
			outSrc = output.toByteArray();
			
			System.out.println("Input Source : " + Arrays.toString(inSrc));
			System.out.println("Output Source : " + Arrays.toString(outSrc));
		}catch(IOException e) {
			System.out.println("read 도중 예외가 발생했습니다.");
		}
		
		
	}

}