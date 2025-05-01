import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Perusahaan perusahaan = new Perusahaan();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== Sistem Manajemen Karyawan ===");
            System.out.println("1. Tambah Karyawan");
            System.out.println("2. Hapus Karyawan");
            System.out.println("3. Ubah Posisi Karyawan");
            System.out.println("4. Ubah Gaji Karyawan");
            System.out.println("5. Tampilkan Semua Karyawan");
            System.out.println("6. Cari Karyawan berdasarkan ID");
            System.out.println("7. Keluar");
            System.out.print("Pilih opsi (1-7): ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // konsumsi newline

            switch (pilihan) {
                case 1:
                    System.out.print("Berapa karyawan yang ingin ditambahkan? ");
                    int jumlah = scanner.nextInt();
                    scanner.nextLine(); // konsumsi newline

                    for (int i = 1; i <= jumlah; i++) {
                        System.out.println("\nData Karyawan ke-" + i);
                        System.out.print("Masukkan ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Masukkan Nama: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan Posisi: ");
                        String posisi = scanner.nextLine();
                        System.out.print("Masukkan Gaji: ");
                        double gaji = scanner.nextDouble();
                        scanner.nextLine();

                        Karyawan baru = new Karyawan(id, nama, posisi, gaji);
                        if (perusahaan.tambahKaryawan(baru)) {
                            System.out.println("Karyawan berhasil ditambahkan.");
                        } else {
                            System.out.println("Gagal: ID sudah digunakan. Karyawan tidak ditambahkan.");
                        }
                    }
                    break;

                case 2:
                    System.out.print("Masukkan ID karyawan yang ingin dihapus: ");
                    String idHapus = scanner.nextLine();
                    if (perusahaan.hapusKaryawan(idHapus)) {
                        System.out.println("Karyawan berhasil dihapus.");
                    } else {
                        System.out.println("Gagal: ID tidak ditemukan.");
                    }
                    break;

                case 3:
                    System.out.print("Masukkan ID karyawan: ");
                    String idPosisi = scanner.nextLine();
                    System.out.print("Masukkan posisi baru: ");
                    String posisiBaru = scanner.nextLine();
                    if (perusahaan.ubahPosisi(idPosisi, posisiBaru)) {
                        System.out.println("Posisi berhasil diubah.");
                    } else {
                        System.out.println("Gagal: ID tidak ditemukan.");
                    }
                    break;

                case 4:
                    System.out.print("Masukkan ID karyawan: ");
                    String idGaji = scanner.nextLine();
                    System.out.print("Masukkan gaji baru: ");
                    double gajiBaru = scanner.nextDouble();
                    scanner.nextLine();
                    if (perusahaan.ubahGaji(idGaji, gajiBaru)) {
                        System.out.println("Gaji berhasil diubah.");
                    } else {
                        System.out.println("Gagal mengubah gaji.");
                    }
                    break;

                case 5:
                    perusahaan.tampilkanSemuaKaryawan();
                    break;

                case 6:
                    System.out.print("Masukkan ID karyawan: ");
                    String idCari = scanner.nextLine();
                    Karyawan hasil = perusahaan.cariKaryawan(idCari);
                    if (hasil != null) {
                        System.out.println("Data Karyawan: " + hasil);
                    } else {
                        System.out.println("Karyawan tidak ditemukan.");
                    }
                    break;

                case 7:
                    System.out.println("Terima kasih. Program selesai.");
                    break;

                default:
                    System.out.println("Opsi tidak valid.");
            }
        } while (pilihan != 7);

        scanner.close();
    }
}
