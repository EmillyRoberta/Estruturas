
package projetopatossal;

public class Roedor extends ProdutoAnimal{
    private int expectativaDeVida;
    private double temperatura; //Temperatura ambiente ideal para a sobrevivencia do animal
    
    //Construtores:
    public Roedor(){
        this(0.0,"",'\u0000',0,0.0,0);
    }
    public Roedor(double preco,String especie,char genero,int expectativadeVida, double temperatura, int quantidade){        
        super(especie,genero, preco, quantidade);
        this.setExpectativaDeVida(expectativaDeVida);
        this.setTemperatura(temperatura);
    }
    
    //Métodos get e set:
    public int getExpectativaDeVida() {
        return this.expectativaDeVida;
    }

    public void setExpectativaDeVida(int expectativaDeVida) {
        if(expectativaDeVida > 0){
            this.expectativaDeVida = expectativaDeVida;
        }
    }

    public double getTemperatura() {
        return this.temperatura;
    }

    public void setTemperatura(double temperatura) {
        if(temperatura>0){
            this.temperatura = temperatura;
        }
    }
    
    
    
    //Método toString
    public void exibir(){
       System.out.printf("Espécie: %s\nPreço: %.2f\nQuantidade: %d\nGênero: %c\nExpectativa de vida: %d anos\nTemperatura: %.2f°c\n", this.especie, this.preco, this.quantidade, this.genero, this.expectativaDeVida, this.temperatura);
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o){
        Roedor e = (Roedor) o;
        int n;
        n = this.especie.compareTo(e.especie);
        return n;
    }
 
}
