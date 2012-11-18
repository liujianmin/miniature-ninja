package com.example.hero30kingdomrush;

import android.graphics.Color;

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
import org.andengine.util.debug.Debug;

public class Assets {
    
    private static Font mFont;  
    private static BitmapTextureAtlas mBackgroundTexture;  
    private static ITextureRegion mBackgroundTextureRegion;  
    
    
    //TiledTextureRegion
    static TiledTextureRegion tiledTextureRegion ;
    static TiledTextureRegion sheeptiledTextureRegion;
    static TiledTextureRegion herotiledTextureRegion;

    public static void load() {
        // TODO Auto-generated method stub
        
        /* Load the font we are going to use. */  
        FontFactory.setAssetBasePath("font/");  
        mFont = FontFactory.createFromAsset(Constants.mEngine.getFontManager(),  
                Constants.mEngine.getTextureManager(), 512, 512, TextureOptions.BILINEAR,  
                Constants.mContext.getAssets(), "Plok.ttf", 32, true, Color.WHITE);  
        mFont.load();  
  
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");  
        /* Load all the textures this game needs. */  
        mBackgroundTexture = new BitmapTextureAtlas(  
                Constants.mEngine.getTextureManager(), 800, 480);  
        mBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory  
                .createFromAsset(mBackgroundTexture, Constants.mContext, "snake_background.png",  
                        0, 0);  
        mBackgroundTexture.load();
        
        
        //TiledTextureRegion
        tiledTextureRegion = getTiledTextureFromPack("fireman");
        sheeptiledTextureRegion = getTiledTextureFromPack("sheep");
        herotiledTextureRegion = getTiledTextureFromPack("fighter");
    }
    private static TiledTextureRegion getTiledTextureFromPack(String name) {
        TexturePackTextureRegionLibrary packer =null;
        TexturePack spritesheetTexturePack = null;
        try {
            spritesheetTexturePack = new TexturePackLoader(Constants.mEngine.getTextureManager(), "gfx/")
                    .loadFromAsset(Constants.mContext.getAssets(), name + ".xml");
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
