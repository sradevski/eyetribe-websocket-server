package stevche.radevski;

import com.theeyetribe.clientsdk.GazeManager;

/**
 * Created by sradevski on 10/06/2016.
 */
public class Globs {
    public static SocketServer server;
    public static GazeManager tracker;

    public static int TRACKER_ACTIVATED = 80;
    public static int TRACKER_DEACTIVATED = 85;

    public static int TRACKER_FAILED_TO_ACTIVATE = 70;
    public static int TRACKER_NOT_ACTIVE = 75;

    public static int NO_STATUS = 0;
}
