module runner {
    requires javafx.controls;
    requires javafx.fxml;


    opens runner to javafx.fxml;
    exports runner;
}