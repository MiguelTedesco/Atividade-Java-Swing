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
public class Incluir {
    public String campoDoTitulo;
    public String campoDaClassificacao;
    public String campoDaDuracao ;
    public String campoDoResumo;
  
        public Incluir(String campoDoTitulo, String campoDaClassificacao, String campoDaDuracao, String campoDoResumo) {
          this.campoDoTitulo = campoDoTitulo;
          this.campoDaClassificacao = campoDaClassificacao;
          this.campoDaDuracao = campoDaDuracao;
          this.campoDoResumo = campoDoResumo;
        }
        
        public void incluirFilme(){
        
        Conexao bd = new Conexao("localhost", "3306", "root", "", "acervo");
        bd.realizaConexao();
        if(bd.isStatusConexao()){
            Filme filme = new Filme(bd.getConexao());
            try{
                filme.settituloFilme(campoDoTitulo);
                filme.setclassificacao(campoDaClassificacao);
                filme.setduracao(campoDaDuracao);
                filme.setResumo(campoDoResumo);
                filme.incluiFilme();
                System.out.println("Filme incluido recebeu o id "+ filme.getidFilme());
            }
            catch(SQLException e){
                System.out.println("Não foi possivel gravar o filme "+e.getMessage());
            }
        }
        else{
            System.out.println("Não está conectado");
            System.out.println(bd.getMensagemErro());
        }
        }
}
