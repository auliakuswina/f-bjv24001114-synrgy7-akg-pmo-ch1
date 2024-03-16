package coba;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<String, Integer> pesanan = new HashMap<>();
    private static final String FILENAME = "struk_pembayaran.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("==========================");
            System.out.println("Selamat datang di Binarfud");
            System.out.println("==========================");
            System.out.println("Silahkan pilih menu:");
            System.out.println("1. Nasi Goreng | 15.000");
            System.out.println("2. Mie Goreng  | 13.000");
            System.out.println("3. Es Teh      | 3.000");
            System.out.println("4. Es Jeruk    | 5.000");
            System.out.println("99. Pesan dan Bayar");
            System.out.println("0. Keluar aplikasi");
            System.out.print("=>");

            int pilihan = scanner.nextInt();
            switch (pilihan) {
                case 1:
                    pesanMakanan("Nasi Goreng", scanner);
                    break;
                case 2:
                    pesanMakanan("Mie Goreng", scanner);
                    break;
                case 3:
                    pesanMakanan("Es Teh", scanner);
                    break;
                case 4:
                    pesanMakanan("Es Jeruk", scanner);
                    break;
                case 99:
                    konfirmasiDanBayar();
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan aplikasi kami!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private static void pesanMakanan(String makanan, Scanner scanner) {
        System.out.print("Masukkan jumlah pesanan " + makanan + ": ");
        int jumlah = scanner.nextInt();
        pesanan.put(makanan, jumlah);
        System.out.println("Pesanan " + makanan + " sebanyak " + jumlah + " telah ditambahkan.");
    }

    private static void konfirmasiDanBayar() {
        if (pesanan.isEmpty()) {
            System.out.println("Belum ada pesanan yang dimasukkan.");
            return;
        }

        int totalHarga = 0;
        for (Map.Entry<String, Integer> entry : pesanan.entrySet()) {
            String makanan = entry.getKey();
            int harga = getHarga(makanan);
            int jumlah = entry.getValue();
            totalHarga += harga * jumlah;
            System.out.println(makanan + " : " + jumlah);
        }
        System.out.println("Total Harga: Rp " + totalHarga);

        System.out.println("Apakah pesanan Anda sudah benar? (y/n)");
        Scanner scanner = new Scanner(System.in);
        String konfirmasi = scanner.nextLine();
        if (konfirmasi.equalsIgnoreCase("y")) {
            try {
                simpanStrukPembayaran(totalHarga);
            } catch (IOException e) {
                System.out.println("Gagal menyimpan struk pembayaran: " + e.getMessage());
            }
            pesanan.clear();
        } else {
            System.out.println("Pesanan dibatalkan.");
        }
    }

    private static int getHarga(String makanan) {
        switch (makanan) {
            case "Nasi Goreng":
                return 15000;
            case "Mie Goreng":
                return 13000;
            case "Es Teh":
                return 3000;
            case "Es Jeruk":
                return 5000;
            default:
                return 0;
        }
    }

    private static void simpanStrukPembayaran(int totalHarga) throws IOException {
        try (FileWriter writer = new FileWriter(FILENAME)) {
            writer.write("===== Struk Pembayaran =====\n");
            for (Map.Entry<String, Integer> entry : pesanan.entrySet()) {
                String makanan = entry.getKey();
                int harga = getHarga(makanan);
                int jumlah = entry.getValue();
                writer.write(makanan + ": " + jumlah + " x Rp " + harga + "\n");
            }
            writer.write("Total Harga: Rp " + totalHarga + "\n");
            System.out.println("Struk pembayaran telah disimpan sebagai " + FILENAME);
        }
    }
}
