package com.example.sinawang

object Constants{
    const val NAMA_USER: String = "nama_user"
    const val TOTAL_PERTANYAAN: String = "total_pertanyaan"
    const val JAWABAN_BENAR: String = "jawaban_benar"

    fun getQustions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val que1 = Question(
                1,
                "Siapakah tokoh wayang ini ?",
                 R.drawable.arjuna,
                "Arjuna",
                "Arjuni",
                "Ardiani",
                1
        )
        questionList.add(que1)

        val que2 = Question(
                2,
                "Siapakah tokoh wayang ini ?",
                R.drawable.semar,
                "Bagong",
                "Gareng",
                "Semar",
                3
        )
        questionList.add(que2)

        val que3 = Question(
                3,
                "Siapakah tokoh wayang ini ?",
                R.drawable.werkudara,
                "Werkudiri",
                "Werkudara",
                "werdani",
                2
        )
        questionList.add(que3)

        val que4 = Question(
                4,
                "Siapakah Nama Lain dari Tokoh wayang Werkudara ?",
                R.drawable.werkudara,
                "Bumasena",
                "Bratasena",
                "Banyusena",
                2
        )
        questionList.add(que4)

        val que5 = Question(
                5,
                "Apa Watak Tokoh Wayang Hanoman?",
                R.drawable.hanoman,
                "Pemberani",
                "Penakut",
                "Iri hati",
                1
        )
        questionList.add(que5)

        val que6 = Question(
                6,
                "Siapakah Tokoh wayang ini ?",
                R.drawable.laksmana,
                "Laksino",
                "Laksana",
                "Laksmana",
                3
        )
        questionList.add(que6)

        val que7 = Question(
                7,
                "Siapakah Tokoh wayang ini ?",
                R.drawable.petruk,
                "Petruk",
                "Gareng",
                "Petrik",
                1
        )
        questionList.add(que7)

        val que8 = Question(
                8,
                "Siapakah tokoh wayang ini ?",
                R.drawable.nakulaa,
                "Nakulia",
                "Nakila",
                "Nakula",
                3
        )
        questionList.add(que8)

        val que9 = Question(
                9,
                "Siapakah tokoh wayang ini ?",
                R.drawable.sadewaa,
                "Sodewa",
                "Sadewa",
                "Sidewi",
                2
        )
        questionList.add(que9)

        val que10 = Question(
                10,
                "Apa watak tokoh wayang Nakula ?",
                R.drawable.nakulaa,
                "Jujur",
                "Pembohong",
                "Pemarah",
                1
        )
        questionList.add(que10)
        return questionList
    }
}