
package projetopatossal;

public abstract class Produto {
    //Atributos
    protected double preco;
    protected int quantidade;
    
    //Construtores
    public Produto(double preco,int quantidade){
        this.setPreco(preco);
        this.setQuantidade(quantidade);    
    }
    
    public Produto(){
        this(0.0,0);
    }
    
    //Métodos get e set
    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        if(preco>0){
            this.preco = preco;
        }
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        if(quantidade>=0){
        this.quantidade = quantidade;
        }
    }   
    
    //Método para calcular o prejuizo
    public abstract void prejuizo(double preco, int quantidade);
}
