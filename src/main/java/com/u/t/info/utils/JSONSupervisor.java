
package com.u.t.info.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.u.t.info.src.Supervisor;
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

public class JSONSupervisor {
    
    public static String toJSONSupervisor(Supervisor supervisor) {
        Gson gson = new Gson();
        return gson.toJson(supervisor);
    }

    public static String toJSONSupervisores(List<Supervisor> supervisores) {
        Gson gson = new Gson();
        return gson.toJson(supervisores);
    }

    public static Supervisor toSupervisor(String json) {
        Gson gson = new Gson();
        Supervisor supervisor = gson.fromJson(json, Supervisor.class);
        return supervisor;
    }

    public static List<Supervisor> toSupervisores(String json) {
        Gson gson = new Gson();
        Type supervisoresTipo = new TypeToken<ArrayList<Supervisor>>() {
        }.getType();
        List<Supervisor> supervisores = gson.fromJson(json, supervisoresTipo);
        return supervisores;
    }
    
    public static List<Supervisor> lerSupervisor(){
        
        List<Supervisor> listSupervisores = new ArrayList<>();    
        
        try{
            
            String lerArquivo = Arquivo.lerArquivo("arquivos/supervisores.json");
            listSupervisores = toSupervisores(lerArquivo);
            
        } catch (FileNotFoundException ex) {
            
            System.out.println("Erro ao abrir o arquivo dos supervisores");
        }
        
        return listSupervisores;
    }
    public static void salvarSupervisoresJSON(List<Supervisor> listSupervisor){
        
        try{
            
            String toJSON= JSONSupervisor.toJSONSupervisores(listSupervisor);
            Arquivo.escreverArquivo("arquivos/supervisores.json",toJSON);
            
        } catch (IOException ex) {
            
            System.out.println("Erro ao salvar os supervisores em arquivos/supervisores.json");
            
        }
    }
    
}
