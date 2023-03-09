package lambda;

import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {
        //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar (x dahil)
        // tamsayilari toplayan bir program create ediniz.
        System.out.println(xeKdrTplFunc(5));
        System.out.println(xeKadarCiftTopla(6));
    }

    public static int xeKadrTopla(int x) {
        int toplam = 0;
        for (int i = 1; i < x; i++) {
            toplam = toplam + i;
        }
        return toplam;
    }
   //functional
    public static int xeKdrTplFunc(int x){
        return IntStream.
                range(1,x+1).
                sum();
    }
    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int xeKadarCiftTopla(int x){
        return IntStream.
                rangeClosed(1,x).
                filter(Lambda01::ciftBul).
                sum();
    }
    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.


}
