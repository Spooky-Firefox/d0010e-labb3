package labb3.verktyg;


public class Punkt {

	private final int x, y;

	public Punkt(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int x() {
		return x;
	}

	public int y() {
		return y;
	}

	public String toString() {
		return "(" + x() + "," + y() + ")";
	}
}
