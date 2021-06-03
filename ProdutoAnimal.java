
package projetopatossal;


public abstract class ProdutoAnimal extends Produto implements Comparable {
    protected String especie;
    protected char genero;
   
    
    //Construtores 
    public ProdutoAnimal(String especie,char genero, double preco, int quantidade){
        super(preco, quantidade);
        this.setEspecie(especie);
        this.setGenero(genero);
    }
    public ProdutoAnimal(){
        this("",'\u0000',0.0,0);
        
    }
    
    //Métodos get e set
    public String getEspecie() {
        return this.especie;
    }

    public void setEspecie(String especie) {
        if(especie != null){
            this.especie = especie;
        }
    }


    public char getGenero() {
        return this.genero;
    }

    public void setGenero(char genero) {
            this.genero = genero;
    }
    
    //Método para exibição dos objetos
    public abstract void exibir();
    
    //Método para calcular o prejuizo
    @Override
    public void prejuizo(double preco, int quantidade){
        double prejuizo;
        prejuizo = this.preco * this.quantidade;
        System.out.printf("Remoção por morte ou doença do animal\nValor do prejuizo: %.2f\n",prejuizo);
        
    }
   
       
    public int compareTo(Object o){
        ProdutoAnimal e = (ProdutoAnimal) o;
        int n;
        n = e.especie.compareTo(e.especie);
        return n;
    }
}
