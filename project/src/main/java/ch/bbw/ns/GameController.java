package ch.bbw.ns;

import ch.bbw.ns.CommandException;
import ch.bbw.ns.Manager;
import ch.bbw.ns.items.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * controller of game FXML
 *
 * @author Noelle Senti
 */

public class GameController {
    //PRIVATE!!!!
    @FXML
    private Label outputRoom, outputTask;
    @FXML
    private TextField input;
    @FXML
    private VBox outputGame;
    @FXML
    private GridPane inventory;

    private Manager manager;

    public GameController() {
        System.out.println("create GameController");
    }


    public void setManager(Manager manager) {
        this.manager = manager;
    }

    /**
     * Send button has been pressed
     */
    @FXML
    public void handleButtonSend(ActionEvent event) {
        String newCommand = input.getText();
        input.clear();
        showText(newCommand, "#000");

        //forward message to some kind of Manager
        manager.newCommand(newCommand.trim().toLowerCase());
    }

    /**
     * Opens help, when pressing the menu button 'help'
     *
     * @param event
     */
    @FXML
    public void handleMenuHelp(ActionEvent event) {
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
     * shows response in outputGame
     *
     * @param response from game
     */
    public void outputAnswer(String response) {
        showText(response, "#0F0");
    }

    /**
     * refreshes item list
     *
     * @param items
     */
    public void refreshInventory(ArrayList<Item> items) {
        int a = 0;
        for (int i = 0; i > 2; i++) {
            for (int j = 0; j > 4; j++) {
                items.get(a).getName();
            }
        }
    }

    /**
     * item is temoved from inventory
     *
     * @param item
     */
    public void deleteFromInventory(String item) {

    }


    /**
     * description of room in outputRoom gets changed
     *
     * @param room new room description
     */
    public void newRoom(String room) {
        outputRoom.setText(room);
    }

    /**
     * new task gets shown in outputTask
     *
     * @param task new task
     */
    public void newTask(String task) {
        outputTask.setText(task);
    }

    public void showError(CommandException e) {
        showText(e.getMessage(), "#F00");
    }

    private void showText(String text, String color) {
        Label l = new Label(text);
        l.setWrapText(true);
        l.setTextFill(Color.web(color));
        outputGame.getChildren().add(l);
    }

    public void update() {
        int a = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                if(a < manager.getItems().size()) {
                    Label l = new Label();
                    l.setText(manager.printItem(a));
                    inventory.add(l, i, j);
                }
                a++;
            }
        }

        outputRoom.setText(manager.getCurrentRoom());
    }
}
