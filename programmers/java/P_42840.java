package programmers.java;

import java.util.ArrayList;
import java.util.List;

/*
모의고사
문제 설명
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
입출력 예
answers	return
[1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]
입출력 예 설명
입출력 예 #1

수포자 1은 모든 문제를 맞혔습니다.
수포자 2는 모든 문제를 틀렸습니다.
수포자 3은 모든 문제를 틀렸습니다.
따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.

입출력 예 #2

모든 사람이 2문제씩을 맞췄습니다.
 */
public class P_42840 {
    public int[] solution(int[] answers) {
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] answer = {};
        int[] score = new int[3];

        for(int i = 0; i < answers.length; i++){
            if(answers[i] == person1[i % 5]){
                score[0]++;
            }
            if(answers[i] == person2[i % 8]){
                score[1]++;
            }
            if(answers[i] == person3[i % 10]){
                score[2]++;
            }
        }
        
        // 최고 점수 사람 
        int topScorePerson = Math.max(score[0], Math.max(score[1], score[2]));

        // 점수가 가장 높은 사람 여럿 일 수 있어서 arrayList에 담아 
        List<Integer> bestPerson = new ArrayList<>();
        
        for(int i = 0; i < score.length; i++){
            if(score[i] == topScorePerson){
                bestPerson.add(i + 1); // 번호가 1부터 시작이라 + 1 !!!! 
            }
        }

        // 그래서 몇 명인디 
        answer = new int[bestPerson.size()];

        for(int i = 0; i < bestPerson.size(); i++){
            answer[i] = bestPerson.get(i);
        }
        
        return answer;
    }
}
