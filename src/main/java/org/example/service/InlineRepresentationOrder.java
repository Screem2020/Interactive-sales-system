package org.example.service;

import java.util.List;

public class InlineRepresentationOrder {

    public void representationString(List<String> strings) {
        int index = -1;
        while (++index < strings.size()) {
            System.out.print(strings.get(index));
        }
    }
}
