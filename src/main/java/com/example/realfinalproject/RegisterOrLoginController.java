package com.example.realfinalproject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class RegisterOrLoginController {
    Manager manager = new Manager();
    private Stage stage = Main.mainStage;
    private Scene scene = null;

    @FXML
    Button register;
    @FXML
    Button login;
    @FXML
    Rectangle rectangle;
    @FXML
    Button close;

//    public void initialize() throws SQLException, IOException {
//        SetArrayLists setArrayLists = new SetArrayLists();
//        setArrayLists.setAllArrayLists();
//        stage.setHeight(439.0);
//        stage.setWidth(616.0);
//        double height = stage.getHeight();
//        double width = stage.getWidth();
//        stage.sizeToScene();
//        register.setLayoutX(width/2 - 172);
//        register.setLayoutY(height/2 - 16);
//        rectangle.setWidth(width);
//        rectangle.setHeight(height);
//        login.setLayoutX(width/2 + 50);
//        login.setLayoutY(height/2 - 16);
//        close.setLayoutX(width - 101);
//    }

    public void switchToRegisterPage(ActionEvent event) throws IOException, SQLException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        if (manager.checkLogin()!=null){
            manager.logout();
        }
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("registerPage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToLoginPage(ActionEvent event) throws IOException, SQLException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        if (manager.checkLogin()!=null){
            manager.logout();
        }
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loginPage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void closeTheStage(ActionEvent event) throws SQLException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        if (manager.checkLogin()!=null){
            manager.logout();
        }
        DataInitializer dataInitializer = new DataInitializer();
        dataInitializer.insertAllInformation();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
}
