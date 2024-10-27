package com.project.yourgg.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Metadata {
	private String dataVersion;
	private String matchId;
	private List<String> participants;
}
