package com.emergentes.modelo;

public class cate {

    private int id;
    private String categoria;

    public cate() {
        id = 0;

        categoria = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
