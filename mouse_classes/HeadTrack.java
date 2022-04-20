import java.util.Scanner;

public class HeadTrack implements Runnable 
{
    ArduinoSerial arduino = new ArduinoSerial("COM4");
    RobotExp mouse = new RobotExp();
    double x = 0, y = 0;
    int posX = 0, posY = 0;
    String string;
    float xl = 0;
    String parar = null;
    boolean cond = true, cond2 = true;

    public HeadTrack()
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
        while(cond2)
        {
            System.out.println("encerrando");
        }
        for(int i = 0; i < 10; i++)
            System.out.println("encerrando2");
        System.exit(2);
    }
    public void run()
    {
        arduino.initialize();
        while(cond)
        {
            string = arduino.read();
            if(arduino.read() != null)
            {
                if(string.charAt(0) == 'x')
                {
                    //System.out.println(arduino.read());
                    x = Float.parseFloat(string.substring(1, 5));           
                    if(Math.abs(x) > 0.1)
                        {
                            //System.out.println(x);
                            if(Math.abs(x) > 2)
                                x = 10 * x / 55;
                                else{x = 10*x / 20;}
                            posX += Math.round(x);
                            //System.out.println(posX);
                            /*if(posX > 1279)
                            {
                                posX = 1280;
                            }
                            else if(posX < 0)
                            {
                                posX = -1;
                            }*/
                            try{Thread.sleep(2);}catch(InterruptedException ex)
                            {Thread.currentThread().interrupt();}  
                            mouse.recebe(posX, posY);
                            if(posX > 1279)
                            {
                                posX = 1279;
                            }
                            else if(posX < 0)
                            {
                                posX = 0;
                            }
                         }
                }
                if(string.charAt(0) == 'y')
                {
                    //System.out.println(arduino.read());
                    y = Float.parseFloat(string.substring(1, 5));
                    y = y/3;
                    y = 0;//////////////////////////////qq
                    if(Math.abs(y) > 0.5)
                        {
                            posY += Math.round(y);
                            mouse.recebe(posX, posY);
                            if(posY > 1279)
                            {
                                posY = 1279;
                            }
                            else if(posY < 0)
                            {
                                posY = 0;
                            }
                         }
                }
                //try{Thread.sleep(1);}catch(InterruptedException ex)
                //{Thread.currentThread().interrupt();}
            }
        }
        cond2 = false;
    }
}
