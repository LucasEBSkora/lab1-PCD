module eu.telecomnancy.tp {
    requires javafx.controls;
    requires javafx.fxml;


    opens eu.telecomnancy.tp to javafx.fxml;
    exports eu.telecomnancy.tp;
    exports eu.telecomnancy.tp.model;
    opens eu.telecomnancy.tp.model to javafx.fxml;
}