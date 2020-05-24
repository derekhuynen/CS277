package DerekHuynen.FinalReview.Decorator2;

public abstract class TreeDecorator implements ChristmasTree {
    private ChristmasTree tree;

    public TreeDecorator(ChristmasTree tree) {
        this.tree = tree;
    }

    @Override
    public double cost() {
        return tree.cost();
    }

    // standard constructors
    @Override
    public String decorate() {
        return tree.decorate();
    }
}
