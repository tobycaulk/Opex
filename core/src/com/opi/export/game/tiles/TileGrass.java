package com.opi.export.game.tiles;

import com.opi.export.AssetsHandler;
import com.opi.export.game.Tile;

public class TileGrass extends Tile {

	public TileGrass() {
		super(AssetsHandler.getSpriteTexture("grass"));
	}
}
