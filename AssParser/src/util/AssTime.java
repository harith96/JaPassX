package util;

import java.util.regex.Pattern;

public class AssTime {
	public int h;
	public int m;
	public int s;
	public int hs;
	public AssTime(String format) {
		// to do add check
		format = format.replace(".", ":");
		Pattern p = Pattern.compile(":");
		String[] items = p.split(format);
		h = Integer.parseInt(items[0]);
		m = Integer.parseInt(items[1]);
		s = Integer.parseInt(items[2]);
		hs = Integer.parseInt(items[3]);
		
	}
	public AssTime(int ms) {
		int h  = (ms / 3600000) % 10;
		int m  = (ms % 3600000) / 60000;
		int s  = (ms % 60000) / 1000;
		int hs = (ms % 1000) / 10;
	}
	public int toMillis(){
		int ms = hs * 10 + s * 1000 + m * 60000 + h * 3600000;
		return ms;
	}
	public String toString(){
		String ret = String.format("%d:%02d:%02d.%02d", h,m,s,hs);
		return ret;
	}
	public int toFrame(float frameRate){
		float ms = (float)this.toMillis();
		float f = ms*frameRate/1000.0f;
		return (int)f;
	}
}
