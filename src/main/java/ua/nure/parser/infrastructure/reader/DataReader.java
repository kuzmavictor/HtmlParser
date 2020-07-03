package ua.nure.parser.infrastructure.reader;

import org.jsoup.nodes.Document;

public interface DataReader{

    Document fetchData(String url);
}
