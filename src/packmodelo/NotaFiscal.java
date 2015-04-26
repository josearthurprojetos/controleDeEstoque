package packmodelo;

/***********************************************************************
 * Module:  NotaFiscal.java
 * Author:  josé
 * Purpose: Defines the Class NotaFiscal
 ***********************************************************************/


/** @pdOid 7c1b8e59-d0a8-4154-8a28-9ea356dac449 */
public class NotaFiscal {
   /** @pdOid e8f82364-2e2b-4789-a5f5-401b8810caa4 */
   private int codigoNota;
   /** @pdOid 0545f5a3-f744-419a-9b4c-daca77eec53b */
   private Produto produtosNota;
   /** @pdOid 04876a09-a424-4abd-a60f-cd7112b26c57 */
   private Funcionario funcNota;
   /** @pdOid 2292dcf8-ef5c-4d12-8600-0978344a2b89 */
   private ClienteFornecedor clienteNota;
   /** @pdOid 6a443090-8da8-4bbe-88eb-19d60a98b74a */
   private java.util.Date dataNota;
   /** @pdOid 5d2d5c60-ff73-4e4f-a375-bca38e9c20bb */
   private java.lang.Float valorTotal;
   /** @pdOid ba5370d8-f9ae-4063-ae0a-137db0431726 */
   private java.lang.Float desconto;
   
   /** @param newCodigoNota
    * @pdOid 53165743-f067-4101-9ebd-ebe380b27abe */
   private void setCodigoNota(int newCodigoNota) {
      codigoNota = newCodigoNota;
   }
   
   /** @param newProdutosNota
    * @pdOid c7120d92-13f5-4a87-a97e-5ba578206486 */
   private void setProdutosNota(Produto newProdutosNota) {
      produtosNota = newProdutosNota;
   }
   
   /** @param newFuncNota
    * @pdOid c43b2170-e0d8-48dd-b439-5ca0a00404d1 */
   private void setFuncNota(Funcionario newFuncNota) {
      funcNota = newFuncNota;
   }
   
   /** @param newClienteNota
    * @pdOid 92fbb04d-795e-47c1-b212-f169592b78df */
   private void setClienteNota(ClienteFornecedor newClienteNota) {
      clienteNota = newClienteNota;
   }
   
   /** @param newDataNota
    * @pdOid d4178d05-a10e-4daa-a767-b274aff54bcf */
   private void setDataNota(java.util.Date newDataNota) {
      dataNota = newDataNota;
   }
   
   /** @param newValorTotal
    * @pdOid b6d2ae25-a4ab-45ef-9625-f90b1f4885f0 */
   private void setValorTotal(java.lang.Float newValorTotal) {
      valorTotal = newValorTotal;
   }
   
   /** @param newDesconto
    * @pdOid 9595cff8-9c40-4955-8ca7-4d191e46c15f */
   private void setDesconto(java.lang.Float newDesconto) {
      desconto = newDesconto;
   }
   
   /** @pdOid ea3cc54e-bcf8-44c3-ad9e-d8ff066825f4 */
   public int getCodigoNota() {
      return codigoNota;
   }
   
   /** @pdOid fd5dcded-5ebe-4a0d-a4ff-2f4c1a89d568 */
   public Produto getProdutosNota() {
      return produtosNota;
   }
   
   /** @pdOid 87b8a743-0f0f-4dc5-be9a-c78deaa354ab */
   public Funcionario getFuncNota() {
      return funcNota;
   }
   
   /** @pdOid 8c528fc6-3255-409e-959c-f2dc24389ea9 */
   public ClienteFornecedor getClienteNota() {
      return clienteNota;
   }
   
   /** @pdOid ed81d5e0-ea18-462d-a1a3-be93c0a2461c */
   public java.util.Date getDataNota() {
      return dataNota;
   }
   
   /** @pdOid 4fce0b1c-df24-4ea2-88c9-3065bc3c60c1 */
   public java.lang.Float getValorTotal() {
      return valorTotal;
   }
   
   /** @pdOid 32e85b8a-eec3-47d5-920f-d90f436a974f */
   public java.lang.Float getDesconto() {
      return desconto;
   }

}