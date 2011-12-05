package br.uff.ic.ubicomp.testes.andengine;

/**
 * @author David Barreto
 */

import java.util.Observable;
import java.util.Observer;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.ZoomCamera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.Entity;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.Scene.IOnSceneTouchListener;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.text.ChangeableText;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.input.touch.detector.ScrollDetector;
import org.anddev.andengine.input.touch.detector.ScrollDetector.IScrollDetectorListener;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.ui.activity.BaseGameActivity;

import com.google.gson.Gson;

import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Display;
import android.widget.Toast;
import br.uff.ic.ubicomp.testes.knowledge.Position;
import br.uff.ic.ubicomp.testes.knowledge.RegistryService;
import br.uff.ic.ubicomp.testes.knowledge.Widget;

public class Main extends BaseGameActivity implements Observer, IOnSceneTouchListener, IScrollDetectorListener {
// ===========================================================
// Constants			
// ===========================================================
	//private static final int CAMERA_WIDTH = 400;
	//private static final int CAMERA_HEIGHT = 400;
	private static final String TAG = "Ubicomp";
	
	private static final int LAYER_COUNT = 5;
	private static final int LAYER_FUNDO = 0;
	private static final int LAYER_OBJETOS = LAYER_FUNDO + 1;
	private static final int LAYER_PACIENTE = LAYER_OBJETOS + 1;
	private static final int LAYER_TOOLS = LAYER_PACIENTE + 1;
	private static final int LAYER_TEXTO = LAYER_TOOLS + 1;
	
	
// ===========================================================
// Fields
// ===========================================================

	private ZoomCamera mCamera;
	
	//textures
	private BitmapTextureAtlas mSpriteTexture;
	private BitmapTextureAtlas mFontTexture;
	private BitmapTextureAtlas mBackgroundTexture;
	private BitmapTextureAtlas mToolTexture;

	//texture regions
	private TextureRegion mSpriteRegion;
	private TextureRegion mFogaoTextureRegionItem;
	private TextureRegion mGeladeiraTextureRegionItem;
	private TextureRegion mNoteBookTextureRegionItem;
	private TextureRegion mBackgroundTextureRegion;
	
	
	private Sprite sprite;
	private Font mFont;
	private ChangeableText text;
	private int mCameraWidth;
	private int mCameraHeight;
	
	//scene
	private Scene mScene;

	//private EventsInterpreter eventsInterpreter;
// ===========================================================
// Constructors
// ===========================================================
	

	private int i =0 ;
	

// ===========================================================
// Getter & Setter
// ===========================================================
 

// ===========================================================
// Methods for/from SuperClass/Interfaces
// ===========================================================

	@Override
	public void onLoadComplete() {
		Log.d(TAG, "Fim do carregamento");
	}

	@Override
	public Engine onLoadEngine() {
		
		Log.d(TAG, "Carregando engine");
		
		Display display = getWindowManager().getDefaultDisplay();
		this.mCameraWidth = 299;//display.getWidth();
		this.mCameraHeight = 327;//display.getHeight();
		
		Log.d(TAG, "Cam W: " + this.mCameraWidth + ", Cam H: " + this.mCameraHeight);
		
		//Mensagem na tela quando iniciar
		Toast.makeText(this, "Teste Computacao Ubiqua", Toast.LENGTH_LONG).show();
		
		//cria a camera
	    this.mCamera = new ZoomCamera(0, 0, this.mCameraWidth, this.mCameraHeight);
	    
	    //opções da engine
	    final EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.LANDSCAPE, new RatioResolutionPolicy(this.mCameraWidth, this.mCameraHeight), this.mCamera);
	    engineOptions.getTouchOptions().setRunOnUpdateThread(true);

	    return new Engine(engineOptions);
	}

	@Override
	public void onLoadResources() {
		
		Log.d(TAG, "Carregando recursos");
		
		//Texto
		this.mFontTexture = new BitmapTextureAtlas(256, 256, TextureOptions.NEAREST);
		this.mFont = new Font(mFontTexture, Typeface.create(Typeface.DEFAULT, Typeface.BOLD), 12, true, Color.BLACK);
		
		//Path base
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		
		//Fundo
		this.mBackgroundTexture = new BitmapTextureAtlas(512, 512, TextureOptions.DEFAULT);
		this.mBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBackgroundTexture, this, "fundo_casa.png", 0, 0);
		
		//textura do toolbar
		this.mToolTexture = new BitmapTextureAtlas(512, 512, TextureOptions.DEFAULT);
		
		//itens do toolbar
		this.mFogaoTextureRegionItem = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mToolTexture, this, "fogao.png", 0, 20);
		this.mGeladeiraTextureRegionItem = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mToolTexture, this, "geladeira.png", 0, 60);
		this.mNoteBookTextureRegionItem = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mToolTexture, this, "notebook.png", 0, 40);
		
		
		//Paciente
		this.mSpriteTexture = new BitmapTextureAtlas(32, 32, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		this.mSpriteRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mSpriteTexture, this, "paciente.png", 0, 0);
			
		//Inserir as texturas
		this.mEngine.getTextureManager().loadTextures(this.mBackgroundTexture, mFontTexture, mSpriteTexture, mToolTexture);
		this.mEngine.getFontManager().loadFont(this.mFont);
		
		//Thread que escuta chamadas de dispositivos externos
		new Thread(new ExternDeviceListener(this,8085)).start();
	}

	@Override
	public Scene onLoadScene() {
		
		Log.d(TAG, "Carregando cena");
		
		this.mScene = new Scene();
		
        final int centerX = (this.mCameraWidth - this.mSpriteRegion.getWidth()) / 2;
        final int centerY = (this.mCameraHeight - this.mSpriteRegion.getHeight()) / 2;
        
		//criando camadas na cena
		for (int i = 0; i < LAYER_COUNT; i++) {
			this.mScene.attachChild(new Entity());
		}
		
		this.mScene.setBackgroundEnabled(false);
        this.mScene.getChild(LAYER_FUNDO).attachChild(new Sprite(0, 0, this.mBackgroundTextureRegion));
        
        //Texto com as coordenadas
        text = new ChangeableText(0, 0, this.mFont, "Localizacao", "Nao identificado".length());        
        this.mScene.getChild(LAYER_TEXTO).attachChild(text);
        
       
        //sprite do paciente
        sprite = new Sprite(centerX, centerY, this.mSpriteRegion) {
            @Override
            public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {            	
            	float x = pSceneTouchEvent.getX();
            	float y = pSceneTouchEvent.getY();
            	String onde = locate(x, y);
            	
            	//text.setText(onde);
            	float width = this.getWidth();
            	float height = this.getHeight();
                this.setPosition(x - width / 2, y - height / 2);
                    
                //text.setText("Calling interpreter1");
                //eventsInterpreter = EventsInterpreter.getInstance();
                String action = "";
                //action = eventsInterpreter.onLocationChanged(onde);
                text.setText(action);
                
                return true;
            }
        };
     
        this.mScene.setOnSceneTouchListener(this);
        this.mScene.getChild(LAYER_PACIENTE).attachChild(sprite);
        this.mScene.registerTouchArea(sprite);
        
        createItem(this.mFogaoTextureRegionItem, 10);
        createItem(this.mGeladeiraTextureRegionItem, 40);
        createItem(this.mNoteBookTextureRegionItem, 90);

        this.mScene.setTouchAreaBindingEnabled(true);
		
		return this.mScene;
	}

	@Override
	public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
		
		//createObject(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
		return false;
	}	
	
	@Override
	public void onScroll(final ScrollDetector pScollDetector, final TouchEvent pTouchEvent, final float pDistanceX, final float pDistanceY) {
		final float zoomFactor = this.mCamera.getZoomFactor();
		this.mCamera.offsetCenter(-pDistanceX / zoomFactor, -pDistanceY / zoomFactor);
	}
// ===========================================================
// Methods
// ===========================================================
	
	public void createObject(final float x, final float y, Sprite sprite) {
		
		Log.d(TAG, "Create object");
		
		Sprite obj = new Sprite(x - sprite.getWidth() / 2, y - sprite.getHeight() / 2, sprite.getTextureRegion()) {
            @Override
            public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {

                this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
                    
                return true;
            }
		};
		
		this.mScene.getChild(LAYER_OBJETOS).attachChild(obj);
		this.mScene.registerTouchArea(obj);
		Log.d(TAG, "Create object - fim");
	}
	
	protected String locate(float x, float y) {
		
		if (x > 160 && x < 250 && y > 224 && y < 300) //OK
			return "Quarto 2";
		if (x > 160 && x < 250 && y > 67 && y < 167) //OK
			return "Quarto 1";
		if (x > 30 && x < 160 && y > 67 && y < 177) //OK
			return "Cozinha";
		if (x > 160 && x < 250 && y > 167 && y < 224) //OK
			return "Banheiro";
		if (x > 0 && x < 250 && y > 0 && y < 67) //OK
			return "Quintal";
		if (x > 0 && x < 160 && y > 224 && y < 300) //OK
			return "Sala";
		if ( (x > 0 && x < 30 && y > 67 && y < 177) || (x > 30 && x < 160 && y > 177 && y < 224)) //OK
			return "Corredor";
		
		return "Nao identificado";
	}
	
	private void createItem(TextureRegion textreg, int offset) {
	
        Sprite sprite = new Sprite(260, offset, textreg) {
        		
        	public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
            
        		float x = pSceneTouchEvent.getX();
        		float y = pSceneTouchEvent.getY();
        		
        		if (pSceneTouchEvent.isActionUp()) {
        			if (x < 250) {
            			createObject(x, y, this);
            			Widget resource = new Widget("cooker1", "localhost", new Position(x, y));
            			RegistryService.getInstance("SRR", "localhost").register(resource);
            		}
        			//this.setPosition(getInitialX(), getInitialY());
        		}
       		
        		Log.d(TAG, "init X = " + getInitialX() + ", init Y = " + getInitialY());
        		
        		if (pSceneTouchEvent.isActionMove())
        			this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
                    
                return true;
            }
        };
        
        this.mScene.getChild(LAYER_OBJETOS).attachChild(sprite);	
        this.mScene.registerTouchArea(sprite);
	}
	
	public boolean SendMessage(String msg) {
		try {
			text.setText(msg);
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}
	/*public void startService(){
   		if (false){
   			Log.d( getClass().getSimpleName(), "Service already started" );
   		}else{
   			Intent i = new Intent("br.uff.ic.ubicomp.testes.knowledge.REMOTE_SERVICE");
   			//i.setClassName("br.uff.ic.ubicomp.testes.knowledge", "br.uff.ic.ubicomp.testes.knowledge.ResourceAgent");
   			startService(i);
   			started = true;
   			updateServiceStatus();
   			Log.d( getClass().getSimpleName(), "startService()" );
   		}
   		
	}
   
	public void stopService() {
  		if (!started) {
  			Log.d( getClass().getSimpleName(),"Service not yet started");
  		} else {
   			Intent i = new Intent("br.uff.ic.ubicomp.testes.knowledge.REMOTE_SERVICE");
   			//i.setClassName("br.uff.ic.ubicomp.testes.knowledge", "br.uff.ic.ubicomp.testes.knowledge.ResourceAgent");
   			stopService(i);
   			started = false;
   			updateServiceStatus();
   			Log.d( getClass().getSimpleName(), "stopService()" );
  		}
	}
  
	public void bindService() {
		if(conn == null) {
			conn = new RemoteServiceConnection();
			Intent i = new Intent("br.uff.ic.ubicomp.testes.knowledge.REMOTE_SERVICE");
			//i.setClassName("br.uff.ic.ubicomp.testes.knowledge", "br.uff.ic.ubicomp.testes.knowledge.ResourceAgent");
			bindService(i, conn, Context.BIND_AUTO_CREATE);
			updateServiceStatus();
			Log.d( getClass().getSimpleName(), "bindService()" );
		} else {
			Log.d( getClass().getSimpleName(), "Cannot bind - service already bound" );
		}
	}
	boolean started;
	private RemoteServiceConnection conn = null;
	public void releaseService() {
		if(conn != null) {
			unbindService(conn);
			conn = null;
			updateServiceStatus();
			Log.d( getClass().getSimpleName(), "releaseService()" );
		} else {
			Toast.makeText(this, "Cannot unbind - service not bound", Toast.LENGTH_SHORT).show();
		}
	}
    
	/*private void invokeService() {
		if(conn == null) {
			Toast.makeText(this, "Cannot invoke - service not bound", Toast.LENGTH_SHORT).show();
		} else {
			try {
				int counter = remoteService.getCounter();
				  TextView t = (TextView)findViewById(R.id.notApplicable);
				  t.setText( "Counter value: "+Integer.toString( counter ) );
				  Log.d( getClass().getSimpleName(), "invokeService()" );
			} catch (RemoteException re) {
				Log.e( getClass().getSimpleName(), "RemoteException" );
			}
		}
   	}*/	        	
	/*public void updateServiceStatus() {
  	  String bindStatus = conn == null ? "unbound" : "bound";
  	  String startStatus = started ? "started" : "not started";
  	  String remoteStatus = remoteService == null ? "not instance" : "instance";
  	  String statusText;
	  statusText = "Service status: "+
								bindStatus+
								","+
								startStatus+
								remoteStatus;
      //TextView t = (TextView)findViewById(R.id.serviceStatus);
  	  //t.setText( statusText );	
    }*/

	@Override
	public void update(Observable o, Object res) {
		// TODO Auto-generated method stub
		
		Log.d(TAG, "update!");
		Widget widget = (Widget) res;
		
		createObject(widget.getPosition().getX(), widget.getPosition().getY(), new Sprite(260, 10, this.mFogaoTextureRegionItem));
		RegistryService.getInstance("SRR", "localhost").register(widget);
	}
  
	/*public class RemoteServiceConnection implements ServiceConnection {
		  
		  public void onServiceConnected(ComponentName className, 
				IBinder boundService ) {
	        remoteService = IMyResourceService.Stub.asInterface((IBinder)boundService);
	        //TextView t = (TextView)findViewById(R.id.notApplicable);
			//t.setText( "Service Connected:"+remoteService );
	        Log.d( getClass().getSimpleName(), "onServiceConnected()" );
	      }

	      public void onServiceDisconnected(ComponentName className) {
	        remoteService = null;
			   Log.d( getClass().getSimpleName(), "onServiceDisconnected" );
	      }
	 };*/
}