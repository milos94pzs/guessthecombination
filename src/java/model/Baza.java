/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author ickarus
 */
public class Baza {
    public static ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
    public static ArrayList<Igra> igre = new ArrayList<Igra>();
    public static ArrayList<Korisnik> adminIKomisija = new ArrayList<Korisnik>();
    
    static{
        
        Korisnik k1 = new Korisnik("cko","cko","cko","cko",1,"admin",0,0,"");                      
        Korisnik k2 = new Korisnik("mil","mil","mile","milic",2,"komisija",0,0,"");              
        Korisnik k3 = new Korisnik("joca","joca","jovana","jovanovic",2,"komisija",0,0,"");      
        
        Korisnik k4 = new Korisnik("dragana","dragana","dragana","dragic",3,"igrac",5,0,"2 8 6 8");
        Korisnik k5 = new Korisnik("marko","marko","marko","markovic",3,"igrac",6,0,"2 5 6 8 ");
        Korisnik k6 = new Korisnik("borko","borko","borko","borkovic",3,"igrac",2,0,"2 4 7 7");
        
        adminIKomisija.add(k1);
        adminIKomisija.add(k2);
        adminIKomisija.add(k3);
        
        
        
        korisnici.add(k4);
        korisnici.add(k5);
        korisnici.add(k6);
        
        Collections.sort(korisnici,new Comparator<Korisnik>(){
            
            public int compare(Korisnik k1, Korisnik k2){
                
                return Integer.valueOf(k2.getPoeni()).compareTo(k1.getPoeni());
            }
        });
        
        
    }
    
    public static boolean proveraKorisnika(String username,String password){
        boolean flag = false;
        
        for(Korisnik k : korisnici){
            if(k.proveraKorisnikaUKlasiKorisnik(username, password)){
                flag = true;
                break;
            }
        }
        
        for(Korisnik k : adminIKomisija){
            if(k.proveraKorisnikaUKlasiKorisnik(username, password)){
                flag = true;
                break;
            }
        }
        
        return flag;
    }
    
    public static boolean kreiranjeKorisnika(String username,String password,String ime,String prezime){
        
        for(Korisnik k : korisnici){
            if(!proveraPostojanjaUseraUBazi(username)){
                Korisnik kor = new Korisnik(username,password,ime,prezime);
                korisnici.add(kor);
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean proveraPostojanjaUseraUBazi(String username){
        
        for(Korisnik k : korisnici){
            if(k.getUsername().equals(username)){
                return true;
            }
        }
        
        for(Korisnik k : adminIKomisija){
            if(k.getUsername().equals(username)){
                return true;
            }
        }
        
        
        return false;
    }
    
    public static Korisnik vratiKorisnikaPoUseru(String username){
        
        for(Korisnik k : korisnici){
            if(k.getUsername().equals(username)){
                return k;
            }
        }
        
        for(Korisnik k : adminIKomisija){
            if(k.getUsername().equals(username)){
                return k;
            }
        }
        return null;
        
    }
    
    public static void brisiKorisnikaPoUseru(String nazivUsername){
        
        Iterator <Korisnik> it = korisnici.iterator();
        
        while(it.hasNext()){
            if(it.next().getUsername().equals(nazivUsername)){
                it.remove();
            }
        }
    }
    
    
    
}
