package com.example.exam2023;

public class CalculateurConso {
    public static final String CARBURANT_INCONNU = "Carburant Inconnu";
    public static final String DIESEL = "Diesel";
    public static final String ESSENCE = "Essence";
    private String carburant;
    private int nbKm; // -1 si la valeur est inconnue
    private int conso; // -1 si la valeur est inconnue
    private float prix; // -1 si la valeur est inconnue

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public void setNbKm(int nbKm) {
        this.nbKm = nbKm;
    }

    public void setConso(int conso) {
        this.conso = conso;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public float calculerConsoMoy() {
        return conso * 100 / nbKm;
    }

    public float calculerCoutKm() {
        return conso * prix * 100 / nbKm;
    }

    public String getCarburant() {
        return carburant;
    }
}
