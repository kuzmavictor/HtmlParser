package ua.nure.parser.infrastructure;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ua.nure.parser.ParserException;
import ua.nure.parser.Result;
import ua.nure.parser.domain.FoundResult;
import ua.nure.parser.domain.HtmlElementParameters;
import ua.nure.parser.domain.ParserContext;
import ua.nure.parser.infrastructure.reader.DataReader;

import java.util.ArrayList;

public class HtmlParserHandler implements ParserHandler<Result, ParserContext> {
    private final static String PLATFORM_NAME = "Java";
    private final DataReader reader;
    private String foundOriginalPath;
    private String foundOtherPath;
    private HtmlElementParameters htmlElementParameters;

    public HtmlParserHandler(DataReader reader) {

        this.reader = reader;
    }

    @Override
    public FoundResult findTargetElement(ParserContext context) {

        String programPath = String.valueOf(this.getClass().getProtectionDomain().getCodeSource().getLocation());
        String originalPath = getOriginalPath(context);
        String otherPath = getOtherPath(context);

        StringBuilder sb = new StringBuilder();
        sb.append("platform: ");
        sb.append(PLATFORM_NAME);
        sb.append("\n");
        sb.append("program_path: ");
        sb.append(programPath);
        sb.append("\n");
        sb.append("input_origin_file_path: ");
        sb.append(originalPath);
        sb.append("\n");
        sb.append("input_other_file_path: ");
        sb.append(otherPath);
        sb.append("\n");

        return new FoundResult(sb.toString());
    }

    private String getOriginalPath(ParserContext context) {
        Document document = reader.fetchData(context.getOriginalDataLocation().getDataLocation());
        this.htmlElementParameters = configHtmlElement(document, context);

        if (htmlElementParameters.getClassName() == null) {
            throw new ParserException("The error to find element, please check input data");
        }

        Elements elements = document.body().getAllElements();


        for (Element element : elements) {
            if (!element.ownText().isEmpty()) {
                createPath(element, htmlElementParameters, true);
            }
        }
        System.out.println(foundOriginalPath);
        return "input_origin_file_path: " + foundOriginalPath;
    }


    private String getOtherPath(ParserContext context) {
        Document document = reader.fetchData(context.getOtherDataLocation().getDataLocation());

        if (htmlElementParameters.getClassName() == null) {
            throw new ParserException("The error to find element, please check input data");
        }

        Elements elements = document.body().getAllElements();


        for (Element element : elements) {
            if (!element.ownText().isEmpty()) {
                createPath(element, htmlElementParameters, false);
            }
        }

        return "input_other_file_path: " + this.foundOtherPath;
    }

    private HtmlElementParameters configHtmlElement(Document document, ParserContext parserContext) {
        String elementToFound = parserContext.getParameterToFound().getParameter();
        Element elementById = document.getElementById(elementToFound);

        if (elementById == null) {
            throw new ParserException("The target data does not exist.");
        }
        String href = document.getElementById(elementToFound).attr("href");
        String text = document.getElementById(elementToFound).text();
        String className = document.getElementById(elementToFound).className();
        String attributes = document.getElementById(elementToFound).attributes().toString();

        return new HtmlElementParameters(href, text, className, attributes);

    }

    private String createPath(Element element, HtmlElementParameters htmlElementParameters, boolean isOriginal) {

        String data = element.ownText();
        Elements parents = element.parents();

        StringBuilder path = new StringBuilder(element.nodeName());

        parents.forEach(el -> path.insert(0, el.nodeName() + '>'));

        new ArrayList<String>().add(path + " = " + data + "\n");

        if (data.equals(htmlElementParameters.getText())) {
            if (isOriginal) {
                return foundOriginalPath = path + "=" + data;
            } else {
                return foundOtherPath = path + "=" + data;
            }

        } else {
            return "No matches found";
        }

    }
}
