package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create UI components
        Label welcomeLabel = new Label("Welcome to Metric Converter!");
        Label instructionsLabel = new Label("Please input your conversion. For example, '1 km = m'.");
        
        // Instructions for how to exit the program
        Label exitInstructionLabel = new Label("Enter '-1' to exit the program.");

        TextArea exampleTextArea = new TextArea();
        exampleTextArea.setEditable(false);
        exampleTextArea.setText("Here are some example conversions:\n" +
                "1 in = cm\n" +
                "1 ft = in\n" +
                "1 ft = mi\n" +
                "1 yd = ft\n" +
                "1 mi = yd\n" +
                "1 cm = in\n" +
                "1 m = ft\n" +
                "1 mm = in\n" +
                "1 km = mi");

        TextField userInputField = new TextField();
        userInputField.setPromptText("Enter your conversion query");

        Button convertButton = new Button("Convert");
        Label resultLabel = new Label();

        // Handle conversion logic
        convertButton.setOnAction(e -> {
            String userInput = userInputField.getText();
            if (userInput.equals("-1")) {
                primaryStage.close();  // Close the application when user enters "-1"
            } else {
                String result = handleConversion(userInput);
                resultLabel.setText(result);
            }
        });

        // Layout setup
        VBox layout = new VBox(10, welcomeLabel, instructionsLabel, exampleTextArea, exitInstructionLabel, userInputField, convertButton, resultLabel);
        layout.setPadding(new Insets(20));

        // Set the scene
        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Metric Converter");
        primaryStage.show();
    }

    // Handle the conversion logic
    private String handleConversion(String userInput) {
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
                return "Sorry, we do not have that conversion available. Or we don't recognize that input.";
        }
    }
}
