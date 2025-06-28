import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManajerTugas manajer = new ManajerTugas();
        manajer.bacaDariFile();

        while (true) {
            System.out.println("\n\u001B[1;36m=== TO-DO LIST MENU ===\u001B[0m");
            System.out.println("1. ➕ Tambah tugas");
            System.out.println("2. 📋 Tampilkan semua tugas");
            System.out.println("3. ✅ Tandai tugas selesai");
            System.out.println("4. ❌ Hapus tugas");
            System.out.println("5. 💾 Simpan & keluar");
            System.out.print("\u001B[35mPilih menu [1-5]: \u001B[0m");

            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    System.out.print("Masukkan deskripsi tugas: ");
                    manajer.tambahTugas(scanner.nextLine());
                    break;
                case "2":
                    manajer.tampilkanTugas();
                    break;
                case "3":
                    System.out.print("Nomor tugas yang diselesaikan: ");
                    manajer.tandaiSelesai(Integer.parseInt(scanner.nextLine()) - 1);
                    break;
                case "4":
                    System.out.print("Nomor tugas yang dihapus: ");
                    manajer.hapusTugas(Integer.parseInt(scanner.nextLine()) - 1);
                    break;
                case "5":
                    manajer.simpanKeFile();
                    System.out.println("\u001B[34mSampai jumpa!\u001B[0m");
                    return;
                default:
                    System.out.println("\u001B[31mPilihan tidak valid.\u001B[0m");
            }
        }
    }
}
