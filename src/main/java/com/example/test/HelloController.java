package com.example.test;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Button btn_log;
    @FXML
    private TextField txt_user;
    @FXML
    private PasswordField pass_txt;

    @FXML
    public void initialize() {
        btn_log.setOnAction(event -> {
            if (txt_user.getText().equals("admin") && pass_txt.getText().equals("admin")) {

                System.out.println("Login Success");
            }
        });
    }

}