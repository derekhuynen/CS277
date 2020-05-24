package DerekHuynen.FinalReview.Decorator2;

public class Runner {
    public static void main(String[] args) {


        ChristmasTree tree1 = new BubbleLights(new ChristmasTreeImpl());



        System.out.println(tree1.decorate());

        ChristmasTree tree2 = new TreeTopper(tree1);
        System.out.println(tree2.decorate());
        System.out.println("Cost: " +  tree2.cost());

    }
}
