package ua.nure.parser.domain;

import jdk.nashorn.internal.ir.annotations.Immutable;
import ua.nure.parser.Result;

@Immutable
public final class FoundResult implements Result {
private final String parsingResult;

    public FoundResult(String parsingResult) {
        this.parsingResult = parsingResult;
    }

    public String getParsingResult() {
        return parsingResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoundResult that = (FoundResult) o;

        return parsingResult != null ? parsingResult.equals(that.parsingResult) : that.parsingResult == null;
    }

    @Override
    public int hashCode() {
        return parsingResult != null ? parsingResult.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "FoundResult{" +
                "parsingResult='" + parsingResult + '\'' +
                '}';
    }
}
