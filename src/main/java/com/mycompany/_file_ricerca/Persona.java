/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._file_ricerca;

import java.io.Serializable;

/**
 *
 * @author Gian
 */
public class Persona implements Serializable
{
    private String cognome;
    private String nome;
    private String telefono;
    private String indirizzo;

    public Persona(String cognome, String nome, String telefono, String indirizzo) {
        this.cognome = cognome;
        this.nome = nome;
        this.telefono = telefono;
        this.indirizzo = indirizzo;
    }
    
    
    
    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    @Override
    public String toString() 
    {
        String output=cognome+";"+nome+";"+telefono+";"+indirizzo+";";
        return output;
    }
    
    
}
