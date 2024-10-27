package com.project.yourgg.service;

import com.project.yourgg.dto.MatchDetails;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class RiotApiService {

	private final WebClient webClient;

	@Value("${RIOT_API_KEY}")
	private String apiKey;

	public RiotApiService(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("https://asia.api.riotgames.com")
			.defaultHeader("User-Agent", "Mozilla/5.0")
			.defaultHeader("Accept-Language", "ko,en;q=0.9,en-US;q=0.8,ko-KR;q=0.7")
			.defaultHeader("Accept-Charset", "application/x-www-form-urlencoded; charset=UTF-8")
			.defaultHeader("Origin", "https://developer.riotgames.com")
			.build();
	}

	public Mono<String> getPuuidByRiotId(String gameName, String tagLine) {

		String url = String.format("/riot/account/v1/accounts/by-riot-id/%s/%s", gameName,
			tagLine);

		return webClient.get()
			.uri(url)
			.header("X-Riot-Token", apiKey)
			.retrieve()
			.bodyToMono(String.class)
			.map(response -> new JSONObject(response).getString("puuid"));
	}

	public Mono<String> getMostRecentMatchIdByPuuid(String puuid) {
		String url = String.format("/lol/match/v5/matches/by-puuid/%s/ids?start=0&count=1", puuid);
		return webClient.get()
			.uri(url)
			.header("X-Riot-Token", apiKey)
			.retrieve()
			.bodyToMono(String[].class)
			.flatMap(matchIds -> matchIds.length > 0 ? Mono.just(matchIds[0])
				: Mono.error(new IllegalStateException("No matches found for the given PUUID.")));
	}

	public Mono<MatchDetails> getMatchDetails(String matchId) {
		String url = String.format("/lol/match/v5/matches/%s", matchId);
		return webClient.get()
			.uri(url)
			.header("X-Riot-Token", apiKey)
			.retrieve()
			.bodyToMono(MatchDetails.class);
	}
}
