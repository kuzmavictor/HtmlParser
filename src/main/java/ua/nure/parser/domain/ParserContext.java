package ua.nure.parser.domain;

import com.google.errorprone.annotations.Immutable;
import ua.nure.parser.Query;

@Immutable
public final class ParserContext implements Query {

    private final ParameterToFound parameterToFound;
    private final AnalyzedDataLocation originalDataLocation;
    private final AnalyzedDataLocation otherDataLocation;

    public ParserContext(ParameterToFound parameterToFound, AnalyzedDataLocation originalDataLocation, AnalyzedDataLocation otherDataLocation) {
        this.parameterToFound = parameterToFound;
        this.originalDataLocation = originalDataLocation;
        this.otherDataLocation = otherDataLocation;
    }

    public ParameterToFound getParameterToFound() {
        return parameterToFound;
    }

    public AnalyzedDataLocation getOriginalDataLocation() {
        return originalDataLocation;
    }

    public AnalyzedDataLocation getOtherDataLocation() {
        return otherDataLocation;
    }
}
