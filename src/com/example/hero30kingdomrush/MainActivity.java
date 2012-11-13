package com.example.hero30kingdomrush;




  
import android.graphics.Color;
import android.opengl.GLES20;

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
  
    private Scene mScene;  
  
    private Font mFont;  
    private BitmapTextureAtlas mBackgroundTexture;  
    private ITextureRegion mBackgroundTextureRegion;  
      
    private Text mHelloText;  
  
    public EngineOptions onCreateEngineOptions() {  
        Camera mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);  
        final EngineOptions engineOptions = new EngineOptions(true,  
                ScreenOrientation.LANDSCAPE_FIXED, new RatioResolutionPolicy(  
                        CAMERA_WIDTH, CAMERA_HEIGHT), mCamera);  
        return engineOptions;  
    }  
  
    @Override  
    public void onCreateResources(){  
        /* Load the font we are going to use. */  
        FontFactory.setAssetBasePath("font/");  
        this.mFont = FontFactory.createFromAsset(this.getFontManager(),  
                this.getTextureManager(), 512, 512, TextureOptions.BILINEAR,  
                this.getAssets(), "Plok.ttf", 32, true, Color.WHITE);  
        this.mFont.load();  
  
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");  
        /* Load all the textures this game needs. */  
        this.mBackgroundTexture = new BitmapTextureAtlas(  
                this.getTextureManager(), 800, 480);  
        this.mBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory  
                .createFromAsset(this.mBackgroundTexture, this, "snake_background.png",  
                        0, 0);  
        this.mBackgroundTexture.load();  
    }  
  
    @Override  
    public Scene onCreateScene(){  
        this.mScene = new Scene();  
        for (int i = 0; i < LAYER_COUNT; i++) {  
            this.mScene.attachChild(new Entity());  
        }  
  
        /* No background color needed as we have a fullscreen background sprite. */  
    //    this.mScene.setBackgroundEnabled(false);  
        mScene.setBackground(new Background(1, 1, 1));
      //  this.mScene.getChildByIndex(LAYER_BACKGROUND).attachChild(  
      //          new Sprite(0, 0, this.mBackgroundTextureRegion, this  
       //                 .getVertexBufferObjectManager()));  
          
        this.mHelloText=new Text(CAMERA_WIDTH/2 - 80, CAMERA_HEIGHT/2 - 16, this.mFont, "Hello World !", this.getVertexBufferObjectManager());  
        this.mHelloText.setBlendFunction(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE_MINUS_SRC_ALPHA);  
        this.mHelloText.setAlpha(0.6f);  
        this.mScene.getChildByIndex(LAYER_TEXT).attachChild(this.mHelloText);  
        
        TiledTextureRegion tiledTextureRegion = getTiledTextureFromPack("fireman");
         
         
         AnimatedSprite sprite = new AnimatedSprite((CAMERA_WIDTH - tiledTextureRegion.getWidth()) / 2,
                 (CAMERA_HEIGHT - tiledTextureRegion.getHeight()) / 2,
                 tiledTextureRegion, this.getVertexBufferObjectManager());
         
         sprite.animate(100);
        // sprite.
         
         this.mScene.attachChild(sprite);
        
          
        return this.mScene;  
    } 
    
    private TiledTextureRegion getTiledTextureFromPack(String name) {
        TexturePackTextureRegionLibrary packer =null;
        TexturePack spritesheetTexturePack = null;
        try {
            spritesheetTexturePack = new TexturePackLoader(this.getTextureManager(), "gfx/")
                    .loadFromAsset(getAssets(), name + ".xml");
            spritesheetTexturePack.loadTexture();
            packer = spritesheetTexturePack.getTexturePackTextureRegionLibrary();
        } catch (final TexturePackParseException e) {
            Debug.e(e);
        }

        TexturePackerTextureRegion[] obj = new TexturePackerTextureRegion[packer
                .getIDMapping().size()];

        for (int i = 0; i < packer.getIDMapping().size(); i++) {
            obj[i] = packer.get(i);
        }

        TiledTextureRegion texture = new TiledTextureRegion(spritesheetTexturePack.getTexture(),
                obj);

        return texture;
    }
      
}  