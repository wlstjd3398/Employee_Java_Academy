package chapter19;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 바이트 기반 입출력 스트림
		// 먼저 바이트타입 배열 생성
//		파일포인터가 { 앞에 존재
		byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		byte[] outSrc = null;
		
		// 바이트배열과 연결된 inputstream
		// Ex1.java 안으로 가져올수있다 inSrc와 연결해서 안으로 가져온다
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		
		// 바이트배열과 연결된 outputstream
		// Ex1.java 밖으로 내보낸다 outSrc와 연결해서 밖으로 내보낸다
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		// ();은 메모리의 임의의공간과 연결됨
		
//		// 1번째 데이터를 가져옴
//		int data = input.read();
//		System.out.println("data = " + data);
//		// 2번째 데이터를 가져옴
//		data = input.read();
//		System.out.println("data = " + data);
// 10번째까지 이렇게하면 번거로움 
//		// for문으로 10번째까지 가져오는법
//		for(int i=1; i<=10; i++) {
//			int data = input.read();
//			System.out.println("data = " + data);
//		}
//		// 7번째까지 데이터가 있을 경우 그 뒤의 데이터는 -1를 가져옴
//		// Returns:the next byte of data, or
//		// -1 if the end of the stream has been reached
		
		
		// while문으로 가져오는법(4byte로 데이터를 읽어올수있음)
		// 누가 좋다 나쁘다가 아니 장단점이 있음
		while(true) {
			int data = input.read();
//			파일 포인터가 한자리 뒤로가서 0을 가져와 스트림을 통해 가져옴
			if(data == -1) {
				break; // 끝에 도달하면 빠져나가라
			}
			
//			System.out.println("data = " + data);
			output.write(data); // 입력한 데이터를 출력
		}
		
		outSrc = output.toByteArray();
		// output과 연결된 공간을 ByteArray화 시킨것
//		Arrays.toString(null);
		// 배열을 문자열화시킨것
		
		System.out.println("Input Source : " + Arrays.toString(inSrc));
		System.out.println("Output Source : " + Arrays.toString(outSrc));
		
		// input output을 우리가 만들어 사용한것으로 닫아줘야함 (스트림은 사용하고 닫아야함)
		// 스트림은 사용하고있는중이라 컴퓨터가 생각함
		// -> IOException 안해줘서 컴파일오류
		
		// 따로따로 닫아줘야함
		try {
			input.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
		try {
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
	}

}
