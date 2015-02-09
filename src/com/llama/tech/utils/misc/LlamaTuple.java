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