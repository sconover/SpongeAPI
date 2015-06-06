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
package org.spongepowered.api.data.manipulator.entity;

import org.spongepowered.api.data.DataManipulator;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.entity.living.Living;

/**
 * Represents the health information for a {@link Living} entity.
 */
public interface HealthData extends DataManipulator<HealthData> {

    /**
     * Returns the health amount.
     *
     * <p>The range of the health depends on the object on which this
     * method is defined. For players in Minecraft, the nominal range is
     * between 0 and 20, inclusive, but the range can be adjusted.</p>
     *
     * <p>Convention dictates that health does not follow below 0 but this
     * convention may be broken.</p>
     *
     * @return Health value
     */
    HealthValue getHealth();

    /**
     * Gets the current maximum health.
     *
     * <p>The maximum health set here may affect the attribute increasing
     * health points. The base health should be minded that it may be lower
     * than the total maximum health of this entity.</p>
     *
     * @return This entities maximum health
     */
    Value<Double, HealthData> getMaxHealth();

    interface HealthValue extends Value<Double, HealthData> {

        HealthData damage(double amount);

    }

}
