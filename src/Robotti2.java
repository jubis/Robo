
public class Robotti2 extends Robotti {
	private RoboMaailma maailma;
	
	public Robotti2() {
		this.maailma = new RoboMaailma();
	}
	
	private boolean[] annaSeinat() {
		boolean[] seinat = new boolean[4];
		int alkuSuunta = this.annaSuunta();
		do {
			seinat[ this.annaSuunta() ] = ! this.voiEdeta();
			this.kaannyOikealle();
		} while( this.annaSuunta() != alkuSuunta );
		return seinat;
	}
	
	@Override
	public void teeSiirto() {
		
		boolean[] seinat = this.annaSeinat();
		int suunta = this.maailma.annaSuuntaKayttamattomaanNaapuriin(seinat);
		if( suunta == -1 ) {
			System.out.println( "Ei löydy käymätöntä naapuria" );
			suunta = this.maailma.annaSuuntaEdelliseen();
		}
	
		while( this.annaSuunta() != suunta ) {
			this.kaannyOikealle();
		}
		System.out.println( "Edetään suuntaan: " + suunta + "******************" );
		this.maailma.siirry( suunta );
		this.etene();
	}
}
