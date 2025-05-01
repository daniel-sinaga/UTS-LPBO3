import java.util.ArrayList;

public class Perusahaan {
    private ArrayList<Karyawan> daftarKaryawan = new ArrayList<>();

    public boolean tambahKaryawan(Karyawan karyawan) {
        if (cariKaryawan(karyawan.getId()) != null) {
            return false;
        }
        daftarKaryawan.add(karyawan);
        return true;
    }

    public boolean hapusKaryawan(String id) {
        Karyawan karyawan = cariKaryawan(id);
        if (karyawan != null) {
            daftarKaryawan.remove(karyawan);
            return true;
        }
        return false;
    }

    public boolean ubahPosisi(String id, String posisiBaru) {
        Karyawan karyawan = cariKaryawan(id);
        if (karyawan != null) {
            karyawan.setPosisi(posisiBaru);
            return true;
        }
        return false;
    }

    public boolean ubahGaji(String id, double gajiBaru) {
        Karyawan karyawan = cariKaryawan(id);
        if (karyawan != null) {
            try {
                karyawan.setGaji(gajiBaru);
                return true;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return false;
    }

    public void tampilkanSemuaKaryawan() {
        if (daftarKaryawan.isEmpty()) {
            System.out.println("Tidak ada karyawan.");
        } else {
            for (Karyawan k : daftarKaryawan) {
                System.out.println(k);
            }
        }
    }

    public Karyawan cariKaryawan(String id) {
        for (Karyawan k : daftarKaryawan) {
            if (k.getId().equalsIgnoreCase(id)) {
                return k;
            }
        }
        return null;
    }
}
