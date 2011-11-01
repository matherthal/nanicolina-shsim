package br.uff.ic.ubicomp.testes.andengine;

import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

public class RecursoImage extends Sprite {
	
	private float initX;
	private float initY;

	public RecursoImage(float pX, float pY, float pWidth, float pHeight,
			TextureRegion pTextureRegion, float initX, float initY) {
		
		super(pX, pY, pWidth, pHeight, pTextureRegion);
		
		this.initX = initX;
		this.initY = initY;
		// TODO Auto-generated constructor stub
	}
	
	public RecursoImage(float pX, float pY, TextureRegion pTextureRegion, float initX, float initY) {
		super(pX, pY, pTextureRegion);
		
		this.initX = initX;
		this.initY = initY;
		// TODO Auto-generated constructor stub
	}

}
