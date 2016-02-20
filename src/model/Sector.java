package model;

public class Sector {
	private int id;
	private String name;
	private int parent_id;

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParent_sector_id() {
		return parent_sector_id;
	}

	public void setParent_sector_id(int parent_sector_id) {
		this.parent_sector_id = parent_sector_id;
	}

	private int parent_sector_id;
}