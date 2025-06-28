import java.io.*;
import java.util.*;

public class ManajerTugas {
    private List<Tugas> daftarTugas = new ArrayList<>();
    private static final String FILE_NAME = "tugas.txt";

    public void tambahTugas(String deskripsi) {
        daftarTugas.add(new Tugas(deskripsi));
        System.out.println("\u001B[34mTugas berhasil ditambahkan!\u001B[0m");
    }

    public void tandaiSelesai(int index) {
        if (index >= 0 && index < daftarTugas.size()) {
            daftarTugas.get(index).tandaiSelesai();
            System.out.println("\u001B[32mTugas ditandai selesai.\u001B[0m");
        } else {
            System.out.println("\u001B[31mNomor tugas tidak valid.\u001B[0m");
        }
    }

    public void hapusTugas(int index) {
        if (index >= 0 && index < daftarTugas.size()) {
            daftarTugas.remove(index);
            System.out.println("\u001B[33mTugas berhasil dihapus.\u001B[0m");
        } else {
            System.out.println("\u001B[31mNomor tugas tidak valid.\u001B[0m");
        }
    }

    public void tampilkanTugas() {
        if (daftarTugas.isEmpty()) {
            System.out.println("\u001B[36mBelum ada tugas.\u001B[0m");
        } else {
            System.out.println("\n\u001B[1mDaftar Tugas:\u001B[0m");
            for (int i = 0; i < daftarTugas.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + daftarTugas.get(i));
            }
        }
    }

    public void simpanKeFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Tugas t : daftarTugas) {
                writer.println(t.isSelesai() + ";" + t.getDeskripsi());
            }
            System.out.println("\u001B[32mTugas disimpan ke file.\u001B[0m");
        } catch (IOException e) {
            System.out.println("\u001B[31mGagal menyimpan ke file.\u001B[0m");
        }
    }

    public void bacaDariFile() {
        daftarTugas.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";", 2);
                Tugas t = new Tugas(parts[1]);
                if (Boolean.parseBoolean(parts[0])) {
                    t.tandaiSelesai();
                }
                daftarTugas.add(t);
            }
            System.out.println("\u001B[36mTugas dimuat dari file.\u001B[0m");
        } catch (IOException e) {
            System.out.println("\u001B[33mFile tidak ditemukan, mulai dengan daftar kosong.\u001B[0m");
        }
    }
}
