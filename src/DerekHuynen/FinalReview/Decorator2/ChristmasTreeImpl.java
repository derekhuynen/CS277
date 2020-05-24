package DerekHuynen.FinalReview.Decorator2;

public class ChristmasTreeImpl implements ChristmasTree {

    @Override
    public String decorate() {
        return "Christmas tree";
    }

    @Override
    public double cost() {
        return 1;
    }
}
