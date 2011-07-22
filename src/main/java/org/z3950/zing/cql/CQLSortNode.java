// $Id: CQLSortNode.java,v 1.2 2008-04-11 12:05:15 mike Exp $

package org.z3950.zing.cql;
import java.util.Properties;
import java.util.Vector;


/**
 * Represents a sort node in a CQL parse-tree.
 *
 * @version	$Id: CQLSortNode.java,v 1.2 2008-04-11 12:05:15 mike Exp $
 */
public class CQLSortNode extends CQLNode {
    /**
     * The root of a subtree representing the query whose result is to
     * be sorted.
     */ 
    private CQLNode subtree;

    /**
     * The set of sort keys by which results are to be sorted,
     * each expressed as an index together with zero or more
     * modifiers.
     */ 
    Vector<ModifierSet> keys;

    public CQLNode getSubtree() {
        return subtree;
    }

    public CQLSortNode(CQLNode subtree) {
	this.subtree = subtree;
	keys = new Vector<ModifierSet>();
    }

    public void addSortIndex(ModifierSet key) {
	keys.add(key);
    }

    public Vector<ModifierSet> getSortIndexes() {
    	return keys;
    }

    public String toXCQL(int level, Vector<CQLPrefix> prefixes,
			 Vector<ModifierSet> sortkeys) {
	if (sortkeys != null)
	    throw new Error("CQLSortNode.toXCQL() called with sortkeys");
	return subtree.toXCQL(level, prefixes, keys);
    }

    public String toCQL() {
	StringBuffer buf = new StringBuffer(subtree.toCQL());

	if (keys != null) {
	    buf.append(" sortby");
	    for (int i = 0; i < keys.size(); i++) {
		ModifierSet key = keys.get(i);
		buf.append(" " + key.toCQL());
	    }
	}

	return buf.toString();
    }

    public String toPQF(Properties config) throws PQFTranslationException {
	return "@attr 1=oops \"###\"";
    }

    public byte[] toType1BER(Properties config)
	throws PQFTranslationException {
	// There is no way to represent sorting in a standard Z39.50
	// Type-1 query, so the best we can do is return the
	// underlying query and ignore the sort-specification.
        return subtree.toType1BER(config);
    }
}
