package com.openmind.ezdg.common;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Encoder {
    public static String encode(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (Exception e) {
            throw new RuntimeException("Encoding error", e);
        }
    }

    public static String encode(Number value){
        return encode(value.toString());
    }
}
