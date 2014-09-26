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

public class SnowflakeCatcher extends PApplet {

SnowFlake[] balls;
public void setup()
{
  size(400,400);
  background(0);
  balls=new SnowFlake[500];
  for(int i=0; i<balls.length; i++){
    balls[i]=new SnowFlake();
  }
}
public void draw()
{
  for (int i=0; i<balls.length; i++){
    balls[i].lookDown();
    balls[i].erase();
    balls[i].wrap();
    balls[i].move();
    balls[i].show();
  }
}
public void mouseDragged()
{
  if(mouseButton==LEFT){
  stroke((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
  strokeWeight(10);
  line(pmouseX,pmouseY,mouseX,mouseY);
  }else if(mouseButton==RIGHT){
  stroke(0);
  strokeWeight(10);
  line(pmouseX,pmouseY,mouseX,mouseY);
}
}

class SnowFlake
{
  int myX, myY, myColor;
  boolean isMoving;
  SnowFlake()
  {
    myX=(int)(Math.random()*400);
    myY=(int)(Math.random()*400);
    myColor=255; 
  }
  public void show()
  {
    noStroke();
    fill(myColor);
    ellipse(myX, myY, 7,7);
  }
  public void lookDown()
  {
    if(get(myX,myY+4)==color(0)){
      isMoving=true;
    }else{
      isMoving=false;
    }

  }
  public void erase()
  {
    noStroke();
    fill(0);
    ellipse(myX,myY,9,9);
  }
  public void move()
  {
   if(isMoving){
    myY++;
   }
  }
  public void wrap()
  {
    if(myY>=396){
      myY=0;
      myX=(int)(Math.random()*400);
    }
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
