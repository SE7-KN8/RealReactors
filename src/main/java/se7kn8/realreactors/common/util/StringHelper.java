package se7kn8.realreactors.common.util;

import com.google.common.base.CaseFormat;

import javax.annotation.Nonnull;

public class StringHelper {

	public static String makeOreDictString(@Nonnull String original) {
		original = original.length() == 0 ? original : original.substring(0, 1).toUpperCase() + CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, original.substring(1));
		return original;
	}
}
