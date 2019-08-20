package module9;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

//simulation of solar system with sun, mercury, venus, earth, moon and mars with
//elliptical orbits
public class SolarSystem {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Solar System"); //creates frame
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes when window closed
				frame.setSize(1300,700); //size of window
				JPanel panel = new AnimationGuiPanel(); //creates animation gui panel
				frame.add(panel); //adds panel to frame
				frame.setVisible(true); //makes visible
			}
		});
	}
}
