package com.u.t.info.src;

/*
Integrantes do grupo:
Nome                            Matricula
Ágata Meireles Carvalho         202065001AC
Kleiton Ewerton de Oliveira     202065050AC
Luiz Miguel Batista Silva       202065060A
Nikolas Oliver Sales Genesio    202065072AC
 */
public class Supervisor extends Funcionario{

    /**
     *
     * @param nome nome do supervisor
     * @param contato telefone do supervisor
     * @param tipo tipo do telefone do supervisor
     * @param cpf cpf do supervisor
     * @param senha senha do supervisor
     * @param rua rua do supervisor
     * @param numero numero da casa do supervisor
     * @param bairro bairro do supervisor
     * @param cidade cidade do supervisor
     * @param uf estado do supervisor
     * @param cep cep do supervisor
     * @param salario salario do supervisor
     */
	public Supervisor(String nome, String contato, String tipo, String cpf, String senha, String rua, String numero, String bairro, String cidade, String uf, String cep, double salario) {
		super( nome,  contato, tipo, cpf,senha, rua, numero, bairro, cidade, uf, cep, salario);
		// TODO Auto-generated constructor stub
	}
	
	
	

    @Override
    public double calculaPagamento() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
		

}
