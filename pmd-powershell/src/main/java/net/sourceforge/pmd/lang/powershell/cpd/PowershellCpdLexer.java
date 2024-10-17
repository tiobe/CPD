/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.powershell.cpd;

import net.sourceforge.pmd.cpd.impl.AntlrCpdLexer;
import net.sourceforge.pmd.lang.powershell.ast.PowershellLexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;

/**
 * The PowerShell tokenizer.
 */
public class PowershellCpdLexer extends AntlrCpdLexer {

    @Override
    protected Lexer getLexerForSource(CharStream charStream) {
        return new PowershellLexer(charStream);
    }
}
