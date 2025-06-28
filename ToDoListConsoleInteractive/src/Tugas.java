public class Tugas {
    private String deskripsi;
    private boolean selesai;

    public Tugas(String deskripsi) {
        this.deskripsi = deskripsi;
        this.selesai = false;
    }

    public String getDeskripsi() { return deskripsi; }
    public boolean isSelesai() { return selesai; }
    public void tandaiSelesai() { this.selesai = true; }

    @Override
    public String toString() {
        return (selesai ? "\u001B[32m[Selesai]\u001B[0m " : "\u001B[31m[Belum ]\u001B[0m ") + deskripsi;
    }
}
