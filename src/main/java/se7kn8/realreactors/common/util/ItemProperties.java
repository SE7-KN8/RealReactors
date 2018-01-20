package se7kn8.realreactors.common.util;

public class ItemProperties {

	public enum IngotTypes {

		BORON(0, "boron"),
		BORON_STEEL(1, "boron_steel"),
		CHROMIUM(2, "chromium"),
		CHROMIUM_STEEL(3, "chromium_steel"),
		GRAPHITE(4, "graphite"),
		POTASSIUM(5, "potassium"),
		SODIUM(6, "potassium"),
		STEEL(7, "steel");

		private final int meta;
		private final String name;

		IngotTypes(int meta, String name) {
			this.meta = meta;
			this.name = name;
		}

		public int getMeta() {
			return meta;
		}

		public String getName() {
			return name;
		}

		public static IngotTypes byMetadata(int meta) {
			for (IngotTypes typ : IngotTypes.values()) {
				if (typ.getMeta() == meta) {
					return typ;
				}
			}

			return STEEL;
		}

	}

}
