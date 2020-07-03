package ua.nure.parser.domain;

import com.google.errorprone.annotations.Immutable;
import org.apache.commons.validator.routines.UrlValidator;
import ua.nure.parser.infrastructure.Validator;

@Immutable
public final class AnalyzedDataLocation {

    private final String dataLocation;

    private AnalyzedDataLocation(String dataLocation) {
        this.dataLocation = dataLocation;
    }

    /**
     * A static factory method to create {@code AnalyzedDatas}.
     *
     * @param url a target URL to analyzed data
     * @return the {@code AnalyzedData} instance
     */
    public static AnalyzedDataLocation fetchFromUrl(String url) {
        UrlValidator urlValidator = new UrlValidator();
        boolean isValidate = Validator.validateUrl(url);
        if (!isValidate) {
            throw new IllegalArgumentException("The string of URL is wrong.");
        }
        return new AnalyzedDataLocation(url);
    }

    public String getDataLocation() {
        return dataLocation;
    }
}
