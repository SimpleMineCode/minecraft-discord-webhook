package io.smcode.discord;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Builder
public class WebhookPayload {
    private String content;
    private String username;
    private List<Embed> embeds;

    @Builder
    static class Embed {
        private String title;
        private String description;
        private List<Field> fields;
        private Author author;
    }

    @Builder
    static class Field {
        private String name;
        private String value;
    }

    @RequiredArgsConstructor (access = AccessLevel.PRIVATE)
    static class Author {
        private final String name;

        public static Author of(String name) {
            return new Author(name);
        }
    }
}
