/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowfree;

/**
 *
 * @author GESE
 */
public class Model {
    private Levels levels;
    private View view;
    
    public Model(View view) {
        levels = Levels.createFromJSON("src/levels.json");
        this.view = view;
    }
    
    public void goToLevel(int l) {
        Level level = levels.getLevel(l);
        view.draw(level);
    }
}
