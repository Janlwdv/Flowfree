/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowfree;

import com.google.gson.Gson;
import java.util.ArrayList;

/**
 *
 * @author GESE
 */
public class Level {
    private int sizeGrid;
    private ArrayList<Combination> combinations;

    public int getSizeGrid() {
        return sizeGrid;
    }

    public ArrayList<Combination> getCombinations() {
        return combinations;
    }
    
    public Level clone() {
        try {
            Gson gson = new Gson();
            return gson.fromJson(gson.toJson(this, Level.class), Level.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
