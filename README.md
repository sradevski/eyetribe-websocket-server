## Synopsis

**EyeTribe Web Socket Server** is a Web Socket Server that wraps the EyeTribe SDK and transmits the data through web sockets. It is primarily used for [EyeNav](https://github.com/sradevski/eyenav) although you may use it in your application.

## Usage

You can download an executable if you don't want to compile the project by yourself. The .jar is located in [here](out/artifacts/EyeTribeServer_jar/).
As the server is written in Java, you need to have [Java 1.8](https://java.com/en/download/) or later installed and added to your PATH variable. In order to run the server, open the terminal, navigate to the location where the .jar is located, and run `java -jar EyeTribeServer.jar`, which will start the server on the default port (8887). You can optionally pass a custom port number like `java -jar EyeTribeServer.jar 8886`. Note that the EyeTribe Server must be running before using the EyeTribe Web Socket Server.


If you wish, you could also build the project by yourself. For my convenience I just uploaded the whole IntelliJ IDEA project as I didn't want to bother building it as a maven project. If you are using Eclipse or a different tool, just copy the src folder, the .jar files, and reference them in your project.

## License

This project is under the [MIT Licence](LICENSE)
