import java.util.ArrayList;
import java.util.Arrays;

public class RubiksCubeBld
{
    public static void main(String[] args)
    {
        System.out.flush();

        //twoByTwo follows white top, green front
        //bob is an arbitrary name
        twoByTwo bob = new twoByTwo();
        
        
        //GENERATE A RANDOM SCRAMBLE & print it
        bob.reset();
        int previousRoll = 10;
        for (int i=0; i<11; i++){
            int roll = (int)(Math.random()*6)+1;
            //if roll results in the same turnS as before, roll again
            //to prevent redundant scrambles like R R'
            while (roll == previousRoll){
                roll = (int)(Math.random()*6)+1;
            }
            previousRoll = roll;
            //based on roll, apply turnS to the cube
            if (roll == 1){
                roll = (int)(Math.random()*2);
                if (roll == 0){
                    bob.turnR();
                } else {
                    bob.turnR(ranExtra());
                }
            } else if (roll == 2){
                roll = (int)(Math.random()*2);
                if (roll == 0){
                    bob.turnL();
                } else {
                    bob.turnL(ranExtra());
                }
            } else if (roll == 3){
                roll = (int)(Math.random()*2);
                if (roll == 0){
                    bob.turnU();
                } else {
                    bob.turnU(ranExtra());
                }
            } else if (roll == 4){
                roll = (int)(Math.random()*2);
                if (roll == 0){
                    bob.turnD();
                } else {
                    bob.turnD(ranExtra());
                }
            } else if (roll == 5){
                roll = (int)(Math.random()*2);
                if (roll == 0){
                    bob.turnF();
                } else {
                    bob.turnF(ranExtra());
                }
            } else {
                roll = (int)(Math.random()*2);
                if (roll == 0){
                    bob.turnB();
                } else {
                    bob.turnB(ranExtra());
                }
            }
        }
        bob.printScramble();
        bob.printState();
        System.out.println("");
        
        
        //TRACE THE CUBE:
        
        //set variables
        String[] solvedPositions = {"UBL","UBR","UFR","UFL","LUB","LUF","LDF","FDB","FUL","FUR","FDR","FDL","RUF","RUB","RDB","RDF","BUR","BUL","BDL","BDR","DFL","DFR","DBR","DBL"};
        char[] currentState = bob.getCorner();
        char[] solvedState = bob.getCornerSolved();
        //visitedState stores whether a piece is visited/was solved
        boolean[] visitedState = new boolean[solvedState.length];
        Arrays.fill(visitedState,false);
        //look through the cube and change element to true if cube already has solved pieces
        for (int i=0; i<currentState.length; i++){
            if (currentState[i] == solvedState[i]){
                visitedState[i] = true;
            }
        }
        //ArrayList can only have reference types, so nextLetter is Character even though it holds a single letter
        ArrayList<Character> path = new ArrayList<Character>();
        String fullBuffer = bob.cornerPiece(bob.getCornerBuffer());
        int targetIndex = indexOf(bob.getCornerTarget(),solvedState);
        int bufferIndex = indexOf(bob.getCornerBuffer(),solvedState);
        Character nextLetter;
        String newCycleAt = "";
        char[] wholePiece = new char[3];
        
        //find the start of the letter sequence
        nextLetter = (Character)(currentState[bufferIndex]);
        System.out.println("starting at " + nextLetter + "...");
        
        //while there's unsolved pieces, trace letters and add it to the arraylist "path"
        while (containsFalse(visitedState)){
            
            //if the next letter goes into buffer, start a new cycle
            if (fullBuffer.contains(String.valueOf(nextLetter)) && containsFalse(visitedState) ){
                for (int i=0; i<visitedState.length; i++){
                    //find an unsolved letter that also isn't the buffer or goes in the buffer
                    if (visitedState[i]==false && !( fullBuffer.contains(String.valueOf(solvedState[i]))  ) ){
                        //remember which piece(consists of 3 letters) the new cycle starts at
                        nextLetter = (Character)(solvedState[i]);
                        newCycleAt = startNewCycle(nextLetter);
                        //add location that the cycle starts at
                        path.add(nextLetter);
                        //and remember the specific letter it went into
                        nextLetter = (Character)(currentState[i]);
                        
                        break; //stop the forloop
                    }
                }
                
            //if the next letter is returning to where the new cycle started, end this cycle and maybe start a new cycle
            } else if ( newCycleAt.contains(String.valueOf(nextLetter)) ){
                newCycleAt = "";
                //since it's returning to the start of the cycle, it implies the piece(of 3 letters) has been solved
                wholePiece = wasVisited(nextLetter);
                for (int i=0; i<3; i++){
                    visitedState[indexOf(wholePiece[i],solvedState)] = true;
                }

                //if cube still isn't solved, then start another new cycle
                if (containsFalse(visitedState)){
                    for (int i=0; i<visitedState.length; i++){
                        //find an unsolved letter that also isn't the buffer or goes in the buffer
                        if (visitedState[i]==false && !( fullBuffer.contains(String.valueOf(solvedState[i]))  ) ){
                            nextLetter = (Character)(solvedState[i]);
                            //remember which piece(3 letters) the new cycle starts at
                            newCycleAt = startNewCycle(nextLetter);
                            path.add(nextLetter);
                            //and remember the letter in that spot
                            nextLetter = (Character)(currentState[i]);
                            
                            break; //stop the forloop
                        }
                    }
                }
            }
            
            //remember the piece(3 letters) that has been solved
            wholePiece = wasVisited(nextLetter);
            for (int i=0; i<3; i++){
                visitedState[indexOf(wholePiece[i],solvedState)] = true;
            }
            
            //add the current letter, then get the next letter based on it
            path.add(nextLetter);
            nextLetter = (Character)(currentState[ indexOf(nextLetter,solvedState) ]);
            
            //if everything solved? stop the whileloop, otherwise it will loop one more time before stopping
            if (!(containsFalse(visitedState))){
                break;
            }
            
        }
        
        //when finished solving, print out letters
        System.out.println("");
        System.out.println("Final letter sequence: ");
        printArray(path);
        for (int i=0; i<path.size(); i++){
            System.out.print(solvedPositions[indexOf(path.get(i),solvedState)]+" ");
        }
        
    }
    
    
    
    //OTHER METHODS
    
    //return a random modifier(prime or 2) for the turnS methods
    public static String ranExtra(){
        int ran = (int)(Math.random()*2);
        if (ran == 0) {
            return "'";
        } else {
            return "2";
        }
    }
    
    //return index (0,1,2...)
    public static int indexOf(char element, char[] list){
        int index = 0;
        for (int i=0; i<list.length; i++){
            if (list[i] == element){
                index = i;
            }
        }
        return index;
    }
    
    //print all the elements from the ArrayList on one line
    public static void printArray(ArrayList<Character> array){
        for (int i=0; i<array.size(); i++){
            System.out.print(array.get(i)+" ");
        }
        System.out.println("");
    }
    
    //check if cube is solved, ignoring the state of the buffer
    public static boolean containsFalse(boolean[] list){
        for (int i=0; i<list.length; i++){
            if (list[i]==false && i!=0 && i!=4 && i!=17){
                return true;
            }
        }
        return false;
    }
    
    //take a Character and return a String of 3 letters that represent its corner piece
    //these 3 letters are where the new cycle starts
    public static String startNewCycle(Character letter){
        return cube.cornerPiece(letter);
    }
    
    //take a Character and return an array of 3 letters that represent its corner piece
    //these 3 letters will be looped through in the main method to remember which letters were visited/solved
    public static char[] wasVisited(Character letter){
        char[] piece = new char[3];
        String cornerPiece = cube.cornerPiece(letter);
        for (int i=0; i<piece.length; i++){
            piece[i] = cornerPiece.charAt(i);
        }
        return piece;
    }
}
