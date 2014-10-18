SnowFlake[] balls;
void setup()
{
  size(400,400);
  background(0);
  frameRate(120);
  balls=new SnowFlake[100];
  for(int i=0; i<balls.length; i++){
    balls[i]=new SnowFlake();
  }
}
void draw()
{
  for (int i=0; i<balls.length; i++){
    balls[i].erase();
    balls[i].lookDown();
    balls[i].wrap();
    balls[i].move();
    balls[i].show();
  }
}
void mouseDragged()
{
  if(mouseButton==LEFT){
  stroke((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
  strokeWeight(15);
  line(pmouseX,pmouseY,mouseX,mouseY);
  }else if(mouseButton==RIGHT){
  stroke(0);
  strokeWeight(15);
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
  void show()
  {
    noStroke();
    fill(myColor);
    ellipse(myX, myY, 7,7);
  }
  void lookDown()
  {
    if(get(myX,myY+5)==color(0)){
      isMoving=true;
    }else{
      isMoving=false;
    }

  }
  void erase()
  {
    noStroke();
    fill(0);
    ellipse(myX,myY,9,9);
  }
  void move()
  {
   if(isMoving){
    myY++;
   }
  }
  void wrap()
  {
    if(myY>=395){
      myY=0;
      myX=(int)(Math.random()*400);
    }
  }
}
