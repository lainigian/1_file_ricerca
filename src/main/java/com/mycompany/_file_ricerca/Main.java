/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._file_ricerca;

import java.io.IOException;
import java.time.Instant;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Main 
{
    public static void main(String[] args) 
    {
        //scriviamo il pathname del file da scrivere
        //String filePathname="F:\\OneDrive - Istituto Olivelli Putelli\\Scuola\\AS 2020 2021\\Materiale 4 Informatica\\Laini_Workspace_2020_20201\\25_TextFile\\file1.txt";
        String filePathname="fileDiTesto.txt";
        
        //scrivo 1000 record su un file
        //scriviRecord(filePathname);
        
        //Cerco un record a partire dal CF invocando il metodo statico ricercaSequenziale
        String recordCercato="1611557974;cognomexyz;nomexyz;telefono123;indirizzoxyz;";
        int posizione;
       
        //Misuro il tempo
        long start=Instant.now().getEpochSecond();
        posizione=ricercaSequenziale(filePathname, recordCercato);
        Long stop=Instant.now().getEpochSecond();
        long secondi=stop-start;
        System.out.println(posizione+ "secondi "+secondi);
        
       
                      
        //leggiamo le righe del file una alla volta
        //mettiamo ogni riga in una variabile String e la stampiamo sul monitor
       
        /*
        String rigaLetta;
        try 
        {

            TextFile f1= new TextFile(filePathname,'R');
            try
            {
                while(true)
                {
                    rigaLetta=f1.fromFile();
                    System.out.println(rigaLetta);   
                } 
            }
            catch(FileException fineFile)       //questa eccezione viene sollevata quando tutto il lfile è stato letto
            {
                System.out.println(fineFile.toString());
                f1.close();
            }           
        } 
        catch (IOException ex) //Questa eccezione viene sollevata in caso di errore nell'accesso al file
        {
            System.out.println("Impossibile aprire il file in lettura");
        } 
        */
        
    }    
    
    //metodo che scrive 10000 record su file, ogni i record sono tutti ugueli tranne il CF che viene simulato con un numero casuale
    private static void scriviRecord(String nomeFile)
    {
        String persona="";
        Random r=new Random();
        int cf; //simula il codice fiscale
        try 
        {  
            TextFile f1=new TextFile(nomeFile,'W');
            //creo 1000 persone con CF casuale (altri parametri uguali) e le salvo su file
            for (int i=0;i<10000;i++)
            {
                cf=r.nextInt(Integer.MAX_VALUE);    //creo un codice fiscale casuale
                persona=Integer.toString(cf)+";cognomexyz;nomexyz;telefono123;indirizzoxyz;"; //creo una persona casuale (l'unica differenza fra le persone è il CF
                f1.toFile(persona);
            }
            f1.close();
            System.out.println("File scritto correttamente");
        } 
        catch (IOException ex) 
        {
            System.out.println("Impossibile aprire il file in scrittura");
        } 
        catch (FileException ex) 
        {
            System.out.println(ex.toString());
        }
        
    }
    
    //metodo che ricerca una persona a partire dal CF e restituisce la sua posizione
    private static int ricercaSequenziale(String nomeFile, String recordCercato)
    {
         String recordLetto;
         int posizione=0;
        try 
        {

            TextFile f1= new TextFile(nomeFile,'R');
            try
            {
                while(true)
                {
                   
                    recordLetto=f1.fromFile();
                    posizione++;
                    if (recordLetto.compareTo(recordCercato)==0)
                    {
                        return posizione;
                    }
                       
                } 
            }
            catch(FileException fineFile)       //questa eccezione viene sollevata quando tutto il lfile è stato letto
            {
                System.out.println(fineFile.toString());
                f1.close();
            }           
        } 
        catch (IOException ex) //Questa eccezione viene sollevata in caso di errore nell'accesso al file
        {
            System.out.println("Impossibile aprire il file in lettura");
        } 
        return posizione;
    }
}


