/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho;

import java.sql.SQLException;

/**
 *
 * @author Miguel e Luis
 */
public class Excluir {
    
    public int campoDoId;
  
        public Excluir(int campoDoId) {
          this.campoDoId = campoDoId;
        }
        
        public void excluirFilme(){
       
        if(campoDoId > 0){
            Conexao bd = new Conexao("localhost", "3306", "root", "", "acervo");
            bd.realizaConexao();
            if(bd.isStatusConexao()){
                Filme filme = new Filme(bd.getConexao());
                try{
                    filme.setidFilme(campoDoId);
                    filme.deletaFilme();
                    System.out.println("Filme excluido!");

                }
                catch(SQLException e){
                    System.out.println("Não foi possivel excluir "+e.getMessage());
                }
            }
            else{
                System.out.println("Não está conectado");
                System.out.println(bd.getMensagemErro());
            }
        }
        else{
            System.out.println("Necessário um id");
        }
    }
}
