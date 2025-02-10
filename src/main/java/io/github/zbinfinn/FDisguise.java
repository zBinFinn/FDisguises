package io.github.zbinfinn;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnLivingEntity;
import org.bukkit.entity.Entity;

public class FDisguise {
    private final Entity disguise;
    public FDisguise(Entity disguise) {
        this.disguise = disguise;
    }

    public void handle(WrapperPlayServerSpawnLivingEntity packet) {
        packet.setEntityType(EntityTypes.getByName(disguise.getType().toString()));
    }
}
