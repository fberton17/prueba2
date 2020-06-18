package Clases;

public class Idioma{
    public String idioma = "";
    public int cantidadreservas = 1;

    public Idioma(String idioma) {
        this.idioma = idioma;
    }

    public String getIdioma() {
        return idioma;
    }

    public int getCantidadreservas() {
        return cantidadreservas;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setCantidadreservas(int cantidadreservas) {
        this.cantidadreservas = cantidadreservas;
    }


}
