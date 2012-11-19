
package com.example.hero30kingdomrush;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.engine.handler.physics.PhysicsHandler;
import org.andengine.entity.scene.Scene;

public class BattleScene extends Scene {

    public BattleScene() {
        // herosprite
        final HeroSprite heroSprite = new HeroSprite(
                (Constants.CAMERA_WIDTH - Assets.herotiledTextureRegion.getWidth()) / 2 - 100,
                (Constants.CAMERA_HEIGHT - Assets.herotiledTextureRegion.getHeight()) / 2,
                Assets.herotiledTextureRegion, Constants.mEngine.getVertexBufferObjectManager());
        final PhysicsHandler physicsHandler = new PhysicsHandler(heroSprite);
        heroSprite.registerUpdateHandler(physicsHandler);

        heroSprite.setScale(2);
        heroSprite.Runnable();
        physicsHandler.setVelocityX(100);
        this.attachChild(heroSprite);
        
        
        final FireManSprite fireManSprite = new FireManSprite(
                (Constants.CAMERA_WIDTH - Assets.tiledTextureRegion.getWidth()) / 2 + 300,
                (Constants.CAMERA_HEIGHT - Assets.tiledTextureRegion.getHeight()) / 2,
                Assets.tiledTextureRegion, Constants.mEngine.getVertexBufferObjectManager()); 
        ISpriteActionInterface actionInterface = fireManSprite;     
        actionInterface.Appeare();     
        this.attachChild(fireManSprite);
        
        this.registerUpdateHandler(new IUpdateHandler() {
            
            @Override
            public void reset() {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void onUpdate(float pSecondsElapsed) {
                // TODO Auto-generated method stub
                if(fireManSprite.collidesWith(heroSprite))
                    physicsHandler.setVelocityX(-100);
            }
        });
    }

}
