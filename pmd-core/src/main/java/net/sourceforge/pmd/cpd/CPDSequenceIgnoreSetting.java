/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.cpd;

public class CPDSequenceIgnoreSetting {
    private int setting = 0;

    public void setValue(CPDSequenceIgnoreType type, boolean value) {
        int index = type.ordinal();
        if (value) {
            setting |= (1 << index);
        } else {
            setting &= ~(1 << index);
        }
    }

    public boolean getValue(CPDSequenceIgnoreType type) {
        return (setting & (1 << type.ordinal())) != 0;
    }
}
