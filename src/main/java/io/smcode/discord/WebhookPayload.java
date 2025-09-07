package io.smcode.discord;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class WebhookPayload {
    private String content;
    private String username;
    private List<Embed> embeds;

    @Getter
    @Builder
    static class Embed {
        private String title;
        private String description;
        private List<Field> fields;
    }

    @Getter
    @Builder
    static class Field {
        private String name;
        private String value;
    }
}
