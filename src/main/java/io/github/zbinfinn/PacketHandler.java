package io.github.zbinfinn;

import com.github.retrooper.packetevents.event.PacketListener;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.event.PacketSendEvent;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.protocol.packettype.PacketTypeCommon;
import com.github.retrooper.packetevents.protocol.player.User;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnEntity;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnLivingEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PacketHandler implements PacketListener {
    @Override
    public void onPacketReceive(PacketReceiveEvent event) {

    }

    @Override
    public void onPacketSend(PacketSendEvent event) {
        User user = event.getUser();
        PacketTypeCommon type = event.getPacketType();
        List<PacketType.Play.Server> types = List.of(
                PacketType.Play.Server.ENTITY_RELATIVE_MOVE_AND_ROTATION,
                PacketType.Play.Server.ENTITY_HEAD_LOOK,
                PacketType.Play.Server.ENTITY_VELOCITY,
                PacketType.Play.Server.ENTITY_RELATIVE_MOVE,
                PacketType.Play.Server.ENTITY_POSITION_SYNC,
                PacketType.Play.Server.UPDATE_ATTRIBUTES,
                PacketType.Play.Server.ENTITY_ROTATION,
                PacketType.Play.Server.DESTROY_ENTITIES,
                PacketType.Play.Server.TIME_UPDATE,
                PacketType.Play.Server.ENTITY_METADATA,
                PacketType.Play.Server.BUNDLE,
                PacketType.Play.Server.MULTI_BLOCK_CHANGE,
                PacketType.Play.Server.EFFECT,
                PacketType.Play.Server.BLOCK_CHANGE,
                PacketType.Play.Server.PLAYER_INFO_UPDATE,
                PacketType.Play.Server.ENTITY_STATUS,
                PacketType.Play.Server.ENTITY_EQUIPMENT,
                PacketType.Play.Server.KEEP_ALIVE,
                PacketType.Play.Server.SOUND_EFFECT
        );
        if (types.contains(type)) {
            return;
        }

        if (event.getPacketType() == PacketType.Play.Server.SPAWN_ENTITY) {
            handleSpawnEntity(event);
        }
        System.out.printf("Packet Sent: %s\n", event.getPacketType().getName());
    }

    private void handleSpawnEntity(PacketSendEvent event) {
        WrapperPlayServerSpawnEntity packet = new WrapperPlayServerSpawnEntity(event);
        if (packet.getUUID().isEmpty()) return;
        for (UUID uuid : FDisguisesAPI.getDisguises().keySet()) System.out.println(uuid);
        System.out.println(packet.getUUID().get());
        if (!FDisguisesAPI.getDisguises().containsKey(packet.getUUID().get())) {
            return;
        }
        System.out.println("Actually reached");
        FDisguisesAPI.getDisguises().get(packet.getUUID().get()).handle(packet);

    }
}
