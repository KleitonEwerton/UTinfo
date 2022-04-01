package com.u.t.info.view;

import com.u.t.info.controller.AdicionarCliente;
import com.u.t.info.controller.AtualizaCliente;
import com.u.t.info.src.Cliente;
import com.u.t.info.utils.BuscaCep;

import java.awt.*;
import java.util.ArrayList;
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
public class TelaCadastroCliente extends TelaCadastro {

    private JTextField nome, cpf;
    private JTextField numeroCasa;
    private JTextField tel1;
    private JButton pesquisarCep, salvar, sair;
    private JRadioButton fixo, celular;
    private ButtonGroup tel;
    private List<Cliente> clientes;

    /**
     * Construtor da classe
     */
    public TelaCadastroCliente() {
        this.clientes = new ArrayList<>();
        this.addWindowListener(new AtualizaCliente(this));
    }

    /**
     * Metodo para desenhar a tela principal
     */
    @Override
    public void desenha() {
        this.setTitle("Cadastro de Cliente");
        this.setVisible(true); //visibilidade
        this.setSize(800, 600); //tamanho
        this.setResizable(false); //bloquear redimensionamento
        this.setLocationRelativeTo(null); //iniciar no meio da tela
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //sair da aplicação
        desenhaTelaCadastroCliente(); //desenho da tela
    }

    /**
     * Metodo para desenhar a tela de cadastro de cliente
     */
    private void desenhaTelaCadastroCliente() {
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
        JLabel jLInfBas = new JLabel("Informações Básicas", JLabel.CENTER);
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

        painel.add(jLInfBas, gbc2); // Ocupa duas células na horizontal.

        JLabel jLNome = new JLabel("Nome: ", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        jLNome.setFont(font);

        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridwidth = 1;
        gbc3.insets = new Insets(20, 10, 0, 0);
        gbc3.gridheight = 1;
        gbc3.gridx = 0;
        gbc3.gridy = 2;
        painel.add(jLNome, gbc3);

        nome = new JTextField(50);
        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridwidth = GridBagConstraints.REMAINDER;
        gbc4.anchor = GridBagConstraints.WEST;
        gbc4.insets = new Insets(20, 0, 0, 0);
        gbc4.gridheight = 1;
        gbc4.weightx = 1.0;
        gbc4.gridx = 1;
        gbc4.gridy = 2;

        painel.add(nome, gbc4);

        JLabel jLCPF = new JLabel("CPF: ", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        jLCPF.setFont(font);

        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridwidth = 1;
        gbc5.insets = new Insets(10, 10, 45, 0);
        gbc5.gridheight = 1;
        gbc5.gridx = 0;
        gbc5.gridy = 3;
        painel.add(jLCPF, gbc5);

        cpf = new JTextField(10);
        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.gridwidth = GridBagConstraints.REMAINDER;
        gbc6.anchor = GridBagConstraints.WEST;

        gbc6.insets = new Insets(15, 0, 45, 0);
        gbc6.gridheight = 1;
        gbc6.gridx = 1;
        gbc6.gridy = 3;
        painel.add(cpf, gbc6);


        Border cadastro = BorderFactory.createRaisedBevelBorder();
        ImageIcon image = new ImageIcon(new ImageIcon("img/Pessoa.png").getImage().getScaledInstance(120, 100, Image.SCALE_DEFAULT));
        JLabel imageLabel = new JLabel(image);
        imageLabel.setBorder(cadastro);

        GridBagConstraints gbcImg = new GridBagConstraints();
        gbcImg.gridwidth = GridBagConstraints.REMAINDER;
        gbcImg.anchor = GridBagConstraints.CENTER;
        gbcImg.fill = GridBagConstraints.VERTICAL;
        gbcImg.insets = new Insets(20, 0, 0, 0);
        gbcImg.gridx = 6;
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

        JLabel jLNumero = new JLabel("Número: ", JLabel.CENTER);
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

        numeroCasa = new JTextField(7);
        GridBagConstraints gcb14 = new GridBagConstraints();
        gcb14.gridwidth = GridBagConstraints.REMAINDER;
        gcb14.anchor = GridBagConstraints.WEST;
        gcb14.insets = new Insets(15, 0, 0, 0);
        gcb14.gridheight = 1;
        gcb14.gridx = 8;
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

        JLabel jLContato = new JLabel("Contato", JLabel.CENTER);
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

        JLabel jLTel1 = new JLabel("Telefone: ", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        jLTel1.setFont(font);

        GridBagConstraints gbc22 = new GridBagConstraints();
        gbc22.gridwidth = 1;
        gbc22.insets = new Insets(20, 10, 0, 0);
        gbc22.gridheight = 1;
        gbc22.gridx = 0;
        gbc22.gridy = 9;
        painel.add(jLTel1, gbc22);

        tel1 = new JTextField(10);
        GridBagConstraints gbc23 = new GridBagConstraints();
        gbc23.gridwidth = GridBagConstraints.REMAINDER;
        gbc23.anchor = GridBagConstraints.WEST;
        gbc23.insets = new Insets(20, 0, 0, 0);
        gbc23.gridheight = 1;
        gbc23.weightx = 1.0;
        gbc23.gridx = 1;
        gbc23.gridy = 9;

        painel.add(tel1, gbc23);

        fixo = new JRadioButton("Fixo");
        fixo.setFont(font);
        fixo.setActionCommand("Fixo");
        celular = new JRadioButton("Celular");
        celular.setFont(font);
        celular.setActionCommand("Celular");
        tel = new ButtonGroup();
        tel.add(fixo);
        tel.add(celular);

        GridBagConstraints gbc24 = new GridBagConstraints();
        gbc24.gridwidth = GridBagConstraints.REMAINDER;
        gbc24.anchor = GridBagConstraints.WEST;
        gbc24.insets = new Insets(15, 0, 0, 0);
        gbc24.gridheight = 1;
        gbc24.weightx = 1.0;
        gbc24.gridx = 2;
        gbc24.gridy = 9;
        painel.add(fixo, gbc24);

        GridBagConstraints gbc25 = new GridBagConstraints();
        gbc25.gridwidth = GridBagConstraints.REMAINDER;
        gbc25.anchor = GridBagConstraints.WEST;
        gbc25.insets = new Insets(15, 0, 0, 0);
        gbc25.gridheight = 1;
        gbc25.weightx = 1.0;
        gbc25.gridx = 3;
        gbc25.gridy = 9;
        painel.add(celular, gbc25);

        sair = new JButton("Cancelar");

        GridBagConstraints gbc32 = new GridBagConstraints();
        gbc32.gridx = 5;
        gbc32.gridy = 13;
        gbc32.gridwidth = 2;
        gbc32.fill = GridBagConstraints.BOTH;
        gbc32.ipady = 5;
        gbc32.anchor = GridBagConstraints.EAST;
        gbc32.insets = new Insets(20, 0, 20, 0);
        gbc32.gridheight = 1;

        painel.add(sair, gbc32);

        salvar = new JButton("Salvar");
        GridBagConstraints gbc33 = new GridBagConstraints();
        gbc33.gridx = 8;
        gbc33.gridy = 13;
        gbc33.ipady = 5;
        gbc33.ipadx = 15;
        gbc33.gridwidth = 1;
        gbc33.anchor = GridBagConstraints.WEST;
        gbc33.insets = new Insets(20, 0, 20, 0);
        gbc33.gridheight = 1;

        salvar.addActionListener(new AdicionarCliente(this));
        painel.add(salvar, gbc33);

        GridBagConstraints gbc34 = new GridBagConstraints();
        gbc34.weighty = 1.0;
        painel.add(new JLabel(""), gbc34);

        this.add(painel);
    }

    /*
    public static void main(String[] args) {
        TelaCadastroCliente tela = new TelaCadastroCliente();
        tela.desenha();
        tela.pack();
    }
     */

    public JTextField getNome() {
        return nome;
    }

    public void setNome(JTextField nome) {
        this.nome = nome;
    }

    public JTextField getCpf() {
        return cpf;
    }

    public void setCpf(JTextField cpf) {
        this.cpf = cpf;
    }

    public JTextField getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(JTextField numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public JTextField getTel1() {
        return tel1;
    }

    public void setTel1(JTextField tel1) {
        this.tel1 = tel1;
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

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ButtonGroup getTel() {
        return tel;
    }

    public void setTel(ButtonGroup tel) {
        this.tel = tel;
    }
}
