package br.com.vidracariaborealaruja.enums;

public enum ContraFechaduras {
    AL_1511("1511"), AL_3534("3534"), AL_3206("3206"), AL_1504("1504");

    private final String codigo;

    ContraFechaduras(String codigo) {

        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }
}
