package uas.febri.faunaflora.utils;

import java.util.HashMap;
import java.util.Map;

import uas.febri.faunaflora.R;

public class QuestionDatas {

    public static Map<String, Integer> getImageList(){

        HashMap<String, Integer> images = new HashMap<>();

        //Fauna
        images.put("Berapakah sisa populasi elang flores yang diketahui?", R.drawable.fauna_elang_flores);
        images.put("Dimanakah gelada tinggal?", R.drawable.fauna_gelada);
        images.put("Berapa lama warna pada ikan arwana akan muncul?", R.drawable.fauna_ikan_arwana);
        images.put("Dimanakah kadal berduri tinggal?", R.drawable.fauna_kadal_berduri);
        images.put("Dimanakah kura-kura leher ular tinggal?", R.drawable.fauna_kura_kura_leher_ular);

        //Flora
        images.put("Perlu berapa tahun bunga bangkai untuk mekar?", R.drawable.flora_bunga_bangkai);
        images.put("Berapakah sisa populasi pohon bergetar yang diketahui?", R.drawable.flora_pohon_bergetar);
        images.put("Dimanakah anggrek hantu dapat tumbuh?", R.drawable.flora_anggrek_hantu);
        images.put("Pada tahun berapakah bunga ini ditemukan?", R.drawable.flora_pitcher);
        images.put("Berasal dari manakah bunga Middlemist Red?", R.drawable.flora_middlemist_red);

        return images;
    }

    public static Map<String, Map<String, Boolean>> getQuestionsList(){
        HashMap<String, Map<String, Boolean>> questions = new HashMap<>();

        HashMap<String, Boolean> answerList = new HashMap<>();
        answerList.put("50", false);
        answerList.put("100", false);
        answerList.put("200", false);
        answerList.put("250", true);

        questions.put("Berapakah sisa populasi elang flores yang diketahui?", answerList);

        HashMap<String, Boolean> answerList2 = new HashMap<>();
        answerList2.put("Ethiopia", true);
        answerList2.put("Rusia", false);
        answerList2.put("Amerika", false);
        answerList2.put("Kamboja", false);
        questions.put("Dimanakah gelada tinggal?", answerList2);

        HashMap<String, Boolean> answerList3 = new HashMap<>();
        answerList3.put("1 - 2 tahun", false);
        answerList3.put("3 - 4 tahun", true);
        answerList3.put("4 - 5 tahun", false);
        answerList3.put("5 - 6 tahun", false);
        questions.put("Berapa lama warna pada ikan arwana akan muncul?", answerList3);

        HashMap<String, Boolean> answerList4 = new HashMap<>();
        answerList4.put("Australia", true);
        answerList4.put("Indonesia", false);
        answerList4.put("Malaysia", false);
        answerList4.put("Swiss", false);
        questions.put("Dimanakah kadal berduri tinggal?", answerList4);

        HashMap<String, Boolean> answerList5 = new HashMap<>();
        answerList5.put("Pulau Bali", false);
        answerList5.put("Pulau Sumatera", false);
        answerList5.put("Pulau Rote", true);
        answerList5.put("Pulai Etor", false);
        questions.put("Dimanakah kura-kura leher ular tinggal?", answerList5);

        HashMap<String, Boolean> answerList6 = new HashMap<>();
        answerList6.put("7 Tahun", true);
        answerList6.put("6 Tahun", false);
        answerList6.put("5 Tahun", false);
        answerList6.put("4 Tahun", false);
        questions.put("Perlu berapa tahun bunga bangkai untuk mekar?", answerList6);

        HashMap<String, Boolean> answerList7 = new HashMap<>();
        answerList7.put("250", false);
        answerList7.put("150", false);
        answerList7.put("100", false);
        answerList7.put("200", true);
        questions.put("Berapakah sisa populasi pohon bergetar yang diketahui?", answerList7);

        HashMap<String, Boolean> answerList8 = new HashMap<>();
        answerList8.put("Suhu Lembab", true);
        answerList8.put("Suhu Panas", false);
        answerList8.put("Suhu Dingin", false);
        answerList8.put("Suhu Kering", false);
        questions.put("Dimanakah anggrek hantu dapat tumbuh?", answerList8);

        HashMap<String, Boolean> answerList9 = new HashMap<>();
        answerList9.put("2002", false);
        answerList9.put("2004", false);
        answerList9.put("2007", true);
        answerList9.put("2009", false);
        questions.put("Pada tahun berapakah bunga ini ditemukan?", answerList9);

        HashMap<String, Boolean> answerList10 = new HashMap<>();
        answerList10.put("China", true);
        answerList10.put("Jepang", false);
        answerList10.put("Indonesia", false);
        answerList10.put("Korea", false);
        questions.put("Berasal dari manakah bunga Middlemist Red?", answerList10);

        return questions;
    }
}
