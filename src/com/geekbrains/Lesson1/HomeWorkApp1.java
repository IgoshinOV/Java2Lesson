package com.geekbrains.Lesson1;

import com.geekbrains.Lesson1.obstacles.Obstacles;
import com.geekbrains.Lesson1.obstacles.Treadmill;
import com.geekbrains.Lesson1.obstacles.Wall;
import com.geekbrains.Lesson1.partisipant.Cat;
import com.geekbrains.Lesson1.partisipant.Human;
import com.geekbrains.Lesson1.partisipant.Participant;
import com.geekbrains.Lesson1.partisipant.Robot;

public class HomeWorkApp1 {

    public static void main(String[] args) {
        Human ivan = new Human("Ivan");
        Cat barsik = new Cat("Barsik");
        Robot ultron = new Robot("Ultron");

        Treadmill treadmill = new Treadmill(400);
        Wall wall = new Wall(2);

        Participant[] participants = {ivan, barsik, ultron};
        Obstacles[] obstacles = {treadmill, wall};

        for (Participant participant : participants) {
            for (Obstacles obstacle : obstacles) {
                if (!obstacle.passObstacle(participant)) {
                    System.out.printf("Участник %s выбывает из соревнований. %n", participant);
                    break;
                }
            }
        }
    }
}
