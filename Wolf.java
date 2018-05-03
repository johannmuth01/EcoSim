/*Class wolf
 * extends organism
 * Johann Muth
 * April 23
 */
class Wolf extends Organism{
  
  Wolf(int xValue, int yValue, int health, int sex){
    super(xValue, yValue, 30, (int)(Math.random()*2));
  }
  int x=getXValue();
  int y=getYValue();
  int h=getHealth();
  int s=getSex();
  Wolf tempWolf;
  
  void eat(){
    setHealth(h+12);
  }
  
  void babies(Organism[][] map){
    for (int i=0; i<25; i++){
      for (int j=0; j<25; j++){
        if (map[i][j]==null ){
          map[i][j]=new Wolf(i,j,20, (int)(Math.random()*2));
          setHealth(h-10);
          return;
        }
      }
    }
  }
  
  void fight(Wolf opponent){
    if(opponent.getHealth() > getHealth()){
      setHealth(0);
    } else if (opponent.getHealth() < getHealth()){
      opponent.setHealth(0);
    } else {
      opponent.setHealth(opponent.getHealth()-10);
      setHealth(h-10);
    }
  }
  
  
  
  void move(Organism[][] map){ //Rn it just checks if there's another sheep in that spot
    int direction=((int)(Math.random()*5));
    if (direction==0){
      if ((x!=24) && (map[x+1][y] == null)){
        setXValue(x+1);
        setHealth(h-2);
      }else if ((x!=24) && map[x+1][y] instanceof Sheep){
        setXValue(x+1);
        eat();
    } else if ((x!=24) && map[x+1][y] instanceof Wolf){
      if (map[x+1][y].getSex() != s){
        babies(map);
      } else {
        tempWolf=(Wolf)(map[x+1][y]);
        fight(tempWolf);
      }
    }
    }
    
    
    
    if (direction==1){
      if ((x!=0) && (map[x-1][y] == null)){
        setXValue(x-1);
        setHealth(h-2);
      }else if ((x!=0) && map[x-1][y] instanceof Sheep){
        setXValue(x-1);
        eat();
      
    } else if ((x!=0) && map[x-1][y] instanceof Wolf){
      if (map[x-1][y].getSex() != s){
        babies(map);
      } else {
        tempWolf=(Wolf)(map[x-1][y]);
        fight(tempWolf);
      }
    }
    }
    
    if (direction==2){
      if ((y!=24) && (map[x][y+1] == null)){
        setYValue(y+1);
        setHealth(h-2);
      }else if ((y!=24) && map[x][y+1] instanceof Sheep){
        setYValue(y+1);
        eat();
      }
    } else if ((y!=24) && map[x][y+1] instanceof Wolf){
      if (map[x][y+1].getSex() != s){
        babies(map);
      } else{
        tempWolf=(Wolf)(map[x][y+1]);
        fight(tempWolf);
      } 
    }
    
    if (direction==3){
      if ((y!=0) && (map[x][y-1] == null)){
        setYValue(y-1);
        setHealth(h-2);
      }else if ((y!=0) && (map[x][y-1] instanceof Sheep)){
        setYValue(y-1);
        eat();
      } else if ((y!=0) && map[x][y-1] instanceof Wolf){
        if (map[x][y-1].getSex() != s){
          babies(map);
        } else{
          tempWolf=(Wolf)(map[x][y-1]);
          fight(tempWolf);
        }
      }
      
      if (direction==4){
        setHealth(h-1);
      }
    }
  }  
}
