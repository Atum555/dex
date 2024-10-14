package com.dexproject.util;

import java.security.InvalidParameterException;

public record Range(int start, int end) {
    public Range {
        if (end <= start) throw new InvalidParameterException("End must be larger than start");
    }

    public int delta() {
        return end - start;
    }

    @Override
    public String toString() {
        return "Range{" + start + ", " + end + '}';
    }
}
