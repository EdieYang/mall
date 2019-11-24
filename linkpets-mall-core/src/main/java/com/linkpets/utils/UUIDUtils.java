package com.linkpets.utils;

import java.util.UUID;

/**
 * @author edie
 */
public class UUIDUtils {

    public static String getId() {
        return UUID.randomUUID().toString().replace("-","");
    }
}
