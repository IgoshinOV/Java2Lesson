package com.geekbrains.Lesson1.obstacles;

import com.geekbrains.Lesson1.partisipant.Participant;

public class Wall implements Obstacles {

    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean passObstacle(Participant participant) {
        if (height < participant.jump()) {
            System.out.printf("Участник %s успешно перепрыгул стену высотой в %d м. %n", participant, height);
            return true;
        }
        System.out.printf("Участник %s не смог перепрыгнуть стену высотой в %d м. %n", participant, height);
        return false;
    }
}
