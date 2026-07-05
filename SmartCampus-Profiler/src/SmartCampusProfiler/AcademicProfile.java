/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SmartCampusProfiler;


public class AcademicProfile {
    private String nama;
    private String npm;

    public AcademicProfile(String nama, String npm) {
        this.nama = nama;
        this.npm = npm;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNama() {
        return nama;
    }

    public String getNpm() {
        return npm;
    }

    public String displayInfo() {
        return "Nama Mahasiswa   : " + nama + 
             "\nNPM Mahasiswa    : " + npm;
    }

    public String displayInfo(String statusAkademik) {
        return displayInfo() + "\nStatus Akademik  : " + statusAkademik;
    }
}