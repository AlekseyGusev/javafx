package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Optional;

public class Controller {

    @FXML
    public TextField displayField;

    double previousNumber = 0;
    double currentNumber = 0;
    double result;
    String operation = "";
    public boolean flag = true;

    public void processDigitButtons(ActionEvent evt) {
        if(flag) {
            displayField.setText("");
            flag = false;
        }
        String digitLabel = ((Button)evt.getSource()).getText();
        displayField.setText(displayField.getText() + digitLabel);
    }

    public void processOperationButtons(ActionEvent evt) {
        String operationLabel = ((Button)evt.getSource()).getText();

        if (!"=".equals(operationLabel)) {
            if (!operation.isEmpty()) {
                return;
            }
            operation = operationLabel;
            previousNumber = Double.parseDouble(displayField.getText());
            displayField.setText("");
        } else {
            if (operation.isEmpty()) {
                return;
            }
            currentNumber = Double.parseDouble(displayField.getText());
            result = calculate(previousNumber, currentNumber, operation);
            displayField.setText(String.valueOf(result));
            operation = "";
            flag = true;
        }

    }

    public void concatDot (){
        displayField.setText(displayField.getText().concat("."));
    }

    public double calculate(double previousNumber, double currentNumber, String operation) {
        switch (operation) {
            case "+":
                return previousNumber + currentNumber;
            case "-":
                return previousNumber - currentNumber;
            case "*":
                return previousNumber * currentNumber;
            case "/":
                if (currentNumber == 0) {
                    return 0;
                }
                return previousNumber / currentNumber;
            default:
                return 0;
        }
    }

    public void clearTextField() {
        displayField.setText("");
        previousNumber = 0;
        currentNumber = 0;
        result = 0;
    }
    public void deleteLastDigit() {
        String enterText = displayField.getText();
        String textWithoutLastChar = Optional.ofNullable(enterText)
                .map(str -> str.replaceAll(".$", ""))
                .orElse("");
        displayField.setText(textWithoutLastChar);
    }

}
