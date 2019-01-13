package flowfree;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class FXMLFlowBoardController {
    
    private View view;
    
    private Model model;
    
    @FXML
    private AnchorPane pane; 
      
    @FXML
    private Label lbllabel;

    @FXML
    private Button btnlvl1;

    @FXML
    private Button btnlvl2;
    
    @FXML
    private Button btnwhite;

    @FXML
    private Button btnblack;
    
    @FXML
    private AnchorPane panestart;

    @FXML
    private Button btnstart;
    
    @FXML
    private Label lblintro;
    
    @FXML
    private ImageView image;
    
    @FXML
    private Button btninfo;

    @FXML
    private Button btnback;
     
    @FXML
    private Label lblwelklevel;
    
    @FXML
    private Button btnSettings;
    
    @FXML
    private Label lblkleurachtergrond;
 
    public void initialize() {

        image = new ImageView("/flowfree/fotoflow.png");
        update();
        
        panestart.getChildren().add(image);
        
        btnlvl1.setVisible(false);
        btnlvl2.setVisible(false);
        btnback.setVisible(false);
        lblkleurachtergrond.setVisible(false);
        btnwhite.setVisible(false);
        btnblack.setVisible(false);
        lblwelklevel.setVisible(false);
        
        lblintro.setVisible(false);
               
        btnlvl1.setOnAction(evt -> levelUp());
        btnlvl2.setOnAction(evt -> levelDown());
        btnstart.setOnAction(evt -> start());
        btninfo.setOnAction(evt -> info());
        btnback.setOnAction(evt -> back());
        btnSettings.setOnAction(evt -> settings());
    }   
    
    int d = 0;
    private void levelUp(){
        d = d+1;
        model.goToLevel(d);
        updatewelklevel();
    }
    
    public void updatewelklevel(){
        lblwelklevel.setText("Level: " + d);
    }
    
    private void levelDown(){
        d = d-1;
        model.goToLevel(d);
        updatewelklevel();
    }
    
    public void update(){
        image.setX(95);
        image.setY(120); 
    }
    
    private void start(){
        view  = new View();
        model = new Model(view);
        
        pane.getChildren().add(view);
        model.goToLevel(0);
        
        btnlvl1.setVisible(true);
        btnlvl2.setVisible(true);
        
        lblintro.setVisible(true);
        lblwelklevel.setVisible(true);
        
        btnstart.setVisible(false);
        btninfo.setVisible(false);
        btnSettings.setVisible(false);
        
        image.setVisible(false);
        
        updatewelklevel();
    }
    
    private void info(){
        
        btnlvl1.setVisible(false);
        btnlvl2.setVisible(false);
        btnstart.setVisible(false);
        btninfo.setVisible(false);
        btnSettings.setVisible(false);
        
        image.setVisible(false);
        
        btnback.setVisible(true);
        
        lbllabel.setText(informatie);
    }
    
    private void settings(){
       
        btnback.setVisible(true);
        
        btnlvl1.setVisible(false);
        btnlvl2.setVisible(false);
        image.setVisible(false);
        btninfo.setVisible(false);
        btnSettings.setVisible(false);
        btnstart.setVisible(false);
    
        lblkleurachtergrond.setVisible(true);
        btnwhite.setVisible(true);
        btnblack.setVisible(true);
    
        btnwhite.setOnAction(evt -> white());
        btnblack.setOnAction(evt -> black());
    }

    
    private void back(){
        
        image.setVisible(true);
        btnstart.setVisible(true);
        btninfo.setVisible(true);
        btnSettings.setVisible(true);
        
        btnback.setVisible(false);
        lbllabel.setText("");
        lblkleurachtergrond.setVisible(false);
        btnwhite.setVisible(false);
        btnblack.setVisible(false);
    }
    
    private void white(){
        panestart.setStyle("-fx-background-color: white;");
        pane.setStyle("-fx-background-color: white;")  ;  
        lblkleurachtergrond.setTextFill(Color.BLACK);
        lbllabel.setTextFill(Color.BLACK);
        lblwelklevel.setTextFill(Color.BLACK);
    }
    
    private void black(){
        panestart.setStyle("-fx-background-color: black;");
        pane.setStyle("-fx-background-color: black;"); 
        lblkleurachtergrond.setTextFill(Color.WHITE);
        lbllabel.setTextFill(Color.WHITE);
        lblwelklevel.setTextFill(Color.WHITE);
    }
    
    private static final String informatie=
        "Dit programma werkt gemaakt door:\n" +
        "Manu Kranzen,\n"+
        "Tim Severijns,\n"+
        "Jan De Visscher\n"+
        "Met behulp van de volgende bronnen:";
    }

