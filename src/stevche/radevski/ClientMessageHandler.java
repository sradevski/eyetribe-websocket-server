package stevche.radevski;

import com.theeyetribe.clientsdk.GazeManager;

/**
 * Created by sradevski on 10/06/2016.
 */
public class ClientMessageHandler {

    public static int startTracker(){
        Globs.tracker = GazeManager.getInstance();
        boolean success = Globs.tracker.activate(GazeManager.ApiVersion.VERSION_1_0, GazeManager.ClientMode.PUSH);

        if(success){

            if(Globs.tracker.getNumGazeListeners() == 0) {
                final GazeListener gazeListener = new GazeListener();
                Globs.tracker.addGazeListener(gazeListener);
            }
            System.out.println("Tracker Activated Successfully");
            return Globs.TRACKER_ACTIVATED;
        }

        System.out.println("Failed to activate tracker. Make sure the eyeTribe server is running.");
        return Globs.TRACKER_FAILED_TO_ACTIVATE;
    }

    public static int stopTracker(){
        if(Globs.tracker != null && Globs.tracker.isActivated()){
            Globs.tracker.deactivate();
            System.out.println("Tracker Deactivated Successfully");
            return Globs.TRACKER_DEACTIVATED;
        }
        else{
            System.out.println("Tried to deactivate tracker, but tracker wasn't active.");
            return Globs.TRACKER_NOT_ACTIVE;
        }
    }
}
