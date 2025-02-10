package io.github.zbinfinn;

import org.bukkit.entity.Entity;

import java.util.HashMap;
import java.util.UUID;

public class FDisguisesAPI {
    private static final HashMap<UUID, FDisguise> disguises = new HashMap<>();
    public static void disguise(UUID target, FDisguise disguise) {
        disguises.put(target, disguise);
    }
    public static void disguise(Entity target, FDisguise disguise) {
        disguise(target.getUniqueId(), disguise);
    }
    public static void disguise(Entity target, Entity disguise) {
        disguise(target.getUniqueId(), new FDisguise(disguise));
    }

    public static HashMap<UUID, FDisguise> getDisguises() {
        return disguises;
    }

}
