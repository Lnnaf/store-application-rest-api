package vn.lyn.store.application.Enum;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum ProductItemModelType {
    SUV("adadad"),
    ABC("");

    private final String value;

    ProductItemModelType(final String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
