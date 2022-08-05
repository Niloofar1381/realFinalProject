package com.example.realfinalproject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main extends Application {
    public static Connection connection;
    static Stage mainStage;
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop_project",
                "root", "12345");
        launch();
        DatabaseInitializer databaseInitializer=new DatabaseInitializer();
        InputProcessor inputProcessor=new InputProcessor();
        databaseInitializer.createTables(connection);
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        inputProcessor.start();
    }
    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginOrRegister.fxml"));
        Parent root= loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
