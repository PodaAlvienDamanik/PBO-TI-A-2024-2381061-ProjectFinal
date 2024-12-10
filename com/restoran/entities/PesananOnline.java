package com.restoran.entities;

public class PesananOnline {
    private String nama;
    private String item;
    private int kuantitas;
    private String status;

    // Constructor
    public PesananOnline(String nama, String item, int kuantitas, String status) {
        this.nama = nama;
        this.item = item;
        this.kuantitas = kuantitas;
        this.status = status;
    }

    // Getters and Setters
    public String getNama() {
        return nama;
    }

    public String getItem() {
        return item;
    }

    public int getKuantitas() {
        return kuantitas;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "PesananOnline{" +
                "nama='" + nama + '\'' +
                ", item='" + item + '\'' +
                ", kuantitas=" + kuantitas +
                ", status='" + status + '\'' +
                '}';
    }
}