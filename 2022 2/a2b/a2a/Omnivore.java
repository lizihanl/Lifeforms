package a2b.a2a;

import java.awt.Color;

public class Omnivore extends Lifeform{
    Cell[][] cell;
    public Omnivore(Cell[][] cell) {
        this.cell=cell;
     
        }
    public Lifeform createLife(){
        return new Omnivore(cell);
    }
    
    
    public void giveBirth(int x,int y) {
        
        Lifeform omn;//this.createLife();
//      addToWorld(life);
      int i1=0;
      int j1=0;
      System.out.print("ok");
     
     
      if(cell[x][y].lifeAge!=0) {
          if(birthCondistion(x,y)){
              super.choosePosition(cell,x,y);//,i1,j1);
              i1=cell[x][y].birthX;
              j1=cell[x][y].birthY;
//                              h=new Herbivore(cell);
//                              herb=this.createLife();
              omn=this.createLife();
              cell[i1][j1].addLife(omn);
              cell[i1][j1].setBackground(Color.blue);
              cell[i1][j1].lifeType="omni";
//                          cell[i1][j1].lifeAge=5;
//                          System.out.print("c"+i1+j1+" ");
          }
      }
      else {
           cell[x][y].delLife();
           cell[x][y].setBackground(Color.white);
           cell[x][y].lifeType="space";
           cell[x][y].foodType=0;
      }
    }
    public boolean birthCondistion(int x,int y) {
        char[] nei=super.getNeighbors(cell,x,y);
        int nFree=0;
        int nOmn=0;
        int nFood=0;
        for(int i=0;i<8;i++) {
            if(nei[i]=='s')
                nFree++;
            if(nei[i]=='o')
                nOmn++;
            if(nei[i]=='p'||nei[i]=='h'|nei[i]=='c')
                nFood++;
        }
//        System.out.println(nFree+" "+nPlant+" "+nHerb);
        if(nFree>=2&&nOmn>=2&&nFood>=1)
            return true;
        else
            return false;
    }
    public void move(int x,int y) {
        int i=0;
        int j=0;
        int nFood=0;
        int age=cell[x][y].lifeAge;
        Lifeform omn=this.createLife();
        
        if(cell[x][y].lifeAge!=5) {
            nFood=countFood(cell,x,y);
            if(nFood==1||nFood==2) {
            
                choosePosition(cell,x,y);
                i=cell[x][y].birthX;
                j=cell[x][y].birthY;

                cell[i][j].addLife(omn);
                cell[i][j].setBackground(Color.blue);
                cell[i][j].lifeType="omni";
                System.out.println("this");    
                
                cell[x][y].delLife();
                cell[x][y].setBackground(Color.white);
                cell[x][y].lifeType="space";
                cell[x][y].foodType=0;
            }
        }
        if(nFood==1)
            cell[i][j].lifeAge=age;  
    }
}
