package org.spongycastle.cms;

import java.util.Map;
import org.spongycastle.asn1.cms.AttributeTable;

public class SimpleAttributeTableGenerator implements CMSAttributeTableGenerator {
    private final AttributeTable attributes;

    public SimpleAttributeTableGenerator(AttributeTable attributeTable) {
        this.attributes = attributeTable;
    }

    public AttributeTable getAttributes(Map map) {
        return this.attributes;
    }
}
