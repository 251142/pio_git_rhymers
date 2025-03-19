package edu.kis.vh.nursery.factory;

import edu.kis.vh.nursery.DefaultCountingOutRhymer;

    public interface Rhymersfactory {
    
        public DefaultCountingOutRhymer GetStandardRhymer();
        
        public DefaultCountingOutRhymer GetFalseRhymer();
        
        public DefaultCountingOutRhymer GetFifoRhymer();
        
        public DefaultCountingOutRhymer GetHanoiRhymer();
        
    }
