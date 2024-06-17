package br.com.vidracariaborealaruja.enums;

public enum Roldanas {
    AL_1125("1125"), AL_1125E("1125E");

    private final String codigo;

    Roldanas(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }
}
