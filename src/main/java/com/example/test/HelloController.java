package com.example.test;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.util.Objects;
import java.util.Optional;

import static com.example.test.Events.*;
import static com.example.test.Users.*;

public class HelloController extends Thread {
    public boolean reg = false;
    public boolean regE = false;
    public String userLogin = "admin";
    public JFXTextField txt_user;
    public JFXPasswordField pass_txt;
    public JFXTextField userReg, nameReg, passReg, ageReg, IdSearch, idDelete, txtE;
    public JFXTextField IdEvent, TitleE, DescripE, AmountE, Team1, Team2;
    public JFXTextField editT, editD, editM, editT1, editT2, aggIntM, aggP, aggP1, aggP2;
    public JFXTextField userForS, newName, newUser, newPass, newAge, txtUserD;
    public DatePicker DateE, newD;
    public ListView<String> eShow, deleteUL;
    public ListView<String> editShow, userShow;
    public Button BtnLog;
    public Pane paneLog, paneRegister, PaneE, createE, DeleteE, EditE, ShowE, PaneU;
    public Pane EditU, DeleteU, PaneR, startMenu;
    public JFXButton searchU, updateU;
    public ComboBox<String> typeUser;
    public ComboBox<String> TypeE;
    public ComboBox<String> TypeD;
    public ComboBox<String> TypeM;
    public Button btnReg, RegE, showE, deleteE, editE, update, mostrarBack, editBack;

    public void initialize() {
        Admin();
        eventDefecto();
        userLogin();
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

    public void userLogin() {
        for (User u : users) {
            if (u.getUser().equals(txt_user.getText()) && u.getPass().equals(pass_txt.getText())) {
                if (u.getTipeUser().equals("Admin")) {
                    userLogin = "Admin";
                } else if (u.getTipeUser().equals("Contenido")) {
                    userLogin = "Contenido";
                }
            }
        }
    }

    public void userLog() {
        if (validLog(txt_user.getText(), pass_txt.getText())) {
            userLogin = txt_user.getText();
        }
    }

    public void OnBtnLogClicked() {
        ValidateLog();
        if (!btn_login()) {
            userLog();
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
            alert.setContentText("El usuario ya existe");
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
        if (searchEvent(Id, userLogin)) {
            createEvent(Id, title, descrip, dateE, typeE, amount, typeD, team1, team2, typeM, userLogin);
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

    public void OnBtnEditShowClicked() {
        String id = txtE.getText();
        if (searchEvent(id, userLogin)) {
            if (Objects.equals(userLogin, "admin")) {
                editShow.getItems().setAll(String.valueOf(eventsA.toString()));
            } else if (Objects.equals(userLogin, "contenido")) {
                editShow.getItems().setAll(String.valueOf(eventsC.toString()));
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("El evento no existe");
            alert.showAndWait();
        }
    }

    public void editEvent() {
        String id = txtE.getText();
        String title = editT.getText();
        String descrip = editE.getText();
        String dateE = newD.getValue().toString();
        String typeE = TypeE.getValue();
        String typeD = TypeD.getValue();
        String typeM = TypeM.getValue();
        double amount = Double.parseDouble(editM.getText());
        String team1 = editT1.getText();
        String team2 = editT2.getText();
        String inteB = aggIntM.getText();
        String playerT1 = aggP1.getText();
        String playerT2 = aggP2.getText();
        String peopleR = aggP.getText();
        if (searchEvent(id, userLogin)) {
            if (Objects.equals(userLogin, "admin")) {
                if (Objects.equals(getEventType(id, userLogin), "Deportivo")) {
                    for (int i = 0; i < eventsA.size(); i++) {
                        if (Objects.equals(eventsA.get(i).getId(), id)) {
                            eventsA.set(eventsA.indexOf(eventsA.get(i)), new EventD(id, title, descrip, dateE, typeE, amount, typeD, team1, team2));
                            eventsA.get(i).setJugadores1(playerT1);
                            eventsA.get(i).setJugadores2(playerT2);
                        }
                    }
                } else if (Objects.equals(typeE, "Musical")) {
                    for (int i = 0; i < eventsA.size(); i++) {
                        if (Objects.equals(eventsA.get(i).getId(), id)) {
                            eventsA.set(eventsA.indexOf(eventsA.get(i)), new EventM(id, title, descrip, dateE, typeE, amount, typeM));
                            eventsA.get(i).setpeopleM(inteB);
                        }
                    }
                } else if (Objects.equals(typeE, "Religioso")) {
                    for (int i = 0; i < eventsA.size(); i++) {
                        if (Objects.equals(eventsA.get(i).getId(), id)) {
                            eventsA.set(eventsA.indexOf(eventsA.get(i)), new EventR(id, title, descrip, dateE, typeE, amount));
                            eventsA.get(i).setpeopleR(peopleR);
                        }
                    }
                }
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Information");
            alert.setContentText("El evento se ha editado correctamente");
            alert.showAndWait();
        }
        regE = false;
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

    public void OnBtnDeleteEClicked2() {
        String Id = idDelete.getText();
        if (searchEvent(Id, userLogin)) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Confirmation");
            alert.setContentText("¿Está seguro de eliminar el evento?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Information");
                alert2.setHeaderText("Information");
                alert2.setContentText("El evento se ha eliminado correctamente");
                alert2.showAndWait();
                DeleteE.setVisible(false);
                startMenu.setVisible(true);
                DeleteE(Id, userLogin);
            } else {
                DeleteE.setVisible(false);
                PaneE.setVisible(true);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("El evento no existe");
            alert.showAndWait();
        }
    }

    public void OnBtneditBackClicked() {
        EditE.setVisible(false);
        PaneE.setVisible(true);
    }

    public void OnBtnEditEClicked() {
        PaneE.setVisible(false);
        EditE.setVisible(true);
    }

    public void showE() {
        String id = IdSearch.getText();
        if (showEvents(id, userLogin)) {
            if (Objects.equals(userLogin, "admin")) {
                eShow.getItems().setAll(String.valueOf(eventsA.toString()));
            } else if (Objects.equals(userLogin, "contenido")) {
                eShow.getItems().setAll(String.valueOf(eventsC.toString()));
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("El evento no existe");
            alert.showAndWait();
        }
    }

    public void OnBtnmostrarBackClicked() {
        ShowE.setVisible(false);
        PaneE.setVisible(true);
    }

    public void OnBtnShowEClicked() {
        PaneE.setVisible(false);
        ShowE.setVisible(true);
    }

    public void OnBtnShowEClicked2() {
        showE();
    }


    public void OnBtnAdminUserClicked() {
        startMenu.setVisible(false);
        PaneU.setVisible(true);
    }

    public void OnBtnEditUClicked() {
        PaneU.setVisible(false);
        EditU.setVisible(true);
    }

    public void OnBtnsearchUClicked() {
        searchU();
    }

    public void searchU() {
        String user = userForS.getText();
        for (User u : users) {
            if (Objects.equals(u.getUser(), user)) {
                userShow.getItems().setAll(String.valueOf(u.toString()));
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("El usuario no existe");
                alert.showAndWait();
            }
        }
    }

    public void OnBtnupdateUClicked() {
        editU();
    }

    public void editU() {
        String user = userForS.getText();
        for (User u : users) {
            if (Objects.equals(u.getUser(), user)) {
                String name = newName.getText();
                String User = newUser.getText();
                String pass = newPass.getText();
                int age = Integer.parseInt(newAge.getText());
                if (newName.getText().isEmpty()) {
                    name = u.getName();
                } else if (newUser.getText().isEmpty()) {
                    User = u.getUser();
                } else if (newPass.getText().isEmpty()) {
                    pass = u.getPass();
                } else if (newAge.getText().isEmpty()) {
                    age = u.getAge();
                }
                u.setName(name);
                u.setUserName(User);
                u.setPass(pass);
                u.setAge(age);
                userShow.getItems().setAll(String.valueOf(u.toString()));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informacion");
                alert.setHeaderText("Informacion");
                alert.setContentText("El usuario se ha modificado correctamente");
                alert.showAndWait();
                Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
                alert2.setTitle("Confirmacion");
                alert2.setHeaderText("Confirmacion");
                alert2.setContentText("¿Desea volver al menu de usuarios?");
                Optional<ButtonType> result = alert2.showAndWait();
                if (result.get() == ButtonType.OK) {
                    EditU.setVisible(false);
                    PaneU.setVisible(true);
                }
            }
        }
    }

    public void OnBtnDeleteUClicked() {
        for (User u : users) {
            deleteUL.getItems().setAll(String.valueOf(u.toString()));
        }
        PaneU.setVisible(false);
        DeleteU.setVisible(true);
    }

    public void OnBtndeleteUClicked(){
        deleteU();
        for (User u : users) {
            deleteUL.getItems().setAll(String.valueOf(u.toString()));
        }
    }

    public void deleteU(){
        String user = txtUserD.getText();
        for (User u : users) {
            if (Objects.equals(u.getUser(), "admin")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("No se puede eliminar el usuario administrador");
                alert.showAndWait();
                Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
                alert2.setTitle("Confirmacion");
                alert2.setHeaderText("Confirmacion");
                alert2.setContentText("¿Desea volver al menu de usuarios?");
                Optional<ButtonType> result = alert2.showAndWait();
                if (result.get() == ButtonType.OK) {
                    DeleteU.setVisible(false);
                    PaneU.setVisible(true);
                }
            } else if (Objects.equals(u.getUser(), user)) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmacion");
                alert.setHeaderText("Confirmacion");
                alert.setContentText("¿Desea eliminar el usuario?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    users.remove(u);
                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                    alert2.setTitle("Informacion");
                    alert2.setHeaderText("Informacion");
                    alert2.setContentText("El usuario se ha eliminado correctamente");
                    alert2.showAndWait();
                    Alert alert3 = new Alert(Alert.AlertType.CONFIRMATION);
                    alert3.setTitle("Confirmacion");
                    alert3.setHeaderText("Confirmacion");
                    alert3.setContentText("¿Desea volver al menu de usuarios?");
                    Optional<ButtonType> result2 = alert3.showAndWait();
                    if (result2.get() == ButtonType.OK) {
                        DeleteU.setVisible(false);
                        PaneU.setVisible(true);
                    }
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("El usuario no existe");
                alert.showAndWait();
            }
        }
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
