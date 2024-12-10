package com.restoran.service;

import com.restoran.entities.Pesanan;
import com.restoran.repository.PesananRepository;
import java.util.List;

public class PesananService implements PesananServiceInterface {
    private final PesananRepository repository;

    public PesananService(PesananRepository repository) {
        this.repository = repository;
    }

    @Override
    public void buatPesanan(String nama, String item, int kuantitas) {
        Pesanan pesanan = new Pesanan(nama, item, kuantitas, "Sedang Diproses");
        repository.tambahPesanan(pesanan);
    }

    @Override
    public List<Pesanan> lihatSemuaPesanan() {
        return repository.lihatSemuaPesanan();
    }

    @Override
    public void hapusPesanan(int index) {
        repository.hapusPesanan(index);
    }

    @Override
    public void updatePesanan(int index, String item, int kuantitas, String status) {
        Pesanan pesanan = new Pesanan("Pembeli", item, kuantitas, status);
        repository.updatePesanan(index, pesanan);
    }
}