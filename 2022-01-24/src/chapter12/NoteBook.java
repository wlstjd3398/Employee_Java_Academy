package chapter12;

public class NoteBook extends Pc{
//부모(Pc)에서 자식(NoteBook)이 확장된것
	// 단순히 클래스간 소스코드가 중복 되었다고 해서 상속을 하면 안됨
	// 한클래스의 특징을 다른 클래스도 동일하게 가지고 있으면서
	// 두클래스 중 한클래스가 더 확장된 개념일때에만 상속을 적용해야함

// 부모가 없는 모든 클래스는 Object 클래스의 자식이 됨
	// 자식 클래스는 부모가 물려받은 코드도 물려 받게 됨
	
	private double Battery;
	
	public void charging() {
		System.out.println("충전을 한다");
	}
	
//	public void showPcInfo( ) {
//		System.out.println("===========[Pc Info]===========");
//		System.out.println("CPU = " + getCPU()); // 상속받은 멤버변수 컴파일 오류 why? -> 자기가 갖고 있는 영역에서만 찾음(상속 받은거라 없다고 판단)
//		System.out.println("GPU = " + getGPU()); // -> getter로 상속받은 영역의 멤버변수 사용해서 해결(전체영역에서 찾기시작)
//		System.out.println("RAM = " + getRAM()); // super.getCPU()라는 연산자를 써서 전체영역에서 바로 찾음 ->잘 안붙이긴함
//		System.out.println("HDD = " + getHDD());
//		System.out.println("Battery = " + Battery); // 자기가 갖고있는 멤버변수는 정상
//		System.out.println("===============================");
//	}
	
	// 오버라이딩 단축키 : alt + shift + s + v
	
	public void showNoteBookInfo() {
		System.out.println("===========[NoteBook Info]===========");
		System.out.println("CPU = " + getCPU());
		System.out.println("GPU = " + getGPU());
		System.out.println("RAM = " + getRAM());
		System.out.println("HDD = " + getHDD());
		System.out.println("Battery = " + Battery);
		System.out.println("===============================");
	}

	
	
	// 위는 만든것, 아래는 오버라이딩 실행해서 만들어서 소스코드 복붙한것
	// @Override라는 것은 있어도 없어도 되는데 애노테이션이라 부름, 컴퓨터가 보는 주석으로 인식하면됨 -> JSP, Spring 등에서 쓰임
	
	@Override
	public void showPcInfo() {
		System.out.println("===========[NoteBook Info]===========");
		System.out.println("CPU = " + getCPU());
		System.out.println("GPU = " + getGPU());
		System.out.println("RAM = " + getRAM());
		System.out.println("HDD = " + getHDD());
		System.out.println("Battery = " + Battery);
		System.out.println("===============================");
	}
	
}
