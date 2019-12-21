import javax.swing.JFileChooser;

public class Test {

	public static void main(String[] args) {
		
		JFileChooser fileChooser = new JFileChooser("/");
		fileChooser.showOpenDialog(null);
		System.out.println(fileChooser.getSelectedFile());

	}

}
