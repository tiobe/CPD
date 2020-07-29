/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.ast;

import java.util.Objects;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * An exception that occurs while processing a file. Subtypes include
 * <ul>
 * <li>{@link TokenMgrError}: lexical syntax errors
 * <li>{@link ParseException}: syntax errors
 * <li>{@link SemanticException}: exceptions occurring after the parsing
 * phase, because the source code is semantically invalid
 * </ul>
 */
public class FileAnalysisException extends RuntimeException {

    protected static final String UNKNOWN_FNAME = "(unknown file)";
    private String filename = UNKNOWN_FNAME;

    public FileAnalysisException() {
        super();
    }

    public FileAnalysisException(String message) {
        super(message);
    }

    public FileAnalysisException(Throwable cause) {
        super(cause);
    }

    public FileAnalysisException(String message, Throwable cause) {
        super(message, cause);
    }

    FileAnalysisException setFileName(String filename) {
        this.filename = Objects.requireNonNull(filename);
        return this;
    }

    protected boolean hasFileName() {
        return !UNKNOWN_FNAME.equals(filename);
    }

    /**
     * The name of the file in which the error occurred.
     */
    public @NonNull String getFileName() {
        return filename;
    }
}
