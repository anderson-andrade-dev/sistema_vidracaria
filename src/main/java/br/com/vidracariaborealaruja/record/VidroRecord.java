package br.com.vidracariaborealaruja.record;

public record VidroRecord(Long id, String nome, boolean isTemperado,
                          boolean isLaminado, String preco, Long espessura) {
}
