package WalkSeries2;
import static java.lang.System.out;
public class InputOutPut {

    public static void main(String... args) {
        var startValue =1;
        var endValue = 100;
        var incrementValue  = 5;

        // it is always a good idea to inform what is happening
        out.println("Start of process");
        // reformatted the code so that it in in the general standard form
        for( startValue = 0; startValue<= endValue ; startValue = startValue + incrementValue){ 
                
            PrintData("The Current Value", startValue); 
            
        }
    }

    private static void PrintData(String message, int value) {
        var header = "-";
        System.out.println( header.repeat(20)   );
		System.out.print(message + "  =");
        System.out.println(value);
    }
}    
