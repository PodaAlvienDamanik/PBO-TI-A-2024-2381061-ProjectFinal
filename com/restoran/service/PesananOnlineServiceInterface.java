package com.restoran.service;

import com.restoran.entities.PesananOnline;
import java.util.List;

public interface PesananOnlineServiceInterface {
    void tambahPesananOnline(String nama, String item, int kuantitas);
    List<PesananOnline> lihatSemuaPesananOnline();
    void hapusPesananOnline(int index);
    void updatePesananOnline(int index, PesananOnline pesanan);
}
