import java.awt.Color;
import java.awt.Graphics;



public class Circle{

	private int x, y;
	private Color color;

	public Circle(int a, int b, Color s){ //color = color of outline, all circles filled black
		x=a;
		y=b;
		color=s;
	}
	public void display(Graphics g){
		g.setColor(Color.BLACK.darker());
		g.fillOval(x, y, 50,50);
		g.setColor(color);
		g.drawOval(x, y, 50,50);
		g.setColor(color.brighter());
		g.drawOval(x, y, 50,50);
	}
	public void setX(int z){
		x=z;
	}
	public void setY(int z){
		y=z;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}







}



