import java.awt.Point;

public class RoboRuutu {
	
	private Point sijainti;
	private final int tulosuunta;
	private int	laskuri = 0;;
	
	public RoboRuutu( int tulosuunta, 
	                  Point sijainti ) {
		this.sijainti = sijainti;
		this.tulosuunta = tulosuunta;
	}
	

	public int annaTulosuunta() {
		return this.tulosuunta;
	}

	public int laskuri() {
		return this.laskuri ;
	}
	
	public void kasvataLaskuria() {
		this.laskuri++;
	}
	
	public Point annaSijainti() {
		return this.sijainti;
	}
}
