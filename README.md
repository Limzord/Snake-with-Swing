# Snake-with-Swing
simple implementation of Snake in Java with Swing and some advanced features

This project was originally created as a little personal project I would work on during my Java classes in uni to implement the things we learned in a real-world example

This GitHub project mainly exists so I have a reference when creating other Java Projects

controls:
arrow keys to move
escape key to quit the game
enter / return key to pause / unpause the game

features:
arbitrary screen size with field size of 25 x 25
an input buffer is implemented to save one extra input if multiple keys are pressed at the same time
pausing is implemented with the input buffer responding while the game is paused
ability to change game logic speed and frame refresh rate separately through launch arguments
automatic detection of main screen's frame refresh rate
save files to save settings applied through launch arguments and load them at startup

launch arguments:
-fr [] / --framerate [] to set the frame refresh rate
-lr [] / --logicrate [] to set the rate at which the game logic is calculated (also changes the snake's movement speed)
-ee / --epilepsyEnable to enable epilepsy mode
-ed / --epilepsyDisable to disable epilepsy mode