import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();

        boolean lanjut = true;
        while (lanjut) {
            System.out.println("\nMasukkan jenis kendaraan (motor/mobil/truk): ");
            String jenis = input.nextLine();

            Kendaraan kendaraan = new Kendaraan(jenis);

            int metode;
            while (true) {
                System.out.println("Pilih cara input durasi parkir:");
                System.out.println("1. Input langsung jumlah jam");
                System.out.println("2. Input jam masuk dan jam keluar");
                System.out.print("Pilihan: ");
                try {
                    metode = Integer.parseInt(input.nextLine());
                    if (metode == 1 || metode == 2) break;
                } catch (Exception e) {}
                System.out.println("Pilihan tidak valid, coba lagi.");
            }

            if (metode == 1) {
                int durasi;
                while (true) {
                    System.out.print("Masukkan lama parkir (jam): ");
                    durasi = Integer.parseInt(input.nextLine());
                    if (durasi > 0) break;
                    System.out.println("Durasi harus lebih dari 0!");
                }
                kendaraan.setLamaParkir(durasi);
            } else {
                int masuk, keluar;
                while (true) {
                    System.out.print("Jam masuk (0-23): ");
                    masuk = Integer.parseInt(input.nextLine());
                    System.out.print("Jam keluar (0-23): ");
                    keluar = Integer.parseInt(input.nextLine());

                    if (masuk >= 0 && masuk <= 23 && keluar >= 0 && keluar <= 23) {
                        int durasi = keluar - masuk;
                        if (durasi > 0) {
                            kendaraan.setLamaParkir(masuk, keluar);
                            break;
                        } else {
                            System.out.println("Jam keluar harus lebih besar dari jam masuk!");
                        }
                    } else {
                        System.out.println("Jam harus antara 0 sampai 23!");
                    }
                }
            }

            kendaraan.tampilkanRingkasan();
            daftarKendaraan.add(kendaraan);

            // Real-time
            double totalBiaya = 0;
            for (Kendaraan k : daftarKendaraan) {
                totalBiaya += k.hitungBiaya();
            }

            System.out.println("\n--- Ringkasan Sementara ---");
            System.out.println("Total kendaraan terparkir: " + daftarKendaraan.size());
            System.out.println("Total semua biaya parkir: Rp " + totalBiaya);
            System.out.println("----------------------------");

            System.out.print("\nTambahkan kendaraan lain? (y/n): ");
            String jawaban = input.nextLine();
            lanjut = jawaban.equalsIgnoreCase("y");
        }

        // BENTUK TABEL
        System.out.println("\n=== RINGKASAN AKHIR ===");
        System.out.printf("%-5s %-18s %-18s %-15s%n", "No", "Jenis Kendaraan", "Lama Parkir (jam)", "Total Biaya (Rp)");
        System.out.println("---------------------------------------------------------------");

        double total = 0;
        for (int i = 0; i < daftarKendaraan.size(); i++) {
            Kendaraan k = daftarKendaraan.get(i);
            double biaya = k.hitungBiaya();
            total += biaya;
            System.out.printf("%-5d %-18s %-18d %-15.0f%n", (i + 1), k.getJenis(), k.getLamaParkir(), biaya);
        }

        System.out.println("---------------------------------------------------------------");
        System.out.printf("Total Kendaraan: %-3d        Total Biaya: Rp %.0f%n", daftarKendaraan.size(), total);
        System.out.println("===============================================================");
    }
}
