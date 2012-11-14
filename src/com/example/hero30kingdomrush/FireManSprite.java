package com.example.hero30kingdomrush;

import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.sprite.vbo.ISpriteVertexBufferObject;
import org.andengine.entity.sprite.vbo.ITiledSpriteVertexBufferObject;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class FireManSprite extends AnimatedSprite implements ISpriteActionInterface{





	public FireManSprite(float pX, float pY,
			ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager) {
		super(pX, pY, pTiledTextureRegion, pVertexBufferObjectManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Runnable() {
		// TODO Auto-generated method stub
		
		//this.a
		
	}

	@Override
	public void Appeare() {
		// TODO Auto-generated method stub
		//this.get
		animate(new long[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100}, 38, 51, true);
	}

	@Override
	public void Disappeare() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Attack() {
		// TODO Auto-generated method stub
		
	}
	

}
