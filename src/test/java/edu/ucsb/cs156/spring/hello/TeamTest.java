package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assertEquals("test-team", team.getName());
    }

    @Test
    public void defaultConstructor_sets_empty_name_and_members() {
        Team emptyTeam = new Team();

        assertEquals("", emptyTeam.getName());
        assertTrue(emptyTeam.getMembers().isEmpty());
    }

    @Test
    public void addMember_adds_member_to_members_list() {
        team.addMember("Alice");

        assertEquals(List.of("Alice"), team.getMembers());
    }

    @Test
    public void setName_changes_name() {
        team.setName("updated-team");

        assertEquals("updated-team", team.getName());
    }

    @Test
    public void setMembers_changes_members() {
        ArrayList<String> updatedMembers = new ArrayList<>(List.of("Alice", "Bob"));

        team.setMembers(updatedMembers);

        assertEquals(updatedMembers, team.getMembers());
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_true_for_same_object() {
        assertTrue(team.equals(team));
    }

    @Test
    public void equals_returns_false_for_object_of_different_type() {
        assertFalse(team.equals("not a team"));
    }

    @Test
    public void equals_returns_true_for_team_with_same_contents() {
        Team other = new Team("test-team");

        assertTrue(team.equals(other));
    }

    @Test
    public void equals_returns_false_for_team_with_different_name() {
        Team other = new Team("other-team");

        assertFalse(team.equals(other));
    }

    @Test
    public void equals_returns_false_for_team_with_different_members() {
        Team other = new Team("test-team");
        other.addMember("Alice");

        assertFalse(team.equals(other));
    }

    @Test
    public void hashCode_returns_value_based_on_name_and_members() {
        team.addMember("Alice");

        int expectedHashCode = "test-team".hashCode() | team.getMembers().hashCode();

        assertEquals(expectedHashCode, team.hashCode());
    }

    @Test
    public void applicationRun_starts_context_on_random_port() {
        try (ConfigurableApplicationContext context = Application.run(new String[] {"--server.port=0"})) {
            assertTrue(context.isActive());
        }
    }

}
