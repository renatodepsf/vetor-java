package br.com.caelum.ed;

import java.util.Arrays;

public class Vetor {

    private Aluno[] alunos = new Aluno[10];

    private int totalDeAlunos = 0;

    public void adiciona(Aluno aluno) {
        for (int indice = 0; indice < this.alunos.length; indice++) {
            if (alunos[indice] == null) {
                alunos[indice] = aluno;
                totalDeAlunos++;
                break;
            }
            garantaEspaco(this.alunos);
        }
    }

    private void garantaEspaco(Aluno[] alunos) {
        if (totalDeAlunos == this.alunos.length) {
            Aluno[] novoArray = new Aluno[this.alunos.length * 2];
            for (int i = 0; i < this.alunos.length; i++) {
                novoArray[i] = alunos[i];
            }
            this.alunos = novoArray;
        }
    }

    public void addPosicao(int posicao, Aluno aluno) {
        if (posicaoInvalida(posicao))
            throw new IllegalArgumentException("Posicao invalida");

        for (int indice = 0; indice < this.alunos.length; indice++) {
            if (alunos[posicao] == null) {
                alunos[posicao] = aluno;
                posicao++;
                break;
            }
        }
    }

    public Aluno pega(int posicao) {
        Aluno aluno = new Aluno();
        if (posicaoInvalida(posicao))
            throw new IllegalArgumentException("Posicao invalida");

        for (int i = 0; i < this.alunos.length; i++) {
            aluno = alunos[posicao];
            break;
        }

        return aluno;
    }

    private boolean posicaoInvalida(int posicao) {
        return posicao >= 0 && posicao < this.alunos.length;
    }

    public void remove(int posicao) {
        if (posicaoInvalida(posicao))
            throw new IllegalArgumentException("Posicao invalida");

        if (alunos[posicao] != null) {
            alunos[posicao] = null;
            totalDeAlunos--;
        }
    }

    public boolean contem(Aluno aluno) {
        for (int i = 0; i < this.alunos.length; i++) {
            if (this.alunos[i] == aluno) {
                return true;
            }
        }
        return false;
    }

    public int tamanho() {
        return totalDeAlunos;
    }

    public String toString() {

        int tamanhoNovoVetor = 0;

        for (int i = 0; i < this.alunos.length; i++) {
            if (alunos[i] != null)
                tamanhoNovoVetor++;
        }

        Aluno aluno = null;
        Aluno[] alunos = new Aluno[tamanhoNovoVetor];
        int indice = 0;

        for (int i = 0; i < this.alunos.length; i++) {
            if (this.alunos[i] != null) {
                aluno = this.alunos[i];
                alunos[indice] = aluno;
                indice++;
                if(tamanhoNovoVetor == indice)
                    break;
            }
        }
        return Arrays.toString(alunos);
    }
}

class TesteAdiciona {
    public static void main(String[] args) {
        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();

        a1.setNome("João");
        a2.setNome("José");

        Vetor vetor = new Vetor();
        vetor.adiciona(a1);
        vetor.adiciona(a2);

        System.out.println(vetor);
        System.out.println();
    }
}

class TesteAdicionaPosicao {
    public static void main(String[] args) {
        Aluno al1 = new Aluno();
        Aluno al2 = new Aluno();
        Aluno al3 = new Aluno();

        al1.setNome("Paulo");
        al2.setNome("Ana");
        al3.setNome("Rafael");

        Vetor vetor = new Vetor();
        vetor.adiciona(al1);
        vetor.addPosicao(0, al2);
        vetor.addPosicao(1, al3);

        System.out.println(vetor);
    }
}

class TestePegaPorPosicao {
    public static void main(String[] args) {
        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();
        a1.setNome("Rafael");
        a2.setNome("Paulo");
        Vetor lista = new Vetor();
        lista.adiciona(a1);
        lista.adiciona(a2);
        Aluno aluno1 = lista.pega(0);
        Aluno aluno2 = lista.pega(1);
        System.out.println(aluno1);
        System.out.println(aluno2);
    }
}

class TesteRemovePorPosicao {
    public static void main(String[] args) {
        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();
        a1.setNome("Rafael");
        a2.setNome("Paulo");
        Vetor lista = new Vetor();
        lista.adiciona(a1);
        lista.adiciona(a2);
        lista.remove(0);
        System.out.println(lista);
    }
}

class TesteContemAluno {
    public static void main(String[] args) {
        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();
        a1.setNome("Rafael");
        a2.setNome("Paulo");
        Vetor lista = new Vetor();
        lista.adiciona(a1);
        lista.adiciona(a2);
        System.out.println(lista.contem(a1));
        System.out.println(lista.contem(a2));
        Aluno aluno = new Aluno();
        aluno.setNome("Ana");
        System.out.println(lista.contem(aluno));
    }
}

class TesteTamanhoLista {
    public static void main(String[] args) {
        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();
        Aluno a3 = new Aluno();
        a1.setNome("Rafael");
        a2.setNome("Paulo");
        Vetor lista = new Vetor();
        lista.adiciona(a1);
        lista.adiciona(a2);
        System.out.println(lista.tamanho());
        lista.adiciona(a3);
        System.out.println(lista.tamanho());
    }
}

