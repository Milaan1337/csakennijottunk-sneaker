package hu.csanyzeg.master.Game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.LoadingStage;
import hu.csanyzeg.master.MainGame;
import hu.csanyzeg.master.Menu.LabelStyle;
import hu.csanyzeg.master.Menu.MenuScreen;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class ControlStage extends MyStage {
    protected InGameStage inGameStage;
    OneSpriteStaticActor actor;
    OneSpriteStaticActor actor2;
    OneSpriteStaticActor actor3;
    OneSpriteStaticActor actor4;
    Variables variables;
    ControllerActor controllerActor;
    MyLabel timeLabel;
    MyLabel backLabel;


    public ControlStage(MyGame game, InGameStage inGameStage) {
        super(new ResponseViewport(500), game);
        this.inGameStage = inGameStage;

        LabelStyle labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.BLACK);

        timeLabel = new MyLabel(game, "",labelStyle);
        timeLabel.setPosition(180,40);
        addActor(timeLabel);


        controllerActor = new ControllerActor(game);
        controllerActor.setPosition(0,0);
        controllerActor.setSize(controllerActor.getWidth() * 1.5f, controllerActor.getHeight() * 1.5f);
        addActor(controllerActor);

        variables = new Variables();
        actor = new OneSpriteStaticActor(game, "blank.png");
        addActor(actor);
        actor.setSize(40f,40f);
        actor.setPosition((float) ((controllerActor.getWidth() / 2) - actor.getWidth()/2), 35);
        actor.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("KATT LE");
                //isBottomPressed = true;
                inGameStage.setBottomPressed(true);
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                //isBottomPressed = false;
                inGameStage.setBottomPressed(false);
            }
        });



        actor2 = new OneSpriteStaticActor(game, "blank.png");
        addActor(actor2);
        actor2.setSize(40f,40f);
        actor2.setPosition((float) ((controllerActor.getWidth() / 2) - actor.getWidth()/2), 110);
        actor2.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("KATT LE");
                //isTopPressed = true;
                inGameStage.setTopPressed(true);
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                //isTopPressed = false;
                inGameStage.setTopPressed(false);
                System.out.println("KATT FEL");
            }
        });

        backLabel = new MyLabel(game, "Back", labelStyle);
        backLabel.setSize(backLabel.getWidth(), backLabel.getHeight());
        backLabel.setPosition(0, getCamera().viewportHeight - backLabel.getHeight());
        addActor(backLabel);
        backLabel.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenWithPreloadAssets(MenuScreen.class, new LoadingStage(game));
            }
        });
        if (!variables.getIsFirstTime() && variables.getLang().equals("en")){
            backLabel.setText("Back");
            backLabel.setSize(backLabel.getWidth(), backLabel.getHeight());
        }
        if (!variables.getIsFirstTime() && variables.getLang().equals("hu")){
            backLabel.setText("Vissza");
            backLabel.setSize(backLabel.getWidth() + 20, backLabel.getHeight());
        }

        actor3 = new OneSpriteStaticActor(game, "blank.png");
        addActor(actor3);
        actor3.setSize(40f,40f);
        actor3.setPosition(30, 70);
        actor3.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("KATT LE");
                //isLeftPressed = true;
                inGameStage.setLeftPressed(true);
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                //isLeftPressed = false;
                inGameStage.setLeftPressed(false);
                System.out.println("KATT FEL");
            }
        });

        actor4 = new OneSpriteStaticActor(game, "blank.png");
        addActor(actor4);
        actor4.setSize(40f,40f);
        actor4.setPosition(110, 70);
        actor4.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("KATT LE");
                //isRightPressed = true;
                inGameStage.setRightPressed(true);
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                //isRightPressed = false;
                inGameStage.setRightPressed(false);
                System.out.println("KATT FEL");
            }
        });



    }

    @Override
    public void act(float delta) {
        super.act(delta);
        timeLabel.setText(((MainGame)game).gameTime.toString());
    }
}
