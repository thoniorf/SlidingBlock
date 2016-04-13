package it.slidingblock.dlv;
public class Spostamenti implements Comparable<Spostamenti>
{
	public int blocco;
	public int partenzariga;
	public int partenzacolonna;
	public int arrivoriga;
	public int arrivocolonna;
	public int turno;
	public int getBlocco()
	{
		return blocco;
	}
	public void setBlocco(int blocco)
	{
		this.blocco = blocco;
	}
	public int getPartenzariga()
	{
		return partenzariga;
	}
	public void setPartenzariga(int partenzariga)
	{
		this.partenzariga = partenzariga;
	}
	public int getPartenzacolonna()
	{
		return partenzacolonna;
	}
	public void setPartenzacolonna(int partenzacolonna)
	{
		this.partenzacolonna = partenzacolonna;
	}
	public int getArrivoriga()
	{
		return arrivoriga;
	}
	public void setArrivoriga(int arrivoriga)
	{
		this.arrivoriga = arrivoriga;
	}
	public int getArrivocolonna()
	{
		return arrivocolonna;
	}
	public void setArrivocolonna(int arrivocolonna)
	{
		this.arrivocolonna = arrivocolonna;
	}
	public int getTurno()
	{
		return turno;
	}
	public void setTurno(int turno)
	{
		this.turno = turno;
	}
	@Override
	public String toString()
	{
		return "(" + blocco + "," + partenzariga + "," + partenzacolonna + ","
				+ arrivoriga + "," + arrivocolonna + "," + turno + ")";
	}
	public int compareTo(Spostamenti o)
	{
		if (this.turno < o.turno)
			return -1;
		else if (this.turno > o.turno)
			return 1;
		else
			return 0;
	}
}
