package com.example.hero30kingdomrush;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class HeroSprite extends AnimatedSprite implements ISpriteActionInterface{

	public HeroSprite(float pX, float pY,
			ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager) {
		super(pX, pY, pTiledTextureRegion, pVertexBufferObjectManager);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void Runnable() {
		// TODO Auto-generated method stub
		animate(new long[]{100,100,100,100,100,100}, 28, 33, true);
		//animate(new long[]{100,100,100,100,100,100,100,100,100,100},new int[]{28,29,30,31,32,33,32,31,30,29},true);
		//animate
	}

	@Override
	public void Appeare() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Disappeare() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Attack() {
		// TODO Auto-generated method stub
		animate(new long[]{100,100,100}, 34, 36, true);
		
	}
	@Override
	public void setSpeed(int x, int y) {
		// TODO Auto-generated method stub
		
	}




}
