/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.awl.cpd;

import org.junit.jupiter.api.Test;

import net.sourceforge.pmd.lang.test.cpd.CpdTextComparisonTest;

class AwlCpdLexerTest extends CpdTextComparisonTest {

    AwlCpdLexerTest() {
        super("awl", ".awl");
    }

    @Test
    void examples() {
        doTest("awl_examples");
    }

}
