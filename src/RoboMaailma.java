import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class RoboMaailma {
	private Map<Point, RoboRuutu> ruudut = new HashMap<Point, RoboRuutu>();
	private Point sijainti = new Point( 0, 0 );
	private int tulosuunta;
	
	public RoboRuutu ruutu() {
		return this.ruudut.get( sijainti );
	}
	
	public int annaSuuntaEdelliseen() {
		if( this.ruutu() != null ) {
			return this.ruutu().annaTulosuunta();
		} else {
			throw new EnsimmainenSiirtoPoikkeus();
		}
		
	}

	private static Point annaNaapurinSijainti( Point keskipiste, int suunta ) {
		keskipiste = (Point) keskipiste.clone();
		switch( suunta ) {
			case Robotti.POHJOINEN:
				keskipiste.translate( 0, 1 );
				break;
			case Robotti.ITA:
				keskipiste.translate( 1, 0 );
				break;
			case Robotti.ETELA:
				keskipiste.translate( 0, -1 );
				break;
			case Robotti.LANSI:
				keskipiste.translate( -1, 0 );
				break;
			default:
				throw new KelvotonSuuntaPoikkeus();
		}
		return keskipiste;
	}

	public void talletaSeinat( boolean[] seinat ) {
		if( this.ruutu() == null ) {
			
		}
	}
	
	public void siirry( int suunta ) {
		this.sijainti = RoboMaailma.annaNaapurinSijainti( this.sijainti, suunta );
		this.tulosuunta = Math.abs( (suunta+2)%4 );
		
		if( this.ruutu() == null ) {
			this.ruudut.put( sijainti, new RoboRuutu( tulosuunta, 
			                                          sijainti ) );
		}
		this.ruutu().kasvataLaskuria();
	}
	
	public int palaa() {
		System.out.println( "Palataan" );
		return this.ruutu().annaTulosuunta();
	}

	public RoboRuutu annaNaapuri( int suunta ) {
		return this.ruudut.get( 
			        RoboMaailma.annaNaapurinSijainti( this.sijainti, suunta ) );
	}

	public int annaSuuntaKayttamattomaanNaapuriin( boolean[] seinat ) {
		int valinta = -1;
		for( int i = 0; i < 4; i++ ) {
			RoboRuutu naapuri = this.annaNaapuri(i);
			if( ( naapuri == null || naapuri.laskuri() == 0 ) && !seinat[i] ) {
				System.out.println( "Valitaan suunta " + i + " " + naapuri );
				valinta = i;
			} else if( naapuri != null ) {
				System.out.println( "Suunnassa " + i + " on jo käyty" );
			} else if( seinat[i] ) {
				System.out.println( "Suunnassa " + i + " seinä" );
			}
		}
		return valinta;
	}
}
