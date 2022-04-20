import java.util.Scanner;

public class Teste implements Runnable 
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    ArduinoSerial arduino = new ArduinoSerial("COM5");
    RobotExp mouse = new RobotExp();
    float x = 0, y = 0;
    int posX = 0, posY = 0;
    String string;
    float xl = 0;
    String parar = null;
    boolean cond = true;
    /**
     * COnstrutor para objetos da classe a
     */
    public Teste()
    {
        Thread th = new Thread(this);
        th.start();
        this.stop();
    }
    public void stop()
    {
        Scanner sc = new Scanner(System.in);
        
        boolean run = true;
        while(run)
        {
            parar = sc.nextLine();
            if("w".equals(parar))
            {
                posX = 0;
            }
            else {cond = false; run = false; }
        }
        System.exit(2);
    }
    public void run()
    {
        while(cond)
        {
            arduino.initialize();
            string = arduino.read();
            //System.out.println(string);
            if(arduino.read() != null)
            {
                if(string.charAt(0) == 'x')
                {
                    x = Float.parseFloat(string.substring(1, 5));
                    if(Math.abs(x) > 3)
                    {
                            posX += Math.round(x);
                        if(posX > 1300)
                          posX = 1300;
                        if(posX < 20)
                          posX = 20;
                        {
                            //if((posX < 1400) && (posX > -800))
                            {
                                //mouse.recebe(posX, posY); 
                                if(posX < 0)
                                    mouse.moveA();
                                if(posX > 0)
                                    mouse.moveD();
                                System.out.println("x: " + x);
                                
                            }
                        }
                    }
                }
                
                if(string.charAt(0) == 'y')
                {
                    
                    y = Float.parseFloat(string.substring(1, 5));
                    if(Math.abs(y) > 3)
                        posY += Math.round(y);
                        //posY = -1 * posY;
                    if(posY > 1100)
                      posY = 1100;
                    if(posY < -20)
                      posY = -20;
                    {
                        //if((posY < 1400) && (posY > -800))
                        {
                            //mouse.recebe(posX, posY); 
                            
                            System.out.println("y: " + y);
                            
                        }
                    }
                }
            }
        }
    }
}
