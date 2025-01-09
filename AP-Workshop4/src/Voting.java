import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Voting {
    private int type;
    private String question;
    private HashMap<String, HashSet<Vote>> choices;
    private ArrayList<String> voteOptions;
    private boolean isAnonymous;
    private ArrayList<Person> voters;
    public Voting (int type, String question, boolean isAnonymous){
        this.type = type;
        this.question = question;
        this.isAnonymous = isAnonymous;
        this.choices = new HashMap<>();
        this.voters = new ArrayList<>();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getChoices() {
        voteOptions = new ArrayList<>();
        for (String str : choices.keySet()){
            voteOptions.add(str);
        }
        return  voteOptions;
    }
    public void createChoices (String choice){
        this.choices.put(choice, new HashSet<Vote>());
    }
    public void vote (Person voter, ArrayList<String> voter_choices){
        if (isAnonymous)
            return;
        else {
            Vote vote = new Vote(voter, null);
            for (String voption : voteOptions){
                for (String vchoices : voter_choices){
                    if(vchoices.equals(voption)){
                        choices.get(voption).add(newVote);
                    }
                }
            }
        }
        if (!voters.contains(voter)){
            voters.add(voter);
        }

    }
    public void vote (Person person){
        if (!isAnonymous){
            return;
        }else{
            Vote newVote = new Vote(person,null);
            for (String vOption : voteOptions){
                choices.get(vOption).add(newVote);
            }

        }
        if (!voters.contains(person)){
            voters.add(person);
        }

    }
    public void printResult(){
        for (String res: choices.keySet()){
            System.out.println("Candidate:" + res + "\tNumber of votes:" + choices.get(res).size());
        }
    }
    public void printVoters(){
        if (isAnonymous){
            return;
        }else {
            for (String can : choices.keySet()) {
                System.out.println("Candidiate:" +  can);
                for (Vote i : choices.get(can)) {
                    System.out.println(i.getVoter().getFirstName() + " " + i.getVoter().getLastName());
                }
            }
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voting voting = (Voting) o;
        return type == voting.type && isAnonymous == voting.isAnonymous && Objects.equals(question, voting.question) && Objects.equals(choices, voting.choices) && Objects.equals(voters, voting.voters);
    }
}
