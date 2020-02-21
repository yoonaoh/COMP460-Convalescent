//package com.mystudio.gamename;
// TODO: ??
//import com.badlogic.gdx.ApplicationAdapter;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Input.Keys;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.math.MathUtils;
//import com.badlogic.gdx.math.Rectangle;
//import com.badlogic.gdx.math.Vector3;
//import com.badlogic.gdx.utils.Array;
//import com.badlogic.gdx.utils.TimeUtils;
//
//import java.util.Iterator;
//
//public class Drop extends ApplicationAdapter {
//    private Texture dropImage;
//    private Texture bucketImage;
//    private SpriteBatch batch;
//    private OrthographicCamera camera;
//    private Rectangle bucket;
//    private Array<Rectangle> raindrops;
//    private long lastDropTime;
//    private int leftToCatch;
//    private boolean complete;
//    private boolean start;
//
//    @Override
//    public void create() {
//        // load the images for the droplet and the bucket, 64x64 pixels each
//        dropImage = new Texture(Gdx.files.internal("dropGecko.png"));
//        bucketImage = new Texture(Gdx.files.internal("bucket.png"));
//
//        // create the camera and the SpriteBatch
//        camera = new OrthographicCamera();
//        camera.setToOrtho(false, 800, 480);
//        batch = new SpriteBatch();
//
//        // create a Rectangle to logically represent the bucket
//        bucket = new Rectangle();
//        bucket.x = (float) ((800 / 2) - (64 / 2)); // center the bucket horizontally
//        bucket.y = 20; // bottom left corner of the bucket is 20 pixels above the bottom screen edge
//        bucket.width = 64;
//        bucket.height = 64;
//
//        // create the raindrops array and spawn the first raindrop
//        raindrops = new Array<Rectangle>();
//        leftToCatch = 4;
//        spawnRaindrop();
//        complete = false;
//        start = false;
//    }
//
//    private void spawnRaindrop() {
//        Rectangle raindrop = new Rectangle();
//        raindrop.x = MathUtils.random(0, 800 - 64);
//        raindrop.y = 480;
//        raindrop.width = 64;
//        raindrop.height = 64;
//        raindrops.add(raindrop);
//        lastDropTime = TimeUtils.nanoTime();
//    }
//
//    @Override
//    public void render() {
//        // clear the screen with a dark blue color. The
//        // arguments to glClearColor are the red, green
//        // blue and alpha component in the range [0,1]
//        // of the color to be used to clear the screen.
//        Gdx.gl.glClearColor(0.2f, 0.49f, 0.3f, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//        // tell the camera to update its matrices.
//        camera.update();
//
//        // tell the SpriteBatch to render in the
//        // coordinate system specified by the camera.
//        batch.setProjectionMatrix(camera.combined);
//
//        // begin a new batch and draw the bucket and
//        // all drops
//        batch.begin();
//        batch.draw(bucketImage, bucket.x, bucket.y);
//        for (Rectangle raindrop : raindrops) {
//            batch.draw(dropImage, raindrop.x, raindrop.y, 50, 50);
//        }
//        batch.end();
//
//        // process user input
//        if (Gdx.input.isTouched()) {
//            Vector3 touchPos = new Vector3();
//            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
//            camera.unproject(touchPos);
//            bucket.x = (float) (touchPos.x - (64.0 / 2.0));
//        }
//        if (Gdx.input.isKeyPressed(Keys.LEFT)) bucket.x -= 200 * Gdx.graphics.getDeltaTime();
//        if (Gdx.input.isKeyPressed(Keys.RIGHT)) bucket.x += 200 * Gdx.graphics.getDeltaTime();
//
//        // make sure the bucket stays within the screen bounds
//        if (bucket.x < 0) bucket.x = 0;
//        if (bucket.x > 800 - 64) bucket.x = 800 - 64;
//
//        // check if we need to create a new raindrop
//        if (leftToCatch > 0) {
//            if (TimeUtils.nanoTime() - lastDropTime > 1000000000) {
//                spawnRaindrop();
//
//            }
//        } else {
//            complete = true;
//        }
//
//        // move the raindrops, remove any that are beneath the bottom edge of
//        // the screen or that hit the bucket. In the latter case we play back
//        // a sound effect as well.
//        for (Iterator<Rectangle> iter = raindrops.iterator(); iter.hasNext(); ) {
//            Rectangle raindrop = iter.next();
//            raindrop.y -= 200 * Gdx.graphics.getDeltaTime();
//            if (raindrop.y + 64 < 0) iter.remove();
//            if (raindrop.overlaps(bucket)) {
//                iter.remove();
//                leftToCatch--;
//            }
//        }
//    }
//
//    @Override
//    public void dispose() {
//        // dispose of all the native resources
//        dropImage.dispose();
//        bucketImage.dispose();
//        batch.dispose();
//    }
//
//    public boolean isCompleted() {
//        return complete;
//    }
//
//    public boolean hasStarted() {
//        return start;
//    }
//
//    public void start() {
//        start = true;
//    }
//}
