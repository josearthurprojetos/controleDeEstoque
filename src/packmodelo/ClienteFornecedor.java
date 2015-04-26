package packmodelo;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;


/***********************************************************************
 * Module:  ClienteFornecedor.java
 * Author:  josé
 * Purpose: Defines the Class ClienteFornecedor
 ***********************************************************************/


/** @pdOid d7fea0e6-6ba2-43e8-820f-96f2be4f1f89 */
public class ClienteFornecedor extends Pessoa {
   /** @pdOid a3c86e5a-a866-4257-853d-4911955d775a */
   private java.util.Date dataCadastro;
   /** @pdOid c933bb08-678f-489c-9328-167166d1ccaa */
   private java.lang.String nomeEmpresa;
   /** @pdOid 47a470e8-5f85-4cf1-b68f-85235bd36cff */
   private java.lang.Float valorVendido;
      
   public ClienteFornecedor(){}
   
   public ClienteFornecedor(String nome, int codigo, String CPF, String RG, String telFixo, String telCelular,
		   String Foto, Date dataCadastro, String nomeEmpresa, Float valorVendido){
	   
	   super(nome, codigo, CPF, RG,telFixo,telCelular, Foto);
	   
	   this.setDataCadastro(dataCadastro);
	   this.setNomeEmpresa(nomeEmpresa);
	   this.setValorVendido(valorVendido);
   }
   
   
   /** @param newDataCadastro
    * @pdOid 5782371b-bda8-4397-8558-324ef1272b20 */
   public void setDataCadastro(java.util.Date newDataCadastro) {
      dataCadastro = newDataCadastro;
   }
   
   /** @param newNomeEmpresa
    * @pdOid 604744ee-64c3-4f44-a089-f08d66646d7f */
   public void setNomeEmpresa(java.lang.String newNomeEmpresa) {
      nomeEmpresa = newNomeEmpresa;
   }
   
   /** @param newValorVendido
    * @pdOid 61616282-0257-41f1-b2ea-6a90ce8ad4b5 */
   public void setValorVendido(java.lang.Float newValorVendido) {
      valorVendido = newValorVendido;
   }
   
   /** @pdOid 3335c5d4-5b2d-4646-87a9-c181d5f04ec1 */
   public String getDataCadastro() {
	   Format formata = new SimpleDateFormat("dd/MM/YYYY");
	   return (formata.format(dataCadastro));	   	   
   }
   
   /** @pdOid 3a2cfb3a-a794-485a-9693-c1b732263494 */
   public java.lang.String getNomeEmpresa() {
      return nomeEmpresa;
   }
   
   /** @pdOid fbf6a7a0-146a-4914-bb98-ccc63df2476f */
   public java.lang.Float getValorVendido() {
      return valorVendido;
   }

}