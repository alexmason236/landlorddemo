package model;

import lombok.Data;

@Data
public class Poker {

	private int id;

	private String name;

	private int num;

	public Poker(int id, String name, int num) {
		this.id = id;
		this.name = name;
		this.num = num;
	}
}
