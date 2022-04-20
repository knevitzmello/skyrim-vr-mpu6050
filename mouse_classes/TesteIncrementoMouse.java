import java.util.Scanner;
public class TesteIncrementoMouse implements Runnable 
{
    RobotExp mouse = new RobotExp();
    float x = 0, y = 0;
    int posX = 0, posY = 0;
    String string;
    int xl = 0;
    String parar = null;
    boolean cond = true;
    public TesteIncrementoMouse()
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
    public void incrementaX()
    {
        for(int x = 0; x < 100; x++)
        {
            System.out.println(x);
            ;//mouse.recebe(x, 500);
        }
    }
    public void run()
    {
        //for(int x = 0; x < 10; x++)
        {
            //////////////////////////////////////////////
            ////////MOVER CABEÇA PARA ESQUERDA////////////
            //////////////////////////////////////////////
            try{Thread.sleep(10000);}catch(InterruptedException ex)
            {Thread.currentThread().interrupt();}      
            mouse.recebe(0, 300);
            //////////////////////////////////////////////
            ////////MOVER CABEÇA PARA DIREITA/////////////
            //////////////////////////////////////////////
            try{Thread.sleep(3000);}catch(InterruptedException ex)
            {Thread.currentThread().interrupt();}
            for(int y = 0; y < 3845; y++)
            {
                xl = y;
                //try{Thread.sleep(1);}catch(InterruptedException ex)
                //{Thread.currentThread().interrupt();}
                
                if(xl > 1279)
                {
                    xl = 1280;
                    mouse.recebe(xl, 300);
                }
                else mouse.recebe(xl, 300);
                    
                System.out.println(y);
            } 
            //////////////////////////////////////////////
            ////////MOVER CABEÇA PARA DIREITA/////////////
            //////////////////////////////////////////////
            try{Thread.sleep(3000);}catch(InterruptedException ex)
            {Thread.currentThread().interrupt();}
            //for(int y = 1279; y < 1300; y++)
            {
                //mouse.recebe(y, 300);
                //System.out.println(y);
            }            
            mouse.recebe(1279, 300);
            try{Thread.sleep(3000);}catch(InterruptedException ex)
            {Thread.currentThread().interrupt();}
        }
        //while(cond)
        {
            
        }
    }
}
