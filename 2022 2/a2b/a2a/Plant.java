package a2b.a2a;

import java.awt.Color;

/**
 * Represent a plant.
 * @author lizihan
 *
 */
public class Plant extends Lifeform{
    /** row and col is the location of a plant. */
//    int row, col;
    Cell[][] cell;
    
    /**
     * Construct a plant.
     * @param row is row.
     * @param column is column.
     */
    public Plant(Cell[][] cell) {
        this.cell=cell;
     
        }
    
    public Lifeform createLife(){
        return new Herbivore(cell);
    }   
    
    public void giveBirth(int x,int y) {
        
        Lifeform plant=this.createLife();
//        addToWorld(life);
        int i1=0;
        int j1=0;
        
        
       
//        if(cell[x][y].lifeAge!=0) {
            if(birthCondistion(x,y)){
                super.choosePosition(cell,x,y);//,i1,j1);
                i1=cell[x][y].birthX;
                j1=cell[x][y].birthY;
//                                h=new Herbivore(cell);
//                                herb=this.createLife();
                cell[i1][j1].addLife(plant);
                cell[i1][j1].setBackground(Color.green);
                cell[i1][j1].lifeType="plant";
//                            cell[i1][j1].lifeAge=5;
//                            System.out.print("c"+i1+j1+" ");
            }
//        }
//        else {
//             cell[x][y].delLife();
//             cell[x][y].setBackground(Color.white);
//             cell[x][y].lifeType="space";
//        }
    }
    
    public boolean birthCondistion(int x,int y) {
        char[] nei=super.getNeighbors(cell,x,y);
        int nFree=0;
        int nPlant=0;
//        int nHerb=0;
        for(int i=0;i<8;i++) {
            if(nei[i]=='s')
                nFree++;
            if(nei[i]=='p')
                nPlant++;
//            if(nei[i]=='h')
//                nHerb++;
        }
//        System.out.println(nFree+" "+nPlant+" "+nHerb);
        if(nFree>=3&&nPlant>=2)
            return true;
        else
            return false;
    }
    
    public void move(int x,int y) {
    
    }
}
