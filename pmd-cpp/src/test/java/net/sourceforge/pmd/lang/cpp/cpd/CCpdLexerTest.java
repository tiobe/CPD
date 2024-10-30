/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.cpp.cpd;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.junit.jupiter.api.Test;

import net.sourceforge.pmd.cpd.CpdLanguageProperties;
import net.sourceforge.pmd.lang.cpp.CppLanguageModule;
import net.sourceforge.pmd.lang.test.cpd.CpdTextComparisonTest;
import net.sourceforge.pmd.lang.test.cpd.LanguagePropertyConfig;

/**
 * Tests specific to C files
 */
class CCpdLexerTest extends CpdTextComparisonTest {

    CCpdLexerTest() {
        super(CppLanguageModule.getInstance(), ".c");
    }

    @Override
    public @NonNull LanguagePropertyConfig defaultProperties() {
        return dontSkipBlocks();
    }

    private void testNormalAndIgnored(String baseFilename) {
        doTest(baseFilename, "", defaultProperties());
        doTest(baseFilename, "_ignored", skipIdentifierAndLiteralsSequences());
    }

    @Test
    void testNegative() {
        testNormalAndIgnored("negative_literals");
    }

    @Test
    void testStructList() {
        testNormalAndIgnored("struct_array");
    }

    @Test
    void testCharLiterals() {
        testNormalAndIgnored("char_literals");
    }


    private static LanguagePropertyConfig skipBlocks(String skipPattern) {
        return properties(true, skipPattern, false, false);
    }

    private static LanguagePropertyConfig skipBlocks() {
        return skipBlocks(null);
    }

    private static LanguagePropertyConfig dontSkipBlocks() {
        return properties(false, null, false, false);
    }

    private static LanguagePropertyConfig skipLiteralSequences() {
        return properties(false, null, true, false);
    }

    private static LanguagePropertyConfig skipIdentifierAndLiteralsSequences() {
        return properties(false, null, true, true);
    }

    private static LanguagePropertyConfig skipIdentifierSequences() {
        return properties(false, null, false, true);
    }

    private static LanguagePropertyConfig properties(boolean skipBlocks, String skipPattern, boolean skipLiteralSequences, boolean skipSequences) {
        return properties -> {
            if (!skipBlocks) {
                properties.setProperty(CppLanguageModule.CPD_SKIP_BLOCKS, "");
            } else if (skipPattern != null) {
                properties.setProperty(CppLanguageModule.CPD_SKIP_BLOCKS, skipPattern);
            }
            properties.setProperty(CpdLanguageProperties.CPD_IGNORE_LITERAL_SEQUENCES, skipLiteralSequences);
            properties.setProperty(CpdLanguageProperties.CPD_IGNORE_LITERAL_AND_IDENTIFIER_SEQUENCES, skipSequences);
        };
    }
}
