package com.example.model;

import com.example.model.entities.Club;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.IntStream;

@Component
public class Fixtures {

    private static final int CLUBS_NO = 18;

    private final User user;
    private final Random random = new Random();
    @Getter
    @Setter
    private int currentMatchweek = 1;
    @Getter
    private Map<Integer, Map<Integer, Integer>> matchweekToFixtures;

    @Getter
    private final List<Club> leagueClubs = Club.getAllClubsFromDB();

    @Autowired
    public Fixtures(User user) {
        this.user = user;

        matchweekToFixtures = new HashMap<>();
        drawMatchweeks(leagueClubs);
        leagueClubs.add(user.getClub());
    }

    private void drawMatchweeks(List<Club> clubs) {
        Club userClub = user.getClub();
        Collections.shuffle(clubs);
        for (int i = 1; i <= CLUBS_NO; i++) {
            matchweekToFixtures.put(i, drawFixtures(i, clubs, userClub));
        }
    }

    private Map<Integer, Integer> drawFixtures(int matchweekNumber, List<Club> clubs, Club userClub) {
        Map<Integer, Integer> fixtures = new HashMap<>();
        fixtures.put(userClub.getId(), clubs.get(matchweekNumber - 1).getId());
        ArrayList<Integer> numbers = new ArrayList<>(IntStream.rangeClosed(0, CLUBS_NO - 1).boxed().toList());
        numbers.remove(matchweekNumber - 1);
        for (int i = 0; i < ((CLUBS_NO - 2) / 2); i++) {
            int first = random.nextInt(0, numbers.size());
            int clubNo1 = numbers.get(first);
            numbers.remove(first);

            int second = random.nextInt(0, numbers.size());
            int clubNo2 = numbers.get(second);
            numbers.remove(second);

            fixtures.put(clubs.get(clubNo1).getId(), clubs.get(clubNo2).getId());
        }

        return fixtures;
    }
}
