/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Miguel e Luis
 */
public class Listar {
    public String lblCampo;
    public String valor;
    public void listarFilme(){
        Conexao bd = new Conexao("localhost", "3306", "root", "", "acervo");
        bd.realizaConexao();
        if(bd.isStatusConexao()){
            Filme filme = new Filme(bd.getConexao());
            try{
                ResultSet listaFilmes = filme.obterListaFilmes();
                lblCampo = ("");
                while(listaFilmes.next()){
                    lblCampo = lblCampo +(("idFilme: "+listaFilmes.getInt("idFilme")) + ("\nTitulo: "+listaFilmes.getString("titulo")) +
                            ("\nClassificacao: "+listaFilmes.getInt("classificacao")) + ("\nDuracao: "+listaFilmes.getFloat("duracao")) +
                            ("\nResumo: "+listaFilmes.getString("resumo"))+ " \n" + " \n");
                }
                valor = lblCampo;
                filme.setValorCampo(valor);
            }
            catch(SQLException e){
                System.out.println("Não foi possivel obter a lista "+e.getMessage());
            }
        }
        else{
            System.out.println("Não está conectado");
            System.out.println(bd.getMensagemErro());
        }
    }
}
