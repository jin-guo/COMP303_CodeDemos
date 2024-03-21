package ca.mcgill.cs.swdesign.m8.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class LuckyNumberCoupled extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Lucky Number");
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(20));

        Slider slider = new Slider(1, 10, 5);
        TextField textNumber = new TextField();
        TextField textSpell = new TextField();



        root.add(slider, 0, 0, 1, 1);
        root.add(textNumber, 0, 1, 1, 1);
        root.add(textSpell, 0, 2, 1, 1);

        slider.valueProperty().addListener((pValue, pOld, pNew)-> {textNumber.setText(String.valueOf(pNew));});





        stage.setScene(new Scene(root));
        stage.show();
    }
}
