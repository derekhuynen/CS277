package DerekHuynen.FinalReview.Decorator2;

public class BubbleLights extends TreeDecorator {

    public BubbleLights(ChristmasTree tree) {
        super(tree);
    }

    public String decorate() {
        return super.decorate() + decorateWithBubbleLights();
    }

    public double cost(){
        return super.cost() + 2;
    }

    private String decorateWithBubbleLights() {
        return " with Bubble Lights";
    }
}
