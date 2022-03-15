package chapter10;

public class Student {

	int kor;
	int eng;
	int mat;
	
	double avg;
	
//	 반환타입 메서드이름 (매개변수) {
//	 소스코드
//	 }
	// 반환타입 모르겠으면 비워도됨
	// 메서드이름도 모르겠으면 비워도됨
	// 매개변수도 모르겠으면 비워도됨
	
	// 평균을 만드는 메서드
	// st1.kor 변수안의 변수
	// st1 안에 들어있는 같은 변수를 사용할수 있기에 this 사용가능
	// return 사용필요 없으니 void 쓰고
	// 매개변수를 사용안하고 변수를 사용하고 있으니 매개변수 비워도됨
	void calcAvg() {
		int total = this.kor + this.eng + this.mat;
		this.avg = (double) total / 3;
	}
	
	// 반복적으로 사용하는 코드는 "객체는 특징을 부여하기" 메서드
	// 객체에 특징을 부여하기를 메서드이름으로 그냥 파파고로 변역해서 넣기
	// Ex2에 give..(인자들)을 넣어서 Student 와서 매개변수를 넣어서 아래 this를 지정해서 해결 할 수 있음
	void giveCharacteristicsToObjects(int kor, int eng, int mat) {
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	
}