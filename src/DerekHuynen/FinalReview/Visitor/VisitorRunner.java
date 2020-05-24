package DerekHuynen.FinalReview.Visitor;

public class VisitorRunner {
    public static void main(String[] args) {

        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}
