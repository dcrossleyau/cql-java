// $Id: CQLParseException.java,v 1.2 2002-11-06 20:13:45 mike Exp $

package org.z3950.zing.cql;
import java.lang.Exception;


/**
 * Exception indicating that an error ocurred parsing CQL.
 *
 * @version	$Id: CQLParseException.java,v 1.2 2002-11-06 20:13:45 mike Exp $
 */
public class CQLParseException extends Exception {
    /**
     * Creates a new <TT>CQLParseException</TT>.
     * @param s
     *	An error message describing the problem with the query,
     *	usually a syntax error of some kind.
     */
    public CQLParseException(String s) {
	super(s);
    }
}
