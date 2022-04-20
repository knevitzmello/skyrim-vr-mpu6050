import java.util.Scanner;
//delay sem verificação > 3mili
//dividindo por 1,5
public class HeadTrack2 implements Runnable 
{
    ArduinoSerial arduino = new ArduinoSerial("COM4");
    RobotExp mouse = new RobotExp();
    double x = 0, y = 0;
    int posX = 0, posY = 0;
    String stringX, stringY;
    float xl = 0;
    String parar = null;
    boolean cond = true, cond2 = true;
    boolean threadEixo = true ;

    public HeadTrack2()
    {
        System.out.println("Aguardando eixo Y");
        threadEixo = true;
        
        Thread threadX = new Thread(this);
        threadX.start();
        
        while(threadEixo == true)
            System.out.println("Aguardando eixo X");
        
        
        Thread threadY = new Thread(this);
        threadY.start();
        
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
                posY = 0;
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
        //arduino.initialize();
        if(threadEixo == true)
        {
            arduino.initialize();
            threadEixo = false;
            while(cond)
            {
                stringX = arduino.read();
                if(arduino.read() != null)
                {
                    if(stringX.charAt(0) == 'x')
                    {
                        //System.out.println(arduino.read());
                        x = Float.parseFloat(stringX.substring(1, 5));           
                        if(Math.abs(x) > 0.1)
                            {
                                //System.out.println(x);
                                x = 10* x / 15;
                                posX += Math.round(x);
                                try{Thread.sleep(3);}catch(InterruptedException ex)
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
                }
            }
        }
        else if(threadEixo == false)
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
        
        cond2 = false;
    }
}
