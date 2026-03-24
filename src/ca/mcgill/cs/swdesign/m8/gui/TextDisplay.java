package ca.mcgill.cs.swdesign.m8.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
 
public class TextDisplay extends Application {
	private static final int Width = 300;
	private static final int Height = 150;
	private static final int GAP = 10;
	private static final int MARGIN = 20;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World");
        GridPane root = new GridPane();
    	root.setHgap(GAP);
    	root.setVgap(GAP);
    	root.setPadding(new Insets(MARGIN));
        Scene scene = new Scene(root, Width, Height);

        Text aText = new Text();
        aText.setFont(new Font(20));
        aText.setWrappingWidth(Width-4*GAP);
        aText.setTextAlignment(TextAlignment.JUSTIFY);
		aText.setText("Waiting for your input.");


		TextField aTextInput = new TextField();
		aTextInput.setMinWidth(200);
		aTextInput.setText("Enter text here ....");
		aTextInput.setOnAction(new EventHandler<ActionEvent>(){
			        @Override
			        public void handle(ActionEvent actionEvent)
			        {
			            aText.setText(aTextInput.getText());
			        }
	    		});

		
        Button btn = new Button();
        btn.setLayoutX(100);
        btn.setLayoutY(80);
        btn.setText("Enter");
        btn.setOnAction(actionEvent -> aText.setText(aTextInput.getText()));
//        btn.setOnMousePressed(actionEvent -> aText.setText("Mouse Pressed!"));
//        btn.setOnMouseReleased(actionEvent -> aText.setText("Mouse Released!"));


        root.add(aTextInput, 0,0,6,1);
        root.add(btn, 6,0,1,1);
        root.add(aText,0,3,4,1);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
