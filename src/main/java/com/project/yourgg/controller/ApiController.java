package com.project.yourgg.controller;

import com.project.yourgg.service.RiotApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/your.gg/ko/kr")
public class ApiController {

	private final RiotApiService riotApiService;

	@Autowired
	public ApiController(RiotApiService riotApiService) {
		this.riotApiService = riotApiService;
	}

	@GetMapping("/profile/{searchName}")
	public Mono<String> findProfile(@PathVariable(name = "searchName") String searchName,
		Model model) {
		String[] nameParts = searchName.split("#");
		if (nameParts.length != 2) {
			return Mono.error(new IllegalArgumentException(
				"Invalid searchName format. Expected format: 'GameName#TagLine'"));
		}

		String gameName = nameParts[0];
		String tagLine = nameParts[1];

		// Riot ID로 PUUID 조회 -> 최근 MatchId 조회 -> 해당 매치 상세 조회
		return riotApiService.getPuuidByRiotId(gameName, tagLine)
			.flatMap(riotApiService::getMostRecentMatchIdByPuuid)
			.flatMap(riotApiService::getMatchDetails)
			.doOnNext(matchDetails -> {
				model.addAttribute("matchDetails", matchDetails);
			})
			.then(Mono.just("matchDetail"));
	}
}
