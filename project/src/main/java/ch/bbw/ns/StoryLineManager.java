package ch.bbw.ns;

import java.util.ArrayList;
import java.util.List;

public class StoryLineManager {
    private List<String> story;
    private Manager manager;
    private int place;

    public StoryLineManager(Manager manager) {
        this.manager = manager;
        story = new ArrayList<>();
        place = 0;

        createList();
    }

    public void update() {
        place++;
    }

    public void createList() {
        story.add("You leave the train, it has been a long while since you have last been here. " +
                "Not much has changed since. You planned on meeting your childhood friend, Jane, " +
                "in your home town. You should take your phone and call an uber to get there.");
        story.add("You take your phone and call yourself a taxi. It arrives with in a " +
                "few minutes. Soon you will be in your home town again, hopefully " +
                "everything worked out as it should have.\n" +
                "After a short drive of a couple minutes you finally arrive in your future " +
                "home town. You see your childhood friend, Jane, you should go talk to her! " +
                "She has been waiting for you to arrive.");
        story.add("Jane: I missed you so much, " + manager.getName() + "! How cool to have you back here! I will " +
                "accompany you throughout your move and fresh start in this old city. Do you " +
                "wanna go inside?\n" +
                "Go inside to the Entrance. Let's see how it looks!");
        story.add("You did not realise how long it has been someone was last in here. " +
                "When did this floor last see a broom?\n" +
                "CONGRATULATIONS you are done with the game!");
    }

    public List<String> getStory() {
        return story;
    }

    public void setStory(List<String> story) {
        this.story = story;
    }

    public String getOutput() {
        return story.get(place);
    }
}
