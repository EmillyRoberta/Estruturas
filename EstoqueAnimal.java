package projetopatossal;
import java.util.Scanner;
import java.util.Collection;
import java.util.TreeSet;
import java.util.Iterator;
import java.io.File;


public class EstoqueAnimal implements Estoque {
    TreeSet<Ave> colecaoAveF = new TreeSet<Ave>();
    TreeSet<Roedor> colecaoRoedorF = new TreeSet<Roedor>();
    TreeSet<Ave> colecaoAveM = new TreeSet<Ave>();
    TreeSet<Roedor> colecaoRoedorM = new TreeSet<Roedor>();
    
    //Objeto para Gerenciador de arquivos:
    GerenciadorDeArquivo gda = new GerenciadorDeArquivo();

    //Método para adicionar novas espécies de roedores ou aumentar as unidades
    public void adicionarRoedor(String especie, char genero, int quantidade) {
        Iterator i;
        Roedor r = new Roedor();
        int verificador = 0; //Variável auxiliar usada para saber se existe ou não a espécie na coleção
        if (genero == 'F') {
            i = colecaoRoedorF.iterator();
        } else {
            i = colecaoRoedorM.iterator();
        }
        while (i.hasNext()) {
            r = (Roedor) i.next();
            if ((especie).equals(r.especie)) {
                r.quantidade = r.quantidade + quantidade;
                verificador++;
                break;
            }
        }
        if (verificador == 1) {
            System.out.printf("A quantidade desta espécie foi atualizada!\n");
        } else {
            r = this.dadosRoedor(especie, genero, quantidade);
            if (r.genero == 'F') {
                colecaoRoedorF.add(r);
            } else {
                colecaoRoedorM.add(r);
            }

        }
    }
    //Método para inserção dos dados de roedores
    public Roedor dadosRoedor(String especie, char genero, int quantidade) {
        Roedor roedor = new Roedor();
        roedor.setEspecie(especie);
        roedor.setQuantidade(quantidade);
        roedor.setGenero(genero);
        Scanner ler = new Scanner(System.in);
        System.out.println("Insira o preço: ");
        roedor.setPreco(ler.nextDouble());
        System.out.println("Insira a temperatura: ");
        roedor.setTemperatura(ler.nextDouble());
        System.out.println("Insira a expectatida de vida: ");
        roedor.setExpectativaDeVida(ler.nextInt());
        return roedor;
    }

    //Método para remover roedores da coleção
    public Roedor removerRoedor(String especie, char genero, int quantidade, char opcao) {
        Iterator i;
        Roedor r = new Roedor();
        if (genero == 'F') {
            i = colecaoRoedorF.iterator();
        } else {
            i = colecaoRoedorM.iterator();
        }
        while (i.hasNext()) {
            r = (Roedor) i.next();
            if ((especie).equals(r.especie)) {
                System.out.printf("Quantidade em estoque: %d\n", r.getQuantidade());
                int quant;
                quant = (r.getQuantidade()) - quantidade;
                if (quant < 0) {
                    r.setQuantidade(0);
                } else {
                    r.setQuantidade(quant);
                }
                System.out.printf("Quantidade em estoque após a operação: %d\n", r.getQuantidade());
                if(opcao == 'P'){
                    r.prejuizo(r.getPreco(), quantidade);
                }else{
                    if(opcao == 'V'){
                        System.out.printf("Remoção por venda!\n");
                    }
                }
                return r;
            }
        }
            System.out.println("A espécie procurada não se encontra nos estoques");
            r.setEspecie("");
            r.setExpectativaDeVida(0);
            r.setGenero('M');
            r.setPreco(0);
            r.setQuantidade(0);
            r.setTemperatura(0);
            return r;
    }
    
    //Método para consultar todos os dados da espécie do roedor procurado
    public void consultarRoedor(String especie, char genero){
        int verificador = 0;
        Iterator i;
        Roedor r;
        if(genero == 'F'){
            i = colecaoRoedorF.iterator();
        }else{
            i = colecaoRoedorM.iterator();
        }
        while (i.hasNext()) {
            r = (Roedor) i.next();
            if ((especie).equals(r.especie)) {
                r.exibir();
                verificador++;
                break;
            }
        }
        if(verificador == 0){
            System.out.print("Não há em estoque esta espécie de animal\n");         
        }
    }
    
    //Método para alterar os dados de alguma espécie presente no estoque
    public void alterarRoedor(String especie, char genero, int opcao){
        int verificador = 0;
        Scanner ler = new Scanner(System.in);
        Iterator i;
        Roedor r = new Roedor();
        if(genero == 'F'){
            i = colecaoRoedorF.iterator();
        }else{
            i = colecaoRoedorM.iterator();
        }
        while(i.hasNext()){
            r = (Roedor) i.next();
            if ((especie).equals(r.especie)) {
                verificador++;
                switch(opcao){
                case 1:
                    System.out.printf("Digite a espécie");
                    r.setEspecie(ler.nextLine());
                    break;
                case 2:
                    System.out.printf("Digite a preco:");
                    r.setPreco(ler.nextDouble());
                    break;
                case 3:
                    System.out.printf("Digite a quantidade:");
                    r.setQuantidade(ler.nextInt());
                    break;
                case 4:
                    System.out.printf("Digite a genero:");
                    r.setGenero(ler.next().charAt(0));
                    break;
                case 5:
                    System.out.printf("Digite a temperatura:");
                    r.setTemperatura(ler.nextDouble());
                    break;
                case 6:
                    System.out.printf("Digite a expectativa de vida:");
                    r.setExpectativaDeVida(opcao);
                    break;
                }
            }  
        } 
        if(verificador == 0){
            System.out.print("Esta espécie não está no estoque\n");
        }
    }
    
    //Método para adicionar novas aves ou aumentar as unidades
    public void adicionarAve(String especie, char genero, int quantidade) {
        int verificador = 0;
        Iterator i;
        Ave a = new Ave();
        if (genero == 'F') {
            i = colecaoAveF.iterator();
        } else {
            i = colecaoAveM.iterator();
        }
        while (i.hasNext()) {
            a = (Ave) i.next();
            if ((especie).equals(a.especie)) {
                a.quantidade = a.quantidade + quantidade;
                verificador++;
            }
        }
        if (verificador == 1) {
            System.out.printf("A quantidade desta espécie foi atualizada!\n");
        } else {
            a = this.dadosAve(especie, genero, quantidade);
            if (a.genero == 'F') {
                colecaoAveF.add(a);
            } else {
                colecaoAveM.add(a);
            }

        }
    }

    //Método para inserção dos dados de roedores
    public Ave dadosAve(String especie, char genero, int quantidade) {
        Ave ave = new Ave();
        ave.setEspecie(especie);
        ave.setQuantidade(quantidade);
        ave.setGenero(genero);
        Scanner ler = new Scanner(System.in);
        System.out.println("Insira o preço: ");
        ave.setPreco(ler.nextDouble());
        System.out.println("Insira a finalidade: ");
        ler.nextLine();
        ave.setFinalidade(ler.nextLine());
        System.out.println("A ave voa? (false ou true): ");
        ave.setVoa(ler.nextBoolean());
        
        return ave;
    }
    
    public Ave removerAve(String especie, char genero, int quantidade, char opcao) {
        Iterator i;
        Ave a = new Ave();
        if (genero == 'F') {
            i = colecaoAveF.iterator();
        } else {
            i = colecaoAveM.iterator();
        }
        while (i.hasNext()) {
            a = (Ave) i.next();
            if ((especie).equals(a.especie)) {
                System.out.printf("Quantidade em estoque: %d\n", a.getQuantidade());
                int quant;
                quant = (a.getQuantidade()) - quantidade;
                if (quant < 0) {
                    a.setQuantidade(0);
                } else {
                    a.setQuantidade(quant);
                }
                System.out.printf("Quantidade em estoque após a operação: %d\n", a.getQuantidade());
                if(opcao == 'P'){
                    a.prejuizo(a.getPreco(), quantidade);
                }else{
                    if(opcao == 'V'){
                        System.out.printf("Remoção por venda!\n");
                    }
                }
                return a;
            }
        }
            System.out.println("A espécie procurada não se encontra nos estoques");
            a.setEspecie("");
            a.setFinalidade("");
            a.setGenero('M');
            a.setPreco(0);
            a.setQuantidade(0);
            a.setVoa(false);
            return a;
    }
    
    public void alterarAve(String especie, char genero, int opcao){
        int verificador = 0;
        Scanner ler = new Scanner(System.in);
        Iterator i;
        Ave a = new Ave();
        if(genero == 'F'){
            i = colecaoRoedorF.iterator();
        }else{
            i = colecaoRoedorM.iterator();
        }
        while(i.hasNext()){
            a = (Ave) i.next();
            if ((especie).equals(a.especie)) {
                verificador++;
                switch(opcao){
                case 1:
                    System.out.printf("Digite a espécie");
                    a.setEspecie(ler.nextLine());
                    break;
                case 2:
                    System.out.printf("Digite a preco:");
                    a.setPreco(ler.nextDouble());
                    break;
                case 3:
                    System.out.printf("Digite a quantidade:");
                    a.setQuantidade(ler.nextInt());
                    break;
                case 4:
                    System.out.printf("Digite a genero:");
                    a.setGenero(ler.next().charAt(0));
                    break;
                }
            }  
        } 
        if(verificador == 0){
            System.out.print("Esta espécie não está no estoque\n");
        }
    }
    //Método para preencher um vetor de animais cuja funcionalidade seja gerar uma lista de roedores que foram retirados para consultas veterinárias semanalmente
    /*public ProdutoAnimal[] vetorRoedor(){
        ProdutoAnimal vetorVet[] = new ProdutoAnimal[6];
        Scanner ler = new Scanner(System.in);
        int opcao, j = 0, quant;
        Iterator i;
        Roedor r = new Roedor();
        i = colecaoRoedorM.iterator();
        while(i.hasNext()){
            r = (Roedor) i.next();
            System.out.printf("\nEspécie: %s\nQuantidade: %d\n\nDegite 1 para remover ou 2 para prosseguir: ", r.getEspecie(),r.getQuantidade());
            opcao = ler.nextInt();
            if(opcao == 1){
                System.out.printf("Digite a quantidade: ");
                quant = ler.nextInt();
                vetorVet[j] = removerRoedor(r.especie,'M',quant,'P');
                 j++;
            }
        }
        if(j == 6){
            System.out.printf("O limite de animais levados ao veterinário já foi atingido!\n");
        }else{
            j++;
            i = colecaoRoedorF.iterator();
            
                 while(i.hasNext()){
                    r = (Roedor) i.next();
                    System.out.printf("\nEspécie: %s\nQuantidade: %d\n\nDegite 1 para remover ou 2 para prosseguir: ", r.getEspecie(),r.getQuantidade());
                    opcao = ler.nextInt();
                    if(opcao == 1){
                        System.out.printf("Digite a quantidade: ");
                        quant = ler.nextInt();
                        vetorVet[j] = removerRoedor(r.especie,'F',quant,'P');
                        j++;
                        if(j == 6){
                            break;
                        }
                    }
                }
            }
            return vetorVet;
        }*/
    
    //Método para exibir o estoque
    @Override
    public void imprimirEstoque() {
        Iterator i = colecaoRoedorM.iterator();
        Roedor r;
        while (i.hasNext()) {
            r = (Roedor) i.next();
            r.exibir();           
        }
        i = colecaoRoedorF.iterator();
        while (i.hasNext()) {
            r = (Roedor) i.next();
            r.exibir();
        }
        i = colecaoAveM.iterator();
        Ave a;
        while (i.hasNext()) {
            a = (Ave) i.next();
            a.exibir();
        }
        i = colecaoAveF.iterator();
        
        while (i.hasNext()) {
            a = (Ave) i.next();
            a.exibir();
        }
        
    }
   public void inicializarColeções(){
       this.colecaoAveM = gda.lerArquivoAve("C://Documentos//colecaoAve//colecaoAveM");
       //this.colecaoAveF = gda.lerArquivoAve("C://Documentos//colecaoAve//colecaoAveF");
       //this.colecaoRoedorF = gda.lerArquivoRoedor("C://Documentos//colecaoRoedor//colecaoRoedorF");
       //this.colecaoRoedorM = gda.lerArquivoRoedor("C://Documentos//colecaoRoedor//colecaoRoedorM");
    }
   public void arquivarRoedor(){
       GerenciadorDeArquivo g = new GerenciadorDeArquivo();
       g.gravarArquivoRoedor(this.colecaoRoedorM,"C:\\Patossal\\ColecaoRoedores\\ColecoesRoedoresM.txt");
       
   }
           

    @Override
    public void apagarEstoque() {
        // para iteração das coleções (remoção):
        Iterator rm = colecaoRoedorM.iterator(); 
        Iterator rf = colecaoRoedorF.iterator();
        Iterator am = colecaoAveM.iterator();
        Iterator af = colecaoAveF.iterator();
        
        //laços de repetição para efetuar a remoção:
        while( rm.hasNext() ){
            rm.remove();            
        }
        while( rf.hasNext() ){
            rf.remove();            
        }
        while( am.hasNext() ){
            am.remove();            
        }
        while( af.hasNext() ){
            af.remove();            
        }
    }
    
//TO DO:

// lista veterinario roedor e ave.
//inicializar coleção.

}

