package se7kn8.realreactors.common.util;

import javax.annotation.Nonnull;

public class StringHelper {

	public static String capitalizeFirstLetter(@Nonnull String original) {
		return original.length() == 0 ? original : original.substring(0, 1).toUpperCase() + original.substring(1);
	}

}
