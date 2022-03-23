package com.github.koryu25.lifeworld.block;

public enum BlockType {
    FACILITY("施設"),
    RESOURCE("資源");

    private String label;

    BlockType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
