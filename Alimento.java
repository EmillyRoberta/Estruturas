/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopatossal;

/**
 *
 * @author stefa
 */
public class Alimento extends Produto {
    protected String marca;
    protected String descricao;
    
    
    
    public void exibir(){
       System.out.printf("Marca: %s\nPreço: %.2f\nQuantidade: %d\nDescricao: %s\n", this.marca, this.preco, this.quantidade,this.descricao);
    }
    
    //calcula o prejuízo de alimentos vencidos
    @Override
    public void prejuizo(double preco, int quantidade){
        double prejuizo;
        prejuizo = this.preco * this.quantidade;
        System.out.printf("Remoção de produto vencido\nValor do prejuizo: %.2f\n",prejuizo);
    }
    
    //ordenação pela marca da ração:
    public int compareTo(Object o){
        Alimento e = (Alimento) o;
        int n;
        n = this.marca.compareTo(e.marca);
        return n;
    }
    
}
