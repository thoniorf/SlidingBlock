package it.slidingblock.combinazioni;

public class SpostamentiC implements Comparable<SpostamentiC> {
	public int blocco = 0, turno = 0;
	public String direzione = "";

	public SpostamentiC() {
		this.blocco = 0;
		this.turno = 0;
		this.direzione = "";
	}

	public SpostamentiC(int blocco, int turno, String direzione) {
		super();
		this.blocco = blocco;
		this.turno = turno;
		this.direzione = direzione;
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

	public String getDirezione() {
		return direzione;
	}

	public void setDirezione(String direzione) {
		this.direzione = direzione;
	}

	@Override
	public String toString() {
		return "SpostamentiC [blocco=" + blocco + ", turno=" + turno
				+ ", direzione=" + direzione + "]";
	}

	@Override
	public int compareTo(SpostamentiC o) {
		if (this.turno > o.turno) {
			return 1;
		} else if (this.turno < o.turno) {
			return -1;
		} else {
			return 0;
		}
	}

}
