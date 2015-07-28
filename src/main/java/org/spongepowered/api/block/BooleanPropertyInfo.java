package org.spongepowered.api.block;

import com.google.common.collect.Lists;
import java.util.List;

public class BooleanPropertyInfo implements PropertyInfo<Boolean> {
  private final String name;
  private final boolean defaultValue;

  public BooleanPropertyInfo(String name, boolean defaultValue) {
    this.name = name;
    this.defaultValue = defaultValue;
  }

  @Override public String getName() {
    return name;
  }

  @Override public Boolean getDefaultValue() {
    return defaultValue;
  }

  @Override public List<Boolean> getAllowedValues() {
    return Lists.newArrayList(true, false);
  }
}
