package com.u.t.info.controller;

import com.u.t.info.src.Cliente;
import com.u.t.info.view.TelaCadastroCliente;
import java.util.InputMismatchException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

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
public class AdicionarCliente implements ActionListener {

    private final TelaCadastroCliente tela;

    /**
     * Construtor da classe
     * @param tela tela de cadastro de cliente
     */
    public AdicionarCliente(TelaCadastroCliente tela) {
        this.tela = tela;
    }

    /**
     * Adicionar um cliente
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        try
        {
            if(tela.getNome().getText().isEmpty() || tela.getCpf().getText().isEmpty() || tela.getCep().getText().isEmpty()
                    || tela.getRua().getText().isEmpty() || tela.getNumeroCasa().getText().isEmpty() || tela.getBairro().getText().isEmpty()
                    || tela.getCidade().getText().isEmpty() || tela.getTel1().getText().isEmpty()) {
                throw new Exception();
            }
            try
            {
                if(!tela.getNome().getText().matches("^[ a-zA-Z]+$") || tela.getNome().getText().length() < 8)
                {
                    throw new Exception();
                }
                try
                {
                    if(!tela.getCpf().getText().matches("[0-9]+") || !tela.getCep().getText().matches("[0-9]+")
                    || !tela.getNumeroCasa().getText().matches("[0-9]+") || !tela.getTel1().getText().matches("[0-9]+"))
                    {
                        throw new Exception();
                    }
                    try
                    {
                        if(validaCPF(tela.getCpf().getText()) == false)
                        {
                            throw new Exception();
                        }
                        try
                        {
                            if(tela.getUf().getText().isEmpty())
                            {
                                throw new Exception();
                            }
                            try {
                                String str = tela.getTel().getSelection().getActionCommand();
                                Cliente cliente = new Cliente(tela.getNome().getText(), tela.getCpf().getText(),
                                        tela.getCep().getText(), tela.getRua().getText(), tela.getNumeroCasa().getText(),
                                        tela.getBairro().getText(), tela.getCidade().getText(), tela.getUf().getText(),
                                        tela.getTel1().getText(), str);
                                tela.getClientes().add(cliente);
                                JOptionPane.showMessageDialog(tela, "Cliente adicionado");
                                LimparFormularioCliente limpar= new LimparFormularioCliente(tela);
                                limpar.LimparFormulario();

                            } catch (NullPointerException e) {
                                JOptionPane.showConfirmDialog(null, "Selecione o tipo do número", "ERRO", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null);
                            }
                        }
                        catch (Exception exception)
                        {
                            JOptionPane.showConfirmDialog(null, "Clicar no botão para validar CEP!", "ERRO", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null);
                        }

                    }
                    catch (Exception exception)
                    {
                        JOptionPane.showConfirmDialog(null, "CPF Inválido", "ERRO", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null);
                    }

                }
                catch (Exception exception)
                {
                    JOptionPane.showConfirmDialog(null, "Verificar os campos CPF, CEP, Número da casa e/ou Telefone! \nProibido uso de letras\nOBS: Digitar sem colocar caracteres \"(.-)\"!", "ERRO", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null);
                }
            }
            catch (Exception exception)
            {
                JOptionPane.showConfirmDialog(null, "Verificar o nome! \nProibido uso de números!\nTamanho Mínimo: 8 caracteres", "ERRO", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null);
            }

        }
        catch (Exception exception)
        {
            JOptionPane.showConfirmDialog(null, "Verificar os campos! \nProibido prosseguir com campos vazios!", "ERRO", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null);
        }
    }

    /**
     * Metodo para validar cpf
     * @param CPF cpf do cliente
     * @return verdadeiro se eh valido e falso se nao eh valido
     */
    public boolean validaCPF(String CPF) {
        if (CPF.equals("00000000000") ||
                CPF.equals("11111111111") ||
                CPF.equals("22222222222") || CPF.equals("33333333333") ||
                CPF.equals("44444444444") || CPF.equals("55555555555") ||
                CPF.equals("66666666666") || CPF.equals("77777777777") ||
                CPF.equals("88888888888") || CPF.equals("99999999999") ||
                (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char)(r + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                return(true);
            else return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
    }

}
