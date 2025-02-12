import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
       
        int[] mathGiverOne = {1,2,3,4,5};
        int[] mathGiverTwo = {2,1,2,3,2,4,2,5};
        int[] mathGiverThree = {3,3,1,1,2,2,4,4,5,5};
        
        int[] countArr = new int[3]; 
    
        for(int index=0;index<answers.length;index++){
            int answerNo = answers[index];
            
            if(mathGiverOne[index%5] == answerNo){
                countArr[0] ++;
            } 
            
            if(mathGiverTwo[index%8] == answerNo){
               countArr[1] ++;
            } 
            
            if(mathGiverThree[index%10] == answerNo){
                countArr[2] ++;
            } 
        }
         
        int max = 0;
        int sum = 0;
        int count = 0;
        for(int index=0;index<countArr.length;index++){
            if(max < countArr[index]){
                max = countArr[index];
                sum = index;
                count = 0;
            }else if(max == countArr[index]){
                sum += index;
                count ++;
            }
        }
        int[] answer;
        if(count == 0){
            answer = new int[1];
            if(sum == 0){
                answer[0] = 1;
            }else if(sum == 1){
                answer[0] = 2;
            }else if(sum == 2){
                answer[0] = 3;
            }   
        }else{
            answer = new int[2];
            if(sum == 1){
                answer[0] = 1;
                answer[1] = 2;
            }else if(sum == 2){
                answer[0] = 1;
                answer[1] = 3;
            }else if(sum == 3 && count == 1){
                answer[0] = 2;
                answer[1] = 3;
            }else{
                answer = new int[3];
                answer[0] = 1;
                answer[1] = 2;
                answer[2] = 3;
            }
        }
        return answer;
    }
}