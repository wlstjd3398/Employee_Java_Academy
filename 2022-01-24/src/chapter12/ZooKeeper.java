package chapter12;

public class ZooKeeper {

//	public void feed(Lion lion) {
//		System.out.println(lion.getName() + " 에게 먹이 주기");
//	}
//	
//	public void feed(Rabbit rabbit) {
//		System.out.println(rabbit.getName() + " 에게 먹이 주기");
//	}
	
	// 오버로딩의 한계 : 하나의 동물에게 지정해줘야함
	// -> 다형성 적용하여 클래스 공통분모를 뽑아서 상속 활용해야함(다형성은 상속에서만 사용가능해서)
	// -> Rabbit Lion이 클래스의 공통부분 많음 -> 자식 부모를 설정해야함
	// extends Animal 설정
	
	public void feed(Animal animal) {
		System.out.println(animal.getName() + " 에게 먹이 주기");
	}
}