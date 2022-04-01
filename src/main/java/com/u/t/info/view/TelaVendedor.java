/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u.t.info.view;

import com.u.t.info.controller.AbrirTelaCadastroCliente;
import com.u.t.info.controller.AtualizaTabelaClientes;
import com.u.t.info.controller.DesenharPainelClientes;
import com.u.t.info.controller.DesenharPainelDevolucoes;
import com.u.t.info.controller.DesenharPainelVendas;
import com.u.t.info.src.Cliente;
import com.u.t.info.src.Devolucao;
import com.u.t.info.src.Produto;
import com.u.t.info.src.Venda;
import com.u.t.info.src.Vendedor;
import com.u.t.info.tables.TableClientes;
import com.u.t.info.utils.Arquivo;
import com.u.t.info.utils.JSONCliente;
import com.u.t.info.utils.JSONDevolucao;
import com.u.t.info.utils.JSONProduto;
import com.u.t.info.utils.JSONVendas;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
 * @author luiz
 */
public class TelaVendedor extends JFrame{
 
    private Vendedor vendedor;
    
    private JPanel painelPrincipal;
    private JPanel painelClientes = new JPanel();
    private JPanel painelVendas= new JPanel();
    private JPanel painelDevolucoes= new JPanel();
    private JPanel painelBotoes;
    private JPanel painelCards;

    private JLabel jlQuantidadeProduto;
    private JLabel jlProduto;
    private JLabel jlCliente;
    private JLabel jlDevolucaoProduto;
    private JLabel jlDevolucaoQuantidade;
    private JLabel jlDevolucaoQuebrado;

    private JComboBox jcbProdutos;
    private JComboBox jcbClientes;
    private JComboBox jcbProdutosDevolucao;

    private JTextField jtQuantidadeProduto;
    private JTextField jtQtdProdutoDevolucao;

    private CardLayout cardLayout;

    private JTable jtClientes;
    private JTable jtDevolucoes;
    private JTable jtVendas;

    private TableClientes modelClientes;
    private DefaultTableModel modelVendas;
    private DefaultTableModel modelDevolucoes;

    private JButton btnClientes;
    private JButton btnVendas;
    private JButton btnDevolucoes;
    private JButton btnCadastrarCliente;
    private JButton btnRealizarVenda;
    private JButton btnRealizarDevolucao;

    private JComboBox jcbDefeito;

    private JRadioButton jrbSim;
    private JRadioButton jrbNao;

    private ButtonGroup bgDefeito;

    private List<Produto> listaProduto;
    private List<Cliente> listaCliente;

    /**
     * Construtor da classe
     * @param vendedor vendedor que fez o login na tela inicial
     */
    public TelaVendedor(Vendedor vendedor)
    {
        super("Sistema de Vendas");
        this.vendedor = vendedor;
        //this.clientes = new ArrayList<>();
       this.addWindowListener(new AtualizaTabelaClientes(this));
    }

    /**
     * Metodo para adicionar produtos e clientes no JComboBox
     */
    public void atualizaLista()
    {
        jcbProdutos = new JComboBox();
        jcbProdutosDevolucao = new JComboBox();
        jcbClientes = new JComboBox();
        try {
            //janela é aberta
            String dados = Arquivo.lerArquivo("arquivos/produtos.json");
            if (!dados.isEmpty()) {
                listaProduto = JSONProduto.lerProdutos();
                listaCliente = JSONCliente.lerCliente();
                for(int i = 0; i < listaProduto.size(); i++)
                {
                    jcbProdutos.addItem(listaProduto.get(i).getNome());
                    jcbProdutosDevolucao.addItem(listaProduto.get(i).getNome());
                }
                
                for(int i = 0; i < listaCliente.size();i++)
                {
                    jcbClientes.addItem(listaCliente.get(i).getNome());
                }
            }
        } catch (FileNotFoundException ex) {
            jcbProdutos.addItem("");
            //aqui a lista esta vazia
        }
    }

    /**
     * Metodo para desenhar a tela principal
     */
    public void desenha()
    {
        this.painelPrincipal = new JPanel();
        this.painelPrincipal.setLayout(new BorderLayout());
        this.setSize(800,600);
       
        desenhaClientes();
        desenhaVendas();
        desenhaDevolucoes();
        
        desenhaCards();
        desenhaBotoes(); 

        this.setVisible(true);
        //this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //this.setResizable(false);

        this.setLocationRelativeTo(null);
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.add(this.painelPrincipal);
        this.repaint();
    }

    /**
     * Metodo para desenhar os paineis
     */
    private void desenhaCards()
    {
        painelCards = new JPanel();
        cardLayout = new CardLayout();
        painelCards.setLayout(cardLayout);
        
        painelCards.add(this.painelClientes,"1");
        painelCards.add(this.painelVendas,"2");
        painelCards.add(this.painelDevolucoes,"3");
        cardLayout.show(painelCards, "1");
        
        this.painelPrincipal.add(painelCards, BorderLayout.CENTER);
    }


    /**
     * Metodo para desenhar botoes
     */
    private void desenhaBotoes()
    {
        this.painelBotoes = new JPanel();
        this.painelBotoes.setLayout(new GridBagLayout());
        this.painelBotoes.setPreferredSize(new Dimension(150, 300));
        
        this.btnClientes = new JButton("Clientes");
        this.btnClientes.addActionListener(new DesenharPainelClientes(this));
        this.btnClientes.setBackground(Color.red);
        this.painelBotoes.add(this.btnClientes);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        this.painelBotoes.add(this.btnClientes, gbc);
        
        this.btnVendas = new JButton("Vendas");
        this.btnVendas.addActionListener(new DesenharPainelVendas(this));
        this.painelBotoes.add(this.btnVendas);
        this.btnVendas.setBackground(Color.red);
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.painelBotoes.add(btnVendas, gbc);
        
        this.btnDevolucoes = new JButton("Devoluções");
        this.btnDevolucoes.addActionListener(new DesenharPainelDevolucoes(this));
        this.painelBotoes.add(this.btnDevolucoes);
        this.btnDevolucoes.setBackground(Color.red);
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.painelBotoes.add(btnDevolucoes, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weighty = 1.0;
        painelBotoes.add(new JLabel(""), gbc);
        
        this.painelPrincipal.add(this.painelBotoes, BorderLayout.WEST);
    }

    /**
     * Metodo para desenhar painel de clientes
     */
    public void desenhaClientes()
    {
        JScrollPane scroll;
        //this.painelClientes = new JPanel();
        this.painelClientes.setBorder(BorderFactory.createTitledBorder("Clientes"));
        this.painelClientes.setLayout(new BorderLayout());
        this.painelClientes.setPreferredSize(new Dimension(600,590));
        
        this.btnCadastrarCliente = new JButton("Cadastrar cliente");
        this.btnCadastrarCliente.setPreferredSize(new Dimension(20, 20));
        this.btnCadastrarCliente.addActionListener(new AbrirTelaCadastroCliente());
        this.painelClientes.add(this.btnCadastrarCliente, BorderLayout.SOUTH);
        
        this.modelClientes = new TableClientes();
        this.jtClientes = new JTable(modelClientes);
        scroll = new JScrollPane(jtClientes);
        scroll.setPreferredSize(new Dimension(590, 580));
        this.painelClientes.add(scroll, BorderLayout.CENTER);       
         
        this.painelPrincipal.add(this.painelClientes, BorderLayout.CENTER);
        
    }

    /**
     * Metodo para desenhar painel de vendas
     */
    public void desenhaVendas()
    {
        JScrollPane scrollVendas;
        //this.painelVendas = new JPanel();
        this.painelVendas.setBorder(BorderFactory.createTitledBorder("Vendas"));
        this.painelVendas.setLayout(new GridBagLayout());
        this.painelVendas.setPreferredSize(new Dimension(600,590));
        
        atualizaLista();
        
        GridBagConstraints gbc = new GridBagConstraints();
        this.jlProduto = new JLabel("Produto");
        
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        this.painelVendas.add(jlProduto,gbc);
        
        //this.jcbProdutos = new JComboBox();
        gbc.gridheight = 1;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 3.0;
        this.painelVendas.add(jcbProdutos,gbc);
        
        this.jlCliente = new JLabel("Cliente");
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        this.painelVendas.add(jlCliente,gbc);
        
        //this.jcbClientes = new JComboBox();
        gbc.gridheight = 1;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        this.painelVendas.add(jcbClientes,gbc);
        
        this.jlQuantidadeProduto = new JLabel("Quantidade");
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        this.painelVendas.add(jlQuantidadeProduto,gbc);
        
        this.jtQuantidadeProduto = new JTextField(5);
        gbc.gridheight = 1;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        this.painelVendas.add(jtQuantidadeProduto,gbc);
        
        this.btnRealizarVenda = new JButton("Realizar venda");
        this.btnRealizarVenda.addActionListener(new AtualizaVendas(this));
        gbc.gridheight = 1;
        gbc.gridx = 5;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        this.painelVendas.add(btnRealizarVenda,gbc);
        
       this.painelPrincipal.add(this.painelVendas, BorderLayout.CENTER);
        
    }

    /**
     * Metodo para desenhar painel de devolucoes
     */
    public void desenhaDevolucoes()
    {
        JScrollPane scrollDevolucoes;
        //this.painelVendas = new JPanel();
        this.painelDevolucoes.setBorder(BorderFactory.createTitledBorder("Devoluções"));
        this.painelDevolucoes.setLayout(new GridBagLayout());
        this.painelDevolucoes.setPreferredSize(new Dimension(600,590));
        
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        this.jlDevolucaoProduto = new JLabel("Produto");
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        this.painelDevolucoes.add(jlDevolucaoProduto,gbc);
        
        //this.jcbProdutosDevolucao = new JComboBox();
        gbc.gridheight = 1;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        this.painelDevolucoes.add(jcbProdutosDevolucao,gbc);
        
        this.jtQtdProdutoDevolucao = new JTextField(5);
        gbc.gridheight = 1;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        this.painelDevolucoes.add(jtQtdProdutoDevolucao,gbc);
        
        this.jlDevolucaoQuantidade = new JLabel("Quantidade");
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        this.painelDevolucoes.add(jlDevolucaoQuantidade,gbc);
        
        this.jlDevolucaoQuebrado = new JLabel("O produto está quebrado?");
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        this.painelDevolucoes.add(jlDevolucaoQuebrado,gbc);
        
        this.btnRealizarDevolucao = new JButton("Realizar Devolução");
        this.btnRealizarDevolucao.addActionListener(new AtualizaDevolucoes(this));
        gbc.gridheight = 1;
        gbc.gridx = 5;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        this.painelDevolucoes.add(btnRealizarDevolucao,gbc);
        
        this.jrbSim = new JRadioButton("Sim");
        this.jrbNao = new JRadioButton("Não");
        this.bgDefeito = new ButtonGroup();
        this.bgDefeito.add(jrbSim);
        this.bgDefeito.add(jrbNao);
        
        this.jcbDefeito = new JComboBox();
        this.jcbDefeito.addItem("Sim");
        this.jcbDefeito.addItem("Não");
        
        gbc.gridheight = 1;
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        this.painelDevolucoes.add(jcbDefeito,gbc);
//        this.painelDevolucoes.add(jrbSim,gbc);
//        
//        gbc.gridheight = 1;
//        gbc.gridx = 4;
//        gbc.gridy = 2;
//        gbc.weightx = 1.0;
//        this.painelDevolucoes.add(jrbNao,gbc);
       
        
        this.painelPrincipal.add(this.painelVendas, BorderLayout.CENTER);
    }

    public JPanel getPainelPrincipal() {
        return painelPrincipal;
    }

    public void setPainelPrincipal(JPanel painelPrincipal) {
        this.painelPrincipal = painelPrincipal;
    }

    public JPanel getPainelClientes() {
        return painelClientes;
    }

    public void setPainelClientes(JPanel painelClientes) {
        this.painelClientes = painelClientes;
    }

    public JPanel getPainelVendas() {
        return painelVendas;
    }

    public void setPainelVendas(JPanel painelVendas) {
        this.painelVendas = painelVendas;
    }

    public JPanel getPaineldevolucoes() {
     
        return painelDevolucoes;
    }

    public void setPaineldevolucoes(JPanel paineldevolucoes) {
        this.painelDevolucoes = paineldevolucoes;
    }

    public JPanel getPainelBotoes() {
        return painelBotoes;
    }

    public void setPainelBotoes(JPanel painelBotoes) {
        this.painelBotoes = painelBotoes;
    }

    public JPanel getPainelCards() {
        return painelCards;
    }

    public void setPainelCards(JPanel painelCards) {
        this.painelCards = painelCards;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }

    public JTable getJtClientes() {
        return jtClientes;
    }

    public void setJtClientes(JTable jtClientes) {
        this.jtClientes = jtClientes;
    }



    public JTable getJtDevolucoes() {
        return jtDevolucoes;
    }

    public void setJtDevolucoes(JTable jtDevolucoes) {
        this.jtDevolucoes = jtDevolucoes;
    }

    public List<Produto> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(List<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    List<Cliente> clientes;
    Vector<Cliente> vcCliente;

    public Vector<Cliente> getVcCliente() {
        return vcCliente;
    }

    public void setVcCliente(Vector<Cliente> vcCliente) {
        this.vcCliente = vcCliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public DefaultTableModel getModelVendas() {
        return modelVendas;
    }

    public void setModelVendas(DefaultTableModel modelVendas) {
        this.modelVendas = modelVendas;
    }

    public DefaultTableModel getModelDevolucoes() {
        return modelDevolucoes;
    }

    public void setModelDevolucoes(DefaultTableModel modelDevolucoes) {
        this.modelDevolucoes = modelDevolucoes;
    }

    public JButton getBtnClientes() {
        return btnClientes;
    }

    public void setBtnClientes(JButton btnClientes) {
        this.btnClientes = btnClientes;
    }

    public JButton getBtnVendas() {
        return btnVendas;
    }

    public void setBtnVendas(JButton btnVendas) {
        this.btnVendas = btnVendas;
    }

    public JButton getBtnDevolucoes() {
        return btnDevolucoes;
    }

    public void setBtnDevolucoes(JButton btnDevolucoes) {
        this.btnDevolucoes = btnDevolucoes;
    }

    public JButton getBtnCadastrarCliente() {
        return btnCadastrarCliente;
    }

    public void setBtnCadastrarCliente(JButton btnCadastrarCliente) {
        this.btnCadastrarCliente = btnCadastrarCliente;
    }

    public JButton getBtnRealizarVendas() {
        return btnRealizarVenda;
    }

    public void setBtnRealizarVendas(JButton btnRealizarVendas) {
        this.btnRealizarVenda = btnRealizarVendas;
    }

    public JComboBox getJcbProdutos() {
        return jcbProdutos;
    }

    public void setJcbProdutos(JComboBox jcbProdutos) {
        this.jcbProdutos = jcbProdutos;
    }

    public JComboBox getJcbClientes() {
        return jcbClientes;
    }

    public void setJcbClientes(JComboBox jcbClientes) {
        this.jcbClientes = jcbClientes;
    }

    public JComboBox getJcbProdutosDevolucao() {
        return jcbProdutosDevolucao;
    }

    public void setJcbProdutosDevolucao(JComboBox jcbProdutosDevolucao) {
        this.jcbProdutosDevolucao = jcbProdutosDevolucao;
    }

    public JTextField getJtQuantidadeProduto() {
        return jtQuantidadeProduto;
    }

    public void setJtQuantidadeProduto(JTextField jtQuantidadeProduto) {
        this.jtQuantidadeProduto = jtQuantidadeProduto;
    }

    public JTextField getJtQtdProdutoDevolucao() {
        return jtQtdProdutoDevolucao;
    }

    public void setJtQtdProdutoDevolucao(JTextField jtQtdProdutoDevolucao) {
        this.jtQtdProdutoDevolucao = jtQtdProdutoDevolucao;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public ButtonGroup getBgDefeito() {
        return bgDefeito;
    }

    public void setBgDefeito(ButtonGroup bgDefeito) {
        this.bgDefeito = bgDefeito;
    }

    public JRadioButton getJrbSim() {
        return jrbSim;
    }

    public void setJrbSim(JRadioButton jrbSim) {
        this.jrbSim = jrbSim;
    }

    public JRadioButton getJrbNao() {
        return jrbNao;
    }

    public void setJrbNao(JRadioButton jrbNao) {
        this.jrbNao = jrbNao;
    }

    public JComboBox getJcbDefeito() {
        return jcbDefeito;
    }

    public void setJcbDefeito(JComboBox jcbDefeito) {
        this.jcbDefeito = jcbDefeito;
    }
}

class AtualizaVendas implements ActionListener
{

    private TelaVendedor tela;

    /**
     * Construtor da classe
     * @param tela Tela de vendedor
     */
    public AtualizaVendas(TelaVendedor tela) {
        this.tela = tela;
    }

    /**
     * Atualizar vendas
     */
    @Override
    public void actionPerformed(ActionEvent arg0) {
        int indiceProduto = tela.getJcbProdutos().getSelectedIndex();
        int indiceCliente = tela.getJcbClientes().getSelectedIndex();
        Produto produto = tela.getListaProduto().get(indiceProduto);
        Cliente cliente = tela.getListaCliente().get(indiceCliente);
        try {
            int quantidade = Integer.parseInt(tela.getJtQuantidadeProduto().getText());
            double valor = quantidade * produto.getPrecoVenda();
            List<Venda> venda = JSONVendas.lerVendas();
            venda.add(new Venda(tela.getVendedor(),cliente, produto, valor));
            String json = JSONVendas.toJSONSVendas(venda);
            Arquivo.escreverArquivo("arquivos/vendas.json", json);
            tela.getVendedor().getVendas().add(new Venda(tela.getVendedor(),cliente, produto, valor));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(tela, "Quantidade inválida");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(tela,"Erro ao salvar vendas");
        }
        
    }
    
}

class AtualizaDevolucoes implements ActionListener
{
    private TelaVendedor tela;

    /**
     * Construtor da classe
     * @param tela
     */
    public AtualizaDevolucoes(TelaVendedor tela) {
        this.tela = tela;
    }

    /**
     * Atualizar devolucoes
     */
    @Override
    public void actionPerformed(ActionEvent arg0) {
        int indiceProduto = tela.getJcbProdutosDevolucao().getSelectedIndex();
        Produto produto = tela.getListaProduto().get(indiceProduto);
        int defeito = tela.getJcbDefeito().getSelectedIndex();
        try {
            int quantidade = Integer.parseInt(tela.getJtQtdProdutoDevolucao().getText());
            List<Devolucao> devolucao = JSONDevolucao.lerDevolucao();
            if(defeito == 0)
            {
                devolucao.add(new Devolucao(tela.getVendedor().getNome(), produto, quantidade, "Sim"));
            }
            else
            {
                devolucao.add(new Devolucao(tela.getVendedor().getNome(), produto, quantidade,"Não"));
            }     
            String json = JSONDevolucao.toJSONDevolucoes(devolucao);
            Arquivo.escreverArquivo("arquivos/devolucoes.json", json);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(tela, "Quantidade inválida");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(tela,"Erro ao salvar devolução");
        }
        
    }
}

