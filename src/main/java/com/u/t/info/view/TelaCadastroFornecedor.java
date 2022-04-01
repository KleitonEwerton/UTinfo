package com.u.t.info.view;

import com.u.t.info.controller.CancelarAcao;
import com.u.t.info.src.Fornecedor;
import com.u.t.info.utils.BuscaCep;
import com.u.t.info.utils.JSONFornecedor;
import static com.u.t.info.utils.JSONFornecedor.salvarFornecedoresJSON;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import javax.swing.*;
import javax.swing.border.Border;

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
public class TelaCadastroFornecedor extends TelaCadastro {

    private JTextField razaoSocial, cnpj;
    private JTextField numeroCasa;
    private JButton pesquisarCep, salvar, sair;
    private JTextArea listaProdutos;
    private List<Fornecedor> fornecedores;

    /**
     * Construtor da classe
     */
    public TelaCadastroFornecedor() {
        this.fornecedores = new ArrayList<>();
    }

    /**
     * Metodo para desenhar a tela principal
     */
    @Override
    public void desenha() {
        this.setTitle("Cadastro de Fornecedor");
        this.setVisible(true); //visibilidade
        this.setSize(800, 600); //tamanho
        this.setResizable(false); //bloquear redimensionamento
        this.setLocationRelativeTo(null); //iniciar no meio da tela
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //sair da aplicação
        desenhaTelaCadastroFornecedor(); //desenho da tela
    }

    /**
     * Metodo para desenhar a tela de cadastro de funcionario
     */
    private void desenhaTelaCadastroFornecedor() {
        JPanel painel = new JPanel();
        painel.setPreferredSize(new Dimension(800, 600));

        GridBagLayout layout = new GridBagLayout();
        painel.setLayout(layout);

        JLabel jLInf = new JLabel("Dados Cadastrais", JLabel.CENTER);
        Font font = new Font("Leelawadee UI", Font.PLAIN, 18);
        jLInf.setFont(font);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(jLInf, gbc);

        Border blackline = BorderFactory.createLineBorder(Color.black);
        JLabel jLInfBas = new JLabel("Identificação do Fornecedor", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        jLInfBas.setBorder(blackline);
        jLInfBas.setFont(font);

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridwidth = GridBagConstraints.REMAINDER;
        gbc2.insets = new Insets(20, 0, 0, 0);
        gbc2.gridheight = 1;
        gbc2.weightx = 1.0;
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.fill = GridBagConstraints.HORIZONTAL;

        painel.add(jLInfBas, gbc2);

        JLabel jLNome = new JLabel("Razão Social: ", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        jLNome.setFont(font);

        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridwidth = 1;
        gbc3.insets = new Insets(20, 10, 0, 0);
        gbc3.gridheight = 1;
        gbc3.gridx = 0;
        gbc3.gridy = 2;
        painel.add(jLNome, gbc3);

        razaoSocial = new JTextField(48);
        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridwidth = GridBagConstraints.REMAINDER;
        gbc4.anchor = GridBagConstraints.WEST;
        gbc4.insets = new Insets(20, 0, 0, 0);
        gbc4.gridheight = 1;
        gbc4.weightx = 1.0;
        gbc4.gridx = 1;
        gbc4.gridy = 2;

        painel.add(razaoSocial, gbc4);

        JLabel jLCPF = new JLabel("CNPJ: ", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        jLCPF.setFont(font);

        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridwidth = 1;
        gbc5.insets = new Insets(10, 10, 45, 0);
        gbc5.gridheight = 1;
        gbc5.gridx = 0;
        gbc5.gridy = 3;
        painel.add(jLCPF, gbc5);

        cnpj = new JTextField(10);
        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.gridwidth = GridBagConstraints.REMAINDER;
        gbc6.anchor = GridBagConstraints.WEST;

        gbc6.insets = new Insets(15, 0, 45, 0);
        gbc6.gridheight = 1;
        gbc6.gridx = 1;
        gbc6.gridy = 3;
        painel.add(cnpj, gbc6);

        Border cadastro = BorderFactory.createRaisedBevelBorder();
        ImageIcon image = new ImageIcon(new ImageIcon("img/Empresa.png").getImage().getScaledInstance(120, 100, Image.SCALE_DEFAULT));
        JLabel imageLabel = new JLabel(image);
        imageLabel.setBorder(cadastro);

        GridBagConstraints gbcImg = new GridBagConstraints();
        gbcImg.gridwidth = GridBagConstraints.REMAINDER;
        gbcImg.anchor = GridBagConstraints.CENTER;
        gbcImg.fill = GridBagConstraints.VERTICAL;
        gbcImg.insets = new Insets(20, 0, 0, 0);
        gbcImg.gridx = 5;
        gbcImg.gridy = 2;
        gbcImg.gridheight = 2;
        painel.add(imageLabel, gbcImg);

        JLabel jlEndereco = new JLabel("Endereço", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        jlEndereco.setBorder(blackline);
        jlEndereco.setFont(font);

        GridBagConstraints gbc7 = new GridBagConstraints();
        gbc7.gridwidth = GridBagConstraints.REMAINDER;
        gbc7.insets = new Insets(20, 0, 0, 0);
        gbc7.gridheight = 1;
        gbc7.weightx = 1.0;
        gbc7.gridx = 0;
        gbc7.gridy = 4;
        gbc7.fill = GridBagConstraints.HORIZONTAL;
        painel.add(jlEndereco, gbc7);

        JLabel jLCEP = new JLabel("CEP: ", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        jLCEP.setFont(font);

        GridBagConstraints gbc8 = new GridBagConstraints();
        gbc8.gridwidth = 1;
        gbc8.insets = new Insets(20, 10, 0, 0);
        gbc8.gridheight = 1;
        gbc8.gridx = 0;
        gbc8.gridy = 5;
        painel.add(jLCEP, gbc8);

        super.setCep(new JTextField(10));
        GridBagConstraints gbc9 = new GridBagConstraints();
        gbc9.gridwidth = 1;
        gbc9.anchor = GridBagConstraints.WEST;
        gbc9.insets = new Insets(20, 0, 0, 0);
        gbc9.gridheight = 1;
        gbc9.gridx = 1;
        gbc9.gridy = 5;

        painel.add(super.getCep(), gbc9);

        pesquisarCep = new JButton("Localizar");
        GridBagConstraints gbc10 = new GridBagConstraints();
        gbc10.gridx = 2;
        gbc10.gridy = 5;
        gbc10.gridwidth = GridBagConstraints.REMAINDER;
        gbc10.anchor = GridBagConstraints.WEST;
        gbc10.insets = new Insets(20, 0, 0, 0);
        gbc10.gridheight = 1;

        pesquisarCep.addActionListener(new BuscaCep(this));

        painel.add(pesquisarCep, gbc10);

        JLabel jLRua = new JLabel("Rua: ", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        jLRua.setFont(font);

        GridBagConstraints gbc11 = new GridBagConstraints();
        gbc11.gridwidth = 1;
        gbc11.insets = new Insets(10, 10, 0, 0);
        gbc11.gridheight = 1;
        gbc11.gridx = 0;
        gbc11.gridy = 6;

        painel.add(jLRua, gbc11);

        super.setRua(new JTextField(47));
        GridBagConstraints gbc12 = new GridBagConstraints();
        gbc12.gridwidth = GridBagConstraints.RELATIVE;
        gbc12.anchor = GridBagConstraints.WEST;
        gbc12.insets = new Insets(15, 0, 0, 0);
        gbc12.gridheight = 1;
        gbc12.gridx = 1;
        gbc12.gridy = 6;
        painel.add(super.getRua(), gbc12);

        JLabel jLNumero = new JLabel("Número:", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        jLNumero.setFont(font);

        GridBagConstraints gbc13 = new GridBagConstraints();
        gbc13.gridwidth = GridBagConstraints.REMAINDER;
        gbc13.anchor = GridBagConstraints.WEST;
        gbc13.insets = new Insets(10, 10, 0, 0);
        gbc13.gridheight = 1;
        gbc13.gridx = 5;
        gbc13.gridy = 6;
        painel.add(jLNumero, gbc13);

        numeroCasa = new JTextField(6);
        GridBagConstraints gcb14 = new GridBagConstraints();
        gcb14.gridwidth = GridBagConstraints.REMAINDER;
        gcb14.anchor = GridBagConstraints.EAST;
        gcb14.insets = new Insets(15, 0, 0, 5);
        gcb14.gridheight = 1;
        gcb14.gridx = 9;
        gcb14.gridy = 6;
        painel.add(numeroCasa, gcb14);

        JLabel jLBairro = new JLabel("Bairro: ", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        jLBairro.setFont(font);

        GridBagConstraints gbc15 = new GridBagConstraints();
        gbc15.gridwidth = 1;
        gbc15.insets = new Insets(10, 10, 0, 0);
        gbc15.gridheight = 1;
        gbc15.gridx = 0;
        gbc15.gridy = 7;
        painel.add(jLBairro, gbc15);

        super.setBairro(new JTextField(12));
        GridBagConstraints gbc16 = new GridBagConstraints();
        gbc16.gridwidth = 1;
        gbc16.anchor = GridBagConstraints.WEST;
        gbc16.insets = new Insets(15, 0, 0, 0);
        gbc16.gridheight = 1;
        gbc16.gridx = 1;
        gbc16.gridy = 7;
        painel.add(super.getBairro(), gbc16);

        JLabel jLCidade = new JLabel("Cidade: ", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        jLCidade.setFont(font);

        GridBagConstraints gbc17 = new GridBagConstraints();
        gbc17.gridwidth = 1;
        gbc17.anchor = GridBagConstraints.WEST;
        gbc17.insets = new Insets(10, 10, 0, 0);
        gbc17.gridheight = 1;
        gbc17.gridx = 2;
        gbc17.gridy = 7;
        painel.add(jLCidade, gbc17);

        super.setCidade(new JTextField(28));
        GridBagConstraints gbc18 = new GridBagConstraints();
        gbc18.gridwidth = 1;
        gbc18.anchor = GridBagConstraints.WEST;

        gbc18.insets = new Insets(15, 0, 0, 0);
        gbc18.gridheight = 1;
        gbc18.gridx = 3;
        gbc18.gridy = 7;
        painel.add(super.getCidade(), gbc18);

        JLabel jLUF = new JLabel("UF: ", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        jLUF.setFont(font);

        GridBagConstraints gbc19 = new GridBagConstraints();
        gbc19.gridwidth = 1;
        gbc19.anchor = GridBagConstraints.WEST;
        gbc19.insets = new Insets(10, 10, 0, 0);
        gbc19.gridheight = 1;
        gbc19.gridx = 5;
        gbc19.gridy = 7;
        painel.add(jLUF, gbc19);

        super.setUf(new JTextField(2));
        super.getUf().setEnabled(false);
        GridBagConstraints gbc20 = new GridBagConstraints();
        gbc20.gridwidth = GridBagConstraints.REMAINDER;
        gbc20.anchor = GridBagConstraints.WEST;
        gbc20.insets = new Insets(15, 0, 0, 0);
        gbc20.gridheight = 1;
        gbc20.gridx = 6;
        gbc20.gridy = 7;
        painel.add(super.getUf(), gbc20);

        JLabel jLContato = new JLabel("Lista de Produtos", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        jLContato.setBorder(blackline);
        jLContato.setFont(font);

        GridBagConstraints gbc21 = new GridBagConstraints();
        gbc21.gridwidth = GridBagConstraints.REMAINDER;
        gbc21.insets = new Insets(20, 0, 0, 0);
        gbc21.gridheight = 1;
        gbc21.weightx = 1.0;
        gbc21.gridx = 0;
        gbc21.gridy = 8;
        gbc21.fill = GridBagConstraints.HORIZONTAL;
        painel.add(jLContato, gbc21);

        JLabel jLTel1 = new JLabel("Lista: ", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        jLTel1.setFont(font);

        GridBagConstraints gbc22 = new GridBagConstraints();
        gbc22.gridwidth = 1;
        gbc22.insets = new Insets(20, 10, 0, 0);
        gbc22.gridheight = 1;
        gbc22.gridx = 0;
        gbc22.gridy = 9;
        painel.add(jLTel1, gbc22);

        listaProdutos = new JTextArea(5, 60);
        GridBagConstraints gbc23 = new GridBagConstraints();
        gbc23.gridwidth = GridBagConstraints.REMAINDER;
        gbc23.anchor = GridBagConstraints.WEST;
        gbc23.insets = new Insets(20, 0, 0, 0);
        gbc23.gridheight = 1;
        gbc23.weightx = 1.0;
        gbc23.gridx = 1;
        gbc23.gridy = 9;

        painel.add(new JScrollPane(listaProdutos), gbc23);

        sair = new JButton("Cancelar");
        sair.addActionListener(new  CancelarAcao(this));

        GridBagConstraints gbc32 = new GridBagConstraints();
        gbc32.gridx = 3;
        gbc32.gridy = 13;
        gbc32.gridwidth = 3;
        //gbc32.fill = GridBagConstraints.BOTH;
        gbc32.ipady = 5;
        gbc32.anchor = GridBagConstraints.EAST;
        gbc32.insets = new Insets(20, 0, 20, 0);
        gbc32.gridheight = 1;

        painel.add(sair, gbc32);

        salvar = new JButton("Salvar");
        salvar.addActionListener(new SalvarFornecedor(this));
        
        GridBagConstraints gbc33 = new GridBagConstraints();
        gbc33.gridx = 6;
        gbc33.gridy = 13;
        gbc33.ipady = 5;
        gbc33.ipadx = 15;
        gbc33.gridwidth = 4;
        gbc33.anchor = GridBagConstraints.WEST;
        gbc33.insets = new Insets(20, 0, 20, 0);
        gbc33.gridheight = 1;

        //salvar.addActionListener(new AdicionarCliente(this));
        painel.add(salvar, gbc33);

        GridBagConstraints gbc34 = new GridBagConstraints();
        gbc34.weighty = 1.0;
        painel.add(new JLabel(""), gbc34);

        this.add(painel);

    }

    public JTextField getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(JTextField razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public JTextField getCnpj() {
        return cnpj;
    }

    public void setCnpj(JTextField cnpj) {
        this.cnpj = cnpj;
    }

    public JTextField getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(JTextField numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public JButton getPesquisarCep() {
        return pesquisarCep;
    }

    public void setPesquisarCep(JButton pesquisarCep) {
        this.pesquisarCep = pesquisarCep;
    }

    public JButton getSalvar() {
        return salvar;
    }

    public void setSalvar(JButton salvar) {
        this.salvar = salvar;
    }

    public JButton getSair() {
        return sair;
    }

    public void setSair(JButton sair) {
        this.sair = sair;
    }

    public JTextArea getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(JTextArea listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }
}

class SalvarFornecedor implements ActionListener{

    private final TelaCadastroFornecedor tela;

    /**
     * Construtor da classe
     * @param tela Tela de cadastro de fornecedor
     */
    public SalvarFornecedor(TelaCadastroFornecedor tela) {
        this.tela = tela;
        
    }

    /**
     * Adicionar um fornecedor
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try
        {
            if(tela.getRazaoSocial().getText().isEmpty() || tela.getCnpj().getText().isEmpty()
                    || tela.getCep().getText().isEmpty() || tela.getRua().getText().isEmpty()
                    || tela.getNumeroCasa().getText().isEmpty() || tela.getBairro().getText().isEmpty()
                    || tela.getCidade().getText().isEmpty())
            {
                throw new Exception();
            }

            try {
                if(!tela.getCnpj().getText().matches("[0-9]+") || !tela.getCep().getText().matches("[0-9]+")
                        || !tela.getNumeroCasa().getText().matches("[0-9]+"))
                {
                    throw new Exception();
                }

                try
                {
                    if(!verificaCNPJ(tela.getCnpj().getText()))
                    {
                        throw new Exception();
                    }
                    try
                    {
                        if(tela.getRazaoSocial().getText().length() < 8)
                        {
                            throw new Exception();
                        }
                        try
                        {
                            if(tela.getUf().getText().isEmpty())
                            {
                                throw new Exception();
                            }
                            List<String> arrayList = Arrays.asList(tela.getListaProdutos().getText().split("\\s*,\\s*"));

                            List<Fornecedor> listFornecedores = JSONFornecedor.lerFornecedores();

                            listFornecedores.add(new Fornecedor(tela.getRazaoSocial().getText(),
                                    tela.getCnpj().getText(), arrayList,tela.getRua().getText(),
                                    tela.getNumeroCasa().getText(),tela.getBairro().getText(),
                                    tela.getCidade().getText(), tela.getUf().getText(),
                                    tela.getCep().getText()));

                            salvarFornecedoresJSON(listFornecedores, tela);
                        }
                        catch (Exception exception)
                        {
                            JOptionPane.showConfirmDialog(null, "Clicar no botão para validar CEP!", "ERRO", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null);
                        }
                    }
                    catch (Exception exception)
                    {
                        JOptionPane.showConfirmDialog(null, "Razão social inválido!\nTamanho Mínimo: 8 caracteres", "ERRO", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null);
                    }
                }
                catch (Exception exception)
                {
                    JOptionPane.showConfirmDialog(null, "CNPJ Inválido", "ERRO", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null);
                }
            }
            catch (Exception exception)
            {
                JOptionPane.showConfirmDialog(null, "Verificar os campos CNPJ, CEP e/ou Número da casa! \nProibido uso de letras\nOBS: Digitar sem colocar caracteres \"(.-)\"!", "ERRO", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null);
            }
        }
        catch (Exception exception)
        {
            JOptionPane.showConfirmDialog(null, "Verificar os campos! \nProibido prosseguir com campos vazios!", "ERRO", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null);
        }
        
    }



    public boolean verificaCNPJ(String CNPJ) {
        // considera-se erro CNPJ's formados por uma sequencia de numeros iguais
        if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") ||
                CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333") ||
                CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555") ||
                CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") ||
                CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999") ||
                (CNPJ.length() != 14))
            return(false);

        char dig13, dig14;
        int sm, i, r, num, peso;

        // "try" - protege o código para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i=11; i>=0; i--) {
                // converte o i-ésimo caractere do CNPJ em um número:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posição de '0' na tabela ASCII)
                num = (int)(CNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig13 = '0';
            else dig13 = (char)((11-r) + 48);

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i=12; i>=0; i--) {
                num = (int)(CNPJ.charAt(i)- 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig14 = '0';
            else dig14 = (char)((11-r) + 48);

            // Verifica se os dígitos calculados conferem com os dígitos informados.
            if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13)))
                return(true);
            else return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
    }
}


