package ua.nure.parser.infrastructure;

import ua.nure.parser.Query;
import ua.nure.parser.Result;


/**
 * Base interface parser implementations.
 *
 * @param <R>
 *         a result of reader work
 * @param <Q>
 *         a query that contain necessary information to read.
 */

public interface ParserHandler <R extends Result, Q extends Query>{

    /**
     * Finds the target element with similar attributes.
     *
     * @param context
     *         a object that wrap query parameters
     * @return the {@code Reader} that contains read data
     */
    R findTargetElement(Q context);
}

