package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;


public class Controller {

    @FXML GridPane gameBoard;
    @FXML Button b1;
    @FXML Button b2;
    @FXML Button b3;
    @FXML Button b4;
    @FXML Button b5;
    @FXML Button b6;
    @FXML Button b7;
    @FXML Button b8;
    @FXML Button b9;

    private boolean isFirstPlayer = true;

    public void buttonClickHandler (ActionEvent evt) {

        Button clickedButton = (Button) evt.getTarget();
        String buttonLabel = clickedButton.getText();

        if ("".equals(buttonLabel) && isFirstPlayer) {
            clickedButton.setText("X");
            isFirstPlayer = false;
        } else if ("".equals(buttonLabel)) {
            clickedButton.setText("O");
            isFirstPlayer = true;
        }
        findThreeInARow();
    }

    private void findThreeInARow(){
        //Row 1
        if (!"".equals(b1.getText()) && b1.getText().equals(b2.getText())
                && b2.getText().equals(b3.getText())) {
                highlightWinningCombo(b1, b2, b3);
        }
        //Row 2
        if (!"".equals(b4.getText()) && b4.getText().equals(b5.getText())
                && b5.getText().equals(b6.getText())) {
                highlightWinningCombo(b4, b5, b6);
        }
        //Row 3
        if (!"".equals(b7.getText()) && b7.getText().equals(b8.getText())
                && b8.getText().equals(b9.getText())) {
                highlightWinningCombo(b7, b8, b9);
        }
        //Column 1
        if (!"".equals(b1.getText()) && b1.getText().equals(b4.getText())
                && b4.getText().equals(b7.getText())) {
                highlightWinningCombo(b1, b4, b7);
        }
        //Column 2
        if (!"".equals(b2.getText()) && b2.getText().equals(b5.getText())
                && b5.getText().equals(b8.getText())) {
                highlightWinningCombo(b2, b5, b8);
        }
        //Column 3
        if (!"".equals(b3.getText()) && b3.getText().equals(b6.getText())
                && b6.getText().equals(b9.getText())) {
                highlightWinningCombo(b3, b6, b9);
        }
        //Diagonal 1
        if (!"".equals(b1.getText()) && b1.getText().equals(b5.getText())
                && b5.getText().equals(b9.getText())) {
                highlightWinningCombo(b1, b5, b9);
        }
        //Diagonal 2
        if (!"".equals(b3.getText()) && b3.getText().equals(b5.getText())
                && b5.getText().equals(b7.getText())) {
                highlightWinningCombo(b3, b5, b7);
        }

    }

    private void highlightWinningCombo(Button first, Button second, Button third) {
        first.getStyleClass().add("winning-button");
        second.getStyleClass().add("winning-button");
        third.getStyleClass().add("winning-button");

    }

    public void menuClickHandler(ActionEvent evt) {
        MenuItem clickedMenuItem = (MenuItem) evt.getTarget();
        String menuLabel = clickedMenuItem.getText();

        if ("Play".equals(menuLabel)) {
            ObservableList<Node> buttons = gameBoard.getChildren();

            buttons.forEach(btn -> {
                ((Button) btn).setText("");
                btn.getStyleClass().remove("winning-button");

            });
            isFirstPlayer = true;
        }
    }

}
