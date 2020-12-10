package leChenadec.tp3;

//package salle.attente;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class SalleDAttentePAPS<E> extends ArrayList<E> implements SalleDAttente<E>
{
	private int capacite ;

	public SalleDAttentePAPS(int capacite)
	{
		super() ;
		this.capacite = capacite ;
	}

	@Override
	// Nombre maximum de clients
	public int getCapacite()
	{
		return capacite ;
	}

	@Override
	// Nombre de clients présents dans la salle
	public int getNbClients()
	{
		return this.size() ;
	}

	@Override
	// Salle vide ?
	public boolean estVide()
	{
		return this.isEmpty() ;
	}

	@Override
	// Salle pleine ?
	public boolean estPleine()
	{
		return getNbClients() == getCapacite() ;
	}

	@Override
	// Prochain client à servir
    public E getProchain()			
    {
    	assert !estVide() ;
    	return this.get(0) ;
    }

	@Override
	// Faire sortir le client "getProchain()"
    public void sortir()				
	{
    	assert !estVide() ;
    	this.remove(0);
	}

	@Override
	// Entrée de "client"
    public void entrer(E client)
    {
    	assert !estPleine() ;
     	this.add(client) ;
    }


}