package com.triple.point.controller;

import java.util.UUID;

public class UUIDConverter {
    public static UUID convertFromString(String uuidString) {
        String convertStr = uuidString.replaceAll("-", "");
        return UUID.fromString (convertStr
                .replaceFirst (
                        "(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)",
                        "$1-$2-$3-$4-$5"
                )
        );
    }
}
