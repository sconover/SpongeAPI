package org.spongepowered.api.block;

import com.google.common.collect.ImmutableList;
import java.util.List;

public class BlockMetadata {
  private final BlockType blockType;
  private final List<PropertyInfo> propertyInfos;

  public BlockMetadata(
      BlockType blockType,
      List<PropertyInfo> propertyInfos) {
    this.blockType = blockType;
    this.propertyInfos = ImmutableList.copyOf(propertyInfos);
  }

  public BlockType getType() {
    return blockType;
  }

  public List<PropertyInfo> getPropertyInfos() {
    return propertyInfos;
  }
}
