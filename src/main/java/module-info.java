module org.example.calculadoraproyecto {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.calculadoraproyecto to javafx.fxml;
    exports org.example.calculadoraproyecto;
}