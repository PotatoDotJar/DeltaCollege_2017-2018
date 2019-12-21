
public class PieceWorker extends Worker {
	private int completedWork;

	// No-Arg constructor - initialize to "dummy" value
	public PieceWorker() {
		super(); // Invoke no-arg constructor of superclass
		completedWork = 0;
	}

	// Parameterized constructor - initialize to parameter values
	public PieceWorker(String na, int id, int completedWork) {
		super(na, id); // Pass name/id along to superclass constructor
		this.completedWork = completedWork;
	}

	// Accessory/mutators
	public void setCompletedWork(int completedWork) {
		this.completedWork = completedWork;
	}

	public double getPay() {
		if (completedWork <= 8000) {
			return 0.25 * (double) completedWork;
		} else if (completedWork > 8000 && completedWork <= 10000) {
			return 0.40 * (double) completedWork;
		} else if (completedWork > 10000) {
			return 0.50 * (double) completedWork;
		} else {
			return 0.25 * (double) completedWork;
		}
	}

	@Override
	double calcGrossPay() {
		this.grossPay = getPay();
		return getPay();
	}
}