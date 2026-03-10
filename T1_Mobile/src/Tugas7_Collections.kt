fun main (){
    data class NilaiMahasiswa(
        val nim: String,
        val nama: String,
        val matakuliah: String,
        val nilai: Int
    )
    fun getGrade(nilai: Int): String {
        return when {
            nilai >= 85 -> "A"
            nilai >= 75 -> "B"
            nilai >= 65 -> "C"
            nilai >= 55 -> "D"
            else        -> "E"
        }
    }
    val dataMahasiswa = listOf(
        NilaiMahasiswa("F1D02310040", "Ayu Diana", "Pemrograman Bergerak", 100),
        NilaiMahasiswa("F1D0200001", "Eka", "Pemrograman Bergerak", 70),
        NilaiMahasiswa("F1D0200002",  "Budi Santoso", "Pemrograman Bergerak", 85),
        NilaiMahasiswa("F1D0200003",  "Citra Dewi", "Pemrograman Bergerak", 68),
        NilaiMahasiswa("F1D0200004",  "Deni Saputra", "Pemrograman Bergerak", 55),
        NilaiMahasiswa("F1D0200005",  "Fajar Ramadan", "Pemrograman Bergerak", 90),
        NilaiMahasiswa("F1D0200006",  "Gita Lestari", "Pemrograman Bergerak", 72),
        NilaiMahasiswa("F1D0200007",  "Hana Safitri", "Pemrograman Bergerak", 45),
        NilaiMahasiswa("F1D0200008",  "Ilham Putra", "Pemrograman Bergerak", 88),
        NilaiMahasiswa("F1D0200009",  "Joko Susilo", "Pemrograman Bergerak", 78)
    )
    println("${"No".padEnd(5)}${"NIM".padEnd(15)}${"Nama".padEnd(20)}${"MataKuliah".padEnd(25)}Nilai")
    for ((index, mhs) in dataMahasiswa.withIndex()) {
        val no   = (index + 1).toString().padEnd(5)
        val nim  = mhs.nim.padEnd(15)
        val nama = mhs.nama.padEnd(20)
        val mk   = mhs.matakuliah.padEnd(25)
        println("$no$nim$nama$mk${mhs.nilai}")
    }
    println("=====STATISTIK=====")
    println("Total Mahasiswa : ${dataMahasiswa.count()}")
    val totalNilai = dataMahasiswa.sumOf { it.nilai }
    val rataRata = totalNilai / dataMahasiswa.count()
    println("Rata-rata Nilai : $rataRata")
    val mahasiswaBest = dataMahasiswa.maxBy { it.nilai }
    println("Nilai Tertinggi : ${mahasiswaBest.nilai} (${mahasiswaBest.nama})")
    val mahasiswaMin = dataMahasiswa.minBy { it.nilai }
    println("Nilai Terendah : ${mahasiswaMin.nilai} (${mahasiswaMin.nama})")

    println("=====MAHASISWA LULUS=====")
    for ((index, mhs) in dataMahasiswa.withIndex()) {
        if (mhs.nilai<70) continue
        println("${(index + 1).toString().padEnd(5)}${mhs.nama.padEnd(20)}${mhs.nilai}")

    }
    println("\n=====URUTAN NILAI ASCENDING=====")
    val ascending = dataMahasiswa.sortedBy { it.nilai }
    for ((index, mhs) in ascending.withIndex()) {
        println("${(index+1).toString().padEnd(5)}${mhs.nama.padEnd(20)}${mhs.nilai}")
    }

    println("\n=====URUTAN NILAI DESCENDING=====")
    val descending = dataMahasiswa.sortedByDescending { it.nilai }
    for ((index, mhs) in descending.withIndex()) {
        println("${(index+1).toString().padEnd(5)}${mhs.nama.padEnd(20)}${mhs.nilai}")
    }

    println("\n=====KELOMPOK BERDASARKAN GRADE=====")
    val kelompokGrade = dataMahasiswa.groupBy { getGrade(it.nilai) }
    for ((grade, listMhs) in kelompokGrade) {
        println("Grade $grade :")
        for (mhs in listMhs) {
            println("     ${mhs.nama.padEnd(20)}${mhs.nilai}")
        }
    }
    println("\n=====JUMLAH MAHASISWA PER GRADE=====")
    for ((grade, listMhs) in kelompokGrade) {
        println("Grade $grade : ${listMhs.count()} mahasiswa")
    }
    println("\n=====CARI MAHASISWA=====")
    print("Masukkan nama yang dicari : ")
    val keyword = readLine()!!
    val hasilCari = dataMahasiswa.filter { it.nama.contains(keyword, ignoreCase = true) }

    if (hasilCari.isEmpty()) {
        println("Mahasiswa dengan nama \"$keyword\" tidak ditemukan!")
    } else {
        println("Hasil pencarian \"$keyword\" :")
        for (mhs in hasilCari) {
            println("     ${mhs.nama.padEnd(20)}${mhs.nilai}")
        }
    }
}