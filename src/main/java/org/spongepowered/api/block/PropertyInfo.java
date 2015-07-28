package org.spongepowered.api.block;

import java.util.List;

public interface PropertyInfo<T> {
  public String getName();
  public T getDefaultValue();
  public List<T> getAllowedValues();
}
