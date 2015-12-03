/*****************************************************************************
 * AMOS
 *
 * Author: 2014 Tore Risch, UDBL
 *
 * Description: A hello world foreign function in Java
 ****************************************************************************/

/***************************************************************************
 * 1. Compile the program with the command:                                *
 *      javac -cp "../bin/javaamos.jar" Hello.java                         *
 * 2. Set PATH to include folder ../bin:                                   *
 *    Windows: set PATH=%PATH%;..\bin Unix: export PATH=$PATH:../bin       *
 * 3. Run javaamos (Amos under Java):                                      *
 *      javaamos                                                           *
 *    Define the function signature in the Amos console toploop:           *
 *      create function hello() -> Charstring                              *
 *        as foreign 'JAVA:Hello/helloF';                                  *
 *    Run it:                                                              *
 *      hello();                                                           *
 **************************************************************************/

import callin.*;
import callout.*;

/**
 * Example class for the callout-interface to foreign Java-functions.
 */
public class Hello
{
    public Hello()
    {
	/* There must always be a default constructor */
    }
    /**
     * Amos II function definition:
     *
     *   create function hello() -> Charstring
     *     as foreign "JAVA:Hello/helloF";
     *
     */
    public void helloF(CallContext cxt, Tuple tpl) throws AmosException
	/* The object 'tpl' contains both input and output values of the
           function call. 

           In this case there is no input value and one output value 
           (pos 0 in tpl) to be filled in with the string "Hello World", 
           which is the result of calling hello() */
    {
        /* Fill in the result position 0 (no argument, 1 result) in tpl: */
        tpl.setElem(0,"Hello World");

        /* Emit the filled in result tuple to Amos II: */
        cxt.emit(tpl); 
    }
}
