
package com.example.hero30kingdomrush;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.engine.handler.physics.PhysicsHandler;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.input.touch.TouchEvent;

import android.util.Log;

public class BattleScene extends Scene {
	  PhysicsHandler physicsHandler;
    public BattleScene() {
        // herosprite
		final HeroSprite heroSprite = new HeroSprite(
				(Constants.CAMERA_WIDTH - Assets.herotiledTextureRegion
						.getWidth()) / 2 - 100,
				(Constants.CAMERA_HEIGHT - Assets.herotiledTextureRegion
						.getHeight()) / 2, Assets.herotiledTextureRegion,
				Constants.mEngine.getVertexBufferObjectManager()) {

			@Override
			public boolean onAreaTouched(TouchEvent pSceneTouchEvent,
					float pTouchAreaLocalX, float pTouchAreaLocalY) {
				// TODO Auto-generated method stub
				// return super
				// .onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX,
				// pTouchAreaLocalY);
				switch (pSceneTouchEvent.getAction()) {
				case TouchEvent.ACTION_DOWN:
					Log.d("aaaa","touchevent.down");
					physicsHandler.setVelocityX(100);
					break;
				case TouchEvent.ACTION_MOVE:
					break;
				case TouchEvent.ACTION_UP:
					physicsHandler.setVelocityX(0);
					break;
				}
				return true;
			}

		};
         physicsHandler = new PhysicsHandler(heroSprite);
        heroSprite.registerUpdateHandler(physicsHandler);
        
        //add heroSprite to TouchArea
        registerTouchArea(heroSprite);
		setTouchAreaBindingOnActionDownEnabled(true);

        heroSprite.setScale(2);
        heroSprite.Runnable();
      //  physicsHandler.setVelocityX(100);
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
        
        
        this.setOnSceneTouchListener(new IOnSceneTouchListener() {
			
			@Override
			public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
				// TODO Auto-generated method stub
				switch (pSceneTouchEvent.getAction()) {
				case TouchEvent.ACTION_DOWN:
					Log.d("aaaa","touchevent.down");
					physicsHandler.setVelocityX(100);
					break;
				case TouchEvent.ACTION_MOVE:
					break;
				case TouchEvent.ACTION_UP:
					physicsHandler.setVelocityX(0);
					break;
				}
				return false;
			}
		});
    }

}
