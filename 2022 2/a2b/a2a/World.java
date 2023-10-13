package a2b.a2a;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * It holds cells. No wrap around on the world (it’s flat, but nothing 
 * falls off the edge either).  World has a 15% chance to create a 
 * herbivore and a 20% chance to create a plant. Use the RandomGenerator 
 * to generate a number between 0 and 99. Value >=85 generate a herbivore, 
 * value >=65 generate a plant.
 * 
 * @author lizihan
 *
 */
public class World extends JPanel {
    /** initialize cells. */
    Cell cell[][];
    
    /**
     * Constructor hold cells.
     * @param row is row.
     * @param column is column.
     */
    int row;
    int col;
    
    Herbivore h;
    Plant p;
    Carnivore c;
    Omnivore o;
    
    public World() {
        
    }
    
    public World(int row, int col) {
        cell = new Cell[row][col];
        
        this.row=row;
        this.col=col;
//        Cell cells=new Cell(row,col);
    }

    /**
     * initialize world.
     */
    public void init() {
        
        this.setBackground(Color.black);
        this.setLayout(new GridLayout(this.row,this.col,1,1));
        for(int row = 0; row < cell.length; row++) {
            for(int col = 0; col < cell[0].length; col++) {
                int rand = RandomGenerator.nextNumber(100);
                cell[row][col] = new Cell(this,row,col);
              
                if(rand >= 80) {
//                    cell[row][col].setBackground(Color.yellow);
//                    cells[row][col] = new Cell(new Herbivore(row, col));
                    h=new Herbivore(cell);
                    cell[row][col].addLife(h);
                    cell[row][col].lifeType="herbi";
                }
                else if(rand >= 60) {
//                    cells[row][col].setBackground(Color.green);
//                    cells[row][col] = new Cell(new Plant(row, col));
                    p=new Plant(cell);
                    cell[row][col].addLife(p);
                    cell[row][col].lifeType="plant";
                }
                else if(rand >= 50) {
//                    cells[row][col].setBackground(Color.green);
//                    cells[row][col] = new Cell(new Plant(row, col));
                    c=new Carnivore(cell);
                    cell[row][col].addLife(c);
                    cell[row][col].lifeType="carni";
                }
                else if(rand >= 45) {
//                    cells[row][col].setBackground(Color.green);
//                    cells[row][col] = new Cell(new Plant(row, col));
                    o=new Omnivore(cell);
                    cell[row][col].addLife(o);
                    cell[row][col].lifeType="omni";
                }
                else{
//                    cells[row][col].setBackground(Color.white);
//                    cells[row][col] = new Cell();
                    cell[row][col].isLifeform=false;
                    cell[row][col].lifeType="space";
                    cell[row][col].setBackground(Color.white);
                }
                this.add(cell[row][col]);
                
            }
        }
        draw();
        
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                takeTurn();
//                System.out.println(h.test);
            }
        });
    }
    public void update() {
        
    }
    public void draw() {        
        for(int row = 0; row < cell.length; row++) {
            for(int col = 0; col < cell[0].length; col++) {
                if(cell[row][col].isLifeform) {
                    if(cell[row][col].lifeType=="herbi")
                        cell[row][col].setBackground(Color.yellow);
                    else if(cell[row][col].lifeType=="plant")
                        cell[row][col].setBackground(Color.green);
                    else if(cell[row][col].lifeType=="carni")
                        cell[row][col].setBackground(Color.red);
                    else if(cell[row][col].lifeType=="omni")
                        cell[row][col].setBackground(Color.blue);
                    else
                        cell[row][col].setBackground(Color.white);
                    
                    
                } 
            }
        }
    }
    
    public void takeTurn() {
//        Herbivore h;
//        Plant p;
//        Carnivore c;
//        Omnivore o;
        
        for(int i = 0; i < this.row; i++) {
            for(int j = 0; j < this.col; j++) {
                if(cell[i][j].isLifeform&&cell[i][j].lifeType!="plant") {
                    cell[i][j].lifeAge--;
                }
            }
            
        }
        for(int i = 0; i < this.row; i++) {
            for(int j = 0; j < this.col; j++) {
                if(cell[i][j].isLifeform) {
                    if(cell[i][j].lifeType=="herbi") {
                        h.giveBirth(i,j);
                        h.move(i,j);
                    }
                    if(cell[i][j].lifeType=="plant")
                        p.giveBirth(i,j);
                    if(cell[i][j].lifeType=="carni") {
                        c.giveBirth(i,j);
                        c.move(i,j);
                    }
                    if(cell[i][j].lifeType=="omni") {
                        o.giveBirth(i,j);
                        o.move(i,j);
//                        System.out.println("this");
                    }
                }    
            }
        }
    }
    
    public Cell[][] getCells() {return cell;}
    
    /**
     * Constructor hold cells.
     * @param cell is the coordinate of the cell.
     */
    public void takeSnapshot(Cell cell[][]) {
    }

}
