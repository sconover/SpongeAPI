/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.block;

import org.spongepowered.api.data.DataManipulator;
import org.spongepowered.api.data.ImmutableDataHolder;

/**
 * Represents a block using {@link BlockType} and a list of
 * {@link DataManipulator} instances.
 *
 * <p>States are instances of {@link ImmutableDataHolder}s and therefor once
 * created, cannot be changed. All retrievals of {@link DataManipulator}s are
 * copies.</p>
 */
public interface BlockState extends ImmutableDataHolder<BlockState> {

    /**
     * Get the base type of block.
     *
     * <p>The type does not include block data such as the contents of
     * inventories.</p>
     *
     * @return The type of block
     */
    BlockType getType();

    /**
     * Set a property that has an enumerated type as the value, to the enum
     * value corresponding to the ordinal.
     *
     * This only exists to support legacy data access methods, please do not use
     * this unless it's because you are forced to maintain backward compatibility.
     *
     * @deprecated
     *
     * @param propertyName - the name of a property that has an enum value
     * @param ordinal - the ordinal of some enum value, such as dye color lime.
     * @return a new BlockState, with the property set
     */
    BlockState withPropertyEnumOrdinal(String propertyName, int ordinal);

    /**
     * For a property that has an enumerated type as the value, check whether the given
     * ordinal corresponds to a valid enum value.
     *
     * This only exists to support legacy data access methods, please do not use
     * this unless it's because you are forced to maintain backward compatibility.
     *
     * @param propertyName - the name of a property that has an enum value
     * @param ordinal - the ordinal of the enum value
     * @return whether the ordinal corresponds to a valid enum value
     */
    boolean isEnumOrdinalValid(String propertyName, int ordinal);

    /**
     * For a property that has an enumerated type as the value, return the enum ordinal for
     * its enum value
     *
     * This only exists to support legacy data access methods, please do not use
     * this unless it's because you are forced to maintain backward compatibility.
     *
     * @deprecated
     *
     * @param propertyName - the name of a property that has an enum value
     * @return the ordinal of the enum value
     */
    int getPropertyEnumOrdinalValue(String propertyName);

    /**
     * Determine whether a block has a property, and that property has an enum value.
     *
     * This only exists to support legacy data access methods, please do not use
     * this unless it's because you are forced to maintain backward compatibility.
     *
     * @deprecated
     *
     * @param propertyName - the name of a property that has an enum value
     * @return whether or not this block has the property
     */
    boolean hasPropertyEnum(String propertyName);

    BlockMetadata getMetadata();
}
