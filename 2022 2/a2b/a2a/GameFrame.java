package a2b.a2a;
//import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

/**
 * controls turns, initializes the World including first rendering.
 * @author lizihan
 *
 */

public class GameFrame extends JFrame{
    /** initialize world. */
    World world;
    
    /**
     * Constructor hold cells.
     * @param world is a new World.
     */
    public GameFrame() {
        
    }
    
    public GameFrame(World world) {
//        world = new World(0, 0);
         this.world = world;   
    }

    /**
     * initialize game.
     */
    public void init() {
//        world.init();
//    GridLayout gl=new GridLayout(25,25,10,10) ;
//
//    this.setLayout(gl);
//    JPanel panel=new JPanel(gl);
//    this.add(panel);
//    JPanel content = new JPanel(new GridLayout(25,25,1,1));
//    content.setBackground(Color.BLACK);
        this.setTitle("game");
//        World world = new World();
        
        
//        this.setLayout(null);
//    this.setContentPane(new World(25,25));
    this.add(this.world);

//    for (int i = 0; i < 25*25; ++i) {
//      JPanel world = new JPanel();
//      world.setBackground(Color.green);  //( i % 2 == i/25 % 2 ? Color.RED : Color.BLUE);
//      content.add(world);
//    }
//    this.add(ContentPane);
    }
//    
    /**
     * Constructor hold cells.
     */
    public void turn() {
        
    }

}
