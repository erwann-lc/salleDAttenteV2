package leChenadec.tp3;

import java.util.HashMap;
import java.util.Map;

public class SalleDAttentePrio<TC extends AvecPrio> implements SalleDAttente<TC> {

	// variable d'instance
	private Integer capacite, maxPrio;
	private Map<Integer, SalleDAttentePAPS<TC>> salle ;

	
	/** Constructeur
	 * 
	 * @param capacite : taille maximale de la salle
	 * @param maxPrio : Niveau maximum de priorité (attention, ne correspond pas au nombre de priorités car nombre de priorités = prioMax + 1
	 */
	public SalleDAttentePrio(int capacite,int maxPrio){
		this.capacite = capacite;
		
		// level maximum
		this.maxPrio=maxPrio;
		this.salle= new HashMap<Integer,SalleDAttentePAPS<TC>>();
		
		for (int i=0;i<=maxPrio;i++) {
			salle.put(i, new SalleDAttentePAPS<TC>(capacite));
		}
	}

	@Override
	public int getCapacite() {
		return this.capacite;
	}

	@Override
	public int getNbClients() {
		int nb=0;
		for (SalleDAttentePAPS<TC> sallePrio: salle.values()) {
			nb=nb+sallePrio.getNbClients();
		}
		return nb;
	}

	@Override
	public boolean estVide() {
		return (this.getNbClients()==0);
	}

	@Override
	public boolean estPleine() {
		return (this.getNbClients()>=this.getCapacite());
	}

	@Override
	public void entrer(TC client) {
		int prio=client.getPrio();
		if(!(this.estPleine())) {
			if (prio>maxPrio) {salle.get(maxPrio).entrer(client);}
			else if(prio<0) {salle.get(0).entrer(client);}
			else {salle.get(prio).entrer(client);}	
		}
	}

	@Override
	public TC getProchain() {
		TC res=null;
		if(!(this.estPleine())) {
			for(int i=maxPrio; i>=0; i--) {
				if(salle.get(i).getNbClients()!=0) {
					res=salle.get(i).getProchain();
					i=-1;
				}
			}
		}
		return res;
	}

	@Override
	public void sortir() {
		if(!(this.estVide())) {
			salle.get(this.getProchain().getPrio()).sortir();
		}		
	}
	
	public void reorganiser() {
		for (Map.Entry<Integer,SalleDAttentePAPS<TC>> priot: salle.entrySet()) {			
			for (TC salleAtt:priot.getValue()) {
				int prioact=salleAtt.getPrio();
				if(prioact!=priot.getKey()) {
					entrer(salleAtt);					
					salle.get(priot.getKey()).remove(salleAtt);
				}					
			}
			
			/*
			for (int i=0; i<=priot.getValue().getNbClients() ;i++) {
				int prioact=priot.getValue().get(i).getPrio();
				if(prioact!=priot.getKey()) {
					entrer(priot.getValue().get(i));					
					priot.getValue().remove(i);	
				}	
			}
			*/	
		}
	}
}
