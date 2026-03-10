// Ayu Diana (F1D02310040)
fun main() {
    println("==== SISTEM PENILAIAN ====")
    print("Masukkan nama mahasiswa : ")
    val nama = readLine()!! //MEMASUKKAN INPUT MAHASISWA
    print("Masukkan Nilai UTS (0-100): ")
    var inputUts = readLine()!!//MENGINPUTKAN NILAI UTS
    var uts = inputUts.toDoubleOrNull() //DIGUNAKAN UNTUK MENGUBAH NILAI DARI VARIABEL UTS MENJADI NULL JIKA MENGINPUT SELAIN ANGKA AKAN DIUBAH MENJADI NULL
    //PERULANGAN YANG DIGUNAKAN UNTUK MENGECEK APAKAH NILAI YANG DIINPUTKAN NILAI ANGKA ATAU TIDAK JIKA MENGINPUTKAN SELAIN ANGKA MAKA AKAN DIMINTA INPUT KEMBALI
    while (uts == null || uts < 0 || uts > 100) {
            println("Nilai harus antara 0 - 100, coba lagi!")
            print("Masukkan Nilai UTS (0-100): ")
            inputUts = readLine()!!
            uts = inputUts.toDoubleOrNull()
    }
    print("Masukkan Nilai UAS (0-100): ")
    var inputUas = readLine()!!
    var uas = inputUas.toDouble()
    while (uas == null|| uas < 0 || uas > 100) {
        println("Nilai harus antara 0 - 100, coba lagi!")
        print("Masukkan Nilai UAS (0-100): : ")
        inputUas = readLine()!!
        uas= inputUas.toDouble()
    }
    print("Masukkan Nilai Tugas (0-100): ")
    var inputTugas = readLine()!!
    var tugas = inputTugas.toDouble()
    while (tugas == null|| tugas < 0 || tugas > 100) {
        println("Nilai harus antara 0 - 100, coba lagi!")
        print("Masukkan Nilai TUGAS (0-100): ")
        inputTugas = readLine()!!
        tugas=inputTugas.toDouble()
    }
    //RUMUS UNTUK MENDAPATKAN NILAI AKHIR DARI MAHASISWA DENGAN PEMBAGIAN UTS 30%, UAS 40%, DAN TUGAS 30%
    val nilaiAkhir = (uts * 0.3) + (uas * 0.4) + (tugas * 0.3)
    //MEMBERIKAN GRADE BERDASARKAN NILAI AKHIR
    val nilaiHuruf = when {
        nilaiAkhir >= 85 -> "A"
        nilaiAkhir >= 70 -> "B"
        nilaiAkhir >= 60 -> "C"
        nilaiAkhir >= 50 -> "D"
        else             -> "E"
    }
    val keterangan = when { // KETERANGAN DARI NILAI YANG DIDAPATKAN DARI NILAI AKHIR
        nilaiAkhir >= 85 -> "Sangat Baik"
        nilaiAkhir >= 70 -> "Baik"
        nilaiAkhir >= 60 -> "Cukup"
        nilaiAkhir >= 50 -> "kurang"
        else             -> "Sangat Kurang"
    }

    val status = if (nilaiAkhir >= 60) "LULUS" else "TIDAK LULUS"
    val penutup = if (nilaiAkhir >= 60) "Selamat! Anda dinyatakan LULUS" else "Yaudahlah, selamat ngulang"
    println("==== HASIL PENILAIAN ====")
    println("Nama         : $nama")
    println("Nilai UTS    : $uts")
    println("Nilai UAS    : $uas")
    println("Nilai Tugas  : $tugas")
    println("--------------------------")
    println("Nilai Akhir  : $nilaiAkhir")
    println("Grade        : $nilaiHuruf")
    println("Keterangan   : $keterangan")
    println("Status       : $status")
    println("$penutup")

}
