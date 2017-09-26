package ball;
import java.applet.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Flapy extends Applet implements KeyListener,Runnable{
	public static int x=50,y=300,flag=0;
	static Thread t=null;
	public void init()
	{
		setBackground(Color.BLACK);
		addKeyListener(this);
		requestFocus();
		Flapy f=new Flapy();
		t=new Thread(f);
		
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.black);
		g.fillRect(0,0,getSize().height,getSize().height);
		g.setColor(Color.red);
		g.fillOval(x, y, 20, 20);
	}
	/*public void paint(Graphics g)
	{
		g.setColor(Color.red);
		g.fillOval(x, y, 20, 20);
	}*/
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(flag==0)
		{
			t.start();
			flag=1;
		}
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		y-=30;
		try {
			t.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		repaint();
		
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(;;)
		{
		y+=1;
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		repaint();
		}
		
	}

}
