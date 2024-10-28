package org.Control4;

public class Task3 {
    public static void main(String args[]){
        ArithmeticProgression ap = new ArithmeticProgression(1.0, 1.0);
        GeometricProgression gp = new GeometricProgression(2.0, 2.0);

        System.out.println(ap.SummaArProgression(4));
        System.out.println(gp.SummaGeomProgression(4));
    }
}

abstract class Progression{
    protected Double firstMember;
    Progression(Double firstMember){
        this.firstMember = firstMember;
    }
}

class ArithmeticProgression extends Progression{
    private Double constantDifference;

    ArithmeticProgression(Double firstMember, Double constantDifference){
        super(firstMember);
        this.constantDifference = constantDifference;
    }

    private Double CalculateNterm(Integer n){
        Double a = firstMember;
        for (int i = n-1; i > 0; i--){
            a += constantDifference;
        }
        return a;
    }

    public Double SummaArProgression(Integer n){
        return n*(firstMember + CalculateNterm(n))/2;
    }
}

class GeometricProgression extends Progression{
    private Double constantRatio;
    GeometricProgression(Double firstMember, Double constantRatio){
        super(firstMember);
        this.constantRatio = constantRatio;
    }

    private Double CalculateNterm(Integer n){
        Double a = firstMember;

        for (int i = n - 1; i > 0; i--) {
            a *= constantRatio;
        }
        return a;
    }

    public Double SummaGeomProgression(Integer n){
        return (firstMember - CalculateNterm(n)*constantRatio)/(1-constantRatio);
    }
}