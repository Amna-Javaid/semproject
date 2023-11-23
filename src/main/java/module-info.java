module com.example.semproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.semproject to javafx.fxml;
    exports com.example.semproject;
}