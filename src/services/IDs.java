package services;

public class IDs extends PilhaDinamica{
    private int id;
    private int tamanhoDaLista;

    public IDs(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getTamanhoDaLista() {
        return tamanhoDaLista;
    }

    public void setTamanhoDaLista(int tamanhoDaLista) {
        this.tamanhoDaLista = tamanhoDaLista;
    }
    


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IDs other = (IDs) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }


}
