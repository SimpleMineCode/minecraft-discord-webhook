package io.smcode.discord;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class Discord {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final String WEBHOOK_URL = "https://discord.com/api/webhooks/1414278223092519014/k4QEFoiXs95XC1i-FHQsx49EKmIVLHTqen64DZkaavUF4i_0qCLZ6mqxSkytNaobfOwk";

    public static void sendMessage(WebhookPayload payload) {
        try (final HttpClient client = HttpClient.newHttpClient()) {
            final String json = gson.toJson(payload);
            final HttpRequest request = HttpRequest.newBuilder()
                    .header("Content-Type", "application/json")
                    .uri(URI.create(WEBHOOK_URL))
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            System.out.println(json);

            final CompletableFuture<HttpResponse<String>> future = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

            future.thenAccept(response -> {
                System.out.println(response.statusCode());
            });
        }
    }
}
