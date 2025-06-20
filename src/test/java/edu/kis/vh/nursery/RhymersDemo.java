package edu.kis.vh.nursery;

import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.RhymersFactory;

class RhymersDemo {

    public static final int MAX_ITERATIONS = 15;
    public static final int RHYMERS_LENGTH = 3;
    public static final String TOTAL_REJECTED_IS = "total rejected is ";

    public static void main(String[] args) {
        RhymersFactory factory = new DefaultRhymersFactory();
        testRhymers(factory);
    }

    private static void testRhymers(RhymersFactory factory) {
        DefaultCountingOutRhymer[] rhymers = { 
            factory.getStandardRhymer(),
            factory.getFalseRhymer(),
            factory.getFIFORhymer(),
            factory.getHanoiRhymer()
        };

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

        System.out.println(TOTAL_REJECTED_IS + ((HanoiRhymer) rhymers[3]).reportRejected());
    }
}
