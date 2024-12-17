package org.blacksmith;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import util.Time;

import static java.sql.Types.NULL;
import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11C.*;

public class Window {

    private int width, height;
    private String title;
    private long glfwWindow;

    public float r, g, b, a;
    private  static Window window = null;
    private static Scene currentScene;

    private Window(){
        this.width = 1920;
        this.height = 1080;
        r = 1;
        b = 1;
        g = 1;
        a = 1;
        this.title = "lol";
    }

    public static void changeScene(int newScene) {
        switch (newScene) {
            case 0:
                currentScene = new LevelEditorScene();
                //currentScene.init();
                break;
            case 1:
                currentScene = new LevelScene();
                break;
            default:
                assert false : "Unknown scene '" + newScene + "'";
                break;
        }
    }

    public static Window get(){
        if (Window.window == null) {
            Window.window = new Window();
        }
        return Window.window;
    }
     public void run(){
         System.out.println("Hello lol");

         init();
         loop();

         // Freeing the memory
         glfwFreeCallbacks(glfwWindow);
         glfwDestroyWindow(glfwWindow);

         // Terminate GLFW and the free error callback
         glfwTerminate();
         glfwSetErrorCallback(null).free();
     }

     public void init(){
        // Setup an error callback
         GLFWErrorCallback.createPrint(System.err).set();

         if (!glfwInit()) {
             throw new IllegalStateException("Unable to initialize GLFW");
         }

         // Configure GLFW
         glfwDefaultWindowHints();
         glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
         glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
         glfwWindowHint(GLFW_MAXIMIZED, GLFW_TRUE);

         //Create the window
         glfwWindow = glfwCreateWindow(this.width, this.height, this.title, NULL, NULL);
         if (glfwWindow == NULL) {
             throw new IllegalStateException("Failed to create the window");
         }

         glfwSetKeyCallback(glfwWindow, KeyListener:: keyCallback);
         // Make the OpenGl context current
         glfwMakeContextCurrent(glfwWindow);
         // Enable v-sync
         glfwSwapInterval(1);

         // Make the window visible
         glfwShowWindow(glfwWindow);

         GL.createCapabilities();
         Window.changeScene(0);
     }

    public void loop(){

        float beginTime = Time.getTime();
        float endTime;
        float dt = -1.0f;
        while(!glfwWindowShouldClose(glfwWindow)){
            glfwPollEvents();

            glClearColor(r, g, b, a);
            glClear(GL_COLOR_BUFFER_BIT);

            if(KeyListener.isKeyPressed(GLFW_KEY_I)){
                System.out.println("Key pressed");
            }
            if (dt >= 0) {
                currentScene.update(dt);
            }
            glfwSwapBuffers(glfwWindow);

            endTime = Time.getTime();
            dt = endTime - beginTime;
            beginTime = endTime;
        }
    }
}
