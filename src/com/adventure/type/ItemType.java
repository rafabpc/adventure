package com.adventure.type;

public enum ItemType {

	LIFE_POTION("BI1", "Life Potion"), 
	BAG_EXPANDER("BI2", "Bag Expander"), 
	ESCAPE("BI3", "Escape");

	private String id;
	private String descricao;

	private ItemType(String id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public String getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getDescricaoById(String id) {
		if (id.equals(LIFE_POTION.getId())) {
			return LIFE_POTION.getDescricao();
		}
		if (id.equals(BAG_EXPANDER.getId())) {
			return BAG_EXPANDER.getDescricao();
		}
		if (id.equals(ESCAPE.getId())) {
			return ESCAPE.getDescricao();
		}
		return null;
	}

}
