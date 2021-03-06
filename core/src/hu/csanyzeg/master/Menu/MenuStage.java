package hu.csanyzeg.master.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanyzeg.master.Credit.CreditScreen;
import hu.csanyzeg.master.Game.InGameScreen;
import hu.csanyzeg.master.Game.Variables;
import hu.csanyzeg.master.LoadingStage;
import hu.csanyzeg.master.MainGame;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;
import hu.csanyzeg.master.Question.QuestionScreen;
import hu.csanyzeg.master.Settings.SettingsScreen;

public class MenuStage extends MyStage {
    LabelStyle labelStyle;
    MyLabel PlayLabel;
    MyLabel SettingsLabel;
    MyLabel CreditLabel;
    MyLabel ExitLabel;
    SoundActor soundActor;
    SoundOffActor soundOffActor;
    QuestionActor questionActor;
    Variables variables;
    MenuActors menuActors;
    static AssetList assetList = new AssetList();
    static {
        assetList.addFont("alegreyaregular.otf",30);
        assetList.add(SoundActor.assetList);
        assetList.add(SoundOffActor.assetList);
        assetList.add(QuestionActor.assetList);
        assetList.add(MenuActors.assetList);

    }
    public MenuStage(MyGame game) {
        super(new ResponseViewport(500), game);
        menuActors = new MenuActors(game);
        menuActors.setWidth(getCamera().viewportWidth);
        menuActors.setHeight(getCamera().viewportHeight);
        addActor(menuActors);
        ((MainGame)game).startTime();
        Variables variables = new Variables();
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.BLACK);
        PlayLabel = new MyLabel(game, "", labelStyle);
        if (!variables.getIsFirstTime() && variables.getLang().equals("en")){
            PlayLabel.setText("Play");
        }
        if (!variables.getIsFirstTime() && variables.getLang().equals("hu")){
            PlayLabel.setText("J??t??k");
        }
        PlayLabel.setSize(100, 50);
        PlayLabel.setPosition(getCamera().viewportWidth / 2 - PlayLabel.getWidth() / 2, getCamera().viewportHeight / 2 - PlayLabel.getHeight() / 2 + 75);
        addActor(PlayLabel);
        PlayLabel.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenWithPreloadAssets(InGameScreen.class,new LoadingStage(game));
            }
        });
        SettingsLabel = new MyLabel(game, "", labelStyle);
        if (!variables.getIsFirstTime() && variables.getLang().equals("en")){
            SettingsLabel.setText("Settings");
        }
        if (!variables.getIsFirstTime() && variables.getLang().equals("hu")){
            SettingsLabel.setText("Be??ll??t??sok");
        }
        SettingsLabel.setSize(100,50);
        SettingsLabel.setPosition(getCamera().viewportWidth / 2 - SettingsLabel.getWidth() / 2, getCamera().viewportHeight / 2 - SettingsLabel.getHeight() / 2);
        addActor(SettingsLabel);
        SettingsLabel.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenWithPreloadAssets(SettingsScreen.class, new LoadingStage(game));
            }
        });
        CreditLabel = new MyLabel(game, "", labelStyle);
        if (!variables.getIsFirstTime() && variables.getLang().equals("en")){
            CreditLabel.setText("Credit");
        }
        if (!variables.getIsFirstTime() && variables.getLang().equals("hu")){
            CreditLabel.setText("Kredit");
        }
        CreditLabel.setSize(100, 50);
        CreditLabel.setPosition(getCamera().viewportWidth / 2 - CreditLabel.getWidth() / 2, getCamera().viewportHeight / 2 - CreditLabel.getHeight() / 2 - 75);
        addActor(CreditLabel);
        CreditLabel.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenWithPreloadAssets(CreditScreen.class, new LoadingStage(game));
            }
        });
        ExitLabel = new MyLabel(game, "", labelStyle);
        if (!variables.getIsFirstTime() && variables.getLang().equals("en")){
            ExitLabel.setText("Exit");
        }
        if (!variables.getIsFirstTime() && variables.getLang().equals("hu")){
            ExitLabel.setText("Kil??p??s");
        }
        ExitLabel.setSize(100, 50);
        ExitLabel.setPosition(getCamera().viewportWidth / 2 - ExitLabel.getWidth() / 2, getCamera().viewportHeight / 2 - ExitLabel.getHeight() / 2 - 150);
        addActor(ExitLabel);
        ExitLabel.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Gdx.app.exit();
            }
        });

        questionActor = new QuestionActor(game);
        questionActor.setPosition(getCamera().viewportWidth - questionActor.getWidth(), 0 );
        addActor(questionActor);

        questionActor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenWithPreloadAssets(QuestionScreen.class,new LoadingStage(game));
            }
        });
        variables = new Variables();

        if (!((MainGame) game).getMusic().isPlaying()){
            ((MainGame) game).getMusic().play();
        }

    }
}