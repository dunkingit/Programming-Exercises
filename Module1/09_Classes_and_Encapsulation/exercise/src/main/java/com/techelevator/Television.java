package com.techelevator;

public class Television {
    private boolean isOn = false;
    private int currentChannel = 3;
//    Channels 3 - 18;
    private int currentVolume = 2;
//    Volume 0 - 10;

    public boolean isOn() {
        return this.isOn;
    }

    public int getCurrentChannel() {
        return this.currentChannel;
    }

    public int getCurrentVolume() {
        return this.currentVolume;
    }
    public void turnOff() {
        this.isOn = false;
    }

    public void turnOn() {
        this.isOn = true;
        this.currentChannel = 3;
        this.currentVolume = 2;
    }

    public void changeChannel(int newChannel) {
        if (isOn && newChannel >= 3 && newChannel <= 18) {
            this.currentChannel = newChannel;
        }
    }

    public void channelUp() {
        if (isOn && currentChannel < 18) {
        this.currentChannel++;
        }else{
        this.currentChannel = 3;
        }
    }

    public void channelDown() {
        if (isOn) {
            if (this.currentChannel > 3) {
                this.currentChannel--;
            } else {
                this.currentChannel = 18;
            }
        }
    }

    public void raiseVolume() {
        if (isOn && currentVolume < 10) {
            currentVolume++;
        }
    }

    public void lowerVolume(){
        if (isOn && currentVolume > 0) {
            currentVolume--;
        };
    }
};

