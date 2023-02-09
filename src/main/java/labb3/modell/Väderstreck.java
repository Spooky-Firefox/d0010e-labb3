package labb3.modell;
/**
 * 
 * @author Viktor Magnusson & Olle Ronstad
 */
public enum Väderstreck {
	NORR(0), ÖSTER(1), SÖDER(2), VÄSTER(3);
	private final int ind;
	private Väderstreck(int i){
		ind = i;
	}
	public int index(){
		return ind;
	}
	// En dold heltalsvariabel (en instansvariabel). Skriv en instansmetod
	// index() som returnerar heltalsvariabeln. Ändra de fyra väderstrecken 
	// så att 
	// 
	// NORR.index() returnerar 0, 
	// ÖSTER.index() returnerar 1,
	// SÖDER.index() returnerar 2 och 
	// VÄSTER.index() returnerar 3. 
}
