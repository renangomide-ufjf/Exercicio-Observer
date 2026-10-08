package padroescomportamentais.observer;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class Loja extends Observable {

    private String nome;
    private String categoria;
    private String cidade;

    public Loja(String nome, String categoria, String cidade) {
        this.nome = nome;
        this.categoria = categoria;
        this.cidade = cidade;
    }

    public void lancarPromocao() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Loja{" +
                "nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
