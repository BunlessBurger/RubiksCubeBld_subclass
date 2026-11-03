public class twoByTwo extends cube
{
    
    //print scramble state(A, B, C...)
    public void printState(){
        System.out.print("State:");
        for (int i=0; i<cornerScrambled.length; i++){
            System.out.print(" "+cornerScrambled[i]);
        }
        System.out.println("");
    }
    
    //PERMUTATION METHODS
    //turn a side
    public void turnR(){
        //create a copy of list cornerScrambled
        copyToArray(cornerScrambled,cornerScrambledTemp);
        
        //replace white with green
        cornerScrambledTemp[1] = cornerScrambled[9];
        cornerScrambledTemp[2] = cornerScrambled[10];
        //blue with white
        cornerScrambledTemp[16] = cornerScrambled[2];
        cornerScrambledTemp[19] = cornerScrambled[1];
        //green with yellow
        cornerScrambledTemp[9] = cornerScrambled[21];
        cornerScrambledTemp[10] = cornerScrambled[22];
        //yellow with blue
        cornerScrambledTemp[21] = cornerScrambled[19];
        cornerScrambledTemp[22] = cornerScrambled[16];
        //rotate red face
        rotateClockwise(12);
        
        scramble.add("R");
        
        //replace cornerScrambled with the new scramble
        copyToArray(cornerScrambledTemp,cornerScrambled);
    }
    public void turnR(String extra){
        //create a copy of list cornerScrambled
        copyToArray(cornerScrambled,cornerScrambledTemp);
        
        if (extra.equals("'") || extra.equals("prime")){
            //replace white with blue
            cornerScrambledTemp[1] = cornerScrambled[19];
            cornerScrambledTemp[2] = cornerScrambled[16];
            //blue with yellow
            cornerScrambledTemp[16] = cornerScrambled[22];
            cornerScrambledTemp[19] = cornerScrambled[21];
            //green with white
            cornerScrambledTemp[9] = cornerScrambled[1];
            cornerScrambledTemp[10] = cornerScrambled[2];
            //yellow with green
            cornerScrambledTemp[21] = cornerScrambled[9];
            cornerScrambledTemp[22] = cornerScrambled[10];
            //rotate red face
            rotateCounter(12);
            
            scramble.add("R'");
        } else if (extra.equals("2")){
            //replace white with yellow
            cornerScrambledTemp[1] = cornerScrambled[21];
            cornerScrambledTemp[2] = cornerScrambled[22];
            //blue with green
            cornerScrambledTemp[16] = cornerScrambled[10];
            cornerScrambledTemp[19] = cornerScrambled[9];
            //green with blue
            cornerScrambledTemp[9] = cornerScrambled[19];
            cornerScrambledTemp[10] = cornerScrambled[16];
            //yellow with white
            cornerScrambledTemp[21] = cornerScrambled[1];
            cornerScrambledTemp[22] = cornerScrambled[2];
            //rotate red face twice
            rotate2(12);
            
            scramble.add("R2");
        }
        
        //replace cornerScrambled with the new scramble
        copyToArray(cornerScrambledTemp,cornerScrambled);
        
    }
    
    public void turnL(){
        copyToArray(cornerScrambled,cornerScrambledTemp);
        
        //replace white with blue
        cornerScrambledTemp[0] = cornerScrambled[18];
        cornerScrambledTemp[3] = cornerScrambled[17];
        //replace blue with yellow
        cornerScrambledTemp[17] = cornerScrambled[23];
        cornerScrambledTemp[18] = cornerScrambled[20];
        //replace yellow with green
        cornerScrambledTemp[20] = cornerScrambled[8];
        cornerScrambledTemp[23] = cornerScrambled[11];
        //replace green with white
        cornerScrambledTemp[8] = cornerScrambled[0];
        cornerScrambledTemp[11] = cornerScrambled[3];
        //rotate orange face
        rotateClockwise(4);
        
        scramble.add("L");
        copyToArray(cornerScrambledTemp,cornerScrambled);
    }
    public void turnL(String extra){
        copyToArray(cornerScrambled,cornerScrambledTemp);
        
        if (extra.equals("'") || extra.equals("prime")){
            //replace white with green
            cornerScrambledTemp[0] = cornerScrambled[8];
            cornerScrambledTemp[3] = cornerScrambled[11];
            //replace blue with white
            cornerScrambledTemp[17] = cornerScrambled[3];
            cornerScrambledTemp[18] = cornerScrambled[0];
            //replace yellow with blue
            cornerScrambledTemp[20] = cornerScrambled[18];
            cornerScrambledTemp[23] = cornerScrambled[17];
            //replace green with yellow
            cornerScrambledTemp[8] = cornerScrambled[20];
            cornerScrambledTemp[11] = cornerScrambled[23];
            //rotate orange face
            rotateCounter(4);
            
            scramble.add("L'");
        } else if (extra.equals("2")){
            //replace white with yellow
            cornerScrambledTemp[0] = cornerScrambled[20];
            cornerScrambledTemp[3] = cornerScrambled[23];
            //replace blue with green
            cornerScrambledTemp[17] = cornerScrambled[11];
            cornerScrambledTemp[18] = cornerScrambled[8];
            //replace yellow with white
            cornerScrambledTemp[20] = cornerScrambled[0];
            cornerScrambledTemp[23] = cornerScrambled[3];
            //replace green with blue
            cornerScrambledTemp[8] = cornerScrambled[18];
            cornerScrambledTemp[11] = cornerScrambled[17];
            //rotate orange face twice
            rotate2(4);
            
            scramble.add("L2");
        }
        
        copyToArray(cornerScrambledTemp,cornerScrambled);
    }
    
    public void turnU(){
        copyToArray(cornerScrambled,cornerScrambledTemp);
        
        //replace green with red
        cornerScrambledTemp[8] = cornerScrambled[12];
        cornerScrambledTemp[9] = cornerScrambled[13];
        //orange with green
        cornerScrambledTemp[4] = cornerScrambled[8];
        cornerScrambledTemp[5] = cornerScrambled[9];
        //blue with orange
        cornerScrambledTemp[16] = cornerScrambled[4];
        cornerScrambledTemp[17] = cornerScrambled[5];
        //red with blue
        cornerScrambledTemp[12] = cornerScrambled[16];
        cornerScrambledTemp[13] = cornerScrambled[17];
        //rotate white face
        rotateClockwise(0);
        
        scramble.add("U");
        
        copyToArray(cornerScrambledTemp,cornerScrambled);
    }
    public void turnU(String extra){
        copyToArray(cornerScrambled,cornerScrambledTemp);
        
        if (extra.equals("'") || extra.equals("prime")){
            //replace green with orange
            cornerScrambledTemp[8] = cornerScrambled[4];
            cornerScrambledTemp[9] = cornerScrambled[5];
            //orange with blue
            cornerScrambledTemp[4] = cornerScrambled[16];
            cornerScrambledTemp[5] = cornerScrambled[17];
            //blue with red
            cornerScrambledTemp[16] = cornerScrambled[12];
            cornerScrambledTemp[17] = cornerScrambled[13];
            //red with green
            cornerScrambledTemp[12] = cornerScrambled[8];
            cornerScrambledTemp[13] = cornerScrambled[9];
            //rotate white face
            rotateCounter(0);
            
            scramble.add("U'");
        } else if (extra.equals("2")){
            //replace green with blue
            cornerScrambledTemp[8] = cornerScrambled[16];
            cornerScrambledTemp[9] = cornerScrambled[17];
            //orange with red
            cornerScrambledTemp[4] = cornerScrambled[12];
            cornerScrambledTemp[5] = cornerScrambled[13];
            //blue with green
            cornerScrambledTemp[16] = cornerScrambled[8];
            cornerScrambledTemp[17] = cornerScrambled[9];
            //red with orange
            cornerScrambledTemp[12] = cornerScrambled[4];
            cornerScrambledTemp[13] = cornerScrambled[5];
            //rotate white face twice
            rotate2(0);
            
            scramble.add("U2");
        }
        
        copyToArray(cornerScrambledTemp,cornerScrambled);
    }
    
    public void turnD(){
        copyToArray(cornerScrambled,cornerScrambledTemp);
        
        //replace orange with blue
        cornerScrambledTemp[7] = cornerScrambled[19];
        cornerScrambledTemp[6] = cornerScrambled[18];
        //replace green with orange
        cornerScrambledTemp[11] = cornerScrambled[7];
        cornerScrambledTemp[10] = cornerScrambled[6];
        //replace red with green
        cornerScrambledTemp[15] = cornerScrambled[11];
        cornerScrambledTemp[14] = cornerScrambled[10];
        //replace blue with red
        cornerScrambledTemp[19] = cornerScrambled[15];
        cornerScrambledTemp[18] = cornerScrambled[14];
        //rotate yellow face
        rotateClockwise(20);
        
        scramble.add("D");
        copyToArray(cornerScrambledTemp,cornerScrambled);
    }
    public void turnD(String extra){
        copyToArray(cornerScrambled,cornerScrambledTemp);
        
        if (extra.equals("'") || extra.equals("prime")){
            //replace orange with green
            cornerScrambledTemp[7] = cornerScrambled[11];
            cornerScrambledTemp[6] = cornerScrambled[10];
            //replace green with red
            cornerScrambledTemp[11] = cornerScrambled[15];
            cornerScrambledTemp[10] = cornerScrambled[14];
            //replace red with blue
            cornerScrambledTemp[15] = cornerScrambled[19];
            cornerScrambledTemp[14] = cornerScrambled[18];
            //replace blue with orange
            cornerScrambledTemp[19] = cornerScrambled[7];
            cornerScrambledTemp[18] = cornerScrambled[6];
            //rotate yellow face
            rotateCounter(20);
            
            scramble.add("D'");
        } else if (extra.equals("2")){
            //replace orange with red
            cornerScrambledTemp[7] = cornerScrambled[15];
            cornerScrambledTemp[6] = cornerScrambled[14];
            //replace green with blue
            cornerScrambledTemp[11] = cornerScrambled[19];
            cornerScrambledTemp[10] = cornerScrambled[18];
            //replace red with orange
            cornerScrambledTemp[15] = cornerScrambled[7];
            cornerScrambledTemp[14] = cornerScrambled[6];
            //replace blue with green
            cornerScrambledTemp[19] = cornerScrambled[11];
            cornerScrambledTemp[18] = cornerScrambled[10];
            //rotate yellow face twice
            rotate2(20);
            
            scramble.add("D2");
        }
        
        copyToArray(cornerScrambledTemp,cornerScrambled);
    }
    
    public void turnF(){
        copyToArray(cornerScrambled,cornerScrambledTemp);
        
        //replace white with orange
        cornerScrambledTemp[2] = cornerScrambled[5];
        cornerScrambledTemp[3] = cornerScrambled[6];
        //replace orange with yellow
        cornerScrambledTemp[5] = cornerScrambled[20];
        cornerScrambledTemp[6] = cornerScrambled[21];
        //replace yellow with red
        cornerScrambledTemp[20] = cornerScrambled[15];
        cornerScrambledTemp[21] = cornerScrambled[12];
        //replace red with white
        cornerScrambledTemp[12] = cornerScrambled[3];
        cornerScrambledTemp[15] = cornerScrambled[2];
        //rotate green face
        rotateClockwise(8);
        
        scramble.add("F");
        copyToArray(cornerScrambledTemp,cornerScrambled);
    }
    public void turnF(String extra){
        copyToArray(cornerScrambled,cornerScrambledTemp);
        
        if (extra.equals("'") || extra.equals("prime")){
            //replace white with red
            cornerScrambledTemp[2] = cornerScrambled[15];
            cornerScrambledTemp[3] = cornerScrambled[12];
            //replace orange with white
            cornerScrambledTemp[5] = cornerScrambled[2];
            cornerScrambledTemp[6] = cornerScrambled[3];
            //replace yellow with orange
            cornerScrambledTemp[20] = cornerScrambled[5];
            cornerScrambledTemp[21] = cornerScrambled[6];
            //replace red with yellow
            cornerScrambledTemp[12] = cornerScrambled[21];
            cornerScrambledTemp[15] = cornerScrambled[20];
            //rotate green face
            rotateCounter(8);
            
            scramble.add("F'");
        } else if (extra.equals("2")){
            //replace white with yellow
            cornerScrambledTemp[2] = cornerScrambled[20];
            cornerScrambledTemp[3] = cornerScrambled[21];
            //orange with red
            cornerScrambledTemp[5] = cornerScrambled[15];
            cornerScrambledTemp[6] = cornerScrambled[12];
            //yellow with white
            cornerScrambledTemp[20] = cornerScrambled[2];
            cornerScrambledTemp[21] = cornerScrambled[3];
            //red with orange
            cornerScrambledTemp[12] = cornerScrambled[6];
            cornerScrambledTemp[15] = cornerScrambled[5];
            //rotate green face twice
            rotate2(8);
            
            scramble.add("F2");
        }
        
        copyToArray(cornerScrambledTemp,cornerScrambled);
    }
    
    public void turnB(){
        copyToArray(cornerScrambled,cornerScrambledTemp);
        
        //replace white with red
        cornerScrambledTemp[1] = cornerScrambled[14];
        cornerScrambledTemp[0] = cornerScrambled[13];
        //replace orange with white
        cornerScrambledTemp[4] = cornerScrambled[1];
        cornerScrambledTemp[7] = cornerScrambled[0];
        //replace yellow with orange
        cornerScrambledTemp[23] = cornerScrambled[4];
        cornerScrambledTemp[22] = cornerScrambled[7];
        //replace red with yellow
        cornerScrambledTemp[14] = cornerScrambled[23];
        cornerScrambledTemp[13] = cornerScrambled[22];
        //rotate blue face
        rotateClockwise(16);
        
        scramble.add("B");
        copyToArray(cornerScrambledTemp,cornerScrambled);
    }
    public void turnB(String extra){
        copyToArray(cornerScrambled,cornerScrambledTemp);
        
        if (extra.equals("'") || extra.equals("prime")){
            //replace white with orange
            cornerScrambledTemp[1] = cornerScrambled[4];
            cornerScrambledTemp[0] = cornerScrambled[7];
            //replace orange with yellow
            cornerScrambledTemp[4] = cornerScrambled[23];
            cornerScrambledTemp[7] = cornerScrambled[22];
            //replace yellow with red
            cornerScrambledTemp[23] = cornerScrambled[14];
            cornerScrambledTemp[22] = cornerScrambled[13];
            //replace red with white
            cornerScrambledTemp[14] = cornerScrambled[1];
            cornerScrambledTemp[13] = cornerScrambled[0];
            //rotate blue face
            rotateCounter(16);
            
            scramble.add("B'");
        } else if (extra.equals("2")){
            //replace white with yellow
            cornerScrambledTemp[1] = cornerScrambled[23];
            cornerScrambledTemp[0] = cornerScrambled[22];
            //replace orange with red
            cornerScrambledTemp[4] = cornerScrambled[14];
            cornerScrambledTemp[7] = cornerScrambled[13];
            //replace yellow with white
            cornerScrambledTemp[23] = cornerScrambled[1];
            cornerScrambledTemp[22] = cornerScrambled[0];
            //replace red with orange
            cornerScrambledTemp[14] = cornerScrambled[4];
            cornerScrambledTemp[13] = cornerScrambled[7];
            //rotate blue face twice
            rotate2(16);
            
            scramble.add("B2");
        }
        
        copyToArray(cornerScrambledTemp,cornerScrambled);
    }
    
    //rotate a face (used in turnS methods)
    private void rotateClockwise(int startIndex){
        cornerScrambledTemp[startIndex] = cornerScrambled[startIndex+3];
        cornerScrambledTemp[startIndex+1] = cornerScrambled[startIndex];
        cornerScrambledTemp[startIndex+2] = cornerScrambled[startIndex+1];
        cornerScrambledTemp[startIndex+3] = cornerScrambled[startIndex+2];
    }
    private void rotateCounter(int startIndex){
        cornerScrambledTemp[startIndex] = cornerScrambled[startIndex+1];
        cornerScrambledTemp[startIndex+1] = cornerScrambled[startIndex+2];
        cornerScrambledTemp[startIndex+2] = cornerScrambled[startIndex+3];
        cornerScrambledTemp[startIndex+3] = cornerScrambled[startIndex];
    }
    private void rotate2(int startIndex){
        cornerScrambledTemp[startIndex] = cornerScrambled[startIndex+2];
        cornerScrambledTemp[startIndex+1] = cornerScrambled[startIndex+3];
        cornerScrambledTemp[startIndex+2] = cornerScrambled[startIndex];
        cornerScrambledTemp[startIndex+3] = cornerScrambled[startIndex+1];
    }
    
}
