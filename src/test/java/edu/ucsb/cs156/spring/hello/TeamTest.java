package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_incomparable_object() {
        assertFalse(team.equals(0), "Team object should not equal 0");
        assertFalse(team.equals("string"), "Team object should not equal string");
    }

    @Test
    public void equals_identical_team() {
        assertTrue(team.equals(team), "Team object should equal itself");
    }

    @Test
    public void equals_equivalent_team() {
        Team team2 = new Team("test-team");
        assertTrue(team.equals(team2), "Team object should equal team with equal name and members");
    }

    @Test
    public void equals_non_equivalent_team() {
        Team team2 = new Team("test-team");
        team2.addMember("Peter");
        Team team3 = new Team("wrong-test-team");
        Team team4 = new Team("wrong-test-team");
        team4.addMember("Peter");

        // team2 differs in members
        // team3 differs in team name
        // team4 differs in both
        assertFalse(team.equals(team2), "Team object should not equal nonequivalent team");
        assertFalse(team.equals(team3), "Team object should not equal nonequivalent team");
        assertFalse(team.equals(team4), "Team object should not equal nonequivalent team");
    }

    @Test
    public void hashCode_matchest_equivalent() {
        Team team1 = new Team("test-team");
        team1.addMember("Peter");

        Team team2 = new Team("test-team");
        team2.addMember("Peter");

        assertEquals(team1.hashCode(), team2.hashCode());
    }
   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
