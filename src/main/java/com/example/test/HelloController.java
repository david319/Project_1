package com.example.test;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import javafx.application.Platform;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import static com.example.test.Users.*;

public class HelloController extends Thread {
    public boolean login = false;
    public boolean reg = false;
    public JFXTextField txt_user;
    public JFXPasswordField pass_txt;
    public JFXTextField userReg;
    public JFXTextField nameReg;
    public JFXTextField passReg;
    public JFXTextField ageReg;
    public Button BtnLog;
    public Pane paneLog;
    public Pane paneRegister;
    public Pane PaneE;
    public Pane createE;
    public Pane DeleteE;
    public Pane EditE;
    public Pane ShowE;
    public Pane PaneU;
    public Pane EditU;
    public Pane DeleteU;
    public Pane PaneR;
    public Pane startMenu;
    public ComboBox<String> typeUser;
    public ComboBox<String> TypeE;
    public ComboBox<String> TypeD;
    public ComboBox<String> TypeM;
    public Button btnReg;

    public void initialize() {
        RequiredFieldValidator txtValidator = new RequiredFieldValidator();
        txtValidator.setMessage("Este campo es requerido");
        txt_user.getValidators().add(txtValidator);
        pass_txt.getValidators().add(txtValidator);
        userReg.getValidators().add(txtValidator);
        nameReg.getValidators().add(txtValidator);
        passReg.getValidators().add(txtValidator);
        NumberValidator ageValidator = new NumberValidator();
        ageValidator.setMessage("Solo números");
        ageReg.getValidators().add(ageValidator);
        Admin();
        typeUser.setItems(comboTipeUser);
    }

    public void ValidateReg() {
        userReg.validate();
        nameReg.validate();
        passReg.validate();
        ageReg.validate();
    }

    public void ValidateLog() {
        txt_user.validate();
        pass_txt.validate();
    }

    ObservableList<String> comboTipeUser =
            FXCollections.observableArrayList(
                    "Admin",
                    "Contenido",
                    "Limitado"
            );

    public void btn_login() {
        String user = txt_user.getText();
        String pass = pass_txt.getText();
        if (!validLog(user, pass)) {
            login = true;
        }
}

    public void btnReg() {
        String nameC = nameReg.getText();
        String user = userReg.getText();
        String pass = passReg.getText();
        String age = ageReg.getText();
        String tipe = typeUser.getValue();
        if (!searchUser(user)) {
            if (tipe.equals("Admin")) {
                aggUser(nameC, user, pass, Integer.parseInt(age), tipe);
            } else if (tipe.equals("Contenido")) {
                aggUser(nameC, user, pass, Integer.parseInt(age), tipe);
            } else if (tipe.equals("Limitado")) {
                aggUser(nameC, user, pass, Integer.parseInt(age), tipe);
            }
            reg = true;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Information");
            alert.setContentText("El usuario se ha registrado correctamente");
            alert.showAndWait();
        }
        reg = false;
    }

    public void OnBtnRegClicked() {
        ValidateReg();
        btnReg();
        if (!reg) {
            paneRegister.setVisible(false);
            paneLog.setVisible(true);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("El usuario ya existe1");
            alert.showAndWait();
        }
    }

    public void OnBtnLogClicked() {
        ValidateLog();
        btn_login();
        if (!login) {
            paneLog.setVisible(false);
            startMenu.setVisible(true);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Usuario o contraseña incorrectos");
            alert.showAndWait();
        }
    }
    public void OnBtnRegisterClicked() {
        PaneU.setVisible(false);
        paneLog.setVisible(false);
        paneRegister.setVisible(true);
    }

    public void OnBtnAdminEventsClicked() {
        startMenu.setVisible(false);
        PaneE.setVisible(true);
    }

    public void OnBtnCreateEventClicked() {
        PaneE.setVisible(false);
        createE.setVisible(true);
    }

    public void OnBtnDeleteEClicked() {
        PaneE.setVisible(false);
        DeleteE.setVisible(true);
    }

    public void OnBtnEditEClicked() {
        PaneE.setVisible(false);
        EditE.setVisible(true);
    }

    public void OnBtnShowEClicked() {
        PaneE.setVisible(false);
        ShowE.setVisible(true);
    }

    public void OnBtnAdminUserClicked() {
        startMenu.setVisible(false);
        PaneU.setVisible(true);
    }

    public void OnBtnEditUClicked() {
        PaneU.setVisible(false);
        EditU.setVisible(true);
    }

    public void OnBtnDeleteUClicked() {
        PaneU.setVisible(false);
        DeleteU.setVisible(true);
    }

    public void OnBtnReportsClicked() {
        startMenu.setVisible(false);
        PaneR.setVisible(true);
    }


    public  void OnBtnBackMenuClicked() {
        startMenu.setVisible(true);
        PaneR.setVisible(false);
    }

    public void OnBtnBackMenuClicked2() {
        startMenu.setVisible(true);
        PaneU.setVisible(false);
    }

    public void OnBtnBackMenuClicked3() {
        startMenu.setVisible(true);
        PaneE.setVisible(false);
    }

    public void OnBtnExitClicked() {
        Platform.exit();
        System.exit(0);
    }
}
