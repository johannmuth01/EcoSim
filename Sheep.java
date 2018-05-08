/*Class Sheep
 * Extends organism
 * Johann Muth
 * April 23
 */
class Sheep extends Organism{ //a subclass of organisms
  Sheep(int xValue, int yValue, int health, int sex){
    super(xValue, yValue, 20, (int)(Math.random()*2));
  }
  int x=getXValue();
  int y=getYValue();
  int h=getHealth();
  int s=getSex();
  
  void eat(Organism[][] map, int x, int y){
    setHealth(h+map[x][y].getHealth());
    map[x][y]=null;
  }
  
  void babies(Organism[][] map){
    for (int i=0; i<25; i++){
      for (int j=0; j<25; j++){
        if (map[i][j]==null){
          map[i][j]=new Sheep(i,j,15, (int)(Math.random()*2));
          setHealth(h-10);
          return;
        }
      }
    }
  }
  
  
  void move(Organism[][] map){ //Rn it just checks if there's another sheep in that spot
    if(h>0){
      int direction=((int)(Math.random()*5));
      if (direction==0){
        if ((x!=24) && (map[x+1][y] == null)){
          map[x+1][y]= new Sheep(x+1,y,h-2,s);
          map[x][y]=null;
        }else if ((x!=24) && map[x+1][y] instanceof Plant){
          eat(map, x+1,y);
          map[x+1][y]= new Sheep(x+1,y,h,s);
          map[x][y]=null;
        } else if ((x!=24) && map[x+1][y] instanceof Sheep){
          if (map[x+1][y].getSex() != s){
            if ((map[x+1][y].getHealth()>15) && (map[x][y].getHealth()>15)) {
              babies(map);
            }
          } else {
            move(map);
          }
        }
      }
      
      
      if (direction==1){
        if ((x!=0) && (map[x-1][y] == null)){
          map[x-1][y]= new Sheep(x-1,y,h-2,s);
          map[x][y]=null;
        }else if ((x!=0) && map[x-1][y] instanceof Plant){
          eat(map, x-1,y);
          map[x-1][y]= new Sheep(x-1,y,h,s);
          map[x][y]=null;
          
        } else if ((x!=0) && map[x-1][y] instanceof Sheep){
          if (map[x-1][y].getSex() != s){
            if ((map[x-1][y].getHealth()>15) && (map[x][y].getHealth()>15)) {
              babies(map);
            }
          } else {
            move(map);
          }
        }
      }
      
      if (direction==2){
        if ((y!=24) && (map[x][y+1] == null)){
          map[x][y+1]= new Sheep(x,y+1,h-2,s);
          map[x][y]=null;
        }else if ((y!=24) && map[x][y+1] instanceof Plant){
          eat(map, x,y+1);
          map[x][y+1]= new Sheep(x,y+1,h,s);
          map[x][y]=null;
        } else if ((y!=24) && map[x][y+1] instanceof Sheep){
          if (map[x][y+1].getSex() != s){
            if ((map[x][y+1].getHealth()>15) && (map[x][y].getHealth()>15)) {
              babies(map);
            }
          } else {
            move(map);
          }
        } 
      }  
      
      if (direction==3){
        if ((y!=0) && (map[x][y-1] == null)){
          map[x][y-1]= new Sheep(x,y-1,h-2,s);
          map[x][y]=null;
        }else if ((y!=0) && (map[x][y-1] instanceof Plant)){
          eat(map, x,y-1);
          map[x][y+1]= new Sheep(x,y-1,h,s);
          map[x][y]=null;
        } else if ((y!=0) && map[x][y-1] instanceof Sheep){
          if (map[x][y-1].getSex() != s){
            if ((map[x][y-1].getHealth()>15) && (map[x][y].getHealth()>15)) {
              babies(map);
            }
          } else {
            move(map);
          }
        }
      }
      
      if (direction==4){
        setHealth(h-1);
      }
    } else {
      map[x][y]=null;
    }
  }
  
  
}
