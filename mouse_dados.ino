//Programa : Teste MPU-6050
//
//Baseado no programa original de JohnChi
 
//Carrega a biblioteca Wire
#include<Wire.h>;

const int SOCAO = 18;



//Endereco I2C do MPU6050
const int MPU=0x68;  

//Variaveis para armazenar valores dos sensores
float AcX,AcY,AcZ,Tmp,GyX,GyY,GyZ;
float AcX2 = 0,AcY2 = 0,AcZ2 = 0,Tmp2 = 0,GyX2 = 0,GyY2 = 0,GyZ2 = 0;

void setup()
{
  Serial.begin(9600);
  Wire.begin();
  Wire.beginTransmission(MPU);
  Wire.write(0x6B); 
   
  //Inicializa o MPU-6050
  Wire.write(0); 
  Wire.endTransmission(true);
    
}

void loop()
{
  Wire.beginTransmission(MPU);
  Wire.write(0x3B);  // starting with register 0x3B (ACCEL_XOUT_H)
  Wire.endTransmission(false);
  
  //Solicita os dados do sensor
  Wire.requestFrom(MPU,14,true);  
  AcX2 = 0;
  AcY2 = 0;
  AcZ2 = 0;
  Tmp2 = 0;
  GyX2 = 0;
  GyY2 = 0;
  GyZ2 = 0;
  
  //for(int i = 0; i < 100; i++)
  {
    AcX=Wire.read()<<8|Wire.read(); //0x3B (ACCEL_XOUT_H) & 0x3C (ACCEL_XOUT_L)     
    AcY=Wire.read()<<8|Wire.read(); //0x3D (ACCEL_YOUT_H) & 0x3E (ACCEL_YOUT_L)
    AcZ=Wire.read()<<8|Wire.read(); //0x3F (ACCEL_ZOUT_H) & 0x40 (ACCEL_ZOUT_L)
    Tmp=Wire.read()<<8|Wire.read(); //0x41 (TEMP_OUT_H) & 0x42 (TEMP_OUT_L)
    GyX=Wire.read()<<8|Wire.read(); //0x43 (GYRO_XOUT_H) & 0x44 (GYRO_XOUT_L)
    GyY=Wire.read()<<8|Wire.read(); //0x45 (GYRO_YOUT_H) & 0x46 (GYRO_YOUT_L)
    GyZ=Wire.read()<<8|Wire.read(); //0x47 (GYRO_ZOUT_H) & 0x48 (GYRO_ZOUT_L)

    AcX2+= AcX;
    AcY2+= AcY;
    AcZ2+= AcZ;
    GyX2= GyX;
    GyY2= GyY;
    GyZ2= GyZ;
    
    
  }
  //Armazena o valor dos sensores nas variaveis correspondentes
  

  AcX2= AcX2 -959;
  AcY2= AcY2 +959;
  AcZ2= AcZ2 +1681;

  //AcX2= AcX2/100;
 // AcY2= AcY2/100;
  //AcZ2= AcZ2/100;
  
  AcX2= AcX2/16384*9,8;
  AcY2= AcY2/16384*9,8;
  AcZ2= AcZ2/16384*9,8;

  GyX2= GyX2/16384;
  GyY2= GyY2/16384;
  GyZ2= GyZ2/16384;

   
  //Mostra os valores na serial
  //Serial.print("Acel. X = "); Serial.print(AcX2);
  //Serial.print(" | Y = "); Serial.print(AcY2);
  //Serial.print(" | Z = "); Serial.print(AcZ2);
  //Serial.print(" | Gir. X = "); Serial.print(GyX);
  //Serial.print(" | Y = "); Serial.print(GyY);
  //Serial.print(" | Z = "); Serial.print(GyZ);
  //Serial.print(" | Temp = "); Serial.println(Tmp/340.00+36.53);

    
    if( ((AcX2) > SOCAO) || ((AcY2) > SOCAO) || ((AcZ2) > SOCAO) || ((AcX2) < -SOCAO) || ((AcY2) < -SOCAO) || ((AcZ2) < -SOCAO))
      {
        Serial.print(AcX2);
         Serial.print("\n");
        Serial.print(AcY2);
         Serial.print("\n");
        Serial.print(AcZ2);
        Serial.print("\n");
        Serial.print("\n");
        Serial.print(GyX2);
         Serial.print("\n");
        Serial.print(GyY2);
         Serial.print("\n");
        Serial.print(GyZ2);
        delay(1000);
      }
  //Aguarda 300 ms e reinicia o processo
  delay(10);
}
