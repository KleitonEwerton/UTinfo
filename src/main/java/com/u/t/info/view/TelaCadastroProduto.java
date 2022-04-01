/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u.t.info.view;

import com.u.t.info.controller.AdicionarProduto;
import com.u.t.info.controller.AtualizaProduto;
import com.u.t.info.src.Fornecedor;
import com.u.t.info.src.Produto;
import com.u.t.info.utils.Arquivo;
import com.u.t.info.utils.JSONFornecedor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.List;

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
 * @author agata
 */
public class TelaCadastroProduto extends JFrame {

    //componentes da tela
    private JTabbedPane barraDeMenu;

    private List<Produto> listaProdutos;

    private JPanel painel;
    private JPanel cadastro;
    private JPanel venda;
    private JPanel inf;

    private JLabel name;
    private JLabel code;
    private JLabel model;
    private JLabel fornecedor;
    private JLabel estoqueMin;
    private JLabel precoVenda;
    private JLabel precoCompra;
    private JLabel descricaoLabel;

    private JTextField nome;
    private JTextField codigo;
    private JTextField modelo;
    private JTextField estoqueInicial;
    private JTextField custoVenda;
    private JTextField custoCompra;
    private JTextField codigoVenda;

    private JTextArea descricao;

    private JComboBox fornecedores;

    private JButton cancelar;
    private JButton salvar;

    
    /*
    Construtor atualiza dados do produto
    */
    public TelaCadastroProduto() {
        super("Produto");
        this.listaProdutos = new ArrayList<>();
        this.addWindowListener(new AtualizaProduto(this));

    }

    
    //atualiza lista usada no combobox
    public void atualizaLista() {
        fornecedores = new JComboBox();
        try {
            String dados = Arquivo.lerArquivo("arquivos/fornecedores.json");
            if (!dados.isEmpty()) {
                List<Fornecedor> fornecedorList = JSONFornecedor.toFornecedores(dados);
                for (int i = 0; i < fornecedorList.size(); i++) {
                    fornecedores.addItem(fornecedorList.get(i).getRazaoSocial());
                }
            }
        } catch (FileNotFoundException ex) {
            fornecedores.addItem("");
            //aqui a lista esta vazia
        }
    }

    //desenha tela
    public void desenha() {

        painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        painel.setPreferredSize(new Dimension(800, 600));

        this.barraDeMenu = new JTabbedPane();
        barraDeMenu.setPreferredSize(new Dimension(800, 525));

        desenhaCadastro();
        desenhaVenda();
        desenhaAdicionais();
        desenhaBotoes();

        this.add(painel);
        //this.getContentPane().add(barraDeMenu);
        this.setSize(800, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null); //iniciar no meio da tela
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    //desenha parte de cadastro
    public void desenhaCadastro() {

        cadastro = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        cadastro.setLayout(layout);
        atualizaLista();
        JLabel jLInfoProduto = new JLabel("Informações Básicas do Produto", JLabel.CENTER);
        Font font = new Font("Leelawadee UI", Font.PLAIN, 18);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        jLInfoProduto.setBorder(blackline);
        jLInfoProduto.setFont(font);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        cadastro.add(jLInfoProduto, gbc);

        name = new JLabel("Nome: ", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        name.setFont(font);

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridwidth = 1;
        gbc2.insets = new Insets(20, 10, 0, 0);
        gbc2.gridheight = 1;
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        cadastro.add(name, gbc2);

        nome = new JTextField(59);
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridwidth = GridBagConstraints.REMAINDER;
        gbc3.anchor = GridBagConstraints.WEST;
        gbc3.insets = new Insets(20, 0, 0, 0);
        gbc3.gridheight = 1;
        gbc3.weightx = 1.0;
        gbc3.gridx = 1;
        gbc3.gridy = 1;
        cadastro.add(nome, gbc3);

        code = new JLabel("Código: ", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        code.setFont(font);

        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridwidth = 1;
        gbc4.insets = new Insets(10, 10, 0, 0);
        gbc4.gridheight = 1;
        gbc4.gridx = 0;
        gbc4.gridy = 2;
        cadastro.add(code, gbc4);

        codigo = new JTextField(10);
        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridwidth = 1;
        gbc5.anchor = GridBagConstraints.WEST;
        gbc5.insets = new Insets(15, 0, 0, 0);
        gbc5.gridheight = 1;
        gbc5.gridx = 1;
        gbc5.gridy = 2;
        cadastro.add(codigo, gbc5);

        model = new JLabel("Modelo: ", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        model.setFont(font);

        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.gridwidth = 1;
        gbc6.insets = new Insets(10, 125, 0, 0);
        gbc6.gridheight = 1;
        gbc6.gridx = 1;
        gbc6.gridy = 2;
        cadastro.add(model, gbc6);

        modelo = new JTextField(41);
        GridBagConstraints gbc7 = new GridBagConstraints();
        gbc7.gridwidth = GridBagConstraints.REMAINDER;
        gbc7.anchor = GridBagConstraints.WEST;
        gbc7.insets = new Insets(15, 0, 0, 0);
        gbc7.gridheight = 1;
        gbc7.gridx = 2;
        gbc7.gridy = 2;
        cadastro.add(modelo, gbc7);

        fornecedor = new JLabel("Fornecedor: ", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        fornecedor.setFont(font);

        GridBagConstraints gbc8 = new GridBagConstraints();
        gbc8.gridwidth = 1;
        gbc8.insets = new Insets(10, 10, 0, 0);
        gbc8.gridheight = 1;
        gbc8.gridx = 0;
        gbc8.gridy = 3;
        cadastro.add(fornecedor, gbc8);

        //fornecedores = new JComboBox(this.listafornecedores);
        fornecedores.setPreferredSize(new Dimension(200, 25));

        GridBagConstraints gbc9 = new GridBagConstraints();
        gbc9.gridwidth = 1;
        gbc9.anchor = GridBagConstraints.WEST;
        gbc9.insets = new Insets(15, 0, 0, 0);
        gbc9.gridheight = 1;
        gbc9.gridx = 1;
        gbc9.gridy = 3;
        cadastro.add(fornecedores, gbc9);

        estoqueMin = new JLabel("Estoque Inicial: ", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        estoqueMin.setFont(font);

        GridBagConstraints gbc10 = new GridBagConstraints();
        gbc10.gridwidth = 1;
        gbc10.insets = new Insets(10, 10, 0, 0);
        gbc10.gridheight = 1;
        gbc10.gridx = 2;
        gbc10.gridy = 3;
        cadastro.add(estoqueMin, gbc10);

        estoqueInicial = new JTextField(8);
        GridBagConstraints gbc11 = new GridBagConstraints();
        gbc11.gridwidth = GridBagConstraints.REMAINDER;
        gbc11.anchor = GridBagConstraints.WEST;
        gbc11.insets = new Insets(15, 0, 0, 0);
        gbc11.gridheight = 1;
        gbc11.gridx = 3;
        gbc11.gridy = 3;
        cadastro.add(estoqueInicial, gbc11);

        GridBagConstraints gbc12 = new GridBagConstraints();
        gbc12.weighty = 1.0;
        cadastro.add(new JLabel(""), gbc12);

        this.barraDeMenu.addTab("Cadastro", this.cadastro);
    }

    
    //desenha parte de venda do produto
    public void desenhaVenda() {

        venda = new JPanel();

        GridBagLayout layout = new GridBagLayout();
        venda.setLayout(layout);

        JLabel jLInfoVenda = new JLabel("Informações do Preço de Venda do Produto", JLabel.CENTER);
        Font font = new Font("Leelawadee UI", Font.PLAIN, 18);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        jLInfoVenda.setBorder(blackline);
        jLInfoVenda.setFont(font);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        venda.add(jLInfoVenda, gbc);

        precoCompra = new JLabel("Preço de Compra: ", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        precoCompra.setFont(font);

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridwidth = 1;
        gbc2.insets = new Insets(20, 10, 0, 0);
        gbc2.gridheight = 1;
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        venda.add(precoCompra, gbc2);

        custoCompra = new JTextField(10);
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridwidth = GridBagConstraints.REMAINDER;
        gbc3.anchor = GridBagConstraints.WEST;
        gbc3.insets = new Insets(20, 0, 0, 0);
        gbc3.gridheight = 1;
        gbc3.weightx = 1.0;
        gbc3.gridx = 1;
        gbc3.gridy = 1;
        venda.add(custoCompra, gbc3);

        precoVenda = new JLabel("Preço de Venda: ", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        precoVenda.setFont(font);

        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridwidth = 1;
        gbc4.insets = new Insets(10, 10, 0, 0);
        gbc4.gridheight = 1;
        gbc4.gridx = 0;
        gbc4.gridy = 2;
        venda.add(precoVenda, gbc4);

        custoVenda = new JTextField(10);
        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridwidth = GridBagConstraints.REMAINDER;
        gbc5.anchor = GridBagConstraints.WEST;
        gbc5.insets = new Insets(15, 0, 0, 0);
        gbc5.gridheight = 1;
        gbc5.weightx = 1.0;
        gbc5.gridx = 1;
        gbc5.gridy = 2;
        venda.add(custoVenda, gbc5);

        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.weighty = 1.0;
        venda.add(new JLabel(""), gbc6);

        this.barraDeMenu.addTab("Custo / Preço de Venda", venda);
    }

    
    //desenha parte de informações adiiconais
    public void desenhaAdicionais() {

        inf = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        inf.setLayout(layout);

        JLabel jLInfoVenda = new JLabel("Informações das Características do Produto", JLabel.CENTER);
        Font font = new Font("Leelawadee UI", Font.PLAIN, 18);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        jLInfoVenda.setBorder(blackline);
        jLInfoVenda.setFont(font);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inf.add(jLInfoVenda, gbc);

        descricaoLabel = new JLabel("Descrição: ", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        descricaoLabel.setFont(font);

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridwidth = 1;
        gbc2.insets = new Insets(20, 10, 0, 0);
        gbc2.gridheight = 1;
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        inf.add(descricaoLabel, gbc2);

        descricao = new JTextArea(5, 61);
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridwidth = GridBagConstraints.REMAINDER;
        gbc3.anchor = GridBagConstraints.WEST;
        gbc3.insets = new Insets(20, 0, 0, 0);
        gbc3.gridheight = 1;
        gbc3.weightx = 1.0;
        gbc3.gridx = 1;
        gbc3.gridy = 1;
        inf.add(new JScrollPane(descricao), gbc3);

        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.weighty = 1.0;
        inf.add(new JLabel(""), gbc4);

        this.barraDeMenu.addTab("Informações Adicionais", inf);

        DefaultListModel<Produto> model = new DefaultListModel<>();
        model.addElement(new Produto("Notebook", "123", 4000.00, 4500.00, "Dell", "8GB CORE I5", "iNSPIRATION", 1000, 50));

    }

    //desenha parte dos botões
    public void desenhaBotoes() {

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 300;
        painel.add(barraDeMenu, gbc);

        cancelar = new JButton("Cancelar");
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 1;
        gbc1.gridy = 1;
        gbc1.gridwidth = 1;
        gbc1.ipady = 5;
        gbc1.anchor = GridBagConstraints.SOUTH;
        gbc1.insets = new Insets(20, 595, 20, 0);
        gbc1.gridheight = 1;
        cancelar.addActionListener(new Cancelar(this));
        painel.add(cancelar, gbc1);

        salvar = new JButton("Salvar");
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 2;
        gbc2.gridy = 1;
        gbc2.ipady = 5;
        gbc2.ipadx = 15;
        gbc2.anchor = GridBagConstraints.SOUTHEAST;
        gbc2.insets = new Insets(20, 0, 20, 35);
        gbc2.gridheight = 1;
        salvar.addActionListener(new AdicionarProduto(this));
        painel.add(salvar, gbc2);

        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.weighty = 1.0;
        painel.add(new JLabel(""), gbc4);

    }

   

    
    //getters e setters
    public JTextField getNome() {
        return nome;
    }

    public JTextField getModelo() {
        return modelo;
    }

    public JTextField getEstoqueInicial() {
        return estoqueInicial;
    }

    public JTextField getCustoVenda() {
        return custoVenda;
    }

    public JTextField getCustoCompra() {
        return custoCompra;
    }

    public JTextField getCodigoVenda() {
        return codigoVenda;
    }

    public JTextArea getDescricao() {
        return descricao;
    }

    public JComboBox getFornecedores() {
        return fornecedores;
    }

    public void setCodigo(JTextField codigo) {
        this.codigo = codigo;
    }

    public void setModelo(JTextField modelo) {
        this.modelo = modelo;
    }

    public void setEstoqueInicial(JTextField estoqueInicial) {
        this.estoqueInicial = estoqueInicial;
    }

    public void setCustoVenda(JTextField custoVenda) {
        this.custoVenda = custoVenda;
    }

    public void setCustoCompra(JTextField custoCompra) {
        this.custoCompra = custoCompra;
    }

    public void setCodigoVenda(JTextField codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public void setDescricao(JTextArea descricao) {
        this.descricao = descricao;
    }

    public void setFornecedores(JComboBox fornecedores) {
        this.fornecedores = fornecedores;
    }

    public JTextField getCodigo() {
        return codigo;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
}

class Cancelar implements ActionListener{
    
    private final TelaCadastroProduto tela;

    public Cancelar(TelaCadastroProduto tela) {
        this.tela = tela;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        tela.dispose();
       
    }

    
}