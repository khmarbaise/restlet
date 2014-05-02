package com.soebes.training.domain;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Parts {

    private Map<String, Part> parts;
    
    public Parts() {
	parts = new ConcurrentHashMap<String, Part>();
    }

    public Map<String, Part> getParts() {
        return parts;
    }

    public void setParts(Map<String, Part> parts) {
        this.parts = parts;
    }
    
    
}
