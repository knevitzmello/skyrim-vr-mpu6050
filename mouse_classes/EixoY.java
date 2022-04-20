
/**
 * Write a description of class EixoY here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EixoY implements Runnable
{
    ArduinoSerial arduino = new ArduinoSerial("COM4");
    RobotExp mouse = new RobotExp();
    double x = 0, y = 0;
    int posX = 0, posY = 0;
    String stringY;
    float xl = 0;
    String parar = null;
    boolean cond = true, cond2 = true;
    boolean threadEixo = true ;
    public EixoY()
    {
        Thread threadY = new Thread(this);
        threadY.start();
    }
    public void run()
    {
        while(cond)
            {
                stringY = arduino.read();
                if(arduino.read() != null)
                {
                    if(stringY.charAt(0) == 'y')
                    {
                        y = Float.parseFloat(stringY.substring(1, 5));
                        if(Math.abs(y) > 0.1)
                            {
                                y = (-10) * y / 15;
                                posY += Math.round(y);
                                try{Thread.sleep(3);}catch(InterruptedException ex)
                                {Thread.currentThread().interrupt();}  
                                mouse.recebe(posX, posY);
                                if(posY > 720)
                                {
                                    posY = 720;
                                }
                                else if(posY < 0)
                                {
                                    posY = 0;
                                }
                             }
                    }
                }
            }
    }
}
