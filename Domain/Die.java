import java.util.Random;

public class Die {

	private int faceValue;

	public void roll() {
		Random rand = new Random();
		this.faceValue = rand.nextInt(5)+1;
		throw new UnsupportedOperationException();
	}

	public int getFaceValue() {
		return this.faceValue;
	}

	public static void main(String[] args) {
		Die d = new Die();
		d.roll();
		System.out.println(d.getFaceValue());
	}

}