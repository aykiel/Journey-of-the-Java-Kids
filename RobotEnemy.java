public class RobotEnemy extends GriddedSprite
{
    public RobotEnemy(String file, int width, int height, int SCALE_FACTOR)
    {
        super(file, width, height, SCALE_FACTOR);
    }

    public GriddedSprite move()
    {
        lookAtPlayer();
        //just so it compiles, remove after testing
        return null;
    }

    public void lookAtPlayer()
    {
        //have code to change sprite to look at player.
        //could use information from move to determine the
        //direction it looks towards
    }

    public void shoot()
    {
        //Not exactly sure what will be here and not sure
        //if it will work
    }
}
