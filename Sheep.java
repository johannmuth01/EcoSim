/*Class Sheep
 * Extends organism
 * Johann Muth
 * April 23
 */
class Sheep extends Organism{
  Sheep(int xValue, int yValue, int health, int sex){
    super(xValue, yValue, 20, (int)(Math.random()*2));
  }
  int x=getXValue();
  int y=getYValue();
  int h=getHealth();
  int s=getSex();
  
  void eat(){
    setHealth(h+6);
  }
  
  void babies(Organism[][] map){
    for (int i=0; i<25; i++){
      for (int j=0; j<25; j++){
        if (map[i][j]==null){
          map[i][j]=new Sheep(i,j,20, (int)(Math.random()*2));
          setHealth(h-10);
          return;
        }
      }
    }
  }
  
  
  void move(Organism[][] map){ //Rn it just checks if there's another sheep in that spot
    int direction=((int)(Math.random()*5));
    if (direction==0){
      if ((x!=24) && (map[x+1][y] == null)){
        setXValue(x+1);
        setHealth(h-2);
      } else if ((x!=24) && map[x+1][y] instanceof Plant){
        setXValue(x+1);
        eat();
      } else if ((x!=24) && map[x+1][y] instanceof Sheep){
        if (map[x+1][y].getSex() != s){
          babies(map);
        } else {
          move(map);
        }
      }
    }
    
    
    if (direction==1){
      if ((x!=0) && (map[x-1][y] == null)){
        setXValue(x-1);
        setHealth(h-2);
      }else if ((x!=0) && map[x-1][y] instanceof Plant){
        setXValue(x-1);
        eat();
      } else if ((x!=0) && map[x-1][y] instanceof Sheep){
        if (map[x-1][y].getSex() != s){
          babies(map);
        } else {
          move(map);
        }
      }
    }
    
    if (direction==2){
      if ((y!=24) && (map[x][y+1] == null)){
        setYValue(y+1);
        setHealth(h-2);
      }else if ((y!=24) && map[x][y+1] instanceof Plant){
        setYValue(y+1);
        eat();
      } else if ((y!=24) && map[x][y+1] instanceof Sheep){
        if (map[x][y+1].getSex() != s){
          babies(map);
        } else {
          move(map);
        }
      } 
    }  
    
    if (direction==3){
      if ((y!=0) && (map[x][y-1] == null)){
        setYValue(y-1);
        setHealth(h-2);
      }else if ((y!=0) && (map[x][y-1] instanceof Plant)){
        setYValue(y-1);
        eat();
      } else if ((y!=0) && map[x][y-1] instanceof Sheep){
        if (map[x][y-1].getSex() != s){
          babies(map);
        } else {
          move(map);
        }
      }
    }
    
    if (direction==4){
      setHealth(h-1);
    }
  }
  
  
}
