/*Class plant
 * extension of ogranism
 * Johann Muth
 * April 23
 */
class Plant extends Organism{
  
  Plant(int xValue, int yValue, int health, int sex){
    super(xValue, yValue, health, 2);
  }
  int x=getXValue();
  int y=getYValue();
  int h=getHealth();
  
  void move(Organism[][] map){
    int spawn=((int)(Math.random()*100));
    if (spawn==99){
      int direction= ((int)(Math.random()*5));
      if ((direction==0) && (map[x+1][y] == null)){
        new Plant(x+1,y,2,2);
      }
      
      if ((direction==1) && (map[x-1][y] == null)){
        new Plant(x-1,y,2,2);
      }
      
      if ((direction==2) && (map[x][y+1] == null)){
        new Plant(x,y+1,2,2);
      }
      
      if ((direction==3) && (map[x+1][y] == null)){
        new Plant(x,y-1,2,2);
      }
      
    }
  }
}