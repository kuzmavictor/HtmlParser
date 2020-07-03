package ua.nure.parser.domain;

import com.google.errorprone.annotations.Immutable;

@Immutable
public final class HtmlElementParameters {

    private final String href;
    private final String text;
    private final String className;
    private final String attribute;


    public HtmlElementParameters(String href, String text, String className, String attribute) {
        this.href = href;
        this.text = text;
        this.className = className;
        this.attribute = attribute;
    }

    public String getHref() {
        return href;
    }

    public String getText() {
        return text;
    }

    public String getClassName() {
        return className;
    }

    public String getAttribute() {
        return attribute;
    }
}
