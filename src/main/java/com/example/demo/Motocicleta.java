package com.example.demo;
import java.util.UUID;

public class Motocicleta {

    private String id, marcaMotocicleta, placaMotocicleta, colorMotocicleta, cilindrajeMotocicleta;
    private int precioMotocicleta;

    public Motocicleta() {
        this.id = UUID.randomUUID().toString();
    }

    public Motocicleta(String cilindrajeMotocicleta, String marcaMotocicleta, String placaMotocicleta, String colorMotocicleta, int precioMotocicleta) {
        this.id = UUID.randomUUID().toString();;
        this.cilindrajeMotocicleta = cilindrajeMotocicleta;
        this.marcaMotocicleta = marcaMotocicleta;
        this.placaMotocicleta = placaMotocicleta;
        this.colorMotocicleta = colorMotocicleta;
        this.precioMotocicleta = precioMotocicleta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarcaMotocicleta() {
        return marcaMotocicleta;
    }

    public void setMarcaMotocicleta(String marcaMotocicleta) {
        this.marcaMotocicleta = marcaMotocicleta;
    }

    public String getPlacaMotocicleta() {
        return placaMotocicleta;
    }

    public void setPlacaMotocicleta(String placaMotocicleta) {
        this.placaMotocicleta = placaMotocicleta;
    }

    public String getColorMotocicleta() {
        return colorMotocicleta;
    }

    public void setColorMotocicleta(String colorMotocicleta) {
        this.colorMotocicleta = colorMotocicleta;
    }

    public int getPrecioMotocicleta() {
        return precioMotocicleta;
    }

    public void setPrecioMotocicleta(int precioMotocicleta) {
        this.precioMotocicleta = precioMotocicleta;
    }

    public String getCilindrajeMotocicleta() {
        return cilindrajeMotocicleta;
    }

    public void setCilindrajeMotocicleta(String cilindrajeMotocicleta) {
        this.cilindrajeMotocicleta = cilindrajeMotocicleta;
    }
}