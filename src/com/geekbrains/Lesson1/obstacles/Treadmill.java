package com.geekbrains.Lesson1.obstacles;

import com.geekbrains.Lesson1.partisipant.Participant;

public class Treadmill implements Obstacles {

    private final int length;

    public Treadmill(int length) {
        this.length = length;
    }

    @Override
    public boolean passObstacle(Participant participant) {
        if (length < participant.run()) {
            System.out.printf("Участник %s успешно пробежал дистанцию в %d м. на беговой дорожке. %n", participant, length);
            return true;
        }
        System.out.printf("Участник %s не смог пробежать дистанцию в %d м. на беговой дорожке. %n", participant, length);
        return false;
    }
}
