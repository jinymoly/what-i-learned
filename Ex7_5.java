public class Ex7_5 {
    public static void main(String[] args) {
        MyTv3 t = new MyTv3();

        t.setChannel(10);
        System.out.println("CH: " + t.getChannel());
        t.setChannel(20);
        System.out.println("CH: " + t.getChannel());
        t.gotoPrevChannel();
        System.out.println("ch: " + t.getChannel());
        t.gotoPrevChannel();
        System.out.println("ch: " + t.getChannel());
        
    }
}

class MyTv3 {

    boolean isPowerOn;
    int channel;
    int volume;
    int prevCh;

    final int MAX_VOLUME = 100;
    final int MIN_VOLUME = 0;
    final int MAX_CHANNEL = 100;
    final int MIN_CHANNEL = 1;

    public boolean isPowerOn() {
        return isPowerOn;
    }
    public void gotoPrevChannel() {
        setChannel(prevCh);
    }
    public void setPowerOn(boolean isPowerOn) {
        this.isPowerOn = isPowerOn;
    }
    public int getChannel() {
        return channel;
    }
    public void setChannel(int channel) {
        if(!(channel < MIN_CHANNEL || channel >MAX_CHANNEL))
        prevCh = this.channel;
        this.channel = channel;
    }
    public int getVolume() {
        return volume;
    }
    public void setVolume(int volume) {
        this.volume = volume;
    }

    
}
