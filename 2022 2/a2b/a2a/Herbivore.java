package a2b.a2a;

import java.awt.Color;

/**
 * Represent a Herbivore.
 * @author lizihan
 *
 */
public class Herbivore extends Lifeform{
    /** 
     * dayLeft is herbivore's life;
     * row and col is the location of a herbivore. 
     */
//    int daysLeft, row, col;
//    Cell cell[][];
    
//    int test=66;
    Cell[][] cell;
    
    /**
     * Construct a Herbivore.
     * @param row is row.
     * @param column is column.
     */
//    public Herbivore() {
//        
//    }
//    public Herbivore(Cell cell) {
//        
//    }
//    public Herbivore(int row, int col) {
//        daysLeft = 5;
//        this.row = row;
//        this.col = col;
//    }

    public Herbivore(Cell[][] cell) {
        this.cell=cell;
     
        }
    
    /**
     * This is how a Herbivore move.
     */
    public Lifeform createLife(){
        return new Herbivore(cell);
    }
    
    
    public void giveBirth(int x,int y) {
        
        Lifeform herb=this.createLife();
//        addToWorld(life);
        int i1=0;
        int j1=0;
        
        
       
        if(cell[x][y].lifeAge!=0) {
            if(birthCondistion(x,y)){
                super.choosePosition(cell,x,y);//,i1,j1);
                i1=cell[x][y].birthX;
                j1=cell[x][y].birthY;
//                                h=new Herbivore(cell);
//                                herb=this.createLife();
                cell[i1][j1].addLife(herb);
                cell[i1][j1].setBackground(Color.yellow);
                cell[i1][j1].lifeType="herbi";
//                            cell[i1][j1].lifeAge=5;
//                            System.out.print("c"+i1+j1+" ");
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
        int nPlant=0;
        int nHerb=0;
        for(int i=0;i<8;i++) {
            if(nei[i]=='s')
                nFree++;
            if(nei[i]=='p')
                nPlant++;
            if(nei[i]=='h')
                nHerb++;
        }
//        System.out.println(nFree+" "+nPlant+" "+nHerb);
        if(nFree>=2&&nPlant>=2&&nHerb>=1)
            return true;
        else
            return false;
    }
    
    public void move(int x,int y) {
        int i=0;
        int j=0;
        int nFood=0;
        int age=cell[x][y].lifeAge;
        Lifeform herb=this.createLife();
        
        if(cell[x][y].lifeAge!=5) {
            nFood=countFood(cell,x,y);
            if(nFood==1||nFood==2) {
            
                choosePosition(cell,x,y);
                i=cell[x][y].birthX;
                j=cell[x][y].birthY;

                cell[i][j].addLife(herb);
                cell[i][j].setBackground(Color.yellow);
                cell[i][j].lifeType="herbi";
                
                cell[x][y].delLife();
                cell[x][y].setBackground(Color.white);
                cell[x][y].lifeType="space";
                cell[x][y].foodType=0;
            }
        }
        if(nFood==1)
            cell[i][j].lifeAge=age;  
    }
    
//    public void move(World world) {
//        daysLeft--;
//        Cell[][] cells = world.getCells();
//        if(daysLeft < 0) cells[row][col] = new Cell();
//        int sides = 8;
//        if(row == 0 || cells[row - 1][col].isHerbivore()) {
//            sides--;
//        }
//        if(row == cells.length - 1 || cells[row + 1][col].isHerbivore()) {
//            sides--;
//        }
//        if(col == 0 || cells[row][col - 1].isHerbivore()) {
//            sides--;
//        }
//        if(col == cells.length - 1 || cells[row][col + 1].isHerbivore()) {
//            sides--;
//        }
//        if(sides == 0) return;
//        int rand = RandomGenerator.nextNumber(sides);
//        int nextDir = 0;
//        int[][] dirs = {{-1, 0},{0, 1},{1, 0},{0, -1}};
//        while(rand >= 0) {
//            if(nextDir == 0 && (row == 0 ||
//                    cells[row - 1][col].isHerbivore()) ||
//                    nextDir == 1 && (col == cells.length - 1 ||
//                    cells[row][col + 1].isHerbivore()) ||
//                    nextDir == 2 && (row == cells.length - 1 ||
//                    cells[row + 1][col].isHerbivore()) ||
//                    nextDir == 3 && (col == 0 ||
//                    cells[row][col - 1].isHerbivore())) {
//                rand = (rand + 1) % 4;
//                continue;
//            }
//            rand++;
//            nextDir++;
//        }
//        
//    }
}
