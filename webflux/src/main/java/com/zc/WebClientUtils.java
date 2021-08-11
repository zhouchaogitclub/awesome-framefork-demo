package com.zc;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author yeyu
 * @since 2021/7/13 5:36 下午
 */
public final class WebClientUtils {
    public static void main(String[] args) {
        WebClient webClient = WebClient.create();
        Mono<String> mono = webClient.get().uri("https://www.baidu.com").retrieve().bodyToMono(String.class);
    }
}
