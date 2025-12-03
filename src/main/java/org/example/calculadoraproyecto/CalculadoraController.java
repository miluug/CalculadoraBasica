
package org.example.calculadoraproyecto;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class CalculadoraController {

    @FXML
    private TextField resultado;

    private int firstNumber = 0;
    private String operator = "";
    private boolean startNew = true;

    // CUANDO TOCAS UN NÚMERO
    @FXML
    private void onNumberClick(ActionEvent e) {
        Button b = (Button) e.getSource();
        String value = b.getText();

        if (startNew) {
            resultado.setText(value);
            startNew = false;
        } else {
            resultado.setText(resultado.getText() + value);
        }
    }

    // CUANDO TOCAS UN OPERADOR (+, -, x, /)
    @FXML
    private void onOperatorClick (ActionEvent e) {
        Button b = (Button) e.getSource();
        operator = b.getText();
        firstNumber = Integer.parseInt(resultado.getText());
        startNew = true;
    }

    // CUANDO TOCAS " = "
    @FXML
    private void onEqualsClick (ActionEvent e) {
        int secondNumber = Integer.parseInt(resultado.getText());
        int result = 0;

        switch (operator) {
            case "+": result = firstNumber + secondNumber; break;
            case "-": result = firstNumber - secondNumber; break;
            case "x": result = firstNumber * secondNumber; break;
            case "/": result = secondNumber != 0 ? firstNumber / secondNumber : 0; break;
        }

        resultado.setText(String.valueOf(result));
        startNew = true;
    }

    // BORRAR TODO
    @FXML
    private void onClearClick(ActionEvent e) {
        resultado.setText("");
        firstNumber = 0;
        operator = "";
        startNew = true;
    }
}