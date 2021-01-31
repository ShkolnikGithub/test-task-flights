package com.gridnine.testing.filter;

import java.util.ArrayList;
import java.util.List;

public interface Filter<T> {

    List<T> filter(List<T> list);

    default List<T> dynamicFilter(List<T> listT, List<Filter> listFilters) {
        List<T> result = new ArrayList<T>(listT);

        for (Filter filter : listFilters) {
            result = filter.filter(result);
        }

        return result;
    }
}
