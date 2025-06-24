/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.awl;

import net.sourceforge.pmd.cpd.CpdLexer;
import net.sourceforge.pmd.lang.LanguagePropertyBundle;
import net.sourceforge.pmd.lang.awl.cpd.AwlCpdLexer;
import net.sourceforge.pmd.lang.impl.CpdOnlyLanguageModuleBase;

public class AwlLanguageModule extends CpdOnlyLanguageModuleBase {
    private static final String ID = "awl";

    public AwlLanguageModule() {
        super(LanguageMetadata.withId(ID).name("AWL").extensions("awl", "AWL"));
    }

    @Override
    public CpdLexer createCpdLexer(LanguagePropertyBundle bundle) {
        return new AwlCpdLexer();
    }
}
