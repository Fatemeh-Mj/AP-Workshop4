import java.util.ArrayList;
import java.util.Random;

public class VotingSystem {
    private ArrayList<Voting> votingList;
    public void createVoting(String question, boolean isAnonymous, int type, ArrayList<String> choices) {
        Voting newVoting = new Voting(type, question, isAnonymous);
        for (String candidates : choices) {
            newVoting.createChoices(candidates);
        }
        votingList.add(newVoting);
    }

    public Voting getVoting(int index){
        return votingList.get(index);
    }
    public ArrayList<Voting> getVotingList() {
        return votingList;
    }
    public void printResults(int index){
        getVoting(index).printResult();
    }
    public void printVoters(int index){
        getVoting(index).printVoters();
    }
    public void printVoting(int index){
        String question = votingList.get(index).getQuestion();
        ArrayList<String> choices = votingList.get(index).getChoices();
        int choiceCounter = 1;
        System.out.println("Question : " + question);
        for (String str : choices){
            System.out.println(choiceCounter + "-" + str );
            choiceCounter ++;
        }
        System.out.println();
    }
    public void vote(int index, Person voter){
        Random random = new Random();
        int choiceCount= random.nextInt(getVoting(index).getChoices().size()); // random choices' count
        ArrayList<String> votingChoices = getVoting(index).getChoices();
        ArrayList<String> voterRandomChoices = new ArrayList<>();
        for (int i = 0; i < choiceCount; i ++){
            int choiceIndex = random.nextInt(votingChoices.size()); // choose a random choice
            voterRandomChoices.add(votingChoices.get(choiceIndex));
            votingChoices.remove(choiceIndex); // to prevent duplicated choices, if a choice has been chosen remove it from all choices
        }
        getVoting(index).vote(voter, voterRandomChoices);
    }
}
