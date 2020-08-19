package org.chasen.crfpp;


import java.util.ArrayList;
import java.util.List;


public class NameAdressSplitClient {


//    public static void main(String[] argv) {
//        System.out.println(split("/5803 Jack,BeiJing"));
//    }

    static {
        try {
            System.loadLibrary("CRFPP");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Cannot load the example native code.\nMake sure your LD_LIBRARY_PATH contains \'.\'\n" + e);
            System.exit(1);
        }
    }

    private static String split(String s) {
        List<String> word_list = cut_sentence(s);
        Tagger tagger = new Tagger("-m /home/python/Desktop/CRF++-0.58/example/NameAddress/model -v 3 -n2");
        tagger.clear();
        for (String word : word_list) {
            tagger.add(word + "\tB");
        }
        if (!tagger.parse())
            return "";

//        tagger.size：测试的单词个数有多少
        String name = "";
        String address = "";
//        对预测结果进行解析
        for (int i = 0; i < tagger.size(); ++i) {
            if (tagger.y2(i).equals("Loc")) {
                address = tagger.x(i, 0);
            }
            if (tagger.y2(i).equals("Name")) {
                name = tagger.x(i, 0);
            }
        }
        return name+","+address;
    }


    private static List cut_sentence(String s) {
        List<String> word_list = new ArrayList<String>();
        String[] s_sentence = s.split("[\\,\\ ]");
        for(int i = 0; i < s_sentence.length; i++){
            word_list.add(s_sentence[i]);
        }
        return word_list;
    }
}
