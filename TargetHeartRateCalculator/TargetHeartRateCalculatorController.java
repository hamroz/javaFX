package sample.TargetHeartRateCalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.MathContext;

public class TargetHeartRateCalculatorController {

    @FXML
    private Label ageLabel;

    @FXML
    private TextField yearTextField;

    @FXML
    private TextField targetHeartRateRangeTextField;

    @FXML
    private Button calculateButton;

    @FXML
    private Label targetHeartRateRangeLabel;


    @FXML
    void calculateButtonPressed(ActionEvent event) {
        try {
            BigDecimal age = new BigDecimal(yearTextField.getText());
            if (age.compareTo(new BigDecimal(0)) <= 0) {
                throw new NumberFormatException();
            }
            BigDecimal maximumHeartRate = new BigDecimal(200).subtract(age);
            BigDecimal heartRateLower = maximumHeartRate.multiply(new BigDecimal("0.50")).round(new MathContext(4));
            BigDecimal heartRateUpper = maximumHeartRate.multiply(new BigDecimal("0.85")).round(new MathContext(4));


            String ans = String.format("%s bpm - %s bpm", heartRateLower.toString(), heartRateUpper.toString());
            targetHeartRateRangeTextField.setText(ans);

        } catch (NumberFormatException ex) {
            yearTextField.setText("Enter your Age");
            yearTextField.selectAll();
            yearTextField.requestFocus();
        }

    }

}