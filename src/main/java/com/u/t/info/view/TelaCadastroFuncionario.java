package com.u.t.info.view;

//import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import com.u.t.info.controller.CancelarAcao;
import com.u.t.info.controller.LimparFormularioFuncionario;
import com.u.t.info.src.*;
import static com.u.t.info.src.Funcionario.retornaListaFuncionarios;
import com.u.t.info.utils.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
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
public class TelaCadastroFuncionario extends TelaCadastro {

    private JTextField nome, telefone;
    private JTextField cpf;
    private JPasswordField senha1, senha2;
    private JTextField numeroCasa;
    private JButton pesquisarCep, salvar, sair;
    private JRadioButton fixo, celular;
    private ButtonGroup tel;
    private JComboBox comboBox;
    private JTabbedPane jtb;

    /**
     * Construtor vazio
     */
    public TelaCadastroFuncionario() {

    }

    /**
     * Metodo para desenhar a tela principal
     */
    @Override
    public void desenha() {
        
        this.setTitle("Cadastro de Funcionário");
        this.setVisible(true); //visibilidade
        this.setSize(800, 600); //tamanho
        this.setResizable(false); //bloquear redimensionamento
        this.setLocationRelativeTo(null); //iniciar no meio da tela
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //sair da aplicação
        desenhaTelaCadastroFuncionario(); //desenho da tela
    }

    /**
     * Metodo para desenhar a tela de cadastro de funcionario
     */
    private void desenhaTelaCadastroFuncionario() {
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        painel.setPreferredSize(new Dimension(800, 600));

        jtb = new JTabbedPane();

        jtb.setPreferredSize(new Dimension(800, 525));
        JPanel painelCadastro = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        painelCadastro.setLayout(layout);

        JLabel jLInf = new JLabel("Informações Básicas", JLabel.CENTER);
        Font font = new Font("Leelawadee UI", Font.PLAIN, 18);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        jLInf.setBorder(blackline);
        jLInf.setFont(font);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painelCadastro.add(jLInf, gbc);

        JLabel jLNome = new JLabel("Nome: ", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        jLNome.setFont(font);

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridwidth = 1;
        gbc2.insets = new Insets(20, 10, 0, 0);
        gbc2.gridheight = 1;
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        painelCadastro.add(jLNome, gbc2);

        nome = new JTextField(50);
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridwidth = GridBagConstraints.REMAINDER;
        gbc3.anchor = GridBagConstraints.WEST;
        gbc3.insets = new Insets(20, 0, 0, 0);
        gbc3.gridheight = 1;
        gbc3.weightx = 1.0;
        gbc3.gridx = 1;
        gbc3.gridy = 1;
        painelCadastro.add(nome, gbc3);

        JLabel jLTelefone = new JLabel("Telefone: ", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        jLTelefone.setFont(font);

        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridwidth = 1;
        gbc4.insets = new Insets(10, 10, 0, 0);
        gbc4.gridheight = 1;
        gbc4.gridx = 0;
        gbc4.gridy = 2;
        painelCadastro.add(jLTelefone, gbc4);

        telefone = new JTextField(10);
        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridwidth = 1;
        gbc5.anchor = GridBagConstraints.WEST;
        gbc5.insets = new Insets(15, 0, 0, 0);
        gbc5.gridheight = 1;
        gbc5.gridx = 1;
        gbc5.gridy = 2;
        painelCadastro.add(telefone, gbc5);

        fixo = new JRadioButton("Fixo");
        fixo.setFont(font);
        fixo.setActionCommand("Fixo");
        celular = new JRadioButton("Celular");
        celular.setFont(font);
        celular.setActionCommand("Celular");
        tel = new ButtonGroup();
        tel.add(fixo);
        tel.add(celular);

        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.gridwidth = 1;
        gbc6.anchor = GridBagConstraints.WEST;
        gbc6.insets = new Insets(10, 0, 0, 0);
        gbc6.gridheight = 1;
        gbc6.gridx = 2;
        gbc6.gridy = 2;
        painelCadastro.add(fixo, gbc6);

        GridBagConstraints gbc7 = new GridBagConstraints();
        gbc7.gridwidth = GridBagConstraints.REMAINDER;
        gbc7.anchor = GridBagConstraints.WEST;
        gbc7.insets = new Insets(10, 0, 0, 0);
        gbc7.gridheight = 1;
        gbc7.weightx = 1.0;
        gbc7.gridx = 3;
        gbc7.gridy = 2;
        painelCadastro.add(celular, gbc7);

        JLabel jLCargo = new JLabel("Cargo: ", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        jLCargo.setFont(font);

        GridBagConstraints gbc8 = new GridBagConstraints();
        gbc8.gridwidth = 1;
        gbc8.insets = new Insets(10, 10, 0, 0);
        gbc8.gridheight = 1;
        gbc8.gridx = 0;
        gbc8.gridy = 3;
        painelCadastro.add(jLCargo, gbc8);

        String cargos[] = {"Gerente", "Supervisor", "Vendedor"};
        comboBox = new JComboBox(cargos);

        GridBagConstraints gbc9 = new GridBagConstraints();
        gbc9.gridwidth = 1;
        gbc9.anchor = GridBagConstraints.WEST;
        gbc9.insets = new Insets(15, 0, 0, 0);
        gbc9.gridheight = 1;
        gbc9.gridx = 1;
        gbc9.gridy = 3;
        painelCadastro.add(comboBox, gbc9);

        Border cadastro = BorderFactory.createRaisedBevelBorder();
        ImageIcon image = new ImageIcon(new ImageIcon("img/Funcionario.png").getImage().getScaledInstance(120, 100, Image.SCALE_DEFAULT));
        JLabel imageLabel = new JLabel(image);
        imageLabel.setBorder(cadastro);

        GridBagConstraints gbcImg = new GridBagConstraints();
        gbcImg.gridwidth = GridBagConstraints.REMAINDER;
        gbcImg.anchor = GridBagConstraints.CENTER;
        gbcImg.fill = GridBagConstraints.VERTICAL;
        gbcImg.insets = new Insets(20, 0, 0, 0);
        gbcImg.gridx = 6;
        gbcImg.gridy = 1;
        gbcImg.gridheight = 3;
        painelCadastro.add(imageLabel, gbcImg);

        JLabel jlEndereco = new JLabel("Endereço", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        jlEndereco.setBorder(blackline);
        jlEndereco.setFont(font);

        GridBagConstraints gbc10 = new GridBagConstraints();
        gbc10.gridwidth = GridBagConstraints.REMAINDER;
        gbc10.insets = new Insets(20, 0, 0, 0);
        gbc10.gridheight = 1;
        gbc10.weightx = 1.0;
        gbc10.gridx = 0;
        gbc10.gridy = 4;
        gbc10.fill = GridBagConstraints.HORIZONTAL;
        painelCadastro.add(jlEndereco, gbc10);

        JLabel jLCEP = new JLabel("CEP: ", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        jLCEP.setFont(font);

        GridBagConstraints gbc11 = new GridBagConstraints();
        gbc11.gridwidth = 1;
        gbc11.insets = new Insets(20, 10, 0, 0);
        gbc11.gridheight = 1;
        gbc11.gridx = 0;
        gbc11.gridy = 5;
        painelCadastro.add(jLCEP, gbc11);

        super.setCep(new JTextField(10));
        GridBagConstraints gbc12 = new GridBagConstraints();
        gbc12.gridwidth = 1;
        gbc12.anchor = GridBagConstraints.WEST;
        gbc12.insets = new Insets(20, 0, 0, 0);
        gbc12.gridheight = 1;
        gbc12.gridx = 1;
        gbc12.gridy = 5;

        painelCadastro.add(super.getCep(), gbc12);

        pesquisarCep = new JButton("Localizar");
        GridBagConstraints gbc13 = new GridBagConstraints();
        gbc13.gridx = 2;
        gbc13.gridy = 5;
        gbc13.gridwidth = GridBagConstraints.REMAINDER;
        gbc13.anchor = GridBagConstraints.WEST;
        gbc13.insets = new Insets(20, 0, 0, 0);
        gbc13.gridheight = 1;
        pesquisarCep.addActionListener(new BuscaCep(this));
        painelCadastro.add(pesquisarCep, gbc13);

        JLabel jLRua = new JLabel("Rua: ", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        jLRua.setFont(font);

        GridBagConstraints gbc14 = new GridBagConstraints();
        gbc14.gridwidth = 1;
        gbc14.insets = new Insets(10, 10, 0, 0);
        gbc14.gridheight = 1;
        gbc14.gridx = 0;
        gbc14.gridy = 6;
        painelCadastro.add(jLRua, gbc14);

        super.setRua(new JTextField(47));
        GridBagConstraints gbc15 = new GridBagConstraints();
        gbc15.gridwidth = GridBagConstraints.RELATIVE;
        gbc15.anchor = GridBagConstraints.WEST;
        gbc15.insets = new Insets(15, 0, 0, 0);
        gbc15.gridheight = 1;
        gbc15.gridx = 1;
        gbc15.gridy = 6;
        painelCadastro.add(super.getRua(), gbc15);

        JLabel jLNumero = new JLabel("Número: ", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        jLNumero.setFont(font);

        GridBagConstraints gbc16 = new GridBagConstraints();
        gbc16.gridwidth = GridBagConstraints.REMAINDER;
        gbc16.anchor = GridBagConstraints.WEST;
        gbc16.insets = new Insets(10, 10, 0, 0);
        gbc16.gridheight = 1;
        gbc16.gridx = 5;
        gbc16.gridy = 6;
        painelCadastro.add(jLNumero, gbc16);

        numeroCasa = new JTextField(7);
        GridBagConstraints gbc17 = new GridBagConstraints();
        gbc17.gridwidth = GridBagConstraints.REMAINDER;
        gbc17.anchor = GridBagConstraints.EAST;
        gbc17.insets = new Insets(15, 0, 0, 20);
        gbc17.gridheight = 1;
        gbc17.gridx = 6;
        gbc17.gridy = 6;
        painelCadastro.add(numeroCasa, gbc17);

        JLabel jLBairro = new JLabel("Bairro: ", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        jLBairro.setFont(font);

        GridBagConstraints gbc18 = new GridBagConstraints();
        gbc18.gridwidth = 1;
        gbc18.insets = new Insets(10, 10, 0, 0);
        gbc18.gridheight = 1;
        gbc18.gridx = 0;
        gbc18.gridy = 7;
        painelCadastro.add(jLBairro, gbc18);

        super.setBairro(new JTextField(12));
        GridBagConstraints gbc19 = new GridBagConstraints();
        gbc19.gridwidth = 1;
        gbc19.anchor = GridBagConstraints.WEST;
        gbc19.insets = new Insets(15, 0, 0, 0);
        gbc19.gridheight = 1;
        gbc19.gridx = 1;
        gbc19.gridy = 7;
        painelCadastro.add(super.getBairro(), gbc19);

        JLabel jLCidade = new JLabel("Cidade: ", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        jLCidade.setFont(font);

        GridBagConstraints gbc20 = new GridBagConstraints();
        gbc20.gridwidth = 1;
        gbc20.anchor = GridBagConstraints.WEST;
        gbc20.insets = new Insets(10, 10, 0, 0);
        gbc20.gridheight = 1;
        gbc20.gridx = 2;
        gbc20.gridy = 7;
        painelCadastro.add(jLCidade, gbc20);

        super.setCidade(new JTextField(28));
        GridBagConstraints gbc21 = new GridBagConstraints();
        gbc21.gridwidth = 1;
        gbc21.anchor = GridBagConstraints.WEST;
        gbc21.insets = new Insets(15, 0, 0, 0);
        gbc21.gridheight = 1;
        gbc21.gridx = 3;
        gbc21.gridy = 7;
        painelCadastro.add(super.getCidade(), gbc21);

        JLabel jLUF = new JLabel("UF: ", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        jLUF.setFont(font);

        GridBagConstraints gbc22 = new GridBagConstraints();
        gbc22.gridwidth = 1;
        gbc22.anchor = GridBagConstraints.WEST;
        gbc22.insets = new Insets(10, 10, 0, 0);
        gbc22.gridheight = 1;
        gbc22.gridx = 5;
        gbc22.gridy = 7;
        painelCadastro.add(jLUF, gbc22);

        super.setUf(new JTextField(2));
        super.getUf().setEnabled(false);

        GridBagConstraints gbc23 = new GridBagConstraints();
        gbc23.gridwidth = GridBagConstraints.REMAINDER;
        gbc23.anchor = GridBagConstraints.WEST;
        gbc23.insets = new Insets(15, 0, 0, 0);
        gbc23.gridheight = 1;
        gbc23.gridx = 6;
        gbc23.gridy = 7;
        painelCadastro.add(super.getUf(), gbc23);

        GridBagConstraints gbc24 = new GridBagConstraints();
        gbc24.weighty = 1.0;
        painelCadastro.add(new JLabel(""), gbc24);

        jtb.addTab("Cadastro", painelCadastro);

        JPanel painelLogin = new JPanel();
        painelLogin.setLayout(layout);

        JLabel jLLogin = new JLabel("Informações de Login", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        jLLogin.setBorder(blackline);
        jLLogin.setFont(font);

        GridBagConstraints gbc25 = new GridBagConstraints();
        gbc25.gridwidth = GridBagConstraints.REMAINDER;
        gbc25.insets = new Insets(10, 0, 0, 0);
        gbc25.gridheight = 1;
        gbc25.gridx = 0;
        gbc25.gridy = 0;
        gbc25.weightx = 1.0;
        gbc25.fill = GridBagConstraints.HORIZONTAL;
        painelLogin.add(jLLogin, gbc25);

        JLabel jLCPF = new JLabel("CPF: ", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        jLCPF.setFont(font);

        GridBagConstraints gbc26 = new GridBagConstraints();
        gbc26.gridwidth = 1;
        gbc26.insets = new Insets(20, 10, 0, 0);
        gbc26.gridheight = 1;
        gbc26.gridx = 0;
        gbc26.gridy = 1;
        painelLogin.add(jLCPF, gbc26);

        cpf = new JTextField(10);
        GridBagConstraints gbc27 = new GridBagConstraints();
        gbc27.gridwidth = GridBagConstraints.REMAINDER;
        gbc27.anchor = GridBagConstraints.WEST;
        gbc27.insets = new Insets(20, 0, 0, 0);
        gbc27.gridheight = 1;
        gbc27.weightx = 1.0;
        gbc27.gridx = 1;
        gbc27.gridy = 1;
        painelLogin.add(cpf, gbc27);

        JLabel jLSenha1 = new JLabel("Senha: ", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        jLSenha1.setFont(font);

        GridBagConstraints gbc28 = new GridBagConstraints();
        gbc28.gridwidth = 1;
        gbc28.insets = new Insets(10, 10, 0, 0);
        gbc28.gridheight = 1;
        gbc28.gridx = 0;
        gbc28.gridy = 2;
        painelLogin.add(jLSenha1, gbc28);

        senha1 = new JPasswordField(10);
        GridBagConstraints gbc29 = new GridBagConstraints();
        gbc29.gridwidth = 1;
        gbc29.anchor = GridBagConstraints.WEST;
        gbc29.insets = new Insets(15, 0, 0, 0);
        gbc29.gridheight = 1;
        gbc29.gridx = 1;
        gbc29.gridy = 2;
        painelLogin.add(senha1, gbc29);

        JLabel jLSenha2 = new JLabel("Confirmar Senha: ", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        jLSenha2.setFont(font);

        GridBagConstraints gbc30 = new GridBagConstraints();
        gbc30.gridwidth = 1;
        gbc30.insets = new Insets(10, 10, 0, 0);
        gbc30.gridheight = 1;
        gbc30.gridx = 2;
        gbc30.gridy = 2;
        painelLogin.add(jLSenha2, gbc30);

        senha2 = new JPasswordField(10);
        GridBagConstraints gbc31 = new GridBagConstraints();
        gbc31.gridwidth = 1;
        gbc31.anchor = GridBagConstraints.WEST;
        gbc31.insets = new Insets(15, 0, 0, 0);
        gbc31.gridheight = 1;
        gbc31.gridx = 3;
        gbc31.gridy = 2;
        painelLogin.add(senha2, gbc31);

        //usuario selecionar para mostrar a senha
        JCheckBox checkbox = new JCheckBox("Mostrar senha");
        GridBagConstraints gbc32 = new GridBagConstraints();
        gbc32.anchor = GridBagConstraints.WEST;
        gbc32.gridx = 1;
        gbc32.gridy = 3;
        gbc32.gridwidth = GridBagConstraints.REMAINDER;
        gbc32.insets = new Insets(8, 0, 0, 0);
        painelLogin.add(checkbox, gbc32);

        //evento para mostrar a senha
        checkbox.addActionListener(ae -> {
            JCheckBox c = (JCheckBox) ae.getSource();
            senha1.setEchoChar(c.isSelected() ? '\u0000' : (Character) UIManager.get("PasswordField.echoChar"));
            senha2.setEchoChar(c.isSelected() ? '\u0000' : (Character) UIManager.get("PasswordField.echoChar"));
        });

        painelLogin.add(new JLabel(""), gbc24);

        jtb.addTab("Login", painelLogin);

        GridBagConstraints gbcPrincipal = new GridBagConstraints();
        gbcPrincipal.fill = GridBagConstraints.BOTH;
        gbcPrincipal.gridwidth = GridBagConstraints.REMAINDER;
        gbcPrincipal.insets = new Insets(0, 0, 0, 0);
        gbcPrincipal.gridx = 0;
        gbcPrincipal.gridy = 0;
        painel.add(jtb, gbcPrincipal);

        sair = new JButton("Cancelar");
        
        
        GridBagConstraints gbc33 = new GridBagConstraints();
        gbc33.gridx = 1;
        gbc33.gridy = 1;
        gbc33.gridwidth = 1;
        //gbc33.fill = GridBagConstraints.BOTH;
        gbc33.ipady = 5;
        gbc33.anchor = GridBagConstraints.SOUTH;
        gbc33.insets = new Insets(20, 595, 20, 0);
        gbc33.gridheight = 1;
        painel.add(sair, gbc33);

        salvar = new JButton("Salvar");
        GridBagConstraints gbc34 = new GridBagConstraints();
        gbc34.gridx = 2;
        gbc34.gridy = 1;
        gbc34.ipady = 5;
        gbc34.ipadx = 15;
        // gbc34.fill = GridBagConstraints.BOTH;
        //gbc34.gridwidth = GridBagConstraints.REMAINDER;
        gbc34.anchor = GridBagConstraints.SOUTHEAST;
        gbc34.insets = new Insets(20, 0, 20, 35);
        gbc34.gridheight = 1;

        salvar.addActionListener(new AdicionarFuncionario(this));
        painel.add(salvar, gbc34);
        sair.addActionListener(new CancelarAcao(this));
        this.add(painel);
    }

    /*
    public static void main(String[] args) {
        TelaCadastroFuncionario tela = new TelaCadastroFuncionario();
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

    public JTextField getTelefone() {
        return telefone;
    }

    public void setTelefone(JTextField telefone) {
        this.telefone = telefone;
    }

    public JTextField getCpf() {
        return cpf;
    }

    public void setCpf(JTextField cpf) {
        this.cpf = cpf;
    }

    public JPasswordField getSenha1() {
        return senha1;
    }

    public void setSenha1(JPasswordField senha1) {
        this.senha1 = senha1;
    }

    public JPasswordField getSenha2() {
        return senha2;
    }

    public void setSenha2(JPasswordField senha2) {
        this.senha2 = senha2;
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

    public JRadioButton getFixo() {
        return fixo;
    }

    public void setFixo(JRadioButton fixo) {
        this.fixo = fixo;
    }

    public JRadioButton getCelular() {
        return celular;
    }

    public void setCelular(JRadioButton celular) {
        this.celular = celular;
    }

    public ButtonGroup getTel() {
        return tel;
    }

    public void setTel(ButtonGroup tel) {
        this.tel = tel;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public void setComboBox(JComboBox comboBox) {
        this.comboBox = comboBox;
    }

    public JTabbedPane getJtb() {
        return jtb;
    }

    public void setJtb(JTabbedPane jtb) {
        this.jtb = jtb;
    }

}

class AdicionarFuncionario implements ActionListener
{
    TelaCadastroFuncionario tela;

    /**
     * Construtor da classe
     * @param tela
     */
    public AdicionarFuncionario (TelaCadastroFuncionario tela) {
        this.tela = tela;
    }

    /**
     * Adicionar um funcionario
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            if (tela.getNome().getText().isEmpty() || tela.getTelefone().getText().isEmpty()
                    || tela.getCep().getText().isEmpty() || tela.getRua().getText().isEmpty()
                    || tela.getNumeroCasa().getText().isEmpty() || tela.getBairro().getText().isEmpty()
                    || tela.getCidade().getText().isEmpty() || tela.getCpf().getText().isEmpty()
                    || tela.getSenha1().getText().isEmpty() || tela.getSenha2().getText().isEmpty()) {
                throw new Exception();
            }

            try
            {
                if(!tela.getCpf().getText().matches("[0-9]+") || !tela.getCep().getText().matches("[0-9]+")
                        || !tela.getNumeroCasa().getText().matches("[0-9]+") || !tela.getTelefone().getText().matches("[0-9]+"))
                {
                    throw new Exception();
                }

                try
                {
                    if(tela.getNome().getText().length() < 8)
                    {
                        throw  new Exception();
                    }

                    try
                    {
                        if(!validaCPF(tela.getCpf().getText()))
                        {
                            throw new Exception();
                        }

                        try
                        {
                            if(tela.getUf().getText().isEmpty())
                            {
                                throw new Exception();
                            }

                            try
                            {
                                String str = tela.getTel().getSelection().getActionCommand();
                                try
                                {
                                    if ((tela.getTelefone().getText().length() < 10) || (tela.getTelefone().getText().length() > 11)) {
                                        throw new Exception();
                                    }

                                    try {
                                        if (!tela.getSenha1().getText().equals(tela.getSenha2().getText())) {
                                            throw new Exception();
                                        }
                                        try
                                        {
                                            if (tela.getSenha1().getText().length() < 8)
                                            {
                                                throw new Exception();
                                            }
                                            String funcionario = tela.getComboBox().getSelectedItem().toString();

                                            switch (funcionario) {
                                                case "Gerente":
                                                    List<Gerente> gerenteList = new ArrayList<>();
                                                    gerenteList = JSONGerente.lerGerentes();
                                                    gerenteList.add(new Gerente(tela.getNome().getText(), tela.getTelefone().getText(), tela.getTel().getSelection().getActionCommand(),
                                                            tela.getCpf().getText(), tela.getSenha1().getText(),
                                                            tela.getRua().getText(), tela.getNumeroCasa().getText(), tela.getBairro().getText(),
                                                            tela.getCidade().getText(), tela.getUf().getText(), tela.getCep().getText(),
                                                            5500));
                                                    String toJSON = JSONGerente.toJSONGerentes(gerenteList);
                                                    try {

                                                        Arquivo.escreverArquivo("arquivos/gerentes.json", toJSON);
                                                        JOptionPane.showMessageDialog(tela, "Funcionario adicionado");
                                                        LimparFormularioFuncionario limparFormularioFuncionario = new LimparFormularioFuncionario(tela);
                                                        limparFormularioFuncionario.LimparFormulario();
                                                    } catch (IOException ex) {

                                                        System.out.println("Erro ao salvar os gerentes");
                                                    }
                                                    break;
                                                case "Vendedor":
                                                    List<Vendedor> vendedorList = new ArrayList<>();
                                                    vendedorList = JSONVendedor.lerVendedores();
                                                    List<Venda> vendaList = new ArrayList<>();

                                                    vendedorList.add(new Vendedor(vendaList, tela.getNome().getText(), tela.getTelefone().getText(), str,
                                                            tela.getCpf().getText(), tela.getSenha1().getText(),
                                                            tela.getRua().getText(), tela.getNumeroCasa().getText(), tela.getBairro().getText(),
                                                            tela.getCidade().getText(), tela.getUf().getText(), tela.getCep().getText(),
                                                            1100));

                                                    String toJSON1 = JSONVendedor.toJSONSVendedores(vendedorList);
                                                    try {

                                                        Arquivo.escreverArquivo("arquivos/vendedores.json", toJSON1);
                                                        JOptionPane.showMessageDialog(tela, "Funcionario adicionado");
                                                        LimparFormularioFuncionario limparFormularioFuncionario = new LimparFormularioFuncionario(tela);
                                                        limparFormularioFuncionario.LimparFormulario();
                                                    } catch (IOException ex) {

                                                        System.out.println("Erro ao salvar os gerentes");
                                                    }
                                                    break;
                                                case "Supervisor":
                                                    List<Supervisor> supervisorList = new ArrayList<>();
                                                    supervisorList = JSONSupervisor.lerSupervisor();

                                                    supervisorList.add(new Supervisor(tela.getNome().getText(), tela.getTelefone().getText(), str,
                                                            tela.getCpf().getText(), tela.getSenha1().getText(),
                                                            tela.getRua().getText(), tela.getNumeroCasa().getText(), tela.getBairro().getText(),
                                                            tela.getCidade().getText(), tela.getUf().getText(), tela.getCep().getText(),
                                                            5500));

                                                    String toJSON2 = JSONSupervisor.toJSONSupervisores(supervisorList);
                                                    try {

                                                        Arquivo.escreverArquivo("arquivos/supervisores.json", toJSON2);
                                                        JOptionPane.showMessageDialog(tela, "Funcionario adicionado");
                                                        LimparFormularioFuncionario limparFormularioFuncionario = new LimparFormularioFuncionario(tela);
                                                        limparFormularioFuncionario.LimparFormulario();
                                                    } catch (IOException ex) {

                                                        System.out.println("Erro ao salvar os supervisores");
                                                    }
                                                    break;
                                            }
                                        }
                                        catch (Exception exception)
                                        {
                                            JOptionPane.showConfirmDialog(null, "Senha deve conter, no mínimo, 8 caracteres!", "ERRO", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null);
                                        }

                                    }
                                    catch (Exception exception)
                                    {
                                        JOptionPane.showConfirmDialog(null, "Senhas Diferentes!", "ERRO", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null);
                                    }
                                }
                                catch (Exception exception)
                                {
                                    JOptionPane.showConfirmDialog(null, "Telefone invalido!", "ERRO", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null);
                                }

                            }
                            catch (NullPointerException e) {
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
                        JOptionPane.showConfirmDialog(null, "CPF Inválido ou já utilizado", "ERRO", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null);
                    }
                }
                catch (Exception exception)
                {
                    JOptionPane.showConfirmDialog(null, "Nome inválido!\nTamanho Mínimo: 8 caracteres", "ERRO", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null);
                }
            }
            catch (Exception exception)
            {
                JOptionPane.showConfirmDialog(null, "Verificar os campos CPF, CEP, Número da casa e/ou Telefone! \nProibido uso de letras\nOBS: Digitar sem colocar caracteres \"(.-)\"!", "ERRO", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null);
            }

        }
        catch (Exception exception)
        {
            JOptionPane.showConfirmDialog(null, "Verificar os campos! \nProibido prosseguir com campos vazios!", "ERRO", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null);
        }
    }

    public boolean validaCPF(String CPF) {
        
        List<Funcionario> listFunc = retornaListaFuncionarios();
        List<String>cpfs = new ArrayList<>();
        //Adiciona todos os cpfs cadastrados
        for(Funcionario f: listFunc){
            switch (f.getClass().getTypeName())
            {
                case "com.u.t.info.src.Gerente":
                    cpfs.add(((Gerente)f).getCpf());
                    break;
                case "com.u.t.info.src.Supervisor":
                    cpfs.add(((Supervisor)f).getCpf());
                    break;
                case "com.u.t.info.src.Vendedor":
                    cpfs.add(((Vendedor)f).getCpf());
                    break;
            }
        }
        if(cpfs.contains(CPF))return false; //Verifica se não já está cadastrado
        
        
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

