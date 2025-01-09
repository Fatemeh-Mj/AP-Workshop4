import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Voting v1 = new Voting(0,"Canceling class" , true);
        v1.createChoices("yes");
        v1.createChoices("no");
        ArrayList<Voting> votings = new ArrayList<>();
        votings.add(v1);
        VotingSystem newPoll = new VotingSystem(votings);

        Person voter1 = new Person("Fatemeh", "Moujani");
        Person voter2 = new Person("Sara", "Mohammadi");
        Person voter3 = new Person("Ahmad", "Zamani");

        ArrayList<String> voter1Choices = new ArrayList<>();
        ArrayList<String> voter2Choices = new ArrayList<>();

        voter1Choices.add("no");
        voter2Choices.add("yes");
        for (Voting v : newPoll.getVotingList()){
            v.printVoters();
            v.printResult();
        }
    }
}
