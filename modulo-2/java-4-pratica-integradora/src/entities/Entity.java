package entities;

import exceptions.EntityNotFoundException;

import java.util.Objects;
import java.util.UUID;

public abstract class Entity {
    private final UUID ID;

    public Entity() {
        this.ID = UUID.randomUUID();
    }

    public UUID getID() { return ID; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(ID, entity.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
