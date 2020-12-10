package leChenadec.tp3;

public class LivrePrio extends Livre implements AvecPrio
{
	private int prio ;
	
	public LivrePrio(String des, int q, double prix, int nbp, String isbn) {
		super(des, q, prix, nbp, isbn);
		
		if(q-(STOCK_MINIMAL+STOCK_MINIMAL/2)>0) {
			this.prio=0;
		}else{
			this.prio=(STOCK_MINIMAL+STOCK_MINIMAL/2)-q;
		}
	}

	@Override
	public int getPrio()
	{	
		if(this.getQuantite()-(STOCK_MINIMAL+STOCK_MINIMAL/2)>0) {
			this.prio=0;
		}else{
			this.prio=(STOCK_MINIMAL+STOCK_MINIMAL/2)-this.getQuantite();
		}
		return prio;	
	}

	public void setPrio(int prio)
	{	this.prio = prio; 	}
	
	@Override
	public String toString()
	{	return super.toString() + " (priorité " + this.getPrio() + ")" ;  }
}