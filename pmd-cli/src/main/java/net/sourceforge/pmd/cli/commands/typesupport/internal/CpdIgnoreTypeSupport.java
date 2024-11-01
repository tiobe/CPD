/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.cli.commands.typesupport.internal;

import java.util.Arrays;
import java.util.Iterator;

import net.sourceforge.pmd.cpd.CPDSequenceIgnoreType;

import picocli.CommandLine.ITypeConverter;
import picocli.CommandLine.TypeConversionException;

public class CpdIgnoreTypeSupport implements ITypeConverter<CPDSequenceIgnoreType>, Iterable<String> {

    @Override
    public Iterator<String> iterator() {
        return Arrays.stream(CPDSequenceIgnoreType.values()).map(CPDSequenceIgnoreType::getName).iterator();
    }

    @Override
    public CPDSequenceIgnoreType convert(String s) {
        return Arrays.stream(CPDSequenceIgnoreType.values())
                .filter(t -> t.getName().equalsIgnoreCase(s))
                .findFirst()
                .orElseThrow(() -> new TypeConversionException("Invalid ignore option: " + s));
    }
}
