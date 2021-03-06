package com.opi.export.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.opi.export.Drawable;
import com.opi.export.Export;
import com.opi.export.MasterDrawer;
import com.opi.export.Tickable;

public class Level implements Drawable, Tickable {
	
	public static final int DISTANCE_BETWEEN_LEVELS = (int) Tile.SIZE * 2;
	
	private Tile[][] tiles;
	private Entity[][] entities;
	private float mx;
	private float my;
	private int levelID;
	private Vector2 enter;
	
	public Level(Tile[][] tiles, Entity[][] entities, int levelID, Vector2 enter) {
		this.tiles = tiles;
		this.entities = entities;
		this.levelID = levelID;
		this.enter = enter;
	}
	
	public void initialize() {
		for(int x = 0; x < entities.length; x++) {
			for(int y = 0; y < entities[0].length; y++) {
				entities[x][y].setPosition(mx + (x * Tile.SIZE), my + (y * Tile.SIZE));
			}
		}
	}
	
	@Override
	public void tick() {
		for(int x = 0; x < tiles.length; x++) {
			for(int y = 0; y < tiles[0].length; y++) {
				tiles[x][y].tick();
			}
		}
		
		for(int x = 0; x < entities.length; x++) {
			for(int y = 0; y < entities[0].length; y++) {
				entities[x][y].tick();
			}
		}
	}

	public void draw(SpriteBatch batch) {
		for(int x = 0; x < tiles.length; x++) {
			for(int y = 0; y < tiles[0].length; y++) {
				tiles[x][y].draw(batch, mx + (x * Tile.SIZE), my + (y * Tile.SIZE));
			}
		}
		
		for(int x = 0; x < entities.length; x++) {
			for(int y = 0; y < entities[0].length; y++) {
				MasterDrawer.add(entities[x][y]);
			}
		}
	}
	

	public void setPosition(float mx, float my) {
		this.mx = mx;
		this.my = my;
	}

	public Tile getTile(int tx, int ty) {
		return tiles[tx][ty];
	}
	
	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}
	
	public Entity getEntity(int ex, int ey) {
		return entities[ex][ey];
	}
	
	public int getLevelWidth() {
		return tiles.length;
	}
	
	public int getLevelHeight() {
		return tiles[0].length;
	}
	
	public float getX() {
		return mx;
	}
	
	public float getY() {
		return my;
	}
	
	public int getLevelID() {
		return levelID;
	}
	
	public Vector2 getTilePosition(int tx, int ty) {
		return new Vector2(getX() + (tx * Tile.SIZE), getY() + (ty * Tile.SIZE));
	}
	
	public Vector2 getEnterPosition() {
		return enter;
	}
	
	public Vector2 getCenteredPosition() {
		float x = (Export.WIDTH / 2) - ((getLevelWidth() * Tile.SIZE) / 2);
		float y = (Export.HEIGHT / 2) - ((getLevelHeight() * Tile.SIZE) / 2);
		
		return new Vector2(x, y);
	}
}
