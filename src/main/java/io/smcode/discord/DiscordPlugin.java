package io.smcode.discord;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class DiscordPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        final List<WebhookPayload.Embed> embeds = List.of(WebhookPayload.Embed.builder()
                .title("My embed")
                .description("My description")
                .fields(List.of(
                        WebhookPayload.Field.builder()
                                .name("My field title")
                                .value("This is a very important message")
                                .build())
                )
                .build()
        );
        final WebhookPayload payload = WebhookPayload.builder()
                .content("Message content")
                .username("SMCode Bot")
                .embeds(embeds)
                .build();

        Discord.sendMessage(payload);
    }
}
