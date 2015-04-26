package packmodelo;

/***********************************************************************
 * Module:  Produto.java
 * Author:  josé
 * Purpose: Defines the Class Produto
 ***********************************************************************/

import java.util.*;

/** @pdOid c371a28f-1fbb-48fe-b772-419658bc7f2a */
public class Produto {
   /** @pdOid 78eebfd2-74fd-426c-a05c-36ad94467705 */
   private int codigo;
   /** @pdOid 59c48eba-de50-4a86-8fd8-730ae96e50f3 */
   private java.lang.Float precoVenda;
   /** @pdOid dd580045-0370-46bd-9d40-4a7907e6c62f */
   private java.lang.Float precoCompra;
   /** @pdOid a0d7d8c6-507d-4720-b014-0dd1a63c6e0c */
   private java.lang.String nomeProduto;
   /** @pdOid 3bf73a79-faa5-46c1-965f-cb426d186b6b */
   private java.lang.String marcaProduto;
   private int quantProduto;
   
   public Produto(){}
   
   public Produto(int codigo, float precoVenda, float precoCompra, String nomeProduto, String marcaProduto, int quantProduto){
	   this.setCodigo(codigo);
	   this.setPrecoVenda(precoVenda);
	   this.setPrecoCompra(precoCompra);
	   this.setNomeProduto(nomeProduto);
	   this.setMarcaProduto(marcaProduto);
	   this.setQuantProduto(quantProduto);
   }
   
   public int getQuantProduto() {
	   return quantProduto;
   }

   public void setQuantProduto(int quantProduto) {
	   this.quantProduto = quantProduto;
   }

/** @param newCodigo
    * @pdOid 6203972c-3de9-4fb8-84c2-d3d0afcfc536 */
   public void setCodigo(int newCodigo) {
      codigo = newCodigo;
   }
   
   /** @param newPrecoVenda
    * @pdOid f692c2ae-40df-4af9-8d6f-08f716d08215 */
   public void setPrecoVenda(java.lang.Float newPrecoVenda) {
      precoVenda = newPrecoVenda;
   }
   
   /** @param newPrecoCompra
    * @pdOid 79367166-ec2e-4bb2-b8ed-6e5e78e80d5e */
   public void setPrecoCompra(java.lang.Float newPrecoCompra) {
      precoCompra = newPrecoCompra;
   }
   
   /** @param newNomeProduto
    * @pdOid 7cb34483-e76f-4763-8298-ccce15f23444 */
   public void setNomeProduto(java.lang.String newNomeProduto) {
      nomeProduto = newNomeProduto;
   }
   
   /** @param newMarcaProduto
    * @pdOid 2ff0ff8a-cbe4-4b8e-8ba2-03b3115584a2 */
   public void setMarcaProduto(java.lang.String newMarcaProduto) {
      marcaProduto = newMarcaProduto;
   }
   
   /** @pdOid 8b7bee3f-28c2-483b-935a-927cbb8ed2ed */
   public int getCodigo() {
      return codigo;
   }
   
   /** @pdOid fef77688-b77c-4664-8768-d195313714b9 */
   public java.lang.Float getPrecoVenda() {
      return precoVenda;
   }
   
   /** @pdOid 6ebb1907-180a-4c98-a79d-4cc764f98464 */
   public java.lang.Float getPrecoCompra() {
      return precoCompra;
   }
   
   /** @pdOid 9d8a9772-ab44-4715-b9b5-02146127d041 */
   public java.lang.String getNomeProduto() {
      return nomeProduto;
   }
   
   /** @pdOid 4392d207-3534-4685-8124-58fc03298196 */
   public java.lang.String getMarcaProduto() {
      return marcaProduto;
   }

}