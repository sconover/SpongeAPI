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
package org.spongepowered.api.world.extent;

import com.flowpowered.math.matrix.Matrix4d;
import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.util.PositionOutOfBoundsException;

/**
 * A volume containing blocks that can be accessed and modified.
 *
 * @see BlockVolume
 */
public interface MutableBlockVolume extends BlockVolume {

    /**
     * Replace the block at this position by a new type.
     *
     * <p>This will remove any extended block data at the given position.</p>
     *
     * @param position The position of the block
     * @param type The new type
     * @throws PositionOutOfBoundsException If the position is outside of the
     *     bounds of the area
     */
    void setBlockType(Vector3i position, BlockType type);

    /**
     * Replace the block at this position by a new type.
     *
     * <p>This will remove any extended block data at the given position.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param type The new type
     * @throws PositionOutOfBoundsException If the position is outside of the
     *     bounds of the area
     */
    void setBlockType(int x, int y, int z, BlockType type);

    /**
     * Returns a new volume that is the same or smaller than the current area.
     * This does not copy the blocks, it only provides a new view of the
     * storage.
     *
     * @param newMin The new minimum coordinates in this volume
     * @param newMax The new maximum coordinates in this volume
     * @return The new volume with the new bounds
     * @throws PositionOutOfBoundsException If the new minimum and maximum
     *     are outside the current volume
     */
    MutableBlockVolume getBlockView(Vector3i newMin, Vector3i newMax);

    /**
     * Returns a new volume that is viewed through some transformation.
     * This does not copy the blocks, it only provides a new view of the
     * storage.
     *
     * @param transform The transformation to be applied, encoded in a matrix.
     *     A 4D matrix is used so that translations can be included in it.
     * @return The new volume with the transform
     */
    MutableBlockVolume getBlockView(Matrix4d transform);

    /**
     * Returns a new volume that is translated so that
     * {@link BlockVolume#getBlockMin()} returns {@link Vector3i#ZERO}.
     * This does not copy the blocks, it only provides a new view of the
     * storage.
     *
     * @return The new volume with its minimum at zero
     */
    MutableBlockVolume getRelativeBlockView();

    /**
     * Returns a new volume that cannot be modified through this view. Unlike
     * immutable storage, it can be changed by holders of mutable views.
     * This does not copy the blocks, it only provides a new view of the
     * storage.
     *
     * @return The new volume, which cannot be modified
     */
    UnmodifiableBlockVolume getUnmodifiableBlockView();

}
