module com.example.realfinalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
    requires lombok;


    opens com.example.realfinalproject to javafx.fxml;
    exports com.example.realfinalproject;
}