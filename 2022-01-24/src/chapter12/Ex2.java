package chapter12;

public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pc p1 = new Pc();
		p1.powerOnOff();
		p1.typing();
		p1.playGame();
		p1.showPcInfo();
		
		NoteBook n1 = new NoteBook();
		n1.powerOnOff();
		n1.typing();
		n1.playGame();
		n1.charging();
//		n1.showNoteBookInfo();
		
		// 헷갈리게 개발 -> 해결방법 : 오버라이딩
		
		n1.showPcInfo();
		
		
		
	}

}
