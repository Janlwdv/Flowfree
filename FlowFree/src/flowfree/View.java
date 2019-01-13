/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowfree;

import java.util.ArrayList;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author GESE
 */
public class View extends Pane{
    private Color[] colors = {Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, Color.ORANGE};
    
    public View () {

    }

    public void draw(Level level) {
        getChildren().clear();
        int size = level.getSizeGrid();
        
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                Rectangle r = new Rectangle(x*(500/size)+5, y*(500/size)+5,(500-size)/size, (500-size)/size);
                r.setFill(Color.BLACK);
                r.setStroke(Color.GREY);
                getChildren().add(r);
            }
        }
        
        for (int i = 0; i < level.getCombinations().size(); i++) {
            Combination comb = level.getCombinations().get(i);
            Circle c1 = new Circle(500/(2*size)+5+comb.getX1()*(500/size), 500/(2*size)+5+comb.getY1()*(500/size), (200/size));
            c1.setFill(colors[i]);
            Circle c2 = new Circle(500/(2*size)+5+comb.getX2()*(500/size), 500/(2*size)+5+comb.getY2()*(500/size),(200/size) );
            c2.setFill(colors[i]);
            getChildren().addAll(c1, c2);
        }
        
    }
}
