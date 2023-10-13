package a2b.a2a;
import javax.swing.*;
import java.awt.*;
import java.lang.String;


/**
 * Each lifeform is a Herbivore or a Plant.
 * @author lizihan
 *
 */

public abstract class Lifeform  {

    Cell[][] cell;  
    
    public Lifeform() {
        
    }
    
    public Lifeform(Cell[][] cell) {
    this.cell=cell;
//        cell=world.getCells();
        
    }
    
    public char[] getNeighbors(Cell[][] cell,int x,int y) {
        int width=cell.length;
        int high=cell[0].length;
        
        if(y==0) {
                cell[x][y].neighbors[0]='x';
                cell[x][y].neighbors[1]='x';
                cell[x][y].neighbors[2]='x';
                if(x==0) {
                    cell[x][y].neighbors[6]='x';
                    cell[x][y].neighbors[7]='x';
                    cell[x][y].neighbors[3]=cell[x+1][y].lifeType.charAt(0);
                    cell[x][y].neighbors[4]=cell[x+1][y+1].lifeType.charAt(0);
                    cell[x][y].neighbors[5]=cell[x][y+1].lifeType.charAt(0);
                }
                else if(x==(high-1)) {
                    cell[x][y].neighbors[3]='x';
                    cell[x][y].neighbors[4]='x';    
                    cell[x][y].neighbors[5]=cell[x][y+1].lifeType.charAt(0);
                    cell[x][y].neighbors[6]=cell[x-1][y+1].lifeType.charAt(0);
                    cell[x][y].neighbors[7]=cell[x-1][y].lifeType.charAt(0);
                 }
                else {
                    cell[x][y].neighbors[3]=cell[x+1][y].lifeType.charAt(0);
                    cell[x][y].neighbors[4]=cell[x+1][y+1].lifeType.charAt(0);
                    cell[x][y].neighbors[5]=cell[x][y+1].lifeType.charAt(0);
                    cell[x][y].neighbors[6]=cell[x-1][y+1].lifeType.charAt(0);
                    cell[x][y].neighbors[7]=cell[x-1][y].lifeType.charAt(0);
            }    
        }
        else if(y==(width-1)) {
            cell[x][y].neighbors[4]='x';
            cell[x][y].neighbors[5]='x';
            cell[x][y].neighbors[6]='x';
            if(x==0) {
                cell[x][y].neighbors[0]='x';
                cell[x][y].neighbors[7]='x';
                cell[x][y].neighbors[1]=cell[x][y-1].lifeType.charAt(0);
                cell[x][y].neighbors[2]=cell[x+1][y-1].lifeType.charAt(0);
                cell[x][y].neighbors[3]=cell[x+1][y].lifeType.charAt(0);
            }
            else if(x==(high-1)) {
                cell[x][y].neighbors[2]='x';
                cell[x][y].neighbors[3]='x';
                cell[x][y].neighbors[0]=cell[x-1][y-1].lifeType.charAt(0);
                cell[x][y].neighbors[1]=cell[x][y-1].lifeType.charAt(0);
                cell[x][y].neighbors[7]=cell[x-1][y].lifeType.charAt(0);
            }
            else {
            cell[x][y].neighbors[0]=cell[x-1][y-1].lifeType.charAt(0);
            cell[x][y].neighbors[1]=cell[x][y-1].lifeType.charAt(0);
            cell[x][y].neighbors[2]=cell[x+1][y-1].lifeType.charAt(0);
            cell[x][y].neighbors[3]=cell[x+1][y].lifeType.charAt(0);
            cell[x][y].neighbors[7]=cell[x-1][y].lifeType.charAt(0);
            }    
        }
        else if(x==0) {
            cell[x][y].neighbors[0]='x';
            cell[x][y].neighbors[1]=cell[x][y-1].lifeType.charAt(0);
            cell[x][y].neighbors[2]=cell[x+1][y-1].lifeType.charAt(0);
            cell[x][y].neighbors[3]=cell[x+1][y].lifeType.charAt(0);
            cell[x][y].neighbors[4]=cell[x+1][y+1].lifeType.charAt(0);
            cell[x][y].neighbors[5]=cell[x][y+1].lifeType.charAt(0);
            cell[x][y].neighbors[6]='x';
            cell[x][y].neighbors[7]='x';
                
        }
        else if(x==(high-1)) {
            cell[x][y].neighbors[0]=cell[x-1][y-1].lifeType.charAt(0);
            cell[x][y].neighbors[1]=cell[x][y-1].lifeType.charAt(0);
            cell[x][y].neighbors[2]='x';
            cell[x][y].neighbors[3]='x';
            cell[x][y].neighbors[4]='x';
            cell[x][y].neighbors[5]=cell[x][y+1].lifeType.charAt(0);
            cell[x][y].neighbors[6]=cell[x-1][y].lifeType.charAt(0);
            cell[x][y].neighbors[7]=cell[x-1][y].lifeType.charAt(0);
                
        }
        else {
            cell[x][y].neighbors[0]=cell[x-1][y-1].lifeType.charAt(0);
            cell[x][y].neighbors[1]=cell[x][y-1].lifeType.charAt(0);
            cell[x][y].neighbors[2]=cell[x+1][y-1].lifeType.charAt(0);
            cell[x][y].neighbors[3]=cell[x+1][y].lifeType.charAt(0);
            cell[x][y].neighbors[4]=cell[x+1][y+1].lifeType.charAt(0);
            cell[x][y].neighbors[5]=cell[x][y+1].lifeType.charAt(0);
            cell[x][y].neighbors[6]=cell[x-1][y+1].lifeType.charAt(0);
            cell[x][y].neighbors[7]=cell[x-1][y].lifeType.charAt(0);
        }
        
        return cell[x][y].neighbors;
    }
    
//    public Lifeform createLife(){
//        return new Lifeform(cell);
//    }
    public abstract void giveBirth(int x,int y);
    
    public abstract void move(int x,int y); //{
//        int i=0;
//        int j=0;
//        int nFood;
//        Lifeform life=new Lifeform(cell);
//        if(cell[x][y].lifeAge!=5) {
//            nFood=countFood(x,y);
//            if(nFood==0) {
//                i=x;
//                j=y;
//            }
//            if(nFood==1) {
//                choosePosition(cell,x,y);
//                i=cell[x][y].birthX;
//                j=cell[x][y].birthY;
////                                h=new Herbivore(cell);
////                                herb=this.createLife();
//                cell[i][j].addLife(herb);
//                cell[i][j].setBackground(Color.yellow);
//                cell[i1][j1].lifeType="herbi";
////                            cell[i1][j1].lifeAge=5;
////                            System.out.print("c"+i1+j1+" ");
//            }
//        }
        
//    }
    int countFood(Cell[][] cell,int x,int y) {              //0:无移动和食物，1:移动，2:食物
        char[]nei=getNeighbors(cell,x,y);
//        System.out.println("nei"+nei[0]+nei[1]+nei[2]+nei[3]+nei[4]+nei[5]+nei[6]+nei[7]);
        int nFree=0;
        int nPlant=0;
        int nHerb=0;
        int nCarn=0;
        int nOmn=0;
        for(int i=0;i<8;i++) {
            if(nei[i]=='s')
                nFree++;
            if(nei[i]=='p')
                nPlant++;
            if(nei[i]=='h')
                nHerb++;
            if(nei[i]=='c')
                nCarn++;
            if(nei[i]=='o')
                nOmn++;
        }
        if(cell[x][y].lifeType=="herbi") {
            if(nPlant>0) {
                cell[x][y].foodType=1;
                return 2;
            }
            else if(nFree>0)
                return 1;
            else
                return 0;
        }
        else if(cell[x][y].lifeType=="carni") {
            if(nHerb>0||nOmn>0){
                cell[x][y].foodType=2;
                return 2;
            }
            else if(nFree>0)
                return 1;
            else
                return 0;
        }
        else if(cell[x][y].lifeType=="omni") {
            if(nPlant>0||nHerb>0||nCarn>0){
                cell[x][y].foodType=3;
                return 2;
            }
            else if(nFree>0)
                return 1;
            else
                return 0;
        }
        else return 0;
    }
    void choosePosition(Cell[][] cell,int x1,int y1){
        int x2=0;
        int y2=0;
        int num=0;
        if(cell[x1][y1].foodType==0) {
            for(int i=0;i<8;i++) {
                if(cell[x1][y1].neighbors[i]=='s') {
                    num=i;
                    break;
                }
            }
        }
        if(cell[x1][y1].foodType==1) {
            for(int i=0;i<8;i++) {
                if(cell[x1][y1].neighbors[i]=='p') {
                    num=i;
                    break;
                }
            }
        }
        if(cell[x1][y1].foodType==2) {
            for(int i=0;i<8;i++) {
                if(cell[x1][y1].neighbors[i]=='h'||cell[x1][y1].neighbors[i]=='o') {
                    num=i;
                    break;
                }
            }
        }
        if(cell[x1][y1].foodType==3) {
            for(int i=0;i<8;i++) {
                if(cell[x1][y1].neighbors[i]=='h'||cell[x1][y1].neighbors[i]=='p'||cell[x1][y1].neighbors[i]=='c') {
                    num=i;
                    break;
                }
            }
        }
        if(num==0) {
            x2=x1-1;
            y2=y1-1;
        }
        if(num==1) {
            x2=x1;
            y2=y1-1;
        }
        if(num==2) {
            x2=x1+1;
            y2=y1-1;
        }
        if(num==3) {
            x2=x1+1;
            y2=y1;
        }
        if(num==4) {
            x2=x1+1;
            y2=y1+1;
        }
        if(num==5) {
            x2=x1;
            y2=y1+1;
        }
        if(num==6) {
            x2=x1-1;
            y2=y1+1;
        }
        if(num==7) {
            x2=x1-1;
            y2=y1;
        }
        cell[x1][y1].birthX=x2;
        cell[x1][y1].birthY=y2;
//        System.out.println("x"+x1+" y"+y1+" num"+num+" type"+cell[x1][y1].foodType+" x"+x2+" y"+y2);
    }
    
}
