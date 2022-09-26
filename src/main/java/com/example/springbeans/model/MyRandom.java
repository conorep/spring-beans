package com.example.springbeans.model;

import org.springframework.stereotype.Component;

import java.util.Random;

//I want this class to be a spring bean (auto-instantiated and available throughout my spring app)
@Component
public class MyRandom implements IMyRandom
{
    private Random random;
    private long seed;

    public MyRandom()
    {
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }

    @Override
    public double nextNumber()
    {
        return random.nextDouble();
    }

    @Override
    public int between(int low, int high)
    {
        return low + random.nextInt(high - low + 1);
    }
}
