package com.github.koryu25.lifeworld.item;

public enum ItemType {
    RESOURCE("資源"),
    RESOURCE_BLOCK("資源ブロック"),
    TOOL("道具"),
    ARMOR("防具"),
    WEAPON("武器");

    private String label;

    ItemType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
