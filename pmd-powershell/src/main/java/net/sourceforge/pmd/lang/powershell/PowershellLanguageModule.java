/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.powershell;

import net.sourceforge.pmd.cpd.CpdLexer;
import net.sourceforge.pmd.lang.LanguagePropertyBundle;
import net.sourceforge.pmd.lang.impl.CpdOnlyLanguageModuleBase;
import net.sourceforge.pmd.lang.powershell.cpd.PowershellCpdLexer;

/**
 * Language implementation for Powershell
 */
public class PowershellLanguageModule extends CpdOnlyLanguageModuleBase {

    /**
     * Creates a new Powershell language instance.
     */
    public PowershellLanguageModule() {
        super(LanguageMetadata.withId("powershell").name("Powershell").extensions("ps1"));
    }

    @Override
    public CpdLexer createCpdLexer(LanguagePropertyBundle bundle) {
        return new PowershellCpdLexer();
    }
}
