package com.example;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class MetricConverterGUI {

    public static void setupGUI(VBox layout) {
        // Labels, TextField, and Button to handle user input and display results
        Label welcomeLabel = new Label("Welcome to Metric Converter!!!");
        Label instructionLabel = new Label("Please input your conversion (e.g., '1 km = mi').");
        TextField inputField = new TextField();
        Button convertButton = new Button("Convert");
        Label resultLabel = new Label(); // Displays the result
        Label exitLabel = new Label("Enter '-1' to exit.");

        // Event handler for the convert button
        convertButton.setOnAction(e -> {
            String userInput = inputField.getText();
            if ("-1".equals(userInput)) {
                resultLabel.setText("Exiting the program. Goodbye!");
                inputField.setDisable(true); // Disable input field after exit
                convertButton.setDisable(true); // Disable the button after exit
            } else {
                String result = processConversion(userInput);
                resultLabel.setText(result);
            }
        });

        // Add all components to the layout
        layout.getChildren().addAll(welcomeLabel, instructionLabel, inputField, convertButton, resultLabel, exitLabel);
    }

    private static String processConversion(String userInput) {
        // Conversion logic based on user input
        switch (userInput) {
            case "1 in = cm":
                return "1 in = 2.54 cm";
            case "1 ft = in":
                return "1 ft = 12 in";
            case "1 ft = mi":
                return "1 mi = 5280 ft";
            case "1 yd = ft":
                return "1 yd = 3 ft";
            case "1 mi = yd":
                return "1 mi = 1760 yd";
            case "1 cm = in":
                return "1 cm = 0.3937 in";
            case "1 m = ft":
                return "1 m = 3.2808 ft";
            case "1 mm = in":
                return "1 mm = 0.03937 in";
            case "1 km = mi":
                return "1 km = 0.62137 mi";
            default:
                return "Sorry, we do not have that conversion available, or we don't recognize that input.";
        }
    }
}
