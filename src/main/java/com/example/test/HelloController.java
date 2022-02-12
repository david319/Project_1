package com.example.test;

import com.sun.tools.javac.Main;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static com.example.test.Users.*;

public class HelloController extends Thread {
    public TextField txt_user;
    public PasswordField txt_pass;
    public Button BtnLog;
    public Pane paneLog;
    public AnchorPane paneStart;
    public Pane startMenu;
    public boolean login = false;

    public void btn_login() {
        Admin();
        String user = txt_user.getText();
        String pass = txt_pass.getText();
        if (searchUser(user, pass)) {
            login = true;
        }
}

    public void OnBtnLogClicked() {
        if (!login) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login");
            alert.setHeaderText("Login");
            alert.setContentText("Login Success");
            alert.showAndWait();
            paneLog.setVisible(false);
            paneStart.setVisible(true);
            startMenu.setVisible(true);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Username or Password is incorrect");
            alert.showAndWait();
        }
    }

    public void OnBtnExitClicked() {
        Platform.exit();
        System.exit(0);
    }
}
