import java.util.Random;

public class Die {

	private int faceValue;

	public void roll() {
		Random rand = new Random();
		this.faceValue = rand.nextInt(6)+1;
	}

	public int getFaceValue() {
		return this.faceValue;
	}

	public void getFaceValue() {
		// TODO - implement Die.getFaceValue
		throw new UnsupportedOperationException();
	}

}