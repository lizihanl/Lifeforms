package a2b.a2a;
import javax.swing.*;

/**
 * It can hold a Plant or a Herbivore or nothing. 
 * Represented as a square in the world.
 * @author lizihan
 *
 */
public class Cell extends JPanel{          // extends JPanel

    /**
     * Constructor of a cell.
     */
    
    int row, col;
    World world;
    Lifeform lifeform;
//    Lifeform arrCell[][];
    boolean isLifeform;
    String lifeType;
    String lifeColor;
    int lifeAge;
    int foodType;//出生/食物/移动选择位置参数：0:出生或移动，1:食草动物，2:食肉动物，3杂食动物
    int birthX;
    int birthY;
    char[] neighbors=new char[8];
//    邻居用长度8的一维数组表示：  0----左上（x-1，y-1）
//                             1---左（x-1，y）
//                             2---左下（x+1，y+1）
//                             3---下（x，y+1）
//                             4---右下（x-1，y+1）
//                             5---右（x+1，y）
//                             6---右上（x-1，y-1）
//                             7---上（x，y-1）
//          值（字符）表示品种：   x---边缘
//                             p---植物
//                             h---食草动物
//                             c---食肉动物
//                             o---杂食动物
//                             s---空
    
    public Cell(World world,int row,int col) {
        this.row=row;
        this.col=col;
        this.world=world;
//        Lifeform arrCell[][];
      
    }
//    public Cell(Lifeform lifeform) {
//        this.lifeform = lifeform;
//    }
//    public Cell() {
//        lifeform = null;
//    }
    
    public void addLife(Lifeform lifeform) {
        isLifeform=true;
//        lifeType=null;
        lifeAge=5;
        foodType=0;
        
    }
    public void delLife() {
        isLifeform=false;
        lifeAge=0;    
    }
    
    public boolean isHerbivore() {return (lifeform instanceof Herbivore);}
    public boolean isPlant() {return (lifeform instanceof Plant);}
    public boolean isEmpty() {return lifeform == null;}
    public Lifeform getLifeform() {return lifeform;}
    public void setLifeform(Lifeform lifeform) {this.lifeform = lifeform;}
}
