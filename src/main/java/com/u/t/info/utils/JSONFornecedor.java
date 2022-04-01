package com.u.t.info.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.u.t.info.controller.LimparFormularioFornecedor;
import com.u.t.info.src.Fornecedor;
import com.u.t.info.view.TelaCadastroFornecedor;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/*
Integrantes do grupo:
Nome                            Matricula
Ágata Meireles Carvalho         202065001AC
Kleiton Ewerton de Oliveira     202065050AC
Luiz Miguel Batista Silva       202065060A
Nikolas Oliver Sales Genesio    202065072AC
 */

public class JSONFornecedor {
    
    public static String toJSONFornecedor(Fornecedor fornecedor) {
        Gson gson = new Gson();
        return gson.toJson(fornecedor);
    }

    public static String toJSONFornecedores(List<Fornecedor> fornecedores) {
        Gson gson = new Gson();
        return gson.toJson(fornecedores);
    }

    public static Fornecedor toFornecedor(String json) {
        Gson gson = new Gson();
        Fornecedor fornecedor = gson.fromJson(json, Fornecedor.class);
        return fornecedor;
    }

    public static List<Fornecedor> toFornecedores(String json) {
        Gson gson = new Gson();
        Type fornecedoresTipo = new TypeToken<ArrayList<Fornecedor>>() {
        }.getType();
        List<Fornecedor> fornecedores = gson.fromJson(json, fornecedoresTipo);
        return fornecedores;
    }
    
    public static List<Fornecedor> lerFornecedores(){
        
        List<Fornecedor> listFornecedores = new ArrayList<>();    
        
        try{
            
            String lerArquivo = Arquivo.lerArquivo("arquivos/fornecedores.json");
            listFornecedores = toFornecedores(lerArquivo);
            
        } catch (FileNotFoundException ex) {
            
            System.out.println("Erro ao abrir o arquivo dos fornecedores");
        }
        
        return listFornecedores;
    }
    public static void salvarFornecedoresJSON(List<Fornecedor> listFornecedor, TelaCadastroFornecedor tela){
        
        try{
            
            String toJSONFornecedor = JSONFornecedor.toJSONFornecedores(listFornecedor);
            Arquivo.escreverArquivo("arquivos/fornecedores.json",toJSONFornecedor);
            JOptionPane.showMessageDialog(null, "Fornecedor adicionado");
            LimparFormularioFornecedor limparFormularioFornecedor = new LimparFormularioFornecedor(tela);
            limparFormularioFornecedor.LimparFormulario();
        } catch (IOException ex) {
            
            System.out.println("Erro ao salvar os fornecedores em arquivos/fornecedores.json");
            
        }
    }
    
    
}
