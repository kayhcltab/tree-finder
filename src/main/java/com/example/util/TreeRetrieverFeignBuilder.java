package com.example.util;

import org.springframework.stereotype.Component;

import com.example.client.TreeRetrievalClient;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.Getter;

/**
 * This class defines the feign client builder for {@link TreeRetrievalClient}
 * 
 * @author KP
 *
 */
@Getter
@Component
public class TreeRetrieverFeignBuilder {
	private TreeRetrievalClient treeClient = createClient(TreeRetrievalClient.class,
			"https://data.cityofnewyork.us/resource/nwxe-4ae8.json");

	private static <T> T createClient(Class<T> type, String uri) {
		return Feign.builder().client(new OkHttpClient()).encoder(new GsonEncoder()).decoder(new GsonDecoder())
				.logger(new Slf4jLogger(type)).logLevel(Logger.Level.FULL).target(type, uri);
	}
}
