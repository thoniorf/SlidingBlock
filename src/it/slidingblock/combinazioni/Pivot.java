package it.slidingblock.combinazioni;

public class Pivot {
	public Pivot(int blocco, int turno, int colonna, int riga) {
		super();
		this.blocco = blocco;
		this.turno = turno;
		this.colonna = colonna;
		this.riga = riga;
	}

	public int blocco,turno,colonna,riga;

	public int getBlocco() {
		return blocco;
	}

	public void setBlocco(int blocco) {
		this.blocco = blocco;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public int getColonna() {
		return colonna;
	}

	public void setColonna(int colonna) {
		this.colonna = colonna;
	}

	public int getRiga() {
		return riga;
	}

	public void setRiga(int riga) {
		this.riga = riga;
	}

}
