/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SmartCampusProfiler;



public class ProfileTracker extends AcademicProfile {
    
    public ProfileTracker(String nama, String npm) {
        super(nama, npm);
    }

    // Accessor: Ekstraksi Tahun Masuk dari 2 digit awal NPM
    public int getTahunMasuk() {
        return Integer.parseInt(getNpm().substring(0, 2)) + 2000;
    }

    // Seleksi (If-Else): Pelacakan Fakultas
    public String getFakultas() {
        String kodeFakultas = getNpm().substring(2, 4);
        if (kodeFakultas.equals("10")) {
            return "Fakultas Teknologi Informasi";
        } else {
            return "Fakultas Lain";
        }
    }

    // Seleksi (Switch-Case): Pelacakan Program Studi
    public String getProdi() {
        String kodeProdi = getNpm().substring(4, 6);
        switch (kodeProdi) {
            case "01":
                return "Teknik Informatika";
            case "02":
                return "Sistem Informasi";
            default:
                return "Program Studi Lain";
        }
    }

    // Accessor: Mendapatkan Nomor Registrasi Unik
    public String getNoRegistrasi() {
        return getNpm().substring(6, 10);
    }

    // UNNECESSARY DETAIL BARU: Validasi Logika Tahun Ajaran Kontemporer (Maksimal Tahun Sekarang 2026)
    public String getValidasiTahunAjaran() {
        int tahun = getTahunMasuk();
        if (tahun < 1981 || tahun > 2026) {
            return "\u001B[31m[REJECTED] Tahun Angkatan Anomali (" + tahun + ")\u001B[0m";
        } else {
            return "\u001B[32m[VERIFIED] Tahun Angkatan Valid (" + tahun + ")\u001B[0m";
        }
    }

    // Polymorphism Overriding: Menampilkan data modifikasi penuh detail
    @Override
    public String displayInfo() {
        return super.displayInfo() +
               "\nTahun Masuk      : " + getTahunMasuk() + " -> " + getValidasiTahunAjaran() +
               "\nFakultas         : " + getFakultas() +
               "\nProgram Studi    : " + getProdi() +
               "\nNo. Registrasi   : " + getNoRegistrasi();
    }
}