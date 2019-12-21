/**
 * Data storage for state of app
 */
public class State {

	private boolean rBtn[] = { false, false, true };
	private boolean chkBox[];
	private String imageList[];

	private int sliderValue = 0;

	private int listSelectionIndex = 0;

	public State(String[] imageList) {
		this.imageList = imageList;
	}


	// Getters and setters
	public boolean[] getrBtn() {
		return rBtn;
	}

	public void setrBtn(boolean[] rBtn) {
		this.rBtn = rBtn;
	}

	public boolean[] getChkBox() {
		return chkBox;
	}

	public void setChkBox(boolean[] chkBox) {
		this.chkBox = chkBox;
	}

	public int getSliderValue() {
		return sliderValue;
	}

	public void setSliderValue(int sliderValue) {
		this.sliderValue = sliderValue;
	}

	public int getListSelectionIndex() {
		return listSelectionIndex;
	}

	public void setListSelectionIndex(int listSelectionIndex) {
		this.listSelectionIndex = listSelectionIndex;
	}

	public String[] getImageList() {
		return imageList;
	}

	public void setImageList(String[] imageList) {
		this.imageList = imageList;
	}

	@Override
	public String toString() {
		
		String rBtnString = "";
		if(rBtn[0]) {
			rBtnString = "Image is Sharpened";
		} else if (rBtn[1]) {
			rBtnString = "Image is Blurred";
		} else if (rBtn[2]) {
			rBtnString = "Image is not altered";
		} else {
			rBtnString = "Image is not altered";
		}

		String chkBoxString = "";
		if (chkBox[0]) {
			chkBoxString += "Image is fliped vertically\n";
		}
		if (chkBox[1]) {
			chkBoxString += "Image is fliped horizontally\n";
		}
		if (chkBox[2]) {
			chkBoxString += "Image is rotated " + sliderValue + "deg\n";
		}
		if (!chkBox[0] && !chkBox[1] && !chkBox[2]) {
			chkBoxString += "Image not altered\n";
		}
		
		String selectedImage = "Selected image: ";
		if (getListSelectionIndex() > 0) {
			selectedImage += getImageList()[getListSelectionIndex()];
		} else {
			selectedImage += "None";
		}
		
		
		return selectedImage + "\n" + rBtnString + "\n" + chkBoxString;
	}

}
