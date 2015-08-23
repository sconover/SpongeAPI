package org.spongepowered.api.entity.living.animal;

public interface CanBeOwned {
  void setOwnerId(String id);
  String getOwnerId();
}
