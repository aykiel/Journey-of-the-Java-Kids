import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;
import java.awt.*;

public class GriddedSprite extends Sprite {
	private AffineTransform transform;

	private int SPRITE_WIDTH;
	private int SPRITE_HEIGHT;

	private int x;
	private int y;

	private int width;

	private int SCALE_FACTOR;

	private int num = 0;

	private boolean animates = true;

	public GriddedSprite(String file, int width, int height, int SCALE_FACTOR) {
		super(file, width, height);

		transform = new AffineTransform();

		this.width = width;
		this.SCALE_FACTOR = SCALE_FACTOR;

		setLayout(null);

		transform.scale(SCALE_FACTOR, SCALE_FACTOR);

		if (getRows() > 1 | getColumns() > 1)
			animates = false;
	}

	public GriddedSprite(String file, int x, int y, int width, int height, int SCALE_FACTOR) {
		super(file, width, height);

		transform = new AffineTransform();

		this.width = width;
		this.SCALE_FACTOR = SCALE_FACTOR;
		this.x = x;
		this.y = y;

		setLayout(null);

		transform.scale(SCALE_FACTOR, SCALE_FACTOR);

		if (getRows() > 1 | getColumns() > 1)
			animates = false;
	}


	public void draw(Graphics2D g, int x, int y, ImageObserver obs) {
		//transform.setToRotation((Math.PI),  ((SPRITE_WIDTH*SCALE_FACTOR / 2) + x), ((SPRITE_HEIGHT*SCALE_FACTOR / 2) + y));
		//System.out.println(num);

		g.setTransform(transform);
		g.drawImage(getSubimage(num), x, y, obs);

		if (num == getRows() - 1)
			num = 0;
		else
			num++;

		//g.drawImage(getSubimage(num), transform, obs);
	}

	public void draw(Graphics2D g, ImageObserver obs) {
		//transform.setToRotation((Math.PI),  ((SPRITE_WIDTH*SCALE_FACTOR / 2) + x), ((SPRITE_HEIGHT*SCALE_FACTOR / 2) + y));
		//System.out.println(num);

		g.setTransform(transform);
		g.drawImage(getSubimage(num), x, y, obs);

		if (num == getRows() - 1)
			num = 0;
		else
			num++;

		//g.drawImage(getSubimage(num), transform, obs);
	}

	public void setX(int x){
		this.x =x;
	}

	public void setY (int y) {
		this.y = y;
	}

	public int getY(){
		return y;
	}

}