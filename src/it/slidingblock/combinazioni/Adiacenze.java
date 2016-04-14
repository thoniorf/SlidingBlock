package it.slidingblock.combinazioni;

public class Adiacenze {
	public int colo, ri;
	public int na, ga;

	public int getColo() {
		return colo;
	}

	public void setColo(int colo) {
		this.colo = colo;
	}

	public int getRi() {
		return ri;
	}

	public Adiacenze(int colo, int ri, int na, int ga) {
		super();
		this.colo = colo;
		this.ri = ri;
		this.na = na;
		this.ga = ga;
	}

	public void setRi(int ri) {
		this.ri = ri;
	}

	public int getNa() {
		return na;
	}

	public void setNa(int na) {
		this.na = na;
	}

	public int getGa() {
		return ga;
	}

	public void setGa(int ga) {
		this.ga = ga;
	}
}
