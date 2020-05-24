package DerekHuynen.FinalReview.Decorator2;

public class TreeTopper extends TreeDecorator{

        public TreeTopper(ChristmasTree tree) {
            super(tree);
        }

        public String decorate() {
            return super.decorate() + decorateWithTreeTopper();
        }

        private String decorateWithTreeTopper() {
            return " with Tree Topper";
        }

        public double cost(){
            return super.cost() + 2;
        }
}
