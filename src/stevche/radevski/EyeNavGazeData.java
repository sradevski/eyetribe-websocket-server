package stevche.radevski;

import com.google.gson.annotations.SerializedName;
import com.theeyetribe.clientsdk.data.Point2D;

/**
 * Created by sradevski on 10/06/2016.
 */
public class EyeNavGazeData {
    public int state = 0;
    @SerializedName("timestamp")
    public long timestamp = 0;
    @SerializedName("x")
    public double x = 0;
    @SerializedName("y")
    public double y = 0;

    public EyeNavGazeData(double x, double y, long timestamp, int state) {
        this.state = getMappedState(state);
        this.timestamp = timestamp;
        this.x = x;
        this.y = y;
    }

    private int getMappedState(int eyeTribeState){
        //Tracking gaze - check documentation on the masked integer meanings.
        if((eyeTribeState & 0x1) != 0){
            return 1;
        }
        else{
            return 2;
        }
    }
}
