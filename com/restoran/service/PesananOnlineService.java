package com.restoran.service;

import com.restoran.entities.PesananOnline;
import com.restoran.repository.PesananRepositoryOnline;
import java.util.List;

public class PesananOnlineService implements PesananOnlineServiceInterface {
    private final PesananRepositoryOnline repository;

    public PesananOnlineService(PesananRepositoryOnline repository) {
        this.repository = repository;
    }

    @Override
    public void tambahPesananOnline(String nama, String item, int kuantitas) {
        PesananOnline pesanan = new PesananOnline(nama, item, kuantitas, "Sedang Diproses");
        repository.tambahPesananOnline(pesanan);
    }

    @Override
    public List<PesananOnline> lihatSemuaPesananOnline() {
        return repository.lihatSemuaPesananOnline();
    }

    @Override
    public void hapusPesananOnline(int index) {
        repository.hapusPesananOnline(index);
    }

    @Override
    public void updatePesananOnline(int index, PesananOnline pesanan) {
        repository.updatePesananOnline(index, pesanan);
    }
}