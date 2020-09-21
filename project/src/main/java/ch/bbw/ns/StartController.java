package ch.bbw.ns;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * start menu controller of start FXML
 *
 * @author Noelle Senti
 */

public class StartController {
    /**
     * Open help window
     */
    public void handleButtonHelp(ActionEvent event) {
        System.out.println("Start Button pressed");
        //src: https://stackoverflow.com/questions/27160951/javafx-open-another-fxml-in-the-another-window-with-button
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/help.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Help");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            System.out.println("Help open");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * open person editor, before starting game
     */
    public void handleButtonStart(ActionEvent event) {
        System.out.println("Person Button pressed");
        //src: https://stackoverflow.com/questions/27160951/javafx-open-another-fxml-in-the-another-window-with-button
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/player.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Player Editor");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            System.out.println("Player Editor open");

            //Hide Window
            ((Node) (event.getSource())).getScene().getWindow().hide();
            System.out.println("Start Menu closed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
