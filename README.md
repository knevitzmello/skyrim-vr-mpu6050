# skyrim-vr-mpu6050
Interface for accelerometer and gyroscope made in Arduino originally designed for skyrim, but can be repurposed.

This program allows for mouse control with an Arduino sensor, the MPU6050, instead of the gyroscope and accelerometer of a smartphone. It is meant to be user on top of a VR device. 
Furthermore, there is the possibility of using a variation attached to the hands of the player, simulating the draw of an arrow while using the bow and arrow in the game, or tha spell charging.

A JAVA code receives the USB treated data from the microcontroller and moves the mouse using the robot library.
