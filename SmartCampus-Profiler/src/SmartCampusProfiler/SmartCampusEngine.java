/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SmartCampusProfiler;




import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Date;

public class SmartCampusEngine {
    
    // Palet Warna ANSI untuk Efek Visual Log Terminal
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String CYAN = "\u001B[36m";
    private static final String PURPLE = "\u001B[35m";

    public static void main(String[] args) {
        // IO Sederhana: Menggunakan Scanner untuk membaca input keyboard
        Scanner inputScanner = new Scanner(System.in);
        
        // Error Handling: Membungkus seluruh core program dengan blok Try-Catch
        try {
            // Tampilan Banner Huruf Besar yang Mewah & Estetik
            System.out.println(CYAN + "________________________________________________________" + RESET);
            System.out.println(CYAN + "   _____                      _   _____                               " + RESET);
            System.out.println(CYAN + "  / ____|                    | | / ____|                              " + RESET);
            System.out.println(CYAN + " | (___  _ __ ___   __ _ _ __| || |     __ _ _ __ ___  _ __  _   _ ___ " + RESET);
            System.out.println(CYAN + "  \\___ \\| '_ ` _ \\ / _` | '__| || |    / _` | '_ ` _ \\| '_ \\| | | / __|" + RESET);
            System.out.println(CYAN + "  ____) | | | | | | (_| | |  | || |___| (_| | | | | | | |_) | |_| \\__ \\" + RESET);
            System.out.println(CYAN + " |_____/|_| |_| |_|\\__,_|_|  |_| \\_____\\__,_|_| |_| |_| .__/ \\__,_|___/" + RESET);
            System.out.println(CYAN + "                                                      | |             " + RESET);
            System.out.println(CYAN + "   [ SYSTEM VERSION 5.2.0 - SECURE CORE ONLINE ]      |_|             " + RESET);
            System.out.println(CYAN + "________________________________________________________" + RESET);
            System.out.println(YELLOW + "Log Waktu Akses Server: " + new Date() + RESET);
            System.out.println("--------------------------------------------------------");
            
            // SYSTEM GUARD #1: Validasi Input Jumlah Data Bukan Angka
            int totalData = 0;
            while (true) {
                try {
                    System.out.print(PURPLE + "[Sistem] " + RESET + "Masukkan jumlah mahasiswa yang ingin di-track: ");
                    totalData = inputScanner.nextInt();
                    inputScanner.nextLine(); // Membersihkan sisa baris baru enter
                    
                    if (totalData <= 0) {
                        System.out.println(YELLOW + "[PERINGATAN] Jumlah data harus lebih besar dari 0!" + RESET);
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println(RED + "[ERROR] Input tidak valid! Harap masukkan data berupa angka." + RESET);
                    inputScanner.nextLine(); // Membersihkan token buffer scanner yang rusak
                }
            }
            
            // Array of Objects: Membuat penampung data objek subclass
            ProfileTracker[] databaseCampus = new ProfileTracker[totalData];
            
            // Perulangan: Menggunakan loop untuk mengisi data ke dalam array
            for (int i = 0; i < databaseCampus.length; i++) {
                System.out.println("\n" + CYAN + "--- Input Data Mahasiswa ke-" + (i + 1) + " ---" + RESET);
                
                System.out.print("Masukkan Nama Lengkap: ");
                String nama = inputScanner.nextLine();
                
                // SYSTEM GUARD #2: Validasi Nama Tidak Boleh Menggandung Karakter Angka (Regex)
                if (nama.matches(".*\\d.*")) {
                    System.out.println(RED + "[DITOLAK] Nama mahasiswa dilarang mengandung karakter angka!" + RESET);
                    System.out.println(YELLOW + "[🔄 Rollback] Mengulang kembali penginputan data ke-" + (i + 1) + RESET);
                    i--; // Memundurkan indeks loop untuk mengulang input
                    continue;
                }
                
                System.out.print("Masukkan 10-Digit NPM: ");
                String npm = inputScanner.nextLine();
                
                // SYSTEM GUARD #3: Validasi NPM Wajib Angka dan Tepat Berjumlah 10 Digit
                if (npm.length() != 10 || !npm.matches("\\d+")) {
                    System.out.println(RED + "[DITOLAK] NPM tidak valid! Wajib angka dan harus tepat 10 digit." + RESET);
                    System.out.println(YELLOW + "[🔄 Rollback] Mengulang kembali penginputan data ke-" + (i + 1) + RESET);
                    i--; // Memundurkan indeks loop untuk mengulang input
                    continue;
                }
                
                // Object Instantiation: Memasukkan objek baru yang valid ke dalam array
                databaseCampus[i] = new ProfileTracker(nama, npm);
                System.out.println(GREEN + "[SUKSES] Data dikunci ke dalam memori." + RESET);
            }
            
            // Perulangan & Output: Menampilkan laporan hasil ekstraksi
            System.out.println("\n" + GREEN + "======================================================");
            System.out.println("        HASIL ANALISIS & TRACKING SMARTCAMPUS        ");
            System.out.println("======================================================" + RESET);
            
            for (ProfileTracker profil : databaseCampus) {
                if (profil != null) {
                    // Cyber Security Detail: Sensor Privasi Data Mahasiswa
                    String npmAsli = profil.getNpm();
                    String npmDisensor = npmAsli.substring(0, 6) + "****";
                    
                    System.out.println("ID Otorisasi Sistem : " + YELLOW + npmDisensor + RESET);
                    
                    // Memanggil method Polimorfisme Overriding & Validasi Tahun Sekaligus
                    System.out.println(profil.displayInfo());
                    System.out.println("------------------------------------------------------");
                }
            }
            
        } catch (Exception e) {
            System.out.println("\n" + RED + "[CRITICAL ERROR] Terjadi kesalahan fatal: " + e.getMessage() + RESET);
        } finally {
            // Garbage Collection Hint untuk Manajemen Siklus Memori JVM
            System.gc();
            System.out.println("\n" + CYAN + "======================================================");
            System.out.println("Sistem SmartCampus-Profiler Berhasil Dijalankan.");
            System.out.println("======================================================" + RESET);
            inputScanner.close();
        }
    }
}