/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopatossal;

import java.util.Iterator;
import java.util.TreeSet;
/**
 *
 * @author stefa
 */
public class EstoqueAlimento implements Estoque {
    TreeSet<Alimento> colecaoAlimento = new TreeSet<Alimento>(); 
    
    //criando objeto para GerenciadorDeArquivos:
    GerenciadorDeArquivo gda = new GerenciadorDeArquivo();
    
    public void inicializarColeções(){
       this.colecaoAlimento = gda.lerArquivoAlimento("C://Documentos//colecaoAlimento//colecaoAlimento");
    }

    @Override
    public void imprimirEstoque() {
        Iterator i = colecaoAlimento.iterator();
        Alimento al;
        while (i.hasNext()) {
            al = (Alimento) i.next();
            al.exibir(); // colocar o exibir para alimento tbm 
            
        }
    }

    @Override
    public void apagarEstoque() {
        // para iteração da coleçõe (remoção):
        Iterator al = colecaoAlimento.iterator(); 
        
        //laços de repetição para efetuar a remoção:
        while( al.hasNext() ){
            al.remove();            
        }
    }
    
//adicionar alimento
//remover alimento
//consultar alimento
//alterar alimento
////inicializar colecao


}
