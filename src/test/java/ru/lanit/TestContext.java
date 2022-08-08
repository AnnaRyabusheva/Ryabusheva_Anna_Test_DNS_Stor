package ru.lanit;

import java.util.HashMap;
import java.util.Map;

public class TestContext {
    private static TestContext instance;

    private Map<String, Object> map;

    private TestContext() {
        this.map = new HashMap<>();
    }

    public void addAttribute(String name, Object value) {
        map.put(name, value);
    }

    public Object getAttribute(String name) {
        return map.get(name);
    }

    public static TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }

    public static void cleanContext() {
        instance.map.clear();
        instance = null;
    }
}
