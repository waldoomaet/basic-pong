int direccionPaleta1 = 50;
int direccionPaleta2 = 50;
float direccionEsferaX = 300;
float direccionEsferaY = 200;
float desplazamientoX = -2.5;
float desplazamientoY = -2.5;

void setup()
{
  size(600,400);
  frameRate(120);
}

void draw()
{
  background(#02F7AC);
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
  fill(#FA0303);
  rect(560,direccionPaleta2,20,150);
  rect(20,direccionPaleta1,20,150);
  fill(#EDD818);
  ellipse(direccionEsferaX,direccionEsferaY,25,25);
  direccionEsferaY-=desplazamientoY;
  direccionEsferaX-=desplazamientoX;
  
  if(direccionEsferaX == 40 && direccionEsferaY > direccionPaleta1 && direccionEsferaY < direccionPaleta1+150)
  {
    desplazamientoX = -2.5;
  }
  if(direccionEsferaY < 25)
  {
    desplazamientoY = -2.5;
  }
  if(direccionEsferaY > 375)
  {
    desplazamientoY = 2.5;
  }
  if(direccionEsferaX == 560 && direccionEsferaY > direccionPaleta2 && direccionEsferaY < direccionPaleta2+150 )
  {
    desplazamientoX = 2.5;
  }
  if(direccionEsferaX < 40 || direccionEsferaX > 560)
  {
    direccionEsferaX = 300;
    direccionEsferaY = 200;
    desplazamientoX = 2.5;
    desplazamientoY = 2.5;
  }
  
  
}
