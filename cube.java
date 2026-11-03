import java.util.ArrayList;

public class cube 
{
    //char arrays because it's more efficient than Strings
    public char[] cornerSolved = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X'};
    public char[] cornerScrambled = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X'};
    public char[] cornerScrambledTemp = new char[cornerSolved.length];
    public char[] edgeSolved = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X'};
    public char[] edgeScrambled = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X'};
    public char[] edgeScrambledTemp = new char[edgeSolved.length];

    public char cornerBuffer = 'E';
    public char cornerTarget = 'V';
    public char edgeBuffer = 'U';
    public char edgeTarget = 'A';

    //arrayList because length and elements(A, B, C...) will change
    ArrayList<String> scramble = new ArrayList<String>();


    //METHODS
    //turnS and rotate methods not here
    
    //get the piece(3 letters for corner, 2 for edge) that a given letter is on
    public static String cornerPiece(Character letter){
        //white face / upper layer
        if ("AER".contains(String.valueOf(letter))){
            return "AER";
        } else if ("BNQ".contains(String.valueOf(letter))){
            return "BNQ";
        } else if ("CJM".contains(String.valueOf(letter))){
            return "CJM";
        } else if ("DFI".contains(String.valueOf(letter))){
            return "DFI";
        //yellow face / bottom layer
        } else if ("UGL".contains(String.valueOf(letter))){
            return "UGL";
        } else if ("VKP".contains(String.valueOf(letter))){
            return "VKP";
        } else if ("WOT".contains(String.valueOf(letter))){
            return "WOT";
        } else if ("XHS".contains(String.valueOf(letter))){
            return "XHS";
        } else {
            return "";
        }
    }
    public static String edgePiece(Character letter){
        //white face / upper layer
        if ("AQ".contains(String.valueOf(letter))){
            return "AQ";
        } else if ("BM".contains(String.valueOf(letter))){
            return "BM";
        } else if ("CI".contains(String.valueOf(letter))){
            return "CI";
        } else if ("DE".contains(String.valueOf(letter))){
            return "DE";
        //yellow face / bottom layer
        } else if ("UK".contains(String.valueOf(letter))){
            return "UK";
        } else if ("VO".contains(String.valueOf(letter))){
            return "VO";
        } else if ("WS".contains(String.valueOf(letter))){
            return "WS";
        } else if ("XG".contains(String.valueOf(letter))){
            return "XG";
        //middle layer
        } else if ("FL".contains(String.valueOf(letter))){
            return "FL";
        } else if ("HR".contains(String.valueOf(letter))){
            return "HR";
        } else if ("NT".contains(String.valueOf(letter))){
            return "NT";
        } else if ("PJ".contains(String.valueOf(letter))){
            return "PJ";
        //else
        } else {
            return "";
        }
    }
    
    
    //reset arrayList and arrays to default
    public void reset(){
        scramble.clear();
        copyToArray(cornerSolved,cornerScrambled);
        copyToArray(cornerSolved,cornerScrambledTemp);
        copyToArray(edgeSolved,edgeScrambled);
        copyToArray(edgeSolved,edgeScrambledTemp);
    }
    
    //replace arrayB with arrayA... arrayA stays the same
    public void copyToArray(char[] arrayA, char[] arrayB){
        for (int i = 0; i<arrayA.length;i++){
            arrayB[i] = arrayA[i];
        }
    }
    
    //return letter A, B, C...
    //not used in main, is used for testing
    public char cornerAtIndex(int index){
        return cornerScrambled[index];
    }
    public char edgeAtIndex(int index){
        return edgeScrambled[index];
    }
    
    //print scramble(F,R,L...)
    public void printScramble(){
        System.out.print("Scramble:");
        for (int i=0; i<scramble.size(); i++){
            System.out.print(" "+scramble.get(i));
        }
        System.out.println("");
    }
    //method to print scrambled state is not here
    
    //return attributes
    //corner
    public char[] getCornerSolved(){
        return cornerSolved;
    }
    public char[] getCorner(){
        return cornerScrambled;
    }
    public char getCornerBuffer(){
        return cornerBuffer;
    }
    public char getCornerTarget(){
        return cornerTarget;
    }
    //edge
    public char[] getEdgeSolved(){
        return edgeSolved;
    }
    public char[] getEdge(){
        return edgeScrambled;
    }
    public char getEdgeBuffer(){
        return edgeBuffer;
    }
    public char getEdgeTarget(){
        return edgeTarget;
    }
    

}
