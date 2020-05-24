/**
 * Person Caretaker Class
 * Homework Assignment: Memento
 *
 * @author Derek Huynen
 * @date 4/09/2020
 * @version 1.00
 */

package DerekHuynen.Homeworks.Momento;

import java.io.*;


public class PersonCaretaker implements Serializable
{
    private String fileName;
    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;
    int counter = 0; // to count number of Objects in Binary File

    private ObjectOutputStream outputStream; //Not sure if we need
    private ObjectInputStream inputStream; // Not sure if we need


    public PersonCaretaker(String fileName ){
        this.fileName = fileName;
        try{
            this.fileOutputStream = new FileOutputStream(fileName);
            this.outputStream = new ObjectOutputStream(fileOutputStream);

            this.fileInputStream = new FileInputStream(fileName);
            this.inputStream = new ObjectInputStream(fileInputStream);

        }catch(IOException i)
        {
            i.printStackTrace();
        }
    }

    /**
     * Write to Binary Output File
     * @param saveState of the current person
     */
    public void addMemento(PersonMemento saveState)
    {
        try{
            outputStream.writeObject(saveState);
            counter += 1;
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Search the Binary File and return the person with the Lowest Weight
     * @return PersonMemento with smallest weight.
     */
    public PersonMemento getMemento()
    {
        PersonMemento result = null;

        try{
            PersonMemento find;
            outputStream.close();
            fileOutputStream.close();


            this.inputStream = new ObjectInputStream(new FileInputStream(fileName));
            result = (PersonMemento) this.inputStream.readObject();

            try{
                for ( int i = 1; i < counter; i++ ) {
                    find = (PersonMemento) inputStream.readObject();

                    if (find.getSavedPerson().getWeightPounds() < result.getSavedPerson().getWeightPounds()) {
                        result = find;
                    }
                }
                inputStream.close();
            }catch (IOException e ){
                e.printStackTrace();
            }
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
    }
        return result;
    }


    /**
     *
     * So I had a very hard time looping through the file so This is my hacked version using a counter
     *
     * Loop through Binary file and Search each object for person with the same weight
     * @param index the weight you are looking for
     * @return PersonMemento with weight equal to
     */
    public PersonMemento getMemento(int index) {


        boolean found = false;
        int count = 0;
        PersonMemento temp = null;

        try{
            PersonMemento find;
            outputStream.close();
            fileOutputStream.close();

            this.inputStream = new ObjectInputStream(new FileInputStream(fileName));

            try{
                while (count < this.counter && !found ) {
                    find = (PersonMemento) inputStream.readObject();
                    if (find.getSavedPerson().getWeightPounds() == index) {
                        temp = find;
                        found = true;
                    }
                    count += 1;
                }
                inputStream.close();
            }catch (IOException e ){
                //
            }
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return temp;
    }

} // End of the PersonCaretaker Class