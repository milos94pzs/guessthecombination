/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;

/**
 *
 * @author ickarus
 */
public class Igra {
    
    public static Random r = new Random();
    
    private static String kombinacija1 = "2";
    private static String kombinacija2 = "4";
    private static String kombinacija3 = "6";
    private static String kombinacija4 = "8";
    
    
    
    
    //za slucaj random kombinacije
    /*
    private static int kombinacija1 = r.nextInt(9);
    private static int kombinacija2 = r.nextInt(9);
    private static int kombinacija3 = r.nextInt(9);
    private static int kombinacija4 = r.nextInt(9); 	
    */
    
    public Igra(String kombinacija1, String kombinacija2, String kombinacija3, String kombinacija4) {
        this.kombinacija1 = kombinacija1;
        this.kombinacija2 = kombinacija2;
        this.kombinacija3 = kombinacija3;
        this.kombinacija4 = kombinacija4;
    }
    
    public static int proveraKombinacije(String komb1,String komb2,String komb3,String komb4){
        
        int brojPoena = 0;
        
        
        String [] kombinacija = {komb1,komb2,komb3,komb4};
        
        
        kombinacija[0] = getKombinacija1();
        kombinacija[1] = getKombinacija2();
        kombinacija[2] = getKombinacija3();
        kombinacija[3] = getKombinacija4();
        
        
        for (int i = 0; i < kombinacija.length; i++) {
        if (kombinacija[i].contains(komb1)) {
            brojPoena += 1;
                       
            if (kombinacija[0].equals(komb1)) {
                brojPoena += 1;
            }
            }
        if (kombinacija[i].contains(komb2)) {
            brojPoena += 1;
 
            if (kombinacija[1].equals(komb2)) {
                brojPoena += 1;
            }
            }
 
        if (kombinacija[i].contains(komb3)) {
            brojPoena += 1;
 
            if (kombinacija[2].equals(komb3)) {
                brojPoena += 1;
            }
            }
 
        if (kombinacija[i].contains(komb4)) {
            brojPoena += 1;
 
            if (kombinacija[3].equals(komb4)) {
                brojPoena += 1;
            }
            }
                       
               
        }
 
        //System.out.println("broj poena je : " + brojPoena);
 
        return brojPoena;
    }

    
    
    public static Random getR() {
        return r;
    }

    public static void setR(Random r) {
        Igra.r = r;
    }


    public static String getKombinacija1() {
        return kombinacija1;
    }

    public static void setKombinacija1(String kombinacija1) {
        Igra.kombinacija1 = kombinacija1;
    }

    public static String getKombinacija2() {
        return kombinacija2;
    }

    public static void setKombinacija2(String kombinacija2) {
        Igra.kombinacija2 = kombinacija2;
    }

    public static String getKombinacija3() {
        return kombinacija3;
    }

    public static void setKombinacija3(String kombinacija3) {
        Igra.kombinacija3 = kombinacija3;
    }

    public static String getKombinacija4() {
        return kombinacija4;
    }

    public static void setKombinacija4(String kombinacija4) {
        Igra.kombinacija4 = kombinacija4;
    }

    
    

    
    
    
    
}
