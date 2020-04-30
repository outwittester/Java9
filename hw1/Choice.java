import java.util.*;
public class Choice {
    public static void main(String[] args) {
        String[][] correct = new String[8][10];
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
        char[] trueAnswers = {'D','B','D','C','C','D','A','E','A','D'};
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < answers[0].length; j++) {
                if (answers[i][j] == trueAnswers[j]) {
                    correct[i][j] = "T";

                } else {
                    correct[i][j] = "F";
                }
            }

        }
        for (int i = 0; i < correct.length; ++i) {
            System.out.println(Arrays.toString(correct[i]));
        }
    }
}