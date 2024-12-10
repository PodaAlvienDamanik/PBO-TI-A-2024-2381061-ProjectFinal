package com.restoran.views;

import com.restoran.entities.PesananOnline;
import com.restoran.service.PesananOnlineServiceInterface;

import java.util.List;
import java.util.Scanner;

public class PesananOnlineView {
    private final PesananOnlineServiceInterface pesananOnlineService;

    public PesananOnlineView(PesananOnlineServiceInterface pesananOnlineService) {
        this.pesananOnlineService = pesananOnlineService;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("\n=== Menu Pesanan Online ===");
            System.out.println("1. Tambah Pesanan Online");
            System.out.println("2. Lihat Semua Pesanan Online");
            System.out.println("3. Hapus Pesanan Online");
            System.out.println("4. Update Pesanan Online");
            System.out.println("5. Kembali");
            System.out.print("Masukkan pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    tambahPesananOnline(scanner);
                    break;
                case 2:
                    lihatPesananOnline();
                    break;
                case 3:
                    hapusPesananOnline(scanner);
                    break;
                case 4:
                    updatePesananOnline(scanner);
                    break;
                case 5:
                    System.out.println("Kembali ke menu utama.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);
    }

    private void tambahPesananOnline(Scanner scanner) {
        System.out.print("Masukkan nama pembeli: ");
        String namaPembeli = scanner.nextLine();
        System.out.print("Masukkan item pesanan: ");
        String item = scanner.nextLine();
        System.out.print("Masukkan jumlah: ");
        int kuantitas = scanner.nextInt();
        scanner.nextLine();

        pesananOnlineService.tambahPesananOnline(namaPembeli, item, kuantitas);
    }

    private void lihatPesananOnline() {
        List<PesananOnline> pesananOnlineList = pesananOnlineService.lihatSemuaPesananOnline();
        if (pesananOnlineList.isEmpty()) {
            System.out.println("Tidak ada pesanan online.");
        } else {
            for (int i = 0; i < pesananOnlineList.size(); i++) {
                System.out.println("[" + i + "] " + pesananOnlineList.get(i));
            }
        }
    }

    private void hapusPesananOnline(Scanner scanner) {
        lihatPesananOnline();
        System.out.print("Masukkan indeks pesanan yang ingin dihapus: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        pesananOnlineService.hapusPesananOnline(index);
    }

    private void updatePesananOnline(Scanner scanner) {
        lihatPesananOnline();
        System.out.print("Masukkan indeks pesanan yang ingin diperbarui: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan item baru: ");
        String item = scanner.nextLine();
        System.out.print("Masukkan kuantitas baru: ");
        int kuantitas = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan status baru: ");
        String status = scanner.nextLine();

        PesananOnline pesanan = new PesananOnline("Pembeli", item, kuantitas, status);
        pesananOnlineService.updatePesananOnline(index, pesanan);
    }
}