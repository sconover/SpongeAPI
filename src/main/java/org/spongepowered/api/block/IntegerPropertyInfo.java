package org.spongepowered.api.block;

import com.google.common.collect.ImmutableList;
import java.util.List;

public class IntegerPropertyInfo implements PropertyInfo<Integer> {
  private final String name;
  private final int defaultValue;
  private final List<Integer> allowedValues;

  public IntegerPropertyInfo(String name, int defaultValue, List<Integer> allowedValues) {
    this.name = name;
    this.defaultValue = defaultValue;
    this.allowedValues = ImmutableList.copyOf(allowedValues);
  }

  @Override public String getName() {
    return name;
  }

  @Override public Integer getDefaultValue() {
    return defaultValue;
  }

  @Override public List<Integer> getAllowedValues() {
    return allowedValues;
  }
}
