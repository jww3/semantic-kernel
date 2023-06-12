// Copyright (c) Microsoft. All rights reserved.
package com.microsoft.semantickernel.chatcompletion;

import javax.annotation.Nullable;

import com.azure.ai.openai.OpenAIAsyncClient;

import reactor.core.publisher.Mono;

public interface ChatCompletion<ChatHistoryType extends ChatHistory> {
    /**
     * Generate a new chat message
     *
     * @param chat            Chat history
     * @param requestSettings AI request settings
     * @return Generated chat message in string format
     */
    Mono<String> generateMessageAsync(
            ChatHistoryType chat, @Nullable ChatRequestSettings requestSettings);

    /**
     * Create a new empty chat instance
     *
     * @param instructions Optional chat instructions for the AI service
     * @return Chat object
     */
    ChatHistoryType createNewChat(@Nullable String instructions);

    interface Builder {
        ChatCompletion<? extends ChatHistory> build(OpenAIAsyncClient client, String modelId);
    }
}