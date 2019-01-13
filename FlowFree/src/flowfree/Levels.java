/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowfree;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author GESE
 */
public class Levels {
    
    private ArrayList<Level> levels;
    
    public static Levels createFromJSON(String filename) {
        Levels levels = null;
        try {
            JsonReader reader = new JsonReader(new FileReader(filename));
            
            Gson gson = new Gson();
            levels = gson.fromJson(reader, Levels.class);
        } catch(FileNotFoundException ex) {
            
        }
        return levels;
    }
    
    public Level getLevel(int level) {
        return this.levels.get(level).clone();
    }
    
    public int size() {
        return levels.size();
    }
}
