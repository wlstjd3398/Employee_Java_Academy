package chapter07;

public class Game {

	private Helmet h;
	private Upper u;
	private Lower l;
	private Shoes s;
	private Weapon w;
	
	
	
	public void Game(Helmet h, Upper u, Lower l, Shoes s, Weapon w) {
		this.h = h;
		this.u = u;
		this.l = l;
		this.s = s;
		this.w = w;
	}

	public void gameInfo() {
		System.out.println("<< Helmet >>");
		System.out.println("defense = " + h.defense);
		System.out.println("weight = " + h.weight);
		System.out.println("durable = " + h.durable);
		System.out.println("grade = " + h.grade);
		System.out.println("-------------------------");
		System.out.println("<< Upper >>");
		System.out.println("defense = " + u.defense);
		System.out.println("weight = " + u.weight);
		System.out.println("durable = " + u.durable);
		System.out.println("grade = " + u.grade);
		System.out.println("-------------------------");
		System.out.println("<< Lower >>");
		System.out.println("defense = " + l.defense);
		System.out.println("weight = " + l.weight);
		System.out.println("durable = " + l.durable);
		System.out.println("grade = " + l.grade);
		System.out.println("-------------------------");
		System.out.println("<< Shoes >>");
		System.out.println("defense = " + s.defense);
		System.out.println("weight = " + s.weight);
		System.out.println("durable = " + s.durable);
		System.out.println("grade = " + s.grade);
		System.out.println("-------------------------");
		System.out.println("<< Weapon >>");
		System.out.println("type = " + w.type);
		System.out.println("offense = " + w.offense);
		System.out.println("durable = " + w.durable);
		System.out.println("grade = " + w.grade);
		System.out.println("-------------------------");
		
		
	}
	
	
}
