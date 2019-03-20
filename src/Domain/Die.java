package Domain;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "Die")
public class Die {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int ID;

    @Column(name = "value")
	private int faceValue;

    @Column(name = "type")
    private String type;

	public void roll() {
		Random rand = new Random();
		this.faceValue = rand.nextInt(6)+1;
	}

	public int getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(int faceValue) {
		this.faceValue = faceValue;
	}
}