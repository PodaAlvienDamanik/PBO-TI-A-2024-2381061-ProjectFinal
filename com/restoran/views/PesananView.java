package com.restoran.views;

import com.restoran.entities.Pesanan;
import com.restoran.service.PesananServiceInterface;

import java.util.List;
import java.util.Scanner;

public class PesananView implements PesananViewInterface {
    private final PesananServiceInterface pesananService;

    public PesananView(PesananServiceInterface pesananService) {
        this.pesananService = pesananService;
    }

    @Override
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("\n=== Menu Pesanan ===");
            System.out.println("1. Buat Pesanan");
            System.out.println("2. Lihat Semua Pesanan");
            System.out.println("3. Update Pesanan");
            System.out.println("4. Hapus Pesanan");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    buatPesanan(scanner);
                    break;
                case 2:
                    lihatPesanan();
                    break;
                case 3:
                    updatePesanan(scanner);
                    break;
                case 4:
                    hapusPesanan(scanner);
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);
    }

    private void buatPesanan(Scanner scanner) {
        System.out.print("Masukkan nama pembeli: ");
        String namaPembeli = scanner.nextLine();
        System.out.print("Masukkan item pesanan: ");
        String item = scanner.nextLine();
        System.out.print("Masukkan jumlah: ");
        int kuantitas = scanner.nextInt();
        scanner.nextLine();

        pesananService.buatPesanan(namaPembeli, item, kuantitas);
    }

    private void lihatPesanan() {
        List<Pesanan> pesananList = pesananService.lihatSemuaPesanan();
        if (pesananList.isEmpty()) {
            System.out.println("Tidak ada pesanan.");
        } else {
            for (int i = 0; i < pesananList.size(); i++) {
                System.out.println("[" + i + "] " + pesananList.get(i));
            }
        }
    }

    private void updatePesanan(Scanner scanner) {
        lihatPesanan();
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

        pesananService.updatePesanan(index, item, kuantitas, status);
    }

    private void hapusPesanan(Scanner scanner) {
        lihatPesanan();
        System.out.print("Masukkan indeks pesanan yang ingin dihapus: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        pesananService.hapusPesanan(index);
    }
}