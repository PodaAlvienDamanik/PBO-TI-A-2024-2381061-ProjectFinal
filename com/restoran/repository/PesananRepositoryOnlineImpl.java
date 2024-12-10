package com.restoran.repository;

import com.restoran.entities.PesananOnline;
import java.util.ArrayList;
import java.util.List;

public class PesananRepositoryOnlineImpl implements PesananRepositoryOnline {
    private final List<PesananOnline> pesananOnlineList = new ArrayList<>();

    @Override
    public void tambahPesananOnline(PesananOnline pesanan) {
        pesananOnlineList.add(pesanan);
    }

    @Override
    public List<PesananOnline> lihatSemuaPesananOnline() {
        return pesananOnlineList;
    }

    @Override
    public void hapusPesananOnline(int index) {
        if (index >= 0 && index < pesananOnlineList.size()) {
            pesananOnlineList.remove(index);
        } else {
            System.out.println("Indeks tidak valid. Tidak ada pesanan yang dihapus.");
        }
    }

    @Override
    public void updatePesananOnline(int index, PesananOnline pesanan) {
        if (index >= 0 && index < pesananOnlineList.size()) {
            pesananOnlineList.set(index, pesanan);
        } else {
            System.out.println("Indeks tidak valid. Tidak ada pesanan yang diperbarui.");
        }
    }
}