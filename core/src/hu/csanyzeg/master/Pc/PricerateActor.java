package hu.csanyzeg.master.Pc;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class PricerateActor extends OneSpriteStaticActor {
    static AssetList assetList = new AssetList();
    static{
        assetList.addFont("alegreyaregular.otf", 10);
        assetList.addTexture("blue.png");
    }
    public PricerateActor(MyGame game) {
        super(game, "blue.png");
    }
}
