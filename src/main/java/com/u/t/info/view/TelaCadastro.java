package com.u.t.info.view;
import javax.swing.*;

/*
Integrantes do grupo:
Nome                            Matricula
Ágata Meireles Carvalho         202065001AC
Kleiton Ewerton de Oliveira     202065050AC
Luiz Miguel Batista Silva       202065060A
Nikolas Oliver Sales Genesio    202065072AC
 */

/**
 *
 * @author Nikolas
 */
public abstract class TelaCadastro extends JFrame {

    //atributos que serao uteis para preencher o endereco de acordo com o cep
    private JTextField rua, bairro, cidade, uf, cep;

    //metodo abstrato que vai ser implementado em cada classe herdada
    public abstract void desenha();

    public JTextField getRua() {
        return rua;
    }

    public void setRua(JTextField rua) {
        this.rua = rua;
    }

    public JTextField getBairro() {
        return bairro;
    }

    public void setBairro(JTextField bairro) {
        this.bairro = bairro;
    }

    public JTextField getCidade() {
        return cidade;
    }

    public void setCidade(JTextField cidade) {
        this.cidade = cidade;
    }

    public JTextField getUf() {
        return uf;
    }

    public void setUf(JTextField uf) {
        this.uf = uf;
    }

    public JTextField getCep() {
        return cep;
    }

    public void setCep(JTextField cep) {
        this.cep = cep;
    }

}
