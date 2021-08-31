/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._file_ricerca;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
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
        //***********************Ricerca sequenziale su file di testo******************************************************************
        String filePathname="persone.txt";
        
        //scrivo 20 record sul file Persone
        scriviRecordTesto(filePathname);
        
        //Cerco un record sequenzialmente il metodo statico ricercaSequenziale che mi restituisce il record
        String nomeCercato="Bianchi Andrea";
        String recordTrovato=ricercaSequenzialeTesto(filePathname, nomeCercato);
        if (recordTrovato==null)
            System.out.println("Non presente");
        else
            System.out.println(recordTrovato);
       //*********************************************************************************************************************************
   
        //***********************Ricerca dicotomica su file binario******************************************************************
        //scrivo 20 record su file binario
        String filePathname2="persone.bin";
        scriviRecordBinari(filePathname2);
        //Scrivi metodo  per ordinare il file
        //Scrivi metodo per cercare il file dicotomico
        
    }    
    
    
    private static void scriviRecordTesto(String nomeFile)
    {
        String persona1="Rossi Mario;3932587854;via del mare 12";  
        String persona2="Bianchi Giovanni;3932475784;via Roma 14"; 
        String persona3="Verdi Carla;58785545214;piazza Garibaldi 21"; 
        String persona4="Rossini Giuseppe;5447887895;viale Marconi 1"; 
        String persona5="Neri Maria;7845669878;corso Mazzini 56"; 
        String persona6="Bianchi Andrea;7854778789;viale Italia 144"; 
        String persona7="Neri Daniele;8754221456;via Leopardi 5"; 
        String persona8="Banto Luigi;2145447875;via del pesce 12"; 
        String persona9="Bassi Carlo;3977487854;via del corso 34"; 
        try 
        {  
            TextFile f1=new TextFile(nomeFile,'W');            
            f1.toFile(persona1);
            f1.toFile(persona2);
            f1.toFile(persona3);
            f1.toFile(persona4);
            f1.toFile(persona5);
            f1.toFile(persona6);
            f1.toFile(persona7);
            f1.toFile(persona8);
            f1.toFile(persona9);
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
    private static String ricercaSequenzialeTesto(String nomeFile, String nomeCercato)
    {
         String recordLetto;
         String[] splitRecord;
         String nomeLetto;

        try 
        {

            TextFile f1= new TextFile(nomeFile,'R');
            try
            {
                while(true)
                {   
                    recordLetto=f1.fromFile();
                    splitRecord=recordLetto.split(";");
                    nomeLetto=splitRecord[0];
                    if (nomeLetto.compareTo(nomeCercato)==0)
                    {
                        f1.close();
                        return recordLetto;
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
        return "";  //se non lo trova --> restituisce una stringa vuota
    }
    
    
    private static void scriviRecordBinari(String nomeFile)
    {
        Persona p1=new Persona("Rossi","Mario","3932587854","via del mare 12");
        Persona p2=new Persona("Bianchi","Giovanni","3932475784","via Roma 14");
        Persona p3=new Persona("Verdi","Carla","58785545214","piazza Garibaldi 2");
        Persona p4=new Persona("Rossini","Giuseppe","5447887895","viale Marconi 1");
        Persona p5=new Persona("Neri","Maria","7845669878","corso Mazzini 56");
        Persona p6=new Persona("Bianchi","Andrea","7854778789","viale Italia 144");
        Persona p7=new Persona("Neri","Daniele","8754221456","via Leopardi 5");
        Persona p8=new Persona("Banto","Luigi","2145447875","via del pesce 12");
        Persona p9=new Persona("Bassi","Carlo","3977487854","via del corso 34");
        
        try 
        {
            //FileOutputStream f1= new FileOutputStream(nomeFile);
            //ObjectOutputStream outputStream=new ObjectOutputStream(f1);
            RandomAccessFile f1=new RandomAccessFile(nomeFile,"wr");
            
            outputStream.writeObject(p1);
            outputStream.writeObject(p2);
            outputStream.writeObject(p3);
            outputStream.writeObject(p4);
            outputStream.writeObject(p5);
            outputStream.writeObject(p6);
            outputStream.writeObject(p7);
            outputStream.writeObject(p8);
            outputStream.writeObject(p9); 
            outputStream.flush();
            outputStream.close();
        } 
        catch (IOException ex) 
        {
            System.out.println("Impossibile aprire il file in scrittura");
        }   
    }
}


