package co.devhack.firebaserestapi;

import com.google.gson.annotations.SerializedName;

/**
 * Created by krlosf on 5/05/18.
 */

public class Alimento {
    private String nombre;
    private Double calorias;
    @SerializedName("carbo_hidratos")
    private Double carboHidratos;
    private Double grasas;
    private Double proteinas;
    private Double racion;
    private String imagen;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCalorias() {
        return calorias;
    }

    public void setCalorias(Double calorias) {
        this.calorias = calorias;
    }

    public Double getCarboHidratos() {
        return carboHidratos;
    }

    public void setCarboHidratos(Double carboHidratos) {
        this.carboHidratos = carboHidratos;
    }

    public Double getGrasas() {
        return grasas;
    }

    public void setGrasas(Double grasas) {
        this.grasas = grasas;
    }

    public Double getProteinas() {
        return proteinas;
    }

    public void setProteinas(Double proteinas) {
        this.proteinas = proteinas;
    }

    public Double getRacion() {
        return racion;
    }

    public void setRacion(Double racion) {
        this.racion = racion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
