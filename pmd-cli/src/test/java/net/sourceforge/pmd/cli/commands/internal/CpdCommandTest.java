/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.cli.commands.internal;

import static net.sourceforge.pmd.util.CollectionUtil.listOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import net.sourceforge.pmd.cpd.CPDConfiguration;
import net.sourceforge.pmd.util.CollectionUtil;

class CpdCommandTest extends BaseCommandTest<CpdCommand> {

    @Test
    void testMultipleDirs() {
        final CpdCommand cmd = setupAndParse(
            "-d", "a", "b"
        );
        assertMultipleDirs(cmd);
    }

    @Test
    void testMultipleDirsWithCommas() {
        final CpdCommand cmd = setupAndParse(
            "-d", "a,b"
        );
        assertMultipleDirs(cmd);
    }

    @Test
    void testMultipleDirsWithRepeatedOption() {
        final CpdCommand cmd = setupAndParse(
            "-d", "a", "-d", "b"
        );
        assertMultipleDirs(cmd);
    }

    @Test
    void testNoPositionalParametersAllowed() {
        final CpdCommand cmd = setupAndParse(
            "-d", "a", "--", "b"
        );
        assertMultipleDirs(cmd);
    }

    @Test
    void testEmptyDirOption() {
        assertError("-d", "-f", "text");
    }

    private void assertMultipleDirs(final CpdCommand result) {
        final CPDConfiguration config = result.toConfiguration();
        assertEquals(listOf("a", "b"), CollectionUtil.map(config.getInputPathList(), Path::toString));
    }

    @ParameterizedTest
    @MethodSource("ignoreSequencesTestArgs")
    void testIgnoreSequencesOption(String[] args, ExpectedIgnoreOptions ignore) {
        final CpdCommand cmd = setupAndParse(args);
        CPDConfiguration config = cmd.toConfiguration();
        assertIgnoreSequenceOptions(config, ignore);
    }

    static Collection<Arguments> ignoreSequencesTestArgs() {
        Collection<Arguments> args = new ArrayList<Arguments>();
        args.add(Arguments.of(
                new String[] {
                    "--ignore-sequences",
                    "literals",
                },
                new ExpectedIgnoreOptions(false, true, false, false)
        ));
        args.add(Arguments.of(
                new String[] {
                    "--ignore-sequences",
                    "literals-identifiers",
                },
                new ExpectedIgnoreOptions(false, false, true, false)
        ));
        args.add(Arguments.of(
                new String[] {
                    "--ignore-sequences",
                    "initializations",
                },
                new ExpectedIgnoreOptions(false, false, false, true)
        ));
        args.add(Arguments.of(
                new String[] {
                    "--ignore-sequences",
                    "literals-identifiers",
                    "--ignore-sequences",
                    "initializations",
                },
                new ExpectedIgnoreOptions(false, false, true, true)
        ));
        args.add(Arguments.of(
                new String[] {
                    "--ignore-sequences",
                },
                new ExpectedIgnoreOptions(false, false, true, false)
        ));
        args.add(Arguments.of(
            new String[] { },
            new ExpectedIgnoreOptions(false, false, false, false)
        ));
        return args;
    }

    void assertIgnoreSequenceOptions(CPDConfiguration config, ExpectedIgnoreOptions exp) {
        assertEquals(config.isIgnoreLiteralSequences(), exp.literalSequences, "Expected isIgnoreLiteralSequences() to be " + exp.literalSequences);
        assertEquals(config.isIgnoreIdentifierAndLiteralSequences(), exp.identifierSequences, "Expected isIgnoreLiteralAndIdentifierSequences() to be " + exp.identifierSequences);
        assertEquals(config.isIgnoreSequenceInitializations(), exp.arrayInitializations, "Expected isIgnoreArrayInitializations() to be " + exp.arrayInitializations);
    }

    static class ExpectedIgnoreOptions {
        boolean annotations;
        boolean literalSequences;
        boolean identifierSequences;
        boolean arrayInitializations;

        ExpectedIgnoreOptions(
                boolean annotations,
                boolean literalSequences,
                boolean identifierSequences,
                boolean arrayInitializations
        ) {
            this.annotations = annotations;
            this.literalSequences = literalSequences;
            this.identifierSequences = identifierSequences;
            this.arrayInitializations = arrayInitializations;
        }
    }

    @Override
    protected CpdCommand createCommand() {
        return new CpdCommand();
    }

    @Override
    protected void addStandardParams(final List<String> argList) {
        // If no minimum tokens provided, set default value
        if (!argList.contains("--minimum-tokens")) {
            argList.add(0, "--minimum-tokens");
            argList.add(1, "100");
        }
    }
}
