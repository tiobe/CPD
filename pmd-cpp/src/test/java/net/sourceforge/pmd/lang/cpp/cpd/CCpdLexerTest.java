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
        doTest(baseFilename, "_ignored", skipSequenceInitializations());
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
        return properties(true, skipPattern, false, false, false);
    }

    private static LanguagePropertyConfig dontSkipBlocks() {
        return properties(false, null, false, false, false);
    }

    private static LanguagePropertyConfig skipSequenceInitializations() {
        return properties(false, null, false, false, true);
    }

    private static LanguagePropertyConfig properties(boolean skipBlocks,
                                                     String skipPattern,
                                                     boolean skipLiteralSequences,
                                                     boolean skipLiteralAndIdentifierSequences,
                                                     boolean skipSequenceInitializations) {
        return properties -> {
            if (!skipBlocks) {
                properties.setProperty(CppLanguageModule.CPD_SKIP_BLOCKS, "");
            } else if (skipPattern != null) {
                properties.setProperty(CppLanguageModule.CPD_SKIP_BLOCKS, skipPattern);
            }
            properties.setProperty(CpdLanguageProperties.CPD_IGNORE_LITERAL_SEQUENCES, skipLiteralSequences);
            properties.setProperty(CpdLanguageProperties.CPD_IGNORE_LITERAL_AND_IDENTIFIER_SEQUENCES, skipLiteralAndIdentifierSequences);
            properties.setProperty(CpdLanguageProperties.CPD_IGNORE_SEQUENCE_INITIALIZATION, skipSequenceInitializations);
        };
    }
}
