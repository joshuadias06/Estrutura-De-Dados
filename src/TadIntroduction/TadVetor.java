package TadIntroduction;

public class TadVetor {

    public TadVetor(int tamanho, int minimo, int maximo, int vaga, int repete) {
        this.tamanho = tamanho;
        this.minimo = minimo;
        this.maximo = maximo;
        this.vaga = vaga;
        this.repete = repete;

        this.dados = new int[this.tamanho];
        if (this.vaga != 0) {
            for (int i = 0; i < this.tamanho; i++) {
                this.dados[i] = this.vaga;
            }
        }
    }

    private final int tamanho;
    private final int minimo;
    private final int maximo;
    private final int vaga;
    private final int repete; 

    private int[] dados;

    public int armazenar(int valor, int posicao) {

        if (!this.valorValido(valor)) { 
            return 1;
        }

        if (!this.posicaoValida(posicao)) {  
            return 2;
        }

        if (this.dados[posicao] != this.vaga) {  
            return 3;
        }

        if (!this.podeRepetir()) {  
            int[] existe = this.localizar(valor, 0);
            if (existe[0] > 0) {
                return 4;
            }

        }

        this.dados[posicao] = valor;  

        return 0;

    }

    public int alterar(int valor, int posicao) {

        if (!this.valorValido(valor)) {  
            return 1;
        }

        if (!this.posicaoValida(posicao)) {  
        }

        if (this.dados[posicao] == this.vaga) {  
            return 3;
        }

        if (!this.podeRepetir()) { 
            int[] existe = this.localizar(valor, 0);
            if (existe[0] > 0) {
                return 4;
            }

        }

        this.dados[posicao] = valor;  

        return 0;

    }

    public int excluir(int posicao) {

        if (!this.posicaoValida(posicao)) { 
            return 2;
        }

        if (this.dados[posicao] == this.vaga) {  
            return 3;
        }

        this.dados[posicao] = this.vaga;

        return 0;

    }

    public int ler(int posicao) {

        if (!this.posicaoValida(posicao)) {  
            return 2;
        }

        return this.dados[posicao];

    }

    public int[] localizar(int valor, int nPrimeiros) {

        int[] res = new int[this.tamanho];

        if (!this.valorValido(valor)) {
            return res;
        }

        if (this.repete == 0) {
            nPrimeiros = 1;
        }

        for (int i = 0; i < this.tamanho; i++) {
            if (this.dados[i] == valor) {
                res[0]++;
                res[res[0]] = i;
                if (res[0] == nPrimeiros) {
                    break;
                }
            }
        }

        return res;
    }

    public int armazenar1Vaga(int valor) {

        if (!this.valorValido(valor)) { 
            return 1;
        }

        for (int i = 0; i < this.tamanho; i++) {
            if (this.dados[i] == this.vaga) {
                int res = this.armazenar(valor, i);
                return res;
            }
        }

        return -1;

    }

  
    public int removerUltima() {

        for (int i = this.tamanho - 1; i >= 0; i--) {
            if (this.dados[i] != this.vaga) {
                return this.excluir(i);
            }
        }

        return -1;

    }

    private boolean valorValido(int valor) {
        return valor >= this.minimo && valor <= this.maximo;
    }

    private boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao < this.tamanho;
    }

    private boolean podeRepetir() {
        return this.repete == 1;
    }
    
    public void limparVetor(){
        for (int i = 0; i < tamanho; i++){
            this.dados[i] = this.vaga;
        }
    }

}
