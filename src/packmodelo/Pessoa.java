package packmodelo;

/***********************************************************************
 * Module:  Pessoa.java
 * Author:  josé
 * Purpose: Defines the Class Pessoa
 ***********************************************************************/


/** @pdOid 905bedc4-2a81-485d-8100-78f6160f430c */
public class Pessoa {
   /** @pdOid d85b79f8-1513-405e-bd55-c99b4bae275b */
   private java.lang.String nome;
   /** @pdOid 2e2339e2-d077-498e-90a7-2bef6e4235e3 */
   private int codigo;
   /** @pdOid dc7a7572-da32-408d-b3ea-9f9ddb3e39dd */
   private java.lang.String cpf;
   /** @pdOid 3063865a-f149-42d1-8d89-c311017da65f */
   private java.lang.String rg;
   /** @pdOid 52d17459-9c10-434a-94e4-356967c99873 */
   private java.lang.String telFixo;
   /** @pdOid 72e3ae05-faac-4ec9-bb5c-4a7f0aebb64b */
   private java.lang.String telCelular;
   private java.lang.String foto;
   
   
   Pessoa(){};
   
   Pessoa(String nome, int codigo, String CPF, String RG, String telFixo, String telCelular, String Foto){
	   this.setNome(nome);
	   this.setCodigo(codigo);
	   this.setCpf(CPF);
	   this.setRg(RG);
	   this.setTelFixo(telFixo);
	   this.setTelCelular(telCelular);	 
	   this.setFoto(Foto);
   };
   
   /** @param newNome
    * @pdOid 3a5c3ef9-3dd9-4c0c-8ea7-2960219911c3 */
   public void setNome(java.lang.String newNome) {
      nome = newNome;
   }
   
   /** @param newCodigo
    * @pdOid 0fb28416-d6df-48bf-8c9b-26835ab2f9e5 */
   public void setCodigo(int newCodigo) {
      codigo = newCodigo;
   }
   
   /** @param newCpf
    * @pdOid 6ff521f1-f97f-473d-89e8-ce234c1cad03 */
   public void setCpf(java.lang.String newCpf) {
      cpf = newCpf;
   }
   
   /** @param newRg
    * @pdOid ebb1d760-2ae7-4d93-8e9c-d9990610abf7 */
   public void setRg(java.lang.String newRg) {
      rg = newRg;
   }
   
   /** @param newTelFixo
    * @pdOid 4cc1a8f7-cf74-4ea2-a396-e45771c2da8b */
   public void setTelFixo(java.lang.String newTelFixo) {
      telFixo = newTelFixo;
   }
   
   /** @param newTelCelular
    * @pdOid 28eea9ff-bd7b-4e67-bb77-cb7aaf111475 */
   public void setTelCelular(java.lang.String newTelCelular) {
      telCelular = newTelCelular;
   }
   
   /** @pdOid e4adfb5d-aaeb-449c-94f7-0260eb1020c7 */
   public java.lang.String getNome() {
      return nome;
   }
   
   /** @pdOid 23869fd1-d3b8-4076-8a4d-b1b85cd569c8 */
   public int getCodigo() {
      return codigo;
   }
   
   /** @pdOid c1ff76f8-c46a-4b37-8533-30ec8f0fb4ad */
   public java.lang.String getCpf() {
      return cpf;
   }
   
   /** @pdOid d4ccae3f-c1fc-437c-8d28-d1da2e7cddde */
   public java.lang.String getRg() {
      return rg;
   }
   
   /** @pdOid 8f4d9cb8-98b5-4cdb-9c89-fa9b4fde5121 */
   public java.lang.String getTelFixo() {
      return telFixo;
   }
   
   /** @pdOid 9398adc8-af53-4dc6-afb5-c02e83d21e2e */
   public java.lang.String getTelCelular() {
      return telCelular;
   }

   public java.lang.String getFoto() {
	return foto;
   }

   public void setFoto(java.lang.String foto) {
	this.foto = foto;
   }

}