import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class RobotExp {
    Robot robot;
    int x = 0, y = 0;
    public  RobotExp() {
        
        try {
            
            robot = new Robot();
            // Cria um delay de 5 segundos de modo que você possa abrir o notepad antes da execução do código a seguir
            // Robot começa a escrever
            
            
        } catch (AWTException e) {
            e.printStackTrace();
        }
        
    }
    
    public void recebe(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.moveX();
    }
    public void moveX()
    {
        robot.mouseMove(x, y);
    }
    public void moveA()
    {
        //robot.mouseMove(x, y);
        robot.keyPress(KeyEvent.VK_A);
    }
    public void moveD()
    {
        //robot.mouseMove(x, y);
        robot.keyPress(KeyEvent.VK_D);
    }
    
}