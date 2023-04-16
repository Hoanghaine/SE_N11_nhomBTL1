module com {
    // requires javafx.controls;
    // requires javafx.fxml;

    // opens com.example to javafx.fxml;
    // exports com.example;
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires transitive java.sql;
    opens com to javafx.fxml;

    exports com;
    exports com.Controller;

    opens com.Controller to javafx.fxml;
    exports com.Controller.User;
    opens com.Controller.User to javafx.fxml;
    exports com.Controller.Psy;
    opens com.Controller.Psy to javafx.fxml;
}   
