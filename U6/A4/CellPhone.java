public class CellPhone {

	// private variables to this class
	private String carrier, type;
	private double speed, memory;
	private int numApps;

	// constructor for creating a phone object
	public CellPhone(final String carrier, final String type, final double speed,
			final double memory, final int num) {
		this.carrier = carrier;
		this.type = type;
		this.memory = memory;
		this.speed = speed;
		this.numApps = num;
	}

	// Setters
	public void setCarrier(final String carrier) {
		this.carrier = carrier;
	}

	public void setType(final String type) {
		this.type = type;
	}

	public void setMemory(final double memory) {
		this.memory = memory;
	}

	public void setSpeed(final double speed) {
		this.speed = speed;
	}

	public void setApps(final int num) {
		this.numApps = num;
	}

	// getters
	public String getCarrier() {
		return carrier;
	}

	public String getType() {
		return type;
	}

	public double getMemory() {
		return memory;
	}

	public double getSpeed() {
		return speed;
	}

	public int getApps() {
		return numApps;
	}
}
