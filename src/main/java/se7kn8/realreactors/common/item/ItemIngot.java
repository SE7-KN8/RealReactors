package se7kn8.realreactors.common.item;

public class ItemIngot extends ItemMeta {

	public static final String[] SUBTYPES = new String[]{
			/* 0 */ "boron",
			/* 1 */ "boron_steel",
			/* 2 */ "chromium",
			/* 3 */ "chromium_steel",
			/* 4 */ "graphite",
			/* 5 */ "potassium",
			/* 6 */ "sodium",
			/* 7 */ "steel"};

	public ItemIngot() {
		super("ingot", SUBTYPES);
	}

}
