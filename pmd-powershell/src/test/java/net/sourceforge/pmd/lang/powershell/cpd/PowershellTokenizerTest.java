/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.powershell.cpd;

import org.junit.jupiter.api.Test;

import net.sourceforge.pmd.lang.test.cpd.CpdTextComparisonTest;

public class PowershellTokenizerTest extends CpdTextComparisonTest {
    public PowershellTokenizerTest() {
        super("powershell", ".ps1");
    }

    @Test
    public void testInitMachine() {
        doTest("Initialize-Machine-Signed");
    }

    @Test
    public void testInstallVS() {
        doTest("Install-VS");
    }

    @Test
    public void testStringLiterals() {
        doTest("String-Literal-Test");
    }

    @Test
    public void testExpStringDollarEnd() {
        doTest("Regex-Interp");
    }
}
