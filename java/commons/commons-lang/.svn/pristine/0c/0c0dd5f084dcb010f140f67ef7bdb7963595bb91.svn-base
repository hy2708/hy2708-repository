package org.hy.commons.lang.string;

import java.util.Map;

public class SimpleStringTemplateParser extends StringTemplateParser {

	/**
	 * Replaces named macros with context values.
	 * All declared properties are considered during value lookup.
	 */
	
	public String parse(String template, Map<String, Object> context) {
		return parse(template, createBeanMacroResolver(context));
	}

	/**
	 * Creates bean-backed <code>MacroResolver</code>.
	 */
	public static MacroResolver createBeanMacroResolver(final Map<String, Object> context) {
		return new MacroResolver() {
			public String resolve(String macroName) {
				Object value = context.get(macroName);

				if (value == null) {
					return null;
				}
				return value.toString();
			}
		};
	}
}