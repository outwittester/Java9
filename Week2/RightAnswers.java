//一个二维数组，输入答案，输出每个人答对多少道题

import java.util.*;

public class RightAnswers {
    public static void main(String[] args) {
        char[][] answers = {
                {'A','B','A','C','C','D','E','E','A','D'},
                {'D','B','A','B','C','A','E','E','A','D'},
                {'E','D','D','A','C','B','E','E','A','D'},
                {'C','B','A','E','D','C','E','E','A','D'},
                {'A','B','D','C','C','D','E','E','A','D'},
                {'B','B','E','C','C','D','E','E','A','D'},
                {'B','B','A','C','C','D','E','E','A','D'},
                {'E','B','E','C','C','D','E','E','A','D'},
        };

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        char[] inputAnswer = input.toCharArray();
        char[] rightAnswer = new char[10];

        if (inputAnswer.length < 10) {
            //rightAnswer = {'D','B','D','C','C','D','A','E','A','D'};
            rightAnswer = "DBDCCDAEAD".toCharArray();
        }
        else {
            rightAnswer = inputAnswer;
        }

        int[] results = new int[10];

        for (int i = 0; i < answers.length; i++) {
            int count = 0;
            for (int j = 0; j < 10; j++) {
                if (answers[i][j] == rightAnswer[j]) {
                    count++;
                }
            results[i] = count;
            }
        }

        System.out.println("The number of right answers:");
        for (int i = 0; i < answers.length; i++) {
            System.out.println(results[i]);
        }


    }
}
