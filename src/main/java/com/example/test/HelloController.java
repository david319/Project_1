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

import static com.example.test.Events.*;
import static com.example.test.Users.*;

public class HelloController extends Thread {
    public boolean reg = false;
    public boolean regE = false;
    public JFXTextField txt_user;
    public JFXPasswordField pass_txt;
    public JFXTextField userReg, nameReg, passReg, ageReg;
    public JFXTextField IdEvent, TitleE, DescripE, AmountE, Team1, Team2;
    public DatePicker DateE;
    public Button BtnLog;
    public Pane paneLog, paneRegister, PaneE, createE, DeleteE, EditE, ShowE, PaneU;
    public Pane EditU, DeleteU, PaneR, startMenu;
    public ComboBox<String> typeUser;
    public ComboBox<String> TypeE;
    public ComboBox<String> TypeD;
    public ComboBox<String> TypeM;
    public Button btnReg, RegE;

    public void initialize() {
        Admin();
        RequiredFieldValidator txtValidator = new RequiredFieldValidator();
        txtValidator.setMessage("Este campo es requerido");
        txt_user.getValidators().add(txtValidator);
        pass_txt.getValidators().add(txtValidator);
        userReg.getValidators().add(txtValidator);
        nameReg.getValidators().add(txtValidator);
        passReg.getValidators().add(txtValidator);
        IdEvent.getValidators().add(txtValidator);
        TitleE.getValidators().add(txtValidator);
        DescripE.getValidators().add(txtValidator);
        Team1.getValidators().add(txtValidator);
        Team2.getValidators().add(txtValidator);
        NumberValidator numberValidator = new NumberValidator();
        numberValidator.setMessage("Solo números");
        AmountE.getValidators().add(numberValidator);
        ageReg.getValidators().add(numberValidator);
        typeUser.setItems(comboTipeUser);
        TypeE.setItems(comboTypeE);
        TypeD.setItems(comboTypeD);
        TypeM.setItems(comboTypeM);
    }

    public void ValidateReg() {
        userReg.validate();
        nameReg.validate();
        passReg.validate();
        ageReg.validate();
    }

    public void ValidateCreateE() {
        IdEvent.validate();
        TitleE.validate();
        DescripE.validate();
        Team1.validate();
        Team2.validate();
        AmountE.validate();
    }

    public void ValidateLog() {
        if (txt_user.getText().isEmpty() || pass_txt.getText().isEmpty()) {
            txt_user.validate();
            pass_txt.validate();
        }
    }

    ObservableList<String> comboTipeUser =
            FXCollections.observableArrayList(
                    "Admin",
                    "Contenido",
                    "Limitado"
            );

    public boolean btn_login() {
        String user = txt_user.getText();
        String pass = pass_txt.getText();
        return !validLog(user, pass);
    }

    public void OnBtnLogClicked() {
        ValidateLog();
        if (!btn_login()) {
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

    public void btnReg() {
        String nameC = nameReg.getText();
        String user = userReg.getText();
        String pass = passReg.getText();
        String age = ageReg.getText();
        String type = typeUser.getValue();
        if (!searchUser(user)) {
            aggUser(user, pass, nameC, Integer.parseInt(age), type);
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
        if (!reg) {
            btnReg();
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

    public void OnBtnAdminEventsClicked() {
        startMenu.setVisible(false);
        PaneE.setVisible(true);
    }

    public void OnBtnCreateEventClicked() {
        PaneE.setVisible(false);
        createE.setVisible(true);
    }

    public void RegE() {
        String Id = IdEvent.getText();
        String title = TitleE.getText();
        String descrip = DescripE.getText();
        String dateE = DateE.getValue().toString();
        double amount = Double.parseDouble(AmountE.getText());
        String typeE = TypeE.getValue();
        String typeD = TypeD.getValue();
        String team1 = Team1.getText();
        String team2 = Team2.getText();
        String typeM = TypeM.getValue();
        if (!searchEvent(Id)) {
            createEvent(Id, title, descrip, dateE, typeE, amount, typeD, team1, team2, typeM);
            regE = true;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Information");
            alert.setContentText("El evento se ha registrado correctamente");
            alert.showAndWait();
        }
        regE = false;
    }

    public void OnBtnCreateEventClicked2() {
        ValidateCreateE();
        if (!regE) {
            RegE();
            createE.setVisible(false);
            startMenu.setVisible(true);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("El evento ya existe");
        }
    }

    ObservableList<String> comboTypeE =
            FXCollections.observableArrayList(
                    "Deportivo",
                    "Musical",
                    "Religioso"
            );

    ObservableList<String> comboTypeD =
            FXCollections.observableArrayList(
                    "Futbol",
                    "Beisbol",
                    "Rugby",
                    "Tenis"
            );

    ObservableList<String> comboTypeM =
            FXCollections.observableArrayList(
                    "Pop",
                    "Rock",
                    "Rap",
                    "Clásica",
                    "Reggaetón",
                    "Otro"
            );

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


    public void OnBtnBackMenuClicked() {
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
