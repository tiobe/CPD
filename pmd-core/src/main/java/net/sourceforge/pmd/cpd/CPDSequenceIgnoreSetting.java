/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.cpd;

import java.util.EnumSet;

public class CPDSequenceIgnoreSetting {
    private EnumSet<CPDSequenceIgnoreType> setting = EnumSet.noneOf(CPDSequenceIgnoreType.class);

    public void setValue(CPDSequenceIgnoreType type, boolean value) {
        if (value) {
            setting.add(type);
        } else {
            setting.remove(type);
        }
    }

    public boolean getValue(CPDSequenceIgnoreType type) {
        return setting.contains(type);
    }
}
