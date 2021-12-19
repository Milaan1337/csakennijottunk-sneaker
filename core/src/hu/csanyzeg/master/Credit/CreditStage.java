package hu.csanyzeg.master.Credit;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.LoadingStage;
import hu.csanyzeg.master.Menu.LabelStyle;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class CreditStage extends MyStage {
    LabelStyle labelStyle;
    MyLabel developers;
    MyLabel nev;
    MyLabel nev2;
    MyLabel nev3;
    MyLabel nev4;
    CreditActors bg;
    static AssetList assetList = new AssetList();
    static {
        assetList.addFont("alegreyaregular.otf",50);
    }
    public CreditStage(MyGame game) {
        super(new ResponseViewport(500), game);
        setCameraResetToCenterOfScreen();
        addBackButtonScreenBackByStackPopListener();
        bg = new CreditActors(game);
        addActor(bg);
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.WHITE);
        developers = new MyLabel(game, "Developers:", labelStyle);
        developers.setPosition(0, 400);
        addActor(developers);
        nev = new MyLabel(game, "Fellner Milán", labelStyle);
        nev.setPosition(50, 350);
        addActor(nev);
        nev2 = new MyLabel(game, "Németh Csaba Bence", labelStyle);
        nev2.setPosition(50, 300);
        addActor(nev2);
        nev3 = new MyLabel(game, "Kancsal Máté", labelStyle);
        nev3.setPosition(50, 250);
        addActor(nev3);
        nev4 = new MyLabel(game, "Zebők Dávid Ferenc", labelStyle);
        nev4.setPosition(50, 200);
        addActor(nev4);
        nev4 = new MyLabel(game, "Back", labelStyle);
        nev4.setPosition(-195, 460);
        addActor(nev4);
        nev4.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenBackByStackPopWithPreloadAssets(new LoadingStage(game));
            }
        });

    }
}
