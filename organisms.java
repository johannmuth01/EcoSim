/*Class organism
 * The super class for plants, sheep and wolves
 * Johann Muth
 * April 23
 */
abstract class Organism{
 
  
  private int xValue;
  
  private int yValue;
  
  private int health;
  
  private int sex;
  
  //String sex;
  
  Organism(int xValue, int yValue, int health, int sex){
    this.xValue=xValue;
    this.yValue=yValue;
    this.health=health;
    this.sex=sex;
  }
  
  public int getHealth(){
    return this.health;
  }
  
  public void setHealth(int value){
    this.health=value;
                          
}
  public int getXValue(){
    return this.xValue;
}
  public void setXValue(int value){
    this.xValue=value;
  }
  public int getYValue(){
    return this.yValue;
}
  public void setYValue(int value){
    this.yValue=value;
  }
  public int getSex(){
    return this.sex;
  }
  
  abstract void move(Organism[][] map);
}
  