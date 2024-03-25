import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Produk {
    protected int id;
    protected String nama;
    protected double harga;

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

class ProdukDiskon extends Produk {
    private double diskon;

    public ProdukDiskon(int id, String nama, double harga, double diskon) {
        super(id, nama, harga);
        this.diskon = diskon;
    }

    public double getDiskon() {
        return diskon;
    }

    public void setDiskon(double diskon) {
        this.diskon = diskon;
    }
}

class ProdukRaket extends Produk {
    private String tipeSenar;

    public ProdukRaket(int id, String nama, double harga, String tipeSenar) {
        super(id, nama, harga);
        this.tipeSenar = tipeSenar;
    }

    public String getTipeSenar() {
        return tipeSenar;
    }

    public void setTipeSenar(String tipeSenar) {
        this.tipeSenar = tipeSenar;
    }
}

class ProdukLokal extends Produk {
    private String daerahAsal;

    public ProdukLokal(int id, String nama, double harga, String daerahAsal) {
        super(id, nama, harga);
        this.daerahAsal = daerahAsal;
    }

    public String getDaerahAsal() {
        return daerahAsal;
    }

    public void setDaerahAsal(String daerahAsal) {
        this.daerahAsal = daerahAsal;
    }
}

class TokoBadminton {
    private ArrayList<Produk> produk;
    private int idSelanjutnya;

    public TokoBadminton() {
        produk = new ArrayList<>();
        idSelanjutnya = 1;
    }

    public void tambahProdukDiskon(String nama, double harga, double diskon) {
        produk.add(new ProdukDiskon(idSelanjutnya++, nama, harga, diskon));
        System.out.println("Produk Diskon berhasil ditambahkan!");
    }

    public void tambahProdukRaket(String nama, double harga, String tipeSenar) {
        produk.add(new ProdukRaket(idSelanjutnya++, nama, harga, tipeSenar));
        System.out.println("Produk Raket berhasil ditambahkan!");
    }

    public void tambahProdukLokal(String nama, double harga, String daerahAsal) {
        produk.add(new ProdukLokal(idSelanjutnya++, nama, harga, daerahAsal));
        System.out.println("Produk Lokal berhasil ditambahkan!");
    }

    public void tampilkanProduk() {
        if (produk.isEmpty()) {
            System.out.println("Tidak ada produk di toko badminton.");
        } else {
            System.out.println("Produk di toko badminton:");
            for (Produk p : produk) {
                if (p instanceof ProdukDiskon) {
                    ProdukDiskon pd = (ProdukDiskon) p;
                    System.out.println("ID: " + pd.getId() + ", Nama: " + pd.getNama() + ", Harga: Rp" + pd.getHarga() + ", Diskon: " + pd.getDiskon() + "%");
                } else if (p instanceof ProdukRaket) {
                    ProdukRaket pr = (ProdukRaket) p;
                    System.out.println("ID: " + pr.getId() + ", Nama: " + pr.getNama() + ", Harga: Rp" + pr.getHarga() + ", Tipe Senar: " + pr.getTipeSenar());
                } else if (p instanceof ProdukLokal) {
                    ProdukLokal pl = (ProdukLokal) p;
                    System.out.println("ID: " + pl.getId() + ", Nama: " + pl.getNama() + ", Harga: Rp" + pl.getHarga() + ", Daerah Asal: " + pl.getDaerahAsal());
                }
            }
        }
    }

    public void perbaruiProduk(int id, String nama, double harga) {
        boolean ditemukan = false;
        for (Produk p : produk
        ) {
            if (p.getId() == id) {
                p.setNama(nama);
                p.setHarga(harga);
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
            System.out.println("1. Tambah Produk Diskon");
            System.out.println("2. Tambah Produk Raket");
            System.out.println("3. Tambah Produk Lokal");
            System.out.println("4. Tampilkan Produk");
            System.out.println("5. Perbarui Produk");
            System.out.println("6. Hapus Produk");
            System.out.println("7. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            int pilihan = 0;
            try {
                pilihan = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Masukkan pilihan sesuai dengan angka (1-7).");
                scanner.nextLine(); // Membersihkan input yang tidak valid
                continue;
            }

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama produk diskon: ");
                    scanner.nextLine(); // Konsumsi newline
                    String namaDiskon = scanner.nextLine();
                    System.out.print("Masukkan harga produk diskon: Rp");
                    double hargaDiskon = 0;
                    try {
                        hargaDiskon = scanner.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("Masukkan harga dalam format numerik.");
                        scanner.nextLine(); // Membersihkan input yang tidak valid
                        continue;
                    }
                    System.out.print("Masukkan besaran diskon (%): ");
                    double diskon = 0;
                    try {
                        diskon = scanner.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("Masukkan diskon dalam format numerik.");
                        scanner.nextLine(); // Membersihkan input yang tidak valid
                        continue;
                    }
                    toko.tambahProdukDiskon(namaDiskon, hargaDiskon, diskon);
                    break;
                case 2:
                    System.out.print("Masukkan nama produk raket: ");
                    scanner.nextLine(); // Konsumsi newline
                    String namaRaket = scanner.nextLine();
                    System.out.print("Masukkan harga produk raket: Rp");
                    double hargaRaket = 0;
                    try {
                        hargaRaket = scanner.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("Masukkan harga dalam format numerik.");
                        scanner.nextLine(); // Membersihkan input yang tidak valid
                        continue;
                    }
                    scanner.nextLine(); // Membersihkan newline
                    System.out.print("Masukkan tipe senar produk raket: ");
                    String tipeSenarRaket = scanner.nextLine();
                    toko.tambahProdukRaket(namaRaket, hargaRaket, tipeSenarRaket);
                    break;
                case 3:
                    System.out.print("Masukkan nama produk lokal: ");
                    scanner.nextLine(); // Konsumsi newline
                    String namaLokal = scanner.nextLine();
                    System.out.print("Masukkan harga produk lokal: Rp");
                    double hargaLokal = 0;
                    try {
                        hargaLokal = scanner.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("Masukkan harga dalam format numerik.");
                        scanner.nextLine(); // Membersihkan input yang tidak valid
                        continue;
                    }
                    scanner.nextLine(); // Membersihkan newline
                    System.out.print("Masukkan daerah asal produk lokal: ");
                    String daerahAsal = scanner.nextLine();
                    toko.tambahProdukLokal(namaLokal, hargaLokal, daerahAsal);
                    break;
                case 4:
                    toko.tampilkanProduk();
                    break;
                case 5:
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
                case 6:
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
                case 7:
                    keluar = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }
        
        // Penutupan scanner setelah keluar dari loop
        scanner.close();
    }
}
