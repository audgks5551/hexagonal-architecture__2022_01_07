package io.mhan.domain;

import java.util.UUID;

public class RouterId {
    private final UUID id;

    public RouterId(UUID id) {
        this.id = id;
    }

    public static RouterId of(String id) {
        return new RouterId(UUID.fromString(id));
    }

    @Override
    public String toString() {
        return "RouterId{" +
                "id=" + id +
                '}';
    }
}
