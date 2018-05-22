/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author ickarus
 */
public class Korisnik {
    
    private String username;
    private String password;
    private String ime;
    private String prezime;
    private String opis;
    private int poeni;
    private int uloga;         // 1 je admin, 2 je komisija, 3 je korisnik
    private int pokusaji;
    private String kombinacija;

    public Korisnik(String username, String password, String ime, String prezime,int uloga,String opis,int poeni,int pokusaji,String kombinacija) {
        this.username = username;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
        if(uloga == 1){
            this.opis = "admin";
        }else if(uloga == 2){
            this.opis = "komisija";
        }else{
            this.opis = "igrac";
        }
        this.poeni = poeni;
        this.kombinacija = kombinacija;
    }

    //ovaj konstruktor sluzi kada se napravi novi korisnik preko registracije
    public Korisnik(String username, String password,String ime,String prezime) {
        this.username = username;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
        this.uloga = 3;
        this.opis = "igrac";
        this.poeni = 0;
        this.pokusaji = 1;
        this.kombinacija = kombinacija;
        
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getPoeni() {
        return poeni;
    }

    public void setPoeni(int poeni) {
        this.poeni = poeni;
    }

    public int getUloga() {
        return uloga;
    }

    public void setUloga(int uloga) {
        this.uloga = uloga;
    }

    public int getPokusaji() {
        return pokusaji;
    }

    public void setPokusaji(int pokusaji) {
        this.pokusaji = pokusaji;
    }

    public String getKombinacija() {
        return kombinacija;
    }

    public void setKombinacija(String kombinacija) {
        this.kombinacija = kombinacija;
    }
    
    
    
    public boolean proveraKorisnikaUKlasiKorisnik(String username,String password){
        return(this.username.equals(username) && this.password.equals(password));
        
    }
    
    
    
    
    
}
