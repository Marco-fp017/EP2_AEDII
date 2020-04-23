package services;

public class PilhaDinamica {
    private No topo;

    //criar pilha
    public PilhaDinamica(){
        topo = null;
    }
    //inserir elemento
    public void inserirNo(IDs ID){
        No novo = new No(ID);
        novo.setProximo(topo);
        topo = novo;
    }
    
    //remover elemento
    public int removerNo(){
        if(topo == null) throw new NullPointerException("a pilha está vazia");
        else {
            No id = topo;
            topo = topo.getProximo();
            return id.getID();
        }       
    }
    
    //imprime diretamente no método
    public void imprimirPilha1(){
        if(topo != null){ 
            No end = topo;
            System.out.print(end.getID());
            while(end.getProximo() != null){
                System.out.print(" " + end.getID());
                end = end.getProximo();
            }
            System.out.println();
        }
        else{
            System.out.println();
        }
    }    

    //retorna uma string com os valores que devem ser imprimidos
    public String imprimirPilha2(){
        if(topo == null) return "\n";
        String saida = "" + topo.getID();
        No end = topo.getProximo();
        while(end != null){
            saida += " " + end.getID();
            end = end.getProximo();
        }
        saida += "\n";
        return saida;
    }

    //verificar se determinado elemento existe na pilha
    public No buscarNaPilha(IDs IdBuscado){
        if(topo.getID() == IdBuscado.getId()) return topo;
        No end = topo;
        
        while(end != null){
            if(end.getID() == IdBuscado.getId()) return end;
            end = end.getProximo();
        } 
        return null;
    }

    //retorna o tamalho da pilha
    public int tamanhoPilha(){
        int tam = 0;
        No end = topo;
        while(end != null){
            tam++;
            end = end.getProximo();
        }
        return tam;
    }
    
    //verifica se existem elementos na pilha
    public boolean estaVazia(){
        if(topo == null) return true;
        return false;
    }
}
