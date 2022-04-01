/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u.t.info.view;

import com.u.t.info.controller.HabilitarDevolucoes;
import com.u.t.info.controller.HabilitarEstoque;
import com.u.t.info.controller.NotificarGerente;
import com.u.t.info.controller.RealizarDevolucao;
import com.u.t.info.src.Produto;
import com.u.t.info.src.Supervisor;
import com.u.t.info.tables.TableProdutos;
import com.u.t.info.utils.Arquivo;
import com.u.t.info.utils.JSONProduto;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;
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
 * @author agata
 */
public class TelaSupervisor extends JFrame {

    private JPanel painelPrincipal;

    private JPanel estoque = new JPanel();
    private JPanel compras = new JPanel();
    private JPanel devolucoes = new JPanel();

    private JPanel botoes;

    private JLabel txt_Inf = new JLabel();

    private JLabel quantidadeDevolucao;
    private JTextField jtQuantidadeDevolucao;
    private JLabel codigo;
    private JLabel defeito;
    private JRadioButton sim;
    private JRadioButton nao;
    private ButtonGroup rbDefeito;

    private int lastIndex;

    private JScrollPane barraRolagem;
    private CardLayout cardLayout;
    private JPanel painel;

    private TableProdutos modelProduto;
    private JTable tableProduto;
    private JComboBox jComboBoxProdutos;

    
    /*
    Contrutor da classe
    param: Supervisor supervisor
    */
    public TelaSupervisor(Supervisor supervisor) {
        super("Supervisonamento - " + supervisor.getNome());
        this.calendario();
    }

    
    //função que pega horario e data atual e armazena em um label
    public void calendario() {
        Thread clock = new Thread() {
            public void run() {
                try {
                    for (;;) {
                        Calendar cal = new GregorianCalendar();
                        int dia = cal.get(Calendar.DAY_OF_MONTH);
                        int mes = cal.get(Calendar.MONTH);
                        int ano = cal.get(Calendar.YEAR);

                        int segundos = cal.get(Calendar.SECOND);
                        int minutos = cal.get(Calendar.MINUTE);
                        int horas = cal.get(Calendar.HOUR_OF_DAY);

                        txt_Inf.setText("Supervisionamento" + " " + (horas - 1) + ":" + minutos + ":" + segundos + "    " + dia + "/" + (mes + 1) + "/" + ano);
                        sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        clock.start();
    }

    
    //atualiza arquivo de produtos
    public void atualizaListaProdutos()
    {
        this.jComboBoxProdutos = new JComboBox();
        this.jComboBoxProdutos.setPreferredSize(new Dimension(200, 20));
        try {
            String dados = Arquivo.lerArquivo("arquivos/produtos.json");
            if (!dados.isEmpty()) {
                List<Produto> produtos = JSONProduto.toProdutos(dados);
                for(int i =0; i < produtos.size(); i++)
                {
                    String str = produtos.get(i).getCodigo() + " - " + produtos.get(i).getNome();
                    jComboBoxProdutos.addItem(str);
                }
            }
        } catch (FileNotFoundException ex) {
            //JOptionPane.showConfirmDialog(tela, "Não foi possível carregar os dados!");
            //aqui a lista esta vazia
        }
    }

    //desenha painel principal
    public void desenha() {
        this.painelPrincipal = new JPanel();
        this.painelPrincipal.setLayout(new BorderLayout());
        this.painelPrincipal.setPreferredSize(new Dimension(800, 600));

        desenhaPainelEstoque();
        desenhaPainelDevolucoes();

        desenhaCard();

        desenhaMenus();
        this.add(this.painelPrincipal);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false); //bloquear redimensionamento
        this.repaint();
    }

    //desenha card que habilia e desabilita paineis*
    public void desenhaCard() {
        cardLayout = new CardLayout();
        painel = new JPanel();
        painel.setLayout(cardLayout);
        //painel.setPreferredSize(new Dimension(500,500));

        painel.add(this.estoque, "1");
        painel.add(this.devolucoes, "2");
        cardLayout.show(painel, "1");

        this.painelPrincipal.add(painel, BorderLayout.CENTER);
    }

    
    //desenha menu de botoes laterais
    public void desenhaMenus() {
        botoes = new JPanel();
        botoes.setBorder(BorderFactory.createTitledBorder("Menu"));
        botoes.setLayout(new GridBagLayout());

        JButton btnEstoque = new JButton("Estoque");
        btnEstoque.addActionListener(new HabilitarEstoque(this));
        btnEstoque.setBackground(Color.red);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        botoes.add(btnEstoque, gbc);

        JButton btnDevolucao = new JButton("Devolução");
        btnDevolucao.addActionListener(new HabilitarDevolucoes(this));
        btnDevolucao.setBackground(Color.red);
        gbc.gridx = 0;
        gbc.gridy = 1;
        botoes.add(btnDevolucao, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 1.0;
        botoes.add(new JLabel(""), gbc);
        this.painelPrincipal.add(botoes, BorderLayout.WEST);
    }

    
    //desenha o painel de estoque
    public void desenhaPainelEstoque() {

        estoque.setBorder(BorderFactory.createTitledBorder("Estoque"));

        this.setLayout(new BorderLayout());
        //estoque.setPreferredSize(new Dimension(500, 500));

        this.estoque.setPreferredSize(new Dimension(500, 500));
        this.modelProduto = new TableProdutos();

        this.tableProduto = new JTable(modelProduto);
        this.tableProduto.setVisible(true);

        //this.tabelaProdutos.setPreferredScrollableViewportSize(new Dimension(800, 400));
        barraRolagem = new JScrollPane(tableProduto);

        JPanel mensagemTexto = new JPanel();
        mensagemTexto.setPreferredSize(new Dimension(500, 50));
        mensagemTexto.setLayout(new BorderLayout());
        mensagemTexto.add(txt_Inf, BorderLayout.CENTER);

        this.estoque.add(mensagemTexto, BorderLayout.NORTH);

        this.estoque.add(barraRolagem, BorderLayout.CENTER);

        JButton notificarGerente = new JButton("Notificar gerente");
        notificarGerente.addActionListener(new NotificarGerente(this));
        estoque.add(notificarGerente);

    }

    //desenha o painel de devoluções
    public void desenhaPainelDevolucoes() {

        this.devolucoes.setBorder(BorderFactory.createTitledBorder("Devoluções"));

        this.setLayout(new BorderLayout());
        //estoque.setPreferredSize(new Dimension(500, 500));



        this.quantidadeDevolucao = new JLabel("Quantidade para devolução:");
        this.jtQuantidadeDevolucao = new JTextField(10);
        this.codigo = new JLabel("Código do produto: ");

        this.defeito = new JLabel("Produto se encontra com defeito efeito? ");
        this.sim = new JRadioButton("Sim");
        this.nao = new JRadioButton("Não");
        this.rbDefeito = new ButtonGroup();
        this.rbDefeito.add(sim);
        this.rbDefeito.add(nao);

        JButton btnDevolucao = new JButton("Devolução");
        btnDevolucao.addActionListener(new RealizarDevolucao(this));
        
        this.devolucoes.add(this.quantidadeDevolucao);

        this.devolucoes.add(this.jtQuantidadeDevolucao);

        this.devolucoes.add(this.codigo);

        atualizaListaProdutos();
        this.devolucoes.add(this.jComboBoxProdutos);

        this.devolucoes.add(this.defeito);

        this.devolucoes.add(this.sim);

        this.devolucoes.add(this.nao);

        this.devolucoes.add(btnDevolucao);

        //this.painelPrincipal.add(devolucoes, BorderLayout.EAST);
        //this.getEstoque().isOptimizedDrawingEnabled();
    }

    
    //getters e setters
    public JPanel getEstoque() {
        return estoque;
    }

    public void setEstoque(JPanel estoque) {
        this.estoque = estoque;
    }

    public JPanel getCompras() {
        return compras;
    }

    public void setCompras(JPanel compras) {
        this.compras = compras;
    }

    public JPanel getDevolucoes() {
        return devolucoes;
    }

    public void setDevolucoes(JPanel devolucoes) {
        this.devolucoes = devolucoes;
    }

    public JPanel getPainelPrincipal() {
        return painelPrincipal;
    }

    public void setPainelPrincipal(JPanel painelPrincipal) {
        this.painelPrincipal = painelPrincipal;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }

    public JPanel getPainel() {
        return painel;
    }

    public void setPainel(JPanel painel) {
        this.painel = painel;
    }

    public JTextField getJtQuantidadeDevolucao() {
        return jtQuantidadeDevolucao;
    }

    public void setJtQuantidadeDevolucao(JTextField jtQuantidadeDevolucao) {
        this.jtQuantidadeDevolucao = jtQuantidadeDevolucao;
    }

    public JRadioButton getSim() {
        return sim;
    }

    public void setSim(JRadioButton sim) {
        this.sim = sim;
    }

    public JRadioButton getNao() {
        return nao;
    }

    public void setNao(JRadioButton nao) {
        this.nao = nao;
    }

    public JTable getTableProduto() {
        return tableProduto;
    }

    public void setTableProduto(JTable tableProduto) {
        this.tableProduto = tableProduto;
    }

    public int getLastIndex() {
        return lastIndex;
    }

    public void setLastIndex(int lastIndex) {
        this.lastIndex = lastIndex;
    }

    public TableProdutos getModelProduto() {
        return modelProduto;
    }

    public void setModelProduto(TableProdutos modelProduto) {
        this.modelProduto = modelProduto;
    }

    public JComboBox getjComboBoxProdutos() {
        return jComboBoxProdutos;
    }

    public void setjComboBoxProdutos(JComboBox jComboBoxProdutos) {
        this.jComboBoxProdutos = jComboBoxProdutos;
    }
}