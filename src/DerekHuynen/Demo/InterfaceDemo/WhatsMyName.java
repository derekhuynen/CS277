package DerekHuynen.Demo.InterfaceDemo;

/**
 * Demonstration interface for a named object.  Losts of classes need a name of some sort,
 * so we might as well make an interface for it.
 * @author David Brown
 * @date	07/10/2019
 *
 */
public interface WhatsMyName {
    /**
     * Give the object a new name.
     * @param newName	The new name of the object.
     */
    public void setName (String newName);
    /**
     * Get the current name of the object.
     * @return	The Current name of the object.
     */
    public String getName ();

}
