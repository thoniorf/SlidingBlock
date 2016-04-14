package it.slidingblock.combinazioni;

public class Dimensione {
	public Dimensione(int blocco, int dimensione) {
		super();
		this.blocco = blocco;
		this.dimensione = dimensione;
	}

	public int blocco;
	public int dimensione;

	public int getBlocco() {
		return blocco;
	}

	public void setBlocco(int blocco) {
		this.blocco = blocco;
	}

	public int getDimensione() {
		return dimensione;
	}

	public void setDimensione(int dimensione) {
		this.dimensione = dimensione;
	}

}
