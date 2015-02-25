package lock;

public class ComboLock {

    private final int one;

    private final int two;

    private final int three;

    /**
     * Basic lock constructor
     *
     * @param one
     *            The first combo number
     * @param two
     *            The second combo number
     * @param three
     *            The third combo number
     */
    public ComboLock(final int one, final int two, final int three) {
        this.one = one;
        this.two = two;
        this.three = three;
    }

    // Some getters to get all of the combo numbers.

    public int getOne() {
        return one;
    }

    public int getThree() {
        return three;
    }

    public int getTwo() {
        return two;
    }

}
