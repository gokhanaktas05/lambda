package lambda;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {

    public static void main(String[] args) {
        Universite u01 = new Universite("Bogazici", "Matematik", 571, 93);
        Universite u02 = new Universite("Istanbul", "Hukuk", 470, 74);
        Universite u03 = new Universite("Marmara", "Turkce", 693, 85);
        Universite u04 = new Universite("Amasya", "Muhasebe", 444, 69);
        Universite u05 = new Universite("Odtu", "Matematik", 123, 77);

        List<Universite> unv = new ArrayList<>(Arrays.asList(u01, u02, u03, u04, u05));
        System.out.println(notOrt74Buyukmu(unv));
        System.out.println(matVarmı(unv));
        System.out.println(matKacTane(unv));
        System.out.println(not550denFazla(unv));
        System.out.println(ogrsys1050EnKck(unv));


    }
    //task 01--> bütün Ünv. lerin notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.
    public static boolean notOrt74Buyukmu(List<Universite> unv) {
       return unv.
                stream().
                allMatch(t -> t.getNotOrt() > 74);
    }
    //task 02-->universite'lerde herhangi birinde "matematik" olup olmadigini
    // kontrol eden pr create ediniz.
    public static boolean matVarmı(List<Universite>unv){
       return unv.
                stream().
                anyMatch(t->t.getBolum().contains("Mat"));
    }
    //task 03-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static List<Universite> ogrSaysbk(List<Universite>unv){
        return unv.
                stream().
                sorted(Comparator.comparing(Universite::getOgrSayisi).reversed()).collect(Collectors.toList());
    }
    //task 04-->"matematik" bolumlerinin sayisini  print ediniz.
    public static int matKacTane(List<Universite>unv){
       return (int) unv.
                stream().
                filter(t->t.getBolum().contains("Mat")).count();
    }
    //task 05-->Ogrenci sayilari 550'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.
    public static OptionalInt not550denFazla(List<Universite>unv){
       return unv.
                stream().
                filter(t->t.getOgrSayisi()>550).
                mapToInt(t->t.getNotOrt()).
                max();
    }
    //task 06-->Ogrenci sayilari 1050'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
    public static OptionalInt ogrsys1050EnKck(List<Universite>unv){
      return  unv.
                stream().
                filter(t->t.getOgrSayisi()<1050).
                mapToInt(t->t.getNotOrt()).
                min();
    }
}
