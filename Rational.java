public class Rational {
    

    // PHASE ONE:

    // instance vars
    private int _numer, _denom;

    // constructors
    public Rational() {
	_numer = 0;
	_denom = 1;
    }

    public Rational(int  numerNew, int denomNew ) {
	if (denomNew != 0) {
	    _denom = denomNew;
	    _numer = numerNew;
	}
	else {
	    System.out.println("invalid denominator, it cannot equal 0");
	    _numer = 0;
	    _denom = 1;
		}
    }

    // methods:

    public String toString() {
	return _numer + "/" + _denom;
    }

    public double floatValue() {
	return ((float) _numer) / _denom;
    }

    public void multiply( Rational factor ) {
	_numer *= factor._numer;
	_denom *= factor._denom;
    }

    public void divide( Rational factor ) {
	_numer *= factor._denom;
	_denom *= factor._numer;
    }

    // PHASE 2:

    public void add( Rational factor ) {
	int origDenom = _denom;
	_numer *= factor._denom;
	_denom *= factor._denom;
	_numer += factor._numer * origDenom;

    }

    public void subtract( Rational factor ) {
	int origDenom = _denom;
	_numer *= factor._denom;
	_denom *= factor._denom;
	_numer -= factor._numer * origDenom;

    }

    // this also works for phase three static gcd method
    public static int gcder( int a, int b) {
        if (a == b){
	    return a;
	}
	else {
	    return gcder( Math.max(a,b) - Math.min(a,b), Math.min(a,b));
	}
    }

    public int gcd() {
	return gcder( _numer, _denom );
    }

    public void reduce() {
	if ( _numer != 0 ) {
	    int gcf = this.gcd();
	    _numer /= gcf;
	    _denom /= gcf;
	}
	else {
	    _denom = 1;
	}
    }

    // PHASE 3

    public int compareTo( Rational comparer) {
	this.reduce();
	comparer.reduce();
	if (  (this._numer == comparer._numer) && (this._denom == comparer._denom) ) {
	    return 0;
	}
	else if ( this.floatValue() > comparer.floatValue() ) {
	    return 1;
	}
	else {
	    return -1;
	}
    }
	


    public static void main( String[] args) {

	System.out.println( "PHASE 1 TESTING:" );
	Rational mine = new Rational( 1, 3) ;
	System.out.println( mine );
	System.out.println( mine.floatValue() );
	
	Rational yours = new Rational( 2, 1) ;
	mine.multiply( yours );
	System.out.println( mine );
	System.out.println( yours );


	mine.divide( yours );
	System.out.println( mine );
	System.out.println( yours );

	System.out.println( "PHASE 2 TESTING:" );

	mine.add( yours );	
	System.out.println( mine);
	System.out.println( yours);

	mine.subtract( yours );	
	System.out.println( mine );
	System.out.println( yours );

	System.out.println( mine.gcd() );
	System.out.println( yours.gcd() );
	
	mine.reduce();
	System.out.println( mine );

	System.out.println( "PHASE 3 TESTING:" );

	Rational thing = new Rational( 1, 2 );
	Rational thang = new Rational( 4, 8 );
	System.out.println( thing.compareTo( thang ) );
	
	Rational bob = new Rational( 1, 2 );
	Rational paul = new Rational( 4, 1 );
	System.out.println( bob.compareTo( paul ) );
	
    }
    

}