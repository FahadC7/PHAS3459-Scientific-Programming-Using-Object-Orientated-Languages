package module9;

import java.awt.event.*;
import javax.swing.*;

public class AnimationGuiPanel extends JPanel
implements ActionListener {
	private AnimationPanel animPanel; // panel containing animation

	//start and stop buttons
	private JButton startButton;
	private JButton stopButton;
	
	// Create JPanel containing animation panel and buttons
	public AnimationGuiPanel() {
		super();
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		animPanel = new AnimationPanel(200,200,20.0);

		//start and stop JButtons which start and stop animation when pressed
		startButton = new JButton("Start");
		stopButton = new JButton("Stop");
		
		//adds action listeners so code listens for if the buttons are pressed
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		
		//creates button panel and adds start and stop buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(
				buttonPanel,BoxLayout.X_AXIS));
		buttonPanel.add(startButton);
		buttonPanel.add(stopButton);
		
		//adds animation and button panel to frame
		add(animPanel);
		add(buttonPanel);
	}
	
	//reponds to button presses
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==startButton) start();
		else if (e.getSource()==stopButton) stop();
		}

	// Start animation when frame is started 
	public void start() {animPanel.start();}
	
	// Stop animation when frame is stopped 
	public void stop() {animPanel.stop();}
}