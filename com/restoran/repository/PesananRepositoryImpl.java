package com.restoran.repository;

import com.restoran.entities.Pesanan;
import java.util.ArrayList;
import java.util.List;

public class PesananRepositoryImpl implements PesananRepository {
    private final List<Pesanan> pesananList = new ArrayList<>();

    @Override
    public void tambahPesanan(Pesanan pesanan) {
        pesananList.add(pesanan);
        System.out.println("Pesanan berhasil ditambahkan: " + pesanan);
    }

    @Override
    public List<Pesanan> lihatSemuaPesanan() {
        return pesananList;
    }

    @Override
    public void hapusPesanan(int index) {
        if (index >= 0 && index < pesananList.size()) {
            pesananList.remove(index);
            System.out.println("Pesanan berhasil dihapus.");
        } else {
            System.out.println("Indeks tidak valid. Tidak ada pesanan yang dihapus.");
        }
    }

    @Override
    public void updatePesanan(int index, Pesanan pesanan) {
        if (index >= 0 && index < pesananList.size()) {
            pesananList.set(index, pesanan);
            System.out.println("Pesanan berhasil diperbarui.");
        } else {
            System.out.println("Indeks tidak valid. Tidak ada pesanan yang diperbarui.");
        }
    }
}