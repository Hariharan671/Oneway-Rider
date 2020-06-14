package com.harryh5n1.onewayrider;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import java.util.Random;
import java.util.Timer;

public class OnewayRider extends ApplicationAdapter {
	SpriteBatch batch;
	Texture road,f1,f2,f3,f4,f5,f6,lf,rg,dw,go,play;
	Random random=new Random();
	int o=0;
	int l=0;boolean game=true;int k,y;
	int v1,v2,v3,v4,v5,v6,h1,h2,h3,h4,h5,h6,velocity=5;
	String[] car={"f2","f3","f4","f5","f6"};
	int u,v;
	Circle circle;
	ShapeRenderer shapeRenderer;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		road=new Texture("roar.png");
		f1=new Texture("f1.png");
		shapeRenderer=new ShapeRenderer();
		lf=new Texture("leftarrow.png");
		dw=new Texture("down.png");
		rg=new Texture("ri8arrow.png");
		f2=new Texture(car[random.nextInt(5)]+".png");
		f3=new Texture(car[random.nextInt(5)]+".png");
		f4=new Texture(car[random.nextInt(5)]+".png");
		f5=new Texture(car[random.nextInt(5)]+".png");
		f6=new Texture(car[random.nextInt(5)]+".png");
		go=new Texture("go.png");
		play=new Texture("play.png");
	}
	@Override
	public void render () {
		batch.begin();//brake system
		batch.draw(road,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		if(Gdx.input.isTouched()){
			circle=new Circle(u,v,play.getWidth());
			Vector3 temp = new Vector3(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY(), 0);
			if(circle.contains(temp.x,temp.y)){
				u=-1000;v=-1000;
				y=1;
				circle=new Circle(u,v,play.getWidth());
				batch.draw(go,+1000,-1000);
				batch.draw(play,u,v);
				start();
				v1=Gdx.graphics.getWidth() / 2 - f1.getWidth() / 2;
				h1=100;
				game=true;
				batch.draw(f1, v1, h1);
			}
		}
		if(o==0) {
			v1=Gdx.graphics.getWidth() / 2 - f1.getWidth() / 2;
			h1=100;
			batch.draw(f1, v1, h1);
		}
		batch.draw(lf,0,300);
		if(y==0){
			batch.draw(go,Gdx.graphics.getWidth()/2-go.getWidth()/2,(2*Gdx.graphics.getHeight())/3);
			batch.draw(play,Gdx.graphics.getWidth()/2-play.getWidth()/2,(2*Gdx.graphics.getHeight())/3-250);
		}
		//batch.draw(dw,Gdx.graphics.getWidth()/2-dw.getWidth()/2,0);
		batch.draw(rg,Gdx.graphics.getWidth()-rg.getWidth(),300);
		if(game) {
			if (l == 0) {
				start();
				l = 1;
			} else if(l == 1) {
				if (h2<= -f2.getHeight()) {
					h2=(Gdx.graphics.getHeight()) + 6*Gdx.graphics.getHeight()/3;
					f2=new Texture(car[random.nextInt(5)]+".png");
					v2=random.nextInt(Gdx.graphics.getWidth()-370)+30;
					batch.draw(f2,v2,h2);
				} else if (h3 <= -f2.getHeight()) {
					f3=new Texture(car[random.nextInt(5)]+".png");
					h3=(Gdx.graphics.getHeight()) + 6*Gdx.graphics.getHeight()/3;
					v3=random.nextInt(Gdx.graphics.getWidth()-370)+30;
					batch.draw(f3,v3,h3);
				} else if (h4 <= -f2.getHeight()) {
					f4=new Texture(car[random.nextInt(5)]+".png");
					v4=random.nextInt(Gdx.graphics.getWidth()-370)+30;
					h4=(Gdx.graphics.getHeight()) + 6*Gdx.graphics.getHeight()/3;
					batch.draw(f4,v4,h4);
				} else if (h5 <= -f2.getHeight()) {
					f5=new Texture(car[random.nextInt(5)]+".png");
					v5=random.nextInt(Gdx.graphics.getWidth()-370)+30;
					h5=(Gdx.graphics.getHeight()) + 6*Gdx.graphics.getHeight()/3;
					batch.draw(f5,v5,h5);
				} else if (h6 <= -f2.getHeight()) {
					f6=new Texture(car[random.nextInt(5)]+".png");
					velocity++;
					v6=random.nextInt(Gdx.graphics.getWidth()-370)+30;
					h6=(Gdx.graphics.getHeight()) + 6*Gdx.graphics.getHeight()/3;
					batch.draw(f6,v6,h6);
				} else {
					h2=h2-velocity;
					h3=h3-velocity;
					h4=h4-velocity;
					h5=h5-velocity;
					h6=h6-velocity;
					batch.draw(f2,v2,h2);batch.draw(f3,v3,h3);batch.draw(f4,v4,h4);batch.draw(f5,v5,h5);batch.draw(f6,v6,h6);
				}
			}
		}
		if(k==0){
		if (Gdx.input.isTouched()) {
			Rectangle left = new Rectangle(0, 300, lf.getWidth(), lf.getHeight());
			Rectangle cax = new Rectangle(v1, h1, f1.getWidth(), f1.getHeight());
			Rectangle rf = new Rectangle(Gdx.graphics.getWidth() - rg.getWidth(), 300, rg.getWidth(), rg.getHeight());
			Vector3 tmp = new Vector3(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY(), 0);
			if (left.contains(tmp.x, tmp.y) && !rf.contains(tmp.x, tmp.y)) {
				o = 1;
				v1 = v1 - 5;
				if (v1 < 30) {
					//Gdx.app.log("Collision","sss");
					gameover();
					o = 0;
				}
			} else if (rf.contains(tmp.x, tmp.y) && !left.contains(tmp.x, tmp.y)) {
				o = 1;
				v1 = v1 + 5;
				if (v1 > Gdx.graphics.getWidth() - 340) {
					//Gdx.app.log("Collision","sss");
					gameover();
					o = 0;
				}
			} else if (rf.contains(tmp.x, tmp.y) && left.contains(tmp.x, tmp.y)) {
				o = 1;
				h1 = h1 - 5;
				if (h1 < 0) {
					//Gdx.app.log("Collision","sss");
					gameover();
					o = 0;
				}
			} else if (cax.contains(tmp.x, tmp.y)) {
				o = 1;
				h1 = h1 + 5;
				if (h1 > Gdx.graphics.getHeight()-f1.getHeight()) {
					gameover();
					//Gdx.app.log("Collision","sss");
					o = 0;
				    }
			    }
		    }
		}
		batch.draw(f1, v1, h1);

        Rectangle carac1=new Rectangle(v1+60,h1+80,f1.getWidth()-120,f1.getHeight()-140);
        Rectangle carac2=new Rectangle(v2+60,h2+80,f1.getWidth()-120,f1.getHeight()-140);
        Rectangle carac3=new Rectangle(v3+60,h3+80,f1.getWidth()-120,f1.getHeight()-140);
        Rectangle carac4=new Rectangle(v4+60,h4+80,f1.getWidth()-120,f1.getHeight()-140);
        Rectangle carac5=new Rectangle(v5+60,h5+80,f1.getWidth()-120,f1.getHeight()-140);
        Rectangle carac6=new Rectangle(v6+60,h6+80,f1.getWidth()-120,f1.getHeight()-140);
        if(Intersector.overlaps(carac1,carac2)||Intersector.overlaps(carac1,carac3)||Intersector.overlaps(carac1,carac4)||Intersector.overlaps(carac1,carac5)||Intersector.overlaps(carac1,carac6)){
            //Gdx.app.log("Collision","sss");
			gameover();
        }
		/*shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.BLUE);
		shapeRenderer.rect(v2+60,h2+80,f2.getWidth()-120,f2.getHeight()-140);
		shapeRenderer.end();*/
		batch.end();

	}
	//Gdx.graphics.getWidth()-340,30
	public void gameover(){

		k=1;
		start();
		y=0;
		u=Gdx.graphics.getWidth()/2-play.getWidth()/2;
		v=(2*Gdx.graphics.getHeight())/3-250;
		game=false;
	}
	public void start(){
		y=1;
		o=0;
		k=0;
		v2=random.nextInt(Gdx.graphics.getWidth()-370)+30;
		v3=random.nextInt(Gdx.graphics.getWidth()-370)+30;
		v4=random.nextInt(Gdx.graphics.getWidth()-370)+30;
		v5=random.nextInt(Gdx.graphics.getWidth()-370)+30;
		v6=random.nextInt(Gdx.graphics.getWidth()-370)+30;
		h2=Gdx.graphics.getHeight();
		h3=(Gdx.graphics.getHeight()) + 2*Gdx.graphics.getHeight()/3;
		h4=(Gdx.graphics.getHeight()) + 4*Gdx.graphics.getHeight()/3;
		h5=(Gdx.graphics.getHeight()) + 6*Gdx.graphics.getHeight()/3;
		h6=(Gdx.graphics.getHeight()) + 8*Gdx.graphics.getHeight()/3;
		batch.draw(f2,v2,h2);
		batch.draw(f3,v3,h3);
		batch.draw(f4,v4,h4);
		batch.draw(f5,v5,h5);
		batch.draw(f6,v6,h6);
		l=1;
	}

	@Override
	public void dispose () {
	}
}
