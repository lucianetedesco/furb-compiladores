package br.furb.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Bruno G. Vigentas
 */
public class FileManager {
    
    
    /**
     * 
     * Método responsável por abrir o arquivo com BufferedReader
     * 
     * @param origem
     * @return 
     * @throws FileNotFoundException
     */
    public static BufferedReader openFile(String origem){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(origem));
            return reader;
        } catch (FileNotFoundException fne){
            fne.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    /**
     * 
     * Método responsável por ler o conteúdo do arquivo do caminho origem
     * 
     * @param origem
     * @return 
     */
    public static String readFile(String origem){
        try {
            BufferedReader reader =  openFile(origem);
            String fileContent = "";
            while (reader.ready()) {                
                fileContent = reader.readLine();
            }
            reader.close();
            return fileContent;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 
     * Método que cria o arquivo no diretório destino
     * 
     * @param destino
     * @param content 
     */
    public static void writeFile(String destino, String content){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(generateFileName(destino)))){
           writer.write(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * 
     * Método que gera um nome random para o arquivo.
     * 
     * @param caminho
     * @return 
     */
    public static String generateFileName(String caminho){
        return caminho.replaceAll(".txt", ".il");
        
    }
    
}
