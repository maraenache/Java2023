package lab2.bonus;

public abstract class Algorithm {

    protected Problem problem;

    public Algorithm(Problem problem) {
        this.problem = problem;
    }

    public abstract Solution solve();
}