package services;

public class DistribuicaoGraus {
    private int numeroEncontros;
    private int quantidadeEncontros = 1;

    public DistribuicaoGraus(int numeroEncontros) {
        this.numeroEncontros = numeroEncontros;
    }

    public int getNumeroEncontros() {
        return numeroEncontros;
    }

    public void setNumeroEncontros(int numeroEncontros) {
        this.numeroEncontros = numeroEncontros;
    }

    public int getQuantidadeEncontros() {
        return quantidadeEncontros;
    }
    
    public void incrementaEncontros(){
        this.quantidadeEncontros++;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.numeroEncontros;
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
        final DistribuicaoGraus other = (DistribuicaoGraus) obj;
        if (this.numeroEncontros != other.numeroEncontros) {
            return false;
        }
        return true;
    }
    
    
}
