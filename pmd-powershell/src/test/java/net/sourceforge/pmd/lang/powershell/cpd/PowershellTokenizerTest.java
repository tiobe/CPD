/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.powershell.cpd;

import org.junit.jupiter.api.Test;

import net.sourceforge.pmd.lang.test.cpd.CpdTextComparisonTest;

class PowershellTokenizerTest extends CpdTextComparisonTest {
    PowershellTokenizerTest() {
        super("powershell", ".ps1");
    }

    @Test
    void testInitMachine() {
        doTest("Initialize-Machine-Signed");
    }

    @Test
    void testInstallVS() {
        doTest("Install-VS");
    }

    @Test
    void testStringLiterals() {
        doTest("String-Literal-Test");
    }

    @Test
    void testExpStringDollarEnd() {
        doTest("Regex-Interp");
    }
}
