package com.example.hero30kingdomrush;

import android.R.integer;
import android.util.Log;
import android.widget.Toast;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.engine.handler.physics.PhysicsHandler;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.extension.tmx.TMXLayer;
import org.andengine.extension.tmx.TMXLoader;
import org.andengine.extension.tmx.TMXProperties;
import org.andengine.extension.tmx.TMXTile;
import org.andengine.extension.tmx.TMXTileProperty;
import org.andengine.extension.tmx.TMXTiledMap;
import org.andengine.extension.tmx.TMXLoader.ITMXTilePropertiesListener;
import org.andengine.extension.tmx.util.exception.TMXLoadException;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.util.debug.Debug;

public class MapScene extends Scene {
    
    TMXTiledMap mTMXTiledMap;
     TMXLayer tmxLayer;
    public MapScene()
    {
        
        this.loadTMXMap();
        loadRole();
        

    }
    
    private void loadRole() {
        // TODO Auto-generated method stub
        
        AnimatedSprite sprite = new AnimatedSprite((Constants.CAMERA_WIDTH - Assets.tiledTextureRegion.getWidth()) / 2,
                (Constants.CAMERA_HEIGHT - Assets.tiledTextureRegion.getHeight()) / 2,
                Assets. tiledTextureRegion, Constants.mEngine.getVertexBufferObjectManager());    
        sprite.animate(100);
        this.attachChild(sprite);

        FireManSprite fireManSprite = new FireManSprite((Constants.CAMERA_WIDTH - Assets.tiledTextureRegion.getWidth()) / 2-100,
                (Constants.CAMERA_HEIGHT - Assets.tiledTextureRegion.getHeight()) / 2,
                Assets.tiledTextureRegion, Constants.mEngine.getVertexBufferObjectManager()); 
        ISpriteActionInterface actionInterface = fireManSprite;     
        actionInterface.Appeare();     
        this.attachChild(fireManSprite);
        

        
        //herosprite
        final HeroSprite heroSprite = new HeroSprite((Constants.CAMERA_WIDTH - Assets.herotiledTextureRegion.getWidth()) / 2-50,
                (Constants.CAMERA_HEIGHT - Assets.herotiledTextureRegion.getHeight()) / 2,
                Assets.herotiledTextureRegion, Constants.mEngine.getVertexBufferObjectManager()); 
		final PhysicsHandler physicsHandler = new PhysicsHandler(heroSprite);
		heroSprite.registerUpdateHandler(physicsHandler);
        heroSprite.setScale(2);
        heroSprite.Runnable();
        physicsHandler.setVelocityX(-100);
        this.attachChild(heroSprite);
        
        
        
        final AnimatedSprite sheepsprite = new AnimatedSprite((Constants.CAMERA_WIDTH - Assets.sheeptiledTextureRegion.getWidth()) / 2+100,
                (Constants.CAMERA_HEIGHT - Assets.sheeptiledTextureRegion.getHeight()) / 2,
                Assets. sheeptiledTextureRegion, Constants.mEngine.getVertexBufferObjectManager()) {
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
				return true;
			}			
		};  
        sheepsprite.setScale(2);
        sheepsprite.animate(100);
        this.attachChild(sheepsprite);
        
		registerTouchArea(sheepsprite);
		setTouchAreaBindingOnActionDownEnabled(true);
		
		
		//loop
		this.registerUpdateHandler(new IUpdateHandler(){
			@Override
			public void onUpdate(float pSecondsElapsed) {
				// TODO Auto-generated method stub
				int dx = (int) (sheepsprite.getX()-heroSprite.getX());
				int dy = (int) (sheepsprite.getY()-heroSprite.getY());
				
/*				int d = (int) Math.sqrt(dx*dx+dy*dy);
				if (d < 10) {
                    physicsHandler.setVelocity(0);
                    return;
                }*/

				if(Math.abs(dx) > 150)				
				physicsHandler.setVelocityX(dx > 0 ? 150 : -150);
				else {
					//physicsHandler.setVelocityX(dx > 0 ? 40 : -40);
				    physicsHandler.setVelocityX(dx );
				}
				if(Math.abs(dy) > 150)
				physicsHandler.setVelocityY(dy > 0 ? 150: -150);
				else
					//physicsHandler.setVelocityY(dy > 0 ? 40 : -40);
				    physicsHandler.setVelocityY(dy );
				
				
				if(dx > 0)
					heroSprite.setFlippedHorizontal(false);
				else {
					heroSprite.setFlippedHorizontal(true);
				}
				
								
				final float[] playerFootCordinates = heroSprite.convertLocalToSceneCoordinates(12, 31);

				/* Get the tile the feet of the player are currently waking on. */
				final TMXTile tmxTile =  tmxLayer.getTMXTileAt(playerFootCordinates[0], playerFootCordinates[1]);
				 Log.d("aaaa", "tmxTile.getTileY() = "+tmxTile.getTileY()+" tmxTile.getTileX() = "+tmxTile.getTileX());
				if(tmxTile != null) {
				    if(tmxTile.getTileY() <60 && tmxTile.getTileX() < 10)
				    {
				       
				        Constants.mEngine.setScene(new  BattleScene());
				    }
				        
				}
				
			}
				


			@Override
			public void reset() {
				// TODO Auto-generated method stub			
			}});
        

        
    }

    private void loadTMXMap()
    {
       // final Scene scene = new Scene();

        try {
            final TMXLoader tmxLoader = new TMXLoader(Constants.mContext.getAssets(), Constants.mEngine.getTextureManager(), TextureOptions.BILINEAR_PREMULTIPLYALPHA, Constants.mEngine.getVertexBufferObjectManager(), new ITMXTilePropertiesListener() {
                @Override
                public void onTMXTileWithPropertiesCreated(final TMXTiledMap pTMXTiledMap, final TMXLayer pTMXLayer, final TMXTile pTMXTile, final TMXProperties<TMXTileProperty> pTMXTileProperties) {
                    /* We are going to count the tiles that have the property "cactus=true" set. */
                    if(pTMXTileProperties.containsTMXProperty("cactus", "true")) {
                        //TMXTiledMapExample.this.mCactusCount++;
                    }
                }
            });
            mTMXTiledMap = tmxLoader.loadFromAsset("tmx/desert.tmx"); 
        } catch (final TMXLoadException e) {
            Debug.e(e);
        }

        tmxLayer = mTMXTiledMap.getTMXLayers().get(0);
        tmxLayer.setTag(1);
        this.attachChild(tmxLayer);
    }

}
