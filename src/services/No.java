package services;

public class No {
    private IDs ID;
    private No proximo;

    public No(IDs ID){
       this.ID = ID;
       this.proximo = null;
   }

    //retorna ID (valor) do nó
    public int getID() {
        return ID.getId();
    }
    
    //define ID (valor) do nó
    public void setID(IDs ID) {
        this.ID = ID;
    }

    //retorna nó anterior
    public No getProximo() {
        return proximo;
    }

    //define nó anterior
    public void setProximo(No prox) {
        this.proximo = prox;
    }   
}
