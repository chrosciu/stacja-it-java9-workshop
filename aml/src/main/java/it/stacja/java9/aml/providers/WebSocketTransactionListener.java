package it.stacja.java9.aml.providers;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import jdk.incubator.http.WebSocket;

public class WebSocketTransactionListener implements WebSocket.Listener {

    @Override
    public CompletionStage<?> onText(WebSocket webSocket, CharSequence message, WebSocket.MessagePart part) {
        webSocket.request(1);
        System.out.println("Message from server: " + message);
        return CompletableFuture.completedFuture(message);
    }

}
