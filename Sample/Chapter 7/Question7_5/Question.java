package Question7_5;

public class Question {

	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}
	
	public static void printSquare(Square s) {
		System.out.println(s.left + "\t" + s.top);
		System.out.println(s.right + "\t" + s.top);
		System.out.println(s.right + "\t" + s.bottom);
		System.out.println(s.left + "\t" + s.bottom);
		System.out.println(s.left + "\t" + s.top);
	}
	
	public static void printLine(Line l) {
		System.out.println(l.start.x + "\t" + l.start.y);
		System.out.println(l.end.x + "\t" + l.end.y);
	}
	
	public static void main(String[] args) {
		/* For an easy way to test these, open up Square Cut Tester.xlsx
		 * in the Chapter 10, Problem 5 folder. Copy and paste the exact 
		 * output from below into the file (including all tabs).
		 */
		Square s1 = new Square(randomInt(5), randomInt(5), randomInt(4) + 1);
		Square s2 = new Square(randomInt(5), randomInt(5), randomInt(4) + 1);
		Line line = s1.cut(s2);
		printSquare(s1);
		printSquare(s2);
		printLine(line);
	}

}
