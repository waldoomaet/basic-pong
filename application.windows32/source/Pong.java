import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Pong extends PApplet {

int direccionPaleta1 = 50;
int direccionPaleta2 = 50;
float direccionEsferaX = 300;
float direccionEsferaY = 200;
float desplazamientoX = -2.5f;
float desplazamientoY = -2.5f;

public void setup()
{
  
  frameRate(120);
}

public void draw()
{
  background(0xff02F7AC);
  if(keyCode == UP && direccionPaleta2 > 1)
  {
    keyCode = 0;
    direccionPaleta2-=15;
  }
  else if(keyCode == DOWN && direccionPaleta2 < 249)
  {
    keyCode = 0;
    direccionPaleta2+=15;
  }
  else if(keyPressed)
  {
    if(key == 'w' && direccionPaleta1 > 1)
    {
      key = 0;
      direccionPaleta1-=15;
    }
    if(key == 's' && direccionPaleta1 < 249)
    {
      key = 0;
      direccionPaleta1+=15;
    }
  }
  fill(0xffFA0303);
  rect(560,direccionPaleta2,20,150);
  rect(20,direccionPaleta1,20,150);
  fill(0xffEDD818);
  ellipse(direccionEsferaX,direccionEsferaY,25,25);
  direccionEsferaY-=desplazamientoY;
  direccionEsferaX-=desplazamientoX;
  
  if(direccionEsferaX == 40 && direccionEsferaY > direccionPaleta1 && direccionEsferaY < direccionPaleta1+150)
  {
    desplazamientoX = -2.5f;
  }
  if(direccionEsferaY < 25)
  {
    desplazamientoY = -2.5f;
  }
  if(direccionEsferaY > 375)
  {
    desplazamientoY = 2.5f;
  }
  if(direccionEsferaX == 560 && direccionEsferaY > direccionPaleta2 && direccionEsferaY < direccionPaleta2+150 )
  {
    desplazamientoX = 2.5f;
  }
  if(direccionEsferaX < 40 || direccionEsferaX > 560)
  {
    direccionEsferaX = 300;
    direccionEsferaY = 200;
    desplazamientoX = 2.5f;
    desplazamientoY = 2.5f;
  }
  
  
}
  public void settings() {  size(600,400); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Pong" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
