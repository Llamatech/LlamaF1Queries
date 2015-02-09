/*
 * LlamaTuple.java
 * This file is part of LlamaUtils
 *
 * Copyright (C) 2015 - LlamaTech Team 
 *
 * LlamaUtils is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * LlamaUtils is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with LlamaUtils. If not, see <http://www.gnu.org/licenses/>.
 */

package com.llama.tech.utils.misc;

public class LlamaTuple<X, Y> 
{ 
    public final X x; 
    public final Y y; 
    public LlamaTuple(X x, Y y) 
    { 
        this.x = x; 
        this.y = y; 
    }

    @Override
    public String toString() 
    {
        return "(" + x + "," + y + ")";
    }

    @Override
    public boolean equals(Object other) 
    {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof LlamaTuple)){
            return false;
        }
        LlamaTuple<X,Y> other_ = ((LlamaTuple<X,Y>) other);
        return other_.x == this.x && other_.y == this.y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((x == null) ? 0 : x.hashCode());
        result = prime * result + ((y == null) ? 0 : y.hashCode());
        return result;
    }
}