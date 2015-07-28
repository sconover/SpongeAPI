package org.spongepowered.api.block;

import com.google.common.collect.ImmutableList;
import java.util.List;

public class EnumPropertyInfo implements PropertyInfo<String> {
  private final String name;
  private final String defaultValue;
  private final List<String> allowedValues;

  public EnumPropertyInfo(String name, String defaultValue,
      List<String> allowedValues) {
    this.name = name;
    this.defaultValue = defaultValue;
    this.allowedValues = ImmutableList.copyOf(allowedValues);
  }

  @Override public String getName() {
    return name;
  }

  @Override public String getDefaultValue() {
    return defaultValue;
  }

  @Override public List<String> getAllowedValues() {
    return allowedValues;
  }
}
