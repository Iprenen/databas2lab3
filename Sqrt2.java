/*****************************************************************************
 * AMOS
 *
 * Author: 2014 Tore Risch, UDBL
 *
 * Description: A tuples valued foreign function
 ****************************************************************************/

import callin.*;
import callout.*;

/**
 * Example class of foreign function taking one argument
 * and returning a tuple with two elements.
 */
public class Sqrt2
{
    public Sqrt2()
    {
	/* There must always be a default constructor */
    }
    /**
     * Declare function sqrt2() as follows in Amos II:
     *
     *   create function sqrt2(Number x) -> (Number pos, Number neg)
     *     as foreign "JAVA:Sqrt2/sqrt2BFF";
     *
     * Amos II calls this method when the user executes a call to sqrt2();
     */
    public void sqrt2BFF(CallContext cxt, Tuple tpl) throws AmosException
	/* The object 'tpl' contains both input and output values of the
           function call. 

           In this case there is 1 input value (pos 0 in tpl) and 
           2 output values (pos 1 and 2 in tpl) to be filled in with 
           the negative and positive square roots of sqrt2(x) */
    {
        /* Get the argument position 0 of sqrt(): */
        double x = tpl.getDoubleElem(0);

        if(x < 0) return; /* No roots */

        /* Fill in result position 1 in tpl: */
        tpl.setElem(1,-Math.sqrt(x));

        /* Fill in result position 2 in tpl: */
        tpl.setElem(2,Math.sqrt(x));

        /* Emit the filled in result tuple to Amos II: */
        cxt.emit(tpl); 
    }
}
