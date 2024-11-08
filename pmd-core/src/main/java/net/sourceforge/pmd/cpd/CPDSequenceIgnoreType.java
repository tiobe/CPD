/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.cpd;

/**
 * Options for skipping/ignoring tokens in CPD
 */
public enum CPDSequenceIgnoreType {
    LITERALS("literals"),
    LITERALS_IDENTIFIERS("literals-identifiers"),
    INITIALIZATIONS("initializations");

    private final String name;

    CPDSequenceIgnoreType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
