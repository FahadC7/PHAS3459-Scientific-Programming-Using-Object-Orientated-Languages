package module9;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimationPanel extends JPanel implements ActionListener {

	
	private Color sunColour = Color.YELLOW;
	private int sunRadius = 30;

	private Color earthColour = Color.BLUE;
	private int earthRadius = 5;	
	private static int initialEarthX = 200;
	private static int initialEarthY = 0;	
	private static int earthX = initialEarthX;
	private static int earthY = initialEarthY;

	private Color moonColour = Color.WHITE;
	private int moonRadius = 1;	
	private static int initialMoonX = 10;
	private static int initialMoonY = 0;	
	private static int moonX = initialMoonX;
	private static int moonY = initialMoonY;

	private Color mercuryColour = Color.GRAY;
	private int mercuryRadius = 2;	
	private static int initialMercuryX = 80;
	private static int initialMercuryY = 0;	
	private static int mercuryX = initialMercuryX;
	private static int mercuryY = initialMercuryY;

	private Color venusColour = Color.ORANGE;
	private int venusRadius = 5;	
	private static int initialVenusX = 140;
	private static int initialVenusY = 0;	
	private static int venusX = initialVenusX;
	private static int venusY = initialVenusY;
	
	private Color marsColour = Color.RED;
	private int marsRadius = 3;	
	private static int initialMarsX = 300;
	private static int initialMarsY = 0;	
	private static int marsX = initialMarsX;
	private static int marsY = initialMarsY;
	
	private final int delay = 5; // delay in ms between steps
	private final double delta; // angle to rotate in each step
	private double angle = 0.0; // current angle of planet on screen
	private Timer animationTimer; // timer controlling frame rate

	private static int timeMonth = 0;
	private static int timeYear = 0;

	//constructor for animation panel
	AnimationPanel(int width, int height, double rotationTime) {
		setPreferredSize(new Dimension(width,height));
		delta = 2*Math.PI*delay/(rotationTime*1000);
		animationTimer = new Timer(delay,this);
		animationTimer.start();
	}

	//overides paintComponent method, all the graphic painting to frame is
	//done in this method
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int height = getHeight();
		int width = getWidth();

		// Fill in background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);

		// updates time
		g.setColor(Color.WHITE);
		clock(angle);
		g.drawString("TIME ELAPSED: " +timeMonth+ " months and " +timeYear+ " years", 0, 20);
		g.drawString("---KEY---", 0, 60);
		
		// Now move origin to centre of panel and paint Sun
		g.translate(width/2, height/2);
		g.setColor(sunColour);
		g.fillOval(-sunRadius, -sunRadius, 2*sunRadius, 2*sunRadius);
		g.drawString("Sun", -width/2, -height/2 + 70);

		//paints Earth and uses rotatePlanet to calculate new position after each step
		//the radius of the planet is subtracted from the planet position because 
		//fillOval positions the planet from the top left corner whereas we want the centre
		g.setColor(earthColour);
		g.fillOval(earthX - earthRadius, earthY - earthRadius, 2*earthRadius, 2*earthRadius);
		g.drawString("Earth", -width/2, -height/2 + 80);
		rotatePlanet(angle, "earth");

		//similarly done for moon, but this orbits around Earth and not Sun
		g.setColor(moonColour);
		g.fillOval(earthX + moonX - moonRadius, earthY + moonY - moonRadius, 2*moonRadius, 2*moonRadius);
		g.drawString("Moon", -width/2, -height/2 + 90);
		rotatePlanet(angle, "moon");

		//Mercury
		g.setColor(mercuryColour);
		g.fillOval(mercuryX - mercuryRadius, mercuryY - mercuryRadius, 2*mercuryRadius, 2*mercuryRadius);
		g.drawString("Mercury", -width/2, -height/2 + 100);
		rotatePlanet(angle, "mercury");

		//Venus
		g.setColor(venusColour);
		g.fillOval(venusX - venusRadius, venusY - venusRadius, 2*venusRadius, 2*venusRadius);
		g.drawString("Venus", -width/2, -height/2 + 110);
		rotatePlanet(angle, "venus");
		
		//Mars
		g.setColor(marsColour);
		g.fillOval(marsX - marsRadius, marsY - marsRadius, 2*marsRadius, 2*marsRadius);
		g.drawString("Mars", -width/2, -height/2 + 120);
		rotatePlanet(angle, "mars");
	}

	//method which calculates position of planet for each given angle
	//this method is used for all planets and uses if statements to distinguish
	//different planet rotation speeds are done by multiplying the angle by an approx freq in comparison to Earth
	private static void rotatePlanet(double angle, String planet) {
		if(planet == "mercury") {
			mercuryX = (int) (initialMercuryX*Math.cos(4*angle) + initialMercuryY*Math.sin(4*angle));
			mercuryY = (int) (initialMercuryY*Math.cos(4*angle) - initialMercuryX*Math.sin(4*angle));
		}

		if(planet == "venus") {
			venusX = (int) (initialVenusX*Math.cos(2*angle) + initialVenusY*Math.sin(2*angle));
			venusY = (int) (initialVenusY*Math.cos(2*angle) - initialVenusX*Math.sin(2*angle));
		}

		if(planet == "mars") {
			marsX = (int) (initialMarsX*Math.cos(0.5*angle) + initialMarsY*Math.sin(0.5*angle));
			marsY = (int) (initialMarsY*Math.cos(0.5*angle) - initialMarsX*Math.sin(0.5*angle));
		}

		if(planet == "earth") {
			earthX = (int) (initialEarthX*Math.cos(angle) + initialEarthY*Math.sin(angle));
			earthY = (int) (initialEarthY*Math.cos(angle) - initialEarthX*Math.sin(angle));
		}

		if(planet == "moon") {
			moonX = (int) (initialMoonX*Math.cos(12*angle) + initialMoonY*Math.sin(12*angle));
			moonY = (int) (initialMoonY*Math.cos(12*angle) - initialMoonX*Math.sin(12*angle));
		}
	}
	
	//method which calculates time elapsed in months and years from value of angle
	public static void clock(double angle) {
		if ((Math.PI/6)*(timeMonth + 12*timeYear) <= angle - Math.PI/6) {
			timeMonth = timeMonth + 1;
		}
		if (timeMonth > 11) {
			timeMonth = 0;
			timeYear = timeYear + 1;
		}
	}

	//starts animation
	public void start() {animationTimer.start();}
	
	//stops animation
	public void stop() {animationTimer.stop();}

	//increases angle by delta so new planet position is calculated and painted
	public void actionPerformed(ActionEvent event) {
		angle += delta;
		repaint();
	}

}
