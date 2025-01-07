package org.blacksmith;

import org.blacksmith.entitytypes.EnemyEntity;
import org.blacksmith.entitytypes.HeroEntity;

import java.util.List;

public class EntityContentManager {

    HeroEntity hero; // only 1 hero, right?
    List<EnemyEntity> enemies;

    public EntityContentManager() {
        hero = new Hero(0,0);
    }

}
