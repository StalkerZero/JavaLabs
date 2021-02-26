package ru.StalkerNidus.Static;


public class MathUtil {
    public static QuadraticEquationRoot calculateQuadraticEquation(QuadraticEquation equation){
        QuadraticEquationRoot answer;
        double d = Math.pow(equation.getB(), 2) - 4 * equation.getA() * equation.getC();
        if(d<0){
            answer = new QuadraticEquationRoot(0, 0, 0);
            return answer;
        }
        double x1 = (-equation.getB()+Math.sqrt(d))/(2* equation.getA());
        double x2 = (-equation.getB()-Math.sqrt(d))/(2* equation.getA());
        if(x1==x2) answer = new QuadraticEquationRoot(x1, 0, 1);
        else answer = new QuadraticEquationRoot(x1, x2, 2);
        return answer;
    }
}
