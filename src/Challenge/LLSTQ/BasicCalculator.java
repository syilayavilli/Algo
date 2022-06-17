package Challenge.LLSTQ;

// To implement a calculator

//Question: Basic Calculator
//        "4+6*3" = 22
//        "4-2+5" = 7
//        "6/2 +4" = 7

// what about 1 + (2 + 3) * 4

// digittruss algorithm   with two stacks
// ignore left  and when ssing right pop and compute

//Solution is use one stack
//Add operands with + and - as is and for * pop the previous and do the multiplication and save the result
//for  - save (-1)
//add all the items in the stack

//constraint to ask interviewer - parenthesis
//Power ^ ?
// whether within the bounds of int ?
// no divide zero ?

// There could be spaces - so we need to trim spaces

import java.util.Stack;

public class BasicCalculator {

//    public int calculate(String s) {
//
//        Stack<Integer> integerStack = new Stack<>();
//        s = s.trim();
//        int index = 0;
//        index = generateNumber(s, integerStack, index);
//
//        while(index < s.length()) {
//            index = performOperation(s, integerStack, index);
//        }
//
//        //calculate the final value by summing the stack
//        int finalValue;
//        while (integerStack.size() != 0) {
//            finalValue = finalValue + integerStack.pop();
//        }
//        return finalValue;
//    }
//
//    private int generateNumber(String s, Stack<Integer> integerStack, int index) {
//
//        int num = 0;
//
//        // 1+2345+2
//        while(index < s.length() && Character.isDigit(s.charAt(index))) {
//            num = 10 * num + Character.getNumericValue(s,charAt(index));
//            //1. 10*0+2 = 2
//            //2. 10*2+3 = 23
//            //3. 10*23+4 = 234
//
//            index++;
//
//        }
//        //push number to stack
//        integerStack.push(num);
//        return index;
//    }
//
//    private int performOperation(String s, Stack<Integer> integerStack, int index ) {
//        char opeartion = null;
//
//        while(!Character.isDigit(s.charAt(index))) {
//            if (s.charAt(index) != ' '){
//                operation = s.charAT(index);
//            }
//            index++;
//        }
//        index = generateNumber(s, integerStack, index);
//        operate(integerStack, operation);
//        return index;
//    }
//
//    private void operate() {
//
//        switch(operation) {
//
//            case '*' :
//
//
//        }
//    }
}
