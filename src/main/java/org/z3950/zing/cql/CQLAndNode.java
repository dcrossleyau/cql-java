// $Id: CQLAndNode.java,v 1.9 2007-06-29 12:48:21 mike Exp $

package org.z3950.zing.cql;


/**
 * Represents an AND node in a CQL parse-tree.
 *
 * @version	$Id: CQLAndNode.java,v 1.9 2007-06-29 12:48:21 mike Exp $
 */
public class CQLAndNode extends CQLBooleanNode {
    /**
     * Creates a new AND node with the specified left- and right-hand
     * sides and modifiers.
     */
    public CQLAndNode(CQLNode left, CQLNode right, ModifierSet ms) {
	super(left, right, ms);
    }

    // ### Too much code duplication here with OR and NOT
    byte[] opType1() {
	byte[] op = new byte[5];
	putTag(CONTEXT, 46, CONSTRUCTED, op, 0); // Operator
	putLen(2, op, 2);
	putTag(CONTEXT, 0, PRIMITIVE, op, 3); // and
	putLen(0, op, 4);
	return op;
    }
}