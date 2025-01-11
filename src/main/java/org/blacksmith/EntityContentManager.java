package org.blacksmith;

import org.blacksmith.entitytypes.CollisionEntity;
import org.blacksmith.entitytypes.EnemyEntity;
import org.blacksmith.entitytypes.GameEntity;
import org.blacksmith.entitytypes.HeroEntity;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EntityContentManager {

    private static EntityContentManager instance;

    HeroEntity hero; // only 1 hero, right?
    List<EnemyEntity> enemies;

    GameEntity game;

    private EntityContentManager() {
        hero = new Hero(0,0);
        enemies = new ArrayList<>();
        game = new GameEntity();
    }

    // Let's use a factory pattern, so we have a global ECM
    public static EntityContentManager getInstance() {
        if (instance == null) {
            instance = new EntityContentManager();
        }
        return instance;
    }

    public HeroEntity getHero() {
        return hero;
    }

    public void addEnemy(EnemyEntity enemy) {
        enemies.add(enemy);
    }

    public void killEnemy(EnemyEntity enemy) {
        enemies.remove(enemy);
    }

    public GameEntity getGame() {
        return game;
    }

    public void tick() {
        hero.tick();
        for (EnemyEntity enemy: enemies) {
            enemy.tick();
        }
        game.tick();
    }

    public void draw(Graphics2D g2d) {
        hero.draw(g2d);
        for (EnemyEntity enemy: enemies) {
            enemy.draw(g2d);
        }
        game.draw(g2d);
    }

}
