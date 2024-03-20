import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Produk {
    private int id;
    private String nama;
    private double harga;

    public Produk(int id, String nama, double harga) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
}

class TokoBadminton {
    private ArrayList<Produk> produk;
    private int idSelanjutnya;

    public TokoBadminton() {
        produk = new ArrayList<>();
        idSelanjutnya = 1;
    }

    public void tambahProduk(String nama, double harga) {
        produk.add(new Produk(idSelanjutnya++, nama, harga));
        System.out.println("Produk berhasil ditambahkan!");
    }

    public void tampilkanProduk() {
        if (produk.isEmpty()) {
            System.out.println("Tidak ada produk di toko badminton.");
        } else {
            System.out.println("Produk di toko badminton:");
            for (Produk produk : produk) {
                System.out.println("ID: " + produk.getId() + ", Nama: " + produk.getNama() + ", Harga: Rp" + produk.getHarga());
            }
        }
    }

    public void perbaruiProduk(int id, String nama, double harga) {
        boolean ditemukan = false;
        for (Produk produk : produk) {
            if (produk.getId() == id) {
                produk.setNama(nama);
                produk.setHarga(harga);
                System.out.println("Produk berhasil diperbarui!");
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Produk dengan ID " + id + " tidak ditemukan.");
        }
    }

    public void hapusProduk(int id) {
        boolean ditemukan = false;
        for (int i = 0; i < produk.size(); i++) {
            if (produk.get(i).getId() == id) {
                produk.remove(i);
                System.out.println("Produk berhasil dihapus!");
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Produk dengan ID " + id + " tidak ditemukan.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TokoBadminton toko = new TokoBadminton();

        boolean keluar = false;
        while (!keluar) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Produk");
            System.out.println("3. Perbarui Produk");
            System.out.println("4. Hapus Produk");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            int pilihan = 0;
            try {
                pilihan = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Masukkan pilihan sesuai dengan angka (1-5).");
                scanner.nextLine(); // Membersihkan input yang tidak valid
                continue;
            }

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama produk: ");
                    scanner.nextLine(); // Konsumsi newline
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan harga produk: Rp");
                    double harga = 0;
                    try {
                        harga = scanner.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("Masukkan harga dalam format numerik.");
                        scanner.nextLine(); // Membersihkan input yang tidak valid
                        continue;
                    }
                    toko.tambahProduk(nama, harga);
                    break;
                case 2:
                    toko.tampilkanProduk();
                    break;
                case 3:
                    System.out.print("Masukkan ID produk yang ingin diperbarui: ");
                    int idPerbarui = 0;
                    try {
                        idPerbarui = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Masukkan ID dalam format numerik.");
                        scanner.nextLine(); // Membersihkan input yang tidak valid
                        continue;
                    }
                    System.out.print("Masukkan nama baru produk: ");
                    scanner.nextLine(); // Konsumsi newline
                    String namaBaru = scanner.nextLine();
                    System.out.print("Masukkan harga baru produk: Rp");
                    double hargaBaru = 0;
                    try {
                        hargaBaru = scanner.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("Masukkan harga dalam format numerik.");
                        scanner.nextLine(); // Membersihkan input yang tidak valid
                        continue;
                    }
                    toko.perbaruiProduk(idPerbarui, namaBaru, hargaBaru);
                    break;
                case 4:
                    System.out.print("Masukkan ID produk yang ingin dihapus: ");
                    int idHapus = 0;
                    try {
                        idHapus = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Masukkan ID dalam format numerik.");
                        scanner.nextLine(); // Membersihkan input yang tidak valid
                        continue;
                    }
                    toko.hapusProduk(idHapus);
                    break;
                case 5:
                    keluar = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
        System.out.println("Keluar dari program. Sampai jumpa!");
        scanner.close();
    }
}
