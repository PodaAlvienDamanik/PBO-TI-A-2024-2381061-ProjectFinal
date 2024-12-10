// src/main/java/com/restoran/entities/Pesanan.java
package com.restoran.entities;

public class Pesanan {
    private String namaPembeli;
    private String item;
    private int kuantitas;
    private String status;

    public Pesanan(String namaPembeli, String item, int kuantitas, String status) {
        this.namaPembeli = namaPembeli;
        this.item = item;
        this.kuantitas = kuantitas;
        this.status = status;
    }

    public String getNamaPembeli() {
        return namaPembeli;
    }

    public void setNamaPembeli(String namaPembeli) {
        this.namaPembeli = namaPembeli;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getKuantitas() {
        return kuantitas;
    }

    public void setKuantitas(int kuantitas) {
        this.kuantitas = kuantitas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pesanan{" +
                "Nama Pembeli='" + namaPembeli + '\'' +
                ", Item='" + item + '\'' +
                ", Kuantitas=" + kuantitas +
                ", Status='" + status + '\'' +
                '}';
    }
}
