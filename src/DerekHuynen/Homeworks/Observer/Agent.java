/**
 * Agent Class
 * Homework Assignment: Observer
 *
 * @author Derek Huynen
 * @version 1.00 4/30/2020
 */
package DerekHuynen.Homeworks.Observer;

/**
 * Agent class that has the agents Name
 */
public class Agent implements Observer{

    /**
     * Name of the Agent
     */
    private String nameOfAgent;


    /**]
     * Agent Constructor
     * @param nameOfAgent name of the agent
     */
    public Agent(String nameOfAgent){
        this.nameOfAgent = nameOfAgent;
    }

    /**
     * Update the stock class
     * @param subject the stock being updated
     */
    @Override
    public void update(Subject subject) {

        System.out.printf("%s %s\n",this.toString(),((Stock) subject).getBid().toString());
    }

    /**
     * Return the agent class as a String
     * @return string version of an Agent
     */
    @Override
    public String toString() {
        return "Agent - Name: " + nameOfAgent + " alerted to";
    }


}

