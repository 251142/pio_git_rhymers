package edu.kis.vh.nursery;

import edu.kis.vh.nursery.DefaultCountingOutRhymer;
import edu.kis.vh.nursery.HanoiRhymer;
import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.Rhymersfactory;

class RhymersDemo {

    public static final int MAX_ITERATIONS = 15;
    public static final int RHYMERS_LENGTH = 3;
    public static final String TOTAL_REJECTED_IS = "total rejected is ";

    public static void main(String[] args) {
        Rhymersfactory factory = new DefaultRhymersFactory();

        DefaultCountingOutRhymer[] rhymers = { factory.GetStandardRhymer(), factory.GetFalseRhymer(),
                factory.GetFIFORhymer(), factory.GetHanoiRhymer()};
        
        for (int i = 1; i < MAX_ITERATIONS; i++)
            for (int j = 0; j < RHYMERS_LENGTH; j++)
                rhymers[j].countIn(i);
        
        java.util.Random rn = new java.util.Random();
        for (int i = 1; i < MAX_ITERATIONS; i++)
            rhymers[3].countIn(rn.nextInt(20));
        
        for (int i = 0; i < rhymers.length; i++) {
            while (!rhymers[i].callCheck())
                System.out.print(rhymers[i].countOut() + "  ");
            System.out.println();
        }
        
        System.out.println(TOTAL_REJECTED_IS
                + ((HanoiRhymer) rhymers[3]).reportRejected());
        
    }
    
}