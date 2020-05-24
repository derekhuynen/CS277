package DerekHuynen.Demo.InterfaceDemo;

public class InterfaceRunner {

    public static void main(String[] args) {
        //Have to make it an Automobile since I declared Geared Vehicle to be abstract.
        GearedVehicle tBone = new Automobile ("T-bone");
        System.out.println (tBone);
        GearedVehicle Terry = new Automobile ("Terry");
        System.out.println("tBone compared to Terry: " + tBone.compare(Terry));
        System.out.println("Trying to shift into really high gear:");
        try {
            tBone.changeGears(Gears.TWELTH);
        } catch (IllegalArgumentException IAE) {
            IAE.printStackTrace();
        }
        System.out.println("Creating a bicycle now.");
        Bicycle commuter = new Bicycle ("Commuter");
        commuter.changeGears(Gears.TWELTH);
        commuter.speedUp(20);
        System.out.println(commuter);
        System.out.println("Putting bicycle into park.");
        try {
            commuter.changeGears(Gears.PARK);
        } catch (IllegalArgumentException IAE) {
            IAE.printStackTrace();
        }
        System.out.println ("Completed satisfactorily.");
    }

}
