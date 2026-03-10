fun main() {
    println("==== SISTEM PENILAIAN ====")
    print("Masukkan nama mahasiswa : ")
    val nama = readLine()!!
    print("Masukkan Nilai UTS (0-100): ")
    var inputUts = readLine()!!
    var uts = inputUts.toDoubleOrNull()

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

    val nilaiAkhir = (uts * 0.3) + (uas * 0.4) + (tugas * 0.3)

    val nilaiHuruf = when {
        nilaiAkhir >= 85 -> "A"
        nilaiAkhir >= 70 -> "B"
        nilaiAkhir >= 60 -> "C"
        nilaiAkhir >= 50 -> "D"
        else             -> "E"
    }
    val keterangan = when {
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