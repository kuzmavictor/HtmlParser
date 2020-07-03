package ua.nure.parser;

import ua.nure.parser.domain.AnalyzedDataLocation;
import ua.nure.parser.domain.ParameterToFound;
import ua.nure.parser.domain.ParserContext;
import ua.nure.parser.infrastructure.HtmlParserHandler;
import ua.nure.parser.infrastructure.ParserHandler;
import ua.nure.parser.infrastructure.reader.DataReader;
import ua.nure.parser.infrastructure.reader.UrlReader;

public class Demo {
    private static final String ORIGINAL_PATH = "https://agileengine.bitbucket.io/beKIvpUlPMtzhfAy/samples/sample-0-origin.html";

    private static final String OTHER_PATH = "https://agileengine.bitbucket.io/beKIvpUlPMtzhfAy/samples/sample-1-evil-gemini.html";

    private static final String ID = "make-everything-ok-button";

    public static void main(String[] args) {

        Demo demo = new Demo();
        demo.igniteParser();

    }

    private void igniteParser() {
        ParameterToFound parameterToFound = new ParameterToFound(ID);

        AnalyzedDataLocation originalData = AnalyzedDataLocation.fetchFromUrl(ORIGINAL_PATH);
        AnalyzedDataLocation otherData = AnalyzedDataLocation.fetchFromUrl(OTHER_PATH);
        ParserContext parserContext = new ParserContext(parameterToFound, originalData, otherData);
        DataReader dataReader = new UrlReader();


        ParserHandler<Result, ParserContext> parserHandler = new HtmlParserHandler(dataReader);
        Result targetElement = parserHandler.findTargetElement(parserContext);

        System.out.println(targetElement);
    }
}
