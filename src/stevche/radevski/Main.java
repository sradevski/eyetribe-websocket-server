package stevche.radevski;

public class Main {
    public static void main(String[] args)
    {
        int port = 8887;
        if(args.length == 1){
            try {
                port = Integer.parseInt(args[0]);
            }
            catch (Exception e) {
            }
        }

        try {
            Globs.server = new SocketServer(port);
            Globs.server.start();
        }
        catch(Exception ex){
            System.out.println("Failed to start server on port: " + port);
        }

        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {
                if(Globs.tracker != null) {
                    Globs.tracker.clearListeners();
                    Globs.tracker.deactivate();
                }
                try {
                    Globs.server.stop();
                }
                catch (Exception ex){
                    System.out.println("Failed to successfully terminate server and tracker");
                }
            }
        });
    }
}

