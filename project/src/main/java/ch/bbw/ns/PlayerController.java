package ch.bbw.ns;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * player controller of player FXML
 *
 * @author Noelle Senti
 */

public class PlayerController {
    @FXML
    private ToggleGroup gender;
    @FXML
    private TextField inputName;


    /**
     * Close window with saving.
     */
    public void handleButtonContinue(ActionEvent event) {
        System.out.println("Continue Button pressed");

        Player player = new Player();

        //Get Gender
        RadioButton genderSelectedToggle = (RadioButton) gender.getSelectedToggle();
        player.setGender(genderSelectedToggle.getId().charAt(0));
        System.out.println("Gender selected and saved: " + genderSelectedToggle.getText());

        //Get Name
        player.setName(inputName.getText());
        System.out.println("Name entered and saved: " + inputName.getText());

        //close window
        ((Node) (event.getSource())).getScene().getWindow().hide();
        System.out.println("Player Editor closed and saved");

        //src: https://stackoverflow.com/questions/27160951/javafx-open-another-fxml-in-the-another-window-with-button
        FXMLLoader loader;
        Parent parent;
        Scene scene;
        GameController gc = new GameController();
        try {
            loader = new FXMLLoader(getClass().getResource("/game.fxml"));
            loader.setController(gc);
            parent = loader.load();

            Stage stage = new Stage();
            stage.setTitle("The Game");
            stage.setScene(new Scene(parent, 450, 450));
            stage.show();
            System.out.println("Game open");

            // Hide this current window (if this is what you want)
            ((Node) (event.getSource())).getScene().getWindow().hide();
            System.out.println("Editor closed");

            GameManager gm = new GameManager(player, gc);
            gc.setManager(gm);
            System.out.println("Create GameManager");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
