///////////////////////////////////////////////////////////////////////////////
// Main Class File:  
// File:             Ingredient.java
// 
// Author(s):           Nicholas Cook 
// Description: 
///////////////////////////////////////////////////////////////////////////////
public class Ingredient {
	private String ingredientName;
	private String effect1;
	private String effect2;
	private String effect3;
	private String effect4;

	//Ingredient object constructor
	public Ingredient(String name, String eff1, String eff2, String eff3, String eff4) {
		this.ingredientName = name;
		this.effect1 = eff1;
		this.effect2 = eff2;
		this.effect3 = eff3;
		this.effect4 = eff4;
	}
	
	public String getName() {
		return this.ingredientName;
	}
	
	public String getEff1() {
		return this.effect1;
	}
	
	public String getEff2() {
		return this.effect2;
	}
	
	public String getEff3() {
		return this.effect3;
	}
	
	public String getEff4() {
		return this.effect4;
	}
	
	public String[] getAllEffects() {
		String[] effects = new String[4];
		effects[0]=this.effect1;
		effects[1] = this.effect2;
		effects[2] = this.effect3;
		effects[3] = this.effect4;
		
		return effects;
	}
}
