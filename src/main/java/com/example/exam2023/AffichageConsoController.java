package com.example.exam2023;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AffichageConsoController {

    @FXML
    private Label labelTypeConsommation;
    @FXML
    TextField txtFldConsoAff, txtFldPrixAff;
    @FXML
    private Button okButton;

    private CalculateurConso calc;
    void initData(CalculateurConso calc) {
        // Récupération de l'objet du modèle
        this.calc = calc;
        // Initialisation de l'interface avec les valeurs récupérées depuis le modèle
        labelTypeConsommation.setText("Consommation en ".concat(calc.getCarburant()));
        txtFldConsoAff.setText(String.valueOf(calc.calculerConsoMoy()));
        txtFldPrixAff.setText(String.valueOf(calc.calculerCoutKm()));
    }
    @FXML
    private void restart(ActionEvent event) throws IOException {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }
}
