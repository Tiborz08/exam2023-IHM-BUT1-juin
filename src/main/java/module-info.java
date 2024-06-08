module com.example.exam2023 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.exam2023 to javafx.fxml;
    exports com.example.exam2023;
}