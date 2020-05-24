package DerekHuynen.Demo.InterfaceDemo;

/**
 * Simpler than the real Comparable interface since I am not using generics.
 * @author	David Brown
 * @date	07/10/2019
 */
public interface MyComparable extends WhatsMyName{
    /**
     * Since we know that MyComparable is also implementing WhatsMyName, we
     * can bank on a getName method.  That saves us from trying to access
     * member variables in this or the other instance of MyComparable.
     * @param Other
     * @return	Integer result of the compare.  < 0 if this < other,
     * 			0 if they are = and > 0 otherwise.  The comparison defaults
     * 			to ignoring the case.  If you don't like that, override it.
     */
    public default int compare (MyComparable Other) {
        return this.getName().compareToIgnoreCase(Other.getName());
    }
}
