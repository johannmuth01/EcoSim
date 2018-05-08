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
  
  void eat(Organism[][] map, int x, int y){
    setHealth(h+map[x][y].getHealth());
    map[x][y]=null;
  }
  
  void babies(Organism[][] map){
    for (int i=0; i<25; i++){
      for (int j=0; j<25; j++){
        if (map[i][j]==null ){
          map[i][j]=new Wolf(i,j,15, (int)(Math.random()*2));
          setHealth(getHealth()-10);
          System.out.println("new Wolf @ "+i+" " +j);
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
    if (h>0){
      int direction=((int)(Math.random()*5));
      if (direction==0){
        if ((x!=24) && (map[x+1][y] == null)){
          map[x+1][y]= new Wolf(x+1,y,h-2,s);
          map[x][y]=null;
        }else if ((x!=24) && map[x+1][y] instanceof Sheep){
          eat(map, x+1, y);
          map[x+1][y]= new Wolf(x+1,y,h,s);
          map[x][y]=null;
        } else if ((x!=24) && map[x+1][y] instanceof Wolf){
          if (map[x+1][y].getSex() != s){
             if ((map[x+1][y].getHealth()>15) && (map[x][y].getHealth()>15)) {
            babies(map);
            }
          } else {
            tempWolf=(Wolf)(map[x+1][y]);
            fight(tempWolf);
          }
        }
      }
      
      
      
      if (direction==1){
        if ((x>0) && (map[x-1][y] == null)){
          map[x-1][y]= new Wolf(x-1,y,h-2,s);
          map[x][y]=null;
        }else if ((x>0) && map[x-1][y] instanceof Sheep){
          eat(map,x-1,y);
          map[x-1][y]= new Wolf(x-1,y,h,s);
          map[x][y]=null;
          
          
        } else if ((x>0) && map[x-1][y] instanceof Wolf){
          if (map[x-1][y].getSex() != s){
            if ((map[x-1][y].getHealth()>15) && (map[x][y].getHealth()>15)) {
            babies(map);
            }
          } else {
            tempWolf=(Wolf)(map[x-1][y]);
            fight(tempWolf);
          }
        }
      }
      
      if (direction==2){
        if ((y<24) && (map[x][y+1] == null)){
          map[x][y+1]= new Wolf(x,y+1,h-2,s);
          map[x][y]=null;
        }else if ((y!=24) && map[x][y+1] instanceof Sheep){
          eat(map, x, y+1);
          map[x][y+1]= new Wolf(x,y+1,h,s);
          map[x][y]=null;
          
        }
      } else if ((y<24) && map[x][y+1] instanceof Wolf){
        if (map[x][y+1].getSex() != s){
           if ((y<24)&&(map[x][y+1].getHealth()>15) && (map[x][y].getHealth()>15)) {
            babies(map);
            
           }
        } else{
          tempWolf=(Wolf)(map[x][y+1]);
          fight(tempWolf);
        } 
      }
      
      if (direction==3){
        if ((y>0) && (map[x][y-1] == null)){
          map[x][y-1]= new Wolf(x,y-1,h-2,s);
          map[x][y]=null;
        }else if ((y>0) && (map[x][y-1] instanceof Sheep)){
          eat(map, x, y-1);
          map[x][y-1]= new Wolf(x,y,h-2,s);
          map[x][y]=null;
          
        } else if ((y>0) && map[x][y-1] instanceof Wolf){
          if (map[x][y-1].getSex() != s){
             if ((map[x][y-1].getHealth()>15) && (map[x][y].getHealth()>15)) {
            babies(map);
            }
          } else{
            tempWolf=(Wolf)(map[x][y-1]);
            fight(tempWolf);
          }
        }
        
        if (direction==4){
          setHealth(h-1);
        }
      }
    } else {
      map[x][y]=null;
    }
  }
}
