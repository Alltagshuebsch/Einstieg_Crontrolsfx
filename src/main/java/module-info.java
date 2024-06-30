module de.alltagshuebsch.einstieg_crontrolsfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.management;
    requires java.desktop;


    opens de.alltagshuebsch.einstieg_crontrolsfx to javafx.fxml;
    exports de.alltagshuebsch.einstieg_crontrolsfx;
}