/*
 * Copyright 1997-2016 Optimatika (www.optimatika.se)
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
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.ojalgo.series;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.UUID;

import org.ojalgo.access.IndexMapper;
import org.ojalgo.function.UnaryFunction;
import org.ojalgo.netio.ASCII;
import org.ojalgo.series.primitive.DataSeries;
import org.ojalgo.type.ColourData;
import org.ojalgo.type.TypeUtils;

abstract class NewAbstractSeries<K extends Comparable<? super K>, V extends Number, I extends NewAbstractSeries<K, V, I>> extends AbstractMap<K, V>
        implements BasicSeries<K, V> {

    private ColourData myColour = null;
    private String myName = null;
    IndexMapper<K> indexMapper = null;

    @SuppressWarnings("unused")
    private NewAbstractSeries() {
        this(null);
    }

    NewAbstractSeries(final IndexMapper<K> indexMapper) {
        super();
        this.indexMapper = indexMapper;
    }

    @SuppressWarnings("unchecked")
    public I colour(final ColourData colour) {
        myColour = colour;
        return (I) this;
    }

    public final Comparator<? super K> comparator() {
        return null;
    }

    public V firstValue() {
        return this.get(this.firstKey());
    }

    public ColourData getColour() {
        if (myColour == null) {
            myColour = ColourData.random();
        }
        return myColour;
    }

    public DataSeries getDataSeries() {
        return DataSeries.wrap(this.getPrimitiveValues());
    }

    public String getName() {
        if (myName == null) {
            myName = UUID.randomUUID().toString();
        }
        return myName;
    }

    public double[] getPrimitiveValues() {

        final double[] retVal = new double[this.size()];

        int i = 0;
        for (final V tmpValue : this.values()) {
            retVal[i] = tmpValue.doubleValue();
            i++;
        }

        return retVal;
    }

    @Override
    public final I headMap(final K toKey) {
        return this.subMap(this.firstKey(), toKey);
    }

    public V lastValue() {
        return this.get(this.lastKey());
    }

    public void modifyAll(final UnaryFunction<V> function) {
        for (final Map.Entry<K, V> tmpEntry : this.entrySet()) {
            this.put(tmpEntry.getKey(), function.invoke(tmpEntry.getValue()));
        }
    }

    @SuppressWarnings("unchecked")
    public I name(final String name) {
        myName = name;
        return (I) this;
    }

    public abstract I subMap(final K fromKey, final K toKey);

    public final I tailMap(final K fromKey) {
        return this.subMap(fromKey, this.nextKey());
    }

    @Override
    public String toString() {

        final StringBuilder retVal = new StringBuilder();

        if (myName != null) {
            retVal.append(myName);
            retVal.append(ASCII.NBSP);
        }

        if (myColour != null) {
            retVal.append(TypeUtils.toHexString(myColour.getRGB()));
            retVal.append(ASCII.NBSP);
        }

        if (this.size() <= 30) {
            retVal.append(super.toString());
        } else {
            retVal.append("First:");
            retVal.append(this.firstKey());
            retVal.append(ASCII.EQUALS);
            retVal.append(this.firstValue());
            retVal.append(ASCII.NBSP);
            retVal.append("Last:");
            retVal.append(this.lastKey());
            retVal.append(ASCII.EQUALS);
            retVal.append(this.lastValue());
            retVal.append(ASCII.NBSP);
            retVal.append("Size:");
            retVal.append(this.size());
        }

        return retVal.toString();
    }

    void setColour(final ColourData colour) {
        this.colour(colour);
    }

    void setName(final String name) {
        this.name(name);
    }

}
