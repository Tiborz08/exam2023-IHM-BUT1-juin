package com.example.exam2023;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SaisieController {

    @FXML
    private TextField txtFldConso, txtFldKm, txtFldPrix;
    @FXML
    private RadioButton rbEssence, rbDiesel;
    private CalculateurConso calc;
    public SaisieController() {
        this.calc = new CalculateurConso();
    }
    @FXML
    public void onCalculerButtonClicked(MouseEvent mouseEvent) {
        if (validateInputs()) {
            calc.setNbKm(Integer.parseInt(txtFldKm.getText()));
            calc.setConso(Integer.parseInt(txtFldConso.getText()));
            calc.setPrix(Float.parseFloat(txtFldPrix.getText()));
            calc.setCarburant(rbEssence.isSelected() ? CalculateurConso.ESSENCE : CalculateurConso.DIESEL);
            afficherResultats(calc);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Valeurs incorrectes");
            alert.setContentText("Veuillez saisir des valeurs numériques valides dans tous les champs");
            alert.showAndWait();
        }
    }
    public void onResetButtonClicked(MouseEvent mouseEvent) {
        txtFldKm.clear();
        txtFldConso.clear();
        txtFldPrix.clear();
        rbEssence.setSelected(false);
        rbDiesel.setSelected(false);
    }
    private boolean validateInputs() {
        String nbKmText = txtFldKm.getText();
        String consoText = txtFldConso.getText();
        String prixText = txtFldPrix.getText();
        // Contrôle de sasie sur champs vides
        if (nbKmText.isEmpty() || consoText.isEmpty() || prixText.isEmpty())
        {
            return false;
        }
        // Contrôle de sasie sur champs non valides
        try {
            Integer.parseInt(nbKmText);
            Integer.parseInt(consoText);
            Float.parseFloat(prixText);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private void afficherResultats(CalculateurConso calc) {
        try {
            FXMLLoader fxmlLoader = new
                    FXMLLoader(getClass().getResource("affichageConso.fxml"));
            Stage fenetre = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 250, 150);
            AffichageConsoController controller = fxmlLoader.getController();
            controller.initData(calc);
            fenetre.setScene(scene);
            fenetre.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}