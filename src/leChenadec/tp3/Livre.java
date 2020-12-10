package leChenadec.tp3;

//package salle.attente.applis;
public class Livre extends ArticlePrio implements SpecifLivre
{
   private int nbPages ;
   private String numISBN ;
   
   public int getNombrePages() { return nbPages ; }
   public String getNumeroISBN() { return numISBN ; }
   
   public Livre (String des, int q, double prix, int nbp, String isbn)
   {
   	   super (des, q, prix) ;
   	   nbPages = nbp ;
   	   numISBN = isbn ;
   }
   
   public String toString()
   {
   	  return
	  	getDesignation()
		+ ", ISBN : " + getNumeroISBN()
	    + " (" + getNombrePages() + " pages)";
   }
   
}
