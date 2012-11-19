package com.example.hero30kingdomrush;




  
import android.graphics.Color;
import android.opengl.GLES20;
import android.widget.Toast;



import org.andengine.engine.camera.BoundCamera;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.Entity;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.TexturePack;
import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.TexturePackLoader;
import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.TexturePackTextureRegionLibrary;
import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.TexturePackerTextureRegion;
import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.exception.TexturePackParseException;
import org.andengine.extension.tmx.TMXLayer;
import org.andengine.extension.tmx.TMXLoader;
import org.andengine.extension.tmx.TMXProperties;
import org.andengine.extension.tmx.TMXTile;
import org.andengine.extension.tmx.TMXTileProperty;
import org.andengine.extension.tmx.TMXTiledMap;
import org.andengine.extension.tmx.TMXLoader.ITMXTilePropertiesListener;
import org.andengine.extension.tmx.util.exception.TMXLoadException;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.debug.Debug;
  
public class MainActivity extends SimpleBaseGameActivity {  
    public static final int CAMERA_WIDTH = 800;  
    public static final int CAMERA_HEIGHT = 480;  
  
    private static final int LAYER_COUNT = 2;  
  
    private static final int LAYER_BACKGROUND = 0;  
    private static final int LAYER_TEXT = LAYER_BACKGROUND + 1;  
  
  

    
    private BoundCamera mBoundChaseCamera;

    protected int mCactusCount;
      

  
    public EngineOptions onCreateEngineOptions() {  
        Camera mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);  
        
        this.mBoundChaseCamera = new BoundCamera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
        
        
        final EngineOptions engineOptions = new EngineOptions(true,  
                ScreenOrientation.LANDSCAPE_FIXED, new RatioResolutionPolicy(  
                        CAMERA_WIDTH, CAMERA_HEIGHT), mCamera);  
        return engineOptions;  
    }  
  
    @Override  
    public void onCreateResources(){  
        
        // andengine's engine
        Constants.mEngine = this.mEngine;
        // application context
        Constants.mContext = this;
        // load game settings
        Settings.load();
        // load pictures & sound
        Assets.load();
        
  
    }  
  
    @Override  
    public Scene onCreateScene(){  
       MapScene mapScene = new MapScene(); 
        
        return new BattleScene();
         

    } 
    

      
}  