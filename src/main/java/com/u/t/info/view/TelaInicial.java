package com.u.t.info.view;


import com.u.t.info.controller.EntrarLogin;

import java.awt.*;
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
public class TelaInicial extends JFrame {

    private JTextField jfUsuario; //digitar o usuário
    private JPasswordField jpSenha; //digitar a senha

    public TelaInicial() {
        super("Login");
    }

    /**
     * Metodo para definir caracteristicas da tela inicial
     */
    public void desenhoTelaInicial() {
        this.setVisible(true); //visibilidade
        this.setSize(800, 600); //tamanho
        this.setResizable(false); //bloquear redimensionamento
        this.setLocationRelativeTo(null); //iniciar no meio da tela
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //sair da aplicação
        desenhoTela(); //desenho da tela
    }

    /**
     * Metodo para desenhar a tela inicial
     */
    private void desenhoTela() {
        JPanel painelPrincipal = new JPanel(new GridLayout(0, 2));

        //painel para auxilir e dividir
        JPanel auxPainelPrincipal = new JPanel();
        auxPainelPrincipal.setPreferredSize(new Dimension(400, 600));

        GridBagLayout layout = new GridBagLayout();
        auxPainelPrincipal.setLayout(layout);

        GridBagConstraints gbc = new GridBagConstraints();
        //com o GridBagConstraints foi possivel colocar os componentes de forma mais simples
        //exibição do texto
        JLabel jLBemVindo = new JLabel("Seja Bem-Vindo", JLabel.CENTER);
        Font font = new Font("Humnst777 BlkCn BT", Font.BOLD, 24);
        jLBemVindo.setFont(font);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(8, 0, 0, 0);
        auxPainelPrincipal.add(jLBemVindo, gbc);

        //exibição do texto
        JLabel jLInf = new JLabel("Identifique-se para acessar o sistema.", JLabel.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        jLInf.setFont(font);

        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.anchor = GridBagConstraints.CENTER;
        gbc1.gridx = 0;
        gbc1.gridy = 1;
        gbc1.gridwidth = GridBagConstraints.REMAINDER;
        gbc1.insets = new Insets(8, 0, 0, 0);
        auxPainelPrincipal.add(jLInf, gbc1);

        //exibição do texto
        JLabel jLUsuario = new JLabel("Usuário:");
        font = new Font("Leelawadee UI", Font.PLAIN, 15);
        jLUsuario.setFont(font);
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.anchor = GridBagConstraints.WEST;
        gbc2.gridx = 0;
        gbc2.gridy = 2;
        gbc2.insets = new Insets(8, 0, 0, 0);
        auxPainelPrincipal.add(jLUsuario, gbc2);

        //permitir usuario digitar seu usuario
        jfUsuario = new JTextField(20);
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.anchor = GridBagConstraints.WEST;
        gbc3.gridx = 1;
        gbc3.gridy = 2;
        gbc3.gridwidth = GridBagConstraints.REMAINDER;
        gbc3.insets = new Insets(8, 10, 0, 0);
        auxPainelPrincipal.add(jfUsuario, gbc3);

        //exibição do texto
        JLabel jLSenha = new JLabel("Senha:");
        font = new Font("Leelawadee UI", Font.PLAIN, 15);
        jLSenha.setFont(font);
        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.anchor = GridBagConstraints.WEST;
        gbc4.gridx = 0;
        gbc4.gridy = 3;
        gbc4.insets = new Insets(8, 0, 0, 0);
        auxPainelPrincipal.add(jLSenha, gbc4);

        //permitir usuario digitar a senha
        jpSenha = new JPasswordField(20);
        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.anchor = GridBagConstraints.WEST;
        gbc5.gridx = 1;
        gbc5.gridy = 3;
        gbc5.gridwidth = GridBagConstraints.REMAINDER;
        gbc5.insets = new Insets(8, 10, 0, 0);
        auxPainelPrincipal.add(jpSenha, gbc5);

        //usuario selecionar para mostrar a senha
        JCheckBox checkbox = new JCheckBox("Mostrar senha");
        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.anchor = GridBagConstraints.WEST;
        gbc6.gridx = 1;
        gbc6.gridy = 4;
        gbc6.gridwidth = GridBagConstraints.REMAINDER;
        gbc6.insets = new Insets(8, 8, 0, 0);
        auxPainelPrincipal.add(checkbox, gbc6);

        //evento para mostrar a senha
        checkbox.addActionListener(ae -> {
            JCheckBox c = (JCheckBox) ae.getSource();
            jpSenha.setEchoChar(c.isSelected() ? '\u0000' : (Character) UIManager.get("PasswordField.echoChar"));
        });

        //botão para permitir entrada
        JButton btnEntrar = new JButton("Entrar");
        gbc.anchor = GridBagConstraints.CENTER;
        GridBagConstraints gbc7 = new GridBagConstraints();
        gbc7.anchor = GridBagConstraints.CENTER;
        gbc7.gridx = 0;
        gbc7.gridy = 5;
        gbc7.gridwidth = GridBagConstraints.REMAINDER;
        gbc7.insets = new Insets(8, 0, 0, 0);
        btnEntrar.addActionListener(new EntrarLogin(this));
        auxPainelPrincipal.add(btnEntrar, gbc7);

        //exibição do texto
        String txt = "Caso não possua cadastro no" + " <br/>" + " sistema, informe o gerente!";
        JLabel semCadastro = new JLabel("<html><div style='text-align: center;'>" + txt + "</div></html>", SwingConstants.CENTER);
        font = new Font("Leelawadee UI", Font.PLAIN, 18);
        semCadastro.setFont(font);
        GridBagConstraints gbc8 = new GridBagConstraints();
        gbc8.anchor = GridBagConstraints.CENTER;
        gbc8.gridx = 0;
        gbc8.gridy = 6;
        gbc8.gridwidth = GridBagConstraints.REMAINDER;
        gbc8.insets = new Insets(8, 0, 0, 0);
        auxPainelPrincipal.add(semCadastro, gbc8);

        //juntando os paineis
        painelPrincipal.add(auxPainelPrincipal);

        //painel direito (logo)
        JPanel painelLogo = new JPanel(new BorderLayout());
        ImageIcon image = new ImageIcon(new ImageIcon("img/UTINFO.png").getImage().getScaledInstance(280, 300, Image.SCALE_DEFAULT));
        JLabel logo = new JLabel(image);

        logo.setHorizontalTextPosition(JLabel.CENTER);
        logo.setVerticalTextPosition(JLabel.BOTTOM);
        painelLogo.add(logo);

        //juntando os paineis
        painelPrincipal.add(painelLogo);

        //adicionando no painel principal
        getContentPane().add(painelPrincipal);

    }

    public JTextField getJfUsuario() {
        return jfUsuario;
    }

    public void setJfUsuario(JTextField jfUsuario) {
        this.jfUsuario = jfUsuario;
    }

    public JPasswordField getJpSenha() {
        return jpSenha;
    }

    public void setJpSenha(JPasswordField jpSenha) {
        this.jpSenha = jpSenha;
    }

}

