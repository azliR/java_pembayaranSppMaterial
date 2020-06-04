package cores.styles;

/**
 *
 * @author rizal
 */
public class Strings {

    public static final String ERROR_DIALOG_DEFAULT_TITLE = "Terjadi Kesalahan";
    public static final String ERROR_DIALOG_DEFAULT_MESSAGE
            = "Terjadi kesalahan yang tidak terduga. Segera hubungi Admin untuk tindak lanjut.";

    public static final String ERROR_DIALOG_CONNECTION
            = "Terjadi kesalahan ketika mengakses server. Cek koneksi Anda dan coba kembali.";

    public static final String ERROR_DIALOG_WRONG_PASSWORD
            = "Nama Pengguna atau kata sandi yang Anda masukkan salah!";
    public static final String ERROR_DIALOG_EXISTING_NISN
            = "NISN ini sudah dipakai oleh siswa lain.";

    public static final String ERROR_DIALOG_FAILED_GET_IMAGE_FROM_DISK
            = "Terjadi kesalahan ketika mengambil gambar dari penyimpanan Anda. Silahkan coba kembali.";
    public static final String ERROR_DIALOG_EMPTY_FIELD
            = "Isi semua kolom yang dibutuhkan!";
    public static final String ERROR_DIALOG_NISN_NIS_LENGTH
            = "NISN atau NIS yang Anda masukkan tidak sesuai standar. NISN harus memiliki 10 karakter dan NIS 8 karakter";
    public static final String ERROR_DIALOG_PASSWORD_LENGTH
            = "Kata sandi Anda terlalu lemah. Gunakan setidaknya 8 karakter dengan kombinasi huruf dan simbol.";
    public static final String ERROR_DIALOG_PASSWORD_NOT_MATCH
            = "Kata sandi tidak cocok.";
    public static final String ERROR_DIALOG_NULL_DATA
            = "Data yang diminta tidak ada, silahkan coba kembali atau hubungi Admin untuk tindak lanjut.";
    public static final String ERROR_DIALOG_ID_IS_NOT_NULL
            = "Terdapat ID yang tersisa dari petugas sebelumnya. Silahkan mulai ulang aplikasi dan coba lagi.";
    public static final String ERROR_DIALOG_ID_IS_NULL
            = "Tidak dapat mengubah data ini karena ID tidak ditemukan. Silahkan mulai ulang aplikasi atau hubungi Admin untuk tindak lanjut.";
    public static final String ERROR_DIALOG_NO_SESSION
            = "Anda belum melakukan sesi masuk. Anda akan dialihkan ke halaman masuk.";

    public static final String SUCCESS_DIALOG_DEFAULT = "Berhasil";
    public static final String SUCCESS_DIALOG_INSERT = "Data berhasil disimpan!";

    public static final String DIALOG_ENTER_PASSWORD_MESSAGE
            = "Masukkan kata sandi akun Anda saat ini";
    public static final String DIALOG_DELETE_TITLE = "Hapus data?";

    public static final char DATABASE_JENIS_KELAMIN_L = 'L';
    public static final char DATABASE_JENIS_KELAMIN_P = 'p';
    public static final String DATABASE_BELUM_DIBAYAR = "Belum dibayar";
    public static final String DATABASE_TELAH_DIBAYAR = "Telah dibayar";
    public static final String DATABASE_SEDANG_AKTIF = "Sedang Aktif";
    public static final String DATABASE_TIDAK_AKTIF = "Tidak Aktif";

    public static final String LAKI_LAKI = "Laki-Laki";
    public static final String PEREMPUAN = "Perempuan";
    public static final String SEMUA = "Semua";

    public static final String SEARCH_HINT = "Cari siswa & mulai pembayaran";

    public static final String ADD_PETUGAS = "Tambah Petugas";
    public static final String EDIT_PETUGAS = "Edit Petugas";
    public static final String NAMA_LENGKAP = "Nama Lengkap";
    public static final String NAMA_PENGGUNA = "Nama Pengguna";
    public static final String NOMOR_TELEPON = "No. Telepon";
    public static final String KATA_SANDI = "Kata Sandi";
    public static final String KONFIRMASI_KATA_SANDI = "Konfirmasi Kata Sandi";
    public static final String HAK_AKSES = "Hak Akses";
    public static final String PETUGAS = "Petugas";
    public static final String ADMINISTRATOR = "Administrator";
    public static final String NAMA_BARU = "Nama Baru";
    public static final String UBAH_NAMA = "Ubah Nama";
    public static final String UBAH_NAMA_DESC
            = "Perubahan nama akan diterapkan di akun Anda.";
    public static final String NAMA_PENGGUNA_BARU = "Nama Pengguna Baru";
    public static final String UBAH_NAMA_PENGGUNA = "Ubah Nama Pengguna";
    public static final String UBAH_NAMA_PENGGUNA_DESC
            = "Perubahan nama pengguna akan diterapkan di akun Anda.";
    public static final String NOMOR_TELEPON_BARU = "No. Telepon Baru";
    public static final String UBAH_NOMOR_TELEPON = "Ubah Nomor Telepon";
    public static final String UBAH_NOMOR_TELEPON_DESC
            = "Perubahan nomor telepon akan diterapkan di akun Anda.";
    public static final String KATA_SANDI_BARU = "Sandi Baru";
    public static final String KONFIRMASI_KATA_SANDI_BARU
            = "Konfirmasi Sandi Baru";
    public static final String UBAH_KATA_SANDI = "Ubah Sandi";
    public static final String UBAH_KATA_SANDI_DESC
            = "Untuk keamanan, pilih sandi yang kuat dan jangan gunakan lagi untuk akun lain.";
    public static final String KERUMITAN_KATA_SANDI = "Kerumitan sandi";
    public static final String KERUMITAN_KATA_SANDI_CONTENT
            = "Gunakan sedikitnya 8 karakter. Jangan gunakan sandi dari situs lain atau sesuatu yang mudah ditebak seperti nama hewan peliharaan Anda.";

    public static final String PROFIL = "Profil";
    public static final String PROFIL_DESC
            = "Info ini akan ditampilkan ketika Anda melakukan transaksi pembayaran.";
    public static final String INFO_LAINNYA = "Info lainnya";
    public static final String INFO_LAINNYA_DESC
            = "Info ini tidak dapat dilihat oleh siapapun. Hanya Anda dan Administrator yang dapat melihat info ini.";

    public static final String DIBUAT_PADA = "Dibuat pada";
    public static final String TERAKHIR_MASUK = "Terakhir masuk";
    public static final String TERAKHIR_UBAH_SANDI = "Terakhir sandi diubah";
    public static final String STATUS = "Status";

    private Strings() {
    }
}
