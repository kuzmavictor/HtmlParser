package ua.nure.parser.domain;


import com.google.errorprone.annotations.Immutable;

@Immutable
public final class ParameterToFound {
    private final String parameter;

    public ParameterToFound(String parameter) {
        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter;
    }
}
