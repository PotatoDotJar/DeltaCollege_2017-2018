
public class PieceWorker extends Employee {


	private int piecesProduced;
	private double wageAmountPerPiece;

	public PieceWorker(String first, String last, int piecesProduced, double wageAmountPerPiece) {
		super(first, last);
		this.piecesProduced = piecesProduced;
		this.wageAmountPerPiece = wageAmountPerPiece;
	}

	// Get the HourlyWorker's pay
	public double earnings() 
	{ 
		return piecesProduced * wageAmountPerPiece;
	}

	// Object status returned as String object
	public String toString() 
	{
		return "Pieces worker: " + super.toString();
	}

	public int getPiecesProduced() {
		return piecesProduced;
	}

	public void setPiecesProduced(int piecesProduced) {
		this.piecesProduced = piecesProduced > 0 ? piecesProduced : 0;
	}

	public double getWageAmountPerPiece() {
		return wageAmountPerPiece;
	}

	public void setWageAmountPerPiece(double wageAmountPerPiece) {
		this.wageAmountPerPiece = wageAmountPerPiece > 0 ? wageAmountPerPiece : 0.0;
	}




}
