package com.project.yourgg.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerkStyle {
	private String description;
	private List<PerkStyleSelection> selections;
	private int style;
}
