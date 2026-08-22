package org.example.flyweightpattern;

import java.util.HashMap;
import java.util.Map;

public class TreeTypeFactory {

    private static final Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + color + texture;

        if (!treeTypes.containsKey(key)) {
            treeTypes.put(
                    key,
                    new TreeType(name, color, texture)
            );
        }

        return treeTypes.get(key);
    }
}
