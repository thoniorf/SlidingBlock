package it.slidingblock.combinazioni;

public class Contiene {
public Contiene(int colonna, int riga, int blocco, int turno) {
		super();
		this.colonna = colonna;
		this.riga = riga;
		this.blocco = blocco;
		this.turno = turno;
	}

public int colonna,riga,blocco,turno;

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
}
