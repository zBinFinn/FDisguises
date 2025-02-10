package io.github.zbinfinn;

import com.github.retrooper.packetevents.event.PacketListener;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.event.PacketSendEvent;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.protocol.player.User;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnLivingEntity;

public class PacketHandler implements PacketListener {
    @Override
    public void onPacketReceive(PacketReceiveEvent event) {

    }

    @Override
    public void onPacketSend(PacketSendEvent event) {
        User user = event.getUser();
        if (event.getPacketType() == PacketType.Play.Server.SPAWN_LIVING_ENTITY) {
            handleSpawnLivingEntity(event);
        }
    }

    private void handleSpawnLivingEntity(PacketSendEvent event) {
        WrapperPlayServerSpawnLivingEntity packet = new WrapperPlayServerSpawnLivingEntity(event);
        if (!FDisguisesAPI.getDisguises().containsKey(packet.getEntityUUID())) {
            return;
        }

        FDisguisesAPI.getDisguises().get(packet.getEntityUUID()).handle(packet);

        packet.setEntityType(EntityTypes.BAMBOO_RAFT);
    }
}
