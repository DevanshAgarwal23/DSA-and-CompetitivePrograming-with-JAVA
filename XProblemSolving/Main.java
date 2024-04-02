package XProblemSolving;

import javax.sound.midi.Soundbank;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minStepToReachTarget(new int[]{1,1}, new int[]{7,5},7));
    }
}
