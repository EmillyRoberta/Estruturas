
package projetopatossal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeSet;
public class GerenciadorDeArquivo {
    
    // grava coleÃ§Ã£o do tipo lista no arquivo de roedor:
    public void gravarArquivoRoedor(TreeSet<Roedor> lista, String arquivo){ // ver se cria o subdiretÃ³rio caso nÃ£o haja ainda.
        File arq = new File(arquivo); // objeto do tipo File recebe nome do arquivo.
        try{
            
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(arq)); // criando objeto a partir de arq para alterar seu conteÃºdo.
            output.writeObject(lista);
            output.close();
        }catch(IOException erro){
            System.out.printf("Erro %s",erro.getMessage());
        }
    } 
    
    public TreeSet<Roedor> lerArquivoRoedor( String arquivo){
        TreeSet<Roedor> lista = new TreeSet(); // cria coleÃ§Ã£o do tipo lista para armazenar o conteÃºdo do arquivo  que estÃ¡ sendo lido.
        try{
            File arq = new File(arquivo); // objeto do tipo File recebe nome do arquivo.
            if(arq.exists()){
                ObjectInputStream input = new ObjectInputStream(new FileInputStream(arquivo)); // criando objeto a partir de arq para ler seu conteÃºdo
                lista = (TreeSet<Roedor>)input.readObject(); // lista recebendo conteÃºdo do arquivo.
                if(lista.isEmpty()){
                    System.out.printf("Patossal estÃ¡ com o estoque de Roedores zerado. Hora de ir as compras !");
                }
                input.close(); // fecha o arquivo.
            }else{
                System.out.printf("Um novo arquivo sera criado com o titulo e diretorio especificado.");
                arq.createNewFile();
            }
        }catch(IOException erro1){
            System.out.printf("Erro: %s",erro1.getMessage()); 
        }catch(ClassNotFoundException erro2){
            System.out.printf("Erro: %s",erro2.getMessage());
        }
        return lista; // retorna a lista equivalente a classe especificada pelo arquivo  
        
    }    
    
    // grava coleÃ§Ã£o do tipo lista no arquivo de ave:
    public void gravarArquivoAve(TreeSet<Ave> lista, String arquivo){ // ver se cria o subdiretÃ³rio caso nÃ£o haja ainda.
        File arq = new File(arquivo); // objeto do tipo File recebe nome do arquivo.
        try{
            
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(arq)); // criando objeto a partir de arq para alterar seu conteÃºdo.
            output.writeObject(lista);
            output.close();
        }catch(IOException erro){
            System.out.printf("Erro %s",erro.getMessage());
        }
    } 
    
    public TreeSet<Ave> lerArquivoAve( String arquivo){
        TreeSet<Ave> lista = new TreeSet(); // cria coleÃ§Ã£o do tipo lista para armazenar o conteÃºdo do arquivo  que estÃ¡ sendo lido.
        try{
            File arq = new File(arquivo); // objeto do tipo File recebe nome do arquivo.
            if(arq.exists()){
                ObjectInputStream input = new ObjectInputStream(new FileInputStream(arquivo)); // criando objeto a partir de arq para ler seu conteÃºdo
                lista = (TreeSet<Ave>)input.readObject(); // lista recebendo conteÃºdo do arquivo.
                if(lista.isEmpty()){
                    System.out.printf("Patossal estÃ¡ com o estoque de Roedores zerado. Hora de ir as compras !");
                }
                input.close(); // fecha o arquivo.
            }else{
                System.out.printf("Um novo arquivo sera criado com o titulo e diretorio especificado.");
                arq.createNewFile();
            }
        }catch(IOException erro1){
            System.out.printf("Erro: %s",erro1.getMessage()); 
        }catch(ClassNotFoundException erro2){
            System.out.printf("Erro: %s",erro2.getMessage());
        }
        return lista; // retorna a lista equivalente a classe especificada pelo arquivo  
    }
    // grava coleÃ§Ã£o do tipo lista no arquivo de Alimento:
    public void gravarArquivoAlimento(TreeSet<Alimento> lista, String arquivo){ // ver se cria o subdiretÃ³rio caso nÃ£o haja ainda.
        File arq = new File(arquivo); // objeto do tipo File recebe nome do arquivo.
        try{
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(arq)); // criando objeto a partir de arq para alterar seu conteÃºdo.
            output.writeObject(lista);
            output.close();
        }catch(IOException erro){
            System.out.printf("Erro %s",erro.getMessage());
        }
    } 
    
    public TreeSet<Alimento> lerArquivoAlimento( String arquivo){
        TreeSet<Alimento> lista = new TreeSet(); // cria coleÃ§Ã£o do tipo lista para armazenar o conteÃºdo do arquivo  que estÃ¡ sendo lido.
        try{
            File arq = new File(arquivo); // objeto do tipo File recebe nome do arquivo.
            if(arq.exists()){
                ObjectInputStream input = new ObjectInputStream(new FileInputStream(arquivo)); // criando objeto a partir de arq para ler seu conteÃºdo
                lista = (TreeSet<Alimento>)input.readObject(); // lista recebendo conteÃºdo do arquivo.
                if(lista.isEmpty()){
                    System.out.printf("Patossal estÃ¡ com o estoque de Roedores zerado. Hora de ir as compras !");
                }
                input.close(); // fecha o arquivo.
            }else{
                System.out.printf("Um novo arquivo sera criado com o titulo e diretorio especificado.");
                arq.createNewFile();
            }
        }catch(IOException erro1){
            System.out.printf("Erro: %s",erro1.getMessage()); 
        }catch(ClassNotFoundException erro2){
            System.out.printf("Erro: %s",erro2.getMessage());
        }
        return lista; // retorna a lista equivalente a classe especificada pelo arquivo  
        
    }
}
