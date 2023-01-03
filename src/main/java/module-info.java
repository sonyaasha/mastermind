module wit.comp1050.mastermindjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.commons.configuration2;


    opens wit.comp1050.mastermindjavafx to javafx.fxml;
    exports wit.comp1050.mastermindjavafx;
}