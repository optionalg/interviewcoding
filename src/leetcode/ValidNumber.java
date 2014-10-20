package leetcode;

interface State
{
    boolean isValid();
    State readSpace();
    State readDigit();
    State readPlus();
    State readMinus();
    State readPoint();
    State readE();
    State readEnd();
}

abstract class AbstractState implements State
{
    @Override
    public boolean isValid() {
        return true;
    }
    
    @Override
    public State readSpace() {
        return new ErrorState();
    }
    
    @Override
    public State readDigit() {
        return new ErrorState();
    }

    @Override
    public State readPlus() {
        return new ErrorState();
    }
    
    @Override
    public State readMinus() {
        return new ErrorState();
    }

    @Override
    public State readPoint() {
        return new ErrorState();
    }

    @Override
    public State readE() {
        return new ErrorState();
    }

    @Override
    public State readEnd() {
        return new ErrorState();
    }
}

class ErrorState extends AbstractState
{
    @Override
    public boolean isValid() {
        return false;
    }
}

class EndState extends AbstractState
{
}

class StartState extends AbstractState
{
    @Override
    public State readDigit() {
        return new DigitState();
    }

    @Override
    public State readPlus() {
        return new PlusState();
    }
    
    @Override
    public State readMinus() {
        return new MinusState();
    }
    
    @Override
    public State readPoint() {
        return new PointState();
    }
    
    @Override
    public State readSpace() {
        return this;
    }
}

class PlusState extends AbstractState
{
    @Override
    public State readDigit() {
        return new DigitState();
    }
    
    @Override
    public State readPoint() {
        return new PlusPointState();
    }
}

class MinusState extends AbstractState
{
    @Override
    public State readDigit() {
        return new DigitState();
    }
    
    @Override
    public State readPoint() {
        return new MinusPointState();
    }
}

class PlusPointState extends AbstractState
{
    @Override
    public State readDigit() {
        return new DigitState();
    }
}

class MinusPointState extends AbstractState
{
    @Override
    public State readDigit() {
        return new DigitState();
    }
}

class DigitState extends AbstractState
{
    @Override
    public State readDigit() {
        return this;
    }
    
    @Override
    public State readPoint() {
        return new DigitPointState();
    }
    
    @Override
    public State readE() {
        return new EState();
    }
    
    @Override
    public State readEnd() {
        return new EndState();
    }
}

class DigitPointState extends AbstractState
{
    @Override
    public State readDigit() {
        return new PointDigitState();
    }
    
    @Override
    public State readEnd() {
        return new EndState();
    }
    
    @Override
    public State readE() {
        return new EState();
    }
}

class PointState extends AbstractState
{
    @Override
    public State readDigit() {
        return new PointDigitState();
    }
}

class PointDigitState extends AbstractState
{
    @Override
    public State readDigit() {
        return this;
    }
    
    @Override
    public State readEnd() {
        return new EndState();
    }
    
    @Override
    public State readE() {
        return new EState();
    }
}

class EState extends AbstractState
{
    @Override
    public State readDigit() {
        return new EDigitState();
    }
    
    @Override
    public State readPlus() {
        return new EPlusState();
    }
    
    @Override
    public State readMinus() {
        return new EMinusState();
    }
}

class EPlusState extends AbstractState
{
    @Override
    public State readDigit() {
        return new EDigitState();
    }
}

class EMinusState extends AbstractState
{
    @Override
    public State readDigit() {
        return new EDigitState();
    }
}

class EDigitState extends AbstractState
{
    @Override
    public State readDigit() {
        return this;
    }
    
    @Override
    public State readEnd() {
        return new EndState();
    }
}

public class ValidNumber
{

    private static boolean invalidChar(char input) {
        return !(Character.isDigit(input) || 
                 input == ' ' ||
                 input == '+' || 
                 input == '-' || 
                 input == '.' || 
                 input == 'e' || 
                 input == 'E');
    }
    
    public static boolean isNumber(String s)
    {
        s = s.trim();  // remove leading and trailing spaces
        State state = new StartState();
        for(char c: s.toCharArray())
        {
            // some chars are not acceptable by any state
            if(invalidChar(c))
                return false;
            
            if(Character.isDigit(c))
                state = state.readDigit();
            else if(c == ' ')
                state = state.readSpace();
            else if(c == '+')
                state = state.readPlus();
            else if(c == '-')
                state = state.readMinus();
            else if(c == '.')
                state = state.readPoint();
            else if(c == 'e' || c == 'E')
                state = state.readE();
            
            if(!state.isValid())
                return false;
        }
        state = state.readEnd();
        return state instanceof EndState;
    }

    public static void main(String[] args)
    {
//        System.out.println(isNumber("0"));
//        System.out.println(isNumber("00"));
//        System.out.println(isNumber("-0"));
//        System.out.println(isNumber("0.0"));
//        System.out.println(isNumber(".0"));
//        System.out.println(isNumber("0."));
//        System.out.println(isNumber("0.1"));
//        System.out.println(isNumber(" 0.1"));
//        System.out.println(isNumber("0.1 "));
//        System.out.println(isNumber("0 .1"));
//        System.out.println(isNumber("0. 1"));
//        System.out.println(isNumber("0 1"));
//        System.out.println(isNumber("+.8"));
//        System.out.println(isNumber("6+1"));
        
//        System.out.println(isNumber(" 12"));
//        System.out.println(isNumber("12 "));
//        System.out.println(isNumber("1 2"));
//        System.out.println(isNumber(" 1  2 "));
//        System.out.println(isNumber(" - 1"));
//        
//        System.out.println(isNumber("abc"));
//        System.out.println(isNumber("1a"));
//        System.out.println(isNumber("1 a"));
//        
//        System.out.println(isNumber("1e2"));
//        System.out.println(isNumber("-1e2"));
//        System.out.println(isNumber("1.0e2"));
//        System.out.println(isNumber("1.0e-2"));
//        System.out.println(isNumber("1e2.0"));
//        
//        System.out.println(isNumber("1e - 2"));
//        System.out.println(isNumber(".1e - 2"));
//        System.out.println(isNumber("01e - 2"));
//        System.out.println(isNumber("1.e - 2"));
//        System.out.println(isNumber("1e - 0"));
//        
//        System.out.println(isNumber("."));
        
        System.out.println(isNumber("64.e3"));
    }

}
