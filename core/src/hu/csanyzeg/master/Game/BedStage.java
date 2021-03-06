package hu.csanyzeg.master.Game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import javax.management.MXBean;

import hu.csanyzeg.master.LoadingStage;
import hu.csanyzeg.master.MainGame;
import hu.csanyzeg.master.Menu.LabelStyle;
import hu.csanyzeg.master.Menu.MenuScreen;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.Timers.IntervalTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.IntervalTimerListener;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class BedStage<timeC> extends MyStage {
    static AssetList assetList = new AssetList();
    static{
        assetList.addFont("alegreyaregular.otf",30);
        assetList.add(BedActor.assetList);
        assetList.add(BedActor2.assetList);
    }
    LabelStyle labelStyle;
    MyLabel sleepLabel;
    MyLabel onehourLabel;
    MyLabel fourhourLabel;
    MyLabel sevenhourLabel;
    MyLabel ninehourLabel;
    MyLabel timeLabel;
    MyLabel sleepLabel2;
    MyLabel backlabel;
    Variables variables;

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public BedStage(MyGame game) {
        super(new ResponseViewport(500), game);
        //timeC = new Time(this);
        //timeStage = new Time(this);
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.WHITE);
        variables = new Variables();
        sleepLabel2 = new MyLabel(game, "You're sleeping now", labelStyle);
        sleepLabel2.setPosition(getCamera().viewportWidth / 2 - sleepLabel2.getWidth() / 2, getCamera().viewportHeight / 2);
        sleepLabel = new MyLabel(game, "How many hours do you want to sleep?", labelStyle);
        sleepLabel.setPosition(getCamera().viewportWidth /2 - sleepLabel.getWidth() / 2.2f, getCamera().viewportHeight / 2 + sleepLabel.getHeight());
        addActor(sleepLabel);
        backlabel = new MyLabel(game, "Back", labelStyle);
        backlabel.setPosition(0,0);
        backlabel.setSize(backlabel.getWidth(), backlabel.getHeight());
        addActor(backlabel);
        backlabel.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenWithPreloadAssets(InGameScreen.class, new LoadingStage(game));
            }
        });
        onehourLabel = new MyLabel(game, "1 hour", labelStyle);
        onehourLabel.setPosition(getCamera().viewportWidth / 4.5f - onehourLabel.getWidth(), getCamera().viewportHeight / 2);
        addActor(onehourLabel);
        onehourLabel.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                ((MainGame)game).gameTime.sleep(3600);
                onehourLabel.remove();
                fourhourLabel.remove();
                sevenhourLabel.remove();
                ninehourLabel.remove();
                sleepLabel.remove();
                addActor(sleepLabel2);
                addTimer(new IntervalTimer(1, new IntervalTimerListener()){

                    @Override
                    public void stop() {
                        super.stop();
                        game.setScreenWithPreloadAssets(InGameScreen.class, new LoadingStage(game));
                    }
                });
            }
        });
        fourhourLabel = new MyLabel(game, "4 hour", labelStyle);
        fourhourLabel.setPosition(getCamera().viewportWidth / 3, getCamera().viewportHeight / 2);
        addActor(fourhourLabel);
        fourhourLabel.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                ((MainGame)game).gameTime.sleep(3600 * 4);
                onehourLabel.remove();
                fourhourLabel.remove();
                sevenhourLabel.remove();
                ninehourLabel.remove();
                sleepLabel.remove();
                addActor(sleepLabel2);
                addTimer(new IntervalTimer(4, new IntervalTimerListener()){

                    @Override
                    public void stop() {
                        super.stop();
                        game.setScreenWithPreloadAssets(InGameScreen.class, new LoadingStage(game));
                    }
                });
            }
        });
        sevenhourLabel = new MyLabel(game, "7 hour", labelStyle);
        sevenhourLabel.setPosition(getCamera().viewportWidth / 1.5f - sevenhourLabel.getWidth(), getCamera().viewportHeight / 2);
        addActor(sevenhourLabel);
        sevenhourLabel.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                ((MainGame)game).gameTime.sleep(3600 * 7);
                onehourLabel.remove();
                fourhourLabel.remove();
                sevenhourLabel.remove();
                ninehourLabel.remove();
                sleepLabel.remove();
                addActor(sleepLabel2);
                addTimer(new IntervalTimer(7, new IntervalTimerListener()){

                    @Override
                    public void stop() {
                        super.stop();
                        game.setScreenWithPreloadAssets(InGameScreen.class, new LoadingStage(game));
                    }
                });
            }
        });
        ninehourLabel = new MyLabel(game, "9 hour", labelStyle);
        ninehourLabel.setPosition(getCamera().viewportWidth / 1.2f, getCamera().viewportHeight / 2
        );
        addActor(ninehourLabel);
        ninehourLabel.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                ((MainGame)game).gameTime.sleep(3600 * 9);
                onehourLabel.remove();
                fourhourLabel.remove();
                sevenhourLabel.remove();
                ninehourLabel.remove();
                sleepLabel.remove();
                addActor(sleepLabel2);
                addTimer(new IntervalTimer(9, new IntervalTimerListener()){

                    @Override
                    public void stop() {
                        super.stop();
                        game.setScreenWithPreloadAssets(InGameScreen.class, new LoadingStage(game));
                    }
                });
            }
        });
        if (!variables.getIsFirstTime() && variables.getLang().equals("en")){
            backlabel.setText("Back");
            backlabel.setSize(backlabel.getWidth(), backlabel.getHeight());
        }
        if (!variables.getIsFirstTime() && variables.getLang().equals("hu")){
            backlabel.setText("Vissza");
            backlabel.setSize(backlabel.getWidth() + 20, backlabel.getHeight());
        }
        if (!variables.getIsFirstTime() && variables.getLang().equals("en")){
            sleepLabel.setText("How many hours do you want to sleep?");
        }
        if (!variables.getIsFirstTime() && variables.getLang().equals("hu")){
            sleepLabel.setText("H??ny ??r??t szeretn??l aludni?");
        }
        if (!variables.getIsFirstTime() && variables.getLang().equals("en")){
            sleepLabel2.setText("You're sleeping now.");
        }
        if (!variables.getIsFirstTime() && variables.getLang().equals("hu")){
            sleepLabel2.setText("??ppen alszol.");
        }
        if (!variables.getIsFirstTime() && variables.getLang().equals("en")){
            onehourLabel.setText("1 hour");
        }
        if (!variables.getIsFirstTime() && variables.getLang().equals("hu")){
            onehourLabel.setText("1 ??ra");
        }
        if (!variables.getIsFirstTime() && variables.getLang().equals("en")){
            fourhourLabel.setText("4 hour");
        }
        if (!variables.getIsFirstTime() && variables.getLang().equals("hu")) {
            fourhourLabel.setText("4 ??ra");
        }
        if (!variables.getIsFirstTime() && variables.getLang().equals("en")){
            sevenhourLabel.setText("7 hour");
        }
        if (!variables.getIsFirstTime() && variables.getLang().equals("hu")) {
            sevenhourLabel.setText("7 ??ra");
        }
        if (!variables.getIsFirstTime() && variables.getLang().equals("en")){
            ninehourLabel.setText("9 hour");
        }
        if (!variables.getIsFirstTime() && variables.getLang().equals("hu")) {
            ninehourLabel.setText("9 ??ra");
        }
    }
}
