/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.cpd;

import java.util.EnumSet;
import java.util.Set;

/**
 * Combined setting for 'ignore-sequence' variants (see {@link CPDSequenceIgnoreType}),
 */
public class CPDSequenceIgnoreSetting {
    private Set<CPDSequenceIgnoreType> enabledIgnoreSequenceTypes = EnumSet.noneOf(CPDSequenceIgnoreType.class);

    public void setValue(CPDSequenceIgnoreType type, boolean value) {
        if (value) {
            enabledIgnoreSequenceTypes.add(type);
        } else {
            enabledIgnoreSequenceTypes.remove(type);
        }
    }

    public boolean getValue(CPDSequenceIgnoreType type) {
        return enabledIgnoreSequenceTypes.contains(type);
    }
}
