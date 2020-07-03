package ua.nure.parser.infrastructure.reader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import ua.nure.parser.ParserException;

import java.io.IOException;

public final class UrlReader implements DataReader {

    @Override
    public Document fetchData(String url) {

        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new ParserException("Cannot read the document by URL");
        }
        return document;
    }

}
