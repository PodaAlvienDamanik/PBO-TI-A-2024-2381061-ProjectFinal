package com.restoran;
import com.restoran.config.Database;
import com.restoran.repository.PesananRepository;
import com.restoran.repository.PesananRepositoryImpl;
import com.restoran.repository.PesananRepositoryOnline;
import com.restoran.repository.PesananRepositoryOnlineImpl;
import com.restoran.service.PesananOnlineService;
import com.restoran.service.PesananOnlineServiceInterface;
import com.restoran.service.PesananService;
import com.restoran.service.PesananServiceInterface;
import com.restoran.views.PesananOnlineView;
import com.restoran.views.PesananView;
import com.restoran.views.PesananViewInterface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Database database = new Database ("my_database", "root","","localhost", "3306");
        database.setup();

        PesananRepository pesananRepository = new PesananRepositoryImpl();
        PesananServiceInterface pesananService = new PesananService(pesananRepository);
        PesananViewInterface pesananView = new PesananView(pesananService);

        PesananRepositoryOnline pesananRepositoryOnline = new PesananRepositoryOnlineImpl();
        PesananOnlineServiceInterface pesananOnlineService = new PesananOnlineService(pesananRepositoryOnline);
        PesananOnlineView pesananOnlineView = new PesananOnlineView(pesananOnlineService);

        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== Restoran Mandalika ===");
            System.out.println("1. Pembeli");
            System.out.println("2. Penjual");
            System.out.println("3. Keluar");
            System.out.print("Pilih peran: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("Anda masuk sebagai Pembeli.");
                    pesananView.displayMenu();
                    break;
                case 2:
                    System.out.println("Anda masuk sebagai Penjual.");
                    pesananOnlineView.displayMenu();
                    break;
                case 3:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 3);
    }
}