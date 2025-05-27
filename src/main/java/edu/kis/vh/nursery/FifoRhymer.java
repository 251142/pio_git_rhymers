package edu.kis.vh.nursery;

/**
 *  FifoRhymer is a variation of DefaultCountingOutRhymer
 *  that returns elements in a FIFO (First-In-First-Out) order.
 */
public class FifoRhymer extends DefaultCountingOutRhymer {

    public final DefaultCountingOutRhymer temp = new DefaultCountingOutRhymer();

    /**
     * Removes and returns the first inserted element in FIFO order.
     * Elements are temporarily moved to the helper stack to reverse the order,
     * and then restored.
     *
     * @return the oldest (first-inserted) value
     */
    @Override
    public int countOut() {
        while (!callCheck())

            temp.countIn(super.countOut());

        int ret = temp.countOut();

        while (!temp.callCheck())

            countIn(temp.countOut());

        return ret;
    }
}
