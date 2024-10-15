/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.matlab.cpd;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.junit.jupiter.api.Test;

import net.sourceforge.pmd.lang.test.cpd.CpdTextComparisonTest;

class MatlabCpdLexerTest extends CpdTextComparisonTest {

    MatlabCpdLexerTest() {
        super("matlab", ".m");
    }

    @Override
    protected @NonNull String normalize(@NonNull String str) {
        // Only normalize LF/CR/CRLF so we can test handling of e.g. \u000C (form-feed)
        return str.replaceAll("\\u000D\\u000A|[\\u000A\\u000D]", "\n");
    }

    @Test
    void testLongSample() {
        doTest("sample-matlab");
    }

    @Test
    void testIgnoreBetweenSpecialComments() {
        doTest("specialComments");
    }

    @Test
    void testComments() {
        doTest("comments");
    }

    @Test
    void testBlockComments() {
        doTest("multilineComments");
    }

    @Test
    void testQuestionMark() {
        doTest("questionMark");
    }

    @Test
    void testDoubleQuotedStrings() {
        doTest("doubleQuotedStrings");
    }

    @Test
    void testTabWidth() {
        doTest("tabWidth");
    }

    @Test
    void testFormFeed() {
        doTest("formFeed");
    }
}
