import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
 
public class Mouse extends JFrame
implements MouseListener, MouseMotionListener {
 
    JLabel mousePosition;
    @Override
    public void mouseClicked(MouseEvent e) {
        mousePosition.setText("Mouse clicado na coordenada : ["+e.getX()+","+e.getY()+"]");
         
    }
 
    @Override
    public void mouseEntered(MouseEvent e) {
        mousePosition.setText("Coordenada atual do mouse : ["+e.getX()+","+e.getY()+"]");
         
    }
 
    @Override
    public void mouseExited(MouseEvent e) {
        mousePosition.setText("O Mouse está fora da janela de acesso");
         
    }
 
    @Override
    public void mousePressed(MouseEvent e) {
        mousePosition.setText("Mouse pressionado nas coordenadas : ["+e.getX()+","+e.getY()+"]");
         
    }
 
    @Override
    public void mouseReleased(MouseEvent e) {
        mousePosition.setText("Coordenada atual do mouse : ["+e.getX()+","+e.getY()+"]");
         
    }
 
    @Override
    public void mouseDragged(MouseEvent e) {
        mousePosition.setText("Mouse arrastado nas coordenadas : ["+e.getX()+","+e.getY()+"]");
         
    }
 
    @Override
    public void mouseMoved(MouseEvent e) {
        mousePosition.setText("Mouse movido para as coordenadas : ["+e.getX()+","+e.getY()+"]");
         
    }
 
    public static void main(String args[])
    {
        new MouseTracker().start();
         
    }
    public void start()
    {
        mousePosition=new JLabel();
         addMouseListener( this );        // listens for own mouse and
          addMouseMotionListener( this );  // mouse-motion events
          setLayout(new FlowLayout(1));
          add(mousePosition);
          Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
          setSize(size );
          setUndecorated(true);
          setVisible( true );
          setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}