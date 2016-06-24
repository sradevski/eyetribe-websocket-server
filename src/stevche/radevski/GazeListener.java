package stevche.radevski;

import com.google.gson.Gson;
import com.theeyetribe.clientsdk.IGazeListener;
import com.theeyetribe.clientsdk.data.GazeData;

/**
 * Created by sradevski on 10/06/2016.
 */

public class GazeListener implements IGazeListener
{
    @Override
    public void onGazeUpdate(GazeData gazeData)
    {
        if(Globs.server != null){
            if(Globs.server.numOfConnections > 0){
                Gson gson = new Gson();
                EyeNavGazeData eyeNavGazeData  = new EyeNavGazeData(gazeData.smoothedCoordinates.x,
                        gazeData.smoothedCoordinates.y, gazeData.timeStamp, gazeData.state);

                String json = gson.toJson(eyeNavGazeData);
                Globs.server.sendToAll(json);
            }
        }
    }
}