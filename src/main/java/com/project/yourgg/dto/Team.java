package com.project.yourgg.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Team {
	private List<Ban> bans;
	private Objectives objectives;
	private int teamId;
	private boolean win;
}
