package A2021_m78_question2;

import java.io.Serializable;

public class Rect implements Serializable{
	private double x,y,width,height;

	public Rect(double x,double y, double width,double height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
}
