public class Kendaraan {
    private String jenis;
    private int lamaParkir; // dalam jam
    private static final int TARIF_MOTOR = 3000;
    private static final int TARIF_MOBIL = 5000;
    private static final int TARIF_TRUK = 8000;

    public Kendaraan(String jenis) {
        this.jenis = jenis.toLowerCase();
    }

    public void setLamaParkir(int lamaParkir) {
        this.lamaParkir = lamaParkir;
    }

    public void setLamaParkir(int jamMasuk, int jamKeluar) {
        this.lamaParkir = jamKeluar - jamMasuk;
        if (this.lamaParkir < 0) this.lamaParkir = 0;
    }

    public int getLamaParkir() {
        return lamaParkir;
    }

    public double hitungBiaya() {
        int tarifPerJam;
        switch (jenis) {
            case "motor":
                tarifPerJam = TARIF_MOTOR;
                break;
            case "mobil":
                tarifPerJam = TARIF_MOBIL;
                break;
            case "truk":
                tarifPerJam = TARIF_TRUK;
                break;
            default:
                tarifPerJam = 0;
        }

        double total = lamaParkir * tarifPerJam;

        if (lamaParkir > 5) {
            total *= 0.9; // diskon 10%
        }

        return total;
    }

    public void tampilkanRingkasan() {
        System.out.println("=== Ringkasan Parkir ===");
        System.out.println("Jenis Kendaraan : " + jenis);
        System.out.println("Lama Parkir     : " + lamaParkir + " jam");
        System.out.println("Total Biaya     : Rp " + hitungBiaya());
        System.out.println("========================");
    }

    public String getJenis() {
        return jenis;
    }
}
