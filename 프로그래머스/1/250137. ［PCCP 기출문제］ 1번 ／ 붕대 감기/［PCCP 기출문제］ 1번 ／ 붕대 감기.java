class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int healTime = bandage[0];
        int healValue = bandage[1];
        int upgradeHealValue = bandage[2];

        int hp = health;
        
        int noAttackCount = 1;
        
        int attacksIndex=0;
        
        int lastTime = attacks[(attacks.length)-1][0];
        
        //타이머
        for(int time=0;time<=lastTime;time++){
            
            //공격 - 시작
            if(time == attacks[attacksIndex][0]){
                hp = hp - attacks[attacksIndex][1];
                //죽음
                if(hp <= 0)return -1;
                attacksIndex++;//오름차순으로 정렬되어있으니 인덱스 카운트로 계산
                noAttackCount = 1;
            }//공격 - 종료
            else{//힐 - 시작
              if(noAttackCount >= healTime){
                  hp = hp + healValue + upgradeHealValue;
                  noAttackCount = 1;
                  if(health < hp){hp=health;}
              }else{
                  hp = hp + healValue;
                  noAttackCount ++;
                  if(health < hp){hp=health;}
              }
            }//힐 - 종료
            
            //종료
            if(attacksIndex == attacks.length){
                if(hp <= 0){
                    return -1;
                }else{
                    return hp;
                }
            }
        }
        return answer;
    }
}


//1초마다 무조건 채우는거고 시전시간이 지나면 추가회복량만큼 1초에 채워지는 힐량이 증가되는거임
