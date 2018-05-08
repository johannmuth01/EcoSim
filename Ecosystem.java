class Ecosystem { 
  
  public static void initialize (Organism[][] map) {
    int xSpawn;
    int ySpawn;
    int numSheep=0;
    int numWolf=0;
    int numPlant=0;
    
    while (numSheep < 7){
      xSpawn= ((int)(Math.random()*25));    
      ySpawn= ((int)(Math.random()*25)); 
      
      if(map[xSpawn][ySpawn] == null){
        map[xSpawn][ySpawn]=new Sheep(xSpawn, ySpawn, 20, (int)(Math.random()*2));
        numSheep++;
      }
    }
    
    while (numWolf < 5){
      xSpawn= ((int)(Math.random()*25));    
      ySpawn= ((int)(Math.random()*25)); 
      
      if(map[xSpawn][ySpawn] == null){
        map[xSpawn][ySpawn]= new Wolf(xSpawn, ySpawn, 30, (int)(Math.random()*2));
        numWolf++;
      }
    }
    
    while (numPlant < 9){
      xSpawn= ((int)(Math.random()*25));    
      ySpawn= ((int)(Math.random()*25)); 
      
      if(map[xSpawn][ySpawn] == null){
        map[xSpawn][ySpawn]= new Plant(xSpawn,ySpawn,2,2);
        numPlant++;
      }
    }
  }
  
  
  public static void main(String[] args) { 
    
    Map map = new Map(25);
    
    // Initialize Map
    initialize(map);
    
    // display the fake grid on Console
    //DisplayGridOnConsole(map);
    
    //Set up Grid Panel
    DisplayGrid grid = new DisplayGrid(map);
    while(true){ 
      //Display the grid on a Panel
      grid.refresh();
      
      
      //Small delay
      try{ Thread.sleep(1000); }catch(Exception e) {};
      
      
      // Initialize Map (Making changes to map)
      for (int i=0; i<25; i++){
        for (int j=0; j<25; j++){
          if(map[i][j] != null){
            map[i][j].move(map);
          }
        }
      }
      
      //Display the grid on a Panel
      grid.refresh();
    }
  }
  
  // Method to simulate grid movement
  //public static void moveItemsOnGrid(Organism[][] map) { 
  
  //for(int i = 0; i<map[0].length;i++)        
  //for(int j = 0; j<map.length;j++) 
  //{ 
  
  //map[i][j].move(map);
  //}
  //}
  
  //method to display grid a text for debugging
  // public static void DisplayGridOnConsole(Organism[][] map) { 
  // for(int i = 0; i<map.length;i++){        
  // for(int j = 0; j<map[0].length;j++) 
  // System.out.print(map[i][j]+" ");
  //System.out.println("");
}
