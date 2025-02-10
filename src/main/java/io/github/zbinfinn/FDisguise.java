package io.github.zbinfinn;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class FDisguise {
    private final EntityType type;
    public FDisguise(Entity disguise) {
        type = disguise.getType();
    }
    public FDisguise(EntityType type) {
        this.type = type;
    }

    public void handle(WrapperPlayServerSpawnEntity packet) {
        packet.setEntityType(EntityTypes.getByName(type.name()));
    }
}
