
package projetopatossal;


public class Ave extends ProdutoAnimal{
    private String finalidade;
    private boolean voa;
    
    //Construtores
    public Ave(){
        this(0.0,"",'\u0000',0,"",false);
    }
    public Ave(double preco,String especie,char genero,int quantidade,String finalidade,boolean voa ){
        super(especie,genero, preco, quantidade);  
    }
    
    //Métos get e set
    public String getFinalidade(){
        return this.finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    public boolean getVoa() {
        return this.voa;
    }

    public void setVoa(boolean voa) {
        this.voa = voa;
    }

    //Método toString
    @Override
    public void exibir(){
        if(this.voa == false){
        System.out.printf("Espécie: %s\nPreço: %.2f\nQuantidade: %d\nGênero: %c\nFinalidade: %s\nVoa: Não\n",this.especie, this.preco, this.quantidade,this.genero,this.finalidade);
    }else{
            System.out.printf("Espécie: %s\nPreço: %.2f\nQuantidade: %d\nGênero: %c\nFinalidade: %s\nVoa: Sim\n",this.especie, this.preco, this.quantidade,this.genero,this.finalidade);   
        }
    }
    /**
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        ProdutoAnimal e = (ProdutoAnimal) o;
        int n;
        n = this.especie.compareTo(e.especie);
        return n;
    }
}
