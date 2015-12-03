/*****************************************************************************
 * AMOS
 *
 * Author: 2014 Tore Risch, UDBL
 *
 * Description: A bag valued foreign function
 ****************************************************************************/

import callin.*;
import callout.*;

/**
 * Example class of foreign function taking one argument N
 * and returning a bag of the first N elements of a number sequence
 */
public class Harmonic
{
    public Harmonic()
    {
	/* There must always be a default constructor */
    }
    /**
     * Declare function harmonic() as follows in Amos II:
     *
     *   create function harmonic(Number x) -> Bag of Number
     *     as foreign "JAVA:Harmonic/harmonicBF";
     *
     * Amos II calls this method when the user executes a call to sqrt2();
     */
    public void harmonicBF(CallContext cxt, Tuple tpl) throws AmosException
	/* The object 'tpl' contains both input and output values of the
           function call. 

           In this case there is 1 input value N (pos 0 in tpl) and 
           1 output values (pos 1 in tpl) to be filled in with 
           the first N elements of the Harmonic number sequence.
           (http://en.wikipedia.org/wiki/Harmonic_series_(mathematics)) */
    {
        double H = 0;

        /* Get the argument N: */
        int N = tpl.getIntElem(0);
        int i;

        /* Generate and emit the N first terms in the Harmonic series H: */
        for(i=1;i<=N;i++)
	    {
		H = H + 1.0/i;
                tpl.setElem(1,H);
                cxt.emit(tpl); 
	    }
    }
}
