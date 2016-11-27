import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.Timer;



public class Tag extends JFrame implements KeyListener, ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  Circle p1 = new Circle (810, 810, Color.MAGENTA);
	  Circle p2 = new Circle (50,90, Color.GREEN);
	  boolean p1it=true;  //player 1 starts off being "it"
	  boolean p2it=false;
	  Timer right = new Timer(30, this);//movement timers for purple circle
	  Timer left = new Timer(30, this);
	  Timer down = new Timer(30, this);
	  Timer up = new Timer(30, this);
	  Timer right2 = new Timer(30, this);//movement timers for green circle
	  Timer left2 = new Timer(30, this);
	  Timer down2 = new Timer(30, this);
	  Timer up2 = new Timer(30, this);
	
	public static void main(String[] args){
		Tag m = new Tag();
		m.setSize(900,900);
		m.setVisible(true);
	}

	public Tag(){  //creates play area, addKeyListener means it will take input from keyboard
		addKeyListener(this);
		setFocusable(true);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	public void keyPressed(KeyEvent e) {  //makes it so when you press a button, it does the corresponding action, defined in actionPerformed
		int code = e.getKeyCode(); 
		if (code == KeyEvent.VK_RIGHT){  //actions for purple circle
			right.start();
		}	 
		if (code == KeyEvent.VK_LEFT){
			left.start();
		}	
		if (code == KeyEvent.VK_DOWN){
			down.start();
		}	
		if (code == KeyEvent.VK_UP){
			up.start();
		}
		if (code == KeyEvent.VK_W){  //actions for green circle
			up2.start();
		}
		if (code == KeyEvent.VK_A){
			left2.start();
		}
		if (code == KeyEvent.VK_S){
			down2.start();
		}	
		if (code == KeyEvent.VK_D){
			right2.start();
		}	 
		repaint();
	}
	@Override
	public void keyReleased(KeyEvent e) {  //stops executing the movement method when key is released
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_RIGHT){
			right.stop();
		}	 
		if (code == KeyEvent.VK_LEFT){
			left.stop();
		}	
		if (code == KeyEvent.VK_DOWN){
			down.stop();
		}	
		if (code == KeyEvent.VK_UP){
			up.stop();
		}	
		if (code == KeyEvent.VK_D){
			right2.stop();
		}	 
		if (code == KeyEvent.VK_A){
			left2.stop();
		}	
		if (code == KeyEvent.VK_S){
			down2.stop();
		}	
		if (code == KeyEvent.VK_W){
			up2.stop();
		}
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) { //defines the actual movement methods

		Object source = e.getSource();

		if(source.equals(right)){      //movement action, and teleports player to opposite side if they go out of bounds
			int newx = p1.getX() + 10; 
			p1.setX(newx);
			if(newx-10>900){
				p1.setX(-10);
			}
		}
		if(source.equals(left)){
			int newx = p1.getX() - 10; 
			p1.setX(newx);
			if(newx+10<0){
				p1.setX(910);
			}
		}
		if(source.equals(down)){
			int newy = p1.getY() + 10; 
			p1.setY(newy);
			if(newy-10>900){
				p1.setY(-10);
			}
		}
		if(source.equals(up)){
			int newy = p1.getY() - 10; 
			p1.setY(newy);
			if(newy+10<0){
				p1.setY(910);
			}
		}

		if(source.equals(right2)){
			int newx = p2.getX() + 10; 
			p2.setX(newx);
			if(newx-10>900){
				p2.setX(-10);
			}
		}
		if(source.equals(left2)){
			int newx = p2.getX() - 10; 
			p2.setX(newx);
			if(newx+10<0){
				p2.setX(910);
			}
		}
		if(source.equals(down2)){
			int newy = p2.getY() + 10; 
			p2.setY(newy);
			if(newy-10>900){
				p2.setY(-10);
			}
		}
		if(source.equals(up2)){
			int newy = p2.getY() - 10; 
			p2.setY(newy);
			if(newy+10<0){
				p2.setY(910);
			}
		}
		try {
			tagCheck();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		repaint();
	}

	public void tagCheck() throws InterruptedException{   //checks if you have tagged the other player
		if(p1it==true){
			if(Math.abs( p2.getX() - p1.getX() )< 35    &&  Math.abs( p2.getY() - p1.getY() )< 35 ){
				p1it=false;
				p2it=true;

				return;
			}
		}
		else if(p2it==true){
			if(Math.abs(p2.getX() - p1.getX() )< 35  && Math.abs( p2.getY() - p1.getY() )< 35  ){ 
				p2it=false;
				p1it=true;
				
				return;
			}
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.GRAY.darker().darker());  //Coloring play area and displaying circles
		g.fillRect(0, 0, 900, 900);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, 900, 900);
		p1.display(g);
		p2.display(g);
		if(p1it){
			g.setColor(Color.MAGENTA);
		}
		else if(p2it){
			g.setColor(Color.GREEN);
		}
		g.setFont(new Font("Chiller", Font.PLAIN, 30));
		g.drawString( "IT", 810,100);
	}
}



