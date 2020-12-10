package leChenadec.tp3;


public class ArticlePrio extends Article implements AvecPrio
{
	private int prio ;
	
	public ArticlePrio(String des, int q, double prix)
	{
		super(des,q,prix);
		
		if(q-STOCK_MINIMAL>0) {
			this.prio=0;
		}else{
			this.prio=STOCK_MINIMAL-q;
		}
	}
	

	public ArticlePrio(String des, double prix) {
		super(des, prix);
	}


	@Override
	public int getPrio()
	{	
		if(this.getQuantite()-STOCK_MINIMAL>0) {
			this.prio=0;
		}else{
			this.prio=STOCK_MINIMAL-this.getQuantite();
		}
		return prio;	
	}

	public void setPrio(int prio)
	{	this.prio = prio; 	}
	
	@Override
	public String toString()
	{	return super.toString() + " (priorité " + this.getPrio() + ")" ;  }
}