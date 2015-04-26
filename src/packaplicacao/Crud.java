package packaplicacao;

/***********************************************************************
 * Module:  Crud.java
 * Author:  josé
 * Purpose: Defines the Class Crud
 ***********************************************************************/

import java.sql.ResultSet;
import java.util.*;

import packconexao.Conexao;


/** @pdOid a2829e15-0dd7-4f54-8903-3af359baedd7 */
public abstract class Crud<T> extends Conexao {
	protected String query;
	protected Conexao con;
	
	public Crud(){
		con = new Conexao();
	}
	
	/** @pdOid 29c4adae-3cd2-4c16-8a50-c58162151bc7 */
   abstract public void cadastrar(T obj);
   
   /** @pdOid 5b49c53f-e015-4780-b394-8a7b5a9d5831 */
   abstract public void alterar(T obj);
   
   /** @pdOid 7a6c3651-691e-4c83-9611-11b3bedf1b16 */
   abstract public void excluir(T obj);
   
   /** @pdOid 48ba9179-d1d8-4e4b-80f2-691f03071dfe */
   abstract public T consultaId(int id);
   
   /** @pdOid 6413aa5d-9172-439e-85c9-a2b9c9ee6652 */
   abstract public Collection<T> consultaNome(String nome);
   
   abstract public Collection<T> listaTodos();
   
   abstract public Collection<T> resultEmObjeto(ResultSet result);

}