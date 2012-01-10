import java.util.*;

public class ExtendedInteger {

	private short value;
	private String special;
	
	private HashMap<String[], String> rules;
	
	public ExtendedInteger( String val ) {
		
		this.special = val;
		
	}
	
	public short getValue() {
		return value;
	}

	public String getSpecial() {
		return special;
	}

	public ExtendedInteger( short val ) {
		
		this.value = val;
		
	}
	
	
	public int loadRules() {
		
		this.addRule("+Inf","+Inf","+Inf");
		
		return 0;
		
		
		//this.rules.get(String[] = { "+Inf", "+Inf" });
		
	}
	
	
	public void addRule( String e1, String e2, String res ) {
		String[] rule = {e1, e2};
		this.rules.put(rule,res);
	}
	
	
	public String getRule( String e1, String e2 ) {
		String[] rule = {e1, e2};

		return this.rules.get(rule);
	}
	
	public ExtendedInteger add( ExtendedInteger val ) {
		
		//Si on a un NaN en opérande
		if ( this.isNaN() || val.isNaN() ) {
			return new ExtendedInteger( "NaN" );
		}
		//+Inf + +Inf nous donne +Inf
		else if ( this.isPositiveInfinity() && val.isPositiveInfinity() ) {
			return new ExtendedInteger( "+Inf " );
		}
		//Idem pour -Inf
		else if ( this.isNegativeInfinity() && val.isNegativeInfinity() ) {
			return new ExtendedInteger( "-Inf" );
		}
		//Si on a 1 valeurs short
		else if ( this.isANormalNumber() || val.isANormalNumber() ) {
			if ( this.isANormalNumber() && val.isANormalNumber() ) {
				return new ExtendedInteger( (short)(this.getValue() + val.getValue()) );
			}
			else if (this.isNegativeInfinity() || val.isNegativeInfinity()) {
				return new ExtendedInteger( "-Inf" );
			}
			else if (this.isPositiveInfinity() || val.isPositiveInfinity()) {
				return new ExtendedInteger( "+Inf" );
			}
		}
		//Par défaut, on renvoie NaN

		return new ExtendedInteger("NaN");

		
	} 
	
	public ExtendedInteger sub( ExtendedInteger val ) {
		//Si on a un NaN en opérande
		if ( this.isNaN() || val.isNaN() ) {
			return new ExtendedInteger( "NaN" );
		}
		//+Inf + +Inf nous donne +Inf
		else if ( this.isPositiveInfinity() && val.isNegativeInfinity() ) {
			return new ExtendedInteger( "+Inf " );
		}
		//Idem pour -Inf
		else if ( this.isNegativeInfinity() && val.isPositiveInfinity() ) {
			return new ExtendedInteger( "-Inf" );
		}
		//Si on a 1 valeurs short
		else if ( this.isANormalNumber() || val.isANormalNumber() ) {
			if ( this.isANormalNumber() && val.isANormalNumber() ) {
				return new ExtendedInteger( (short)(this.getValue() - val.getValue()) );
			}
			else if (this.isNegativeInfinity() || val.isNegativeInfinity()) {
				
				if ( this.isNegativeInfinity() ) {
					return new ExtendedInteger( "-Inf" );
				}
				else {
					return new ExtendedInteger( "+Inf" );
				}
			}
			else if (this.isPositiveInfinity() || val.isPositiveInfinity()) {
				
				if ( this.isPositiveInfinity() ) {
					return new ExtendedInteger( "+Inf" );
				}
				else {
					return new ExtendedInteger( "-Inf" );
				}
			}
		}
		//Par défaut, on renvoie NaN
		return new ExtendedInteger("NaN");

	} 
	
	public ExtendedInteger mult( ExtendedInteger val ) {
		//Si on a un NaN en opérande
		if ( this.isNaN() || val.isNaN() ) {
			return new ExtendedInteger( "NaN" );
		}
		//+Inf + +Inf nous donne +Inf
		else if ( this.isPositiveInfinity() && val.isPositiveInfinity() ) {
			return new ExtendedInteger( "+Inf " );
		}
		//Idem pour -Inf
		else if ( this.isNegativeInfinity() && val.isNegativeInfinity() ) {
			return new ExtendedInteger( "+Inf" );
		}
		else if ( this.isNegativeInfinity() && val.isPositiveInfinity() ) {
			return new ExtendedInteger( "-Inf" );
		}
		else if ( this.isPositiveInfinity() && val.isNegativeInfinity() ) {
			return new ExtendedInteger( "-Inf" );
		}
		//Si on a 1 valeurs short
		else if ( this.isANormalNumber() || val.isANormalNumber() ) {
			if ( this.isANormalNumber() && val.isANormalNumber() ) {
				return new ExtendedInteger( (short)(this.getValue() * val.getValue()) );
			}
			else if (this.isNegativeInfinity() || val.isNegativeInfinity()) {
				return new ExtendedInteger( "-Inf" );
			}
			else if (this.isPositiveInfinity() || val.isPositiveInfinity()) {
				return new ExtendedInteger( "+Inf" );
			}
		}
		//Par défaut, on renvoie NaN
		return new ExtendedInteger("NaN");
		
	} 
	
	public ExtendedInteger div( ExtendedInteger val ) {
		
		if ( this.isANormalNumber() || val.isANormalNumber() ) {
			
			if ( this.isANormalNumber() && val.isANormalNumber() ) {
				return new ExtendedInteger( (short)(this.getValue() / val.getValue()) );
			}
			else if (this.isPositiveInfinity() || val.isPositiveInfinity()) {
				
				if ( val.isPositiveInfinity() ) {
					return new ExtendedInteger( (short) 0 );
				}
				else {
					return new ExtendedInteger( "+Inf" );
				}
			}
			else if (this.isNegativeInfinity() || val.isNegativeInfinity()) {
				if ( val.isPositiveInfinity() ) {
					return new ExtendedInteger( (short) 0 );
				}
				else {
					return new ExtendedInteger( "-Inf" );
				}
			}


			
		}

		return new ExtendedInteger("NaN");	
		
	} 

	
	
	
	public ExtendedInteger min( ExtendedInteger val ) {
		
	}
	
	public ExtendedInteger max( ExtendedInteger val ) {
		
	}
	
	
	public boolean isNaN() {
		return this.special.equals("NaN");
	}
	
	public boolean isPositiveInfinity() {
		return this.special.equals("+Inf");
	}
	
	public boolean isNegativeInfinity() {
		return this.special.equals("-Inf");
	}
	
	/*
	public boolean isANormalNumber() {
		return (this.special.length() == 0);
	}
	*/
	
	public boolean isANormalNumber() {
		return (!isNaN() && !isNegativeInfinity() && !isPositiveInfinity());
	}
}
